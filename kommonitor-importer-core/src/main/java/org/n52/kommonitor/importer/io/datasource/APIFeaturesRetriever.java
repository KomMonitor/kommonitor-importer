package org.n52.kommonitor.importer.io.datasource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.http.HttpHelper;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Retriever for remote datasets that can be requested with a HTTP GET.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class APIFeaturesRetriever extends AbstractDataSourceRetriever<InputStream> {

    private static Logger LOG = LoggerFactory.getLogger(APIFeaturesRetriever.class);

    private static final String TYPE = DataSourceType.TypeEnum.OGCAPI_FEATURES.getValue();
    private static final String PARAM_URL = "url";
    private static final String PARAM_BBOX = "bbox";
    private static final String PARAM_BBOX_TYPE = "bboxType";
    private static final String PARAM_CUSTOM_FILTER = "filter";
    private static final String PARAM_URL_DESC = "An URL that references a dataset. " +
            "The dataset will be retrieved with a HTTP GET request for that URL.";
    private static final String PARAM_BBOX_DESC = "A bounding box for this dataset. Either a literal array of four" +
            " coordinates (bboxType=='ref') , or uuid of spatialUnit used as reference (bboxType=='literal')";

    private static final String PARAM_BBOX_TYPE_DESC = ".";
    private static final String PARAM_CUSTOM_FILTER_DESC = "Additional custom filter conditions. " +
            "Availability in the remote API is not validated and must be checked beforehand!";

    @Autowired
    private SpatialUnitsControllerApi apiClient;
    private final ObjectMapper mapper;

    public APIFeaturesRetriever() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    protected String initType() {
        return TYPE;
    }

    @Override
    protected Set<DataSourceParameter> initSupportedParameters() {
        Set<DataSourceParameter> parameters = new HashSet<>();
        parameters.add(new DataSourceParameter(PARAM_BBOX, PARAM_BBOX_DESC, DataSourceParameter.ParameterTypeValues.ARRAY));
        parameters.add(new DataSourceParameter(PARAM_BBOX_TYPE, PARAM_BBOX_DESC, DataSourceParameter.ParameterTypeValues.ARRAY));
        parameters.add(new DataSourceParameter(PARAM_CUSTOM_FILTER, PARAM_CUSTOM_FILTER_DESC, DataSourceParameter.ParameterTypeValues.STRING, false));
        parameters.add(new DataSourceParameter(PARAM_URL, PARAM_URL_DESC, DataSourceParameter.ParameterTypeValues.STRING));
        return parameters;
    }

    @Override
    public Dataset<InputStream> retrieveDataset(DataSourceDefinitionType datasource) throws DataSourceRetrieverException, ImportParameterException {
        //
        String url = this.getParameterValue(PARAM_URL, datasource.getParameters())
                .orElseThrow(() -> new ImportParameterException("Missing parameter: " + PARAM_URL));

        String bboxType = this.getParameterValue(PARAM_BBOX_TYPE, datasource.getParameters())
                .orElseThrow(() -> new ImportParameterException("Missing parameter: " + PARAM_BBOX_TYPE));

        String bboxValue = this.getParameterValue(PARAM_BBOX, datasource.getParameters())
                .orElseThrow(() -> new ImportParameterException("Missing parameter: " + PARAM_BBOX));

        String filter = this.getParameterValue(PARAM_BBOX, datasource.getParameters())
                .orElse(null);

        try {
            HttpHelper httpHelper = HttpHelper.getBasicHttpHelper();
            FeatureCollection rootCollection = new FeatureCollection();


            String bbox = (bboxType.equals("ref")) ? getBBoxFromSpatialUnit(bboxValue) : bboxValue;

            URIBuilder builder = new URIBuilder(url);
            builder.setParameter("limit", "200")
                    .setParameter("crs", "http://www.opengis.net/def/crs/OGC/1.3/CRS84")
                    .setParameter("f", "json")
                    .setParameter("bbox", bbox);
            HttpGet request = new HttpGet(builder.build());


            boolean hasNextPage = false;
            do {
                byte[] response = httpHelper.executeHttpGetRequest(request);
                ExtendedFeatureCollection page = mapper.readValue(response, ExtendedFeatureCollection.class);
                rootCollection.addAll(page.features());
                if (page.hasNextLink()) {
                    hasNextPage = true;
                    request = new HttpGet(page.getNextLink().href());
                } else {
                    hasNextPage = false;
                }
            }
            while (hasNextPage);

            System.out.println(rootCollection.getFeatures().size());
            return new Dataset<>(new ByteArrayInputStream(mapper.writeValueAsBytes(rootCollection)));
        } catch (IOException | URISyntaxException ex) {
            LOG.debug(String.format("Failed retrieving dataset for datasource: %n%s", datasource), ex);
            throw new DataSourceRetrieverException(String.format("Failed retrieving dataset from URL '%s'", url), ex);
        }
    }

    private String getBBoxFromSpatialUnit(String resourceId) throws IOException {
        String response = apiClient.getAllSpatialUnitFeaturesById(resourceId, null, "strong");

        //TODO: check if we need to do coordinate transformations here?
        FeatureJSON featureJSON = new FeatureJSON();
        ReferencedEnvelope envelope = featureJSON.readFeatureCollection(response).getBounds();

        return String.format("%f,%f,%f,%f", envelope.getMinX(), envelope.getMinY(), envelope.getMaxX(), envelope.getMaxY());
    }

    /**
     * Custom FeatureCollection with support for API defined metadata. Not-needed fields are omitted
     *
     * @param features geojson features
     * @param links    links to further resources
     */
    record ExtendedFeatureCollection(
            @JsonProperty List<Feature> features,
            @JsonProperty List<Link> links
    ) {

        record Link(
                @JsonProperty String href,
                @JsonProperty String rel,
                @JsonProperty String type
        ) {
        }

        boolean hasNextLink() {
            return getNextLink() != null;
        }

        Link getNextLink() {
            if (links.size() > 0) {
                for (Link link : links) {
                    if (Objects.equals(link.rel, "next") && Objects.equals(link.type, "application/geo+json")) {
                        return link;
                    }
                }
            }
            return null;
        }
    }

}

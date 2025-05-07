package org.n52.kommonitor.importer.io.datasource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.geotools.api.feature.simple.SimpleFeature;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.locationtech.jts.geom.Geometry;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.http.HttpHelper;
import org.n52.kommonitor.importer.utils.GeometryHelper;
import org.n52.kommonitor.importer.utils.ImportMonitor;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private static final String PARAM_URL_DESC = "An URL that references a OGC API - Features dataset. " +
            "The dataset will be retrieved with HTTP GET requests for that URL.";
    private static final String PARAM_BBOX_DESC = "A bounding box for this dataset. Either a comma-seperated list of " +
            "four coordinates (bboxType=='literal'), or uuid of spatialUnit used as reference (bboxType=='ref')";

    private static final String PARAM_BBOX_TYPE_DESC = "type of the supplied bbox. Either 'ref' if a reference " +
            "spatialUnit is used, or 'literal' of the bbox is provided verbatim.";
    private static final String PARAM_CUSTOM_FILTER_DESC = "Additional custom filter conditions. " +
            "Availability in the remote API is not validated and must be checked beforehand!";

    private static final Pattern FILTER_PATTERN = Pattern.compile("[\\w\\.]*=[\\w\\.]*");
    private final ObjectMapper mapper;
    private final FeatureJSON featureJSON;
    @Autowired
    private SpatialUnitsApi apiClient;

    @Autowired
    private ImportMonitor monitor;

    private HttpHelper httpHelper;
    @Value("${proxy.host:#{null}}")
    protected String proxyHost;

    @Value("${proxy.port:#{null}}")
    protected Integer proxyPort;

    public APIFeaturesRetriever() throws IOException {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        featureJSON = new FeatureJSON();
    }

    @PostConstruct
    public void postConstruct() throws IOException {
        if (proxyHost != null && proxyPort != null) {
            httpHelper = HttpHelper.getProxyHttpHelper(proxyHost, proxyPort);
        } else {
            httpHelper = HttpHelper.getBasicHttpHelper();
        }
    }

    public APIFeaturesRetriever(HttpHelper httpHelper) throws IOException {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        featureJSON = new FeatureJSON();
        this.httpHelper = httpHelper;
    }

    @Override
    protected String initType() {
        return TYPE;
    }

    @Override
    protected Set<DataSourceParameter> initSupportedParameters() {
        Set<DataSourceParameter> parameters = new HashSet<>();
        parameters.add(new DataSourceParameter(PARAM_BBOX, PARAM_BBOX_DESC, DataSourceParameter.ParameterTypeValues.STRING));
        parameters.add(new DataSourceParameter(PARAM_BBOX_TYPE, PARAM_BBOX_TYPE_DESC, DataSourceParameter.ParameterTypeValues.STRING));
        parameters.add(new DataSourceParameter(PARAM_CUSTOM_FILTER, PARAM_CUSTOM_FILTER_DESC, DataSourceParameter.ParameterTypeValues.STRING, false));
        parameters.add(new DataSourceParameter(PARAM_URL, PARAM_URL_DESC, DataSourceParameter.ParameterTypeValues.STRING));
        return parameters;
    }

    @Override
    public Dataset<InputStream> retrieveDataset(DataSourceDefinitionType datasource) throws DataSourceRetrieverException, ImportParameterException {
        //
        String url = this.getParameterValue(PARAM_URL, datasource.getParameters())
                .map(el -> (el.endsWith("/")) ? el.substring(0, el.length() - 1) : el)
                .map(el -> (el.endsWith("/items")) ? el : el + "/items")
                .orElseThrow(() -> new ImportParameterException("Missing parameter: " + PARAM_URL));

        String bboxType = this.getParameterValue(PARAM_BBOX_TYPE, datasource.getParameters())
                .orElseThrow(() -> new ImportParameterException("Missing parameter: " + PARAM_BBOX_TYPE));

        String bboxValue = this.getParameterValue(PARAM_BBOX, datasource.getParameters())
                .orElseThrow(() -> new ImportParameterException("Missing parameter: " + PARAM_BBOX));

        String filter = this.getParameterValue(PARAM_CUSTOM_FILTER, datasource.getParameters())
                .orElse(null);


        HttpGet request = null;
        try {
            ArrayList<FeatureCollection.Feature> features = new ArrayList<>();

            String bbox;
            Geometry referenceGeometry;

            // Get spatialUnit by reference
            if (bboxType.equals("ref")) {

                // Get spatialUnit from data-management
                byte[] response = apiClient.getAllSpatialUnitFeaturesById(bboxValue,  "original");

                // Extract bbox for first stage filtering (intersection with bbox)
                DefaultFeatureCollection featureCollection = (DefaultFeatureCollection) featureJSON.readFeatureCollection(response);
                ReferencedEnvelope envelope = featureCollection.getBounds();
                bbox = String.format(Locale.US, "%f,%f,%f,%f", envelope.getMinX(), envelope.getMinY(), envelope.getMaxX(), envelope.getMaxY());

                // Extract GeometryCollection for second stage filtering (exact intersection)
                referenceGeometry = GeometryHelper.combineGeometries(featureCollection);
            } else {
                bbox = bboxValue;
                referenceGeometry = null;
            }
            URIBuilder builder = new URIBuilder(url);
            builder.setParameter("limit", "200")
                    // .setParameter("crs", "http://www.opengis.net/def/crs/OGC/1.3/CRS84")
                    .setParameter("f", "json")
                    .setParameter("bbox", bbox);

            if (filter != null) {
                Matcher matcher = FILTER_PATTERN.matcher(filter);
                while (matcher.find()) {
                    String filterExpr = matcher.group();
                    String[] split = filterExpr.split("=");
                    builder.addParameter(split[0], split[1]);
                }
            }
            request = new HttpGet(builder.build());


            boolean hasNextPage = false;
            do {
                byte[] response = httpHelper.executeHttpGetRequest(request);

                // Due to GeoTools decoding issues with additional properties such as links, and issues with inconsistent
                // schemas of enclosed features we use jackson parsing first
                FeatureCollection featureAPIResponse = mapper.readValue(response, FeatureCollection.class);

                Iterator<FeatureCollection.Feature> featureIterator = featureAPIResponse.features.stream().iterator();
                while (featureIterator.hasNext()) {
                    FeatureCollection.Feature feature = featureIterator.next();
                    SimpleFeature simpleFeature = featureJSON.readFeature(mapper.writeValueAsString(feature));

                    if (simpleFeature.getDefaultGeometry() == null) {
                        LOG.error("filtered out feature - no geometry present : {}", feature);
                        continue;
                    }

                    if (GeometryHelper.spatiallyIntersects((Geometry) simpleFeature.getDefaultGeometry(), referenceGeometry)) {
                        features.add(feature);
                    } else {
                        LOG.debug("filtered out feature - geometry does no intersect: {}", feature);
                    }
                }

                // Do again if we have a nextLink
                if (featureAPIResponse.hasNextLink()) {
                    hasNextPage = true;
                    request = new HttpGet(featureAPIResponse.getNextLink().href());
                } else {
                    hasNextPage = false;
                }
            }
            while (hasNextPage);

            FeatureCollection responseCollection = new FeatureCollection(
                    "FeatureCollection",
                    features,
                    null
            );

            return new Dataset<>(new ByteArrayInputStream(mapper.writeValueAsBytes(responseCollection)));
        } catch (IOException | URISyntaxException ex) {
            LOG.debug(String.format("Failed retrieving dataset for datasource: %n%s", datasource), ex);
            String errorUrl = (request != null) ? request.getAuthority() + request.getRequestUri() : url;
            monitor.addFailedConversion("Failed retrieving dataset for datasource", ex.getLocalizedMessage());
            throw new DataSourceRetrieverException(String.format("Failed retrieving dataset from URL '%s'", errorUrl), ex);
        }
    }

    /**
     * Custom FeatureCollection with support for API defined metadata. Not-needed fields are omitted
     *
     * @param links links to further resources
     */
    private record FeatureCollection(
            String type,
            @JsonProperty List<Feature> features,
            @JsonProperty List<Link> links
    ) {

        record Feature(
                @JsonProperty String type,
                @JsonProperty String id,
                @JsonProperty Object geometry,
                @JsonProperty Object properties
        ) {
        }

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

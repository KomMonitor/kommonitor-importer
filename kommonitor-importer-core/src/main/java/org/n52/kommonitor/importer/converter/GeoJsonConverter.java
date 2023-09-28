package org.n52.kommonitor.importer.converter;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.referencing.CRS;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.DecodingException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.opengis.feature.simple.SimpleFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Converter for GeoJson datasets. Parses a GeoJson document as {@link org.geotools.feature.FeatureCollection}
 * and converts it into KomMonitor resources.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class GeoJsonConverter extends AbstractConverter {
    private static final String NAME = "GeoJSON";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String PARAM_CRS = "CRS";
    private static final String PARAM_CRS_DESC = "Angabe des Koordinatenreferenzsystems als EPSG-Code (z.B. EPSG:4326)";

    private FeatureDecoder featureDecoder;
    private ObjectMapper mapper;
    private FeatureJSON featureJson;

    @Autowired
    public GeoJsonConverter(FeatureDecoder featureDecoder) {
        this.featureDecoder = featureDecoder;
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        featureJson = new FeatureJSON();
        featureJson.setEncodeNullValues(true);
    }

    @Override
    public String initName() {
        return NAME;
    }

    @Override
    public Set<String> initSupportedMimeType() {
        Set<String> mimeTypes = new HashSet<>();
        mimeTypes.add("application/geo+json");
        return mimeTypes;
    }

    @Override
    public Set<String> initSupportedSchemas() {
        return null;
    }

    @Override
    public Set<String> initSupportedEncoding() {
        Set<String> encodings = new HashSet<>();
        encodings.add(DEFAULT_ENCODING);

        return encodings;
    }

    @Override
    public String getDefaultEncoding() {
        return DEFAULT_ENCODING;
    }
    @Override
    public Set<ConverterParameter> initConverterParameters() {
        Set<ConverterParameter> params = new HashSet();
        params.add(createCrsParameter());

        return params;
    }

    @Override
    public List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition,
                                                         Dataset dataset,
                                                         SpatialResourcePropertyMappingType propertyMapping)
            throws ConverterException, ImportParameterException {
        InputStream input = getInputStream(converterDefinition, dataset);
        try {
            return convertSpatialResources(converterDefinition, input, propertyMapping);
        } catch (IOException ex) {
            throw new ConverterException("Error while parsing dataset.", ex);
        }
    }

    private List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition,
                                                          InputStream dataset,
                                                          SpatialResourcePropertyMappingType propertyMapping)
            throws ImportParameterException, IOException {

        Optional<String> crsOpt = this.getParameterValue(PARAM_CRS, converterDefinition.getParameters());

        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_CRS);
        }

        List<SpatialResource> spatialResources = new ArrayList<>();

        // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        FeatureCollection featureCollection = mapper.readValue(dataset, FeatureCollection.class);
        Iterator<Feature> featureIterator = featureCollection.iterator();

        // Each SimpleFeature will be then read by the use of GeoTools and handled separately, in order to avoid
        // parsing issues.
        while (featureIterator.hasNext()) {
            Feature feature = featureIterator.next();
            SimpleFeature simpleFeature = featureJson.readFeature(mapper.writeValueAsString(feature));
            try {
                spatialResources.add(featureDecoder.decodeFeatureToSpatialResource(simpleFeature, propertyMapping, CRS.decode(crsOpt.get())));
            } catch (DecodingException ex) {
                LOG.error(String.format("Decoding failed for feature %s", simpleFeature.getID()));
                LOG.debug(String.format("Failed feature decoding attributes: %s", simpleFeature.getAttributes()));
                featureDecoder.addMonitoringMessage(propertyMapping.getIdentifierProperty(), simpleFeature, ex.getMessage());
            } catch (Exception ex) {
                throw new ImportParameterException(String.format("Invalid CRS parameter '%s'.", crsOpt.get()), ex);
            }
        }

        return spatialResources;
    }

    @Override
    public List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition,
                                                  Dataset dataset,
                                                  IndicatorPropertyMappingType propertyMapping)
            throws ConverterException, ImportParameterException {
        InputStream input = getInputStream(converterDefinition, dataset);
        try {
            return convertIndicators(input, propertyMapping);
        } catch (IOException ex) {
            throw new ConverterException("Error while parsing dataset.", ex);
        }
    }

    private List<IndicatorValue> convertIndicators(InputStream dataset,
                                                   IndicatorPropertyMappingType propertyMapping)
            throws IOException {
        List<IndicatorValue> indicatorValueList = new ArrayList<>();

        // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        FeatureCollection featureCollection = mapper.readValue(dataset, FeatureCollection.class);
        Iterator<Feature> featureIterator = featureCollection.iterator();

        // Each SimpleFeature will be then read by the use of GeoTools and handled separately, in order to avoid
        // parsing issues.
        while (featureIterator.hasNext()) {
            Feature feature = featureIterator.next();
            SimpleFeature simpleFeature = featureJson.readFeature(mapper.writeValueAsString(feature));
            try {
                indicatorValueList.add(featureDecoder.decodeFeatureToIndicatorValue(simpleFeature, propertyMapping));
            } catch (DecodingException ex) {
                LOG.error(String.format("Decoding failed for feature %s", simpleFeature.getID()));
                LOG.debug(String.format("Failed feature decoding attributes: %s", simpleFeature.getAttributes()));
                featureDecoder.addMonitoringMessage(propertyMapping.getSpatialReferenceKeyProperty(), simpleFeature, ex.getMessage());
            }
        }
        // Due to the GeoTools decoding issues, the grouping of Features with same ID but different timestamps
        // can't be performed by the FeatureDecoder. Therefore, the grouping has to be done for IndicatorValues
        // in the following.
        if (propertyMapping.getTimeseriesMappings().size() == 1) {
            indicatorValueList = groupIndicatorValues(indicatorValueList);
        }
        return indicatorValueList;
    }

    private ConverterParameter createCrsParameter() {
        return new ConverterParameter(PARAM_CRS, PARAM_CRS_DESC, ConverterParameter.ParameterTypeValues.STRING, true);
    }

}

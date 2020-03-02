package org.n52.kommonitor.importer.decoder;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.locationtech.jts.geom.Geometry;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.entities.TimeseriesValue;
import org.n52.kommonitor.importer.exceptions.DecodingException;
import org.n52.kommonitor.importer.utils.ImportMonitor;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.n52.kommonitor.importer.utils.GeometryHelper;
import org.n52.kommonitor.models.TimeseriesMappingType;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.TransformException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Helper class for decoding {@link SimpleFeature} instances into {@link SpatialResource}
 * and {@link IndicatorValue} entities
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class FeatureDecoder {

    private static final String RANDOM_FEATURE_ID_PREFIX = "random_feature_id";
    private static final Logger LOG = LoggerFactory.getLogger(FeatureDecoder.class);

    private GeometryHelper geomHelper;

    @Autowired
    private ImportMonitor monitor;

    @Autowired
    public FeatureDecoder(GeometryHelper geometryHelper, ImportMonitor monitor) {
        this.geomHelper = geometryHelper;
        this.monitor = monitor;
    }

    /**
     * Decode a {@link SimpleFeatureCollection} as {@link List<SpatialResource>} by mapping certain properties
     * and the geometry
     *
     * @param featureCollection   {@link SimpleFeatureCollection} to decode
     * @param propertyMappingType definition of property mappings
     * @return {@link List<SpatialResource>}
     */
    public List<SpatialResource> decodeFeatureCollectionToSpatialResources(SimpleFeatureCollection featureCollection,
                                                                           SpatialResourcePropertyMappingType propertyMappingType,
                                                                           CoordinateReferenceSystem sourceCrs) {
        List<SpatialResource> result = new ArrayList<>();
        SimpleFeatureIterator iterator = featureCollection.features();
        while (iterator.hasNext()) {
            SimpleFeature feature = iterator.next();
            try {
                result.add(decodeFeatureToSpatialResource(feature, propertyMappingType, sourceCrs));
            } catch (DecodingException e) {
                LOG.warn("Could not decode feature {}. Cause: {}.", feature.getID(), e.getMessage());
                addMonitoringMessage(propertyMappingType.getIdentifierProperty(), feature, e.getMessage());
            }
        }
        return result;
    }

    /**
     * Decode a {@link SimpleFeature} as {@link SpatialResource} by mapping certain properties
     * and the geometry
     *
     * @param feature         {@link SimpleFeature} to decode
     * @param propertyMapping definition of property mappings
     * @return {@link SpatialResource}
     * @throws DecodingException if a certain property could not be decoded from the {@link SimpleFeature}
     */
    public SpatialResource decodeFeatureToSpatialResource(SimpleFeature feature,
                                                          SpatialResourcePropertyMappingType propertyMapping,
                                                          CoordinateReferenceSystem sourceCrs) throws DecodingException {
        String id = getPropertyValueAsString(feature, propertyMapping.getIdentifierProperty());
        String name = getPropertyValueAsString(feature, propertyMapping.getNameProperty());
        String arisenFrom = propertyMapping.getArisenFromProperty() == null ? null :
                getPropertyValueAsString(feature, propertyMapping.getArisenFromProperty());
        LocalDate startDate = propertyMapping.getValidStartDateProperty() == null ? null :
                getPropertyValueAsDate(feature, propertyMapping.getValidStartDateProperty());
        LocalDate endDate = propertyMapping.getValidEndDateProperty() == null ? null :
                getPropertyValueAsDate(feature, propertyMapping.getValidEndDateProperty());
        Geometry geom = null;
        try {
            geom = geomHelper.reprojectGeomToWgs84(getGeometry(feature, feature.getFeatureType()), sourceCrs);
        } catch (FactoryException | TransformException ex) {
            throw new DecodingException(String.format("Could not reproject feature geometries to CRS: %s", GeometryHelper.EPSG_4326), ex);
        }

        return new SpatialResource(id, name, geom, arisenFrom, startDate, endDate);
    }

    /**
     * Decode a {@link SimpleFeatureCollection} as {@link List<IndicatorValue>} by mapping certain properties.
     *
     * @param featureCollection {@link SimpleFeatureCollection} to decode
     * @param propertyMapping   definition of property mappings
     * @return the decoded {@link List<IndicatorValue>}
     * @throws IOException if decoding fails
     */
    public List<IndicatorValue> decodeFeatureCollectionToIndicatorValues(SimpleFeatureCollection featureCollection,
                                                                         IndicatorPropertyMappingType propertyMapping) throws IOException {
        //TODO implement a more dedicated solution for differentiate
        // various options of how TimeSeriesValues are encoded
        // as feature properties
        List<IndicatorValue> result = new ArrayList<>();
        // if there is only a single property mapping, the FeatureCollection may contain only single TimeseriesValues
        // or the FeatureCollection may contain the same SimpleFeature multiple times and each of these Features
        // contains different TimeseriesValues that all belongs to a common Indicator
        if (propertyMapping.getTimeseriesMappings().size() == 1) {
            return decodeFeatureCollectionToIndicatorValues(featureCollection,
                    propertyMapping.getSpatialReferenceKeyProperty(), propertyMapping.getTimeseriesMappings().get(0));
        }
        // if there are multiple property mappings, each SimpleFeature of the SimpleFeatureCollection contains
        // all TimeSeriesValues of a common Indicator on its own within its properties
        else {
            SimpleFeatureIterator iterator = featureCollection.features();
            while (iterator.hasNext()) {
                SimpleFeature feature = iterator.next();
                try {
                    IndicatorValue indicator = decodeFeatureToIndicatorValue(feature, propertyMapping);
                    result.add(indicator);
                } catch (DecodingException e) {
                    LOG.warn("Could not decode feature {}. Cause: {}.", feature.getID(), e.getMessage());
                    addMonitoringMessage(propertyMapping.getSpatialReferenceKeyProperty(), feature, e.getMessage());
                }
            }
        }

        return result;
    }

    /**
     * Decode a {@link SimpleFeature} as {@link IndicatorValue} by mapping certain feature properties
     *
     * @param feature         the {@link SimpleFeature} to decode
     * @param propertyMapping definition of property mappings
     * @return the decoded {@link IndicatorValue}
     * @throws DecodingException if a certain property could not be decoded from the {@link SimpleFeature}
     */
    public IndicatorValue decodeFeatureToIndicatorValue(SimpleFeature feature, IndicatorPropertyMappingType propertyMapping) throws DecodingException {
        List<TimeseriesValue> timeSeriesValues = new ArrayList<>();
        propertyMapping.getTimeseriesMappings().forEach(pM -> {
            try {
                timeSeriesValues.add(decodeFeatureToTimeseriesValue(feature, pM));
            } catch (DecodingException e) {
                LOG.warn("Could not decode time series value for feature {}. Cause: {}.", feature.getID(), e.getMessage());
                addMonitoringMessage(propertyMapping.getSpatialReferenceKeyProperty(), feature, e.getMessage());

            }
        });
        return new IndicatorValue(getPropertyValueAsString(feature,
                propertyMapping.getSpatialReferenceKeyProperty()), timeSeriesValues);
    }

    /**
     * Decode a {@link  List<SimpleFeature>} as {@link IndicatorValue} by mapping certain feature properties.
     * This methods assumes, that each {@link SimpleFeature} ist related to the same spatial resource but contains
     * a different indicator value will be used as the indicator value for one timestamp.
     *
     * @param spatialRefKey         the spatial reference key for the {@link IndicatorValue} to which all the
     *                              {@link SimpleFeature} entities belong
     * @param features              {@link  List<SimpleFeature>} to decode
     * @param timeSeriesMappingType definition of property mappings
     * @return {@link IndicatorValue}
     */
    IndicatorValue decodeFeaturesToIndicatorValues(String spatialRefKey, List<SimpleFeature> features, TimeseriesMappingType timeSeriesMappingType) {
        List<TimeseriesValue> timeSeries = new ArrayList<>();
        features.forEach(f -> {
            try {
                timeSeries.add(decodeFeatureToTimeseriesValue(f, timeSeriesMappingType));
            } catch (DecodingException e) {
                LOG.warn("Could not decode time series value for feature {}. Cause: {}.", f.getID(), e.getMessage());
                monitor.addFailedConversion(spatialRefKey, e.getMessage());
            }
        });

        return new IndicatorValue(spatialRefKey, timeSeries);
    }

    /**
     * Decode a {@link SimpleFeature} as {@link TimeseriesValue} by mapping certain feature properties
     *
     * @param feature             the {@link SimpleFeature} to decode
     * @param propertyMappingType definition of property mappings
     * @return the decoded {@link TimeseriesValue}
     * @throws DecodingException if a certain property could not be decoded from the {@link SimpleFeature}
     */
    TimeseriesValue decodeFeatureToTimeseriesValue(SimpleFeature feature, TimeseriesMappingType propertyMappingType) throws DecodingException {
        float indicatorValue = getPropertyValueAsFloat(feature, propertyMappingType.getIndicatorValueProperty());
        LocalDate timeStamp = null;
        if (propertyMappingType.getTimestampProperty() == null || propertyMappingType.getTimestampProperty().isEmpty()) {
            timeStamp = propertyMappingType.getTimestamp();
        } else {
            timeStamp = getPropertyValueAsDate(feature, propertyMappingType.getTimestampProperty());
        }
        return new TimeseriesValue(indicatorValue, timeStamp);
    }

    /**
     * Decode a {@link SimpleFeatureCollection} as {@link List<IndicatorValue>} by mapping certain properties.
     * Note, that this method should be used if the FeatureCollection contains only a single TimeseriesValues
     * or the FeatureCollection contains the same SimpleFeature multiple times and each of these Features
     * contains different TimeseriesValues that all belongs to a common Indicator
     *
     * @param featureCollection    {@link SimpleFeatureCollection} to decode
     * @param referenceKeyProperty the property that contains the key tha references a spatial resource an indicator is related to
     * @param timeseriesMapping    definition of property mappings for timeseries
     * @return {@link List<IndicatorValue>}
     */
    private List<IndicatorValue> decodeFeatureCollectionToIndicatorValues(SimpleFeatureCollection featureCollection,
                                                                          String referenceKeyProperty,
                                                                          TimeseriesMappingType timeseriesMapping) throws IOException {
        List<IndicatorValue> result = new ArrayList<>();
        Map<String, List<SimpleFeature>> groupedFeatures = groupFeatureCollection(featureCollection, referenceKeyProperty);
        groupedFeatures.forEach((k, v) -> {
            result.add(decodeFeaturesToIndicatorValues(k, v, timeseriesMapping));
        });

        return result;
    }

    /**
     * Groups a {@link SimpleFeatureCollection} by common values of a spatial reference key property that
     * is defined within a {@link IndicatorPropertyMappingType}.
     * The grouping results in a {@link Map<String, List<SimpleFeature>>} with the distinct spatial reference key values
     * as map keys and the {@link SimpleFeature} entities belonging to the spatial reference keys value as values.
     *
     * @param featureCollection    the {@link SimpleFeatureCollection} to group
     * @param referenceKeyProperty property that contains the reference key which will be used for grouping features
     * @return a {@link Map} that contains the {@link SimpleFeature} entities grouped by its spatial reference key values
     */
    Map<String, List<SimpleFeature>> groupFeatureCollection(SimpleFeatureCollection featureCollection, String referenceKeyProperty) {
        Map<String, List<SimpleFeature>> groupedFeatures = new HashMap();
        SimpleFeatureIterator iterator = featureCollection.features();
        while (iterator.hasNext()) {
            SimpleFeature feature = iterator.next();
            try {
                String refKey = getPropertyValueAsString(feature, referenceKeyProperty);
                if (groupedFeatures.containsKey(refKey)) {
                    groupedFeatures.get(refKey).add(feature);
                } else {
                    List<SimpleFeature> featureList = new ArrayList<>();
                    featureList.add(feature);
                    groupedFeatures.put(refKey, featureList);
                }
            } catch (DecodingException e) {
                LOG.warn("Could not decode feature {}. Cause: {}.", feature.getID(), e.getMessage());
                addMonitoringMessage(referenceKeyProperty, feature, e.getMessage());
            }

        }
        return groupedFeatures;
    }

    /**
     * Gets the {@link Geometry} of a feature within WGS 84 coordinate reference system
     *
     * @param feature           the {@link SimpleFeature} to fetch the geometry from
     * @param simpleFeatureType {@link SimpleFeatureType} associated to  the {@link SimpleFeature}
     * @return {@link Geometry} of the feature
     */
    private Geometry getGeometry(SimpleFeature feature, SimpleFeatureType simpleFeatureType) throws DecodingException {
        String geomName = simpleFeatureType.getGeometryDescriptor().getLocalName();
        Geometry geom = (Geometry) feature.getAttribute(geomName);
        return geom;
    }


    /**
     * Gets the value from a {@link SimpleFeature} property as String
     *
     * @param feature      the {@link SimpleFeature} to fetch the property from
     * @param propertyName name of the property to fetch
     * @return the value of the fetched feature property as String
     * @throws DecodingException if the property value could not be parsed as String
     */
    String getPropertyValueAsString(SimpleFeature feature, String propertyName) throws DecodingException {
        Object propertyValue = getPropertyValue(feature, propertyName);
        return String.valueOf(propertyValue);
    }

    /**
     * Gets the value from a {@link SimpleFeature} property as Float
     *
     * @param feature      the {@link SimpleFeature} to fetch the property from
     * @param propertyName name of the property to fetch
     * @return the value of the fetched feature property as Float
     * @throws DecodingException if the property value could not be parsed as Float
     */
    float getPropertyValueAsFloat(SimpleFeature feature, String propertyName) throws DecodingException {
        Object propertyValue = getPropertyValue(feature, propertyName);
        if (propertyValue instanceof Float) {
            return (Float) propertyValue;
        } else if (propertyValue instanceof String) {
            try {
                return Float.parseFloat((String) propertyValue);
            } catch (NumberFormatException ex) {
                throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, Float.class.getName()));
            }

        } else if (propertyValue instanceof Double) {
            return ((Double) propertyValue).floatValue();
        } else if (propertyValue instanceof Integer) {
            return ((Integer) propertyValue).floatValue();
        } else {
            throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, Float.class.getName()));
        }
    }

    /**
     * * Gets the value from a {@link SimpleFeature} property as {@link LocalDate}
     *
     * @param feature      the {@link SimpleFeature} to fetch the property from
     * @param propertyName name of the property to fetch
     * @return the value of the fetched feature property as Date
     * @throws DecodingException if the property value could not be parsed as {@link LocalDate}
     */
    LocalDate getPropertyValueAsDate(SimpleFeature feature, String propertyName) throws DecodingException {
        Object propertyValue = getPropertyValue(feature, propertyName);
        LocalDate date = null;
        if (propertyValue instanceof String) {
            try {
                date = LocalDate.parse((String) propertyValue);
            } catch (DateTimeParseException ex) {
                throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, LocalDate.class.getName()), ex);
            }
        } else if (propertyValue instanceof Date) {
            Instant instant = ((Date) propertyValue).toInstant();
            date = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, LocalDate.class.getName()));
        }
        return date;
    }

    Object getPropertyValue(SimpleFeature feature, String propertyName) throws DecodingException {
        Object propertyValue = feature.getAttribute(propertyName);
        if (propertyValue == null) {
            throw new DecodingException(String.format("Property '%s' does not exist.", propertyName));
        }
        return propertyValue;
    }

    public void addMonitoringMessage(String keyProperty, SimpleFeature feature, String message) {
        Object id = feature.getAttribute(keyProperty);
        if (id == null) {
            id = String.join(":", RANDOM_FEATURE_ID_PREFIX, UUID.randomUUID().toString());
        }
        monitor.addFailedConversion(String.valueOf(id), message);
    }


}

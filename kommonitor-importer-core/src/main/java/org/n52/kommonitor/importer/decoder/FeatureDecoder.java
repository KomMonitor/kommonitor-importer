package org.n52.kommonitor.importer.decoder;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.locationtech.jts.geom.Geometry;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.entities.TimeseriesValue;
import org.n52.kommonitor.importer.exceptions.DecodingException;
import org.n52.kommonitor.importer.utils.GeometryHelper;
import org.n52.kommonitor.importer.utils.ImportMonitor;
import org.n52.kommonitor.models.AttributeMappingType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.n52.kommonitor.models.TimeseriesMappingType;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.GeometryDescriptor;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.TransformException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.DateTimeException;
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
        Geometry geom;
        try {
            geom = geomHelper.reprojectGeomToWgs84(getGeometry(feature, feature.getFeatureType()), sourceCrs);
        } catch (FactoryException | TransformException ex) {
            throw new DecodingException(String.format("Could not reproject feature geometries to CRS: %s", GeometryHelper.EPSG_4326), ex);
        }

        Map attributes;
        if (propertyMapping.isKeepAttributes()) {
            attributes = mappAllAttributes(feature);
        } else {
            attributes = mapAttributes(feature, propertyMapping.getAttributes(), id, propertyMapping.isKeepMissingOrNullValueAttributes());
        }

        return new SpatialResource(id, name, geom, arisenFrom, startDate, endDate, attributes);
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
            return decodeFeatureCollectionToIndicatorValues(
                    featureCollection,
                    propertyMapping.getSpatialReferenceKeyProperty(),
                    propertyMapping.getTimeseriesMappings().get(0),
                    propertyMapping.isKeepMissingOrNullValueIndicator()
                    );
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
                timeSeriesValues.add(decodeFeatureToTimeseriesValue(feature, pM, propertyMapping.isKeepMissingOrNullValueIndicator()));
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
    IndicatorValue decodeFeaturesToIndicatorValues(String spatialRefKey, List<SimpleFeature> features, TimeseriesMappingType timeSeriesMappingType, boolean keepMissingOrNullValueProperties) {
        List<TimeseriesValue> timeSeries = new ArrayList<>();
        features.forEach(f -> {
            try {
                TimeseriesValue value = decodeFeatureToTimeseriesValue(f, timeSeriesMappingType, keepMissingOrNullValueProperties);
                if (value == null) {
                    monitor.addFailedConversion(
                            spatialRefKey,
                            String.format("Indicator value property %s does not exist or has NULL value but was kept.",
                                    timeSeriesMappingType.getIndicatorValueProperty()));
                }
                timeSeries.add(value);
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
     * @return the decoded {@link TimeseriesValue} or NULL if the indicator value does not exist and missing or NULL value
     * properties should be kept
     * @throws DecodingException if a certain property could not be decoded from the {@link SimpleFeature}
     */
    TimeseriesValue decodeFeatureToTimeseriesValue(SimpleFeature feature, TimeseriesMappingType propertyMappingType, boolean keepMissingOrNullValueProperties) throws DecodingException {
        Property indicatorValueProperty = getProperty(feature, propertyMappingType.getIndicatorValueProperty());
        if (keepMissingOrNullValueProperties && (indicatorValueProperty == null || indicatorValueProperty.getValue() == null)) {
            return null;
        }
        float indicatorValue = getPropertyValueAsFloat(indicatorValueProperty, propertyMappingType.getIndicatorValueProperty());
        LocalDate timeStamp;
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
                                                                          TimeseriesMappingType timeseriesMapping,
                                                                          boolean keepMissingOrNullValueProperties) {
        List<IndicatorValue> result = new ArrayList<>();
        Map<String, List<SimpleFeature>> groupedFeatures = groupFeatureCollection(featureCollection, referenceKeyProperty);
        groupedFeatures.forEach((k, v) -> result.add(decodeFeaturesToIndicatorValues(k, v, timeseriesMapping, keepMissingOrNullValueProperties)));

        return result;
    }

    /**
     * Groups a {@link SimpleFeatureCollection} by common values of a spatial reference key property that
     * is defined within a {@link IndicatorPropertyMappingType}.
     * The grouping results in a {@link Map<String, List>SimpleFeature>>} with the distinct spatial reference key values
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
     * Maps additional attributes from a {@link SimpleFeature}
     *
     * @param feature           the {@link SimpleFeature} to map the attributes from
     * @param attributeMappings attributes mapping definitions
     * @return mapped attributes if there are any attribute mapping definitions anf null if the attribute mappings are empty
     */
    Map mapAttributes(SimpleFeature feature, List<AttributeMappingType> attributeMappings, String id, boolean keepMissingOrNullValues) {
        if (attributeMappings == null || attributeMappings.isEmpty()) {
            return null;
        }
        Map attributes = new HashMap();

        attributeMappings.forEach(a -> {
            try {
                Object propertyValue = null;
                if (keepMissingOrNullValues) {
                    Property property = getProperty(feature, a.getName());
                    if (property == null || property.getValue() == null) {
                        monitor.addFailedConversion(id, String.format("Property %s does not exist or has NULL value but was kept.", a.getName()));
                    } else {
                        propertyValue = getAttributeValue(feature, a);
                    }
                } else {
                    propertyValue = getAttributeValue(feature, a);
                }
                if (a.getMappingName() != null && !a.getMappingName().isEmpty()) {
                    attributes.put(a.getMappingName(), propertyValue);
                } else {
                    attributes.put(a.getName(), propertyValue);
                }
            } catch (DecodingException e) {
                LOG.warn("Could not decode time series value for feature {}. Cause: {}.", id, e.getMessage());
                monitor.addFailedConversion(id, e.getMessage());
            }
        });
        return attributes;
    }

    /**
     * Maps all attributes but the geometry property from a {@link SimpleFeature}. The attribute names will be kept.
     *
     * @param feature the {@link SimpleFeature} to map the attributes from
     * @return an attribute map whose keys are formed by the property names and the values by the property values from
     * the origin feature's property list
     */
    Map mappAllAttributes(SimpleFeature feature) {
        Map attributes = new HashMap();
        feature.getProperties().forEach(p -> {
            if (feature.getDefaultGeometryProperty() == null) {
                attributes.put(p.getName().getLocalPart(), p.getValue());
            } else if (!p.getName().getURI().equals(feature.getDefaultGeometryProperty().getName().getURI())) {
                attributes.put(p.getName().getLocalPart(), p.getValue());
            }
        });
        return attributes;
    }

    /**
     * Get the attribute value of a {@link SimpleFeature} from an {@link AttributeMappingType}
     *
     * @param feature          the {@link SimpleFeature} to fetch the attribute value from
     * @param attributeMapping the attribute mapping definition
     * @return the attribute value depending on the type defined in the attribute mapping
     * @throws DecodingException
     */
    Object getAttributeValue(SimpleFeature feature, AttributeMappingType attributeMapping) throws DecodingException {
        switch (attributeMapping.getType()) {
            case INTEGER:
                return getPropertyValueAsInteger(feature, attributeMapping.getName());
            case FLOAT:
                return getPropertyValueAsFloat(feature, attributeMapping.getName());
            case DATE:
                return getPropertyValueAsDate(feature, attributeMapping.getName());
            default:
                return getPropertyValueAsString(feature, attributeMapping.getName());
        }
    }

    /**
     * Gets the {@link Geometry} of a feature within WGS 84 coordinate reference system
     *
     * @param feature           the {@link SimpleFeature} to fetch the geometry from
     * @param simpleFeatureType {@link SimpleFeatureType} associated to  the {@link SimpleFeature}
     * @return {@link Geometry} of the feature
     * @throws DecodingException
     */
    Geometry getGeometry(SimpleFeature feature, SimpleFeatureType simpleFeatureType) throws DecodingException {
        GeometryDescriptor geomDesc = simpleFeatureType.getGeometryDescriptor();
        if (geomDesc == null) {
            throw new DecodingException("Could not decode geometry property.");
        }
        return (Geometry) feature.getAttribute(geomDesc.getName());
    }

    /**
     * Gets the value from a {@link Property} as String
     *
     * @param property the {@link Property} to fetch the value from
     * @return the value of the fetched feature property as String
     */
    String getPropertyValueAsString(Property property) {
        return String.valueOf(property.getValue());
    }

    /**
     * Gets the value from a {@link SimpleFeature} property as String
     *
     * @param feature      the {@link SimpleFeature} to fetch the property from
     * @param propertyName name of the property
     * @return the value of the fetched feature property as String
     * @throws DecodingException if the property value could not be parsed as String
     */
    String getPropertyValueAsString(SimpleFeature feature, String propertyName) throws DecodingException {
        Object propertyValue = getPropertyValue(feature, propertyName);
        return String.valueOf(propertyValue);
    }

    /**
     * Gets the value from a {@link Property} as Integer
     *
     * @param property     the {@link Property} to fetch the value from
     * @param propertyName name of the property
     * @return the value of the fetched feature property as Integer
     * @throws DecodingException if the property value could not be parsed as Integer
     */
    int getPropertyValueAsInteger(Property property, String propertyName) throws DecodingException {
        try {
            return parsePropertyValueAsInteger(property.getValue());
        } catch (NumberFormatException ex) {
            throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, Integer.class.getName()));
        }
    }

    /**
     * Gets the value from a {@link SimpleFeature} property as Integer
     *
     * @param feature      the {@link SimpleFeature} to fetch the property from
     * @param propertyName name of the property
     * @return the value of the fetched feature property as Integer
     * @throws DecodingException if the property value could not be parsed as Integer
     */
    int getPropertyValueAsInteger(SimpleFeature feature, String propertyName) throws DecodingException {
        Object propertyValue = getPropertyValue(feature, propertyName);
        try {
            return parsePropertyValueAsInteger(propertyValue);
        } catch (NumberFormatException ex) {
            throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, Integer.class.getName()));
        }
    }

    private int parsePropertyValueAsInteger(Object value) throws NumberFormatException {
        if (value instanceof Integer) {
            return (Integer) value;
        } else if (value instanceof Long) {
            return ((Long) value).intValue();
        } else if (value instanceof String) {
            return Integer.parseInt((String) value);
        } else {
            throw new NumberFormatException(String.format("No valid Integer value: %s", value));
        }
    }

    /**
     * Gets the value from a {@link Property} as Float
     *
     * @param property     the {@link Property} to fetch the value from
     * @param propertyName name of the property
     * @return the value of the fetched feature property as Float
     * @throws DecodingException if the property value could not be parsed as Float
     */
    float getPropertyValueAsFloat(Property property, String propertyName) throws DecodingException {
        try {
            return parsePropertyValueAsFloat(property.getValue());
        } catch (NumberFormatException ex) {
            throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, Float.class.getName()));
        }
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
        try {
            return parsePropertyValueAsFloat(propertyValue);
        } catch (NumberFormatException ex) {
            throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, Float.class.getName()));
        }
    }

    private float parsePropertyValueAsFloat(Object value) throws NumberFormatException {
        if (value instanceof Float) {
            return (Float) value;
        } else if (value instanceof String) {
            return Float.parseFloat((String) value);
        } else if (value instanceof Double) {
            return ((Double) value).floatValue();
        } else if (value instanceof Integer) {
            return ((Integer) value).floatValue();
        } else if (value instanceof Long) {
            return ((Long) value).floatValue();
        } else {
            throw new NumberFormatException(String.format("No valid Float value: %s", value));
        }
    }

    /**
     * * Gets the value from a {@link Property} as {@link LocalDate}
     *
     * @param property     the {@link Property} to fetch the value from
     * @param propertyName name of the property
     * @return the value of the fetched feature property as {@link LocalDate}
     * @throws DecodingException if the property value could not be parsed as {@link LocalDate}
     */
    LocalDate getPropertyValueAsDate(Property property, String propertyName) throws DecodingException {
        try {
            return parsePropertyValueAsDate(property.getValue());
        } catch (DateTimeParseException ex) {
            throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, LocalDate.class.getName()), ex);
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
        try {
            return parsePropertyValueAsDate(propertyValue);
        } catch (DateTimeParseException ex) {
            throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, LocalDate.class.getName()), ex);
        }
    }

    private LocalDate parsePropertyValueAsDate(Object value) throws DateTimeParseException {
        LocalDate date;
        if (value instanceof String) {
            date = LocalDate.parse((String) value);
        } else if (value instanceof Date) {
            Instant instant = ((Date) value).toInstant();
            date = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            throw new DateTimeParseException(String.format("No valid LocalDate value: %s", value), "", 0);
        }
        return date;
    }

    Property getProperty(SimpleFeature feature, String propertyName) throws DecodingException {
        Property property = feature.getProperty(propertyName);
        if (property == null) {
            throw new DecodingException(String.format("Property '%s' does not exist.", propertyName));
        }
        return property;
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

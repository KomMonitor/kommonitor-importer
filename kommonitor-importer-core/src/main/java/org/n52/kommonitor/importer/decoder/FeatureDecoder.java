package org.n52.kommonitor.importer.decoder;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.locationtech.jts.geom.Geometry;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.entities.TimeseriesValue;
import org.n52.kommonitor.importer.exceptions.DecodingException;
import org.n52.kommonitor.importer.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.importer.models.SpatialResourcePropertyMappingType;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(FeatureDecoder.class);
    public static final String EPSG_4326 = "EPSG:4326";


    /**
     * Decode a {@link SimpleFeature} as {@link SpatialResource} by mapping certain properties
     * and the geometry
     *
     * @param feature         {@link SimpleFeature} to decode
     * @param propertyMapping definition of property mappings
     * @return {@link SpatialResource}
     * @throws DecodingException if a certain property could not be decoded from the {@link SimpleFeature}
     */
    public SpatialResource decodeFeatureToSpatialResource(SimpleFeature feature, SpatialResourcePropertyMappingType propertyMapping, CoordinateReferenceSystem crs) throws DecodingException {
        String id = getPropertyValueAsString(feature, propertyMapping.getIdentifierProperty());
        String name = getPropertyValueAsString(feature, propertyMapping.getNameProperty());
        String arisenFrom = propertyMapping.getArisenFromProperty() == null ? null :
                getPropertyValueAsString(feature, propertyMapping.getArisenFromProperty());
        LocalDate startDate = propertyMapping.getValidStartDateProperty() == null ? null :
                getPropertyValueAsDate(feature, propertyMapping.getValidStartDateProperty());
        LocalDate endDate = propertyMapping.getValidEndDateProperty() == null ? null :
                getPropertyValueAsDate(feature, propertyMapping.getValidEndDateProperty());
        Geometry geom = getGeometry(feature, feature.getFeatureType(), crs);

        return new SpatialResource(id, name, geom, arisenFrom, startDate, endDate);
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
                                                                           CoordinateReferenceSystem crs) {
        List<SpatialResource> result = new ArrayList<>();
        SimpleFeatureIterator iterator = featureCollection.features();
        while (iterator.hasNext()) {
            SimpleFeature feature = iterator.next();
            try {
                result.add(decodeFeatureToSpatialResource(feature, propertyMappingType, crs));
            } catch (DecodingException e) {
                LOG.warn("Could not decode feature {}. Cause: {}.", feature.getID(), e.getMessage());
            }
        }
        return result;
    }

    /**
     * Decode a {@link  List<SimpleFeature>} as {@link IndicatorValue} by mapping certain properties
     *
     * @param spatialRefKey       the spatial reference key for the {@link IndicatorValue} to which all the
     *                            {@link SimpleFeature} entities belong
     * @param features            {@link  List<SimpleFeature>} to decode
     * @param propertyMappingType definition of property mappings
     * @return {@link IndicatorValue}
     * @throws DecodingException if a certain property could not be decoded from the {@link SimpleFeature}
     */
    public IndicatorValue decodeFeaturesToIndicatorValues(String spatialRefKey, List<SimpleFeature> features, IndicatorPropertyMappingType propertyMappingType) {
        List<TimeseriesValue> timeSeries = new ArrayList<>();
        features.forEach(f -> {
            try {
                float indicatorValue = getPropertyValueAsFloat(f, propertyMappingType.getIndicatorValueProperty());
                LocalDate timeStamp = getPropertyValueAsDate(f, propertyMappingType.getTimestampProperty());
                timeSeries.add(new TimeseriesValue(indicatorValue, timeStamp));
            } catch (DecodingException e) {
                LOG.warn("Could not decode feature {}. Cause: {}.", f.getID(), e.getMessage());
            }
        });

        return new IndicatorValue(spatialRefKey, timeSeries);
    }

    /**
     * Decode a {@link SimpleFeatureCollection} as {@link List<IndicatorValue>} by mapping certain properties
     * and the geometry
     *
     * @param featureCollection   {@link SimpleFeatureCollection} to decode
     * @param propertyMappingType definition of property mappings
     * @return {@link List<IndicatorValue>}
     */
    public List<IndicatorValue> decodeFeatureCollectionToIndicatorValues(SimpleFeatureCollection featureCollection,
                                                                         IndicatorPropertyMappingType propertyMappingType) throws IOException {
        List<IndicatorValue> result = new ArrayList<>();
        Map<String, List<SimpleFeature>> groupedFeatures = groupFeatureCollection(featureCollection, propertyMappingType);
        groupedFeatures.forEach((k, v) -> {
            result.add(decodeFeaturesToIndicatorValues(k, v, propertyMappingType));
        });

        return result;
    }

    /**
     * Groups a {@link SimpleFeatureCollection} by common values of a spatial reference key property that
     * is defined within a {@link IndicatorPropertyMappingType}.
     * The grouping results in a {@link Map<String, List<SimpleFeature>>} with the distinct spatial reference key values
     * as map keys and the {@link SimpleFeature} entities belonging to the spatial reference keys value as values.
     *
     * @param featureCollection   the {@link SimpleFeatureCollection} to group
     * @param propertyMappingType {@link IndicatorPropertyMappingType} that contains the definition of the reference key property
     * @return a {@link Map} that contains the {@link SimpleFeature} entities grouped by its spatial reference key values
     */
    protected Map<String, List<SimpleFeature>> groupFeatureCollection(SimpleFeatureCollection featureCollection, IndicatorPropertyMappingType propertyMappingType) {
        Map<String, List<SimpleFeature>> groupedFeatures = new HashMap();
        SimpleFeatureIterator iterator = featureCollection.features();
        while (iterator.hasNext()) {
            SimpleFeature feature = iterator.next();
            try {
                String refKey = getPropertyValueAsString(feature, propertyMappingType.getSpatialReferenceKeyProperty());
                if (groupedFeatures.containsKey(refKey)) {
                    groupedFeatures.get(refKey).add(feature);
                } else {
                    List<SimpleFeature> featureList = new ArrayList<>();
                    featureList.add(feature);
                    groupedFeatures.put(refKey, featureList);
                }
            } catch (DecodingException e) {
                LOG.warn("Could not decode feature {}. Cause: {}.", feature.getID(), e.getMessage());
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
    protected Geometry getGeometry(SimpleFeature feature, SimpleFeatureType simpleFeatureType, CoordinateReferenceSystem crs) throws DecodingException {
        String geomName = simpleFeatureType.getGeometryDescriptor().getLocalName();
        Geometry geom = (Geometry) feature.getAttribute(geomName);
        try {
            return reprojectGeomToWgs84(geom, crs);
        } catch (FactoryException | TransformException ex) {
            throw new DecodingException(String.format("Could not reproject feature geometries to CRS: %s", EPSG_4326), ex);
        }
    }

    /**
     * Reprojects a {@link Geometry} from a source CRS into WGS 84 CRS
     *
     * @param geom      {@link Geometry} to reproject
     * @param sourceCrs {@link CoordinateReferenceSystem} of the feature geometry
     * @return the reprojected {@link Geometry}
     * @throws FactoryException
     * @throws TransformException
     */
    protected Geometry reprojectGeomToWgs84(Geometry geom, CoordinateReferenceSystem sourceCrs)
            throws FactoryException, TransformException {
        MathTransform transform = CRS.findMathTransform(sourceCrs, CRS.decode(EPSG_4326));
        return JTS.transform(geom, transform);
    }

    /**
     * Gets the value from a {@link SimpleFeature} property as String
     *
     * @param feature      the {@link SimpleFeature} to fetch the property from
     * @param propertyName name of the property to fetch
     * @return the value of the fetched feature property as String
     * @throws DecodingException if the property value could not be parsed as String
     */
    protected String getPropertyValueAsString(SimpleFeature feature, String propertyName) throws DecodingException {
        Object propertyValue = getPropertyValue(feature, propertyName);
        if (!(propertyValue instanceof String)) {
            throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, String.class.getName()));
        }
        return (String) propertyValue;
    }

    /**
     * Gets the value from a {@link SimpleFeature} property as Float
     *
     * @param feature      the {@link SimpleFeature} to fetch the property from
     * @param propertyName name of the property to fetch
     * @return the value of the fetched feature property as Float
     * @throws DecodingException if the property value could not be parsed as Float
     */
    protected float getPropertyValueAsFloat(SimpleFeature feature, String propertyName) throws DecodingException {
        Object propertyValue = getPropertyValue(feature, propertyName);
        if (propertyValue instanceof Float) {
            return (Float) propertyValue;
        } else if (propertyValue instanceof String) {
            try {
                return Float.parseFloat((String) propertyValue);
            } catch (NumberFormatException ex) {
                throw new DecodingException(String.format("Could not decode property '%s' as '%s'", propertyName, Float.class.getName()));
            }

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
    protected LocalDate getPropertyValueAsDate(SimpleFeature feature, String propertyName) throws DecodingException {
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

    protected Object getPropertyValue(SimpleFeature feature, String propertyName) throws DecodingException {
        Object propertyValue = feature.getAttribute(propertyName);
        if (propertyValue == null) {
            throw new DecodingException(String.format("Property '%s' does not exist.", propertyName));
        }
        return propertyValue;
    }
}

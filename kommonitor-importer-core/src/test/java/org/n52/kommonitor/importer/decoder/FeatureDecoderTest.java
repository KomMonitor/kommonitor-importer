package org.n52.kommonitor.importer.decoder;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.CRS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.mockito.Mockito;
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
import org.opengis.feature.type.GeometryDescriptor;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
class FeatureDecoderTest {

    private static final String ID_PROP = "id";
    private static final String ID_PROP_VALUE = "testId";
    private static final String NAME_PROP = "name";
    private static final String NAME_PROP_VALUE = "testName";
    private static final String START_DATE_PROP = "startDate";
    private static final String START_DATE_PROP_VALUE = "2020-01-01";
    private static final String END_DATE_PROP = "endDate";
    private static final String END_DATE_PROP_VALUE = "2020-12-31";
    private static final String GEOM_PROP = "geometry";
    private static final String REF_KEY_PROP = "refKey";
    private static final String REF_KEY_PROP_VALUE = "testRefKey";
    private static final String VALUE_PROP = "value";
    private static final String VALUE_PROP_2 = "value2";
    private static final float VALUE_PROP_VALUE = 12.123f;
    private static final float VALUE_PROP_2_VALUE = 24.621f;
    private static final String TIMESTAMP_PROP = "timestamp";
    private static final String TIMESTAMP_PROP_2 = "timestamp2";
    private static final String TIMESTAMP_PROP_VALUE = "2020-01-01";
    private static final String TIMESTAMP_PROP_2_VALUE = "2020-09-15";

    private static FeatureDecoder decoder;

    @BeforeAll
    static void init() throws Exception {
        GeometryHelper geomHelper = new GeometryHelper();
        geomHelper.afterPropertiesSet();
        ImportMonitor monitor = new ImportMonitor();
        decoder = new FeatureDecoder(geomHelper, monitor);
    }


    @Test
    @DisplayName("Test single feature decoding to SpatialResource")
    void testDecodeFeatureToSpatialResource() throws DecodingException, FactoryException {
        SpatialResourcePropertyMappingType mapping = crateSpatialFeaturePropertyMapping();
        SimpleFeature feature = mockSimpleFeature();

        SpatialResource resource = decoder.decodeFeatureToSpatialResource(feature, mapping, CRS.decode("EPSG:32632"));

        Assertions.assertEquals("testId", resource.getId());
        Assertions.assertEquals("testName", resource.getName());
        Assertions.assertEquals(LocalDate.of(2020, 01, 01), resource.getStartDate().get());
        Assertions.assertEquals(LocalDate.of(2020, 12, 31), resource.getEndDate().get());
    }

    private SpatialResourcePropertyMappingType crateSpatialFeaturePropertyMapping() {
        SpatialResourcePropertyMappingType mapping = new SpatialResourcePropertyMappingType();
        mapping.setIdentifierProperty(ID_PROP);
        mapping.setNameProperty(NAME_PROP);
        mapping.setValidStartDateProperty(START_DATE_PROP);
        mapping.setValidEndDateProperty(END_DATE_PROP);
        return mapping;
    }

    private IndicatorPropertyMappingType createIndicatorPropertyMapping() {
        IndicatorPropertyMappingType mapping = new IndicatorPropertyMappingType();
        mapping.setSpatialReferenceKeyProperty(REF_KEY_PROP);

        List timeseriesMappingList = new ArrayList();
        timeseriesMappingList.add(createTimeseriesPropertyMapping());
        mapping.setTimeseriesMappings(timeseriesMappingList);
        return mapping;
    }

    private TimeseriesMappingType createTimeseriesPropertyMapping() {
        TimeseriesMappingType timeseriesMapping = new TimeseriesMappingType();
        timeseriesMapping.setIndicatorValueProperty(VALUE_PROP);
        return timeseriesMapping;
    }

    @Test
    @DisplayName("Test single Feature decoding to SpatialResource for optional properties")
    void testDecodeFeatureToSpatialResourceForOptionalProperties() throws DecodingException, FactoryException, TransformException {
        SpatialResourcePropertyMappingType mapping = crateSpatialFeaturePropertyMapping();
        mapping.setValidStartDateProperty(null);
        mapping.setValidEndDateProperty(null);
        SimpleFeature feature = mockSimpleFeature();

        SpatialResource resource = decoder.decodeFeatureToSpatialResource(feature, mapping, CRS.decode("EPSG:32632"));

        Assertions.assertFalse(resource.getStartDate().isPresent());
        Assertions.assertFalse(resource.getEndDate().isPresent());
    }

    @Test
    @DisplayName("Test FeatureCollection decoding to SpatialResources")
    void testDecodeFeatureCollectionToSpatialResources() throws DecodingException, FactoryException, IOException {
        SpatialResourcePropertyMappingType mapping = crateSpatialFeaturePropertyMapping();
        SimpleFeature feature = mockSimpleFeature();

        SimpleFeatureCollection featureCollection = Mockito.mock(SimpleFeatureCollection.class);
        SimpleFeatureIterator iterator = Mockito.mock(SimpleFeatureIterator.class);
        Mockito.when(featureCollection.features()).thenReturn(iterator);
        Mockito.when(iterator.hasNext()).thenReturn(true, false);
        Mockito.when(iterator.next()).thenReturn(feature);

        List<SpatialResource> resources = decoder.decodeFeatureCollectionToSpatialResources(featureCollection, mapping, CRS.decode("EPSG:32632"));

        Assertions.assertEquals(1, resources.size());
        Assertions.assertEquals(NAME_PROP_VALUE, resources.get(0).getName());
        Assertions.assertEquals(ID_PROP_VALUE, resources.get(0).getId());
    }

    @Test
    @DisplayName("Test single Feature decoding to TimeSeriesValue")
    void testDecodeFeatureToTimeseriesValue() throws DecodingException {
        TimeseriesMappingType mapping = createTimeseriesPropertyMapping();
        mapping.setTimestampProperty(TIMESTAMP_PROP);
        SimpleFeature feature = mockSimpleFeature();

        TimeseriesValue timeseriesValue = decoder.decodeFeatureToTimeseriesValue(feature, mapping);

        Assertions.assertEquals(12.123, timeseriesValue.getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 01, 01), timeseriesValue.getTimestamp());
    }

    @Test
    @DisplayName("Test single Feature decoding to IndicatorValue")
    void testDecodeSingleFeatureToIndicatorValue() throws DecodingException {
        IndicatorPropertyMappingType mapping = createIndicatorPropertyMapping();
        SimpleFeature feature = mockSimpleFeature();

        IndicatorValue indicator = decoder.decodeFeatureToIndicatorValue(feature, mapping);

        Assertions.assertEquals(REF_KEY_PROP_VALUE, indicator.getSpatialReferenceKey());
        Assertions.assertEquals(12.123, indicator.getTimeSeriesValueList().get(0).getValue(), 0.0001);
    }

    @Test
    @DisplayName("Test Feature decoding to Indicator with timestamp property mapping")
    void testDecodeFeatureToIndicatorsWithTimestampPropertyMapping() throws DecodingException, FactoryException {
        TimeseriesMappingType mapping = createTimeseriesPropertyMapping();
        mapping.setTimestampProperty(TIMESTAMP_PROP);
        SimpleFeature feature = mockSimpleFeature();

        IndicatorValue indicator = decoder.decodeFeaturesToIndicatorValues(REF_KEY_PROP_VALUE, Arrays.asList(feature), mapping);

        Assertions.assertEquals(REF_KEY_PROP_VALUE, indicator.getSpatialReferenceKey());
        Assertions.assertEquals(12.123, indicator.getTimeSeriesValueList().get(0).getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 01, 01), indicator.getTimeSeriesValueList().get(0).getTimestamp());
    }

    @Test
    @DisplayName("Test single Feature decoding to Indicator with static timestamp")
    void testDecodeFeatureToIndicatorsWithStaticTimestamp() throws DecodingException, FactoryException {
        TimeseriesMappingType mapping = createTimeseriesPropertyMapping();
        mapping.setTimestamp(LocalDate.parse(TIMESTAMP_PROP_VALUE));
        SimpleFeature feature = mockSimpleFeature();

        IndicatorValue indicator = decoder.decodeFeaturesToIndicatorValues(REF_KEY_PROP_VALUE, Arrays.asList(feature), mapping);

        Assertions.assertEquals(REF_KEY_PROP_VALUE, indicator.getSpatialReferenceKey());
        Assertions.assertEquals(12.123, indicator.getTimeSeriesValueList().get(0).getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 01, 01), indicator.getTimeSeriesValueList().get(0).getTimestamp());
    }

    @Test
    @DisplayName("Test FeatureCollection decoding to Indicator")
    void testDecodeFeatureCollectionToIndicatorsForSingleTimeseriesMapping() throws DecodingException, FactoryException, IOException {
        IndicatorPropertyMappingType mapping = createIndicatorPropertyMapping();
        mapping.getTimeseriesMappings().get(0).setTimestampProperty(TIMESTAMP_PROP);
        SimpleFeature feature = mockSimpleFeature();

        SimpleFeatureCollection featureCollection = Mockito.mock(SimpleFeatureCollection.class);
        SimpleFeatureIterator iterator = Mockito.mock(SimpleFeatureIterator.class);
        Mockito.when(featureCollection.features()).thenReturn(iterator);
        Mockito.when(iterator.hasNext()).thenReturn(true, false);
        Mockito.when(iterator.next()).thenReturn(feature);

        List<IndicatorValue> indicators = decoder.decodeFeatureCollectionToIndicatorValues(featureCollection, mapping);

        Assertions.assertEquals(REF_KEY_PROP_VALUE, indicators.get(0).getSpatialReferenceKey());
        Assertions.assertEquals(12.123, indicators.get(0).getTimeSeriesValueList().get(0).getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 01, 01), indicators.get(0).getTimeSeriesValueList().get(0).getTimestamp());
    }

    @Test
    @DisplayName("Test FeatureCollection decoding to Indicator")
    void testDecodeFeatureCollectionToIndicatorsForMultipleTimeseriesMapping() throws DecodingException, FactoryException, IOException {
        IndicatorPropertyMappingType mapping = createIndicatorPropertyMapping();
        mapping.getTimeseriesMappings().get(0).setTimestampProperty(TIMESTAMP_PROP);

        TimeseriesMappingType timeseriesMapping = new TimeseriesMappingType();
        timeseriesMapping.setIndicatorValueProperty(VALUE_PROP_2);
        timeseriesMapping.setTimestampProperty(TIMESTAMP_PROP_2);

        mapping.addTimeseriesMappingsItem(timeseriesMapping);

        SimpleFeature feature = mockSimpleFeature();
        Mockito.when(feature.getAttribute(VALUE_PROP_2)).thenReturn(VALUE_PROP_2_VALUE);
        Mockito.when(feature.getAttribute(TIMESTAMP_PROP_2)).thenReturn(TIMESTAMP_PROP_2_VALUE);

        SimpleFeatureCollection featureCollection = Mockito.mock(SimpleFeatureCollection.class);
        SimpleFeatureIterator iterator = Mockito.mock(SimpleFeatureIterator.class);
        Mockito.when(featureCollection.features()).thenReturn(iterator);
        Mockito.when(iterator.hasNext()).thenReturn(true, false);
        Mockito.when(iterator.next()).thenReturn(feature);

        List<IndicatorValue> indicators = decoder.decodeFeatureCollectionToIndicatorValues(featureCollection, mapping);

        Assertions.assertEquals(REF_KEY_PROP_VALUE, indicators.get(0).getSpatialReferenceKey());
        Assertions.assertEquals(VALUE_PROP_VALUE, indicators.get(0).getTimeSeriesValueList().get(0).getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 1, 1), indicators.get(0).getTimeSeriesValueList().get(0).getTimestamp());
        Assertions.assertEquals(VALUE_PROP_2_VALUE, indicators.get(0).getTimeSeriesValueList().get(1).getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 9, 15), indicators.get(0).getTimeSeriesValueList().get(1).getTimestamp());
    }

    @Test
    @DisplayName("Test FeatureCollection grouping")
    void testGroupFeatureCollection() throws DecodingException, FactoryException, IOException {
        IndicatorPropertyMappingType mapping = createIndicatorPropertyMapping();
        SimpleFeature f1 = Mockito.mock(SimpleFeature.class);
        Mockito.when(f1.getAttribute(REF_KEY_PROP)).thenReturn("testRefKey");
        SimpleFeature f2 = Mockito.mock(SimpleFeature.class);
        Mockito.when(f2.getAttribute(REF_KEY_PROP)).thenReturn("testRefKey");
        SimpleFeature f3 = Mockito.mock(SimpleFeature.class);
        Mockito.when(f3.getAttribute(REF_KEY_PROP)).thenReturn("anotherTestRefKey");

        SimpleFeatureCollection featureCollection = Mockito.mock(SimpleFeatureCollection.class);
        SimpleFeatureIterator iterator = Mockito.mock(SimpleFeatureIterator.class);
        Mockito.when(featureCollection.features()).thenReturn(iterator);
        Mockito.when(iterator.hasNext()).thenReturn(true, true, true, false);
        Mockito.when(iterator.next()).thenReturn(f1, f2, f3);

        Map<String, List<SimpleFeature>> groupedFeatures = decoder.groupFeatureCollection(featureCollection, REF_KEY_PROP);

        Assertions.assertEquals(2, groupedFeatures.size());
        Assertions.assertTrue(groupedFeatures.containsKey("testRefKey") && groupedFeatures.containsKey("anotherTestRefKey"));
    }

    @Test
    @DisplayName("Test get String property")
    void testGetStringPropertyValue() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        String attValue = "testAttributeValue";
        Mockito.when(feature.getAttribute(attName)).thenReturn(attValue);

        Assertions.assertEquals(attValue, decoder.getPropertyValueAsString(feature, attName));
    }

    @Test
    @DisplayName("Test get String property for non String property")
    void testGetStringPropertyValueForNonStringProperty() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        int attValue = 123;
        Mockito.when(feature.getAttribute(attName)).thenReturn(attValue);

        Assertions.assertEquals(String.valueOf(attValue), decoder.getPropertyValueAsString(feature, attName));
    }

    @Test
    @DisplayName("Test get Date property should throw an exception for an invalid type")
    void testGetDatePropertyValueThrowsExceptionForInvalidType() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        Mockito.when(feature.getAttribute(attName)).thenReturn(Integer.valueOf(1));

        Assertions.assertThrows(DecodingException.class, () -> decoder.getPropertyValueAsDate(feature, attName));
    }

    @Test
    @DisplayName("Test get Date property should throw an exception for an non parsable Date string")
    void testGetDatePropertyValueThrowsExceptionForNonParsableString() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        String date = "not-a-date";
        Mockito.when(feature.getAttribute(attName)).thenReturn(date);

        Assertions.assertThrows(DecodingException.class, () -> decoder.getPropertyValueAsDate(feature, attName));
    }

    @Test
    @DisplayName("Test get Date property value for a String property type")
    void testGetDatePropertyValueForStringProperty() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        String date = "2019-12-17";
        Mockito.when(feature.getAttribute(attName)).thenReturn(date);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Assertions.assertEquals(date, dtf.format(decoder.getPropertyValueAsDate(feature, attName)));
    }

    @Test
    @DisplayName("Test get Date property value for a Date property type")
    void testGetDatePropertyValueForDateProperty() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        Date date = new Date();
        Mockito.when(feature.getAttribute(attName)).thenReturn(date);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Assertions.assertEquals(df.format(date), dtf.format(decoder.getPropertyValueAsDate(feature, attName)));
    }

    @Test
    @DisplayName("Test get Integer property value for a Integer property type")
    void testGetIntegerPropertyValueForIntegerProperty() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        int value = 123;
        Mockito.when(feature.getAttribute(attName)).thenReturn(value);

        Assertions.assertEquals(value, decoder.getPropertyValueAsInteger(feature, attName));
    }

    @Test
    @DisplayName("Test get Integer property value for a String property")
    void testGetIntegerPropertyValueForStringProperty() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        String value = "123";
        Mockito.when(feature.getAttribute(attName)).thenReturn(value);

        Assertions.assertEquals(Integer.parseInt(value), decoder.getPropertyValueAsInteger(feature, attName));
    }

    @Test
    @DisplayName("Test get Integer property value should throw an exception for a non parsable String property")
    void testGetIntegerPropertyValueForNonParsableStringProperty() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        String value = "not-a-number";
        Mockito.when(feature.getAttribute(attName)).thenReturn(value);

        Assertions.assertThrows(DecodingException.class, () -> decoder.getPropertyValueAsInteger(feature, attName));
    }

    @Test
    @DisplayName("Test get Integer property value should throw an exception for a non supported property type")
    void testGetIntegerPropertyValueForNonSupportedPropertyType() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        float value = 123.123f;
        Mockito.when(feature.getAttribute(attName)).thenReturn(value);

        Assertions.assertThrows(DecodingException.class, () -> decoder.getPropertyValueAsInteger(feature, attName));
    }

    @Test
    @DisplayName("Test get Float property value for a Float property type")
    void testGetFloatPropertyValueForFloatProperty() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        float value = 0.123f;
        Mockito.when(feature.getAttribute(attName)).thenReturn(value);

        Assertions.assertEquals(value, decoder.getPropertyValueAsFloat(feature, attName));
    }

    @Test
    @DisplayName("Test get Float property value for a String property type")
    void testGetFloatPropertyValueForStringProperty() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        String value = "0.123";
        Mockito.when(feature.getAttribute(attName)).thenReturn(value);

        Assertions.assertEquals(Float.parseFloat(value), decoder.getPropertyValueAsFloat(feature, attName));
    }

    @Test
    @DisplayName("Test get Float property value for a numerical property type")
    void testGetFloatPropertyValueForNumericalProperty() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        double valueDbl = 0.123;
        int valueInt = 12;
        long valueLng = 12L;

        Mockito.when(feature.getAttribute(attName)).thenReturn(valueDbl);
        Assertions.assertEquals(((Double) valueDbl).floatValue(), decoder.getPropertyValueAsFloat(feature, attName));

        Mockito.when(feature.getAttribute(attName)).thenReturn(valueInt);
        Assertions.assertEquals(((Integer) valueInt).floatValue(), decoder.getPropertyValueAsFloat(feature, attName));

        Mockito.when(feature.getAttribute(attName)).thenReturn(valueLng);
        Assertions.assertEquals(((Long) valueLng).floatValue(), decoder.getPropertyValueAsFloat(feature, attName));
    }

    @Test
    @DisplayName("Test get Float property value should throw an exception for a non parsable String")
    void testGetFloatPropertyValueThrowsExceptionForNonParsableString() {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        String value = "not-a-number";
        Mockito.when(feature.getAttribute(attName)).thenReturn(value);

        Assertions.assertThrows(DecodingException.class, () -> decoder.getPropertyValueAsFloat(feature, attName));
    }

    @Test
    @DisplayName("Test get property value for existing property")
    void testGetPropertyValue() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        String attValue = "testAttributeValue";
        Mockito.when(feature.getAttribute(attName)).thenReturn(attValue);

        Assertions.assertEquals(attValue, decoder.getPropertyValue(feature, attName));
    }

    @Test
    @DisplayName("Test get property value should throw exception for missing property")
    void testGetPropertyValueShouldThrowExceptionForMissingProperty() {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";

        Assertions.assertThrows(DecodingException.class, () -> decoder.getPropertyValue(feature, attName));
    }

    private SimpleFeature mockSimpleFeature() {
        SimpleFeatureType featureType = Mockito.mock(SimpleFeatureType.class);
        GeometryDescriptor descriptor = Mockito.mock(GeometryDescriptor.class);
        Mockito.when(descriptor.getLocalName()).thenReturn(GEOM_PROP);
        Mockito.when(featureType.getGeometryDescriptor()).thenReturn(descriptor);

        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        Mockito.when(feature.getAttribute(ID_PROP)).thenReturn(ID_PROP_VALUE);
        Mockito.when(feature.getAttribute(NAME_PROP)).thenReturn(NAME_PROP_VALUE);
        Mockito.when(feature.getAttribute(START_DATE_PROP)).thenReturn(START_DATE_PROP_VALUE);
        Mockito.when(feature.getAttribute(END_DATE_PROP)).thenReturn(END_DATE_PROP_VALUE);
        Mockito.when(feature.getAttribute(GEOM_PROP))
                .thenReturn(JTSFactoryFinder.getGeometryFactory().createPoint(new Coordinate(405329.64, 5757736.23)));
        Mockito.when(feature.getAttribute(REF_KEY_PROP)).thenReturn(REF_KEY_PROP_VALUE);
        Mockito.when(feature.getAttribute(VALUE_PROP)).thenReturn(VALUE_PROP_VALUE);
        Mockito.when(feature.getAttribute(TIMESTAMP_PROP)).thenReturn(TIMESTAMP_PROP_VALUE);
        Mockito.when(feature.getFeatureType()).thenReturn(featureType);
        return feature;
    }
}
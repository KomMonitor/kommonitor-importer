package org.n52.kommonitor.importer.decoder;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.geotools.api.feature.Property;
import org.geotools.api.feature.simple.SimpleFeature;
import org.geotools.api.feature.simple.SimpleFeatureType;
import org.geotools.api.feature.type.GeometryDescriptor;
import org.geotools.api.feature.type.Name;
import org.geotools.api.referencing.FactoryException;
import org.geotools.api.referencing.NoSuchAuthorityCodeException;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.feature.NameImpl;
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
import org.n52.kommonitor.importer.utils.GeometryHelper;
import org.n52.kommonitor.importer.utils.ImportMonitor;
import org.n52.kommonitor.models.AttributeMappingType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.n52.kommonitor.models.TimeseriesMappingType;

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
    void testDecodeFeatureToSpatialResource() throws DecodingException, FactoryException, NoSuchAuthorityCodeException {
        SpatialResourcePropertyMappingType mapping = crateSpatialFeaturePropertyMapping();
        mapping.setKeepMissingOrNullValueAttributes(false);
        SimpleFeature feature = mockSimpleFeature();

        SpatialResource resource = decoder.decodeFeatureToSpatialResource(feature, mapping, CRS.decode("EPSG:32632"));

        Assertions.assertEquals("testId", resource.getId());
        Assertions.assertEquals("testName", resource.getName());
        Assertions.assertEquals(LocalDate.of(2020, 1, 1), resource.getStartDate().get());
        Assertions.assertEquals(LocalDate.of(2020, 12, 31), resource.getEndDate().get());
    }

    private SpatialResourcePropertyMappingType crateSpatialFeaturePropertyMapping() {
        SpatialResourcePropertyMappingType mapping = new SpatialResourcePropertyMappingType();
        mapping.setIdentifierProperty(ID_PROP);
        mapping.setNameProperty(NAME_PROP);
        mapping.setValidStartDateProperty(START_DATE_PROP);
        mapping.setValidEndDateProperty(END_DATE_PROP);
        mapping.setKeepAttributes(false);
        return mapping;
    }

    private IndicatorPropertyMappingType createIndicatorPropertyMapping() {
        IndicatorPropertyMappingType mapping = new IndicatorPropertyMappingType();
        mapping.setSpatialReferenceKeyProperty(REF_KEY_PROP);
        mapping.setKeepMissingOrNullValueIndicator(false);

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
    void testDecodeFeatureToSpatialResourceForOptionalProperties() throws DecodingException, FactoryException, NoSuchAuthorityCodeException {
        SpatialResourcePropertyMappingType mapping = crateSpatialFeaturePropertyMapping();
        mapping.setValidStartDateProperty(null);
        mapping.setValidEndDateProperty(null);
        mapping.setKeepAttributes(false);
        mapping.setKeepMissingOrNullValueAttributes(false);
        SimpleFeature feature = mockSimpleFeature();

        SpatialResource resource = decoder.decodeFeatureToSpatialResource(feature, mapping, CRS.decode("EPSG:32632"));

        Assertions.assertFalse(resource.getStartDate().isPresent());
        Assertions.assertFalse(resource.getEndDate().isPresent());
    }

    @Test
    @DisplayName("Test FeatureCollection decoding to SpatialResources")
    void testDecodeFeatureCollectionToSpatialResources() throws FactoryException, NoSuchAuthorityCodeException {
        SpatialResourcePropertyMappingType mapping = crateSpatialFeaturePropertyMapping();
        mapping.setKeepMissingOrNullValueAttributes(false);
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

        TimeseriesValue timeseriesValue = decoder.decodeFeatureToTimeseriesValue(feature, mapping, false);

        Assertions.assertEquals(12.123, timeseriesValue.getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 1, 1), timeseriesValue.getTimestamp());
    }

    @Test
    @DisplayName("Test single Feature decoding to TimeSeriesValue withing missing Indicator value handling for missing property")
    void testDecodeFeatureToTimeseriesValueWithMissingIndicatorValueHandlingForMissingProperty() throws DecodingException {
        TimeseriesMappingType mapping = new TimeseriesMappingType();
        mapping.setTimestampProperty(TIMESTAMP_PROP);
        mapping.setIndicatorValueProperty("missingProperty");
        SimpleFeature feature = mockSimpleFeature();

        TimeseriesValue timeseriesValue = decoder.decodeFeatureToTimeseriesValue(feature, mapping, true);

        Assertions.assertNull(timeseriesValue.getValue());
    }

    @Test
    @DisplayName("Test single Feature decoding to TimeSeriesValue withing missing Indicator value handling for NULL value")
    void testDecodeFeatureToTimeseriesValueWithMissingIndicatorValueHandlingForNullValue() throws DecodingException {
        TimeseriesMappingType mapping = new TimeseriesMappingType();
        mapping.setTimestampProperty(TIMESTAMP_PROP);
        mapping.setIndicatorValueProperty("indicatorProperty");

        Property indicatorProperty = Mockito.mock(Property.class);
        Mockito.when(indicatorProperty.getValue()).thenReturn(null);
        SimpleFeature feature = mockSimpleFeature();
        Mockito.when(feature.getProperty("indicatorProperty")).thenReturn(indicatorProperty);

        TimeseriesValue timeseriesValue = decoder.decodeFeatureToTimeseriesValue(feature, mapping, true);

        Assertions.assertNull(timeseriesValue.getValue());
    }

    @Test
    @DisplayName("Test single Feature decoding to IndicatorValue")
    void testDecodeSingleFeatureToIndicatorValue() throws DecodingException {
        IndicatorPropertyMappingType mapping = createIndicatorPropertyMapping();
        SimpleFeature feature = mockSimpleFeature();

        IndicatorValue indicator = decoder.decodeFeatureToIndicatorValue(feature, mapping, null);

        Assertions.assertEquals(REF_KEY_PROP_VALUE, indicator.getSpatialReferenceKey());
        Assertions.assertEquals(12.123, indicator.getTimeSeriesValueList().get(0).getValue(), 0.0001);
    }

    @Test
    @DisplayName("Test Feature decoding to Indicator with timestamp property mapping")
    void testDecodeFeatureToIndicatorsWithTimestampPropertyMapping() {
        TimeseriesMappingType mapping = createTimeseriesPropertyMapping();
        mapping.setTimestampProperty(TIMESTAMP_PROP);
        SimpleFeature feature = mockSimpleFeature();

        IndicatorValue indicator = decoder.decodeFeaturesToIndicatorValues(REF_KEY_PROP_VALUE, Collections.singletonList(feature), mapping, false, null);

        Assertions.assertEquals(REF_KEY_PROP_VALUE, indicator.getSpatialReferenceKey());
        Assertions.assertEquals(12.123, indicator.getTimeSeriesValueList().get(0).getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 1, 1), indicator.getTimeSeriesValueList().get(0).getTimestamp());
    }

    @Test
    @DisplayName("Test single Feature decoding to Indicator with static timestamp")
    void testDecodeFeatureToIndicatorsWithStaticTimestamp() {
        TimeseriesMappingType mapping = createTimeseriesPropertyMapping();
        mapping.setTimestamp(LocalDate.parse(TIMESTAMP_PROP_VALUE));
        SimpleFeature feature = mockSimpleFeature();

        IndicatorValue indicator = decoder.decodeFeaturesToIndicatorValues(REF_KEY_PROP_VALUE, Collections.singletonList(feature), mapping, false, null);

        Assertions.assertEquals(REF_KEY_PROP_VALUE, indicator.getSpatialReferenceKey());
        Assertions.assertEquals(12.123, indicator.getTimeSeriesValueList().get(0).getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 1, 1), indicator.getTimeSeriesValueList().get(0).getTimestamp());
    }

    @Test
    @DisplayName("Test FeatureCollection decoding to Indicator")
    void testDecodeFeatureCollectionToIndicatorsForSingleTimeseriesMapping() throws IOException {
        IndicatorPropertyMappingType mapping = createIndicatorPropertyMapping();
        mapping.getTimeseriesMappings().get(0).setTimestampProperty(TIMESTAMP_PROP);
        SimpleFeature feature = mockSimpleFeature();

        SimpleFeatureCollection featureCollection = Mockito.mock(SimpleFeatureCollection.class);
        SimpleFeatureIterator iterator = Mockito.mock(SimpleFeatureIterator.class);
        Mockito.when(featureCollection.features()).thenReturn(iterator);
        Mockito.when(iterator.hasNext()).thenReturn(true, false);
        Mockito.when(iterator.next()).thenReturn(feature);

        List<IndicatorValue> indicators = decoder.decodeFeatureCollectionToIndicatorValues(featureCollection, mapping, null);

        Assertions.assertEquals(REF_KEY_PROP_VALUE, indicators.get(0).getSpatialReferenceKey());
        Assertions.assertEquals(12.123, indicators.get(0).getTimeSeriesValueList().get(0).getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 1, 1), indicators.get(0).getTimeSeriesValueList().get(0).getTimestamp());
    }

    @Test
    @DisplayName("Test FeatureCollection decoding to Indicator")
    void testDecodeFeatureCollectionToIndicatorsForMultipleTimeseriesMapping() throws IOException {
        IndicatorPropertyMappingType mapping = createIndicatorPropertyMapping();
        mapping.getTimeseriesMappings().get(0).setTimestampProperty(TIMESTAMP_PROP);

        TimeseriesMappingType timeseriesMapping = new TimeseriesMappingType();
        timeseriesMapping.setIndicatorValueProperty(VALUE_PROP_2);
        timeseriesMapping.setTimestampProperty(TIMESTAMP_PROP_2);

        mapping.addTimeseriesMappingsItem(timeseriesMapping);

        SimpleFeature feature = mockSimpleFeature();
        Property valueProperty2 = Mockito.mock(Property.class);
        Mockito.when(valueProperty2.getValue()).thenReturn(VALUE_PROP_2_VALUE);
        Mockito.when(feature.getAttribute(VALUE_PROP_2)).thenReturn(VALUE_PROP_2_VALUE);
        Mockito.when(feature.getProperty(VALUE_PROP_2)).thenReturn(valueProperty2);

        Property timestampProperty2 = Mockito.mock(Property.class);
        Mockito.when(timestampProperty2.getValue()).thenReturn(TIMESTAMP_PROP_2_VALUE);
        Mockito.when(feature.getAttribute(TIMESTAMP_PROP_2)).thenReturn(TIMESTAMP_PROP_2_VALUE);
        Mockito.when(feature.getProperty(TIMESTAMP_PROP_2)).thenReturn(timestampProperty2);

        SimpleFeatureCollection featureCollection = Mockito.mock(SimpleFeatureCollection.class);
        SimpleFeatureIterator iterator = Mockito.mock(SimpleFeatureIterator.class);
        Mockito.when(featureCollection.features()).thenReturn(iterator);
        Mockito.when(iterator.hasNext()).thenReturn(true, false);
        Mockito.when(iterator.next()).thenReturn(feature);

        List<IndicatorValue> indicators = decoder.decodeFeatureCollectionToIndicatorValues(featureCollection, mapping, null);

        Assertions.assertEquals(REF_KEY_PROP_VALUE, indicators.get(0).getSpatialReferenceKey());
        Assertions.assertEquals(VALUE_PROP_VALUE, indicators.get(0).getTimeSeriesValueList().get(0).getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 1, 1), indicators.get(0).getTimeSeriesValueList().get(0).getTimestamp());
        Assertions.assertEquals(VALUE_PROP_2_VALUE, indicators.get(0).getTimeSeriesValueList().get(1).getValue(), 0.0001);
        Assertions.assertEquals(LocalDate.of(2020, 9, 15), indicators.get(0).getTimeSeriesValueList().get(1).getTimestamp());
    }

    @Test
    @DisplayName("Test attribute mapping")
    void testMapAttributes() {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String id = "testId";
        String strProp = "testStringProp";
        String strValue = "testStringValue";
        Mockito.when(feature.getAttribute(strProp)).thenReturn(strValue);

        String intProp = "testIntegerProp";
        int intValue = 123;
        Mockito.when(feature.getAttribute(intProp)).thenReturn(intValue);

        String floatProp = "testFloatProp";
        String mappedFloatProp = "mappedFloatProp";
        float floatValue = 123.123f;
        Mockito.when(feature.getAttribute(floatProp)).thenReturn(floatValue);

        String nonExistingProp = "non-existing-prop";

        String dateProp = "testDateProp";
        String mappedDateProp = "mappedDateProp";
        Date dateValue = new Date();
        Mockito.when(feature.getAttribute(dateProp)).thenReturn(dateValue);

        List<AttributeMappingType> mappings = new ArrayList();
        mappings.add(new AttributeMappingType().name(strProp).type(AttributeMappingType.TypeEnum.STRING));
        mappings.add(new AttributeMappingType().name(intProp).type(AttributeMappingType.TypeEnum.INTEGER));
        mappings.add(new AttributeMappingType().name(floatProp).mappingName(mappedFloatProp).type(AttributeMappingType.TypeEnum.FLOAT));
        mappings.add(new AttributeMappingType().name(dateProp).mappingName(mappedDateProp).type(AttributeMappingType.TypeEnum.DATE));
        mappings.add(new AttributeMappingType().name(nonExistingProp).type(AttributeMappingType.TypeEnum.STRING));

        Map mappedAttributes = decoder.mapAttributes(feature, mappings, id, false);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Assertions.assertEquals(strValue, mappedAttributes.get(strProp));
        Assertions.assertEquals(intValue, mappedAttributes.get(intProp));
        Assertions.assertEquals(floatValue, mappedAttributes.get(mappedFloatProp));
        Assertions.assertEquals(df.format(dateValue), dtf.format((LocalDate) mappedAttributes.get(mappedDateProp)));
        Assertions.assertFalse(mappedAttributes.containsKey(nonExistingProp));
    }

    @Test
    @DisplayName("Test attribute mapping for missing properties")
    void testMapAttributesForMissingProperties() {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String id = "testId";
        String strProp = "testStringProp";
        Property stringProperty = Mockito.mock(Property.class);
        Mockito.when(stringProperty.getValue()).thenReturn(null);
        Mockito.when(feature.getProperty(strProp)).thenReturn(stringProperty);

        String intProp = "testIntegerProp";
        int intValue = 123;
        Property integerProperty = Mockito.mock(Property.class);
        Mockito.when(integerProperty.getValue()).thenReturn(intValue);
        Mockito.when(feature.getAttribute(intProp)).thenReturn(intValue);
        Mockito.when(feature.getProperty(intProp)).thenReturn(integerProperty);

        String floatProp = "testFloatProp";
        String mappedFloatProp = "mappedFloatProp";
        float floatValue = 123.123f;

        String nonExistingProp = "non-existing-prop";

        String dateProp = "testDateProp";
        String mappedDateProp = "mappedDateProp";
        Date dateValue = new Date();
        Property mappedDateProperty = Mockito.mock(Property.class);
        Mockito.when(mappedDateProperty.getValue()).thenReturn(dateValue);
        Mockito.when(feature.getAttribute(dateProp)).thenReturn(dateValue);
        Mockito.when(feature.getProperty(dateProp)).thenReturn(mappedDateProperty);

        List<AttributeMappingType> mappings = new ArrayList();
        mappings.add(new AttributeMappingType().name(strProp).type(AttributeMappingType.TypeEnum.STRING));
        mappings.add(new AttributeMappingType().name(intProp).type(AttributeMappingType.TypeEnum.INTEGER));
        mappings.add(new AttributeMappingType().name(floatProp).mappingName(mappedFloatProp).type(AttributeMappingType.TypeEnum.FLOAT));
        mappings.add(new AttributeMappingType().name(dateProp).mappingName(mappedDateProp).type(AttributeMappingType.TypeEnum.DATE));
        mappings.add(new AttributeMappingType().name(nonExistingProp).type(AttributeMappingType.TypeEnum.STRING));

        Map mappedAttributes = decoder.mapAttributes(feature, mappings, id, true);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Assertions.assertNull(mappedAttributes.get(strProp));
        Assertions.assertEquals(intValue, mappedAttributes.get(intProp));
        Assertions.assertNull(mappedAttributes.get(mappedFloatProp));
        Assertions.assertEquals(df.format(dateValue), dtf.format((LocalDate) mappedAttributes.get(mappedDateProp)));
        Assertions.assertTrue(mappedAttributes.containsKey(nonExistingProp));
    }

    @Test
    @DisplayName("Test attribute mapping should return null for an empty mapping definition")
    void testMapAttributesShouldReturnNullForEmptyMappingDefinition() {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String id = "testId";
        List mappings = new ArrayList();

        Map mappedAttributes = decoder.mapAttributes(feature, mappings, id, false);

        Assertions.assertNull(mappedAttributes);
    }

    @Test
    @DisplayName("Test mapping of all attribute")
    void testMapAllAttributes() {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String strPropName = "testStringProp";
        String strValue = "testStringValue";
        Property strProp = Mockito.mock(Property.class);
        Name strName = Mockito.mock(Name.class);
        Mockito.when(strName.getLocalPart()).thenReturn(strPropName);
        Mockito.when(strProp.getName()).thenReturn(strName);
        Mockito.when(strProp.getValue()).thenReturn(strValue);

        String intPropName = "testIntegerProp";
        int intValue = 123;
        Property intProp = Mockito.mock(Property.class);
        Name intName = Mockito.mock(Name.class);
        Mockito.when(intName.getLocalPart()).thenReturn(intPropName);
        Mockito.when(intProp.getName()).thenReturn(intName);
        Mockito.when(intProp.getValue()).thenReturn(intValue);

        String floatPropName = "testFloatProp";
        float floatValue = 123.123f;
        Property floatProp = Mockito.mock(Property.class);
        Name floatName = Mockito.mock(Name.class);
        Mockito.when(floatName.getLocalPart()).thenReturn(floatPropName);
        Mockito.when(floatProp.getName()).thenReturn(floatName);
        Mockito.when(floatProp.getValue()).thenReturn(floatValue);

        String datePropName = "testDateProp";
        Date dateValue = new Date();
        Property dateProp = Mockito.mock(Property.class);
        Name dateName = Mockito.mock(Name.class);
        Mockito.when(dateName.getLocalPart()).thenReturn(datePropName);
        Mockito.when(dateProp.getName()).thenReturn(dateName);
        Mockito.when(dateProp.getValue()).thenReturn(dateValue);

        Mockito.when(feature.getProperties()).thenReturn(Arrays.asList(strProp, intProp, floatProp, dateProp));

        Map mappedAttributes = decoder.mappAllAttributes(feature);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Assertions.assertEquals(strValue, mappedAttributes.get(strPropName));
        Assertions.assertEquals(intValue, mappedAttributes.get(intPropName));
        Assertions.assertEquals(floatValue, mappedAttributes.get(floatPropName));
        Assertions.assertEquals(df.format(dateValue), df.format(mappedAttributes.get(datePropName)));

    }

    @Test
    @DisplayName("Test FeatureCollection grouping")
    void testGroupFeatureCollection() {
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
    void testGetDatePropertyValueThrowsExceptionForInvalidType() {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        Mockito.when(feature.getAttribute(attName)).thenReturn(1);

        Assertions.assertThrows(DecodingException.class, () -> decoder.getPropertyValueAsDate(feature, attName));
    }

    @Test
    @DisplayName("Test get Date property should throw an exception for an non parsable Date string")
    void testGetDatePropertyValueThrowsExceptionForNonParsableString() {
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
    void testGetIntegerPropertyValueForNonParsableStringProperty() {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        String value = "not-a-number";
        Mockito.when(feature.getAttribute(attName)).thenReturn(value);

        Assertions.assertThrows(DecodingException.class, () -> decoder.getPropertyValueAsInteger(feature, attName));
    }

    @Test
    @DisplayName("Test get Integer property value should throw an exception for a non supported property type")
    void testGetIntegerPropertyValueForNonSupportedPropertyType() {
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
        GeometryDescriptor geomDesc = featureType.getGeometryDescriptor();
        Mockito.when(geomDesc).thenReturn(descriptor);
        Mockito.when(descriptor.getName()).thenReturn(new NameImpl(GEOM_PROP));

        Property idProperty = Mockito.mock(Property.class);
        Mockito.when(idProperty.getValue()).thenReturn(ID_PROP_VALUE);
        Property nameProperty = Mockito.mock(Property.class);
        Mockito.when(nameProperty.getValue()).thenReturn(NAME_PROP_VALUE);
        Property startDateProperty = Mockito.mock(Property.class);
        Mockito.when(startDateProperty.getValue()).thenReturn(START_DATE_PROP_VALUE);
        Property endDateProperty = Mockito.mock(Property.class);
        Mockito.when(endDateProperty.getValue()).thenReturn(END_DATE_PROP_VALUE);
        Property refKeyProperty = Mockito.mock(Property.class);
        Mockito.when(refKeyProperty.getValue()).thenReturn(REF_KEY_PROP_VALUE);
        Property valueProperty = Mockito.mock(Property.class);
        Mockito.when(valueProperty.getValue()).thenReturn(VALUE_PROP_VALUE);
        Property timestampProperty = Mockito.mock(Property.class);
        Mockito.when(timestampProperty.getValue()).thenReturn(TIMESTAMP_PROP_VALUE);

        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        Mockito.when(feature.getAttribute(ID_PROP)).thenReturn(ID_PROP_VALUE);
        Mockito.when(feature.getProperty(ID_PROP)).thenReturn(idProperty);
        Mockito.when(feature.getAttribute(NAME_PROP)).thenReturn(NAME_PROP_VALUE);
        Mockito.when(feature.getProperty(NAME_PROP)).thenReturn(nameProperty);
        Mockito.when(feature.getAttribute(START_DATE_PROP)).thenReturn(START_DATE_PROP_VALUE);
        Mockito.when(feature.getProperty(START_DATE_PROP)).thenReturn(startDateProperty);
        Mockito.when(feature.getAttribute(END_DATE_PROP)).thenReturn(END_DATE_PROP_VALUE);
        Mockito.when(feature.getProperty(END_DATE_PROP)).thenReturn(endDateProperty);
        Mockito.when(feature.getAttribute(descriptor.getName()))
                .thenReturn(JTSFactoryFinder.getGeometryFactory().createPoint(new Coordinate(405329.64, 5757736.23)));
        Mockito.when(feature.getAttribute(REF_KEY_PROP)).thenReturn(REF_KEY_PROP_VALUE);
        Mockito.when(feature.getProperty(REF_KEY_PROP)).thenReturn(refKeyProperty);
        Mockito.when(feature.getAttribute(VALUE_PROP)).thenReturn(VALUE_PROP_VALUE);
        Mockito.when(feature.getProperty(VALUE_PROP)).thenReturn(valueProperty);
        Mockito.when(feature.getAttribute(TIMESTAMP_PROP)).thenReturn(TIMESTAMP_PROP_VALUE);
        Mockito.when(feature.getProperty(TIMESTAMP_PROP)).thenReturn(timestampProperty);
        Mockito.when(feature.getFeatureType()).thenReturn(featureType);
        return feature;
    }
}
package org.n52.kommonitor.importer.decoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.DecodingException;
import org.n52.kommonitor.importer.models.SpatialResourcePropertyMappingType;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.GeometryDescriptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
class FeatureDecoderTest {

    private static FeatureDecoder decoder;

    @BeforeAll
    static void setUp() {
        decoder = new FeatureDecoder();
    }

    @Test
    @DisplayName("Test single feature decoding")
    void testDecodeFeature() throws DecodingException {
        SpatialResourcePropertyMappingType mapping = new SpatialResourcePropertyMappingType();
        mapping.setIdentifierProperty("id");
        mapping.setNameProperty("name");
        mapping.setValidStartDateProperty("startDate");
        mapping.setValidEndDateProperty("endDate");

        SimpleFeatureType featureType = Mockito.mock(SimpleFeatureType.class);
        GeometryDescriptor descriptor = Mockito.mock(GeometryDescriptor.class);
        Mockito.when(descriptor.getLocalName()).thenReturn("geometry");
        Mockito.when(featureType.getGeometryDescriptor()).thenReturn(descriptor);

        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        Mockito.when(feature.getAttribute(mapping.getIdentifierProperty())).thenReturn("testId");
        Mockito.when(feature.getAttribute(mapping.getNameProperty())).thenReturn("testName");
        Mockito.when(feature.getAttribute(mapping.getValidStartDateProperty())).thenReturn("2019-12-17");
        Mockito.when(feature.getAttribute(mapping.getValidEndDateProperty())).thenReturn("2020-12-17");

        Geometry geom = Mockito.mock(Point.class);
        Mockito.when(feature.getAttribute("geometry")).thenReturn(geom);
        Mockito.when(feature.getFeatureType()).thenReturn(featureType);

        SpatialResource resource = decoder.decodeFeature(feature, mapping);

        Assertions.assertEquals("testId", resource.getId());
        Assertions.assertEquals("testName", resource.getName());
        Assertions.assertEquals(LocalDate.of(2019, 12, 17), resource.getStartDate().get());
        Assertions.assertEquals(LocalDate.of(2020, 12, 17), resource.getEndDate().get());
    }

    @Test
    @DisplayName("Test single feature decoding for optional properties")
    void testDecodeFeatureForOptionalProperties() throws DecodingException {
        SpatialResourcePropertyMappingType mapping = new SpatialResourcePropertyMappingType();
        mapping.setIdentifierProperty("id");
        mapping.setNameProperty("name");

        SimpleFeatureType featureType = Mockito.mock(SimpleFeatureType.class);
        GeometryDescriptor descriptor = Mockito.mock(GeometryDescriptor.class);
        Mockito.when(descriptor.getLocalName()).thenReturn("geometry");
        Mockito.when(featureType.getGeometryDescriptor()).thenReturn(descriptor);

        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        Mockito.when(feature.getAttribute(mapping.getIdentifierProperty())).thenReturn("testId");
        Mockito.when(feature.getAttribute(mapping.getNameProperty())).thenReturn("testName");

        Geometry geom = Mockito.mock(Point.class);
        Mockito.when(feature.getAttribute("geometry")).thenReturn(geom);
        Mockito.when(feature.getFeatureType()).thenReturn(featureType);

        SpatialResource resource = decoder.decodeFeature(feature, mapping);

        Assertions.assertFalse(resource.getStartDate().isPresent());
        Assertions.assertFalse(resource.getEndDate().isPresent());
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
    @DisplayName("Test get String property should throw an exception for an invalid type")
    void testGetStringPropertyValueThrowsExceptionForInvalidType() {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        Mockito.when(feature.getAttribute(attName)).thenReturn(Integer.valueOf(1));

        Assertions.assertThrows(DecodingException.class, () -> decoder.getPropertyValueAsString(feature, attName));
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
}
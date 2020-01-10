package org.n52.kommonitor.importer.decoder;

import org.geotools.data.DataUtilities;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.geometry.GeometryBuilder;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.converter.WFSv1Converter;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.DecodingException;
import org.n52.kommonitor.importer.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.importer.models.SpatialResourcePropertyMappingType;
import org.n52.kommonitor.importer.utils.GeometryHelper;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.GeometryDescriptor;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {FeatureDecoder.class, GeometryHelper.class})
class FeatureDecoderTest {

    @Autowired
    FeatureDecoder decoder;

    @Test
    @DisplayName("Test single feature decoding to SpatialResource")
    void testDecodeFeatureToSpatialResource() throws DecodingException, FactoryException {
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
        Mockito.when(feature.getAttribute("geometry"))
                .thenReturn(JTSFactoryFinder.getGeometryFactory().createPoint(new Coordinate(405329.64, 5757736.23)));
        Mockito.when(feature.getFeatureType()).thenReturn(featureType);

        SpatialResource resource = decoder.decodeFeatureToSpatialResource(feature, mapping, CRS.decode("EPSG:32632"));

        Assertions.assertEquals("testId", resource.getId());
        Assertions.assertEquals("testName", resource.getName());
        Assertions.assertEquals(LocalDate.of(2019, 12, 17), resource.getStartDate().get());
        Assertions.assertEquals(LocalDate.of(2020, 12, 17), resource.getEndDate().get());
    }

    @Test
    @DisplayName("Test single feature decoding to SpatialResource for optional properties")
    void testDecodeFeatureToSpatialResourceForOptionalProperties() throws DecodingException, FactoryException, TransformException {
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
        Mockito.when(feature.getAttribute("geometry"))
                .thenReturn(JTSFactoryFinder.getGeometryFactory().createPoint(new Coordinate(405329.64, 5757736.23)));
        Mockito.when(feature.getFeatureType()).thenReturn(featureType);

        SpatialResource resource = decoder.decodeFeatureToSpatialResource(feature, mapping, CRS.decode("EPSG:32632"));

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
}
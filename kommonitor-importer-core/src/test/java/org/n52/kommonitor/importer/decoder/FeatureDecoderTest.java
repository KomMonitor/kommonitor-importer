package org.n52.kommonitor.importer.decoder;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.exceptions.DecodingException;
import org.opengis.feature.simple.SimpleFeature;

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
    void testGetDatePropertyValue() throws DecodingException {
        SimpleFeature feature = Mockito.mock(SimpleFeature.class);
        String attName = "testAttribute";
        Mockito.when(feature.getAttribute(attName)).thenReturn(Integer.valueOf(1));

        Assertions.assertThrows(DecodingException.class, () -> decoder.getPropertyValueAsDate(feature, attName));
    }

    @Test
    void testGetDatePropertyValueThrowsExceptionForUnvalidType() throws DecodingException {
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
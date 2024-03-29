package org.n52.kommonitor.importer.converter;

import java.io.File;
import java.io.InputStream;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.utils.GeometryHelper;
import org.n52.kommonitor.importer.utils.ImportMonitor;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.ParameterValueType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.n52.kommonitor.models.TimeseriesMappingType;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class TableAddressStructuredConverterTest {

    private final static String MIME_TYPE = "text/csv";
    private final static String ENCODING = "UTF-8";

    private static ConverterDefinitionType convDef;
    private static SpatialResourcePropertyMappingType spatialResourcePropertyMapping;
    private static IndicatorPropertyMappingType indicatorPropertyMapping;

    private static TableConverter_address_structured converter;

    @BeforeAll
    static void init() throws Exception {
        GeometryHelper geomHelper = new GeometryHelper();
        geomHelper.afterPropertiesSet();
        ImportMonitor monitor = new ImportMonitor();
        converter = new TableConverter_address_structured(new FeatureDecoder(geomHelper, monitor));

        convDef = new ConverterDefinitionType();
        convDef.setMimeType(MIME_TYPE);
        convDef.setEncoding(ENCODING);
        ParameterValueType param_separator = new ParameterValueType();
        param_separator.setName("Trennzeichen");
        param_separator.setValue(";");
        ParameterValueType param_street = new ParameterValueType();
        param_street.setName("Strasse_Spaltenname");
        param_street.setValue("street");
        ParameterValueType param_housenumber = new ParameterValueType();
        param_housenumber.setName("Hausnummer_Spaltenname");
        param_housenumber.setValue("housenumber");
        ParameterValueType param_city = new ParameterValueType();
        param_city.setName("Stadt_Spaltenname");
        param_city.setValue("city");
        ParameterValueType param_postcode = new ParameterValueType();
        param_postcode.setName("Postleitzahl_Spaltenname");
        param_postcode.setValue("postcode");
        ParameterValueType param_country = new ParameterValueType();
        param_country.setName("Land_Spaltenname");
        param_country.setValue("country");
        ParameterValueType param_district = new ParameterValueType();
        param_district.setName("Bezirk_Spaltenname");
        param_district.setValue("district");
        ParameterValueType param_state = new ParameterValueType();
        param_state.setName("Bundesland_Spaltenname");
        param_state.setValue("state");
        List<ParameterValueType> params = new ArrayList<ParameterValueType>();
        params.add(param_separator);
        params.add(param_street);
        params.add(param_postcode);
        params.add(param_housenumber);
        params.add(param_city);
        params.add(param_state);
        params.add(param_country);
        params.add(param_district);
        convDef.setParameters(params);

        spatialResourcePropertyMapping = new SpatialResourcePropertyMappingType();
        spatialResourcePropertyMapping.setIdentifierProperty("ID");
        spatialResourcePropertyMapping.setNameProperty("NAME");
        spatialResourcePropertyMapping.setKeepAttributes(false);
        spatialResourcePropertyMapping.setKeepMissingOrNullValueAttributes(true);
        
        indicatorPropertyMapping = new IndicatorPropertyMappingType();
        indicatorPropertyMapping.setSpatialReferenceKeyProperty("ID");
        List<TimeseriesMappingType> timeseriesMappings = new ArrayList<TimeseriesMappingType>();
        TimeseriesMappingType timeseriesMappingType = new TimeseriesMappingType();
        timeseriesMappingType.setTimestamp(new Date().toInstant()
        	      .atZone(ZoneId.systemDefault())
        	      .toLocalDate());
        timeseriesMappingType.setIndicatorValueProperty("NAME");
        
		timeseriesMappings.add(timeseriesMappingType);
        indicatorPropertyMapping.setTimeseriesMappings(timeseriesMappings);
        indicatorPropertyMapping.setKeepMissingOrNullValueIndicator(true);

    }

    @Test
    @DisplayName("Test convert SpatialResources for CSV dataset")
    void testConvertSpatialResourcesForCsvDataset() throws ConverterException, ImportParameterException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("features_fromAddressStructured.csv").getFile());
        Dataset<InputStream> dataset = new Dataset(file);

        List<SpatialResource> spatialResources = converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping);

//        Assertions.assertEquals(4, spatialResources.size());
    }
    
//    @Test
//    @DisplayName("Test convert Indicators for CSV dataset")
//    void testConvertIndicatorsForCsvDataset() throws ConverterException {
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource("features_fromAddressStructured.csv").getFile());
//        Dataset<InputStream> dataset = new Dataset(file);
//
//        List<IndicatorValue> indicators = converter.convertIndicators(convDef, dataset, indicatorPropertyMapping);
//
//        Assertions.assertEquals(5, indicators.size());
//        Assertions.assertNotNull(indicators.get(0).getSpatialReferenceKey());
//        Assertions.assertEquals(1, indicators.get(0).getTimeSeriesValueList().size());
//    }

//    @Test
//    @DisplayName("Test convert SpatialResources for CSV dataset throws ConverterException for non parsable dataset")
//    void testConvertSpatialResourcesForGeoJsonDatasetThrowsConverterExceptionForNotParsableDataset() {
//        Dataset<String> dataset = new Dataset<>("nonParsableFeatureCollection");
//
//        Assertions.assertThrows(ConverterException.class, () -> converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping));
//    }
//    
//    @Test
//    @DisplayName("Test convert Indicators for CSV dataset throws ConverterException for non parsable dataset")
//    void testConvertIndicatorsForGeoJsonDatasetThrowsConverterExceptionForNotParsableDataset() {
//        Dataset<String> dataset = new Dataset<>("nonParsableFeatureCollection");
//
//        Assertions.assertThrows(ConverterException.class, () -> converter.convertIndicators(convDef, dataset, indicatorPropertyMapping));
//    }

}

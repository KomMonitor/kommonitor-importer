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
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
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
public class CsvLatLonConverterTest {

    private final static String MIME_TYPE = "text/csv";
    private final static String ENCODING = "UTF-8";

    private static ConverterDefinitionType convDef;
    private static SpatialResourcePropertyMappingType spatialResourcePropertyMapping;
    private static IndicatorPropertyMappingType indicatorPropertyMapping;

    private static CsvConverter_latLon converter;

    @BeforeAll
    static void init() throws Exception {
        GeometryHelper geomHelper = new GeometryHelper();
        geomHelper.afterPropertiesSet();
        ImportMonitor monitor = new ImportMonitor();
        converter = new CsvConverter_latLon(new FeatureDecoder(geomHelper, monitor));

        convDef = new ConverterDefinitionType();
        convDef.setMimeType(MIME_TYPE);
        convDef.setEncoding(ENCODING);
        ParameterValueType param_crs = new ParameterValueType();
        param_crs.setName("CRS");
        param_crs.setValue("EPSG:4647");
        ParameterValueType param_separator = new ParameterValueType();
        param_separator.setName("separator");
        param_separator.setValue(";");
        ParameterValueType param_xCoord = new ParameterValueType();
        param_xCoord.setName("xCoordColumn");
        param_xCoord.setValue("ETSRe");
        ParameterValueType param_yCoord = new ParameterValueType();
        param_yCoord.setName("yCoordColumn");
        param_yCoord.setValue("ETRSh");
        List<ParameterValueType> params = new ArrayList<ParameterValueType>();
        params.add(param_crs);
        params.add(param_separator);
        params.add(param_xCoord);
        params.add(param_yCoord);
        convDef.setParameters(params);

        spatialResourcePropertyMapping = new SpatialResourcePropertyMappingType();
        spatialResourcePropertyMapping.setIdentifierProperty("ID");
        spatialResourcePropertyMapping.setNameProperty("paAdresseID");
        spatialResourcePropertyMapping.setKeepAttributes(false);
        spatialResourcePropertyMapping.setKeepMissingOrNullValueAttributes(true);
        
        indicatorPropertyMapping = new IndicatorPropertyMappingType();
        indicatorPropertyMapping.setSpatialReferenceKeyProperty("ID");
        List<TimeseriesMappingType> timeseriesMappings = new ArrayList<TimeseriesMappingType>();
        TimeseriesMappingType timeseriesMappingType = new TimeseriesMappingType();
        timeseriesMappingType.setTimestamp(new Date().toInstant()
        	      .atZone(ZoneId.systemDefault())
        	      .toLocalDate());
        timeseriesMappingType.setIndicatorValueProperty("paAdresseID");
        
		timeseriesMappings.add(timeseriesMappingType);
        indicatorPropertyMapping.setTimeseriesMappings(timeseriesMappings);
        indicatorPropertyMapping.setKeepMissingOrNullValueIndicator(true);

    }

    @Test
    @DisplayName("Test convert SpatialResources for CSV dataset")
    void testConvertSpatialResourcesForCsvDataset() throws ConverterException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("features.csv").getFile());
        Dataset<InputStream> dataset = new Dataset(file);

        List<SpatialResource> spatialResources = converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping);

        Assertions.assertEquals(5, spatialResources.size());
    }
    
    @Test
    @DisplayName("Test convert Indicators for CSV dataset")
    void testConvertIndicatorsForCsvDataset() throws ConverterException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("features.csv").getFile());
        Dataset<InputStream> dataset = new Dataset(file);

        List<IndicatorValue> indicators = converter.convertIndicators(convDef, dataset, indicatorPropertyMapping);

        Assertions.assertEquals(5, indicators.size());
        Assertions.assertNotNull(indicators.get(0).getSpatialReferenceKey());
        Assertions.assertEquals(1, indicators.get(0).getTimeSeriesValueList().size());
    }

    @Test
    @DisplayName("Test convert SpatialResources for CSV dataset throws ConverterException for non parsable dataset")
    void testConvertSpatialResourcesForGeoJsonDatasetThrowsConverterExceptionForNotParsableDataset() {
        Dataset<String> dataset = new Dataset<>("nonParsableFeatureCollection");

        Assertions.assertThrows(ConverterException.class, () -> converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping));
    }
    
    @Test
    @DisplayName("Test convert Indicators for CSV dataset throws ConverterException for non parsable dataset")
    void testConvertIndicatorsForGeoJsonDatasetThrowsConverterExceptionForNotParsableDataset() {
        Dataset<String> dataset = new Dataset<>("nonParsableFeatureCollection");

        Assertions.assertThrows(ConverterException.class, () -> converter.convertIndicators(convDef, dataset, indicatorPropertyMapping));
    }

}

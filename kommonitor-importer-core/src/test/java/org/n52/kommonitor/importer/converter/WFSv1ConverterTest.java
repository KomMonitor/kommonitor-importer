package org.n52.kommonitor.importer.converter;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.geotools.wfs.GML;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
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
public class WFSv1ConverterTest {

    private final static String WFS_SCHEMA = "http://schemas.opengis.net/wfs/1.0.0/wfs.xsd";
    private final static String MIME_TYPE = "application/xml";
    private final static String ENCODING = "UTF-8";

    private static ConverterDefinitionType convDef;
    private static SpatialResourcePropertyMappingType spatialResourcePropertyMapping;
    private static IndicatorPropertyMappingType indicatorPropertyMapping;

    private static WFSv1Converter converter;

    @BeforeAll
    static void init() throws Exception {
        GeometryHelper geomHelper = new GeometryHelper();
        geomHelper.afterPropertiesSet();
        ImportMonitor monitor = new ImportMonitor();
        converter = new WFSv1Converter(new FeatureDecoder(geomHelper, monitor));

        convDef = new ConverterDefinitionType();
        convDef.setMimeType(MIME_TYPE);
        convDef.setSchema(WFS_SCHEMA);
        convDef.setEncoding(ENCODING);
        ParameterValueType param = new ParameterValueType();
        param.setName("CRS");
        param.setValue("EPSG:25832");
        convDef.setParameters(Collections.singletonList(param));

        spatialResourcePropertyMapping = new SpatialResourcePropertyMappingType();
        spatialResourcePropertyMapping.setIdentifierProperty("Baublock_ID");
        spatialResourcePropertyMapping.setNameProperty("Baublock_ID");
        spatialResourcePropertyMapping.setValidStartDateProperty("EreignisintervallStart");
        spatialResourcePropertyMapping.setValidEndDateProperty("EreignisintervallEnde");
        spatialResourcePropertyMapping.setKeepAttributes(false);
        spatialResourcePropertyMapping.setKeepMissingOrNullValueAttributes(false);

        indicatorPropertyMapping = new IndicatorPropertyMappingType();
        indicatorPropertyMapping.setSpatialReferenceKeyProperty("Baublock_ID");
        indicatorPropertyMapping.setKeepMissingOrNullValueIndicator(false);

        TimeseriesMappingType timeseriesMapping = new TimeseriesMappingType();
        timeseriesMapping.setIndicatorValueProperty("dmg_altrstr_drchschnaltr");
        timeseriesMapping.setTimestampProperty("EreignisintervallStart");

        indicatorPropertyMapping.setTimeseriesMappings(Collections.singletonList(timeseriesMapping));
    }

    @Test
    @DisplayName("Test get GML parser for a certain schema")
    void testGetGmlParserForSchema() throws ImportParameterException {
        GML gml = converter.getGmlParserForSchema(WFS_SCHEMA);

        Assertions.assertNotNull(gml);
    }

    @Test
    @DisplayName("Test get GML parser throws ImportParameterException for unsupported schema")
    void testGetGmlThrowsImportParameterExceptionForUnsupportedSchema() {
        Assertions.assertThrows(ImportParameterException.class, () -> converter.getGmlParserForSchema("http://no/valid/gml/schema"));
    }

    @Test
    @DisplayName("Test convert SpatialResources for WFS 1.0.0 datasource")
    void testConvertSpatialResourcesForWfs100Datasource() throws ConverterException, ImportParameterException {
        InputStream input = getClass().getResourceAsStream("/getWfs100FeatureResponseTest.xml");
        Dataset<InputStream> dataset = new Dataset<>(input);

        List<SpatialResource> spatialResources = converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping);

        Assertions.assertEquals(3, spatialResources.size());
    }

    @Test
    @DisplayName("Test convert Indicators for WFS 1.0.0 datasource")
    void testConvertIndicatorsForWfs100Datasource() throws ConverterException, ImportParameterException {
        InputStream input = getClass().getResourceAsStream("/getWfs100FeatureResponseTest.xml");
        Dataset<InputStream> dataset = new Dataset<>(input);

        List<IndicatorValue> spatialResources = converter.convertIndicators(convDef, dataset, indicatorPropertyMapping);

        Assertions.assertEquals(3, spatialResources.size());
    }

    @Test
    @DisplayName("Test convert SpatialResources for WFS datasource throws ConverterException for non parsable dataset")
    void testConvertSpatialResourcesForWfsDatasourceThrowsConverterExceptionForNotParsableDataset() {
        Dataset<String> dataset = new Dataset<>("nonParsableFeatureCollection");

        Assertions.assertThrows(ConverterException.class, () -> converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping));
    }

    @Test
    @DisplayName("Test convert Indicators for WFS datasource throws ConverterException for non parsable dataset")
    void testConvertIndicatorForWfsDatasourceThrowsConverterExceptionForNotParsableDataset() {
        Dataset<String> dataset = new Dataset<>("nonParsableFeatureCollection");

        Assertions.assertThrows(ConverterException.class, () -> converter.convertIndicators(convDef, dataset, indicatorPropertyMapping));
    }

    @Test
    @DisplayName("Test convert SpatialResources for WFS datasource throws ImportParameterException for unavailable CRS parameter")
    void testConvertSpatialResourcesForWfsDatasourceThrowsImporParameterExceptionForUnavailableParameter() {
        InputStream input = getClass().getResourceAsStream("/getWfs100FeatureResponseTest.xml");
        Dataset<InputStream> dataset = new Dataset<>(input);
        convDef.setParameters(Collections.EMPTY_LIST);

        Assertions.assertThrows(ImportParameterException.class, () -> converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping));
    }

    @Test
    @DisplayName("Test convert SpatialResources for WFS datasource throws ConverterException for unvalid CRS parameter")
    void testConvertSpatialResourcesForWfsDatasourceThrowsConverterExceptionForNonValidParameter() {
        InputStream input = getClass().getResourceAsStream("/getWfs100FeatureResponseTest.xml");
        Dataset<InputStream> dataset = new Dataset<>(input);
        ParameterValueType param = new ParameterValueType();
        param.setName("CRS");
        param.setValue("non-valid-epsg-code");
        convDef.setParameters(Collections.singletonList(param));

        Assertions.assertThrows(ImportParameterException.class, () -> converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping));
    }


}

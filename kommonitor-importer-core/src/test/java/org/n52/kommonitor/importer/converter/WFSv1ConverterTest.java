package org.n52.kommonitor.importer.converter;

import org.geotools.GML;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.SpatialResourcePropertyMappingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.InputStream;
import java.util.List;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WFSv1Converter.class})
public class WFSv1ConverterTest {

    private final static String WFS_SCHEMA = "http://schemas.opengis.net/wfs/1.0.0/wfs.xsd";
    private final static String MIME_TYPE = "application/xml";
    private final static String ENCODING = "UTF-8";

    private static ConverterDefinitionType convDef;
    private static SpatialResourcePropertyMappingType propertyMapping;

    @Autowired
    private WFSv1Converter converter;

    @BeforeAll
    static void init() {
        convDef = new ConverterDefinitionType();
        convDef.setMimeType(MIME_TYPE);
        convDef.setSchema(WFS_SCHEMA);
        convDef.setEncoding(ENCODING);

        propertyMapping = new SpatialResourcePropertyMappingType();
        propertyMapping.setIdentifierProperty("Baublock_ID");
        propertyMapping.setNameProperty("Baublock_ID");
        propertyMapping.setValidStartDateProperty("EreignisintervallStart");
        propertyMapping.setValidEndDateProperty("EreignisintervallEnde");
    }

    @Test
    @DisplayName("Test get GML parser for a certain schema")
    void testGetGmlParserForSchema() {
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
    void testConvertSpatialResourcesForWfs100Datasource() throws ConverterException {
        InputStream input = getClass().getResourceAsStream("/getWfs100FeatureResponseTest.xml");
        Dataset<InputStream> dataset = new Dataset<>(input);

        List<SpatialResource> spatialResources = converter.convertSpatialResources(convDef, dataset, propertyMapping);

        Assertions.assertEquals(3, spatialResources.size());
    }

    @Test
    @DisplayName("Test convert SpatialResources for WFS datasource throws ConverterException for unsupported dataset type")
    void testConvertSpatialResourcesForWfsDatasourceThrowsConverterExceptionForUnsupportedDatasetType() {
        ConverterDefinitionType convDef = Mockito.mock(ConverterDefinitionType.class);
        SpatialResourcePropertyMappingType propertyMapping = Mockito.mock(SpatialResourcePropertyMappingType.class);
        Dataset<Double> dataset = new Dataset<>(123.123);

        Assertions.assertThrows(ConverterException.class, () -> converter.convertSpatialResources(convDef, dataset, propertyMapping));
    }

    @Test
    @DisplayName("Test convert SpatialResources for WFS datasource throws ConverterException for non parsable dataset")
    void testConvertSpatialResourcesForWfsDatasourceThrowsConverterExceptionForNotParsableDataset() {
        Dataset<String> dataset = new Dataset<>("nonParsableFeatureCollection");

        Assertions.assertThrows(ConverterException.class, () -> converter.convertSpatialResources(convDef, dataset, propertyMapping));
    }

}

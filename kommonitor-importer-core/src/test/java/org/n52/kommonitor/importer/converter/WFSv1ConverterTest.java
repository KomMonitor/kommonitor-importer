package org.n52.kommonitor.importer.converter;

//import net.opengis.wfs.x20.FeatureCollectionDocument;
//import net.opengis.wfs.x20.FeatureCollectionType;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.geotools.GML;
import org.geotools.geometry.jts.WKTReader2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.SpatialResourcePropertyMappingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

    private String WFS_SCHEMA = "http://schemas.opengis.net/wfs/1.0.0/wfs.xsd";

    @Autowired
    private WFSv1Converter converter;
    
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

}

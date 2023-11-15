package org.n52.kommonitor.importer.converter;

import org.junit.jupiter.api.BeforeAll;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.utils.GeometryHelper;
import org.n52.kommonitor.importer.utils.ImportMonitor;
import org.n52.kommonitor.models.*;

import java.util.Collections;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class APIFeaturesConverterTest extends GeoJsonConverterTest{

    @BeforeAll
    static void init() throws Exception {
        GeometryHelper geomHelper = new GeometryHelper();
        geomHelper.afterPropertiesSet();
        ImportMonitor monitor = new ImportMonitor();
        converter = new APIFeaturesConverter(new FeatureDecoder(geomHelper, monitor));

        convDef = new ConverterDefinitionType();
        convDef.setMimeType(MIME_TYPE);
        convDef.setEncoding(ENCODING);
        ParameterValueType param = new ParameterValueType();
        convDef.setParameters(Collections.singletonList(param));

        spatialResourcePropertyMapping = new SpatialResourcePropertyMappingType();
        spatialResourcePropertyMapping.setIdentifierProperty("baublock_id");
        spatialResourcePropertyMapping.setNameProperty("baublock_name");
        spatialResourcePropertyMapping.setKeepMissingOrNullValueAttributes(false);
    }


}

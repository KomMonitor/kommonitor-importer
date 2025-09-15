package org.n52.kommonitor.importer.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class AbstractConverterTest {

    private static final String NAME = "GmlConverter";
    private static final String MIME_TYPE = "application/xml";
    private static final String ENCODING = "UTF-8";
    private static final String SCHEMA = "http://schemas.opengis.net/gml/3.2.1/gml.xsd";
    private static Set<String> supportedMimeTypes;
    private static Set<String> supportedSchemas;
    private static Set<String> supportedEncodings;

    @BeforeAll
    static void init() {
        supportedMimeTypes = new HashSet<>(Collections.singletonList(MIME_TYPE));
        supportedSchemas = new HashSet<>(Collections.singletonList(SCHEMA));
        supportedEncodings = new HashSet<>(Collections.singletonList(ENCODING));
    }

    @Test
    void testValidateDefinition() throws Exception {
        AbstractConverter converter = prepareMock();
        ConverterDefinitionType definition = new ConverterDefinitionType();
        definition.setMimeType(MIME_TYPE);
        definition.setSchema(SCHEMA);
        definition.setEncoding(ENCODING);

        Assertions.assertDoesNotThrow(() -> converter.validateDefinition(definition));
    }

    @Test
    void testValidateDefinitionForUnsupportedMimeType() throws Exception {
        AbstractConverter converter = prepareMock();
        String mimeType = "application/json";
        String schema = "http://schemas.opengis.net/gml/2.1.2/gml.xsd";
        String encoding = "ISO-8859-1";
        ConverterDefinitionType definition = new ConverterDefinitionType();
        definition.setMimeType(mimeType);
        definition.setSchema(schema);
        definition.setEncoding(encoding);

        Assertions.assertThrows(
                ImportParameterException.class,
                () -> converter.validateDefinition(definition),
                getErrorMessage(mimeType, schema, encoding));
    }

    @Test
    @DisplayName("Test get InputStream for unsupported dataset type")
    void testGetInputStreamThrowsConverterExceptionForUnsupportedDatasetType() throws Exception {
        AbstractConverter converter = prepareMock();
        ConverterDefinitionType convDef = Mockito.mock(ConverterDefinitionType.class);
        Dataset<Double> dataset = new Dataset<>(123.123);

        Assertions.assertThrows(ConverterException.class, () -> converter.getInputStream(convDef, dataset));
    }

    private AbstractConverter prepareMock() {
        AbstractConverter converter = Mockito.mock(AbstractConverter.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(converter.initName()).thenReturn(NAME);
        Mockito.when(converter.initSupportedMimeType()).thenReturn(supportedMimeTypes);
        Mockito.when(converter.initSupportedSchemas()).thenReturn(supportedSchemas);
        Mockito.when(converter.initSupportedEncoding()).thenReturn(supportedEncodings);
        converter.afterPropertiesSet();
        return converter;
    }

    private String getErrorMessage(String mimeType, String schema, String encoding) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Unsupported MIME type '%s' for converter '%s'. Supported MIME type is '%s'.",
                mimeType, NAME, MIME_TYPE));
        builder.append(System.lineSeparator());
        builder.append(String.format("Unsupported schema '%s' for converter '%s'. Supported schemas are '%s'.",
                schema, NAME, supportedSchemas));
        builder.append(String.format("Unsupported encoding '%s' for converter '%s'. Supported encodings are '%s'.",
                encoding, NAME, supportedEncodings));
        return builder.toString();
    }
}

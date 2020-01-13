package org.n52.kommonitor.importer.api;

import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.api.encoder.ConverterEncoder;
import org.n52.kommonitor.importer.api.handler.ImportExceptionHandler;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.ConverterParameter;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(ConvertersApiController.class)
@ContextConfiguration(classes = {ConvertersApiController.class, ConverterEncoder.class, ImportExceptionHandler.class})
public class ConvertersApiControllerTest {

    private static final String CONVERTER_NAME = "Test converter";
    private static final String CONVERTER_MIME_TYPE = "text/xml";
    private static final String CONVERTER_SCHEMA = "http://schemas.opengis.net/wfs/1.0.0/wfs.xsd";
    private static final String PARAM_NAME = "payload";
    private static final String PARAM_DESC = "The dataset payload";
    private static final ConverterParameter.ParameterTypeValues PARAM_TYPE = ConverterParameter.ParameterTypeValues.STRING;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConverterRepository converterRepository;

    @MockBean
    private AbstractConverter converter;

    @Test
    @DisplayName("Test getConverters responds with OK status code")
    public void tesGetConverters() throws Exception {
        prepareMocks();
        Mockito.when(converterRepository.getAll()).thenReturn(Arrays.asList(converter));

        this.mockMvc.perform(get("/converters"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$[0].name").value(CONVERTER_NAME))
                .andExpect(jsonPath("$[0].mimeTypes[0]").value(CONVERTER_MIME_TYPE))
                .andExpect(jsonPath("$[0].parameters[0]").doesNotExist());
    }

    @Test
    @DisplayName("Test getConverterByName responds with OK status code")
    public void testGetConverterByName() throws Exception {
        prepareMocks();
        Mockito.when(converterRepository.getConverter(CONVERTER_NAME)).thenReturn(Optional.of(converter));

        this.mockMvc.perform(get("/converters/{name}", CONVERTER_NAME))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.name").value(CONVERTER_NAME))
                .andExpect(jsonPath("$.mimeTypes[0]").value(CONVERTER_MIME_TYPE))
                .andExpect(jsonPath("$.parameters[0].name").value(PARAM_NAME))
                .andExpect(jsonPath("$.parameters[0].description").value(PARAM_DESC));

    }

    @Test
    @DisplayName("Test getConverterByName responds with NotFound status code")
    public void testGetConverterByNameNotFound() throws Exception {
        Mockito.when(converterRepository.getConverter(CONVERTER_NAME)).thenReturn(Optional.ofNullable(null));

        this.mockMvc.perform(get("/converters/{name}", CONVERTER_NAME))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.message")
                        .value(String.format("Resource '%s' with identifier '%s' was not found.",
                                AbstractConverter.class.getName(), CONVERTER_NAME)));
    }

    private void prepareMocks() {
        Mockito.when(converter.getName()).thenReturn(CONVERTER_NAME);
        Mockito.when(converter.getSupportedMimeTypes()).thenReturn(new HashSet<>(Arrays.asList(CONVERTER_MIME_TYPE)));
        Mockito.when(converter.getSupportedSchemas()).thenReturn(new HashSet<>(Arrays.asList(CONVERTER_SCHEMA)));
        Mockito.when(converter.getConverterParameters()).thenReturn(new HashSet<>(Arrays.asList(new ConverterParameter(PARAM_NAME, PARAM_DESC, PARAM_TYPE))));
    }
}

package org.n52.kommonitor.importer.api;

import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.api.encoder.DataSourceRetrieverEncoder;
import org.n52.kommonitor.importer.api.handler.ImportExceptionHandler;
import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.io.datasource.DataSourceParameter;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
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
@ContextConfiguration(classes = {DatasourceTypesApiController.class, DataSourceRetrieverEncoder.class, ImportExceptionHandler.class})
public class DatasourceTypesApiTest {

    private static final String DATASOURCE_TYPE = "INLINE";
    private static final String PARAM_NAME = "payload";
    private static final String PARAM_DESC = "The dataset payload";
    private static final DataSourceParameter.ParameterTypeValues PARAM_TYPE = DataSourceParameter.ParameterTypeValues.STRING;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataSourceRetrieverRepository repository;

    @MockBean
    private AbstractDataSourceRetriever retriever;

    @Test
    @DisplayName("Test getSupportedDataSourceTypes responds with OK status code")
    public void testGetSupportedDataSourceTypes() throws Exception {
        prepareMocks();
        Mockito.when(repository.getAll()).thenReturn(Arrays.asList(retriever));

        this.mockMvc.perform(get("/datasourceTypes"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$[0].type").value(DATASOURCE_TYPE))
                .andExpect(jsonPath("$[0].parameters[0]").doesNotExist());
    }

    @Test
    @DisplayName("Test getSupportedDataSourceTypeByType responds with OK status code")
    public void testGetSupportedDataSourceTypeByType() throws Exception {
        prepareMocks();
        Mockito.when(repository.getDatasourceRetriever(DATASOURCE_TYPE)).thenReturn(Optional.of(retriever));

        this.mockMvc.perform(get("/datasourceTypes/{type}", DATASOURCE_TYPE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.parameters[0].name").value(PARAM_NAME))
                .andExpect(jsonPath("$.parameters[0].description").value(PARAM_DESC));

    }

    @Test
    @DisplayName("Test getConverterByName responds with NotFound status code")
    public void testGetSupportedDataSourceTypeByTypeNotFound() throws Exception {
        Mockito.when(repository.getDatasourceRetriever(DATASOURCE_TYPE)).thenReturn(Optional.ofNullable(null));

        this.mockMvc.perform(get("/datasourceTypes/{type}", DATASOURCE_TYPE))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.message")
                        .value(String.format("Resource '%s' with identifier '%s' was not found.",
                                AbstractDataSourceRetriever.class.getName(), DATASOURCE_TYPE)));
    }

    private void prepareMocks() {
        Mockito.when(retriever.getType()).thenReturn(DATASOURCE_TYPE);
        Mockito.when(retriever.getDataSourceParameters())
                .thenReturn(new HashSet<>(Arrays.asList(new DataSourceParameter(PARAM_NAME, PARAM_DESC, PARAM_TYPE))));
    }
}

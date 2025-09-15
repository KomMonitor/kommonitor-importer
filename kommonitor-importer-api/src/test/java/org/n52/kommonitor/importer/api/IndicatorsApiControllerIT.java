package org.n52.kommonitor.importer.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;
import org.n52.kommonitor.importer.api.encoder.IndicatorEncoder;
import org.n52.kommonitor.importer.api.handler.ApiExceptionHandler;
import org.n52.kommonitor.importer.api.handler.IndicatorUpdateHandler;
import org.n52.kommonitor.importer.api.handler.RequestHandlerRepository;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
import org.n52.kommonitor.importer.utils.EntityValidator;
import org.n52.kommonitor.importer.utils.ImportMonitor;
import org.n52.kommonitor.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(IndicatorsApiController.class)
@ContextConfiguration(classes = {IndicatorsApiController.class, RequestHandlerRepository.class, IndicatorUpdateHandler.class, ApiExceptionHandler.class, EntityValidator.class})
public class IndicatorsApiControllerIT {

    private static final String RESOURCE_ID = "testID";
    private static final String BASE_PATH = "/importer";

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ConverterRepository converterRepository;

    @MockitoBean
    private AbstractConverter converter;

    @MockitoBean
    private DataSourceRetrieverRepository retrieverRepository;

    @MockitoBean
    private AbstractDataSourceRetriever<?> retriever;

    @MockitoBean
    private IndicatorEncoder encoder;

    @MockitoBean
    private IndicatorsApi apiClient;

    @MockitoBean
    private EntityValidator validator;

    @MockitoBean
    private ImportMonitor monitor;

    private static UpdateIndicatorPOSTInputType indicatorUpdateBody;

    @BeforeAll
    static void init() {
        indicatorUpdateBody = createGeoresourceUpdateType();
    }

    @Test
    @DisplayName("Test updateIndicator responds with 200 status code")
    public void testUpdateIndicator() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        indicatorUpdateBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/indicators/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(new ObjectMapper().writeValueAsString(indicatorUpdateBody)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.uri").value(RESOURCE_ID));
    }

    @Test
    @DisplayName("Test updateIndicator dry run responds with 200 status code and resource uri is empty")
    public void testUpdateIndicatorDryRun() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        indicatorUpdateBody.setDryRun(true);

        this.mockMvc.perform(post(BASE_PATH + "/indicators/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(new ObjectMapper().writeValueAsString(indicatorUpdateBody)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.uri").isEmpty());
    }

    @Test
    @DisplayName("Test updateIndicator responds with 400 status code for non valid request content")
    public void testUpdateIndicatorForNonValidRequestContent() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        JsonNode json = new ObjectMapper().valueToTree(indicatorUpdateBody);
        ((ObjectNode) json.get("dataSource")).put("type", "invalidType");
        ((ObjectNode) json).set("metadata", null);
        indicatorUpdateBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/indicators/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(json.toString()))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @DisplayName("Test updateIndicator responds with 400 status code for ImportParameterException")
    public void testUpdateIndicatorForImportParameterException() throws Exception {
        prepareMocks();
        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenThrow(new ImportParameterException("Missing parameter: testParam"));
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        indicatorUpdateBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/indicators/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(new ObjectMapper().writeValueAsString(indicatorUpdateBody)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @DisplayName("Test updateIndicators responds with 500 status code for DataSourceRetrieverException")
    public void testUpdateIndicatorForDataSourceRetrieverException() throws Exception {
        prepareMocks();
        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenThrow(new DataSourceRetrieverException("Error while fetching data."));
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        indicatorUpdateBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/indicators/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(new ObjectMapper().writeValueAsString(indicatorUpdateBody)))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @Test
    @DisplayName("Test updateIndicator responds with 500 status code for RestClientException")
    public void testUpdateIndicatorForRestClientException() throws Exception {
        prepareMocks();
        Mockito.when(apiClient.updateIndicatorAsBodyWithHttpInfo(Mockito.anyString(), Mockito.any(IndicatorPUTInputType.class)))
                .thenThrow(new RestClientException("Error while requesting DataManagement API"));
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        indicatorUpdateBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/indicators/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(new ObjectMapper().writeValueAsString(indicatorUpdateBody)))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    private static UpdateIndicatorPOSTInputType createGeoresourceUpdateType() {
        UpdateIndicatorPOSTInputType indicatorUpdate = new UpdateIndicatorPOSTInputType();
        IndicatorPUTInputType indicatorPutBody = new IndicatorPUTInputType();

        indicatorPutBody.setApplicableSpatialUnit("testSpatialUnitId");

        indicatorUpdate.setIndicatorPutBody(indicatorPutBody);
        indicatorUpdate.setIndicatorId(RESOURCE_ID);

        ConverterDefinitionType converter = new ConverterDefinitionType();
        converter.setName("testConverter");
        converter.setMimeType("application/xml");
        indicatorUpdate.setConverter(converter);

        DataSourceDefinitionType dataSource = new DataSourceDefinitionType();
        dataSource.setType(DataSourceDefinitionType.TypeEnum.DB);
        indicatorUpdate.setDataSource(dataSource);

        IndicatorPropertyMappingType mapping = new IndicatorPropertyMappingType();
        mapping.setSpatialReferenceKeyProperty("refProp");

        TimeseriesMappingType timeseriesMapping = new TimeseriesMappingType();
        timeseriesMapping.setIndicatorValueProperty("valProp");
        timeseriesMapping.setTimestampProperty("timestampProp");
        mapping.setTimeseriesMappings(Arrays.asList(timeseriesMapping));
        mapping.setKeepMissingOrNullValueIndicator(true);

        indicatorUpdate.setPropertyMapping(mapping);

        return indicatorUpdate;

    }

    private void prepareMocks() throws ConverterException, ImportParameterException, JsonProcessingException, DataSourceRetrieverException {
        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenReturn(Mockito.mock(Dataset.class));

        IndicatorValue indicator = new IndicatorValue();

        Mockito.when(converter.convertIndicators(
                Mockito.any(ConverterDefinitionType.class),
                Mockito.any(Dataset.class),
                Mockito.any(IndicatorPropertyMappingType.class)))
                .thenReturn(Arrays.asList(indicator));
        Mockito.when(validator.isValid(Mockito.eq(indicator), Mockito.anyBoolean())).thenReturn(true);

        HttpHeaders headers = new HttpHeaders();
        headers.add("location", RESOURCE_ID);

        Mockito.when(apiClient.addIndicatorAsBodyWithHttpInfo(Mockito.any()))
                .thenReturn(new ResponseEntity<>(headers, HttpStatus.CREATED));
        Mockito.when(apiClient.updateIndicatorAsBodyWithHttpInfo(Mockito.anyString(), Mockito.any(IndicatorPUTInputType.class)))
                .thenReturn(new ResponseEntity<Void>(headers, HttpStatus.OK));

        Mockito.when(encoder.encode(Mockito.any(UpdateIndicatorPOSTInputType.class), Mockito.anyList()))
                .thenReturn(Mockito.mock(IndicatorPUTInputType.class));
        Mockito.when(validator.isValid(Mockito.any(IndicatorValue.class), Mockito.eq(false))).thenReturn(true);
    }


}

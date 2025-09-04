package org.n52.kommonitor.importer.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;
import org.n52.kommonitor.importer.api.encoder.SpatialResourceJsonEncoder;
import org.n52.kommonitor.importer.api.handler.ApiExceptionHandler;
import org.n52.kommonitor.importer.api.handler.RequestHandlerRepository;
import org.n52.kommonitor.importer.api.handler.SpatialUnitImportHandler;
import org.n52.kommonitor.importer.api.handler.SpatialUnitUpdateHandler;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.SpatialResource;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(GeoresourcesApiController.class)
@ContextConfiguration(classes = {SpatialUnitsApiController.class, RequestHandlerRepository.class, SpatialUnitImportHandler.class, SpatialUnitUpdateHandler.class, ApiExceptionHandler.class})
public class SpatialUnitApiControllerIT {
    private static final String RESOURCE_ID = "testID";
    private static final String BASE_PATH = "/importer";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConverterRepository converterRepository;

    @MockBean
    private AbstractConverter converter;

    @MockBean
    private DataSourceRetrieverRepository retrieverRepository;

    @MockBean
    private AbstractDataSourceRetriever<?> retriever;

    @MockBean
    private SpatialResourceJsonEncoder encoder;

    @MockBean
    private SpatialUnitsApi apiClient;

    @MockBean
    private EntityValidator validator;

    @MockBean
    private ImportMonitor monitor;

    private static ImportSpatialUnitPOSTInputType spatialUnitImportBody;

    private static UpdateSpatialUnitPOSTInputType spatialUnitUpdateBody;

    private static ObjectMapper mapper;

    @BeforeAll
    static void init() {
        spatialUnitImportBody = createSpatialUnitImportType();
        spatialUnitUpdateBody = createSpatialUnitUpdateType();
        mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Test
    @DisplayName("Test importSpatialUnit responds with 200 status code")
    public void testImportSpatialUnit() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        spatialUnitImportBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(spatialUnitImportBody)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.uri").value(RESOURCE_ID));
    }

    @Test
    @DisplayName("Test importSpatialUnit dry run responds with 200 status code and resource uri is empty")
    public void testImportSpatialUnitDryRun() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        spatialUnitImportBody.setDryRun(true);

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(spatialUnitImportBody)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.uri").isEmpty());
    }

    @Test
    @DisplayName("Test importSpatialUnit responds with 400 status code for non valid request content")
    public void testImportSpatialUnitForNonValidRequestContent() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        JsonNode json = mapper.valueToTree(spatialUnitImportBody);
        ((ObjectNode) json.get("dataSource")).put("type", "invalidType");
        ((ObjectNode) json).set("metadata", null);
        spatialUnitImportBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(json.toString()))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @DisplayName("Test importSpatialUnit responds with 400 status code for ImportParameterException")
    public void testImportSpatialUnitForImportParameterException() throws Exception {
        prepareMocks();
        spatialUnitImportBody.setDryRun(false);

        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenThrow(new ImportParameterException("Missing parameter: testParam"));
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(spatialUnitImportBody)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @DisplayName("Test importSpatialUnit responds with 500 status code for DataSourceRetrieverException")
    public void testImportSpatialUnitForDataSourceRetrieverException() throws Exception {
        prepareMocks();
        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenThrow(new DataSourceRetrieverException("Error while fetching data."));
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        spatialUnitImportBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(spatialUnitImportBody)))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @Test
    @DisplayName("Test importSpatialUnit responds with 500 status code for RestClientException")
    public void testImportSpatialUnitForRestClientException() throws Exception {
        prepareMocks();
        Mockito.when(apiClient.addSpatialUnitAsBodyWithHttpInfo(Mockito.any()))
                .thenThrow(new RestClientException("Error while requesting DataManagement API"));
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        spatialUnitImportBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(spatialUnitImportBody)))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @Test
    @DisplayName("Test updateSpatialUnit responds with 200 status code")
    public void testUpdateSpatialUnit() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        spatialUnitUpdateBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(spatialUnitUpdateBody)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.uri").value(RESOURCE_ID));
    }

    @Test
    @DisplayName("Test updateSpatialUnit dry run responds with 200 status code and resource uri is empty")
    public void testUpdateSpatialUnitDryRun() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        spatialUnitUpdateBody.setDryRun(true);

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(spatialUnitUpdateBody)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.uri").isEmpty());
    }

    @Test
    @DisplayName("Test updateSpatialUnit responds with 400 status code for non valid request content")
    public void testUpdateSpatialUnitForNonValidRequestContent() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        JsonNode json = mapper.valueToTree(spatialUnitUpdateBody);
        ((ObjectNode) json.get("dataSource")).put("type", "invalidType");
        ((ObjectNode) json).set("metadata", null);
        spatialUnitUpdateBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(json.toString()))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @DisplayName("Test updateSpatialUnit responds with 400 status code for ImportParameterException")
    public void testUpdateSpatialUnitForImportParameterException() throws Exception {
        prepareMocks();
        spatialUnitUpdateBody.setDryRun(false);

        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenThrow(new ImportParameterException("Missing parameter: testParam"));
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(spatialUnitUpdateBody)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @DisplayName("Test updateSpatialUnit responds with 500 status code for DataSourceRetrieverException")
    public void testUpdateSpatialUnitForDataSourceRetrieverException() throws Exception {
        prepareMocks();
        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenThrow(new DataSourceRetrieverException("Error while fetching data."));
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        spatialUnitUpdateBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(spatialUnitUpdateBody)))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @Test
    @DisplayName("Test updateSpatialUnit responds with 500 status code for RestClientException")
    public void testUpdateSpatialUnitForRestClientException() throws Exception {
        prepareMocks();
        Mockito.when(apiClient.updateSpatialUnitAsBodyWithHttpInfo(Mockito.anyString(), Mockito.any(SpatialUnitPUTInputType.class)))
                .thenThrow(new RestClientException("Error while requesting DataManagement API"));
        Mockito.when(retrieverRepository.getDataSourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        spatialUnitUpdateBody.setDryRun(false);

        this.mockMvc.perform(post(BASE_PATH + "/spatial-units/update")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(spatialUnitUpdateBody)))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    private static ImportSpatialUnitPOSTInputType createSpatialUnitImportType() {
        ImportSpatialUnitPOSTInputType spatialUnitImport = new ImportSpatialUnitPOSTInputType();
        SpatialUnitPOSTInputType spatialUnitPostBody = new SpatialUnitPOSTInputType();

        CommonMetadataType meta = new CommonMetadataType();
        meta.setDescription("metadataDescription");
        meta.setSridEPSG(BigDecimal.valueOf(45326));
        meta.setDatasource("metadataDatasource");
        meta.setContact("metadataContact");
        meta.setUpdateInterval(CommonMetadataType.UpdateIntervalEnum.ARBITRARY);
        spatialUnitPostBody.setMetadata(meta);

        PeriodOfValidityType periodOfValidity = new PeriodOfValidityType();
        periodOfValidity.setStartDate(LocalDate.now());
        periodOfValidity.setEndDate(LocalDate.now());
        spatialUnitPostBody.setPeriodOfValidity(periodOfValidity);

        spatialUnitPostBody.setSpatialUnitLevel("testLevel");

        spatialUnitImport.setSpatialUnitPostBody(spatialUnitPostBody);

        ConverterDefinitionType converter = new ConverterDefinitionType();
        converter.setName("testConverter");
        converter.setMimeType("application/xml");
        spatialUnitImport.setConverter(converter);

        DataSourceDefinitionType dataSource = new DataSourceDefinitionType();
        dataSource.setType(DataSourceDefinitionType.TypeEnum.DB);
        spatialUnitImport.setDataSource(dataSource);

        SpatialResourcePropertyMappingType mapping = new SpatialResourcePropertyMappingType();
        mapping.setIdentifierProperty("idProp");
        mapping.setNameProperty("nameProp");
        mapping.setKeepAttributes(false);
        mapping.setKeepMissingOrNullValueAttributes(true);
        spatialUnitImport.setPropertyMapping(mapping);

        return spatialUnitImport;
    }

    private static UpdateSpatialUnitPOSTInputType createSpatialUnitUpdateType() {
        UpdateSpatialUnitPOSTInputType spatialUnitUpdate = new UpdateSpatialUnitPOSTInputType();
        SpatialUnitPUTInputType spatialUnitPutBody = new SpatialUnitPUTInputType();

        spatialUnitUpdate.setSpatialUnitId(RESOURCE_ID);

        PeriodOfValidityType periodOfValidity = new PeriodOfValidityType();
        periodOfValidity.setStartDate(LocalDate.now());
        periodOfValidity.setEndDate(LocalDate.now());
        spatialUnitPutBody.setPeriodOfValidity(periodOfValidity);

        spatialUnitUpdate.setSpatialUnitPutBody(spatialUnitPutBody);

        ConverterDefinitionType converter = new ConverterDefinitionType();
        converter.setName("testConverter");
        converter.setMimeType("application/xml");
        spatialUnitUpdate.setConverter(converter);

        DataSourceDefinitionType dataSource = new DataSourceDefinitionType();
        dataSource.setType(DataSourceDefinitionType.TypeEnum.DB);
        spatialUnitUpdate.setDataSource(dataSource);

        SpatialResourcePropertyMappingType mapping = new SpatialResourcePropertyMappingType();
        mapping.setIdentifierProperty("idProp");
        mapping.setNameProperty("nameProp");
        mapping.setKeepAttributes(false);
        mapping.setKeepMissingOrNullValueAttributes(true);
        spatialUnitUpdate.setPropertyMapping(mapping);

        return spatialUnitUpdate;
    }

    private void prepareMocks() throws ConverterException, ImportParameterException, JsonProcessingException, DataSourceRetrieverException {
        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenReturn(Mockito.mock(Dataset.class));

        Mockito.when(converter.convertSpatialResources(
                Mockito.any(ConverterDefinitionType.class),
                Mockito.any(Dataset.class),
                Mockito.any(SpatialResourcePropertyMappingType.class)))
                .thenReturn(Arrays.asList(new SpatialResource()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", RESOURCE_ID);
        Mockito.when(apiClient.addSpatialUnitAsBodyWithHttpInfo(Mockito.any())).thenReturn(new ResponseEntity<>(headers, HttpStatus.CREATED));
        Mockito.when(apiClient.updateSpatialUnitAsBodyWithHttpInfo(Mockito.anyString(), Mockito.any(SpatialUnitPUTInputType.class))).thenReturn(new ResponseEntity<Void>(headers, HttpStatus.OK));

        SpatialUnitPOSTInputType spatialUnit = Mockito.mock(SpatialUnitPOSTInputType.class);
        Mockito.when(spatialUnit.getSpatialUnitLevel()).thenReturn("testLevel");

        Mockito.when(encoder.encodeSpatialResourcesAsString(Mockito.anyList())).thenReturn("");
        Mockito.when(validator.isValid(Mockito.any(SpatialResource.class))).thenReturn(true);
    }

}

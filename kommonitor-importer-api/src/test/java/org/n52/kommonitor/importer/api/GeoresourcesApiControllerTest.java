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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;
import org.n52.kommonitor.importer.api.encoder.GeoresourceEncoder;
import org.n52.kommonitor.importer.api.handler.GeoresourceImportHandler;
import org.n52.kommonitor.importer.api.handler.ImportExceptionHandler;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
import org.n52.kommonitor.importer.models.*;
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
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(GeoresourcesApiController.class)
@ContextConfiguration(classes = {GeoresourcesApiController.class, GeoresourceImportHandler.class, ImportExceptionHandler.class})
public class GeoresourcesApiControllerTest {

    private static final String CREATED_RESOURCE_ID = "testID";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GeoresourceImportHandler handler;

    @MockBean
    private ConverterRepository converterRepository;

    @MockBean
    private AbstractConverter converter;

    @MockBean
    private DataSourceRetrieverRepository retrieverRepository;

    @MockBean
    private AbstractDataSourceRetriever retriever;

    @MockBean
    private GeoresourceEncoder encoder;

    @MockBean
    private GeoresourcesApi apiClient;

    private static ImportGeoresourcePOSTInputType geoImportBody;

    private static ObjectMapper mapper;

    @BeforeAll
    static void init() {
        geoImportBody = createGeoresourceImportType();
        mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Test
    @DisplayName("Test importGeoresource responds with 201 status code")
    public void testImportGeoresource() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDatasourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));

        this.mockMvc.perform(post("/georesources")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(geoImportBody)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.[0]").value(CREATED_RESOURCE_ID));
    }

    @Test
    @DisplayName("Test importGeoresource responds with 400 status code for non valid request content")
    public void testImportGeoresourceForNonValidRequestContent() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDatasourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        JsonNode json = mapper.valueToTree(geoImportBody);
        ((ObjectNode) json.get("dataSource")).put("type", "invalidType");
        ((ObjectNode) json).set("metadata", null);

        this.mockMvc.perform(post("/georesources")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(json.toString()))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @DisplayName("Test importGeoresource responds with 400 status code for ImportParameterException")
    public void testImportGeoresourceForImportParameterException() throws Exception {
        prepareMocks();

        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenThrow(new ImportParameterException("Missing parameter: testParam"));
        Mockito.when(retrieverRepository.getDatasourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));

        this.mockMvc.perform(post("/georesources")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(geoImportBody)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @DisplayName("Test importGeoresource responds with 500 status code for DataSourceRetrieverException")
    public void testImportGeoresourceForDataSourceRetrieverException() throws Exception {
        prepareMocks();
        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenThrow(new DataSourceRetrieverException("Error while fetching data."));
        Mockito.when(retrieverRepository.getDatasourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));

        this.mockMvc.perform(post("/georesources")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(geoImportBody)))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @Test
    @DisplayName("Test importGeoresource responds with 500 status code for RestClientException")
    public void testImportGeoresourceForRestClientException() throws Exception {
        prepareMocks();
        Mockito.when(apiClient.addGeoresourceAsBodyWithHttpInfo(Mockito.any()))
                .thenThrow(new RestClientException("Error while requesting DataManagement API"));
        Mockito.when(retrieverRepository.getDatasourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));

        this.mockMvc.perform(post("/georesources")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(mapper.writeValueAsString(geoImportBody)))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    private static ImportGeoresourcePOSTInputType createGeoresourceImportType() {
        ImportGeoresourcePOSTInputType geoImport = new ImportGeoresourcePOSTInputType();

        GeoresourcePOSTInputType geoPostBody = new GeoresourcePOSTInputType();
        geoPostBody.setDatasetName("testDataset");

        PeriodOfValidityType pov = new PeriodOfValidityType();
        pov.setStartDate(LocalDate.now());
        pov.setEndDate(LocalDate.now());
        geoPostBody.setPeriodOfValidity(pov);

        CommonMetadataType meta = new CommonMetadataType();
        meta.setDescription("metadataDescription");
        meta.setSridEPSG(BigDecimal.valueOf(45326));
        meta.setDatasource("metadataDatasource");
        meta.setContact("metadataContact");
        meta.setUpdateInterval(CommonMetadataType.UpdateIntervalEnum.ARBITRARY);
        geoPostBody.setMetadata(meta);

        geoImport.setGeoresourcePostBody(geoPostBody);

        DataSourceDefinitionType dataSource = new DataSourceDefinitionType();
        dataSource.setType(DataSourceDefinitionType.TypeEnum.DB);
        geoImport.setDataSource(dataSource);

        ConverterDefinitionType converter = new ConverterDefinitionType();
        converter.setName("testConverter");
        converter.setMimeType("application/xml");
        geoImport.setConverter(converter);

        SpatialResourcePropertyMappingType mapping = new SpatialResourcePropertyMappingType();
        mapping.setIdentifierProperty("idProp");
        mapping.setNameProperty("nameProp");
        geoImport.setPropertyMapping(mapping);

        return geoImport;
    }

    private void prepareMocks() throws ConverterException, ImportParameterException, JsonProcessingException {
        Mockito.when(converter.convertSpatialResources(
                Mockito.any(ConverterDefinitionType.class),
                Mockito.any(Dataset.class),
                Mockito.any(SpatialResourcePropertyMappingType.class)))
                .thenReturn(Arrays.asList(new SpatialResource()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", CREATED_RESOURCE_ID);
        ResponseEntity<Void> response = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        Mockito.when(apiClient.addGeoresourceAsBodyWithHttpInfo(Mockito.any())).thenReturn(response);

        GeoresourcePOSTInputType geo = Mockito.mock(GeoresourcePOSTInputType.class);
        Mockito.when(geo.getDatasetName()).thenReturn("testDataset");

        Mockito.when(encoder.encode(Mockito.any(ImportGeoresourcePOSTInputType.class), Mockito.anyList())).thenReturn(geo);
    }
}

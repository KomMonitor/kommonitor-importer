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
import org.n52.kommonitor.importer.api.handler.ImportExceptionHandler;
import org.n52.kommonitor.importer.api.handler.IndicatorImportHandler;
import org.n52.kommonitor.importer.api.handler.IndicatorUpdateHandler;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(IndicatorsApiController.class)
@ContextConfiguration(classes = {IndicatorsApiController.class, IndicatorImportHandler.class, IndicatorUpdateHandler.class, ImportExceptionHandler.class})
public class IndicatorsApiControllerTest {

    private static final String CREATED_RESOURCE_ID = "testID";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConverterRepository converterRepository;

    @MockBean
    private AbstractConverter converter;

    @MockBean
    private DataSourceRetrieverRepository retrieverRepository;

    @MockBean
    private AbstractDataSourceRetriever retriever;

    @MockBean
    private IndicatorEncoder encoder;

    @MockBean
    private IndicatorsApi apiClient;

    private static ImportIndicatorPOSTInputType indicatorImportBody;

    @BeforeAll
    static void init() {
        indicatorImportBody = createGeoresourceImportType();
    }

    @Test
    @DisplayName("Test importIndicator responds with 201 status code")
    public void testImportIndicator() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDatasourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));

        this.mockMvc.perform(post("/indicators")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(new ObjectMapper().writeValueAsString(indicatorImportBody)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.[0]").value(CREATED_RESOURCE_ID));
    }

    @Test
    @DisplayName("Test importIndicator responds with 400 status code for non valid request content")
    public void testImportIndicatorForNonValidRequestContent() throws Exception {
        prepareMocks();
        Mockito.when(retrieverRepository.getDatasourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));
        JsonNode json = new ObjectMapper().valueToTree(indicatorImportBody);
        ((ObjectNode) json.get("dataSource")).put("type", "invalidType");
        ((ObjectNode) json).set("metadata", null);

        this.mockMvc.perform(post("/indicators")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(json.toString()))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @DisplayName("Test importIndicator responds with 400 status code for ImportParameterException")
    public void testImportIndicatorForImportParameterException() throws Exception {
        prepareMocks();

        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenThrow(new ImportParameterException("Missing parameter: testParam"));
        Mockito.when(retrieverRepository.getDatasourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));

        this.mockMvc.perform(post("/indicators")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(new ObjectMapper().writeValueAsString(indicatorImportBody)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @DisplayName("Test importIndicators responds with 500 status code for DataSourceRetrieverException")
    public void testImportIndicatorForDataSourceRetrieverException() throws Exception {
        prepareMocks();
        Mockito.when(retriever.retrieveDataset(Mockito.any(DataSourceDefinitionType.class)))
                .thenThrow(new DataSourceRetrieverException("Error while fetching data."));
        Mockito.when(retrieverRepository.getDatasourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));

        this.mockMvc.perform(post("/indicators")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(new ObjectMapper().writeValueAsString(indicatorImportBody)))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @Test
    @DisplayName("Test importIndicator responds with 500 status code for RestClientException")
    public void testImportIndicatorForRestClientException() throws Exception {
        prepareMocks();
        Mockito.when(apiClient.addIndicatorAsBodyWithHttpInfo(Mockito.any()))
                .thenThrow(new RestClientException("Error while requesting DataManagement API"));
        Mockito.when(retrieverRepository.getDatasourceRetriever(Mockito.anyString())).thenReturn(Optional.of(retriever));
        Mockito.when(converterRepository.getConverter(Mockito.anyString())).thenReturn(Optional.of(converter));

        this.mockMvc.perform(post("/indicators")
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .content(new ObjectMapper().writeValueAsString(indicatorImportBody)))
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(ContentType.APPLICATION_JSON.getMimeType()))
                .andExpect(jsonPath("$.code").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }


    private static ImportIndicatorPOSTInputType createGeoresourceImportType() {
        ImportIndicatorPOSTInputType indicatorImport = new ImportIndicatorPOSTInputType();
        IndicatorPOSTInputType indicatorPostBody = new IndicatorPOSTInputType();

        CommonMetadataType meta = new CommonMetadataType();
        meta.setDescription("metadataDescription");
        meta.setSridEPSG(BigDecimal.valueOf(45326));
        meta.setDatasource("metadataDatasource");
        meta.setContact("metadataContact");
        meta.setUpdateInterval(CommonMetadataType.UpdateIntervalEnum.ARBITRARY);
        indicatorPostBody.setMetadata(meta);

        indicatorPostBody.setAbbreviation("testAbr");
        indicatorPostBody.setAllowedRoles(Arrays.asList("testRole"));
        indicatorPostBody.setApplicableSpatialUnit("testSpatialUnitId");

        ConverterDefinitionType converter = new ConverterDefinitionType();
        converter.setName("testConverter");
        converter.setMimeType("application/xml");
        indicatorImport.setConverter(converter);

        indicatorPostBody.setCreationType(IndicatorPOSTInputType.CreationTypeEnum.INSERTION);
        indicatorPostBody.setDatasetName("testDataset");

        DataSourceDefinitionType dataSource = new DataSourceDefinitionType();
        dataSource.setType(DataSourceDefinitionType.TypeEnum.DB);
        indicatorImport.setDataSource(dataSource);

        DefaultClassificationMappingItemType classItemMapping = new DefaultClassificationMappingItemType();
        classItemMapping.setDefaultColorAsHex("#2f8f67");
        classItemMapping.setDefaultCustomRating("testRating");
        DefaultClassificationMappingType classMapping = new DefaultClassificationMappingType();
        classMapping.setColorBrewerSchemeName("testColorSchema");
        classMapping.setItems(Arrays.asList(classItemMapping));
        indicatorPostBody.setDefaultClassificationMapping(classMapping);

        indicatorPostBody.setIndicatorType(IndicatorPOSTInputType.IndicatorTypeEnum.STATUS_ABSOLUTE);
        indicatorPostBody.setInterpretation("testInterpretation");
        indicatorPostBody.setIsHeadlineIndicator(false);
        indicatorPostBody.setLowestSpatialUnitForComputation("testId");
        indicatorPostBody.setProcessDescription("testProcessDesc");
        indicatorPostBody.setTags(Collections.EMPTY_LIST);
        indicatorPostBody.setUnit("testUnit");
        indicatorPostBody.setTopicReference("testRef");

        indicatorImport.setIndicatorPostBody(indicatorPostBody);

        IndicatorPropertyMappingType mapping = new IndicatorPropertyMappingType();
        mapping.setSpatialReferenceKeyProperty("refProp");
        mapping.setIndicatorValueProperty("valProp");
        mapping.setTimestampProperty("timestampProp");
        indicatorImport.setPropertyMapping(mapping);

        return indicatorImport;
    }

    private void prepareMocks() throws ConverterException, ImportParameterException, JsonProcessingException {
        Mockito.when(converter.convertIndicators(
                Mockito.any(ConverterDefinitionType.class),
                Mockito.any(Dataset.class),
                Mockito.any(IndicatorPropertyMappingType.class)))
                .thenReturn(Arrays.asList(new IndicatorValue()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", CREATED_RESOURCE_ID);
        ResponseEntity<Void> response = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        Mockito.when(apiClient.addIndicatorAsBodyWithHttpInfo(Mockito.any())).thenReturn(response);

        IndicatorPOSTInputType indicator = Mockito.mock(IndicatorPOSTInputType.class);
        Mockito.when(indicator.getDatasetName()).thenReturn("testDataset");

        Mockito.when(encoder.encode(Mockito.any(ImportIndicatorPOSTInputType.class), Mockito.anyList())).thenReturn(indicator);
    }


}

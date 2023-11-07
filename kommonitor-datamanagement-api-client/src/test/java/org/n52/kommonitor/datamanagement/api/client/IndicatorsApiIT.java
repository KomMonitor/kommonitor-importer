/*
 * KomMonitor Data Access API
 * erster Entwurf einer Datenzugriffs-API, die den Zugriff auf die KomMonitor-Datenhaltungsschicht kapselt.
 *
 * OpenAPI spec version: 0.0.1
 * Contact: christian.danowski-buhren@hs-bochum.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.n52.kommonitor.datamanagement.api.client;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

/**
 * API tests for IndicatorsApi
 */
@RestClientTest(IndicatorsApi.class)
@ContextConfiguration(classes = {ApiClient.class, IndicatorsApi.class, RestTemplate.class})
public class IndicatorsApiIT {

    private static final String BASE_PATH = "http://localhost:8085/management";

    @Autowired
    private IndicatorsApi api;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    private MockRestServiceServer mockServer;

    @BeforeEach
    private void init() throws IOException {
        api.getApiClient().setBasePath(BASE_PATH);
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }


    /**
     * Add a new indicator dataset
     * <p>
     * Add/Register an indicator dataset for a certain period of time and spatial unit/level
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void addIndicatorAsBodyTest() {
        HttpHeaders headers = new HttpHeaders();
        mockServer.expect(ExpectedCount.once(),
                requestTo(BASE_PATH + "/indicators"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.CREATED)
                );

        api.addIndicatorAsBody(Mockito.mock(IndicatorPOSTInputType.class));

        mockServer.verify();
    }

    /**
     * Delete the features/contents of the selected indicator dataset
     * <p>
     * Delete the features/contents of the selected indicator dataset
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    @Disabled
    public void deleteIndicatorByIdTest() {
        String indicatorId = null;
        api.deleteIndicatorById(indicatorId);

        // TODO: test validations
    }

    /**
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * <p>
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    @Disabled
    public void deleteIndicatorByIdAndSpatialUnitIdTest() {
        String indicatorId = null;
        String spatialUnitId = null;
        api.deleteIndicatorByIdAndSpatialUnitId(indicatorId, spatialUnitId);

        // TODO: test validations
    }

    /**
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * <p>
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    @Disabled
    public void deleteIndicatorByIdAndYearAndMonthTest() {
        String indicatorId = null;
        String spatialUnitId = null;
        BigDecimal year = null;
        BigDecimal month = null;
        BigDecimal day = null;
        api.deleteIndicatorByIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day);

        // TODO: test validations
    }

    /**
     * retrieve information about the selected indicator
     * <p>
     * retrieve information about the selected indicator
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    @Disabled
    public void getIndicatorByIdTest() {
        String indicatorId = null;
        IndicatorOverviewType response = api.getIndicatorById(indicatorId);

        // TODO: test validations
    }

    /**
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * <p>
     * retrieve the indicator for the selected spatial unit as GeoJSON
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    @Disabled
    public void getIndicatorBySpatialUnitIdAndIdTest() {
        String indicatorId = null;
        String spatialUnitId = null;
        String simplifyGeometries = null;
        byte[] response = api.getIndicatorBySpatialUnitIdAndId(indicatorId, spatialUnitId, simplifyGeometries);

        // TODO: test validations
    }

    /**
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * <p>
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    @Disabled
    public void getIndicatorBySpatialUnitIdAndIdAndYearAndMonthTest() {
        String indicatorId = null;
        String spatialUnitId = null;
        BigDecimal year = null;
        BigDecimal month = null;
        BigDecimal day = null;
        String simplifyGeometries = null;
        byte[] response = api.getIndicatorBySpatialUnitIdAndIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day, simplifyGeometries);

        // TODO: test validations
    }

    /**
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * <p>
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    @Disabled
    public void getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometryTest() {
        String indicatorId = null;
        String spatialUnitId = null;
        BigDecimal year = null;
        BigDecimal month = null;
        BigDecimal day = null;
        List<IndicatorPropertiesWithoutGeomType> response = api.getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(indicatorId, spatialUnitId, year, month, day);

        // TODO: test validations
    }

    /**
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * <p>
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    @Disabled
    public void getIndicatorBySpatialUnitIdAndIdWithoutGeometryTest() {
        String indicatorId = null;
        String spatialUnitId = null;
        List<IndicatorPropertiesWithoutGeomType> response = api.getIndicatorBySpatialUnitIdAndIdWithoutGeometry(indicatorId, spatialUnitId);

        // TODO: test validations
    }

    /**
     * retrieve information about available indicators
     * <p>
     * retrieve information about available indicators
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getIndicatorsTest() throws JsonProcessingException {
        IndicatorOverviewType indicator = new IndicatorOverviewType();
        indicator.setIndicatorId("testId");

        mockServer.expect(ExpectedCount.once(),
                requestTo(BASE_PATH + "/indicators"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(Arrays.asList(indicator)))
                );

        List<IndicatorOverviewType> response = api.getIndicators();

        mockServer.verify();
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals("testId", response.get(0).getIndicatorId());
    }

    /**
     * Modify/Update the contents of the selected indicator dataset
     * <p>
     * Modify/Update the contents of the selected indicator dataset
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateIndicatorAsBodyTest() {
        String resourceId = "testId";

        HttpHeaders headers = new HttpHeaders();
        mockServer.expect(ExpectedCount.once(),
                requestTo(BASE_PATH + "/indicators/" + resourceId))
                .andExpect(method(HttpMethod.PUT))
                .andRespond(withStatus(HttpStatus.OK)
                );

        api.updateIndicatorAsBodyWithHttpInfo(resourceId, Mockito.mock(IndicatorPUTInputType.class));

        mockServer.verify();
    }

    /**
     * Modify/Update the metadata of the selected indicator dataset
     * <p>
     * Modify/Update the metadata of the selected indicator dataset. This replaces the formerly stored metadata.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    @Disabled
    public void updateIndicatorMetadataAsBodyTest() {
        String indicatorId = null;
        IndicatorPATCHInputType metadata = null;
        api.updateIndicatorMetadataAsBody(indicatorId, metadata);

        // TODO: test validations
    }

}
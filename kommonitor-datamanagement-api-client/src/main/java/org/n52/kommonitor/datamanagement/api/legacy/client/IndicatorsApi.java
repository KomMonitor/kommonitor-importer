package org.n52.kommonitor.datamanagement.api.legacy.client;

import org.n52.kommonitor.datamanagement.api.legacy.ApiClient;

import java.math.BigDecimal;

import org.n52.kommonitor.models.IndicatorOverviewType;
import org.n52.kommonitor.models.IndicatorPATCHInputType;
import org.n52.kommonitor.models.IndicatorPOSTInputType;
import org.n52.kommonitor.models.IndicatorPUTInputType;
import org.n52.kommonitor.models.IndicatorPropertiesWithoutGeomType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-01-13T17:05:28.208+01:00")
@Component("org.n52.kommonitor.datamanagement.api.client.IndicatorsApi")
public class IndicatorsApi {
    private ApiClient apiClient;

    public IndicatorsApi() {
        this(new ApiClient());
    }

    @Autowired
    public IndicatorsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Add a new indicator dataset
     * Add/Register an indicator dataset for a certain period of time and spatial unit/level
     * <p><b>201</b> - Created
     * <p><b>405</b> - Invalid input
     * @param indicatorData indicator data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void addIndicatorAsBody(IndicatorPOSTInputType indicatorData) throws RestClientException {
        addIndicatorAsBodyWithHttpInfo(indicatorData);
    }

    /**
     * Add a new indicator dataset
     * Add/Register an indicator dataset for a certain period of time and spatial unit/level
     * <p><b>201</b> - Created
     * <p><b>405</b> - Invalid input
     * @param indicatorData indicator data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> addIndicatorAsBodyWithHttpInfo(IndicatorPOSTInputType indicatorData) throws RestClientException {
        Object postBody = indicatorData;
        
        // verify the required parameter 'indicatorData' is set
        if (indicatorData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorData' when calling addIndicatorAsBody");
        }
        
        String path = UriComponentsBuilder.fromPath("/indicators").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete the features/contents of the selected indicator dataset
     * Delete the features/contents of the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteIndicatorById(String indicatorId) throws RestClientException {
        deleteIndicatorByIdWithHttpInfo(indicatorId);
    }

    /**
     * Delete the features/contents of the selected indicator dataset
     * Delete the features/contents of the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteIndicatorByIdWithHttpInfo(String indicatorId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling deleteIndicatorById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        String path = UriComponentsBuilder.fromPath("/indicators/{indicatorId}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteIndicatorByIdAndSpatialUnitId(String indicatorId, String spatialUnitId) throws RestClientException {
        deleteIndicatorByIdAndSpatialUnitIdWithHttpInfo(indicatorId, spatialUnitId);
    }

    /**
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteIndicatorByIdAndSpatialUnitIdWithHttpInfo(String indicatorId, String spatialUnitId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling deleteIndicatorByIdAndSpatialUnitId");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteIndicatorByIdAndSpatialUnitId");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        String path = UriComponentsBuilder.fromPath("/indicators/{indicatorId}/{spatialUnitId}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteIndicatorByIdAndYearAndMonth(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        deleteIndicatorByIdAndYearAndMonthWithHttpInfo(indicatorId, spatialUnitId, year, month, day);
    }

    /**
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteIndicatorByIdAndYearAndMonthWithHttpInfo(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("year", year);
        uriVariables.put("month", month);
        uriVariables.put("day", day);
        String path = UriComponentsBuilder.fromPath("/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve information about the selected indicator
     * retrieve information about the selected indicator
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return IndicatorOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public IndicatorOverviewType getIndicatorById(String indicatorId) throws RestClientException {
        return getIndicatorByIdWithHttpInfo(indicatorId).getBody();
    }

    /**
     * retrieve information about the selected indicator
     * retrieve information about the selected indicator
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return ResponseEntity&lt;IndicatorOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<IndicatorOverviewType> getIndicatorByIdWithHttpInfo(String indicatorId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        String path = UriComponentsBuilder.fromPath("/indicators/{indicatorId}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<IndicatorOverviewType> returnType = new ParameterizedTypeReference<IndicatorOverviewType>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getIndicatorBySpatialUnitIdAndId(String indicatorId, String spatialUnitId, String simplifyGeometries) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdWithHttpInfo(indicatorId, spatialUnitId, simplifyGeometries).getBody();
    }

    /**
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getIndicatorBySpatialUnitIdAndIdWithHttpInfo(String indicatorId, String spatialUnitId, String simplifyGeometries) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorBySpatialUnitIdAndId");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getIndicatorBySpatialUnitIdAndId");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        String path = UriComponentsBuilder.fromPath("/indicators/{indicatorId}/{spatialUnitId}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));

        final String[] accepts = { 
            "application/octed-stream"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<byte[]> returnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getIndicatorBySpatialUnitIdAndIdAndYearAndMonth(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithHttpInfo(indicatorId, spatialUnitId, year, month, day, simplifyGeometries).getBody();
    }

    /**
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithHttpInfo(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("year", year);
        uriVariables.put("month", month);
        uriVariables.put("day", day);
        String path = UriComponentsBuilder.fromPath("/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));

        final String[] accepts = { 
            "application/octed-stream"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<byte[]> returnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return List&lt;IndicatorPropertiesWithoutGeomType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorPropertiesWithoutGeomType> getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometryWithHttpInfo(indicatorId, spatialUnitId, year, month, day).getBody();
    }

    /**
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return ResponseEntity&lt;List&lt;IndicatorPropertiesWithoutGeomType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorPropertiesWithoutGeomType>> getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometryWithHttpInfo(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("year", year);
        uriVariables.put("month", month);
        uriVariables.put("day", day);
        String path = UriComponentsBuilder.fromPath("/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}/without-geometry").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>> returnType = new ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return List&lt;IndicatorPropertiesWithoutGeomType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorPropertiesWithoutGeomType> getIndicatorBySpatialUnitIdAndIdWithoutGeometry(String indicatorId, String spatialUnitId) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdWithoutGeometryWithHttpInfo(indicatorId, spatialUnitId).getBody();
    }

    /**
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;List&lt;IndicatorPropertiesWithoutGeomType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorPropertiesWithoutGeomType>> getIndicatorBySpatialUnitIdAndIdWithoutGeometryWithHttpInfo(String indicatorId, String spatialUnitId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorBySpatialUnitIdAndIdWithoutGeometry");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getIndicatorBySpatialUnitIdAndIdWithoutGeometry");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        String path = UriComponentsBuilder.fromPath("/indicators/{indicatorId}/{spatialUnitId}/without-geometry").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>> returnType = new ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve information about available indicators
     * retrieve information about available indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @return List&lt;IndicatorOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorOverviewType> getIndicators() throws RestClientException {
        return getIndicatorsWithHttpInfo().getBody();
    }

    /**
     * retrieve information about available indicators
     * retrieve information about available indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @return ResponseEntity&lt;List&lt;IndicatorOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorOverviewType>> getIndicatorsWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/indicators").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<List<IndicatorOverviewType>> returnType = new ParameterizedTypeReference<List<IndicatorOverviewType>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Modify/Update the contents of the selected indicator dataset
     * Modify/Update the contents of the selected indicator dataset
     * <p><b>200</b> - OK - Updated
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param indicatorData indicator data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorAsBody(String indicatorId, IndicatorPUTInputType indicatorData) throws RestClientException {
        updateIndicatorAsBodyWithHttpInfo(indicatorId, indicatorData);
    }

    /**
     * Modify/Update the contents of the selected indicator dataset
     * Modify/Update the contents of the selected indicator dataset
     * <p><b>200</b> - OK - Updated
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param indicatorData indicator data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorAsBodyWithHttpInfo(String indicatorId, IndicatorPUTInputType indicatorData) throws RestClientException {
        Object postBody = indicatorData;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling updateIndicatorAsBody");
        }
        
        // verify the required parameter 'indicatorData' is set
        if (indicatorData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorData' when calling updateIndicatorAsBody");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        String path = UriComponentsBuilder.fromPath("/indicators/{indicatorId}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Modify/Update the metadata of the selected indicator dataset
     * Modify/Update the metadata of the selected indicator dataset. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param metadata metadata input (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorMetadataAsBody(String indicatorId, IndicatorPATCHInputType metadata) throws RestClientException {
        updateIndicatorMetadataAsBodyWithHttpInfo(indicatorId, metadata);
    }

    /**
     * Modify/Update the metadata of the selected indicator dataset
     * Modify/Update the metadata of the selected indicator dataset. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param metadata metadata input (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorMetadataAsBodyWithHttpInfo(String indicatorId, IndicatorPATCHInputType metadata) throws RestClientException {
        Object postBody = metadata;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling updateIndicatorMetadataAsBody");
        }
        
        // verify the required parameter 'metadata' is set
        if (metadata == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'metadata' when calling updateIndicatorMetadataAsBody");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        String path = UriComponentsBuilder.fromPath("/indicators/{indicatorId}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}

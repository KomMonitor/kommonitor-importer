package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;

import java.math.BigDecimal;
import org.n52.kommonitor.models.IndicatorMetadataPATCHInputType;
import org.n52.kommonitor.models.IndicatorOverviewType;
import org.n52.kommonitor.models.IndicatorPATCHDisplayOrderInputType;
import org.n52.kommonitor.models.IndicatorPATCHInputType;
import org.n52.kommonitor.models.IndicatorPOSTInputType;
import org.n52.kommonitor.models.IndicatorPUTInputType;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-10T16:49:27.441698800+02:00[Europe/Berlin]")
@Component
public class IndicatorsControllerApi {
    private ApiClient apiClient;

    public IndicatorsControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public IndicatorsControllerApi(ApiClient apiClient) {
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
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorData indicatorData (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Void addIndicatorAsBody(IndicatorPOSTInputType indicatorData) throws RestClientException {
        return addIndicatorAsBodyWithHttpInfo(indicatorData).getBody();
    }

    /**
     * Add a new indicator dataset
     * Add/Register an indicator dataset for a certain period of time and spatial unit/level
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorData indicatorData (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> addIndicatorAsBodyWithHttpInfo(IndicatorPOSTInputType indicatorData) throws RestClientException {
        Object localVarPostBody = indicatorData;
        
        // verify the required parameter 'indicatorData' is set
        if (indicatorData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorData' when calling addIndicatorAsBody");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/management/indicators", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected indicator dataset
     * Delete the features/contents of the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId indicatorId (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Void deleteIndicatorById(String indicatorId) throws RestClientException {
        return deleteIndicatorByIdWithHttpInfo(indicatorId).getBody();
    }

    /**
     * Delete the features/contents of the selected indicator dataset
     * Delete the features/contents of the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId indicatorId (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteIndicatorByIdWithHttpInfo(String indicatorId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling deleteIndicatorById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/management/indicators/{indicatorId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Void deleteIndicatorByIdAndSpatialUnitId(String indicatorId, String spatialUnitId) throws RestClientException {
        return deleteIndicatorByIdAndSpatialUnitIdWithHttpInfo(indicatorId, spatialUnitId).getBody();
    }

    /**
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteIndicatorByIdAndSpatialUnitIdWithHttpInfo(String indicatorId, String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
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

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/management/indicators/{indicatorId}/{spatialUnitId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param day day (required)
     * @param indicatorId indicatorId (required)
     * @param month month (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param year year (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity deleteIndicatorByIdAndYearAndMonth(BigDecimal day, String indicatorId, BigDecimal month, String spatialUnitId, BigDecimal year) throws RestClientException {
        return deleteIndicatorByIdAndYearAndMonthWithHttpInfo(day, indicatorId, month, spatialUnitId, year).getBody();
    }

    /**
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param day day (required)
     * @param indicatorId indicatorId (required)
     * @param month month (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param year year (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseEntity> deleteIndicatorByIdAndYearAndMonthWithHttpInfo(BigDecimal day, String indicatorId, BigDecimal month, String spatialUnitId, BigDecimal year) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("day", day);
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("month", month);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("year", year);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<ResponseEntity> localReturnType = new ParameterizedTypeReference<ResponseEntity>() {};
        return apiClient.invokeAPI("/management/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about the selected indicator
     * retrieve information about the selected indicator
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @param name  (optional)
     * @return IndicatorOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public IndicatorOverviewType getIndicatorById(String indicatorId, String name) throws RestClientException {
        return getIndicatorByIdWithHttpInfo(indicatorId, name).getBody();
    }

    /**
     * retrieve information about the selected indicator
     * retrieve information about the selected indicator
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @param name  (optional)
     * @return ResponseEntity&lt;IndicatorOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<IndicatorOverviewType> getIndicatorByIdWithHttpInfo(String indicatorId, String name) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<IndicatorOverviewType> localReturnType = new ParameterizedTypeReference<IndicatorOverviewType>() {};
        return apiClient.invokeAPI("/management/indicators/{indicatorId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param name  (optional)
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getIndicatorBySpatialUnitIdAndId(String indicatorId, String spatialUnitId, String name, String simplifyGeometries) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdWithHttpInfo(indicatorId, spatialUnitId, name, simplifyGeometries).getBody();
    }

    /**
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param name  (optional)
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getIndicatorBySpatialUnitIdAndIdWithHttpInfo(String indicatorId, String spatialUnitId, String name, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
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

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));

        final String[] localVarAccepts = { 
            "application/octed-stream"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/management/indicators/{indicatorId}/{spatialUnitId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param day day (required)
     * @param indicatorId indicatorId (required)
     * @param month month (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param year year (required)
     * @param name  (optional)
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getIndicatorBySpatialUnitIdAndIdAndYearAndMonth(BigDecimal day, String indicatorId, BigDecimal month, String spatialUnitId, BigDecimal year, String name, String simplifyGeometries) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithHttpInfo(day, indicatorId, month, spatialUnitId, year, name, simplifyGeometries).getBody();
    }

    /**
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param day day (required)
     * @param indicatorId indicatorId (required)
     * @param month month (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param year year (required)
     * @param name  (optional)
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithHttpInfo(BigDecimal day, String indicatorId, BigDecimal month, String spatialUnitId, BigDecimal year, String name, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("day", day);
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("month", month);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("year", year);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));

        final String[] localVarAccepts = { 
            "application/octed-stream"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/management/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param day day (required)
     * @param indicatorId indicatorId (required)
     * @param month month (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param year year (required)
     * @param name  (optional)
     * @return Map&lt;String, String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Map<String, String> getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(BigDecimal day, String indicatorId, BigDecimal month, String spatialUnitId, BigDecimal year, String name) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometryWithHttpInfo(day, indicatorId, month, spatialUnitId, year, name).getBody();
    }

    /**
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param day day (required)
     * @param indicatorId indicatorId (required)
     * @param month month (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param year year (required)
     * @param name  (optional)
     * @return ResponseEntity&lt;Map&lt;String, String&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Map<String, String>> getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometryWithHttpInfo(BigDecimal day, String indicatorId, BigDecimal month, String spatialUnitId, BigDecimal year, String name) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("day", day);
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("month", month);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("year", year);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Map<String, String>> localReturnType = new ParameterizedTypeReference<Map<String, String>>() {};
        return apiClient.invokeAPI("/management/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param name  (optional)
     * @return Map&lt;String, String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Map<String, String> getIndicatorBySpatialUnitIdAndIdWithoutGeometry(String indicatorId, String spatialUnitId, String name) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdWithoutGeometryWithHttpInfo(indicatorId, spatialUnitId, name).getBody();
    }

    /**
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param name  (optional)
     * @return ResponseEntity&lt;Map&lt;String, String&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Map<String, String>> getIndicatorBySpatialUnitIdAndIdWithoutGeometryWithHttpInfo(String indicatorId, String spatialUnitId, String name) throws RestClientException {
        Object localVarPostBody = null;
        
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

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Map<String, String>> localReturnType = new ParameterizedTypeReference<Map<String, String>>() {};
        return apiClient.invokeAPI("/management/indicators/{indicatorId}/{spatialUnitId}/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available indicators
     * retrieve information about available indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param name  (optional)
     * @return IndicatorOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public IndicatorOverviewType getIndicators(String name) throws RestClientException {
        return getIndicatorsWithHttpInfo(name).getBody();
    }

    /**
     * retrieve information about available indicators
     * retrieve information about available indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param name  (optional)
     * @return ResponseEntity&lt;IndicatorOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<IndicatorOverviewType> getIndicatorsWithHttpInfo(String name) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<IndicatorOverviewType> localReturnType = new ParameterizedTypeReference<IndicatorOverviewType>() {};
        return apiClient.invokeAPI("/management/indicators", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the contents of the selected indicator dataset
     * Modify/Update the contents of the selected indicator dataset
     * <p><b>200</b> - OK - Updated
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorId indicatorId (required)
     * @param indicatorData indicatorData (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Void updateIndicatorAsBody(String indicatorId, IndicatorPUTInputType indicatorData) throws RestClientException {
        return updateIndicatorAsBodyWithHttpInfo(indicatorId, indicatorData).getBody();
    }

    /**
     * Modify/Update the contents of the selected indicator dataset
     * Modify/Update the contents of the selected indicator dataset
     * <p><b>200</b> - OK - Updated
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorId indicatorId (required)
     * @param indicatorData indicatorData (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorAsBodyWithHttpInfo(String indicatorId, IndicatorPUTInputType indicatorData) throws RestClientException {
        Object localVarPostBody = indicatorData;
        
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

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/management/indicators/{indicatorId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update displayOrder for submitted indicators
     * Update displayOrder for submitted indicators
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorOrderArray array of indicator id and displayOrder items (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorDisplayOrder(List<IndicatorPATCHDisplayOrderInputType> indicatorOrderArray) throws RestClientException {
        updateIndicatorDisplayOrderWithHttpInfo(indicatorOrderArray);
    }

    /**
     * Update displayOrder for submitted indicators
     * Update displayOrder for submitted indicators
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorOrderArray array of indicator id and displayOrder items (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorDisplayOrderWithHttpInfo(List<IndicatorPATCHDisplayOrderInputType> indicatorOrderArray) throws RestClientException {
        Object localVarPostBody = indicatorOrderArray;
        
        // verify the required parameter 'indicatorOrderArray' is set
        if (indicatorOrderArray == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorOrderArray' when calling updateIndicatorDisplayOrder");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/management/indicators/display-order", HttpMethod.PATCH, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the metadata of the selected indicator dataset
     * Modify/Update the metadata of the selected indicator dataset. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId indicatorId (required)
     * @param metadata metadata (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity updateIndicatorMetadataAsBody(String indicatorId, IndicatorMetadataPATCHInputType metadata) throws RestClientException {
        return updateIndicatorMetadataAsBodyWithHttpInfo(indicatorId, metadata).getBody();
    }

    /**
     * Modify/Update the metadata of the selected indicator dataset
     * Modify/Update the metadata of the selected indicator dataset. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId indicatorId (required)
     * @param metadata metadata (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseEntity> updateIndicatorMetadataAsBodyWithHttpInfo(String indicatorId, IndicatorMetadataPATCHInputType metadata) throws RestClientException {
        Object localVarPostBody = metadata;
        
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

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<ResponseEntity> localReturnType = new ParameterizedTypeReference<ResponseEntity>() {};
        return apiClient.invokeAPI("/management/indicators/{indicatorId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the selected indicator dataset
     * 
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param indicatorData indicatorData (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity updateIndicatorRolesUsingPATCH(String indicatorId, String spatialUnitId, IndicatorPATCHInputType indicatorData) throws RestClientException {
        return updateIndicatorRolesUsingPATCHWithHttpInfo(indicatorId, spatialUnitId, indicatorData).getBody();
    }

    /**
     * Modify/Update the selected indicator dataset
     * 
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param indicatorData indicatorData (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseEntity> updateIndicatorRolesUsingPATCHWithHttpInfo(String indicatorId, String spatialUnitId, IndicatorPATCHInputType indicatorData) throws RestClientException {
        Object localVarPostBody = indicatorData;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling updateIndicatorRolesUsingPATCH");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling updateIndicatorRolesUsingPATCH");
        }
        
        // verify the required parameter 'indicatorData' is set
        if (indicatorData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorData' when calling updateIndicatorRolesUsingPATCH");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/octed-stream"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<ResponseEntity> localReturnType = new ParameterizedTypeReference<ResponseEntity>() {};
        return apiClient.invokeAPI("/management/indicators/{indicatorId}/{spatialUnitId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}

package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;

import java.math.BigDecimal;
import org.n52.kommonitor.models.IndicatorOverviewType;

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
public class IndicatorsPublicControllerApi {
    private ApiClient apiClient;

    public IndicatorsPublicControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public IndicatorsPublicControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * retrieve information about available public indicators
     * retrieve information about available public indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return IndicatorOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public IndicatorOverviewType getIndicators1() throws RestClientException {
        return getIndicators1WithHttpInfo().getBody();
    }

    /**
     * retrieve information about available public indicators
     * retrieve information about available public indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;IndicatorOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<IndicatorOverviewType> getIndicators1WithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<IndicatorOverviewType> localReturnType = new ParameterizedTypeReference<IndicatorOverviewType>() {};
        return apiClient.invokeAPI("/management/public/indicators", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about the selected public indicator
     * retrieve information about the selected public indicator
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @return IndicatorOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public IndicatorOverviewType getPublicIndicatorById(String indicatorId) throws RestClientException {
        return getPublicIndicatorByIdWithHttpInfo(indicatorId).getBody();
    }

    /**
     * retrieve information about the selected public indicator
     * retrieve information about the selected public indicator
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @return ResponseEntity&lt;IndicatorOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<IndicatorOverviewType> getPublicIndicatorByIdWithHttpInfo(String indicatorId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getPublicIndicatorById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<IndicatorOverviewType> localReturnType = new ParameterizedTypeReference<IndicatorOverviewType>() {};
        return apiClient.invokeAPI("/management/public/indicators/{indicatorId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the public indicator for the selected spatial unit as GeoJSON
     * retrieve the public indicator for the selected spatial unit as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getPublicIndicatorBySpatialUnitIdAndId(String indicatorId, String spatialUnitId, String simplifyGeometries) throws RestClientException {
        return getPublicIndicatorBySpatialUnitIdAndIdWithHttpInfo(indicatorId, spatialUnitId, simplifyGeometries).getBody();
    }

    /**
     * retrieve the public indicator for the selected spatial unit as GeoJSON
     * retrieve the public indicator for the selected spatial unit as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getPublicIndicatorBySpatialUnitIdAndIdWithHttpInfo(String indicatorId, String spatialUnitId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getPublicIndicatorBySpatialUnitIdAndId");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicIndicatorBySpatialUnitIdAndId");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));

        final String[] localVarAccepts = { 
            "application/octed-stream"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/management/public/indicators/{indicatorId}/{spatialUnitId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the public indicator for the selected public spatial unit, year and month as GeoJSON
     * retrieve the public indicator for the selected spatial unit, year and month as GeoJSON
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
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth(BigDecimal day, String indicatorId, BigDecimal month, String spatialUnitId, BigDecimal year, String simplifyGeometries) throws RestClientException {
        return getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithHttpInfo(day, indicatorId, month, spatialUnitId, year, simplifyGeometries).getBody();
    }

    /**
     * retrieve the public indicator for the selected public spatial unit, year and month as GeoJSON
     * retrieve the public indicator for the selected spatial unit, year and month as GeoJSON
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
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithHttpInfo(BigDecimal day, String indicatorId, BigDecimal month, String spatialUnitId, BigDecimal year, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
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

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));

        final String[] localVarAccepts = { 
            "application/octed-stream"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/management/public/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries!
     * retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries!
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
     * @return Map&lt;String, String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Map<String, String> getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(BigDecimal day, String indicatorId, BigDecimal month, String spatialUnitId, BigDecimal year) throws RestClientException {
        return getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometryWithHttpInfo(day, indicatorId, month, spatialUnitId, year).getBody();
    }

    /**
     * retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries!
     * retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries!
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
     * @return ResponseEntity&lt;Map&lt;String, String&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Map<String, String>> getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometryWithHttpInfo(BigDecimal day, String indicatorId, BigDecimal month, String spatialUnitId, BigDecimal year) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
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
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Map<String, String>> localReturnType = new ParameterizedTypeReference<Map<String, String>>() {};
        return apiClient.invokeAPI("/management/public/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the public indicator values and other properties for the selected public spatial unit. It does not include the spatial geometries!
     * retrieve the public indicator values and other properties for the selected public spatial unit. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @return Map&lt;String, String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Map<String, String> getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry(String indicatorId, String spatialUnitId) throws RestClientException {
        return getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometryWithHttpInfo(indicatorId, spatialUnitId).getBody();
    }

    /**
     * retrieve the public indicator values and other properties for the selected public spatial unit. It does not include the spatial geometries!
     * retrieve the public indicator values and other properties for the selected public spatial unit. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId indicatorId (required)
     * @param spatialUnitId spatialUnitId (required)
     * @return ResponseEntity&lt;Map&lt;String, String&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Map<String, String>> getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometryWithHttpInfo(String indicatorId, String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry");
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
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Map<String, String>> localReturnType = new ParameterizedTypeReference<Map<String, String>>() {};
        return apiClient.invokeAPI("/management/public/indicators/{indicatorId}/{spatialUnitId}/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}

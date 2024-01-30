package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;

import java.math.BigDecimal;
import org.n52.kommonitor.models.IndicatorOverviewType;
import org.n52.kommonitor.models.IndicatorPropertiesWithoutGeomType;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-01-30T13:33:53.805125800+01:00[Europe/Berlin]")
@Component("org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicApi")
public class IndicatorsPublicApi {
    private ApiClient apiClient;

    public IndicatorsPublicApi() {
        this(new ApiClient());
    }

    @Autowired
    public IndicatorsPublicApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * retrieve information about the selected public indicator
     * retrieve information about the selected public indicator
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected public indicator dataset (required)
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
     * @param indicatorId unique identifier of the selected public indicator dataset (required)
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
        return apiClient.invokeAPI("/public/indicators/{indicatorId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the public indicator for the selected spatial unit as GeoJSON
     * retrieve the public indicator for the selected spatial unit as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected public indicator dataset (required)
     * @param spatialUnitId the unique identifier of the public spatial level (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
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
     * @param indicatorId unique identifier of the selected public indicator dataset (required)
     * @param spatialUnitId the unique identifier of the public spatial level (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
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
        return apiClient.invokeAPI("/public/indicators/{indicatorId}/{spatialUnitId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the public indicator for the selected public spatial unit, year and month as GeoJSON
     * retrieve the public indicator for the selected spatial unit, year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected public indicator dataset (required)
     * @param spatialUnitId the unique identifier of the public spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        return getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithHttpInfo(indicatorId, spatialUnitId, year, month, day, simplifyGeometries).getBody();
    }

    /**
     * retrieve the public indicator for the selected public spatial unit, year and month as GeoJSON
     * retrieve the public indicator for the selected spatial unit, year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected public indicator dataset (required)
     * @param spatialUnitId the unique identifier of the public spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithHttpInfo(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("year", year);
        uriVariables.put("month", month);
        uriVariables.put("day", day);

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
        return apiClient.invokeAPI("/public/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries!
     * retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return List&lt;IndicatorPropertiesWithoutGeomType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorPropertiesWithoutGeomType> getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        return getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometryWithHttpInfo(indicatorId, spatialUnitId, year, month, day).getBody();
    }

    /**
     * retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries!
     * retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return ResponseEntity&lt;List&lt;IndicatorPropertiesWithoutGeomType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorPropertiesWithoutGeomType>> getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometryWithHttpInfo(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("year", year);
        uriVariables.put("month", month);
        uriVariables.put("day", day);

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

        ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>> localReturnType = new ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>>() {};
        return apiClient.invokeAPI("/public/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the public indicator values and other properties for the selected public spatial unit. It does not include the spatial geometries!
     * retrieve the public indicator values and other properties for the selected public spatial unit. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected public indicator dataset (required)
     * @param spatialUnitId the unique identifier of the public spatial level (required)
     * @return List&lt;IndicatorPropertiesWithoutGeomType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorPropertiesWithoutGeomType> getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry(String indicatorId, String spatialUnitId) throws RestClientException {
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
     * @param indicatorId unique identifier of the selected public indicator dataset (required)
     * @param spatialUnitId the unique identifier of the public spatial level (required)
     * @return ResponseEntity&lt;List&lt;IndicatorPropertiesWithoutGeomType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorPropertiesWithoutGeomType>> getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometryWithHttpInfo(String indicatorId, String spatialUnitId) throws RestClientException {
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

        ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>> localReturnType = new ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>>() {};
        return apiClient.invokeAPI("/public/indicators/{indicatorId}/{spatialUnitId}/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available public indicators
     * retrieve information about available public indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;IndicatorOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorOverviewType> getPublicIndicators() throws RestClientException {
        return getPublicIndicatorsWithHttpInfo().getBody();
    }

    /**
     * retrieve information about available public indicators
     * retrieve information about available public indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;List&lt;IndicatorOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorOverviewType>> getPublicIndicatorsWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<List<IndicatorOverviewType>> localReturnType = new ParameterizedTypeReference<List<IndicatorOverviewType>>() {};
        return apiClient.invokeAPI("/public/indicators", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset spatial feature (required)
     * @return List&lt;IndicatorPropertiesWithoutGeomType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorPropertiesWithoutGeomType> getPublicSingleIndicatorFeatureById(String indicatorId, String spatialUnitId, String featureId) throws RestClientException {
        return getPublicSingleIndicatorFeatureByIdWithHttpInfo(indicatorId, spatialUnitId, featureId).getBody();
    }

    /**
     * retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset spatial feature (required)
     * @return ResponseEntity&lt;List&lt;IndicatorPropertiesWithoutGeomType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorPropertiesWithoutGeomType>> getPublicSingleIndicatorFeatureByIdWithHttpInfo(String indicatorId, String spatialUnitId, String featureId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getPublicSingleIndicatorFeatureById");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicSingleIndicatorFeatureById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getPublicSingleIndicatorFeatureById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("featureId", featureId);

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

        ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>> localReturnType = new ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>>() {};
        return apiClient.invokeAPI("/public/indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve single feature database record specified by its unique database primary key id
     * retrieve single feature database record specified by its unique database primary key id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset spatial feature (required)
     * @param featureRecordId the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @return List&lt;IndicatorPropertiesWithoutGeomType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorPropertiesWithoutGeomType> getPublicSingleIndicatorFeatureRecordById(String indicatorId, String spatialUnitId, String featureId, String featureRecordId) throws RestClientException {
        return getPublicSingleIndicatorFeatureRecordByIdWithHttpInfo(indicatorId, spatialUnitId, featureId, featureRecordId).getBody();
    }

    /**
     * retrieve single feature database record specified by its unique database primary key id
     * retrieve single feature database record specified by its unique database primary key id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset spatial feature (required)
     * @param featureRecordId the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @return ResponseEntity&lt;List&lt;IndicatorPropertiesWithoutGeomType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorPropertiesWithoutGeomType>> getPublicSingleIndicatorFeatureRecordByIdWithHttpInfo(String indicatorId, String spatialUnitId, String featureId, String featureRecordId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getPublicSingleIndicatorFeatureRecordById");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicSingleIndicatorFeatureRecordById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getPublicSingleIndicatorFeatureRecordById");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling getPublicSingleIndicatorFeatureRecordById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("featureId", featureId);
        uriVariables.put("featureRecordId", featureRecordId);

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

        ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>> localReturnType = new ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>>() {};
        return apiClient.invokeAPI("/public/indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}

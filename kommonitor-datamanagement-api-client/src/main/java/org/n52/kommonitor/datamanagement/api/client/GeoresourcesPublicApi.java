package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.BaseApi;

import java.math.BigDecimal;
import org.n52.kommonitor.models.GeoresourceOverviewType;
import org.n52.kommonitor.models.ResourceFilterType;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-09-01T12:50:21.566716700+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
@Component("org.n52.kommonitor.datamanagement.api.client.GeoresourcesPublicApi")
public class GeoresourcesPublicApi extends BaseApi {

    public GeoresourcesPublicApi() {
        super(new ApiClient());
    }

    @Autowired
    public GeoresourcesPublicApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Filter public georesources
     * Filter public georesource datasets according to the specified filter
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param resourceFilterType filter data (required)
     * @return List&lt;GeoresourceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<GeoresourceOverviewType> filterPublicGeoresources(ResourceFilterType resourceFilterType) throws RestClientException {
        return filterPublicGeoresourcesWithHttpInfo(resourceFilterType).getBody();
    }

    /**
     * Filter public georesources
     * Filter public georesource datasets according to the specified filter
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param resourceFilterType filter data (required)
     * @return ResponseEntity&lt;List&lt;GeoresourceOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<GeoresourceOverviewType>> filterPublicGeoresourcesWithHttpInfo(ResourceFilterType resourceFilterType) throws RestClientException {
        Object localVarPostBody = resourceFilterType;
        
        // verify the required parameter 'resourceFilterType' is set
        if (resourceFilterType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'resourceFilterType' when calling filterPublicGeoresources");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<List<GeoresourceOverviewType>> localReturnType = new ParameterizedTypeReference<List<GeoresourceOverviewType>>() {};
        return apiClient.invokeAPI("/public/georesources/filter", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the public geo-resource dataset (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getAllPublicGeoresourceFeaturesById(String georesourceId, String simplifyGeometries) throws RestClientException {
        return getAllPublicGeoresourceFeaturesByIdWithHttpInfo(georesourceId, simplifyGeometries).getBody();
    }

    /**
     * retrieve all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the public geo-resource dataset (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getAllPublicGeoresourceFeaturesByIdWithHttpInfo(String georesourceId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getAllPublicGeoresourceFeaturesById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/public/georesources/{georesourceId}/allFeatures", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve only the properties without geometry of all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve only the properties without geometry of all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId georesourceId (required)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getAllPublicGeoresourceFeaturesByIdWithoutGeometry(String georesourceId) throws RestClientException {
        return getAllPublicGeoresourceFeaturesByIdWithoutGeometryWithHttpInfo(georesourceId).getBody();
    }

    /**
     * retrieve only the properties without geometry of all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve only the properties without geometry of all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId georesourceId (required)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getAllPublicGeoresourceFeaturesByIdWithoutGeometryWithHttpInfo(String georesourceId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getAllPublicGeoresourceFeaturesByIdWithoutGeometry");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

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

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/public/georesources/{georesourceId}/allFeatures/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available features of the selected public geo-resource dataset
     * retrieve information about available features of the selected public geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the public geo-resource dataset (required)
     * @return GeoresourceOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GeoresourceOverviewType getPublicGeoresourceById(String georesourceId) throws RestClientException {
        return getPublicGeoresourceByIdWithHttpInfo(georesourceId).getBody();
    }

    /**
     * retrieve information about available features of the selected public geo-resource dataset
     * retrieve information about available features of the selected public geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the public geo-resource dataset (required)
     * @return ResponseEntity&lt;GeoresourceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GeoresourceOverviewType> getPublicGeoresourceByIdWithHttpInfo(String georesourceId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getPublicGeoresourceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

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

        ParameterizedTypeReference<GeoresourceOverviewType> localReturnType = new ParameterizedTypeReference<GeoresourceOverviewType>() {};
        return apiClient.invokeAPI("/public/georesources/{georesourceId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the features according to the selected public geo-resource dataset and selected year and month as GeoJSON
     * retrieve the features according to the selected public geo-resource dataset and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the public geo-resource dataset (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getPublicGeoresourceByIdAndYearAndMonth(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        return getPublicGeoresourceByIdAndYearAndMonthWithHttpInfo(georesourceId, year, month, day, simplifyGeometries).getBody();
    }

    /**
     * retrieve the features according to the selected public geo-resource dataset and selected year and month as GeoJSON
     * retrieve the features according to the selected public geo-resource dataset and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the public geo-resource dataset (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getPublicGeoresourceByIdAndYearAndMonthWithHttpInfo(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getPublicGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getPublicGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getPublicGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getPublicGeoresourceByIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);
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
        return apiClient.invokeAPI("/public/georesources/{georesourceId}/{year}/{month}/{day}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve only the properties without geometry of the features according to the selected public geo-resource dataset and selected year and month as GeoJSON
     * retrieve only the properties without geometry of the features according to the selected public geo-resource dataset and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId georesourceId (required)
     * @param year year (required)
     * @param month month (required)
     * @param day day (required)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getPublicGeoresourceByIdAndYearAndMonthWithoutGeometry(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        return getPublicGeoresourceByIdAndYearAndMonthWithoutGeometryWithHttpInfo(georesourceId, year, month, day).getBody();
    }

    /**
     * retrieve only the properties without geometry of the features according to the selected public geo-resource dataset and selected year and month as GeoJSON
     * retrieve only the properties without geometry of the features according to the selected public geo-resource dataset and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId georesourceId (required)
     * @param year year (required)
     * @param month month (required)
     * @param day day (required)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getPublicGeoresourceByIdAndYearAndMonthWithoutGeometryWithHttpInfo(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getPublicGeoresourceByIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getPublicGeoresourceByIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getPublicGeoresourceByIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getPublicGeoresourceByIdAndYearAndMonthWithoutGeometry");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);
        uriVariables.put("year", year);
        uriVariables.put("month", month);
        uriVariables.put("day", day);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/octed-stream"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/public/georesources/{georesourceId}/{year}/{month}/{day}/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the JSON schema for the selected public geo-resource dataset
     * retrieve the JSON schema for the selected public geo-resource dataset. The JSON schema indicates the property structure of the dataset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the public geo-resource dataset (required)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getPublicGeoresourceSchemaByLevel(String georesourceId) throws RestClientException {
        return getPublicGeoresourceSchemaByLevelWithHttpInfo(georesourceId).getBody();
    }

    /**
     * retrieve the JSON schema for the selected public geo-resource dataset
     * retrieve the JSON schema for the selected public geo-resource dataset. The JSON schema indicates the property structure of the dataset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the public geo-resource dataset (required)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getPublicGeoresourceSchemaByLevelWithHttpInfo(String georesourceId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getPublicGeoresourceSchemaByLevel");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

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

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/public/georesources/{georesourceId}/schema", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available features of different public geo-resource datasets
     * retrieve information about available features of different public geo-resource datasets
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;GeoresourceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<GeoresourceOverviewType> getPublicGeoresources() throws RestClientException {
        return getPublicGeoresourcesWithHttpInfo().getBody();
    }

    /**
     * retrieve information about available features of different public geo-resource datasets
     * retrieve information about available features of different public geo-resource datasets
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;List&lt;GeoresourceOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<GeoresourceOverviewType>> getPublicGeoresourcesWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<List<GeoresourceOverviewType>> localReturnType = new ParameterizedTypeReference<List<GeoresourceOverviewType>>() {};
        return apiClient.invokeAPI("/public/georesources", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve single feature database records for all applicable periods of validity for the selected geo-resource dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * retrieve single feature database records for all applicable periods of validity for the selected geo-resource dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param featureId the identifier of the geo-resource dataset feature (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getPublicSingleGeoresourceFeatureById(String georesourceId, String featureId, String simplifyGeometries) throws RestClientException {
        return getPublicSingleGeoresourceFeatureByIdWithHttpInfo(georesourceId, featureId, simplifyGeometries).getBody();
    }

    /**
     * retrieve single feature database records for all applicable periods of validity for the selected geo-resource dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * retrieve single feature database records for all applicable periods of validity for the selected geo-resource dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param featureId the identifier of the geo-resource dataset feature (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getPublicSingleGeoresourceFeatureByIdWithHttpInfo(String georesourceId, String featureId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getPublicSingleGeoresourceFeatureById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getPublicSingleGeoresourceFeatureById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);
        uriVariables.put("featureId", featureId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/public/georesources/{georesourceId}/singleFeature/{featureId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve single feature database record specified by its unique database primary key id
     * retrieve single feature database record specified by its unique database primary key id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param featureId the identifier of the geo-resource dataset feature (required)
     * @param featureRecordId the unique database record identifier of the geo-resource dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getPublicSingleGeoresourceFeatureRecordById(String georesourceId, String featureId, String featureRecordId, String simplifyGeometries) throws RestClientException {
        return getPublicSingleGeoresourceFeatureRecordByIdWithHttpInfo(georesourceId, featureId, featureRecordId, simplifyGeometries).getBody();
    }

    /**
     * retrieve single feature database record specified by its unique database primary key id
     * retrieve single feature database record specified by its unique database primary key id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param featureId the identifier of the geo-resource dataset feature (required)
     * @param featureRecordId the unique database record identifier of the geo-resource dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getPublicSingleGeoresourceFeatureRecordByIdWithHttpInfo(String georesourceId, String featureId, String featureRecordId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getPublicSingleGeoresourceFeatureRecordById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getPublicSingleGeoresourceFeatureRecordById");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling getPublicSingleGeoresourceFeatureRecordById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);
        uriVariables.put("featureId", featureId);
        uriVariables.put("featureRecordId", featureRecordId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/public/georesources/{georesourceId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    @Override
    public <T> ResponseEntity<T> invokeAPI(String url, HttpMethod method, Object request, ParameterizedTypeReference<T> returnType) throws RestClientException {
        String localVarPath = url.replace(apiClient.getBasePath(), "");
        Object localVarPostBody = request;

        final Map<String, Object> uriVariables = new HashMap<String, Object>();
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

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}

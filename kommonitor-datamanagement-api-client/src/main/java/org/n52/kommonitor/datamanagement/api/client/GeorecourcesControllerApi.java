package org.n52.kommonitor.datamanagement.api.client;

import org.checkerframework.checker.units.qual.C;
import org.n52.kommonitor.datamanagement.api.ApiClient;

import java.math.BigDecimal;
import org.n52.kommonitor.models.GeoresourceOverviewType;
import org.n52.kommonitor.models.GeoresourcePATCHInputType;
import org.n52.kommonitor.models.GeoresourcePOSTInputType;
import org.n52.kommonitor.models.GeoresourcePUTInputType;

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
public class GeorecourcesControllerApi {
    private ApiClient apiClient;

    public GeorecourcesControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public GeorecourcesControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Add a new geo-resource
     * Add/Register a geo-resource dataset for a certain period of time
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param featureData featureData (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Void addGeoresourceAsBody(GeoresourcePOSTInputType featureData) throws RestClientException {
        return addGeoresourceAsBodyWithHttpInfo(featureData).getBody();
    }

    /**
     * Add a new geo-resource
     * Add/Register a geo-resource dataset for a certain period of time
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param featureData featureData (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> addGeoresourceAsBodyWithHttpInfo(GeoresourcePOSTInputType featureData) throws RestClientException {
        Object localVarPostBody = featureData;
        
        // verify the required parameter 'featureData' is set
        if (featureData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureData' when calling addGeoresourceAsBody");
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
        return apiClient.invokeAPI("/management/georesources", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete all features/contents of the selected geo-resource dataset
     * Delete all features/contents of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId georesourceId (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity deleteAllGeoresourceFeaturesById(String georesourceId) throws RestClientException {
        return deleteAllGeoresourceFeaturesByIdWithHttpInfo(georesourceId).getBody();
    }

    /**
     * Delete all features/contents of the selected geo-resource dataset
     * Delete all features/contents of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId georesourceId (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseEntity> deleteAllGeoresourceFeaturesByIdWithHttpInfo(String georesourceId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling deleteAllGeoresourceFeaturesById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

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
        return apiClient.invokeAPI("/management/georesources/{georesourceId}/allFeatures", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected geo-resource dataset
     * Delete the features/contents of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId georesourceId (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity deleteGeoresourceById(String georesourceId) throws RestClientException {
        return deleteGeoresourceByIdWithHttpInfo(georesourceId).getBody();
    }

    /**
     * Delete the features/contents of the selected geo-resource dataset
     * Delete the features/contents of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId georesourceId (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseEntity> deleteGeoresourceByIdWithHttpInfo(String georesourceId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling deleteGeoresourceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

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
        return apiClient.invokeAPI("/management/georesources/{georesourceId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected geo-resource dataset, selected by year and month
     * Delete the features/contents of the selected geo-resource dataset, selected by year and month
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param day day (required)
     * @param georesourceId georesourceId (required)
     * @param month month (required)
     * @param year year (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity deleteGeoresourceByIdAndYearAndMonth(BigDecimal day, String georesourceId, BigDecimal month, BigDecimal year) throws RestClientException {
        return deleteGeoresourceByIdAndYearAndMonthWithHttpInfo(day, georesourceId, month, year).getBody();
    }

    /**
     * Delete the features/contents of the selected geo-resource dataset, selected by year and month
     * Delete the features/contents of the selected geo-resource dataset, selected by year and month
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param day day (required)
     * @param georesourceId georesourceId (required)
     * @param month month (required)
     * @param year year (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseEntity> deleteGeoresourceByIdAndYearAndMonthWithHttpInfo(BigDecimal day, String georesourceId, BigDecimal month, BigDecimal year) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling deleteGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling deleteGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling deleteGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling deleteGeoresourceByIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("day", day);
        uriVariables.put("georesourceId", georesourceId);
        uriVariables.put("month", month);
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
        return apiClient.invokeAPI("/management/georesources/{georesourceId}/{year}/{month}/{day}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId georesourceId (required)
     * @param name  (optional)
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAllGeoresourceFeaturesById(String georesourceId, String name, String simplifyGeometries) throws RestClientException {
        return getAllGeoresourceFeaturesByIdWithHttpInfo(georesourceId, name, simplifyGeometries).getBody();
    }

    /**
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId georesourceId (required)
     * @param name  (optional)
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAllGeoresourceFeaturesByIdWithHttpInfo(String georesourceId, String name, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getAllGeoresourceFeaturesById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/management/georesources/{georesourceId}/allFeatures", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available features of the selected geo-resource dataset
     * retrieve information about available features of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId georesourceId (required)
     * @param name  (optional)
     * @return GeoresourceOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GeoresourceOverviewType getGeoresourceById(String georesourceId, String name) throws RestClientException {
        return getGeoresourceByIdWithHttpInfo(georesourceId, name).getBody();
    }

    /**
     * retrieve information about available features of the selected geo-resource dataset
     * retrieve information about available features of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId georesourceId (required)
     * @param name  (optional)
     * @return ResponseEntity&lt;GeoresourceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GeoresourceOverviewType> getGeoresourceByIdWithHttpInfo(String georesourceId, String name) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getGeoresourceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

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

        ParameterizedTypeReference<GeoresourceOverviewType> localReturnType = new ParameterizedTypeReference<GeoresourceOverviewType>() {};
        return apiClient.invokeAPI("/management/georesources/{georesourceId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON
     * retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param day day (required)
     * @param georesourceId georesourceId (required)
     * @param month month (required)
     * @param year year (required)
     * @param name  (optional)
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getGeoresourceByIdAndYearAndMonth(BigDecimal day, String georesourceId, BigDecimal month, BigDecimal year, String name, String simplifyGeometries) throws RestClientException {
        return getGeoresourceByIdAndYearAndMonthWithHttpInfo(day, georesourceId, month, year, name, simplifyGeometries).getBody();
    }

    /**
     * retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON
     * retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param day day (required)
     * @param georesourceId georesourceId (required)
     * @param month month (required)
     * @param year year (required)
     * @param name  (optional)
     * @param simplifyGeometries simplifyGeometries (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getGeoresourceByIdAndYearAndMonthWithHttpInfo(BigDecimal day, String georesourceId, BigDecimal month, BigDecimal year, String name, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getGeoresourceByIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("day", day);
        uriVariables.put("georesourceId", georesourceId);
        uriVariables.put("month", month);
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
        return apiClient.invokeAPI("/management/georesources/{georesourceId}/{year}/{month}/{day}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the JSON schema for the selected geo-resource dataset
     * retrieve the JSON schema for the selected geo-resource dataset. The JSON schema indicates the property structure of the dataset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId georesourceId (required)
     * @param name  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getGeoresourceSchemaByLevel(String georesourceId, String name) throws RestClientException {
        return getGeoresourceSchemaByLevelWithHttpInfo(georesourceId, name).getBody();
    }

    /**
     * retrieve the JSON schema for the selected geo-resource dataset
     * retrieve the JSON schema for the selected geo-resource dataset. The JSON schema indicates the property structure of the dataset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId georesourceId (required)
     * @param name  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getGeoresourceSchemaByLevelWithHttpInfo(String georesourceId, String name) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getGeoresourceSchemaByLevel");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

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

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/management/georesources/{georesourceId}/schema", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available features of different geo-resource datasets
     * retrieve information about available features of different geo-resource datasets
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param name  (optional)
     * @return GeoresourceOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GeoresourceOverviewType getGeoresources(String name) throws RestClientException {
        return getGeoresourcesWithHttpInfo(name).getBody();
    }

    /**
     * retrieve information about available features of different geo-resource datasets
     * retrieve information about available features of different geo-resource datasets
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param name  (optional)
     * @return ResponseEntity&lt;GeoresourceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GeoresourceOverviewType> getGeoresourcesWithHttpInfo(String name) throws RestClientException {
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

        ParameterizedTypeReference<GeoresourceOverviewType> localReturnType = new ParameterizedTypeReference<GeoresourceOverviewType>() {};
        return apiClient.invokeAPI("/management/georesources", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the features of the selected geo-resource dataset
     * Modify/Update the features of the selected geo-resource dataset.  The interface expects a full upload of all geometries for the spatial unit. Internally, those geometries are compared to the existing ones to mark &#39;old&#39; geometries that are no longer in use as outdated. Hence, each geometric object is only persisted once and its use is controlled by time validity marks.
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param georesourceId georesourceId (required)
     * @param featureData featureData (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity updateGeoresourceAsBody(String georesourceId, GeoresourcePUTInputType featureData) throws RestClientException {
        return updateGeoresourceAsBodyWithHttpInfo(georesourceId, featureData).getBody();
    }

    /**
     * Modify/Update the features of the selected geo-resource dataset
     * Modify/Update the features of the selected geo-resource dataset.  The interface expects a full upload of all geometries for the spatial unit. Internally, those geometries are compared to the existing ones to mark &#39;old&#39; geometries that are no longer in use as outdated. Hence, each geometric object is only persisted once and its use is controlled by time validity marks.
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param georesourceId georesourceId (required)
     * @param featureData featureData (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseEntity> updateGeoresourceAsBodyWithHttpInfo(String georesourceId, GeoresourcePUTInputType featureData) throws RestClientException {
        Object localVarPostBody = featureData;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling updateGeoresourceAsBody");
        }
        
        // verify the required parameter 'featureData' is set
        if (featureData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureData' when calling updateGeoresourceAsBody");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

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
        return apiClient.invokeAPI("/management/georesources/{georesourceId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the metadata of the selected geo-resource dataset
     * Modify/Update the metadata of the selected geo-resource dataset. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param georesourceId georesourceId (required)
     * @param metadata metadata (required)
     * @return ResponseEntity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity updateGeoresourceMetadataAsBody(String georesourceId, GeoresourcePATCHInputType metadata) throws RestClientException {
        return updateGeoresourceMetadataAsBodyWithHttpInfo(georesourceId, metadata).getBody();
    }

    /**
     * Modify/Update the metadata of the selected geo-resource dataset
     * Modify/Update the metadata of the selected geo-resource dataset. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param georesourceId georesourceId (required)
     * @param metadata metadata (required)
     * @return ResponseEntity&lt;ResponseEntity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseEntity> updateGeoresourceMetadataAsBodyWithHttpInfo(String georesourceId, GeoresourcePATCHInputType metadata) throws RestClientException {
        Object localVarPostBody = metadata;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling updateGeoresourceMetadataAsBody");
        }
        
        // verify the required parameter 'metadata' is set
        if (metadata == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'metadata' when calling updateGeoresourceMetadataAsBody");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

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
        return apiClient.invokeAPI("/management/georesources/{georesourceId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}

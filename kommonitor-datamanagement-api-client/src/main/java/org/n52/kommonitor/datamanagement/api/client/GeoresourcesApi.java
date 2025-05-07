package org.n52.kommonitor.datamanagement.api.client;

import jakarta.annotation.Generated;
import org.n52.kommonitor.datamanagement.api.ApiClient;

import java.math.BigDecimal;
import org.n52.kommonitor.models.GeoresourceOverviewType;
import org.n52.kommonitor.models.GeoresourcePATCHInputType;
import org.n52.kommonitor.models.GeoresourcePOSTInputType;
import org.n52.kommonitor.models.GeoresourcePUTInputType;
import org.n52.kommonitor.models.OwnerInputType;
import org.n52.kommonitor.models.PermissionLevelInputType;
import org.n52.kommonitor.models.PermissionLevelType;

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

@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-21T12:45:23.890552600+01:00[Europe/Berlin]")
@Component("org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi")
public class GeoresourcesApi {
    private ApiClient apiClient;

    public GeoresourcesApi() {
        this(new ApiClient());
    }

    @Autowired
    public GeoresourcesApi(ApiClient apiClient) {
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
     * @param georesourcePOSTInputType feature data (required)
     * @return GeoresourceOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GeoresourceOverviewType addGeoresourceAsBody(GeoresourcePOSTInputType georesourcePOSTInputType) throws RestClientException {
        return addGeoresourceAsBodyWithHttpInfo(georesourcePOSTInputType).getBody();
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
     * @param georesourcePOSTInputType feature data (required)
     * @return ResponseEntity&lt;GeoresourceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GeoresourceOverviewType> addGeoresourceAsBodyWithHttpInfo(GeoresourcePOSTInputType georesourcePOSTInputType) throws RestClientException {
        Object localVarPostBody = georesourcePOSTInputType;
        
        // verify the required parameter 'georesourcePOSTInputType' is set
        if (georesourcePOSTInputType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourcePOSTInputType' when calling addGeoresourceAsBody");
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

        ParameterizedTypeReference<GeoresourceOverviewType> localReturnType = new ParameterizedTypeReference<GeoresourceOverviewType>() {};
        return apiClient.invokeAPI("/georesources", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete all features/contents of the selected geo-resource dataset
     * Delete all features/contents of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteAllGeoresourceFeaturesById(String georesourceId) throws RestClientException {
        deleteAllGeoresourceFeaturesByIdWithHttpInfo(georesourceId);
    }

    /**
     * Delete all features/contents of the selected geo-resource dataset
     * Delete all features/contents of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteAllGeoresourceFeaturesByIdWithHttpInfo(String georesourceId) throws RestClientException {
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

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}/allFeatures", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected geo-resource dataset
     * Delete the features/contents of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteGeoresourceById(String georesourceId) throws RestClientException {
        deleteGeoresourceByIdWithHttpInfo(georesourceId);
    }

    /**
     * Delete the features/contents of the selected geo-resource dataset
     * Delete the features/contents of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteGeoresourceByIdWithHttpInfo(String georesourceId) throws RestClientException {
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

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected geo-resource dataset, selected by year and month
     * Delete the features/contents of the selected geo-resource dataset, selected by year and month
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteGeoresourceByIdAndYearAndMonth(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        deleteGeoresourceByIdAndYearAndMonthWithHttpInfo(georesourceId, year, month, day);
    }

    /**
     * Delete the features/contents of the selected geo-resource dataset, selected by year and month
     * Delete the features/contents of the selected geo-resource dataset, selected by year and month
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteGeoresourceByIdAndYearAndMonthWithHttpInfo(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling deleteGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling deleteGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling deleteGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling deleteGeoresourceByIdAndYearAndMonth");
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

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}/{year}/{month}/{day}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete all database records for the specified feature of the selected geo-resource dataset
     * Delete all database records for the specified feature of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param featureId the identifier of the geo-resource dataset feature (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteSingleGeoresourceFeatureById(String georesourceId, String featureId) throws RestClientException {
        deleteSingleGeoresourceFeatureByIdWithHttpInfo(georesourceId, featureId);
    }

    /**
     * Delete all database records for the specified feature of the selected geo-resource dataset
     * Delete all database records for the specified feature of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param featureId the identifier of the geo-resource dataset feature (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteSingleGeoresourceFeatureByIdWithHttpInfo(String georesourceId, String featureId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling deleteSingleGeoresourceFeatureById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling deleteSingleGeoresourceFeatureById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);
        uriVariables.put("featureId", featureId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}/singleFeature/{featureId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected geo-resource dataset
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param featureId the identifier of the geo-resource dataset feature (required)
     * @param featureRecordId the unique database record identifier of the geo-resource dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteSingleGeoresourceFeatureRecordById(String georesourceId, String featureId, String featureRecordId) throws RestClientException {
        deleteSingleGeoresourceFeatureRecordByIdWithHttpInfo(georesourceId, featureId, featureRecordId);
    }

    /**
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected geo-resource dataset
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param featureId the identifier of the geo-resource dataset feature (required)
     * @param featureRecordId the unique database record identifier of the geo-resource dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteSingleGeoresourceFeatureRecordByIdWithHttpInfo(String georesourceId, String featureId, String featureRecordId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling deleteSingleGeoresourceFeatureRecordById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling deleteSingleGeoresourceFeatureRecordById");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling deleteSingleGeoresourceFeatureRecordById");
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

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getAllGeoresourceFeaturesById(String georesourceId, String simplifyGeometries) throws RestClientException {
        return getAllGeoresourceFeaturesByIdWithHttpInfo(georesourceId, simplifyGeometries).getBody();
    }

    /**
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getAllGeoresourceFeaturesByIdWithHttpInfo(String georesourceId, String simplifyGeometries) throws RestClientException {
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

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));


        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}/allFeatures", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
    public byte[] getAllGeoresourceFeaturesByIdWithoutGeometry(String georesourceId) throws RestClientException {
        return getAllGeoresourceFeaturesByIdWithoutGeometryWithHttpInfo(georesourceId).getBody();
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
    public ResponseEntity<byte[]> getAllGeoresourceFeaturesByIdWithoutGeometryWithHttpInfo(String georesourceId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getAllGeoresourceFeaturesByIdWithoutGeometry");
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
        return apiClient.invokeAPI("/georesources/{georesourceId}/allFeatures/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available features of the selected geo-resource dataset
     * retrieve information about available features of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @return GeoresourceOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public GeoresourceOverviewType getGeoresourceById(String georesourceId) throws RestClientException {
        return getGeoresourceByIdWithHttpInfo(georesourceId).getBody();
    }

    /**
     * retrieve information about available features of the selected geo-resource dataset
     * retrieve information about available features of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @return ResponseEntity&lt;GeoresourceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GeoresourceOverviewType> getGeoresourceByIdWithHttpInfo(String georesourceId) throws RestClientException {
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

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<GeoresourceOverviewType> localReturnType = new ParameterizedTypeReference<GeoresourceOverviewType>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON
     * retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getGeoresourceByIdAndYearAndMonth(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        return getGeoresourceByIdAndYearAndMonthWithHttpInfo(georesourceId, year, month, day, simplifyGeometries).getBody();
    }

    /**
     * retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON
     * retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getGeoresourceByIdAndYearAndMonthWithHttpInfo(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getGeoresourceByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getGeoresourceByIdAndYearAndMonth");
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
        return apiClient.invokeAPI("/georesources/{georesourceId}/{year}/{month}/{day}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
    public byte[] getGeoresourceByIdAndYearAndMonthWithoutGeometry(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        return getGeoresourceByIdAndYearAndMonthWithoutGeometryWithHttpInfo(georesourceId, year, month, day).getBody();
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
    public ResponseEntity<byte[]> getGeoresourceByIdAndYearAndMonthWithoutGeometryWithHttpInfo(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getGeoresourceByIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getGeoresourceByIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getGeoresourceByIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getGeoresourceByIdAndYearAndMonthWithoutGeometry");
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
        return apiClient.invokeAPI("/georesources/{georesourceId}/{year}/{month}/{day}/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about the permissions for the selected geo-resource
     * retrieve information about the permissions for the selected geo-resource
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @return List&lt;PermissionLevelType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<PermissionLevelType> getGeoresourcePermissionsById(String georesourceId) throws RestClientException {
        return getGeoresourcePermissionsByIdWithHttpInfo(georesourceId).getBody();
    }

    /**
     * retrieve information about the permissions for the selected geo-resource
     * retrieve information about the permissions for the selected geo-resource
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @return ResponseEntity&lt;List&lt;PermissionLevelType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<PermissionLevelType>> getGeoresourcePermissionsByIdWithHttpInfo(String georesourceId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getGeoresourcePermissionsById");
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

        ParameterizedTypeReference<List<PermissionLevelType>> localReturnType = new ParameterizedTypeReference<List<PermissionLevelType>>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}/permissions", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the JSON schema for the selected geo-resource dataset
     * retrieve the JSON schema for the selected geo-resource dataset. The JSON schema indicates the property structure of the dataset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getGeoresourceSchemaByLevel(String georesourceId) throws RestClientException {
        return getGeoresourceSchemaByLevelWithHttpInfo(georesourceId).getBody();
    }

    /**
     * retrieve the JSON schema for the selected geo-resource dataset
     * retrieve the JSON schema for the selected geo-resource dataset. The JSON schema indicates the property structure of the dataset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getGeoresourceSchemaByLevelWithHttpInfo(String georesourceId) throws RestClientException {
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

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}/schema", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available features of different geo-resource datasets
     * retrieve information about available features of different geo-resource datasets
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;GeoresourceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<GeoresourceOverviewType> getGeoresources() throws RestClientException {
        return getGeoresourcesWithHttpInfo().getBody();
    }

    /**
     * retrieve information about available features of different geo-resource datasets
     * retrieve information about available features of different geo-resource datasets
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;List&lt;GeoresourceOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<GeoresourceOverviewType>> getGeoresourcesWithHttpInfo() throws RestClientException {
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
        return apiClient.invokeAPI("/georesources", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getSingleGeoresourceFeatureById(String georesourceId, String featureId, String simplifyGeometries) throws RestClientException {
        return getSingleGeoresourceFeatureByIdWithHttpInfo(georesourceId, featureId, simplifyGeometries).getBody();
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
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getSingleGeoresourceFeatureByIdWithHttpInfo(String georesourceId, String featureId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getSingleGeoresourceFeatureById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getSingleGeoresourceFeatureById");
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
        return apiClient.invokeAPI("/georesources/{georesourceId}/singleFeature/{featureId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getSingleGeoresourceFeatureRecordById(String georesourceId, String featureId, String featureRecordId, String simplifyGeometries) throws RestClientException {
        return getSingleGeoresourceFeatureRecordByIdWithHttpInfo(georesourceId, featureId, featureRecordId, simplifyGeometries).getBody();
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
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getSingleGeoresourceFeatureRecordByIdWithHttpInfo(String georesourceId, String featureId, String featureRecordId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getSingleGeoresourceFeatureRecordById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getSingleGeoresourceFeatureRecordById");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling getSingleGeoresourceFeatureRecordById");
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
        return apiClient.invokeAPI("/georesources/{georesourceId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param featureData feature data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateGeoresourceAsBody(String georesourceId, GeoresourcePUTInputType featureData) throws RestClientException {
        updateGeoresourceAsBodyWithHttpInfo(georesourceId, featureData);
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
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param featureData feature data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateGeoresourceAsBodyWithHttpInfo(String georesourceId, GeoresourcePUTInputType featureData) throws RestClientException {
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

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the feature record of the selected georesource dataset feature
     * Modify/Update the feature record of the selected georesource dataset feature
     * <p><b>200</b> - OK - Updated
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param featureId the identifier of the geo-resource dataset feature (required)
     * @param featureRecordId the unique database record identifier of the geo-resource dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param georesourceFeatureRecordData georesource feature record data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateGeoresourceFeatureRecordAsBody(String georesourceId, String featureId, String featureRecordId, String georesourceFeatureRecordData) throws RestClientException {
        updateGeoresourceFeatureRecordAsBodyWithHttpInfo(georesourceId, featureId, featureRecordId, georesourceFeatureRecordData);
    }

    /**
     * Modify/Update the feature record of the selected georesource dataset feature
     * Modify/Update the feature record of the selected georesource dataset feature
     * <p><b>200</b> - OK - Updated
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param featureId the identifier of the geo-resource dataset feature (required)
     * @param featureRecordId the unique database record identifier of the geo-resource dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param georesourceFeatureRecordData georesource feature record data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateGeoresourceFeatureRecordAsBodyWithHttpInfo(String georesourceId, String featureId, String featureRecordId, String georesourceFeatureRecordData) throws RestClientException {
        Object localVarPostBody = georesourceFeatureRecordData;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling updateGeoresourceFeatureRecordAsBody");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling updateGeoresourceFeatureRecordAsBody");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling updateGeoresourceFeatureRecordAsBody");
        }
        
        // verify the required parameter 'georesourceFeatureRecordData' is set
        if (georesourceFeatureRecordData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceFeatureRecordData' when calling updateGeoresourceFeatureRecordAsBody");
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

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the metadata of the selected geo-resource dataset
     * Modify/Update the metadata of the selected geo-resource dataset. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param metadata metadata input (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateGeoresourceMetadataAsBody(String georesourceId, GeoresourcePATCHInputType metadata) throws RestClientException {
        updateGeoresourceMetadataAsBodyWithHttpInfo(georesourceId, metadata);
    }

    /**
     * Modify/Update the metadata of the selected geo-resource dataset
     * Modify/Update the metadata of the selected geo-resource dataset. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param metadata metadata input (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateGeoresourceMetadataAsBodyWithHttpInfo(String georesourceId, GeoresourcePATCHInputType metadata) throws RestClientException {
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

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * update the ownership for the selected geo-resource dataset
     * update the ownership for the selected geo-resource dataset
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param ownerInputType GeoResource ownership input (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateGeoresourceOwnership(String georesourceId, OwnerInputType ownerInputType) throws RestClientException {
        updateGeoresourceOwnershipWithHttpInfo(georesourceId, ownerInputType);
    }

    /**
     * update the ownership for the selected geo-resource dataset
     * update the ownership for the selected geo-resource dataset
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param ownerInputType GeoResource ownership input (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateGeoresourceOwnershipWithHttpInfo(String georesourceId, OwnerInputType ownerInputType) throws RestClientException {
        Object localVarPostBody = ownerInputType;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling updateGeoresourceOwnership");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}/ownership", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * update the permissions for the selected geo-resource dataset
     * update the permissions for the selected geo-resource dataset
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param permissionLevelInputType GeoResource permission level input (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateGeoresourcePermissions(String georesourceId, PermissionLevelInputType permissionLevelInputType) throws RestClientException {
        updateGeoresourcePermissionsWithHttpInfo(georesourceId, permissionLevelInputType);
    }

    /**
     * update the permissions for the selected geo-resource dataset
     * update the permissions for the selected geo-resource dataset
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param permissionLevelInputType GeoResource permission level input (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateGeoresourcePermissionsWithHttpInfo(String georesourceId, PermissionLevelInputType permissionLevelInputType) throws RestClientException {
        Object localVarPostBody = permissionLevelInputType;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling updateGeoresourcePermissions");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/georesources/{georesourceId}/permissions", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}

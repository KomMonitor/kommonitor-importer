package org.n52.kommonitor.datamanagement.api.client;

import jakarta.annotation.Generated;
import org.n52.kommonitor.datamanagement.api.ApiClient;

import java.math.BigDecimal;
import org.n52.kommonitor.models.OwnerInputType;
import org.n52.kommonitor.models.PermissionLevelInputType;
import org.n52.kommonitor.models.PermissionLevelType;
import org.n52.kommonitor.models.SpatialUnitOverviewType;
import org.n52.kommonitor.models.SpatialUnitPATCHInputType;
import org.n52.kommonitor.models.SpatialUnitPOSTInputType;
import org.n52.kommonitor.models.SpatialUnitPUTInputType;

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
@Component("org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi")
public class SpatialUnitsApi {
    private ApiClient apiClient;

    public SpatialUnitsApi() {
        this(new ApiClient());
    }

    @Autowired
    public SpatialUnitsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Add a new spatial-unit
     * Add/Register a spatial unit for a certain period of time
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param featureData feature data (required)
     * @return SpatialUnitOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SpatialUnitOverviewType addSpatialUnitAsBody(SpatialUnitPOSTInputType featureData) throws RestClientException {
        return addSpatialUnitAsBodyWithHttpInfo(featureData).getBody();
    }

    /**
     * Add a new spatial-unit
     * Add/Register a spatial unit for a certain period of time
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param featureData feature data (required)
     * @return ResponseEntity&lt;SpatialUnitOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SpatialUnitOverviewType> addSpatialUnitAsBodyWithHttpInfo(SpatialUnitPOSTInputType featureData) throws RestClientException {
        Object localVarPostBody = featureData;
        
        // verify the required parameter 'featureData' is set
        if (featureData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureData' when calling addSpatialUnitAsBody");
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

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<SpatialUnitOverviewType> localReturnType = new ParameterizedTypeReference<SpatialUnitOverviewType>() {};
        return apiClient.invokeAPI("/spatial-units", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete all features/contents of the selected spatial-unit dataset
     * Delete all features/contents of the selected spatial-unit dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteAllSpatialUnitFeaturesById(String spatialUnitId) throws RestClientException {
        deleteAllSpatialUnitFeaturesByIdWithHttpInfo(spatialUnitId);
    }

    /**
     * Delete all features/contents of the selected spatial-unit dataset
     * Delete all features/contents of the selected spatial-unit dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteAllSpatialUnitFeaturesByIdWithHttpInfo(String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteAllSpatialUnitFeaturesById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);

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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/allFeatures", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete all database records for the specified feature of the selected spatial-unit dataset
     * Delete all database records for the specified feature of the selected spatial-unit dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteSingleSpatialUnitFeatureById(String spatialUnitId, String featureId) throws RestClientException {
        deleteSingleSpatialUnitFeatureByIdWithHttpInfo(spatialUnitId, featureId);
    }

    /**
     * Delete all database records for the specified feature of the selected spatial-unit dataset
     * Delete all database records for the specified feature of the selected spatial-unit dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteSingleSpatialUnitFeatureByIdWithHttpInfo(String spatialUnitId, String featureId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteSingleSpatialUnitFeatureById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling deleteSingleSpatialUnitFeatureById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);
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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/singleFeature/{featureId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected spatial-unit dataset
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected spatial-unit dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param featureRecordId the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteSingleSpatialUnitFeatureRecordById(String spatialUnitId, String featureId, String featureRecordId) throws RestClientException {
        deleteSingleSpatialUnitFeatureRecordByIdWithHttpInfo(spatialUnitId, featureId, featureRecordId);
    }

    /**
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected spatial-unit dataset
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected spatial-unit dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param featureRecordId the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteSingleSpatialUnitFeatureRecordByIdWithHttpInfo(String spatialUnitId, String featureId, String featureRecordId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteSingleSpatialUnitFeatureRecordById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling deleteSingleSpatialUnitFeatureRecordById");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling deleteSingleSpatialUnitFeatureRecordById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);
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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected spatial-unit
     * Delete the features/contents of the selected spatial-unit
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteSpatialUnitById(String spatialUnitId) throws RestClientException {
        deleteSpatialUnitByIdWithHttpInfo(spatialUnitId);
    }

    /**
     * Delete the features/contents of the selected spatial-unit
     * Delete the features/contents of the selected spatial-unit
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteSpatialUnitByIdWithHttpInfo(String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteSpatialUnitById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);

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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected spatial-unit, year and month
     * Delete the features/contents of the selected spatial-unit, year and month
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteSpatialUnitByIdAndYearAndMonth(String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        deleteSpatialUnitByIdAndYearAndMonthWithHttpInfo(spatialUnitId, year, month, day);
    }

    /**
     * Delete the features/contents of the selected spatial-unit, year and month
     * Delete the features/contents of the selected spatial-unit, year and month
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteSpatialUnitByIdAndYearAndMonthWithHttpInfo(String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteSpatialUnitByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling deleteSpatialUnitByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling deleteSpatialUnitByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling deleteSpatialUnitByIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);
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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/{year}/{month}/{day}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param simplifyGeometries ontrols simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getAllSpatialUnitFeaturesById(String spatialUnitId, String simplifyGeometries) throws RestClientException {
        return getAllSpatialUnitFeaturesByIdWithHttpInfo(spatialUnitId, simplifyGeometries).getBody();
    }

    /**
     * retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param simplifyGeometries ontrols simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getAllSpatialUnitFeaturesByIdWithHttpInfo(String spatialUnitId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getAllSpatialUnitFeaturesById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);

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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/allFeatures", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getSingleSpatialUnitFeatureById(String spatialUnitId, String featureId, String simplifyGeometries) throws RestClientException {
        return getSingleSpatialUnitFeatureByIdWithHttpInfo(spatialUnitId, featureId, simplifyGeometries).getBody();
    }

    /**
     * retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getSingleSpatialUnitFeatureByIdWithHttpInfo(String spatialUnitId, String featureId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getSingleSpatialUnitFeatureById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getSingleSpatialUnitFeatureById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);
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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/singleFeature/{featureId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve single feature database record specified by its unique database primary key id
     * retrieve single feature database record specified by its unique database primary key id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param featureRecordId the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getSingleSpatialUnitFeatureRecordById(String spatialUnitId, String featureId, String featureRecordId, String simplifyGeometries) throws RestClientException {
        return getSingleSpatialUnitFeatureRecordByIdWithHttpInfo(spatialUnitId, featureId, featureRecordId, simplifyGeometries).getBody();
    }

    /**
     * retrieve single feature database record specified by its unique database primary key id
     * retrieve single feature database record specified by its unique database primary key id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param featureRecordId the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getSingleSpatialUnitFeatureRecordByIdWithHttpInfo(String spatialUnitId, String featureId, String featureRecordId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getSingleSpatialUnitFeatureRecordById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getSingleSpatialUnitFeatureRecordById");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling getSingleSpatialUnitFeatureRecordById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);
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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available features of different spatial units/levels
     * retrieve information about available features of different spatial units/levels
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;SpatialUnitOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<SpatialUnitOverviewType> getSpatialUnits() throws RestClientException {
        return getSpatialUnitsWithHttpInfo().getBody();
    }

    /**
     * retrieve information about available features of different spatial units/levels
     * retrieve information about available features of different spatial units/levels
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;List&lt;SpatialUnitOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<SpatialUnitOverviewType>> getSpatialUnitsWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<List<SpatialUnitOverviewType>> localReturnType = new ParameterizedTypeReference<List<SpatialUnitOverviewType>>() {};
        return apiClient.invokeAPI("/spatial-units", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available features of the selected spatial unit/level
     * retrieve information about available features of the selected spatial unit/level
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return SpatialUnitOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public SpatialUnitOverviewType getSpatialUnitsById(String spatialUnitId) throws RestClientException {
        return getSpatialUnitsByIdWithHttpInfo(spatialUnitId).getBody();
    }

    /**
     * retrieve information about available features of the selected spatial unit/level
     * retrieve information about available features of the selected spatial unit/level
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;SpatialUnitOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SpatialUnitOverviewType> getSpatialUnitsByIdWithHttpInfo(String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getSpatialUnitsById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
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

        ParameterizedTypeReference<SpatialUnitOverviewType> localReturnType = new ParameterizedTypeReference<SpatialUnitOverviewType>() {};
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON
     * retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getSpatialUnitsByIdAndYearAndMonth(String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        return getSpatialUnitsByIdAndYearAndMonthWithHttpInfo(spatialUnitId, year, month, day, simplifyGeometries).getBody();
    }

    /**
     * retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON
     * retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getSpatialUnitsByIdAndYearAndMonthWithHttpInfo(String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getSpatialUnitsByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getSpatialUnitsByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getSpatialUnitsByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getSpatialUnitsByIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/{year}/{month}/{day}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about the permissions for the selected spatial unit dataset
     * retrieve information about the permissions for the selected spatial unit dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId identifier of the spatial unit dataset (required)
     * @return List&lt;PermissionLevelType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<PermissionLevelType> getSpatialUnitsPermissionsById(String spatialUnitId) throws RestClientException {
        return getSpatialUnitsPermissionsByIdWithHttpInfo(spatialUnitId).getBody();
    }

    /**
     * retrieve information about the permissions for the selected spatial unit dataset
     * retrieve information about the permissions for the selected spatial unit dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId identifier of the spatial unit dataset (required)
     * @return ResponseEntity&lt;List&lt;PermissionLevelType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<PermissionLevelType>> getSpatialUnitsPermissionsByIdWithHttpInfo(String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getSpatialUnitsPermissionsById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
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

        ParameterizedTypeReference<List<PermissionLevelType>> localReturnType = new ParameterizedTypeReference<List<PermissionLevelType>>() {};
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/permissions", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the JSON schema for the selected spatial unit/level
     * retrieve the JSON schema for the selected spatial unit/level. The JSON schema indicates the property structure of the dataset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getSpatialUnitsSchemaById(String spatialUnitId) throws RestClientException {
        return getSpatialUnitsSchemaByIdWithHttpInfo(spatialUnitId).getBody();
    }

    /**
     * retrieve the JSON schema for the selected spatial unit/level
     * retrieve the JSON schema for the selected spatial unit/level. The JSON schema indicates the property structure of the dataset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getSpatialUnitsSchemaByIdWithHttpInfo(String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getSpatialUnitsSchemaById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
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

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/schema", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the features of the selected spatial-unit
     * Modify/Update the features of the selected spatial-unit. The interface expects a full upload of all geometries for the spatial unit. Internally, those geometries are compared to the existing ones to mark &#39;old&#39; geometries that are no longer in use as outdated. Hence, each geometric object is only persisted once and its use is controlled by time validity marks.
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureData feature data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateSpatialUnitAsBody(String spatialUnitId, SpatialUnitPUTInputType featureData) throws RestClientException {
        updateSpatialUnitAsBodyWithHttpInfo(spatialUnitId, featureData);
    }

    /**
     * Modify/Update the features of the selected spatial-unit
     * Modify/Update the features of the selected spatial-unit. The interface expects a full upload of all geometries for the spatial unit. Internally, those geometries are compared to the existing ones to mark &#39;old&#39; geometries that are no longer in use as outdated. Hence, each geometric object is only persisted once and its use is controlled by time validity marks.
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureData feature data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateSpatialUnitAsBodyWithHttpInfo(String spatialUnitId, SpatialUnitPUTInputType featureData) throws RestClientException {
        Object localVarPostBody = featureData;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling updateSpatialUnitAsBody");
        }
        
        // verify the required parameter 'featureData' is set
        if (featureData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureData' when calling updateSpatialUnitAsBody");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);

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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the feature record of the selected spatial-unit dataset feature
     * Modify/Update the feature record of the selected spatial-unit dataset feature
     * <p><b>200</b> - OK - Updated
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param featureRecordId the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param spatialUnitFeatureRecordData spatial-unit feature record data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateSpatialUnitFeatureRecordAsBody(String spatialUnitId, String featureId, String featureRecordId, String spatialUnitFeatureRecordData) throws RestClientException {
        updateSpatialUnitFeatureRecordAsBodyWithHttpInfo(spatialUnitId, featureId, featureRecordId, spatialUnitFeatureRecordData);
    }

    /**
     * Modify/Update the feature record of the selected spatial-unit dataset feature
     * Modify/Update the feature record of the selected spatial-unit dataset feature
     * <p><b>200</b> - OK - Updated
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param featureRecordId the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param spatialUnitFeatureRecordData spatial-unit feature record data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateSpatialUnitFeatureRecordAsBodyWithHttpInfo(String spatialUnitId, String featureId, String featureRecordId, String spatialUnitFeatureRecordData) throws RestClientException {
        Object localVarPostBody = spatialUnitFeatureRecordData;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling updateSpatialUnitFeatureRecordAsBody");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling updateSpatialUnitFeatureRecordAsBody");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling updateSpatialUnitFeatureRecordAsBody");
        }
        
        // verify the required parameter 'spatialUnitFeatureRecordData' is set
        if (spatialUnitFeatureRecordData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitFeatureRecordData' when calling updateSpatialUnitFeatureRecordAsBody");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);
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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the metadata of the selected spatial-unit
     * Modify/Update the metadata of the selected spatial-unit. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param metadata metadata input (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateSpatialUnitMetadataAsBody(String spatialUnitId, SpatialUnitPATCHInputType metadata) throws RestClientException {
        updateSpatialUnitMetadataAsBodyWithHttpInfo(spatialUnitId, metadata);
    }

    /**
     * Modify/Update the metadata of the selected spatial-unit
     * Modify/Update the metadata of the selected spatial-unit. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param metadata metadata input (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateSpatialUnitMetadataAsBodyWithHttpInfo(String spatialUnitId, SpatialUnitPATCHInputType metadata) throws RestClientException {
        Object localVarPostBody = metadata;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling updateSpatialUnitMetadataAsBody");
        }
        
        // verify the required parameter 'metadata' is set
        if (metadata == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'metadata' when calling updateSpatialUnitMetadataAsBody");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);

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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * update information about the ownership for the selected spatial unit dataset
     * update information about the ownership for the selected spatial unit dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId identifier of the spatial unit dataset (required)
     * @param ownerInputType Spatial unit ownership input. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateSpatialUnitsOwnership(String spatialUnitId, OwnerInputType ownerInputType) throws RestClientException {
        updateSpatialUnitsOwnershipWithHttpInfo(spatialUnitId, ownerInputType);
    }

    /**
     * update information about the ownership for the selected spatial unit dataset
     * update information about the ownership for the selected spatial unit dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId identifier of the spatial unit dataset (required)
     * @param ownerInputType Spatial unit ownership input. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateSpatialUnitsOwnershipWithHttpInfo(String spatialUnitId, OwnerInputType ownerInputType) throws RestClientException {
        Object localVarPostBody = ownerInputType;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling updateSpatialUnitsOwnership");
        }
        
        // verify the required parameter 'ownerInputType' is set
        if (ownerInputType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ownerInputType' when calling updateSpatialUnitsOwnership");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);

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
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/ownership", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * update information about the permissions for the selected spatial unit dataset
     * update information about the permissions for the selected spatial unit dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId identifier of the spatial unit dataset (required)
     * @param permissionLevelInputType Spatial unit permission level input. (required)
     * @return List&lt;PermissionLevelType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<PermissionLevelType> updateSpatialUnitsPermissions(String spatialUnitId, PermissionLevelInputType permissionLevelInputType) throws RestClientException {
        return updateSpatialUnitsPermissionsWithHttpInfo(spatialUnitId, permissionLevelInputType).getBody();
    }

    /**
     * update information about the permissions for the selected spatial unit dataset
     * update information about the permissions for the selected spatial unit dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param spatialUnitId identifier of the spatial unit dataset (required)
     * @param permissionLevelInputType Spatial unit permission level input. (required)
     * @return ResponseEntity&lt;List&lt;PermissionLevelType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<PermissionLevelType>> updateSpatialUnitsPermissionsWithHttpInfo(String spatialUnitId, PermissionLevelInputType permissionLevelInputType) throws RestClientException {
        Object localVarPostBody = permissionLevelInputType;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling updateSpatialUnitsPermissions");
        }
        
        // verify the required parameter 'permissionLevelInputType' is set
        if (permissionLevelInputType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'permissionLevelInputType' when calling updateSpatialUnitsPermissions");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);

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

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<List<PermissionLevelType>> localReturnType = new ParameterizedTypeReference<List<PermissionLevelType>>() {};
        return apiClient.invokeAPI("/spatial-units/{spatialUnitId}/permissions", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}

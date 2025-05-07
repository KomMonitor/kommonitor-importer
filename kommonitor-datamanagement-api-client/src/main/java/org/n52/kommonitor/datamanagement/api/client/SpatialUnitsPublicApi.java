package org.n52.kommonitor.datamanagement.api.client;

import jakarta.annotation.Generated;
import org.n52.kommonitor.datamanagement.api.ApiClient;

import java.math.BigDecimal;
import org.n52.kommonitor.models.SpatialUnitOverviewType;

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

@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-01-30T13:33:53.805125800+01:00[Europe/Berlin]")
@Component("org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicApi")
public class SpatialUnitsPublicApi {
    private ApiClient apiClient;

    public SpatialUnitsPublicApi() {
        this(new ApiClient());
    }

    @Autowired
    public SpatialUnitsPublicApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
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
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getAllPublicSpatialUnitFeaturesById(String spatialUnitId, String simplifyGeometries) throws RestClientException {
        return getAllPublicSpatialUnitFeaturesByIdWithHttpInfo(spatialUnitId, simplifyGeometries).getBody();
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
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getAllPublicSpatialUnitFeaturesByIdWithHttpInfo(String spatialUnitId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getAllPublicSpatialUnitFeaturesById");
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
        return apiClient.invokeAPI("/public/spatial-units/{spatialUnitId}/allFeatures", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getPublicSingleSpatialUnitFeatureById(String featureId, String spatialUnitId, String simplifyGeometries) throws RestClientException {
        return getPublicSingleSpatialUnitFeatureByIdWithHttpInfo(featureId, spatialUnitId, simplifyGeometries).getBody();
    }

    /**
     * retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getPublicSingleSpatialUnitFeatureByIdWithHttpInfo(String featureId, String spatialUnitId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getPublicSingleSpatialUnitFeatureById");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicSingleSpatialUnitFeatureById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("featureId", featureId);
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
        return apiClient.invokeAPI("/public/spatial-units/{spatialUnitId}/singleFeature/{featureId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve single feature database record specified by its unique database primary key id
     * retrieve single feature database record specified by its unique database primary key id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param featureRecordId the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getPublicSingleSpatialUnitFeatureRecordById(String featureId, String featureRecordId, String spatialUnitId, String simplifyGeometries) throws RestClientException {
        return getPublicSingleSpatialUnitFeatureRecordByIdWithHttpInfo(featureId, featureRecordId, spatialUnitId, simplifyGeometries).getBody();
    }

    /**
     * retrieve single feature database record specified by its unique database primary key id
     * retrieve single feature database record specified by its unique database primary key id
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param featureId the identifier of the spatial-unit dataset feature (required)
     * @param featureRecordId the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param spatialUnitId the identifier of the spatial-unit dataset (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getPublicSingleSpatialUnitFeatureRecordByIdWithHttpInfo(String featureId, String featureRecordId, String spatialUnitId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getPublicSingleSpatialUnitFeatureRecordById");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling getPublicSingleSpatialUnitFeatureRecordById");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicSingleSpatialUnitFeatureRecordById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("featureId", featureId);
        uriVariables.put("featureRecordId", featureRecordId);
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
        return apiClient.invokeAPI("/public/spatial-units/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
    public List<SpatialUnitOverviewType> getPublicSpatialUnits() throws RestClientException {
        return getPublicSpatialUnitsWithHttpInfo().getBody();
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
    public ResponseEntity<List<SpatialUnitOverviewType>> getPublicSpatialUnitsWithHttpInfo() throws RestClientException {
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
        return apiClient.invokeAPI("/public/spatial-units", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
    public SpatialUnitOverviewType getPublicSpatialUnitsById(String spatialUnitId) throws RestClientException {
        return getPublicSpatialUnitsByIdWithHttpInfo(spatialUnitId).getBody();
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
    public ResponseEntity<SpatialUnitOverviewType> getPublicSpatialUnitsByIdWithHttpInfo(String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicSpatialUnitsById");
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
        return apiClient.invokeAPI("/public/spatial-units/{spatialUnitId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
    public byte[] getPublicSpatialUnitsByIdAndYearAndMonth(String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        return getPublicSpatialUnitsByIdAndYearAndMonthWithHttpInfo(spatialUnitId, year, month, day, simplifyGeometries).getBody();
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
    public ResponseEntity<byte[]> getPublicSpatialUnitsByIdAndYearAndMonthWithHttpInfo(String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicSpatialUnitsByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getPublicSpatialUnitsByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getPublicSpatialUnitsByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getPublicSpatialUnitsByIdAndYearAndMonth");
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
        return apiClient.invokeAPI("/public/spatial-units/{spatialUnitId}/{year}/{month}/{day}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
    public String getPublicSpatialUnitsSchemaById(String spatialUnitId) throws RestClientException {
        return getPublicSpatialUnitsSchemaByIdWithHttpInfo(spatialUnitId).getBody();
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
    public ResponseEntity<String> getPublicSpatialUnitsSchemaByIdWithHttpInfo(String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getPublicSpatialUnitsSchemaById");
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
        return apiClient.invokeAPI("/public/spatial-units/{spatialUnitId}/schema", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}

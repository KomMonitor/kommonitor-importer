package org.n52.kommonitor.datamanagement.api.legacy.client;

import org.n52.kommonitor.datamanagement.api.legacy.ApiClient;

import java.math.BigDecimal;

import org.n52.kommonitor.models.SpatialUnitOverviewType;
import org.n52.kommonitor.models.SpatialUnitPATCHInputType;
import org.n52.kommonitor.models.SpatialUnitPOSTInputType;
import org.n52.kommonitor.models.SpatialUnitPUTInputType;

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
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param featureData feature data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void addSpatialUnitAsBody(SpatialUnitPOSTInputType featureData) throws RestClientException {
        addSpatialUnitAsBodyWithHttpInfo(featureData);
    }

    /**
     * Add a new spatial-unit
     * Add/Register a spatial unit for a certain period of time
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param featureData feature data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> addSpatialUnitAsBodyWithHttpInfo(SpatialUnitPOSTInputType featureData) throws RestClientException {
        Object postBody = featureData;
        
        // verify the required parameter 'featureData' is set
        if (featureData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureData' when calling addSpatialUnitAsBody");
        }
        
        String path = UriComponentsBuilder.fromPath("/spatial-units").build().toUriString();

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
     * Delete the features/contents of the selected spatial-unit
     * Delete the features/contents of the selected spatial-unit
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
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
     * <p><b>401</b> - API key is missing or invalid
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteSpatialUnitByIdWithHttpInfo(String spatialUnitId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteSpatialUnitById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);
        String path = UriComponentsBuilder.fromPath("/spatial-units/{spatialUnitId}").buildAndExpand(uriVariables).toUriString();

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
     * Delete the features/contents of the selected spatial-unit, year and month
     * Delete the features/contents of the selected spatial-unit, year and month
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
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
     * <p><b>401</b> - API key is missing or invalid
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteSpatialUnitByIdAndYearAndMonthWithHttpInfo(String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        Object postBody = null;
        
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
        String path = UriComponentsBuilder.fromPath("/spatial-units/{spatialUnitId}/{year}/{month}/{day}").buildAndExpand(uriVariables).toUriString();

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
     * retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAllSpatialUnitFeaturesById(String spatialUnitId, String simplifyGeometries) throws RestClientException {
        return getAllSpatialUnitFeaturesByIdWithHttpInfo(spatialUnitId, simplifyGeometries).getBody();
    }

    /**
     * retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAllSpatialUnitFeaturesByIdWithHttpInfo(String spatialUnitId, String simplifyGeometries) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getAllSpatialUnitFeaturesById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);
        String path = UriComponentsBuilder.fromPath("/spatial-units/{spatialUnitId}/allFeatures").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve information about available features of different spatial units/levels
     * retrieve information about available features of different spatial units/levels
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
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
     * @return ResponseEntity&lt;List&lt;SpatialUnitOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<SpatialUnitOverviewType>> getSpatialUnitsWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/spatial-units").build().toUriString();

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

        ParameterizedTypeReference<List<SpatialUnitOverviewType>> returnType = new ParameterizedTypeReference<List<SpatialUnitOverviewType>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve information about available features of the selected spatial unit/level
     * retrieve information about available features of the selected spatial unit/level
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
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
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;SpatialUnitOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<SpatialUnitOverviewType> getSpatialUnitsByIdWithHttpInfo(String spatialUnitId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getSpatialUnitsById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);
        String path = UriComponentsBuilder.fromPath("/spatial-units/{spatialUnitId}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<SpatialUnitOverviewType> returnType = new ParameterizedTypeReference<SpatialUnitOverviewType>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON
     * retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
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
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getSpatialUnitsByIdAndYearAndMonthWithHttpInfo(String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        Object postBody = null;
        
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
        String path = UriComponentsBuilder.fromPath("/spatial-units/{spatialUnitId}/{year}/{month}/{day}").buildAndExpand(uriVariables).toUriString();

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
     * retrieve the JSON schema for the selected spatial unit/level
     * retrieve the JSON schema for the selected spatial unit/level. The JSON schema indicates the property structure of the dataset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
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
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getSpatialUnitsSchemaByIdWithHttpInfo(String spatialUnitId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getSpatialUnitsSchemaById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("spatialUnitId", spatialUnitId);
        String path = UriComponentsBuilder.fromPath("/spatial-units/{spatialUnitId}/schema").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Modify/Update the features of the selected spatial-unit
     * Modify/Update the features of the selected spatial-unit. The interface expects a full upload of all geometries for the spatial unit. Internally, those geometries are compared to the existing ones to mark &#39;old&#39; geometries that are no longer in use as outdated. Hence, each geometric object is only persisted once and its use is controlled by time validity marks.
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
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
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureData feature data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateSpatialUnitAsBodyWithHttpInfo(String spatialUnitId, SpatialUnitPUTInputType featureData) throws RestClientException {
        Object postBody = featureData;
        
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
        String path = UriComponentsBuilder.fromPath("/spatial-units/{spatialUnitId}").buildAndExpand(uriVariables).toUriString();

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
     * Modify/Update the metadata of the selected spatial-unit
     * Modify/Update the metadata of the selected spatial-unit. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
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
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param metadata metadata input (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateSpatialUnitMetadataAsBodyWithHttpInfo(String spatialUnitId, SpatialUnitPATCHInputType metadata) throws RestClientException {
        Object postBody = metadata;
        
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
        String path = UriComponentsBuilder.fromPath("/spatial-units/{spatialUnitId}").buildAndExpand(uriVariables).toUriString();

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

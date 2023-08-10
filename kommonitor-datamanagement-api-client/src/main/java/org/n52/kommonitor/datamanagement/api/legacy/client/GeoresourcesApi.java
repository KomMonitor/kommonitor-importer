package org.n52.kommonitor.datamanagement.api.legacy.client;

import org.n52.kommonitor.datamanagement.api.legacy.ApiClient;

import java.math.BigDecimal;

import org.n52.kommonitor.models.GeoresourceOverviewType;
import org.n52.kommonitor.models.GeoresourcePATCHInputType;
import org.n52.kommonitor.models.GeoresourcePOSTInputType;
import org.n52.kommonitor.models.GeoresourcePUTInputType;

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
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param featureData feature data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void addGeoresourceAsBody(GeoresourcePOSTInputType featureData) throws RestClientException {
        addGeoresourceAsBodyWithHttpInfo(featureData);
    }

    /**
     * Add a new geo-resource
     * Add/Register a geo-resource dataset for a certain period of time
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param featureData feature data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> addGeoresourceAsBodyWithHttpInfo(GeoresourcePOSTInputType featureData) throws RestClientException {
        Object postBody = featureData;
        
        // verify the required parameter 'featureData' is set
        if (featureData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureData' when calling addGeoresourceAsBody");
        }
        
        String path = UriComponentsBuilder.fromPath("/georesources").build().toUriString();

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
     * Delete the features/contents of the selected geo-resource dataset
     * Delete the features/contents of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
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
     * <p><b>401</b> - API key is missing or invalid
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteGeoresourceByIdWithHttpInfo(String georesourceId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling deleteGeoresourceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);
        String path = UriComponentsBuilder.fromPath("/georesources/{georesourceId}").buildAndExpand(uriVariables).toUriString();

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
     * Delete the features/contents of the selected geo-resource dataset, selected by year and month
     * Delete the features/contents of the selected geo-resource dataset, selected by year and month
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
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
     * <p><b>401</b> - API key is missing or invalid
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteGeoresourceByIdAndYearAndMonthWithHttpInfo(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        Object postBody = null;
        
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
        String path = UriComponentsBuilder.fromPath("/georesources/{georesourceId}/{year}/{month}/{day}").buildAndExpand(uriVariables).toUriString();

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
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAllGeoresourceFeaturesById(String georesourceId, String simplifyGeometries) throws RestClientException {
        return getAllGeoresourceFeaturesByIdWithHttpInfo(georesourceId, simplifyGeometries).getBody();
    }

    /**
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAllGeoresourceFeaturesByIdWithHttpInfo(String georesourceId, String simplifyGeometries) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getAllGeoresourceFeaturesById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);
        String path = UriComponentsBuilder.fromPath("/georesources/{georesourceId}/allFeatures").buildAndExpand(uriVariables).toUriString();

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
     * retrieve information about available features of the selected geo-resource dataset
     * retrieve information about available features of the selected geo-resource dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
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
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @return ResponseEntity&lt;GeoresourceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<GeoresourceOverviewType> getGeoresourceByIdWithHttpInfo(String georesourceId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getGeoresourceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);
        String path = UriComponentsBuilder.fromPath("/georesources/{georesourceId}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<GeoresourceOverviewType> returnType = new ParameterizedTypeReference<GeoresourceOverviewType>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON
     * retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
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
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param year year for which datasets shall be queried (required)
     * @param month month for which datasets shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getGeoresourceByIdAndYearAndMonthWithHttpInfo(String georesourceId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        Object postBody = null;
        
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
        String path = UriComponentsBuilder.fromPath("/georesources/{georesourceId}/{year}/{month}/{day}").buildAndExpand(uriVariables).toUriString();

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
     * retrieve the JSON schema for the selected geo-resource dataset
     * retrieve the JSON schema for the selected geo-resource dataset. The JSON schema indicates the property structure of the dataset.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
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
     * @param georesourceId the identifier of the geo-resource dataset (required)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getGeoresourceSchemaByLevelWithHttpInfo(String georesourceId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'georesourceId' is set
        if (georesourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceId' when calling getGeoresourceSchemaByLevel");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("georesourceId", georesourceId);
        String path = UriComponentsBuilder.fromPath("/georesources/{georesourceId}/schema").buildAndExpand(uriVariables).toUriString();

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
     * retrieve information about available features of different geo-resource datasets
     * retrieve information about available features of different geo-resource datasets
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
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
     * @return ResponseEntity&lt;List&lt;GeoresourceOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<GeoresourceOverviewType>> getGeoresourcesWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/georesources").build().toUriString();

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

        ParameterizedTypeReference<List<GeoresourceOverviewType>> returnType = new ParameterizedTypeReference<List<GeoresourceOverviewType>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Modify/Update the features of the selected geo-resource dataset
     * Modify/Update the features of the selected geo-resource dataset.  The interface expects a full upload of all geometries for the spatial unit. Internally, those geometries are compared to the existing ones to mark &#39;old&#39; geometries that are no longer in use as outdated. Hence, each geometric object is only persisted once and its use is controlled by time validity marks.
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
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
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param featureData feature data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateGeoresourceAsBodyWithHttpInfo(String georesourceId, GeoresourcePUTInputType featureData) throws RestClientException {
        Object postBody = featureData;
        
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
        String path = UriComponentsBuilder.fromPath("/georesources/{georesourceId}").buildAndExpand(uriVariables).toUriString();

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
     * Modify/Update the metadata of the selected geo-resource dataset
     * Modify/Update the metadata of the selected geo-resource dataset. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
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
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param georesourceId identifier of the geo-resource dataset (required)
     * @param metadata metadata input (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateGeoresourceMetadataAsBodyWithHttpInfo(String georesourceId, GeoresourcePATCHInputType metadata) throws RestClientException {
        Object postBody = metadata;
        
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
        String path = UriComponentsBuilder.fromPath("/georesources/{georesourceId}").buildAndExpand(uriVariables).toUriString();

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

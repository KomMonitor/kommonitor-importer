package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;

import org.n52.kommonitor.models.TopicInputType;
import org.n52.kommonitor.models.TopicOverviewType;

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
@Component("org.n52.kommonitor.datamanagement.api.client.TopicsApi")
public class TopicsApi {
    private ApiClient apiClient;

    public TopicsApi() {
        this(new ApiClient());
    }

    @Autowired
    public TopicsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Register a new topic
     * Add/Register a topic
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param topicData topic input data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void addTopic(TopicInputType topicData) throws RestClientException {
        addTopicWithHttpInfo(topicData);
    }

    /**
     * Register a new topic
     * Add/Register a topic
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param topicData topic input data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> addTopicWithHttpInfo(TopicInputType topicData) throws RestClientException {
        Object postBody = topicData;
        
        // verify the required parameter 'topicData' is set
        if (topicData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'topicData' when calling addTopic");
        }
        
        String path = UriComponentsBuilder.fromPath("/topics").build().toUriString();

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
     * Delete the topic
     * Delete the topic
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * @param topicId unique identifier of the topic (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTopic(String topicId) throws RestClientException {
        deleteTopicWithHttpInfo(topicId);
    }

    /**
     * Delete the topic
     * Delete the topic
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * @param topicId unique identifier of the topic (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTopicWithHttpInfo(String topicId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'topicId' is set
        if (topicId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'topicId' when calling deleteTopic");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("topicId", topicId);
        String path = UriComponentsBuilder.fromPath("/topics/{topicId}").buildAndExpand(uriVariables).toUriString();

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
     * retrieve information about the selected topic
     * retrieve information about the selected topic
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param topicId unique identifier of the topic (required)
     * @return TopicOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TopicOverviewType getTopicById(String topicId) throws RestClientException {
        return getTopicByIdWithHttpInfo(topicId).getBody();
    }

    /**
     * retrieve information about the selected topic
     * retrieve information about the selected topic
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param topicId unique identifier of the topic (required)
     * @return ResponseEntity&lt;TopicOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TopicOverviewType> getTopicByIdWithHttpInfo(String topicId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'topicId' is set
        if (topicId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'topicId' when calling getTopicById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("topicId", topicId);
        String path = UriComponentsBuilder.fromPath("/topics/{topicId}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<TopicOverviewType> returnType = new ParameterizedTypeReference<TopicOverviewType>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve information about available topics
     * retrieve information about available topics
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @return List&lt;TopicOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<TopicOverviewType> getTopics() throws RestClientException {
        return getTopicsWithHttpInfo().getBody();
    }

    /**
     * retrieve information about available topics
     * retrieve information about available topics
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @return ResponseEntity&lt;List&lt;TopicOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<TopicOverviewType>> getTopicsWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/topics").build().toUriString();

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

        ParameterizedTypeReference<List<TopicOverviewType>> returnType = new ParameterizedTypeReference<List<TopicOverviewType>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Modify topic information
     * Modify topic information
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param topicId unique identifier of the topic (required)
     * @param topicData topic input data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateTopic(String topicId, TopicInputType topicData) throws RestClientException {
        updateTopicWithHttpInfo(topicId, topicData);
    }

    /**
     * Modify topic information
     * Modify topic information
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param topicId unique identifier of the topic (required)
     * @param topicData topic input data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateTopicWithHttpInfo(String topicId, TopicInputType topicData) throws RestClientException {
        Object postBody = topicData;
        
        // verify the required parameter 'topicId' is set
        if (topicId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'topicId' when calling updateTopic");
        }
        
        // verify the required parameter 'topicData' is set
        if (topicData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'topicData' when calling updateTopic");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("topicId", topicId);
        String path = UriComponentsBuilder.fromPath("/topics/{topicId}").buildAndExpand(uriVariables).toUriString();

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
}

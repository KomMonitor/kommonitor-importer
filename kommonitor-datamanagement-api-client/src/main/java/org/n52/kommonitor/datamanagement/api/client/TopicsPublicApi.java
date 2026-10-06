package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.BaseApi;

import org.n52.kommonitor.models.TopicDisplayOrderModeOverviewType;
import org.n52.kommonitor.models.TopicOverviewType;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-10-06T12:33:28.182741500+02:00[Europe/Berlin]", comments = "Generator version: 7.23.0")
@Component("org.n52.kommonitor.datamanagement.api.client.TopicsPublicApi")
public class TopicsPublicApi extends BaseApi {

    public TopicsPublicApi() {
        super(new ApiClient());
    }

    @Autowired
    public TopicsPublicApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * retrieve information about the selected topic
     * retrieve information about the selected topic
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
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
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param topicId unique identifier of the topic (required)
     * @return ResponseEntity&lt;TopicOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TopicOverviewType> getTopicByIdWithHttpInfo(String topicId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'topicId' is set
        if (topicId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'topicId' when calling getTopicById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("topicId", topicId);

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

        ParameterizedTypeReference<TopicOverviewType> localReturnType = new ParameterizedTypeReference<TopicOverviewType>() {};
        return apiClient.invokeAPI("/public/topics/{topicId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available topics
     * retrieve information about available topics
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param topicType Controls whether only topics for indicators or georesources should be returned. Supported values are [&#39;georesource&#39;, &#39;indicator&#39;] (optional)
     * @return List&lt;TopicOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<TopicOverviewType> getTopics(String topicType) throws RestClientException {
        return getTopicsWithHttpInfo(topicType).getBody();
    }

    /**
     * retrieve information about available topics
     * retrieve information about available topics
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param topicType Controls whether only topics for indicators or georesources should be returned. Supported values are [&#39;georesource&#39;, &#39;indicator&#39;] (optional)
     * @return ResponseEntity&lt;List&lt;TopicOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<TopicOverviewType>> getTopicsWithHttpInfo(String topicType) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "topicType", topicType));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<List<TopicOverviewType>> localReturnType = new ParameterizedTypeReference<List<TopicOverviewType>>() {};
        return apiClient.invokeAPI("/public/topics", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * the topics display order mode for georesources and indicators
     * the topics display order mode for georesources and indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;TopicDisplayOrderModeOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<TopicDisplayOrderModeOverviewType> getTopicsDisplayOrderMode() throws RestClientException {
        return getTopicsDisplayOrderModeWithHttpInfo().getBody();
    }

    /**
     * the topics display order mode for georesources and indicators
     * the topics display order mode for georesources and indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;List&lt;TopicDisplayOrderModeOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<TopicDisplayOrderModeOverviewType>> getTopicsDisplayOrderModeWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<List<TopicDisplayOrderModeOverviewType>> localReturnType = new ParameterizedTypeReference<List<TopicDisplayOrderModeOverviewType>>() {};
        return apiClient.invokeAPI("/public/topics/display-order/mode", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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

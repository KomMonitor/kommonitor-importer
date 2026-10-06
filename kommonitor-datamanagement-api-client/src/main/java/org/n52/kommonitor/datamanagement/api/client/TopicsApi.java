package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.BaseApi;

import org.n52.kommonitor.models.TopicDisplayOrderInputType;
import org.n52.kommonitor.models.TopicDisplayOrderModeInputType;
import org.n52.kommonitor.models.TopicInputType;
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
@Component("org.n52.kommonitor.datamanagement.api.client.TopicsApi")
public class TopicsApi extends BaseApi {

    public TopicsApi() {
        super(new ApiClient());
    }

    @Autowired
    public TopicsApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Register a new topic
     * Add/Register a topic
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param topicData topic input data (required)
     * @return TopicOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TopicOverviewType addTopic(TopicInputType topicData) throws RestClientException {
        return addTopicWithHttpInfo(topicData).getBody();
    }

    /**
     * Register a new topic
     * Add/Register a topic
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param topicData topic input data (required)
     * @return ResponseEntity&lt;TopicOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TopicOverviewType> addTopicWithHttpInfo(TopicInputType topicData) throws RestClientException {
        Object localVarPostBody = topicData;
        
        // verify the required parameter 'topicData' is set
        if (topicData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'topicData' when calling addTopic");
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

        ParameterizedTypeReference<TopicOverviewType> localReturnType = new ParameterizedTypeReference<TopicOverviewType>() {};
        return apiClient.invokeAPI("/topics", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the topic
     * Delete the topic
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
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
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param topicId unique identifier of the topic (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteTopicWithHttpInfo(String topicId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'topicId' is set
        if (topicId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'topicId' when calling deleteTopic");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("topicId", topicId);

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
        return apiClient.invokeAPI("/topics/{topicId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update display order for submitted georesources main topics
     * Update displayOrder for submitted georesources main topics
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param mainGeoresourceTopicOrderArray array of georesource main topic id and display order (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateGeoresourceMainTopicDisplayOrder(List<TopicDisplayOrderInputType> mainGeoresourceTopicOrderArray) throws RestClientException {
        updateGeoresourceMainTopicDisplayOrderWithHttpInfo(mainGeoresourceTopicOrderArray);
    }

    /**
     * Update display order for submitted georesources main topics
     * Update displayOrder for submitted georesources main topics
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param mainGeoresourceTopicOrderArray array of georesource main topic id and display order (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateGeoresourceMainTopicDisplayOrderWithHttpInfo(List<TopicDisplayOrderInputType> mainGeoresourceTopicOrderArray) throws RestClientException {
        Object localVarPostBody = mainGeoresourceTopicOrderArray;
        
        // verify the required parameter 'mainGeoresourceTopicOrderArray' is set
        if (mainGeoresourceTopicOrderArray == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'mainGeoresourceTopicOrderArray' when calling updateGeoresourceMainTopicDisplayOrder");
        }
        

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
        return apiClient.invokeAPI("/topics/georesources/display-order", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update the display order mode for georesource topics
     * Update the display order mode for georesource topics
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param georesourceTopicOrderMode display order mode for georesource (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateGeoresourcesTopicDisplayOrderMode(TopicDisplayOrderModeInputType georesourceTopicOrderMode) throws RestClientException {
        updateGeoresourcesTopicDisplayOrderModeWithHttpInfo(georesourceTopicOrderMode);
    }

    /**
     * Update the display order mode for georesource topics
     * Update the display order mode for georesource topics
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param georesourceTopicOrderMode display order mode for georesource (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateGeoresourcesTopicDisplayOrderModeWithHttpInfo(TopicDisplayOrderModeInputType georesourceTopicOrderMode) throws RestClientException {
        Object localVarPostBody = georesourceTopicOrderMode;
        
        // verify the required parameter 'georesourceTopicOrderMode' is set
        if (georesourceTopicOrderMode == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'georesourceTopicOrderMode' when calling updateGeoresourcesTopicDisplayOrderMode");
        }
        

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
        return apiClient.invokeAPI("/topics/georesources/display-order/mode", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update display order for submitted indicators main topics
     * Update display order for submitted indicators main topics
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorMainTopicOrderArray array of indicator main topic id and display order (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorsMainTopicDisplayOrder(List<TopicDisplayOrderInputType> indicatorMainTopicOrderArray) throws RestClientException {
        updateIndicatorsMainTopicDisplayOrderWithHttpInfo(indicatorMainTopicOrderArray);
    }

    /**
     * Update display order for submitted indicators main topics
     * Update display order for submitted indicators main topics
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorMainTopicOrderArray array of indicator main topic id and display order (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorsMainTopicDisplayOrderWithHttpInfo(List<TopicDisplayOrderInputType> indicatorMainTopicOrderArray) throws RestClientException {
        Object localVarPostBody = indicatorMainTopicOrderArray;
        
        // verify the required parameter 'indicatorMainTopicOrderArray' is set
        if (indicatorMainTopicOrderArray == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorMainTopicOrderArray' when calling updateIndicatorsMainTopicDisplayOrder");
        }
        

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
        return apiClient.invokeAPI("/topics/indicators/display-order", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update the display order mode for indicator topics
     * Update the display order mode for indicator topics
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorTopicOrderMode display order mode for indicators (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorsTopicDisplayOrderMode(TopicDisplayOrderModeInputType indicatorTopicOrderMode) throws RestClientException {
        updateIndicatorsTopicDisplayOrderModeWithHttpInfo(indicatorTopicOrderMode);
    }

    /**
     * Update the display order mode for indicator topics
     * Update the display order mode for indicator topics
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorTopicOrderMode display order mode for indicators (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorsTopicDisplayOrderModeWithHttpInfo(TopicDisplayOrderModeInputType indicatorTopicOrderMode) throws RestClientException {
        Object localVarPostBody = indicatorTopicOrderMode;
        
        // verify the required parameter 'indicatorTopicOrderMode' is set
        if (indicatorTopicOrderMode == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorTopicOrderMode' when calling updateIndicatorsTopicDisplayOrderMode");
        }
        

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
        return apiClient.invokeAPI("/topics/indicators/display-order/mode", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update display order for submitted subtopics
     * Update display order for submitted subtopics
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param topicId unique identifier of the topic (required)
     * @param subtopicOrderArray array of subtopic id and display order items (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateSubtopicDisplayOrder(String topicId, List<TopicDisplayOrderInputType> subtopicOrderArray) throws RestClientException {
        updateSubtopicDisplayOrderWithHttpInfo(topicId, subtopicOrderArray);
    }

    /**
     * Update display order for submitted subtopics
     * Update display order for submitted subtopics
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param topicId unique identifier of the topic (required)
     * @param subtopicOrderArray array of subtopic id and display order items (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateSubtopicDisplayOrderWithHttpInfo(String topicId, List<TopicDisplayOrderInputType> subtopicOrderArray) throws RestClientException {
        Object localVarPostBody = subtopicOrderArray;
        
        // verify the required parameter 'topicId' is set
        if (topicId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'topicId' when calling updateSubtopicDisplayOrder");
        }
        
        // verify the required parameter 'subtopicOrderArray' is set
        if (subtopicOrderArray == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subtopicOrderArray' when calling updateSubtopicDisplayOrder");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("topicId", topicId);

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
        return apiClient.invokeAPI("/topics/{topicId}/display-order", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify topic information
     * Modify topic information
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
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
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param topicId unique identifier of the topic (required)
     * @param topicData topic input data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateTopicWithHttpInfo(String topicId, TopicInputType topicData) throws RestClientException {
        Object localVarPostBody = topicData;
        
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
        return apiClient.invokeAPI("/topics/{topicId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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

        final String[] localVarAccepts = {  };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}

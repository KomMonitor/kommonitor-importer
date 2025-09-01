package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.BaseApi;

import org.n52.kommonitor.models.UserInfoInputType;
import org.n52.kommonitor.models.UserInfoOverviewType;

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
@Component("org.n52.kommonitor.datamanagement.api.client.UserInfoApi")
public class UserInfoApi extends BaseApi {

    public UserInfoApi() {
        super(new ApiClient());
    }

    @Autowired
    public UserInfoApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Register new additional information about a user
     * Register new additional information about a user
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param userInfoInputType user info data (required)
     * @return UserInfoOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UserInfoOverviewType addUserInfo(UserInfoInputType userInfoInputType) throws RestClientException {
        return addUserInfoWithHttpInfo(userInfoInputType).getBody();
    }

    /**
     * Register new additional information about a user
     * Register new additional information about a user
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param userInfoInputType user info data (required)
     * @return ResponseEntity&lt;UserInfoOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserInfoOverviewType> addUserInfoWithHttpInfo(UserInfoInputType userInfoInputType) throws RestClientException {
        Object localVarPostBody = userInfoInputType;
        
        // verify the required parameter 'userInfoInputType' is set
        if (userInfoInputType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userInfoInputType' when calling addUserInfo");
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

        ParameterizedTypeReference<UserInfoOverviewType> localReturnType = new ParameterizedTypeReference<UserInfoOverviewType>() {};
        return apiClient.invokeAPI("/userInfos", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete additional information of a user
     * Delete additional information of a user
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param userId identifier of the user information (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteUserInfo(String userId) throws RestClientException {
        deleteUserInfoWithHttpInfo(userId);
    }

    /**
     * Delete additional information of a user
     * Delete additional information of a user
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param userId identifier of the user information (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteUserInfoWithHttpInfo(String userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling deleteUserInfo");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("userId", userId);

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
        return apiClient.invokeAPI("/userInfos/{userId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Retrieve additional information about a user
     * Retrieve additional information about a user
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param userId User info ID (required)
     * @return UserInfoOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UserInfoOverviewType getUserInfoById(String userId) throws RestClientException {
        return getUserInfoByIdWithHttpInfo(userId).getBody();
    }

    /**
     * Retrieve additional information about a user
     * Retrieve additional information about a user
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param userId User info ID (required)
     * @return ResponseEntity&lt;UserInfoOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserInfoOverviewType> getUserInfoByIdWithHttpInfo(String userId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling getUserInfoById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("userId", userId);

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

        ParameterizedTypeReference<UserInfoOverviewType> localReturnType = new ParameterizedTypeReference<UserInfoOverviewType>() {};
        return apiClient.invokeAPI("/userInfos/{userId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Retrieve additional information about the current user
     * Retrieve additional information about the current user
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return UserInfoOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UserInfoOverviewType getUserInfoForUser() throws RestClientException {
        return getUserInfoForUserWithHttpInfo().getBody();
    }

    /**
     * Retrieve additional information about the current user
     * Retrieve additional information about the current user
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;UserInfoOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserInfoOverviewType> getUserInfoForUserWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<UserInfoOverviewType> localReturnType = new ParameterizedTypeReference<UserInfoOverviewType>() {};
        return apiClient.invokeAPI("/userInfos/user", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Retrieve additional information about registered users such as favourite lists
     * Retrieve additional information about registered users such as favourite lists
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;UserInfoOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<UserInfoOverviewType> getUserInfos() throws RestClientException {
        return getUserInfosWithHttpInfo().getBody();
    }

    /**
     * Retrieve additional information about registered users such as favourite lists
     * Retrieve additional information about registered users such as favourite lists
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;List&lt;UserInfoOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<UserInfoOverviewType>> getUserInfosWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<List<UserInfoOverviewType>> localReturnType = new ParameterizedTypeReference<List<UserInfoOverviewType>>() {};
        return apiClient.invokeAPI("/userInfos", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update additional information of a user
     * Modify/Update additional information of a user
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param userId identifier of the user information (required)
     * @param userInfoData user info data (required)
     * @return UserInfoOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UserInfoOverviewType updateUserInfo(String userId, UserInfoInputType userInfoData) throws RestClientException {
        return updateUserInfoWithHttpInfo(userId, userInfoData).getBody();
    }

    /**
     * Modify/Update additional information of a user
     * Modify/Update additional information of a user
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param userId identifier of the user information (required)
     * @param userInfoData user info data (required)
     * @return ResponseEntity&lt;UserInfoOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserInfoOverviewType> updateUserInfoWithHttpInfo(String userId, UserInfoInputType userInfoData) throws RestClientException {
        Object localVarPostBody = userInfoData;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling updateUserInfo");
        }
        
        // verify the required parameter 'userInfoData' is set
        if (userInfoData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userInfoData' when calling updateUserInfo");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("userId", userId);

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

        ParameterizedTypeReference<UserInfoOverviewType> localReturnType = new ParameterizedTypeReference<UserInfoOverviewType>() {};
        return apiClient.invokeAPI("/userInfos/{userId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update additional information of a user in parts
     * Modify/Update additional information of a user in parts
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param userId identifier of the user information (required)
     * @param userInfoData user info data (required)
     * @return UserInfoOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public UserInfoOverviewType updateUserInfoPartially(String userId, UserInfoInputType userInfoData) throws RestClientException {
        return updateUserInfoPartiallyWithHttpInfo(userId, userInfoData).getBody();
    }

    /**
     * Modify/Update additional information of a user in parts
     * Modify/Update additional information of a user in parts
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param userId identifier of the user information (required)
     * @param userInfoData user info data (required)
     * @return ResponseEntity&lt;UserInfoOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<UserInfoOverviewType> updateUserInfoPartiallyWithHttpInfo(String userId, UserInfoInputType userInfoData) throws RestClientException {
        Object localVarPostBody = userInfoData;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userId' when calling updateUserInfoPartially");
        }
        
        // verify the required parameter 'userInfoData' is set
        if (userInfoData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userInfoData' when calling updateUserInfoPartially");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("userId", userId);

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

        ParameterizedTypeReference<UserInfoOverviewType> localReturnType = new ParameterizedTypeReference<UserInfoOverviewType>() {};
        return apiClient.invokeAPI("/userInfos/{userId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}

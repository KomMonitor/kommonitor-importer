package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.BaseApi;

import org.n52.kommonitor.models.OwnerInputType;
import org.n52.kommonitor.models.PermissionLevelInputType;
import org.n52.kommonitor.models.PermissionLevelType;
import org.n52.kommonitor.models.WebServiceCreationType;
import org.n52.kommonitor.models.WebServiceOverviewType;
import org.n52.kommonitor.models.WebServiceType;

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
@Component("org.n52.kommonitor.datamanagement.api.client.WebServicesApi")
public class WebServicesApi extends BaseApi {

    public WebServicesApi() {
        super(new ApiClient());
    }

    @Autowired
    public WebServicesApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Add a new web service
     * Add/Register a web service that provides georesources or indicators data
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * @param webServiceCreationType web service metadata (required)
     * @return WebServiceOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WebServiceOverviewType addWebServiceAsBody(WebServiceCreationType webServiceCreationType) throws RestClientException {
        return addWebServiceAsBodyWithHttpInfo(webServiceCreationType).getBody();
    }

    /**
     * Add a new web service
     * Add/Register a web service that provides georesources or indicators data
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * @param webServiceCreationType web service metadata (required)
     * @return ResponseEntity&lt;WebServiceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WebServiceOverviewType> addWebServiceAsBodyWithHttpInfo(WebServiceCreationType webServiceCreationType) throws RestClientException {
        Object localVarPostBody = webServiceCreationType;
        
        // verify the required parameter 'webServiceCreationType' is set
        if (webServiceCreationType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'webServiceCreationType' when calling addWebServiceAsBody");
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

        ParameterizedTypeReference<WebServiceOverviewType> localReturnType = new ParameterizedTypeReference<WebServiceOverviewType>() {};
        return apiClient.invokeAPI("/web-services", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the metadata of a certain web service
     * Delete the metadata of a certain web service
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * @param webServiceId identifier of the web service metadata entry (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteWebServiceById(String webServiceId) throws RestClientException {
        deleteWebServiceByIdWithHttpInfo(webServiceId);
    }

    /**
     * Delete the metadata of a certain web service
     * Delete the metadata of a certain web service
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * @param webServiceId identifier of the web service metadata entry (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteWebServiceByIdWithHttpInfo(String webServiceId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'webServiceId' is set
        if (webServiceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'webServiceId' when calling deleteWebServiceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("webServiceId", webServiceId);

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
        return apiClient.invokeAPI("/web-services/{webServiceId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about a certain web service
     * retrieve information about a certain web service
     * <p><b>200</b> - OK
     * @param webServiceId identifier of the web service metadata entry (required)
     * @return WebServiceOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WebServiceOverviewType getWebServiceById(String webServiceId) throws RestClientException {
        return getWebServiceByIdWithHttpInfo(webServiceId).getBody();
    }

    /**
     * retrieve information about a certain web service
     * retrieve information about a certain web service
     * <p><b>200</b> - OK
     * @param webServiceId identifier of the web service metadata entry (required)
     * @return ResponseEntity&lt;WebServiceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WebServiceOverviewType> getWebServiceByIdWithHttpInfo(String webServiceId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'webServiceId' is set
        if (webServiceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'webServiceId' when calling getWebServiceById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("webServiceId", webServiceId);

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

        ParameterizedTypeReference<WebServiceOverviewType> localReturnType = new ParameterizedTypeReference<WebServiceOverviewType>() {};
        return apiClient.invokeAPI("/web-services/{webServiceId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about the permissions for the selected web service
     * retrieve information about the permissions for the selected web service
     * <p><b>200</b> - OK
     * @param webServiceId identifier of the web service dataset (required)
     * @return List&lt;PermissionLevelType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<PermissionLevelType> getWebServicePermissionsById(String webServiceId) throws RestClientException {
        return getWebServicePermissionsByIdWithHttpInfo(webServiceId).getBody();
    }

    /**
     * retrieve information about the permissions for the selected web service
     * retrieve information about the permissions for the selected web service
     * <p><b>200</b> - OK
     * @param webServiceId identifier of the web service dataset (required)
     * @return ResponseEntity&lt;List&lt;PermissionLevelType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<PermissionLevelType>> getWebServicePermissionsByIdWithHttpInfo(String webServiceId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'webServiceId' is set
        if (webServiceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'webServiceId' when calling getWebServicePermissionsById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("webServiceId", webServiceId);

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
        return apiClient.invokeAPI("/web-services/{webServiceId}/permissions", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available web services
     * retrieve information about available web services
     * <p><b>200</b> - OK
     * @param resourceType Controls whether only web services for indicators or georesources should be returned. Supported values are [&#39;georesource&#39;, &#39;indicator&#39;] (optional)
     * @return List&lt;WebServiceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<WebServiceOverviewType> getWebServices(String resourceType) throws RestClientException {
        return getWebServicesWithHttpInfo(resourceType).getBody();
    }

    /**
     * retrieve information about available web services
     * retrieve information about available web services
     * <p><b>200</b> - OK
     * @param resourceType Controls whether only web services for indicators or georesources should be returned. Supported values are [&#39;georesource&#39;, &#39;indicator&#39;] (optional)
     * @return ResponseEntity&lt;List&lt;WebServiceOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<WebServiceOverviewType>> getWebServicesWithHttpInfo(String resourceType) throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "resourceType", resourceType));
        

        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<List<WebServiceOverviewType>> localReturnType = new ParameterizedTypeReference<List<WebServiceOverviewType>>() {};
        return apiClient.invokeAPI("/web-services", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the metadata of a web service
     * Modify/Update the metadata of a web service
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * @param webServiceId identifier of the web service metadata entry (required)
     * @param webServiceData feature data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateWebServiceMetadataAsBody(String webServiceId, WebServiceType webServiceData) throws RestClientException {
        updateWebServiceMetadataAsBodyWithHttpInfo(webServiceId, webServiceData);
    }

    /**
     * Modify/Update the metadata of a web service
     * Modify/Update the metadata of a web service
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * @param webServiceId identifier of the web service metadata entry (required)
     * @param webServiceData feature data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateWebServiceMetadataAsBodyWithHttpInfo(String webServiceId, WebServiceType webServiceData) throws RestClientException {
        Object localVarPostBody = webServiceData;
        
        // verify the required parameter 'webServiceId' is set
        if (webServiceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'webServiceId' when calling updateWebServiceMetadataAsBody");
        }
        
        // verify the required parameter 'webServiceData' is set
        if (webServiceData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'webServiceData' when calling updateWebServiceMetadataAsBody");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("webServiceId", webServiceId);

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
        return apiClient.invokeAPI("/web-services/{webServiceId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * update the ownership for the selected web service
     * update the ownership for the selected web service
     * <p><b>204</b> - No Content
     * @param webServiceId identifier of the web service dataset (required)
     * @param ownerInputType Web service ownership input (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateWebServiceOwnership(String webServiceId, OwnerInputType ownerInputType) throws RestClientException {
        updateWebServiceOwnershipWithHttpInfo(webServiceId, ownerInputType);
    }

    /**
     * update the ownership for the selected web service
     * update the ownership for the selected web service
     * <p><b>204</b> - No Content
     * @param webServiceId identifier of the web service dataset (required)
     * @param ownerInputType Web service ownership input (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateWebServiceOwnershipWithHttpInfo(String webServiceId, OwnerInputType ownerInputType) throws RestClientException {
        Object localVarPostBody = ownerInputType;
        
        // verify the required parameter 'webServiceId' is set
        if (webServiceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'webServiceId' when calling updateWebServiceOwnership");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("webServiceId", webServiceId);

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
        return apiClient.invokeAPI("/web-services/{webServiceId}/ownership", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * update the permissions for the selected web service dataset
     * update the permissions for the selected web service dataset
     * <p><b>204</b> - No Content
     * @param webServiceId identifier of the web service dataset (required)
     * @param permissionLevelInputType Web service permission level input (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateWebServicePermissions(String webServiceId, PermissionLevelInputType permissionLevelInputType) throws RestClientException {
        updateWebServicePermissionsWithHttpInfo(webServiceId, permissionLevelInputType);
    }

    /**
     * update the permissions for the selected web service dataset
     * update the permissions for the selected web service dataset
     * <p><b>204</b> - No Content
     * @param webServiceId identifier of the web service dataset (required)
     * @param permissionLevelInputType Web service permission level input (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateWebServicePermissionsWithHttpInfo(String webServiceId, PermissionLevelInputType permissionLevelInputType) throws RestClientException {
        Object localVarPostBody = permissionLevelInputType;
        
        // verify the required parameter 'webServiceId' is set
        if (webServiceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'webServiceId' when calling updateWebServicePermissions");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("webServiceId", webServiceId);

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
        return apiClient.invokeAPI("/web-services/{webServiceId}/permissions", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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

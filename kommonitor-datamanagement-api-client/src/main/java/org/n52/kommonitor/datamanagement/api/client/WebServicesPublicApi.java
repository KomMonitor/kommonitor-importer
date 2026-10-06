package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.BaseApi;

import org.n52.kommonitor.models.WebServiceOverviewType;

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
@Component("org.n52.kommonitor.datamanagement.api.client.WebServicesPublicApi")
public class WebServicesPublicApi extends BaseApi {

    public WebServicesPublicApi() {
        super(new ApiClient());
    }

    @Autowired
    public WebServicesPublicApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * retrieve information about available public web services
     * retrieve information about available public web services
     * <p><b>200</b> - OK
     * @param resourceType Controls whether only web services for indicators or georesources should be returned. Supported values are [&#39;georesource&#39;, &#39;indicator&#39;] (optional)
     * @return List&lt;WebServiceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<WebServiceOverviewType> getPublicWebServices(String resourceType) throws RestClientException {
        return getPublicWebServicesWithHttpInfo(resourceType).getBody();
    }

    /**
     * retrieve information about available public web services
     * retrieve information about available public web services
     * <p><b>200</b> - OK
     * @param resourceType Controls whether only web services for indicators or georesources should be returned. Supported values are [&#39;georesource&#39;, &#39;indicator&#39;] (optional)
     * @return ResponseEntity&lt;List&lt;WebServiceOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<WebServiceOverviewType>> getPublicWebServicesWithHttpInfo(String resourceType) throws RestClientException {
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
        return apiClient.invokeAPI("/public/web-services", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about a certain public web service
     * retrieve information about a certain public web service
     * <p><b>200</b> - OK
     * @param webServiceId identifier of the web service metadata entry (required)
     * @return WebServiceOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WebServiceOverviewType getWebPublicServiceById(String webServiceId) throws RestClientException {
        return getWebPublicServiceByIdWithHttpInfo(webServiceId).getBody();
    }

    /**
     * retrieve information about a certain public web service
     * retrieve information about a certain public web service
     * <p><b>200</b> - OK
     * @param webServiceId identifier of the web service metadata entry (required)
     * @return ResponseEntity&lt;WebServiceOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WebServiceOverviewType> getWebPublicServiceByIdWithHttpInfo(String webServiceId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'webServiceId' is set
        if (webServiceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'webServiceId' when calling getWebPublicServiceById");
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
        return apiClient.invokeAPI("/public/web-services/{webServiceId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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

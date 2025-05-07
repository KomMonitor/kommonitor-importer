package org.n52.kommonitor.datamanagement.api.client;

import jakarta.annotation.Generated;
import org.n52.kommonitor.datamanagement.api.ApiClient;

import org.n52.kommonitor.models.ProcessScriptOverviewType;
import org.n52.kommonitor.models.ProcessScriptPOSTInputType;
import org.n52.kommonitor.models.ProcessScriptPUTInputType;

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
@Component("org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi")
public class ProcessScriptsApi {
    private ApiClient apiClient;

    public ProcessScriptsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ProcessScriptsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Register a new process script
     * Register a process script associated to a certain indicator
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param processScriptData details necessary to register the process script (required)
     * @return ProcessScriptOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProcessScriptOverviewType addProcessScriptAsBody(ProcessScriptPOSTInputType processScriptData) throws RestClientException {
        return addProcessScriptAsBodyWithHttpInfo(processScriptData).getBody();
    }

    /**
     * Register a new process script
     * Register a process script associated to a certain indicator
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param processScriptData details necessary to register the process script (required)
     * @return ResponseEntity&lt;ProcessScriptOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProcessScriptOverviewType> addProcessScriptAsBodyWithHttpInfo(ProcessScriptPOSTInputType processScriptData) throws RestClientException {
        Object localVarPostBody = processScriptData;
        
        // verify the required parameter 'processScriptData' is set
        if (processScriptData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'processScriptData' when calling addProcessScriptAsBody");
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

        ParameterizedTypeReference<ProcessScriptOverviewType> localReturnType = new ParameterizedTypeReference<ProcessScriptOverviewType>() {};
        return apiClient.invokeAPI("/process-scripts", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the process script
     * Delete the process script associated to the specified indicator
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteProcessScript(String indicatorId) throws RestClientException {
        deleteProcessScriptWithHttpInfo(indicatorId);
    }

    /**
     * Delete the process script
     * Delete the process script associated to the specified indicator
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteProcessScriptWithHttpInfo(String indicatorId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling deleteProcessScript");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);

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
        return apiClient.invokeAPI("/process-scripts/usingIndicatorId/{indicatorId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the process script
     * Delete the process script associated to the specified scriptId
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param scriptId unique identifier of the selected script (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteProcessScriptByScriptId(String scriptId) throws RestClientException {
        deleteProcessScriptByScriptIdWithHttpInfo(scriptId);
    }

    /**
     * Delete the process script
     * Delete the process script associated to the specified scriptId
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param scriptId unique identifier of the selected script (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteProcessScriptByScriptIdWithHttpInfo(String scriptId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'scriptId' is set
        if (scriptId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'scriptId' when calling deleteProcessScriptByScriptId");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("scriptId", scriptId);

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
        return apiClient.invokeAPI("/process-scripts/{scriptId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the process script code associated to a certain indicator as JavaScript file
     * retrieve the process script code associated to a certain indicator as JavaScript file
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param scriptId unique identifier of the selected script (required)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getProcessScriptCode(String scriptId) throws RestClientException {
        return getProcessScriptCodeWithHttpInfo(scriptId).getBody();
    }

    /**
     * retrieve the process script code associated to a certain indicator as JavaScript file
     * retrieve the process script code associated to a certain indicator as JavaScript file
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param scriptId unique identifier of the selected script (required)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getProcessScriptCodeWithHttpInfo(String scriptId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'scriptId' is set
        if (scriptId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'scriptId' when calling getProcessScriptCode");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("scriptId", scriptId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/javascript"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/process-scripts/{scriptId}/scriptCode", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the process script code associated to a certain indicator as JavaScript file
     * retrieve the process script code associated to a certain indicator as JavaScript file
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getProcessScriptCodeForIndicator(String indicatorId) throws RestClientException {
        return getProcessScriptCodeForIndicatorWithHttpInfo(indicatorId).getBody();
    }

    /**
     * retrieve the process script code associated to a certain indicator as JavaScript file
     * retrieve the process script code associated to a certain indicator as JavaScript file
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getProcessScriptCodeForIndicatorWithHttpInfo(String indicatorId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getProcessScriptCodeForIndicator");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/javascript"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/process-scripts/usingIndicatorId/{indicatorId}/scriptCode", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about the associated process script for a certain indicator
     * retrieve information about the associated process script for a certain indicator
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return ProcessScriptOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProcessScriptOverviewType getProcessScriptForIndicator(String indicatorId) throws RestClientException {
        return getProcessScriptForIndicatorWithHttpInfo(indicatorId).getBody();
    }

    /**
     * retrieve information about the associated process script for a certain indicator
     * retrieve information about the associated process script for a certain indicator
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return ResponseEntity&lt;ProcessScriptOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProcessScriptOverviewType> getProcessScriptForIndicatorWithHttpInfo(String indicatorId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getProcessScriptForIndicator");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);

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

        ParameterizedTypeReference<ProcessScriptOverviewType> localReturnType = new ParameterizedTypeReference<ProcessScriptOverviewType>() {};
        return apiClient.invokeAPI("/process-scripts/usingIndicatorId/{indicatorId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about the associated process script for a certain scriptId
     * retrieve information about the associated process script for a certain scriptId
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param scriptId unique identifier of the selected script (required)
     * @return ProcessScriptOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProcessScriptOverviewType getProcessScriptForScriptId(String scriptId) throws RestClientException {
        return getProcessScriptForScriptIdWithHttpInfo(scriptId).getBody();
    }

    /**
     * retrieve information about the associated process script for a certain scriptId
     * retrieve information about the associated process script for a certain scriptId
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param scriptId unique identifier of the selected script (required)
     * @return ResponseEntity&lt;ProcessScriptOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProcessScriptOverviewType> getProcessScriptForScriptIdWithHttpInfo(String scriptId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'scriptId' is set
        if (scriptId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'scriptId' when calling getProcessScriptForScriptId");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("scriptId", scriptId);

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

        ParameterizedTypeReference<ProcessScriptOverviewType> localReturnType = new ParameterizedTypeReference<ProcessScriptOverviewType>() {};
        return apiClient.invokeAPI("/process-scripts/{scriptId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve an empty script template, that defines how to implement process scripts for KomMonitor as JavaScript file.
     * retrieve an empty script template, that defines how to implement process scripts for KomMonitor. The script works as a template for a NodeJS module. Hence, it predefines required methods that are called by the executing processing engine (a NodeJS runtimne environment). As a script developer, those predefined methods have to be implemented. The template contains detailed documentation on how to implement those methods.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getProcessScriptTemplate() throws RestClientException {
        return getProcessScriptTemplateWithHttpInfo().getBody();
    }

    /**
     * retrieve an empty script template, that defines how to implement process scripts for KomMonitor as JavaScript file.
     * retrieve an empty script template, that defines how to implement process scripts for KomMonitor. The script works as a template for a NodeJS module. Hence, it predefines required methods that are called by the executing processing engine (a NodeJS runtimne environment). As a script developer, those predefined methods have to be implemented. The template contains detailed documentation on how to implement those methods.
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getProcessScriptTemplateWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/javascript"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/process-scripts/template", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available process scripts
     * retrieve information about available process scripts
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;ProcessScriptOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<ProcessScriptOverviewType> getProcessScripts() throws RestClientException {
        return getProcessScriptsWithHttpInfo().getBody();
    }

    /**
     * retrieve information about available process scripts
     * retrieve information about available process scripts
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;List&lt;ProcessScriptOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<ProcessScriptOverviewType>> getProcessScriptsWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<List<ProcessScriptOverviewType>> localReturnType = new ParameterizedTypeReference<List<ProcessScriptOverviewType>>() {};
        return apiClient.invokeAPI("/process-scripts", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update an existing process script
     * Modify/Update an existing process script associated to a certain indicator
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param processScriptData details necessary to modify the process script (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateProcessScriptAsBody(String indicatorId, ProcessScriptPUTInputType processScriptData) throws RestClientException {
        updateProcessScriptAsBodyWithHttpInfo(indicatorId, processScriptData);
    }

    /**
     * Modify/Update an existing process script
     * Modify/Update an existing process script associated to a certain indicator
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param processScriptData details necessary to modify the process script (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateProcessScriptAsBodyWithHttpInfo(String indicatorId, ProcessScriptPUTInputType processScriptData) throws RestClientException {
        Object localVarPostBody = processScriptData;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling updateProcessScriptAsBody");
        }
        
        // verify the required parameter 'processScriptData' is set
        if (processScriptData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'processScriptData' when calling updateProcessScriptAsBody");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);

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
        return apiClient.invokeAPI("/process-scripts/usingIndicatorId/{indicatorId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update an existing process script
     * Modify/Update an existing process script associated to a certain scriptId
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param scriptId unique identifier of the selected script (required)
     * @param processScriptData details necessary to modify the process script (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateProcessScriptAsBodyByScriptId(String scriptId, ProcessScriptPUTInputType processScriptData) throws RestClientException {
        updateProcessScriptAsBodyByScriptIdWithHttpInfo(scriptId, processScriptData);
    }

    /**
     * Modify/Update an existing process script
     * Modify/Update an existing process script associated to a certain scriptId
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param scriptId unique identifier of the selected script (required)
     * @param processScriptData details necessary to modify the process script (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateProcessScriptAsBodyByScriptIdWithHttpInfo(String scriptId, ProcessScriptPUTInputType processScriptData) throws RestClientException {
        Object localVarPostBody = processScriptData;
        
        // verify the required parameter 'scriptId' is set
        if (scriptId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'scriptId' when calling updateProcessScriptAsBodyByScriptId");
        }
        
        // verify the required parameter 'processScriptData' is set
        if (processScriptData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'processScriptData' when calling updateProcessScriptAsBodyByScriptId");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("scriptId", scriptId);

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
        return apiClient.invokeAPI("/process-scripts/{scriptId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}

package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;

import org.n52.kommonitor.importer.models.RoleInputType;
import org.n52.kommonitor.importer.models.RoleOverviewType;

import java.util.ArrayList;
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
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-01-10T14:00:35.064+01:00")
@Component("org.n52.kommonitor.datamanagement.api.client.RolesApi")
public class RolesApi {
    private ApiClient apiClient;

    public RolesApi() {
        this(new ApiClient());
    }

    @Autowired
    public RolesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Register a new role
     * Add/Register a role
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param roleData role input data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void addRole(RoleInputType roleData) throws RestClientException {
        addRoleWithHttpInfo(roleData);
    }

    /**
     * Register a new role
     * Add/Register a role
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param roleData role input data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> addRoleWithHttpInfo(RoleInputType roleData) throws RestClientException {
        Object postBody = roleData;
        
        // verify the required parameter 'roleData' is set
        if (roleData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'roleData' when calling addRole");
        }
        
        String path = UriComponentsBuilder.fromPath("/roles").build().toUriString();

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
     * Delete the role
     * Delete the role
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * @param roleId unique identifier of the role (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteRole(String roleId) throws RestClientException {
        deleteRoleWithHttpInfo(roleId);
    }

    /**
     * Delete the role
     * Delete the role
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * @param roleId unique identifier of the role (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteRoleWithHttpInfo(String roleId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'roleId' is set
        if (roleId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'roleId' when calling deleteRole");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("roleId", roleId);
        String path = UriComponentsBuilder.fromPath("/roles/{roleId}").buildAndExpand(uriVariables).toUriString();

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
     * retrieve information about the selected role
     * retrieve information about the selected role
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param roleId unique identifier of the role (required)
     * @return RoleOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public RoleOverviewType getRoleById(String roleId) throws RestClientException {
        return getRoleByIdWithHttpInfo(roleId).getBody();
    }

    /**
     * retrieve information about the selected role
     * retrieve information about the selected role
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @param roleId unique identifier of the role (required)
     * @return ResponseEntity&lt;RoleOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<RoleOverviewType> getRoleByIdWithHttpInfo(String roleId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'roleId' is set
        if (roleId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'roleId' when calling getRoleById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("roleId", roleId);
        String path = UriComponentsBuilder.fromPath("/roles/{roleId}").buildAndExpand(uriVariables).toUriString();

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

        ParameterizedTypeReference<RoleOverviewType> returnType = new ParameterizedTypeReference<RoleOverviewType>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * retrieve information about available roles
     * retrieve information about available roles
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @return List&lt;RoleOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<RoleOverviewType> getRoles() throws RestClientException {
        return getRolesWithHttpInfo().getBody();
    }

    /**
     * retrieve information about available roles
     * retrieve information about available roles
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * @return ResponseEntity&lt;List&lt;RoleOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<RoleOverviewType>> getRolesWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/roles").build().toUriString();

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

        ParameterizedTypeReference<List<RoleOverviewType>> returnType = new ParameterizedTypeReference<List<RoleOverviewType>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Modify role information
     * Modify role information
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param roleId unique identifier of the role (required)
     * @param roleData role input data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateRole(String roleId, RoleInputType roleData) throws RestClientException {
        updateRoleWithHttpInfo(roleId, roleData);
    }

    /**
     * Modify role information
     * Modify role information
     * <p><b>200</b> - OK
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>405</b> - Invalid input
     * @param roleId unique identifier of the role (required)
     * @param roleData role input data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateRoleWithHttpInfo(String roleId, RoleInputType roleData) throws RestClientException {
        Object postBody = roleData;
        
        // verify the required parameter 'roleId' is set
        if (roleId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'roleId' when calling updateRole");
        }
        
        // verify the required parameter 'roleData' is set
        if (roleData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'roleData' when calling updateRole");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("roleId", roleId);
        String path = UriComponentsBuilder.fromPath("/roles/{roleId}").buildAndExpand(uriVariables).toUriString();

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

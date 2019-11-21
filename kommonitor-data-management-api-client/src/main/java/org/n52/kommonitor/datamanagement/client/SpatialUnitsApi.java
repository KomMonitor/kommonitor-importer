package org.n52.kommonitor.datamanagement.client;

import org.n52.kommonitor.datamanagement.ApiClient;

import org.n52.kommonitor.importer.models.ImportSpatialUnitPOSTInputType;

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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-21T19:25:57.064+01:00")
@Component("org.n52.kommonitor.datamanagement.client.SpatialUnitsApi")
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
     * Import a new spatial-unit
     * Import a new spatial unit for a certain period of time. Parses Input source, extracts relevant data, performs schema mapping to KomMonitor data model and calls POST /spatial-units of KomMonitor Data Management API
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * @param featureData feature data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void importSpatialUnit(ImportSpatialUnitPOSTInputType featureData) throws RestClientException {
        importSpatialUnitWithHttpInfo(featureData);
    }

    /**
     * Import a new spatial-unit
     * Import a new spatial unit for a certain period of time. Parses Input source, extracts relevant data, performs schema mapping to KomMonitor data model and calls POST /spatial-units of KomMonitor Data Management API
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * @param featureData feature data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> importSpatialUnitWithHttpInfo(ImportSpatialUnitPOSTInputType featureData) throws RestClientException {
        Object postBody = featureData;
        
        // verify the required parameter 'featureData' is set
        if (featureData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureData' when calling importSpatialUnit");
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
}

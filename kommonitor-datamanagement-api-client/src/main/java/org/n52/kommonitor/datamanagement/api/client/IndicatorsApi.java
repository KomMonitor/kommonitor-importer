package org.n52.kommonitor.datamanagement.api.client;

import org.n52.kommonitor.datamanagement.api.ApiClient;

import java.math.BigDecimal;
import org.n52.kommonitor.models.IndicatorMetadataPATCHInputType;
import org.n52.kommonitor.models.IndicatorOverviewType;
import org.n52.kommonitor.models.IndicatorPATCHDisplayOrderInputType;
import org.n52.kommonitor.models.IndicatorPOSTInputType;
import org.n52.kommonitor.models.IndicatorPUTInputType;
import org.n52.kommonitor.models.IndicatorPropertiesWithoutGeomType;
import org.n52.kommonitor.models.OwnerInputType;
import org.n52.kommonitor.models.PermissionLevelInputType;
import org.n52.kommonitor.models.PermissionLevelType;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-02-21T12:45:23.890552600+01:00[Europe/Berlin]")
@Component("org.n52.kommonitor.datamanagement.api.client.IndicatorsApi")
public class IndicatorsApi {
    private ApiClient apiClient;

    public IndicatorsApi() {
        this(new ApiClient());
    }

    @Autowired
    public IndicatorsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Add a new indicator dataset
     * Add/Register an indicator dataset for a certain period of time and spatial unit/level
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorData indicator data (required)
     * @return IndicatorOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public IndicatorOverviewType addIndicatorAsBody(IndicatorPOSTInputType indicatorData) throws RestClientException {
        return addIndicatorAsBodyWithHttpInfo(indicatorData).getBody();
    }

    /**
     * Add a new indicator dataset
     * Add/Register an indicator dataset for a certain period of time and spatial unit/level
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorData indicator data (required)
     * @return ResponseEntity&lt;IndicatorOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<IndicatorOverviewType> addIndicatorAsBodyWithHttpInfo(IndicatorPOSTInputType indicatorData) throws RestClientException {
        Object localVarPostBody = indicatorData;
        
        // verify the required parameter 'indicatorData' is set
        if (indicatorData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorData' when calling addIndicatorAsBody");
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

        ParameterizedTypeReference<IndicatorOverviewType> localReturnType = new ParameterizedTypeReference<IndicatorOverviewType>() {};
        return apiClient.invokeAPI("/indicators", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected indicator dataset
     * Delete the features/contents of the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteIndicatorById(String indicatorId) throws RestClientException {
        deleteIndicatorByIdWithHttpInfo(indicatorId);
    }

    /**
     * Delete the features/contents of the selected indicator dataset
     * Delete the features/contents of the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteIndicatorByIdWithHttpInfo(String indicatorId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling deleteIndicatorById");
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
        return apiClient.invokeAPI("/indicators/{indicatorId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteIndicatorByIdAndSpatialUnitId(String indicatorId, String spatialUnitId) throws RestClientException {
        deleteIndicatorByIdAndSpatialUnitIdWithHttpInfo(indicatorId, spatialUnitId);
    }

    /**
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * Delete the features/contents of the selected indicator dataset for the selected spatial unit
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteIndicatorByIdAndSpatialUnitIdWithHttpInfo(String indicatorId, String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling deleteIndicatorByIdAndSpatialUnitId");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteIndicatorByIdAndSpatialUnitId");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);

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
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteIndicatorByIdAndYearAndMonth(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        deleteIndicatorByIdAndYearAndMonthWithHttpInfo(indicatorId, spatialUnitId, year, month, day);
    }

    /**
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * Delete the features/contents of the selected indicator dataset, selected by year and month
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteIndicatorByIdAndYearAndMonthWithHttpInfo(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling deleteIndicatorByIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("year", year);
        uriVariables.put("month", month);
        uriVariables.put("day", day);

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
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete all database records for the specified feature of the selected indicator dataset
     * Delete all database records for the specified feature of the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset spatial feature (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteSingleIndicatorFeatureById(String indicatorId, String spatialUnitId, String featureId) throws RestClientException {
        deleteSingleIndicatorFeatureByIdWithHttpInfo(indicatorId, spatialUnitId, featureId);
    }

    /**
     * Delete all database records for the specified feature of the selected indicator dataset
     * Delete all database records for the specified feature of the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset spatial feature (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteSingleIndicatorFeatureByIdWithHttpInfo(String indicatorId, String spatialUnitId, String featureId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling deleteSingleIndicatorFeatureById");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteSingleIndicatorFeatureById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling deleteSingleIndicatorFeatureById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("featureId", featureId);

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
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected indicator dataset
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset feature (required)
     * @param featureRecordId the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteSingleIndicatorFeatureRecordById(String indicatorId, String spatialUnitId, String featureId, String featureRecordId) throws RestClientException {
        deleteSingleIndicatorFeatureRecordByIdWithHttpInfo(indicatorId, spatialUnitId, featureId, featureRecordId);
    }

    /**
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected indicator dataset
     * Delete single feature database record specified by its unique database primary key id for the specified feature of the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset feature (required)
     * @param featureRecordId the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteSingleIndicatorFeatureRecordByIdWithHttpInfo(String indicatorId, String spatialUnitId, String featureId, String featureRecordId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling deleteSingleIndicatorFeatureRecordById");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling deleteSingleIndicatorFeatureRecordById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling deleteSingleIndicatorFeatureRecordById");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling deleteSingleIndicatorFeatureRecordById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("featureId", featureId);
        uriVariables.put("featureRecordId", featureRecordId);

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
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about the selected indicator
     * retrieve information about the selected indicator
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return IndicatorOverviewType
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public IndicatorOverviewType getIndicatorById(String indicatorId) throws RestClientException {
        return getIndicatorByIdWithHttpInfo(indicatorId).getBody();
    }

    /**
     * retrieve information about the selected indicator
     * retrieve information about the selected indicator
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return ResponseEntity&lt;IndicatorOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<IndicatorOverviewType> getIndicatorByIdWithHttpInfo(String indicatorId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorById");
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

        ParameterizedTypeReference<IndicatorOverviewType> localReturnType = new ParameterizedTypeReference<IndicatorOverviewType>() {};
        return apiClient.invokeAPI("/indicators/{indicatorId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getIndicatorBySpatialUnitIdAndId(String indicatorId, String spatialUnitId, String simplifyGeometries) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdWithHttpInfo(indicatorId, spatialUnitId, simplifyGeometries).getBody();
    }

    /**
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * retrieve the indicator for the selected spatial unit as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getIndicatorBySpatialUnitIdAndIdWithHttpInfo(String indicatorId, String spatialUnitId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorBySpatialUnitIdAndId");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getIndicatorBySpatialUnitIdAndId");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));


        final String[] localVarAccepts = { 
            "application/octed-stream"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; (optional, default to original)
     * @return byte[]
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public byte[] getIndicatorBySpatialUnitIdAndIdAndYearAndMonth(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithHttpInfo(indicatorId, spatialUnitId, year, month, day, simplifyGeometries).getBody();
    }

    /**
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * retrieve the indicator for the selected spatial unit, year and month as GeoJSON
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; (optional, default to original)
     * @return ResponseEntity&lt;byte[]&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<byte[]> getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithHttpInfo(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("year", year);
        uriVariables.put("month", month);
        uriVariables.put("day", day);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));


        final String[] localVarAccepts = { 
            "application/octed-stream"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<byte[]> localReturnType = new ParameterizedTypeReference<byte[]>() {};
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return List&lt;IndicatorPropertiesWithoutGeomType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorPropertiesWithoutGeomType> getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometryWithHttpInfo(indicatorId, spatialUnitId, year, month, day).getBody();
    }

    /**
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param year year for which the indicator shall be queried (required)
     * @param month month for which the indicator shall be queried (required)
     * @param day day for which datasets shall be queried (required)
     * @return ResponseEntity&lt;List&lt;IndicatorPropertiesWithoutGeomType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorPropertiesWithoutGeomType>> getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometryWithHttpInfo(String indicatorId, String spatialUnitId, BigDecimal year, BigDecimal month, BigDecimal day) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'year' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'month' is set
        if (month == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'month' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // verify the required parameter 'day' is set
        if (day == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'day' when calling getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("year", year);
        uriVariables.put("month", month);
        uriVariables.put("day", day);

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

        ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>> localReturnType = new ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>>() {};
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return List&lt;IndicatorPropertiesWithoutGeomType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorPropertiesWithoutGeomType> getIndicatorBySpatialUnitIdAndIdWithoutGeometry(String indicatorId, String spatialUnitId) throws RestClientException {
        return getIndicatorBySpatialUnitIdAndIdWithoutGeometryWithHttpInfo(indicatorId, spatialUnitId).getBody();
    }

    /**
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;List&lt;IndicatorPropertiesWithoutGeomType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorPropertiesWithoutGeomType>> getIndicatorBySpatialUnitIdAndIdWithoutGeometryWithHttpInfo(String indicatorId, String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorBySpatialUnitIdAndIdWithoutGeometry");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getIndicatorBySpatialUnitIdAndIdWithoutGeometry");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);

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

        ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>> localReturnType = new ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>>() {};
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/without-geometry", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about the permissions for the selected indicator dataset
     * retrieve information about the permissions for the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return List&lt;PermissionLevelType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<PermissionLevelType> getIndicatorPermissionsById(String indicatorId) throws RestClientException {
        return getIndicatorPermissionsByIdWithHttpInfo(indicatorId).getBody();
    }

    /**
     * retrieve information about the permissions for the selected indicator dataset
     * retrieve information about the permissions for the selected indicator dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @return ResponseEntity&lt;List&lt;PermissionLevelType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<PermissionLevelType>> getIndicatorPermissionsByIdWithHttpInfo(String indicatorId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorPermissionsById");
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

        ParameterizedTypeReference<List<PermissionLevelType>> localReturnType = new ParameterizedTypeReference<List<PermissionLevelType>>() {};
        return apiClient.invokeAPI("/indicators/{indicatorId}/permissions", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about the permissions for the selected indicator and spatial unit dataset
     * retrieve information about the permissions for the selected indicator and spatial unit dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return List&lt;PermissionLevelType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<PermissionLevelType> getIndicatorPermissionsBySpatialUnitIdAndId(String indicatorId, String spatialUnitId) throws RestClientException {
        return getIndicatorPermissionsBySpatialUnitIdAndIdWithHttpInfo(indicatorId, spatialUnitId).getBody();
    }

    /**
     * retrieve information about the permissions for the selected indicator and spatial unit dataset
     * retrieve information about the permissions for the selected indicator and spatial unit dataset
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @return ResponseEntity&lt;List&lt;PermissionLevelType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<PermissionLevelType>> getIndicatorPermissionsBySpatialUnitIdAndIdWithHttpInfo(String indicatorId, String spatialUnitId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getIndicatorPermissionsBySpatialUnitIdAndId");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getIndicatorPermissionsBySpatialUnitIdAndId");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);

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
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/permissions", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve information about available indicators
     * retrieve information about available indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return List&lt;IndicatorOverviewType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorOverviewType> getIndicators() throws RestClientException {
        return getIndicatorsWithHttpInfo().getBody();
    }

    /**
     * retrieve information about available indicators
     * retrieve information about available indicators
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @return ResponseEntity&lt;List&lt;IndicatorOverviewType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorOverviewType>> getIndicatorsWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<List<IndicatorOverviewType>> localReturnType = new ParameterizedTypeReference<List<IndicatorOverviewType>>() {};
        return apiClient.invokeAPI("/indicators", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset spatial feature (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return List&lt;IndicatorPropertiesWithoutGeomType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorPropertiesWithoutGeomType> getSingleIndicatorFeatureById(String indicatorId, String spatialUnitId, String featureId, String simplifyGeometries) throws RestClientException {
        return getSingleIndicatorFeatureByIdWithHttpInfo(indicatorId, spatialUnitId, featureId, simplifyGeometries).getBody();
    }

    /**
     * retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity)
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset spatial feature (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;List&lt;IndicatorPropertiesWithoutGeomType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorPropertiesWithoutGeomType>> getSingleIndicatorFeatureByIdWithHttpInfo(String indicatorId, String spatialUnitId, String featureId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getSingleIndicatorFeatureById");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getSingleIndicatorFeatureById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getSingleIndicatorFeatureById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("featureId", featureId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));


        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>> localReturnType = new ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>>() {};
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * retrieve single feature database record specified by its unique database primary key id test
     * retrieve single feature database record specified by its unique database primary key id test
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset spatial feature (required)
     * @param featureRecordId the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return List&lt;IndicatorPropertiesWithoutGeomType&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<IndicatorPropertiesWithoutGeomType> getSingleIndicatorFeatureRecordById(String indicatorId, String spatialUnitId, String featureId, String featureRecordId, String simplifyGeometries) throws RestClientException {
        return getSingleIndicatorFeatureRecordByIdWithHttpInfo(indicatorId, spatialUnitId, featureId, featureRecordId, simplifyGeometries).getBody();
    }

    /**
     * retrieve single feature database record specified by its unique database primary key id test
     * retrieve single feature database record specified by its unique database primary key id test
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid status value
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset spatial feature (required)
     * @param featureRecordId the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param simplifyGeometries Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. (optional, default to original)
     * @return ResponseEntity&lt;List&lt;IndicatorPropertiesWithoutGeomType&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<IndicatorPropertiesWithoutGeomType>> getSingleIndicatorFeatureRecordByIdWithHttpInfo(String indicatorId, String spatialUnitId, String featureId, String featureRecordId, String simplifyGeometries) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling getSingleIndicatorFeatureRecordById");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling getSingleIndicatorFeatureRecordById");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling getSingleIndicatorFeatureRecordById");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling getSingleIndicatorFeatureRecordById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("featureId", featureId);
        uriVariables.put("featureRecordId", featureRecordId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "simplifyGeometries", simplifyGeometries));


        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "kommonitor-data-access_oauth" };

        ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>> localReturnType = new ParameterizedTypeReference<List<IndicatorPropertiesWithoutGeomType>>() {};
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the contents of the selected indicator dataset
     * Modify/Update the contents of the selected indicator dataset
     * <p><b>200</b> - OK - Updated
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param indicatorData indicator data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorAsBody(String indicatorId, IndicatorPUTInputType indicatorData) throws RestClientException {
        updateIndicatorAsBodyWithHttpInfo(indicatorId, indicatorData);
    }

    /**
     * Modify/Update the contents of the selected indicator dataset
     * Modify/Update the contents of the selected indicator dataset
     * <p><b>200</b> - OK - Updated
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param indicatorData indicator data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorAsBodyWithHttpInfo(String indicatorId, IndicatorPUTInputType indicatorData) throws RestClientException {
        Object localVarPostBody = indicatorData;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling updateIndicatorAsBody");
        }
        
        // verify the required parameter 'indicatorData' is set
        if (indicatorData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorData' when calling updateIndicatorAsBody");
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
        return apiClient.invokeAPI("/indicators/{indicatorId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update displayOrder for submitted indicators
     * Update displayOrder for submitted indicators
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorOrderArray array of indicator id and displayOrder items (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorDisplayOrder(List<IndicatorPATCHDisplayOrderInputType> indicatorOrderArray) throws RestClientException {
        updateIndicatorDisplayOrderWithHttpInfo(indicatorOrderArray);
    }

    /**
     * Update displayOrder for submitted indicators
     * Update displayOrder for submitted indicators
     * <p><b>200</b> - OK
     * <p><b>201</b> - Created
     * <p><b>204</b> - No Content
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorOrderArray array of indicator id and displayOrder items (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorDisplayOrderWithHttpInfo(List<IndicatorPATCHDisplayOrderInputType> indicatorOrderArray) throws RestClientException {
        Object localVarPostBody = indicatorOrderArray;
        
        // verify the required parameter 'indicatorOrderArray' is set
        if (indicatorOrderArray == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorOrderArray' when calling updateIndicatorDisplayOrder");
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
        return apiClient.invokeAPI("/indicators/display-order", HttpMethod.PATCH, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the feature record of the selected indicator dataset feature
     * Modify/Update the feature record of the selected indicator dataset feature
     * <p><b>200</b> - OK - Updated
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset feature (required)
     * @param featureRecordId the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param indicatorFeatureRecordData indicator feature record data (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorFeatureRecordAsBody(String indicatorId, String spatialUnitId, String featureId, String featureRecordId, IndicatorPropertiesWithoutGeomType indicatorFeatureRecordData) throws RestClientException {
        updateIndicatorFeatureRecordAsBodyWithHttpInfo(indicatorId, spatialUnitId, featureId, featureRecordId, indicatorFeatureRecordData);
    }

    /**
     * Modify/Update the feature record of the selected indicator dataset feature
     * Modify/Update the feature record of the selected indicator dataset feature
     * <p><b>200</b> - OK - Updated
     * <p><b>201</b> - Created
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param featureId the identifier of the indicator dataset feature (required)
     * @param featureRecordId the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity (required)
     * @param indicatorFeatureRecordData indicator feature record data (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorFeatureRecordAsBodyWithHttpInfo(String indicatorId, String spatialUnitId, String featureId, String featureRecordId, IndicatorPropertiesWithoutGeomType indicatorFeatureRecordData) throws RestClientException {
        Object localVarPostBody = indicatorFeatureRecordData;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling updateIndicatorFeatureRecordAsBody");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling updateIndicatorFeatureRecordAsBody");
        }
        
        // verify the required parameter 'featureId' is set
        if (featureId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureId' when calling updateIndicatorFeatureRecordAsBody");
        }
        
        // verify the required parameter 'featureRecordId' is set
        if (featureRecordId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'featureRecordId' when calling updateIndicatorFeatureRecordAsBody");
        }
        
        // verify the required parameter 'indicatorFeatureRecordData' is set
        if (indicatorFeatureRecordData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorFeatureRecordData' when calling updateIndicatorFeatureRecordAsBody");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);
        uriVariables.put("featureId", featureId);
        uriVariables.put("featureRecordId", featureRecordId);

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
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the metadata of the selected indicator dataset
     * Modify/Update the metadata of the selected indicator dataset. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param metadata metadata input (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorMetadataAsBody(String indicatorId, IndicatorMetadataPATCHInputType metadata) throws RestClientException {
        updateIndicatorMetadataAsBodyWithHttpInfo(indicatorId, metadata);
    }

    /**
     * Modify/Update the metadata of the selected indicator dataset
     * Modify/Update the metadata of the selected indicator dataset. This replaces the formerly stored metadata.
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param metadata metadata input (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorMetadataAsBodyWithHttpInfo(String indicatorId, IndicatorMetadataPATCHInputType metadata) throws RestClientException {
        Object localVarPostBody = metadata;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling updateIndicatorMetadataAsBody");
        }
        
        // verify the required parameter 'metadata' is set
        if (metadata == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'metadata' when calling updateIndicatorMetadataAsBody");
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
        return apiClient.invokeAPI("/indicators/{indicatorId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the selected indicator dataset ownership
     * 
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param indicatorData Indicator parameters input (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorOwnership(String indicatorId, OwnerInputType indicatorData) throws RestClientException {
        updateIndicatorOwnershipWithHttpInfo(indicatorId, indicatorData);
    }

    /**
     * Modify/Update the selected indicator dataset ownership
     * 
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param indicatorData Indicator parameters input (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorOwnershipWithHttpInfo(String indicatorId, OwnerInputType indicatorData) throws RestClientException {
        Object localVarPostBody = indicatorData;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling updateIndicatorOwnership");
        }
        
        // verify the required parameter 'indicatorData' is set
        if (indicatorData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorData' when calling updateIndicatorOwnership");
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
        return apiClient.invokeAPI("/indicators/{indicatorId}/ownership", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the selected indicator dataset ownership
     * 
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param indicatorData Indicator parameters input (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorOwnershipBySpatialUnit(String indicatorId, String spatialUnitId, OwnerInputType indicatorData) throws RestClientException {
        updateIndicatorOwnershipBySpatialUnitWithHttpInfo(indicatorId, spatialUnitId, indicatorData);
    }

    /**
     * Modify/Update the selected indicator dataset ownership
     * 
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param indicatorData Indicator parameters input (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorOwnershipBySpatialUnitWithHttpInfo(String indicatorId, String spatialUnitId, OwnerInputType indicatorData) throws RestClientException {
        Object localVarPostBody = indicatorData;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling updateIndicatorOwnershipBySpatialUnit");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling updateIndicatorOwnershipBySpatialUnit");
        }
        
        // verify the required parameter 'indicatorData' is set
        if (indicatorData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorData' when calling updateIndicatorOwnershipBySpatialUnit");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);

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
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/ownership", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the selected indicator dataset permissions
     * 
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param indicatorData Indicator parameters input (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorPermissions(String indicatorId, PermissionLevelInputType indicatorData) throws RestClientException {
        updateIndicatorPermissionsWithHttpInfo(indicatorId, indicatorData);
    }

    /**
     * Modify/Update the selected indicator dataset permissions
     * 
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param indicatorData Indicator parameters input (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorPermissionsWithHttpInfo(String indicatorId, PermissionLevelInputType indicatorData) throws RestClientException {
        Object localVarPostBody = indicatorData;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling updateIndicatorPermissions");
        }
        
        // verify the required parameter 'indicatorData' is set
        if (indicatorData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorData' when calling updateIndicatorPermissions");
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
        return apiClient.invokeAPI("/indicators/{indicatorId}/permissions", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Modify/Update the selected indicator dataset permissions
     * 
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param indicatorData Indicator parameters input (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateIndicatorPermissionsBySpatialUnit(String indicatorId, String spatialUnitId, PermissionLevelInputType indicatorData) throws RestClientException {
        updateIndicatorPermissionsBySpatialUnitWithHttpInfo(indicatorId, spatialUnitId, indicatorData);
    }

    /**
     * Modify/Update the selected indicator dataset permissions
     * 
     * <p><b>200</b> - OK
     * <p><b>204</b> - No Content
     * <p><b>401</b> - API key is missing or invalid
     * <p><b>403</b> - Forbidden
     * <p><b>405</b> - Invalid input
     * @param indicatorId unique identifier of the selected indicator dataset (required)
     * @param spatialUnitId the unique identifier of the spatial level (required)
     * @param indicatorData Indicator parameters input (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> updateIndicatorPermissionsBySpatialUnitWithHttpInfo(String indicatorId, String spatialUnitId, PermissionLevelInputType indicatorData) throws RestClientException {
        Object localVarPostBody = indicatorData;
        
        // verify the required parameter 'indicatorId' is set
        if (indicatorId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorId' when calling updateIndicatorPermissionsBySpatialUnit");
        }
        
        // verify the required parameter 'spatialUnitId' is set
        if (spatialUnitId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'spatialUnitId' when calling updateIndicatorPermissionsBySpatialUnit");
        }
        
        // verify the required parameter 'indicatorData' is set
        if (indicatorData == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'indicatorData' when calling updateIndicatorPermissionsBySpatialUnit");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("indicatorId", indicatorId);
        uriVariables.put("spatialUnitId", spatialUnitId);

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
        return apiClient.invokeAPI("/indicators/{indicatorId}/{spatialUnitId}/permissions", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}

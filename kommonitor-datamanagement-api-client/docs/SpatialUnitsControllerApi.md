# SpatialUnitsControllerApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addSpatialUnitAsBody**](SpatialUnitsControllerApi.md#addSpatialUnitAsBody) | **POST** /management/spatial-units | Add a new spatial-unit |
| [**deleteAllSpatialUnitFeaturesById**](SpatialUnitsControllerApi.md#deleteAllSpatialUnitFeaturesById) | **DELETE** /management/spatial-units/{spatialUnitId}/allFeatures | Delete all features/contents of the selected spatial-unit dataset |
| [**deleteSpatialUnitById**](SpatialUnitsControllerApi.md#deleteSpatialUnitById) | **DELETE** /management/spatial-units/{spatialUnitId} | Delete the features/contents of the selected spatial-unit |
| [**deleteSpatialUnitByIdAndYearAndMonth**](SpatialUnitsControllerApi.md#deleteSpatialUnitByIdAndYearAndMonth) | **DELETE** /management/spatial-units/{spatialUnitId}/{year}/{month}/{day} | Delete the features/contents of the selected spatial-unit, year and month |
| [**getAllSpatialUnitFeaturesById**](SpatialUnitsControllerApi.md#getAllSpatialUnitFeaturesById) | **GET** /management/spatial-units/{spatialUnitId}/allFeatures | retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity) |
| [**getSpatialUnits**](SpatialUnitsControllerApi.md#getSpatialUnits) | **GET** /management/spatial-units | retrieve information about available features of different spatial units/levels |
| [**getSpatialUnitsById**](SpatialUnitsControllerApi.md#getSpatialUnitsById) | **GET** /management/spatial-units/{spatialUnitId} | retrieve information about available features of the selected spatial unit/level |
| [**getSpatialUnitsByIdAndYearAndMonth**](SpatialUnitsControllerApi.md#getSpatialUnitsByIdAndYearAndMonth) | **GET** /management/spatial-units/{spatialUnitId}/{year}/{month}/{day} | retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON |
| [**getSpatialUnitsSchemaById**](SpatialUnitsControllerApi.md#getSpatialUnitsSchemaById) | **GET** /management/spatial-units/{spatialUnitId}/schema | retrieve the JSON schema for the selected spatial unit/level |
| [**updateSpatialUnitAsBody**](SpatialUnitsControllerApi.md#updateSpatialUnitAsBody) | **PUT** /management/spatial-units/{spatialUnitId} | Modify/Update the features of the selected spatial-unit |
| [**updateSpatialUnitMetadataAsBody**](SpatialUnitsControllerApi.md#updateSpatialUnitMetadataAsBody) | **PATCH** /management/spatial-units/{spatialUnitId} | Modify/Update the metadata of the selected spatial-unit |



## addSpatialUnitAsBody

> ResponseEntity addSpatialUnitAsBody(featureData)

Add a new spatial-unit

Add/Register a spatial unit for a certain period of time

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsControllerApi apiInstance = new SpatialUnitsControllerApi(defaultClient);
        SpatialUnitPOSTInputType featureData = new SpatialUnitPOSTInputType(); // SpatialUnitPOSTInputType | featureData
        try {
            ResponseEntity result = apiInstance.addSpatialUnitAsBody(featureData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsControllerApi#addSpatialUnitAsBody");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **featureData** | [**SpatialUnitPOSTInputType**](SpatialUnitPOSTInputType.md)| featureData | |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | Created |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


## deleteAllSpatialUnitFeaturesById

> ResponseEntity deleteAllSpatialUnitFeaturesById(spatialUnitId)

Delete all features/contents of the selected spatial-unit dataset

Delete all features/contents of the selected spatial-unit dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsControllerApi apiInstance = new SpatialUnitsControllerApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        try {
            ResponseEntity result = apiInstance.deleteAllSpatialUnitFeaturesById(spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsControllerApi#deleteAllSpatialUnitFeaturesById");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **spatialUnitId** | **String**| spatialUnitId | |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |


## deleteSpatialUnitById

> ResponseEntity deleteSpatialUnitById(spatialUnitId)

Delete the features/contents of the selected spatial-unit

Delete the features/contents of the selected spatial-unit

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsControllerApi apiInstance = new SpatialUnitsControllerApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        try {
            ResponseEntity result = apiInstance.deleteSpatialUnitById(spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsControllerApi#deleteSpatialUnitById");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **spatialUnitId** | **String**| spatialUnitId | |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |


## deleteSpatialUnitByIdAndYearAndMonth

> ResponseEntity deleteSpatialUnitByIdAndYearAndMonth(day, month, spatialUnitId, year)

Delete the features/contents of the selected spatial-unit, year and month

Delete the features/contents of the selected spatial-unit, year and month

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsControllerApi apiInstance = new SpatialUnitsControllerApi(defaultClient);
        BigDecimal day = new BigDecimal("1.0"); // BigDecimal | day
        BigDecimal month = new BigDecimal("1.0"); // BigDecimal | month
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        BigDecimal year = new BigDecimal("2023.0"); // BigDecimal | year
        try {
            ResponseEntity result = apiInstance.deleteSpatialUnitByIdAndYearAndMonth(day, month, spatialUnitId, year);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsControllerApi#deleteSpatialUnitByIdAndYearAndMonth");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **day** | **BigDecimal**| day | [default to 1.0] |
| **month** | **BigDecimal**| month | [default to 1.0] |
| **spatialUnitId** | **String**| spatialUnitId | |
| **year** | **BigDecimal**| year | [default to 2023.0] |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |


## getAllSpatialUnitFeaturesById

> String getAllSpatialUnitFeaturesById(spatialUnitId, name, simplifyGeometries)

retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)

retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsControllerApi apiInstance = new SpatialUnitsControllerApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        String name = "name_example"; // String | 
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            String result = apiInstance.getAllSpatialUnitFeaturesById(spatialUnitId, name, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsControllerApi#getAllSpatialUnitFeaturesById");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **spatialUnitId** | **String**| spatialUnitId | |
| **name** | **String**|  | [optional] |
| **simplifyGeometries** | **String**| simplifyGeometries | [optional] [default to original] |

### Return type

**String**

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Invalid status value |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getSpatialUnits

> SpatialUnitOverviewType getSpatialUnits(name)

retrieve information about available features of different spatial units/levels

retrieve information about available features of different spatial units/levels

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsControllerApi apiInstance = new SpatialUnitsControllerApi(defaultClient);
        String name = "name_example"; // String | 
        try {
            SpatialUnitOverviewType result = apiInstance.getSpatialUnits(name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsControllerApi#getSpatialUnits");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**|  | [optional] |

### Return type

[**SpatialUnitOverviewType**](SpatialUnitOverviewType.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Invalid status value |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getSpatialUnitsById

> SpatialUnitOverviewType getSpatialUnitsById(spatialUnitId, name)

retrieve information about available features of the selected spatial unit/level

retrieve information about available features of the selected spatial unit/level

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsControllerApi apiInstance = new SpatialUnitsControllerApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        String name = "name_example"; // String | 
        try {
            SpatialUnitOverviewType result = apiInstance.getSpatialUnitsById(spatialUnitId, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsControllerApi#getSpatialUnitsById");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **spatialUnitId** | **String**| spatialUnitId | |
| **name** | **String**|  | [optional] |

### Return type

[**SpatialUnitOverviewType**](SpatialUnitOverviewType.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Invalid status value |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getSpatialUnitsByIdAndYearAndMonth

> byte[] getSpatialUnitsByIdAndYearAndMonth(day, month, spatialUnitId, year, name, simplifyGeometries)

retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON

retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsControllerApi apiInstance = new SpatialUnitsControllerApi(defaultClient);
        BigDecimal day = new BigDecimal("1.0"); // BigDecimal | day
        BigDecimal month = new BigDecimal("1.0"); // BigDecimal | month
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        BigDecimal year = new BigDecimal("2023.0"); // BigDecimal | year
        String name = "name_example"; // String | 
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            byte[] result = apiInstance.getSpatialUnitsByIdAndYearAndMonth(day, month, spatialUnitId, year, name, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsControllerApi#getSpatialUnitsByIdAndYearAndMonth");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **day** | **BigDecimal**| day | [default to 1.0] |
| **month** | **BigDecimal**| month | [default to 1.0] |
| **spatialUnitId** | **String**| spatialUnitId | |
| **year** | **BigDecimal**| year | [default to 2023.0] |
| **name** | **String**|  | [optional] |
| **simplifyGeometries** | **String**| simplifyGeometries | [optional] [default to original] |

### Return type

**byte[]**

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octed-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Invalid status value |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getSpatialUnitsSchemaById

> String getSpatialUnitsSchemaById(spatialUnitId, name)

retrieve the JSON schema for the selected spatial unit/level

retrieve the JSON schema for the selected spatial unit/level. The JSON schema indicates the property structure of the dataset.

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsControllerApi apiInstance = new SpatialUnitsControllerApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        String name = "name_example"; // String | 
        try {
            String result = apiInstance.getSpatialUnitsSchemaById(spatialUnitId, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsControllerApi#getSpatialUnitsSchemaById");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **spatialUnitId** | **String**| spatialUnitId | |
| **name** | **String**|  | [optional] |

### Return type

**String**

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Invalid status value |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## updateSpatialUnitAsBody

> ResponseEntity updateSpatialUnitAsBody(spatialUnitId, featureData)

Modify/Update the features of the selected spatial-unit

Modify/Update the features of the selected spatial-unit. The interface expects a full upload of all geometries for the spatial unit. Internally, those geometries are compared to the existing ones to mark &#39;old&#39; geometries that are no longer in use as outdated. Hence, each geometric object is only persisted once and its use is controlled by time validity marks.

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsControllerApi apiInstance = new SpatialUnitsControllerApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        SpatialUnitPUTInputType featureData = new SpatialUnitPUTInputType(); // SpatialUnitPUTInputType | featureData
        try {
            ResponseEntity result = apiInstance.updateSpatialUnitAsBody(spatialUnitId, featureData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsControllerApi#updateSpatialUnitAsBody");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **spatialUnitId** | **String**| spatialUnitId | |
| **featureData** | [**SpatialUnitPUTInputType**](SpatialUnitPUTInputType.md)| featureData | |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | Created |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


## updateSpatialUnitMetadataAsBody

> ResponseEntity updateSpatialUnitMetadataAsBody(spatialUnitId, metadata)

Modify/Update the metadata of the selected spatial-unit

Modify/Update the metadata of the selected spatial-unit. This replaces the formerly stored metadata.

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsControllerApi apiInstance = new SpatialUnitsControllerApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        SpatialUnitPATCHInputType metadata = new SpatialUnitPATCHInputType(); // SpatialUnitPATCHInputType | metadata
        try {
            ResponseEntity result = apiInstance.updateSpatialUnitMetadataAsBody(spatialUnitId, metadata);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsControllerApi#updateSpatialUnitMetadataAsBody");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **spatialUnitId** | **String**| spatialUnitId | |
| **metadata** | [**SpatialUnitPATCHInputType**](SpatialUnitPATCHInputType.md)| metadata | |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **405** | Invalid input |  -  |


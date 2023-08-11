# SpatialUnitsPublicControllerApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllSpatialUnitFeaturesById1**](SpatialUnitsPublicControllerApi.md#getAllSpatialUnitFeaturesById1) | **GET** /management/public/spatial-units/{spatialUnitId}/allFeatures | retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity) |
| [**getSpatialUnits1**](SpatialUnitsPublicControllerApi.md#getSpatialUnits1) | **GET** /management/public/spatial-units | retrieve information about available features of different spatial units/levels |
| [**getSpatialUnitsById1**](SpatialUnitsPublicControllerApi.md#getSpatialUnitsById1) | **GET** /management/public/spatial-units/{spatialUnitId} | retrieve information about available features of the selected spatial unit/level |
| [**getSpatialUnitsByIdAndYearAndMonth1**](SpatialUnitsPublicControllerApi.md#getSpatialUnitsByIdAndYearAndMonth1) | **GET** /management/public/spatial-units/{spatialUnitId}/{year}/{month}/{day} | retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON |
| [**getSpatialUnitsSchemaById1**](SpatialUnitsPublicControllerApi.md#getSpatialUnitsSchemaById1) | **GET** /management/public/spatial-units/{spatialUnitId}/schema | retrieve the JSON schema for the selected spatial unit/level |



## getAllSpatialUnitFeaturesById1

> String getAllSpatialUnitFeaturesById1(spatialUnitId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicControllerApi apiInstance = new SpatialUnitsPublicControllerApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            String result = apiInstance.getAllSpatialUnitFeaturesById1(spatialUnitId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicControllerApi#getAllSpatialUnitFeaturesById1");
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


## getSpatialUnits1

> SpatialUnitOverviewType getSpatialUnits1()

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicControllerApi apiInstance = new SpatialUnitsPublicControllerApi(defaultClient);
        try {
            SpatialUnitOverviewType result = apiInstance.getSpatialUnits1();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicControllerApi#getSpatialUnits1");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

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


## getSpatialUnitsById1

> SpatialUnitOverviewType getSpatialUnitsById1(spatialUnitId)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicControllerApi apiInstance = new SpatialUnitsPublicControllerApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        try {
            SpatialUnitOverviewType result = apiInstance.getSpatialUnitsById1(spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicControllerApi#getSpatialUnitsById1");
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


## getSpatialUnitsByIdAndYearAndMonth1

> byte[] getSpatialUnitsByIdAndYearAndMonth1(day, month, spatialUnitId, year, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicControllerApi apiInstance = new SpatialUnitsPublicControllerApi(defaultClient);
        BigDecimal day = new BigDecimal("1.0"); // BigDecimal | day
        BigDecimal month = new BigDecimal("1.0"); // BigDecimal | month
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        BigDecimal year = new BigDecimal("2023.0"); // BigDecimal | year
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            byte[] result = apiInstance.getSpatialUnitsByIdAndYearAndMonth1(day, month, spatialUnitId, year, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicControllerApi#getSpatialUnitsByIdAndYearAndMonth1");
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


## getSpatialUnitsSchemaById1

> String getSpatialUnitsSchemaById1(spatialUnitId)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicControllerApi apiInstance = new SpatialUnitsPublicControllerApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        try {
            String result = apiInstance.getSpatialUnitsSchemaById1(spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicControllerApi#getSpatialUnitsSchemaById1");
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


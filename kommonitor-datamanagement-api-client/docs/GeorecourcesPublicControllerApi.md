# GeorecourcesPublicControllerApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllPublicGeoresourceFeaturesById**](GeorecourcesPublicControllerApi.md#getAllPublicGeoresourceFeaturesById) | **GET** /management/public/georesources/{georesourceId}/allFeatures | retrieve all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity) |
| [**getPublicGeoresourceById**](GeorecourcesPublicControllerApi.md#getPublicGeoresourceById) | **GET** /management/public/georesources/{georesourceId} | retrieve information about available features of the selected public geo-resource dataset |
| [**getPublicGeoresourceByIdAndYearAndMonth**](GeorecourcesPublicControllerApi.md#getPublicGeoresourceByIdAndYearAndMonth) | **GET** /management/public/georesources/{georesourceId}/{year}/{month}/{day} | retrieve the features according to the selected public geo-resource dataset and selected year and month as GeoJSON |
| [**getPublicGeoresourceSchemaByLevel**](GeorecourcesPublicControllerApi.md#getPublicGeoresourceSchemaByLevel) | **GET** /management/public/georesources/{georesourceId}/schema | retrieve the JSON schema for the selected public geo-resource dataset |
| [**getPublicGeoresources**](GeorecourcesPublicControllerApi.md#getPublicGeoresources) | **GET** /management/public/georesources | retrieve information about available features of different public geo-resource datasets |



## getAllPublicGeoresourceFeaturesById

> String getAllPublicGeoresourceFeaturesById(georesourceId, simplifyGeometries)

retrieve all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)

retrieve all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesPublicControllerApi apiInstance = new GeorecourcesPublicControllerApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            String result = apiInstance.getAllPublicGeoresourceFeaturesById(georesourceId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesPublicControllerApi#getAllPublicGeoresourceFeaturesById");
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
| **georesourceId** | **String**| georesourceId | |
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


## getPublicGeoresourceById

> GeoresourceOverviewType getPublicGeoresourceById(georesourceId)

retrieve information about available features of the selected public geo-resource dataset

retrieve information about available features of the selected public geo-resource dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesPublicControllerApi apiInstance = new GeorecourcesPublicControllerApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        try {
            GeoresourceOverviewType result = apiInstance.getPublicGeoresourceById(georesourceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesPublicControllerApi#getPublicGeoresourceById");
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
| **georesourceId** | **String**| georesourceId | |

### Return type

[**GeoresourceOverviewType**](GeoresourceOverviewType.md)

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


## getPublicGeoresourceByIdAndYearAndMonth

> byte[] getPublicGeoresourceByIdAndYearAndMonth(day, georesourceId, month, year, simplifyGeometries)

retrieve the features according to the selected public geo-resource dataset and selected year and month as GeoJSON

retrieve the features according to the selected public geo-resource dataset and selected year and month as GeoJSON

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesPublicControllerApi apiInstance = new GeorecourcesPublicControllerApi(defaultClient);
        BigDecimal day = new BigDecimal("1.0"); // BigDecimal | day
        String georesourceId = "georesourceId_example"; // String | georesourceId
        BigDecimal month = new BigDecimal("1.0"); // BigDecimal | month
        BigDecimal year = new BigDecimal("2023.0"); // BigDecimal | year
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            byte[] result = apiInstance.getPublicGeoresourceByIdAndYearAndMonth(day, georesourceId, month, year, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesPublicControllerApi#getPublicGeoresourceByIdAndYearAndMonth");
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
| **georesourceId** | **String**| georesourceId | |
| **month** | **BigDecimal**| month | [default to 1.0] |
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


## getPublicGeoresourceSchemaByLevel

> String getPublicGeoresourceSchemaByLevel(georesourceId)

retrieve the JSON schema for the selected public geo-resource dataset

retrieve the JSON schema for the selected public geo-resource dataset. The JSON schema indicates the property structure of the dataset.

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesPublicControllerApi apiInstance = new GeorecourcesPublicControllerApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        try {
            String result = apiInstance.getPublicGeoresourceSchemaByLevel(georesourceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesPublicControllerApi#getPublicGeoresourceSchemaByLevel");
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
| **georesourceId** | **String**| georesourceId | |

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


## getPublicGeoresources

> GeoresourceOverviewType getPublicGeoresources()

retrieve information about available features of different public geo-resource datasets

retrieve information about available features of different public geo-resource datasets

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesPublicControllerApi apiInstance = new GeorecourcesPublicControllerApi(defaultClient);
        try {
            GeoresourceOverviewType result = apiInstance.getPublicGeoresources();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesPublicControllerApi#getPublicGeoresources");
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

[**GeoresourceOverviewType**](GeoresourceOverviewType.md)

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


# GeorecourcesControllerApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addGeoresourceAsBody**](GeorecourcesControllerApi.md#addGeoresourceAsBody) | **POST** /management/georesources | Add a new geo-resource |
| [**deleteAllGeoresourceFeaturesById**](GeorecourcesControllerApi.md#deleteAllGeoresourceFeaturesById) | **DELETE** /management/georesources/{georesourceId}/allFeatures | Delete all features/contents of the selected geo-resource dataset |
| [**deleteGeoresourceById**](GeorecourcesControllerApi.md#deleteGeoresourceById) | **DELETE** /management/georesources/{georesourceId} | Delete the features/contents of the selected geo-resource dataset |
| [**deleteGeoresourceByIdAndYearAndMonth**](GeorecourcesControllerApi.md#deleteGeoresourceByIdAndYearAndMonth) | **DELETE** /management/georesources/{georesourceId}/{year}/{month}/{day} | Delete the features/contents of the selected geo-resource dataset, selected by year and month |
| [**getAllGeoresourceFeaturesById**](GeorecourcesControllerApi.md#getAllGeoresourceFeaturesById) | **GET** /management/georesources/{georesourceId}/allFeatures | retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity) |
| [**getGeoresourceById**](GeorecourcesControllerApi.md#getGeoresourceById) | **GET** /management/georesources/{georesourceId} | retrieve information about available features of the selected geo-resource dataset |
| [**getGeoresourceByIdAndYearAndMonth**](GeorecourcesControllerApi.md#getGeoresourceByIdAndYearAndMonth) | **GET** /management/georesources/{georesourceId}/{year}/{month}/{day} | retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON |
| [**getGeoresourceSchemaByLevel**](GeorecourcesControllerApi.md#getGeoresourceSchemaByLevel) | **GET** /management/georesources/{georesourceId}/schema | retrieve the JSON schema for the selected geo-resource dataset |
| [**getGeoresources**](GeorecourcesControllerApi.md#getGeoresources) | **GET** /management/georesources | retrieve information about available features of different geo-resource datasets |
| [**updateGeoresourceAsBody**](GeorecourcesControllerApi.md#updateGeoresourceAsBody) | **PUT** /management/georesources/{georesourceId} | Modify/Update the features of the selected geo-resource dataset |
| [**updateGeoresourceMetadataAsBody**](GeorecourcesControllerApi.md#updateGeoresourceMetadataAsBody) | **PATCH** /management/georesources/{georesourceId} | Modify/Update the metadata of the selected geo-resource dataset |



## addGeoresourceAsBody

> ResponseEntity addGeoresourceAsBody(featureData)

Add a new geo-resource

Add/Register a geo-resource dataset for a certain period of time

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesControllerApi apiInstance = new GeorecourcesControllerApi(defaultClient);
        GeoresourcePOSTInputType featureData = new GeoresourcePOSTInputType(); // GeoresourcePOSTInputType | featureData
        try {
            ResponseEntity result = apiInstance.addGeoresourceAsBody(featureData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesControllerApi#addGeoresourceAsBody");
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
| **featureData** | [**GeoresourcePOSTInputType**](GeoresourcePOSTInputType.md)| featureData | |

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


## deleteAllGeoresourceFeaturesById

> ResponseEntity deleteAllGeoresourceFeaturesById(georesourceId)

Delete all features/contents of the selected geo-resource dataset

Delete all features/contents of the selected geo-resource dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesControllerApi apiInstance = new GeorecourcesControllerApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        try {
            ResponseEntity result = apiInstance.deleteAllGeoresourceFeaturesById(georesourceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesControllerApi#deleteAllGeoresourceFeaturesById");
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


## deleteGeoresourceById

> ResponseEntity deleteGeoresourceById(georesourceId)

Delete the features/contents of the selected geo-resource dataset

Delete the features/contents of the selected geo-resource dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesControllerApi apiInstance = new GeorecourcesControllerApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        try {
            ResponseEntity result = apiInstance.deleteGeoresourceById(georesourceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesControllerApi#deleteGeoresourceById");
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


## deleteGeoresourceByIdAndYearAndMonth

> ResponseEntity deleteGeoresourceByIdAndYearAndMonth(day, georesourceId, month, year)

Delete the features/contents of the selected geo-resource dataset, selected by year and month

Delete the features/contents of the selected geo-resource dataset, selected by year and month

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesControllerApi apiInstance = new GeorecourcesControllerApi(defaultClient);
        BigDecimal day = new BigDecimal("1.0"); // BigDecimal | day
        String georesourceId = "georesourceId_example"; // String | georesourceId
        BigDecimal month = new BigDecimal("1.0"); // BigDecimal | month
        BigDecimal year = new BigDecimal("2023.0"); // BigDecimal | year
        try {
            ResponseEntity result = apiInstance.deleteGeoresourceByIdAndYearAndMonth(day, georesourceId, month, year);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesControllerApi#deleteGeoresourceByIdAndYearAndMonth");
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


## getAllGeoresourceFeaturesById

> String getAllGeoresourceFeaturesById(georesourceId, name, simplifyGeometries)

retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)

retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesControllerApi apiInstance = new GeorecourcesControllerApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        String name = "name_example"; // String | 
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            String result = apiInstance.getAllGeoresourceFeaturesById(georesourceId, name, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesControllerApi#getAllGeoresourceFeaturesById");
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


## getGeoresourceById

> GeoresourceOverviewType getGeoresourceById(georesourceId, name)

retrieve information about available features of the selected geo-resource dataset

retrieve information about available features of the selected geo-resource dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesControllerApi apiInstance = new GeorecourcesControllerApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        String name = "name_example"; // String | 
        try {
            GeoresourceOverviewType result = apiInstance.getGeoresourceById(georesourceId, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesControllerApi#getGeoresourceById");
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
| **name** | **String**|  | [optional] |

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


## getGeoresourceByIdAndYearAndMonth

> byte[] getGeoresourceByIdAndYearAndMonth(day, georesourceId, month, year, name, simplifyGeometries)

retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON

retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesControllerApi apiInstance = new GeorecourcesControllerApi(defaultClient);
        BigDecimal day = new BigDecimal("1.0"); // BigDecimal | day
        String georesourceId = "georesourceId_example"; // String | georesourceId
        BigDecimal month = new BigDecimal("1.0"); // BigDecimal | month
        BigDecimal year = new BigDecimal("2023.0"); // BigDecimal | year
        String name = "name_example"; // String | 
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            byte[] result = apiInstance.getGeoresourceByIdAndYearAndMonth(day, georesourceId, month, year, name, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesControllerApi#getGeoresourceByIdAndYearAndMonth");
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


## getGeoresourceSchemaByLevel

> String getGeoresourceSchemaByLevel(georesourceId, name)

retrieve the JSON schema for the selected geo-resource dataset

retrieve the JSON schema for the selected geo-resource dataset. The JSON schema indicates the property structure of the dataset.

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesControllerApi apiInstance = new GeorecourcesControllerApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        String name = "name_example"; // String | 
        try {
            String result = apiInstance.getGeoresourceSchemaByLevel(georesourceId, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesControllerApi#getGeoresourceSchemaByLevel");
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


## getGeoresources

> GeoresourceOverviewType getGeoresources(name)

retrieve information about available features of different geo-resource datasets

retrieve information about available features of different geo-resource datasets

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesControllerApi apiInstance = new GeorecourcesControllerApi(defaultClient);
        String name = "name_example"; // String | 
        try {
            GeoresourceOverviewType result = apiInstance.getGeoresources(name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesControllerApi#getGeoresources");
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


## updateGeoresourceAsBody

> ResponseEntity updateGeoresourceAsBody(georesourceId, featureData)

Modify/Update the features of the selected geo-resource dataset

Modify/Update the features of the selected geo-resource dataset.  The interface expects a full upload of all geometries for the spatial unit. Internally, those geometries are compared to the existing ones to mark &#39;old&#39; geometries that are no longer in use as outdated. Hence, each geometric object is only persisted once and its use is controlled by time validity marks.

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesControllerApi apiInstance = new GeorecourcesControllerApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        GeoresourcePUTInputType featureData = new GeoresourcePUTInputType(); // GeoresourcePUTInputType | featureData
        try {
            ResponseEntity result = apiInstance.updateGeoresourceAsBody(georesourceId, featureData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesControllerApi#updateGeoresourceAsBody");
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
| **featureData** | [**GeoresourcePUTInputType**](GeoresourcePUTInputType.md)| featureData | |

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


## updateGeoresourceMetadataAsBody

> ResponseEntity updateGeoresourceMetadataAsBody(georesourceId, metadata)

Modify/Update the metadata of the selected geo-resource dataset

Modify/Update the metadata of the selected geo-resource dataset. This replaces the formerly stored metadata.

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeorecourcesControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeorecourcesControllerApi apiInstance = new GeorecourcesControllerApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        GeoresourcePATCHInputType metadata = new GeoresourcePATCHInputType(); // GeoresourcePATCHInputType | metadata
        try {
            ResponseEntity result = apiInstance.updateGeoresourceMetadataAsBody(georesourceId, metadata);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeorecourcesControllerApi#updateGeoresourceMetadataAsBody");
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
| **metadata** | [**GeoresourcePATCHInputType**](GeoresourcePATCHInputType.md)| metadata | |

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


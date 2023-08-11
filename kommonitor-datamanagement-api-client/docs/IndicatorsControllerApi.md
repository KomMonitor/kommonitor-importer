# IndicatorsControllerApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addIndicatorAsBody**](IndicatorsControllerApi.md#addIndicatorAsBody) | **POST** /management/indicators | Add a new indicator dataset |
| [**deleteIndicatorById**](IndicatorsControllerApi.md#deleteIndicatorById) | **DELETE** /management/indicators/{indicatorId} | Delete the features/contents of the selected indicator dataset |
| [**deleteIndicatorByIdAndSpatialUnitId**](IndicatorsControllerApi.md#deleteIndicatorByIdAndSpatialUnitId) | **DELETE** /management/indicators/{indicatorId}/{spatialUnitId} | Delete the features/contents of the selected indicator dataset for the selected spatial unit |
| [**deleteIndicatorByIdAndYearAndMonth**](IndicatorsControllerApi.md#deleteIndicatorByIdAndYearAndMonth) | **DELETE** /management/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day} | Delete the features/contents of the selected indicator dataset, selected by year and month |
| [**getIndicatorById**](IndicatorsControllerApi.md#getIndicatorById) | **GET** /management/indicators/{indicatorId} | retrieve information about the selected indicator |
| [**getIndicatorBySpatialUnitIdAndId**](IndicatorsControllerApi.md#getIndicatorBySpatialUnitIdAndId) | **GET** /management/indicators/{indicatorId}/{spatialUnitId} | retrieve the indicator for the selected spatial unit as GeoJSON |
| [**getIndicatorBySpatialUnitIdAndIdAndYearAndMonth**](IndicatorsControllerApi.md#getIndicatorBySpatialUnitIdAndIdAndYearAndMonth) | **GET** /management/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day} | retrieve the indicator for the selected spatial unit, year and month as GeoJSON |
| [**getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry**](IndicatorsControllerApi.md#getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry) | **GET** /management/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}/without-geometry | retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries! |
| [**getIndicatorBySpatialUnitIdAndIdWithoutGeometry**](IndicatorsControllerApi.md#getIndicatorBySpatialUnitIdAndIdWithoutGeometry) | **GET** /management/indicators/{indicatorId}/{spatialUnitId}/without-geometry | retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries! |
| [**getIndicators**](IndicatorsControllerApi.md#getIndicators) | **GET** /management/indicators | retrieve information about available indicators |
| [**updateIndicatorAsBody**](IndicatorsControllerApi.md#updateIndicatorAsBody) | **PUT** /management/indicators/{indicatorId} | Modify/Update the contents of the selected indicator dataset |
| [**updateIndicatorDisplayOrder**](IndicatorsControllerApi.md#updateIndicatorDisplayOrder) | **PATCH** /management/indicators/display-order | Update displayOrder for submitted indicators |
| [**updateIndicatorMetadataAsBody**](IndicatorsControllerApi.md#updateIndicatorMetadataAsBody) | **PATCH** /management/indicators/{indicatorId} | Modify/Update the metadata of the selected indicator dataset |
| [**updateIndicatorRolesUsingPATCH**](IndicatorsControllerApi.md#updateIndicatorRolesUsingPATCH) | **PATCH** /management/indicators/{indicatorId}/{spatialUnitId} | Modify/Update the selected indicator dataset |



## addIndicatorAsBody

> ResponseEntity addIndicatorAsBody(indicatorData)

Add a new indicator dataset

Add/Register an indicator dataset for a certain period of time and spatial unit/level

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        IndicatorPOSTInputType indicatorData = new IndicatorPOSTInputType(); // IndicatorPOSTInputType | indicatorData
        try {
            ResponseEntity result = apiInstance.addIndicatorAsBody(indicatorData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#addIndicatorAsBody");
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
| **indicatorData** | [**IndicatorPOSTInputType**](IndicatorPOSTInputType.md)| indicatorData | |

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
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


## deleteIndicatorById

> ResponseEntity deleteIndicatorById(indicatorId)

Delete the features/contents of the selected indicator dataset

Delete the features/contents of the selected indicator dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        try {
            ResponseEntity result = apiInstance.deleteIndicatorById(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#deleteIndicatorById");
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
| **indicatorId** | **String**| indicatorId | |

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


## deleteIndicatorByIdAndSpatialUnitId

> ResponseEntity deleteIndicatorByIdAndSpatialUnitId(indicatorId, spatialUnitId)

Delete the features/contents of the selected indicator dataset for the selected spatial unit

Delete the features/contents of the selected indicator dataset for the selected spatial unit

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        try {
            ResponseEntity result = apiInstance.deleteIndicatorByIdAndSpatialUnitId(indicatorId, spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#deleteIndicatorByIdAndSpatialUnitId");
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
| **indicatorId** | **String**| indicatorId | |
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


## deleteIndicatorByIdAndYearAndMonth

> ResponseEntity deleteIndicatorByIdAndYearAndMonth(day, indicatorId, month, spatialUnitId, year)

Delete the features/contents of the selected indicator dataset, selected by year and month

Delete the features/contents of the selected indicator dataset, selected by year and month

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        BigDecimal day = new BigDecimal("1.0"); // BigDecimal | day
        String indicatorId = "indicatorId_example"; // String | indicatorId
        BigDecimal month = new BigDecimal("1.0"); // BigDecimal | month
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        BigDecimal year = new BigDecimal("2023.0"); // BigDecimal | year
        try {
            ResponseEntity result = apiInstance.deleteIndicatorByIdAndYearAndMonth(day, indicatorId, month, spatialUnitId, year);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#deleteIndicatorByIdAndYearAndMonth");
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
| **indicatorId** | **String**| indicatorId | |
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


## getIndicatorById

> IndicatorOverviewType getIndicatorById(indicatorId, name)

retrieve information about the selected indicator

retrieve information about the selected indicator

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        String name = "name_example"; // String | 
        try {
            IndicatorOverviewType result = apiInstance.getIndicatorById(indicatorId, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#getIndicatorById");
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
| **indicatorId** | **String**| indicatorId | |
| **name** | **String**|  | [optional] |

### Return type

[**IndicatorOverviewType**](IndicatorOverviewType.md)

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


## getIndicatorBySpatialUnitIdAndId

> byte[] getIndicatorBySpatialUnitIdAndId(indicatorId, spatialUnitId, name, simplifyGeometries)

retrieve the indicator for the selected spatial unit as GeoJSON

retrieve the indicator for the selected spatial unit as GeoJSON

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        String name = "name_example"; // String | 
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            byte[] result = apiInstance.getIndicatorBySpatialUnitIdAndId(indicatorId, spatialUnitId, name, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#getIndicatorBySpatialUnitIdAndId");
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
| **indicatorId** | **String**| indicatorId | |
| **spatialUnitId** | **String**| spatialUnitId | |
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


## getIndicatorBySpatialUnitIdAndIdAndYearAndMonth

> byte[] getIndicatorBySpatialUnitIdAndIdAndYearAndMonth(day, indicatorId, month, spatialUnitId, year, name, simplifyGeometries)

retrieve the indicator for the selected spatial unit, year and month as GeoJSON

retrieve the indicator for the selected spatial unit, year and month as GeoJSON

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        BigDecimal day = new BigDecimal("1.0"); // BigDecimal | day
        String indicatorId = "indicatorId_example"; // String | indicatorId
        BigDecimal month = new BigDecimal("1.0"); // BigDecimal | month
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        BigDecimal year = new BigDecimal("2023.0"); // BigDecimal | year
        String name = "name_example"; // String | 
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            byte[] result = apiInstance.getIndicatorBySpatialUnitIdAndIdAndYearAndMonth(day, indicatorId, month, spatialUnitId, year, name, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
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
| **indicatorId** | **String**| indicatorId | |
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


## getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry

> Map&lt;String, String&gt; getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(day, indicatorId, month, spatialUnitId, year, name)

retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!

retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        BigDecimal day = new BigDecimal("1.0"); // BigDecimal | day
        String indicatorId = "indicatorId_example"; // String | indicatorId
        BigDecimal month = new BigDecimal("1.0"); // BigDecimal | month
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        BigDecimal year = new BigDecimal("2023.0"); // BigDecimal | year
        String name = "name_example"; // String | 
        try {
            Map<String, String> result = apiInstance.getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(day, indicatorId, month, spatialUnitId, year, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
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
| **indicatorId** | **String**| indicatorId | |
| **month** | **BigDecimal**| month | [default to 1.0] |
| **spatialUnitId** | **String**| spatialUnitId | |
| **year** | **BigDecimal**| year | [default to 2023.0] |
| **name** | **String**|  | [optional] |

### Return type

**Map&lt;String, String&gt;**

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


## getIndicatorBySpatialUnitIdAndIdWithoutGeometry

> Map&lt;String, String&gt; getIndicatorBySpatialUnitIdAndIdWithoutGeometry(indicatorId, spatialUnitId, name)

retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!

retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        String name = "name_example"; // String | 
        try {
            Map<String, String> result = apiInstance.getIndicatorBySpatialUnitIdAndIdWithoutGeometry(indicatorId, spatialUnitId, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#getIndicatorBySpatialUnitIdAndIdWithoutGeometry");
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
| **indicatorId** | **String**| indicatorId | |
| **spatialUnitId** | **String**| spatialUnitId | |
| **name** | **String**|  | [optional] |

### Return type

**Map&lt;String, String&gt;**

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


## getIndicators

> IndicatorOverviewType getIndicators(name)

retrieve information about available indicators

retrieve information about available indicators

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        String name = "name_example"; // String | 
        try {
            IndicatorOverviewType result = apiInstance.getIndicators(name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#getIndicators");
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

[**IndicatorOverviewType**](IndicatorOverviewType.md)

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


## updateIndicatorAsBody

> ResponseEntity updateIndicatorAsBody(indicatorId, indicatorData)

Modify/Update the contents of the selected indicator dataset

Modify/Update the contents of the selected indicator dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        IndicatorPUTInputType indicatorData = new IndicatorPUTInputType(); // IndicatorPUTInputType | indicatorData
        try {
            ResponseEntity result = apiInstance.updateIndicatorAsBody(indicatorId, indicatorData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#updateIndicatorAsBody");
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
| **indicatorId** | **String**| indicatorId | |
| **indicatorData** | [**IndicatorPUTInputType**](IndicatorPUTInputType.md)| indicatorData | |

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
| **200** | OK - Updated |  -  |
| **201** | Created |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


## updateIndicatorDisplayOrder

> updateIndicatorDisplayOrder(indicatorOrderArray)

Update displayOrder for submitted indicators

Update displayOrder for submitted indicators

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        List<IndicatorPATCHDisplayOrderInputType> indicatorOrderArray = Arrays.asList(); // List<IndicatorPATCHDisplayOrderInputType> | array of indicator id and displayOrder items
        try {
            apiInstance.updateIndicatorDisplayOrder(indicatorOrderArray);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#updateIndicatorDisplayOrder");
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
| **indicatorOrderArray** | [**List&lt;IndicatorPATCHDisplayOrderInputType&gt;**](IndicatorPATCHDisplayOrderInputType.md)| array of indicator id and displayOrder items | |

### Return type

null (empty response body)

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
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


## updateIndicatorMetadataAsBody

> ResponseEntity updateIndicatorMetadataAsBody(indicatorId, metadata)

Modify/Update the metadata of the selected indicator dataset

Modify/Update the metadata of the selected indicator dataset. This replaces the formerly stored metadata.

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        IndicatorMetadataPATCHInputType metadata = new IndicatorMetadataPATCHInputType(); // IndicatorMetadataPATCHInputType | metadata
        try {
            ResponseEntity result = apiInstance.updateIndicatorMetadataAsBody(indicatorId, metadata);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#updateIndicatorMetadataAsBody");
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
| **indicatorId** | **String**| indicatorId | |
| **metadata** | [**IndicatorMetadataPATCHInputType**](IndicatorMetadataPATCHInputType.md)| metadata | |

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


## updateIndicatorRolesUsingPATCH

> ResponseEntity updateIndicatorRolesUsingPATCH(indicatorId, spatialUnitId, indicatorData)

Modify/Update the selected indicator dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsControllerApi apiInstance = new IndicatorsControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        IndicatorPATCHInputType indicatorData = new IndicatorPATCHInputType(); // IndicatorPATCHInputType | indicatorData
        try {
            ResponseEntity result = apiInstance.updateIndicatorRolesUsingPATCH(indicatorId, spatialUnitId, indicatorData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsControllerApi#updateIndicatorRolesUsingPATCH");
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
| **indicatorId** | **String**| indicatorId | |
| **spatialUnitId** | **String**| spatialUnitId | |
| **indicatorData** | [**IndicatorPATCHInputType**](IndicatorPATCHInputType.md)| indicatorData | |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/octed-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **405** | Invalid input |  -  |


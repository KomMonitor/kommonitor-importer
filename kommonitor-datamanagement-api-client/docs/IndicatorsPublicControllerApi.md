# IndicatorsPublicControllerApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getIndicators1**](IndicatorsPublicControllerApi.md#getIndicators1) | **GET** /management/public/indicators | retrieve information about available public indicators |
| [**getPublicIndicatorById**](IndicatorsPublicControllerApi.md#getPublicIndicatorById) | **GET** /management/public/indicators/{indicatorId} | retrieve information about the selected public indicator |
| [**getPublicIndicatorBySpatialUnitIdAndId**](IndicatorsPublicControllerApi.md#getPublicIndicatorBySpatialUnitIdAndId) | **GET** /management/public/indicators/{indicatorId}/{spatialUnitId} | retrieve the public indicator for the selected spatial unit as GeoJSON |
| [**getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth**](IndicatorsPublicControllerApi.md#getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth) | **GET** /management/public/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day} | retrieve the public indicator for the selected public spatial unit, year and month as GeoJSON |
| [**getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry**](IndicatorsPublicControllerApi.md#getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry) | **GET** /management/public/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}/without-geometry | retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries! |
| [**getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry**](IndicatorsPublicControllerApi.md#getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry) | **GET** /management/public/indicators/{indicatorId}/{spatialUnitId}/without-geometry | retrieve the public indicator values and other properties for the selected public spatial unit. It does not include the spatial geometries! |



## getIndicators1

> IndicatorOverviewType getIndicators1()

retrieve information about available public indicators

retrieve information about available public indicators

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicControllerApi apiInstance = new IndicatorsPublicControllerApi(defaultClient);
        try {
            IndicatorOverviewType result = apiInstance.getIndicators1();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicControllerApi#getIndicators1");
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


## getPublicIndicatorById

> IndicatorOverviewType getPublicIndicatorById(indicatorId)

retrieve information about the selected public indicator

retrieve information about the selected public indicator

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicControllerApi apiInstance = new IndicatorsPublicControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        try {
            IndicatorOverviewType result = apiInstance.getPublicIndicatorById(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicControllerApi#getPublicIndicatorById");
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


## getPublicIndicatorBySpatialUnitIdAndId

> byte[] getPublicIndicatorBySpatialUnitIdAndId(indicatorId, spatialUnitId, simplifyGeometries)

retrieve the public indicator for the selected spatial unit as GeoJSON

retrieve the public indicator for the selected spatial unit as GeoJSON

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicControllerApi apiInstance = new IndicatorsPublicControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            byte[] result = apiInstance.getPublicIndicatorBySpatialUnitIdAndId(indicatorId, spatialUnitId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicControllerApi#getPublicIndicatorBySpatialUnitIdAndId");
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


## getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth

> byte[] getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth(day, indicatorId, month, spatialUnitId, year, simplifyGeometries)

retrieve the public indicator for the selected public spatial unit, year and month as GeoJSON

retrieve the public indicator for the selected spatial unit, year and month as GeoJSON

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicControllerApi apiInstance = new IndicatorsPublicControllerApi(defaultClient);
        BigDecimal day = new BigDecimal("1.0"); // BigDecimal | day
        String indicatorId = "indicatorId_example"; // String | indicatorId
        BigDecimal month = new BigDecimal("1.0"); // BigDecimal | month
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        BigDecimal year = new BigDecimal("2023.0"); // BigDecimal | year
        String simplifyGeometries = "original"; // String | simplifyGeometries
        try {
            byte[] result = apiInstance.getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth(day, indicatorId, month, spatialUnitId, year, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicControllerApi#getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
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


## getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry

> Map&lt;String, String&gt; getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(day, indicatorId, month, spatialUnitId, year)

retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries!

retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries!

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicControllerApi apiInstance = new IndicatorsPublicControllerApi(defaultClient);
        BigDecimal day = new BigDecimal("1.0"); // BigDecimal | day
        String indicatorId = "indicatorId_example"; // String | indicatorId
        BigDecimal month = new BigDecimal("1.0"); // BigDecimal | month
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        BigDecimal year = new BigDecimal("2023.0"); // BigDecimal | year
        try {
            Map<String, String> result = apiInstance.getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(day, indicatorId, month, spatialUnitId, year);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicControllerApi#getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
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


## getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry

> Map&lt;String, String&gt; getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry(indicatorId, spatialUnitId)

retrieve the public indicator values and other properties for the selected public spatial unit. It does not include the spatial geometries!

retrieve the public indicator values and other properties for the selected public spatial unit. It does not include the spatial geometries!

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicControllerApi apiInstance = new IndicatorsPublicControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        String spatialUnitId = "spatialUnitId_example"; // String | spatialUnitId
        try {
            Map<String, String> result = apiInstance.getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry(indicatorId, spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicControllerApi#getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry");
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


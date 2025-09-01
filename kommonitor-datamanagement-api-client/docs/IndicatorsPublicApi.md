# IndicatorsPublicApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**filterPublicIndicators**](IndicatorsPublicApi.md#filterPublicIndicators) | **POST** /public/indicators/filter | Filter public indicators |
| [**getPublicIndicatorById**](IndicatorsPublicApi.md#getPublicIndicatorById) | **GET** /public/indicators/{indicatorId} | retrieve information about the selected public indicator |
| [**getPublicIndicatorBySpatialUnitIdAndId**](IndicatorsPublicApi.md#getPublicIndicatorBySpatialUnitIdAndId) | **GET** /public/indicators/{indicatorId}/{spatialUnitId} | retrieve the public indicator for the selected spatial unit as GeoJSON |
| [**getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth**](IndicatorsPublicApi.md#getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth) | **GET** /public/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day} | retrieve the public indicator for the selected public spatial unit, year and month as GeoJSON |
| [**getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry**](IndicatorsPublicApi.md#getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry) | **GET** /public/indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}/without-geometry | retrieve the public indicator values and other properties for the selected public spatial unit, year and month. It does not include the spatial geometries! |
| [**getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry**](IndicatorsPublicApi.md#getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry) | **GET** /public/indicators/{indicatorId}/{spatialUnitId}/without-geometry | retrieve the public indicator values and other properties for the selected public spatial unit. It does not include the spatial geometries! |
| [**getPublicIndicators**](IndicatorsPublicApi.md#getPublicIndicators) | **GET** /public/indicators | retrieve information about available public indicators |
| [**getPublicSingleIndicatorFeatureById**](IndicatorsPublicApi.md#getPublicSingleIndicatorFeatureById) | **GET** /public/indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId} | retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity) |
| [**getPublicSingleIndicatorFeatureRecordById**](IndicatorsPublicApi.md#getPublicSingleIndicatorFeatureRecordById) | **GET** /public/indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | retrieve single feature database record specified by its unique database primary key id |



## filterPublicIndicators

> List&lt;IndicatorOverviewType&gt; filterPublicIndicators(resourceFilterType)

Filter public indicators

Filter public indicators datasets according to the specified filter

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");

        IndicatorsPublicApi apiInstance = new IndicatorsPublicApi(defaultClient);
        ResourceFilterType resourceFilterType = new ResourceFilterType(); // ResourceFilterType | filter data
        try {
            List<IndicatorOverviewType> result = apiInstance.filterPublicIndicators(resourceFilterType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicApi#filterPublicIndicators");
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
| **resourceFilterType** | [**ResourceFilterType**](ResourceFilterType.md)| filter data | |

### Return type

[**List&lt;IndicatorOverviewType&gt;**](IndicatorOverviewType.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicApi apiInstance = new IndicatorsPublicApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected public indicator dataset
        try {
            IndicatorOverviewType result = apiInstance.getPublicIndicatorById(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicApi#getPublicIndicatorById");
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
| **indicatorId** | **String**| unique identifier of the selected public indicator dataset | |

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicApi apiInstance = new IndicatorsPublicApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected public indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the public spatial level
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getPublicIndicatorBySpatialUnitIdAndId(indicatorId, spatialUnitId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicApi#getPublicIndicatorBySpatialUnitIdAndId");
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
| **indicatorId** | **String**| unique identifier of the selected public indicator dataset | |
| **spatialUnitId** | **String**| the unique identifier of the public spatial level | |
| **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong] |

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

> byte[] getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicApi apiInstance = new IndicatorsPublicApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected public indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the public spatial level
        BigDecimal year = new BigDecimal(78); // BigDecimal | year for which the indicator shall be queried
        BigDecimal month = new BigDecimal(78); // BigDecimal | month for which the indicator shall be queried
        BigDecimal day = new BigDecimal(78); // BigDecimal | day for which datasets shall be queried
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicApi#getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
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
| **indicatorId** | **String**| unique identifier of the selected public indicator dataset | |
| **spatialUnitId** | **String**| the unique identifier of the public spatial level | |
| **year** | **BigDecimal**| year for which the indicator shall be queried | |
| **month** | **BigDecimal**| month for which the indicator shall be queried | |
| **day** | **BigDecimal**| day for which datasets shall be queried | |
| **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong] |

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

> List&lt;IndicatorPropertiesWithoutGeomType&gt; getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(indicatorId, spatialUnitId, year, month, day)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicApi apiInstance = new IndicatorsPublicApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        BigDecimal year = new BigDecimal(78); // BigDecimal | year for which the indicator shall be queried
        BigDecimal month = new BigDecimal(78); // BigDecimal | month for which the indicator shall be queried
        BigDecimal day = new BigDecimal(78); // BigDecimal | day for which datasets shall be queried
        try {
            List<IndicatorPropertiesWithoutGeomType> result = apiInstance.getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(indicatorId, spatialUnitId, year, month, day);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicApi#getPublicIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
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
| **indicatorId** | **String**| unique identifier of the selected indicator dataset | |
| **spatialUnitId** | **String**| the unique identifier of the spatial level | |
| **year** | **BigDecimal**| year for which the indicator shall be queried | |
| **month** | **BigDecimal**| month for which the indicator shall be queried | |
| **day** | **BigDecimal**| day for which datasets shall be queried | |

### Return type

[**List&lt;IndicatorPropertiesWithoutGeomType&gt;**](IndicatorPropertiesWithoutGeomType.md)

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

> List&lt;IndicatorPropertiesWithoutGeomType&gt; getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry(indicatorId, spatialUnitId)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicApi apiInstance = new IndicatorsPublicApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected public indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the public spatial level
        try {
            List<IndicatorPropertiesWithoutGeomType> result = apiInstance.getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry(indicatorId, spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicApi#getPublicIndicatorBySpatialUnitIdAndIdWithoutGeometry");
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
| **indicatorId** | **String**| unique identifier of the selected public indicator dataset | |
| **spatialUnitId** | **String**| the unique identifier of the public spatial level | |

### Return type

[**List&lt;IndicatorPropertiesWithoutGeomType&gt;**](IndicatorPropertiesWithoutGeomType.md)

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


## getPublicIndicators

> List&lt;IndicatorOverviewType&gt; getPublicIndicators()

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicApi apiInstance = new IndicatorsPublicApi(defaultClient);
        try {
            List<IndicatorOverviewType> result = apiInstance.getPublicIndicators();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicApi#getPublicIndicators");
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

[**List&lt;IndicatorOverviewType&gt;**](IndicatorOverviewType.md)

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


## getPublicSingleIndicatorFeatureById

> List&lt;IndicatorPropertiesWithoutGeomType&gt; getPublicSingleIndicatorFeatureById(indicatorId, spatialUnitId, featureId)

retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity)

retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity)

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicApi apiInstance = new IndicatorsPublicApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        String featureId = "featureId_example"; // String | the identifier of the indicator dataset spatial feature
        try {
            List<IndicatorPropertiesWithoutGeomType> result = apiInstance.getPublicSingleIndicatorFeatureById(indicatorId, spatialUnitId, featureId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicApi#getPublicSingleIndicatorFeatureById");
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
| **indicatorId** | **String**| unique identifier of the selected indicator dataset | |
| **spatialUnitId** | **String**| the unique identifier of the spatial level | |
| **featureId** | **String**| the identifier of the indicator dataset spatial feature | |

### Return type

[**List&lt;IndicatorPropertiesWithoutGeomType&gt;**](IndicatorPropertiesWithoutGeomType.md)

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


## getPublicSingleIndicatorFeatureRecordById

> List&lt;IndicatorPropertiesWithoutGeomType&gt; getPublicSingleIndicatorFeatureRecordById(indicatorId, spatialUnitId, featureId, featureRecordId)

retrieve single feature database record specified by its unique database primary key id

retrieve single feature database record specified by its unique database primary key id

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsPublicApi apiInstance = new IndicatorsPublicApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        String featureId = "featureId_example"; // String | the identifier of the indicator dataset spatial feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        try {
            List<IndicatorPropertiesWithoutGeomType> result = apiInstance.getPublicSingleIndicatorFeatureRecordById(indicatorId, spatialUnitId, featureId, featureRecordId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsPublicApi#getPublicSingleIndicatorFeatureRecordById");
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
| **indicatorId** | **String**| unique identifier of the selected indicator dataset | |
| **spatialUnitId** | **String**| the unique identifier of the spatial level | |
| **featureId** | **String**| the identifier of the indicator dataset spatial feature | |
| **featureRecordId** | **String**| the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity | |

### Return type

[**List&lt;IndicatorPropertiesWithoutGeomType&gt;**](IndicatorPropertiesWithoutGeomType.md)

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


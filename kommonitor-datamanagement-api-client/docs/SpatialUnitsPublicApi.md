# SpatialUnitsPublicApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllPublicSpatialUnitFeaturesById**](SpatialUnitsPublicApi.md#getAllPublicSpatialUnitFeaturesById) | **GET** /public/spatial-units/{spatialUnitId}/allFeatures | retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity) |
| [**getPublicSingleSpatialUnitFeatureById**](SpatialUnitsPublicApi.md#getPublicSingleSpatialUnitFeatureById) | **GET** /public/spatial-units/{spatialUnitId}/singleFeature/{featureId} | retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity) |
| [**getPublicSingleSpatialUnitFeatureRecordById**](SpatialUnitsPublicApi.md#getPublicSingleSpatialUnitFeatureRecordById) | **GET** /public/spatial-units/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | retrieve single feature database record specified by its unique database primary key id |
| [**getPublicSpatialUnits**](SpatialUnitsPublicApi.md#getPublicSpatialUnits) | **GET** /public/spatial-units | retrieve information about available features of different spatial units/levels |
| [**getPublicSpatialUnitsById**](SpatialUnitsPublicApi.md#getPublicSpatialUnitsById) | **GET** /public/spatial-units/{spatialUnitId} | retrieve information about available features of the selected spatial unit/level |
| [**getPublicSpatialUnitsByIdAndYearAndMonth**](SpatialUnitsPublicApi.md#getPublicSpatialUnitsByIdAndYearAndMonth) | **GET** /public/spatial-units/{spatialUnitId}/{year}/{month}/{day} | retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON |
| [**getPublicSpatialUnitsSchemaById**](SpatialUnitsPublicApi.md#getPublicSpatialUnitsSchemaById) | **GET** /public/spatial-units/{spatialUnitId}/schema | retrieve the JSON schema for the selected spatial unit/level |



## getAllPublicSpatialUnitFeaturesById

> byte[] getAllPublicSpatialUnitFeaturesById(spatialUnitId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicApi apiInstance = new SpatialUnitsPublicApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getAllPublicSpatialUnitFeaturesById(spatialUnitId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicApi#getAllPublicSpatialUnitFeaturesById");
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
| **spatialUnitId** | **String**| the unique identifier of the spatial level | |
| **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong] |

### Return type

**byte[]**

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


## getPublicSingleSpatialUnitFeatureById

> byte[] getPublicSingleSpatialUnitFeatureById(featureId, spatialUnitId, simplifyGeometries)

retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity)

retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity)

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicApi apiInstance = new SpatialUnitsPublicApi(defaultClient);
        String featureId = "featureId_example"; // String | the identifier of the spatial-unit dataset feature
        String spatialUnitId = "spatialUnitId_example"; // String | the identifier of the spatial-unit dataset
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getPublicSingleSpatialUnitFeatureById(featureId, spatialUnitId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicApi#getPublicSingleSpatialUnitFeatureById");
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
| **featureId** | **String**| the identifier of the spatial-unit dataset feature | |
| **spatialUnitId** | **String**| the identifier of the spatial-unit dataset | |
| **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong] |

### Return type

**byte[]**

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


## getPublicSingleSpatialUnitFeatureRecordById

> byte[] getPublicSingleSpatialUnitFeatureRecordById(featureId, featureRecordId, spatialUnitId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicApi apiInstance = new SpatialUnitsPublicApi(defaultClient);
        String featureId = "featureId_example"; // String | the identifier of the spatial-unit dataset feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        String spatialUnitId = "spatialUnitId_example"; // String | the identifier of the spatial-unit dataset
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getPublicSingleSpatialUnitFeatureRecordById(featureId, featureRecordId, spatialUnitId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicApi#getPublicSingleSpatialUnitFeatureRecordById");
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
| **featureId** | **String**| the identifier of the spatial-unit dataset feature | |
| **featureRecordId** | **String**| the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity | |
| **spatialUnitId** | **String**| the identifier of the spatial-unit dataset | |
| **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong] |

### Return type

**byte[]**

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


## getPublicSpatialUnits

> List&lt;SpatialUnitOverviewType&gt; getPublicSpatialUnits()

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicApi apiInstance = new SpatialUnitsPublicApi(defaultClient);
        try {
            List<SpatialUnitOverviewType> result = apiInstance.getPublicSpatialUnits();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicApi#getPublicSpatialUnits");
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

[**List&lt;SpatialUnitOverviewType&gt;**](SpatialUnitOverviewType.md)

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


## getPublicSpatialUnitsById

> SpatialUnitOverviewType getPublicSpatialUnitsById(spatialUnitId)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicApi apiInstance = new SpatialUnitsPublicApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        try {
            SpatialUnitOverviewType result = apiInstance.getPublicSpatialUnitsById(spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicApi#getPublicSpatialUnitsById");
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
| **spatialUnitId** | **String**| the unique identifier of the spatial level | |

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


## getPublicSpatialUnitsByIdAndYearAndMonth

> byte[] getPublicSpatialUnitsByIdAndYearAndMonth(spatialUnitId, year, month, day, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicApi apiInstance = new SpatialUnitsPublicApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        BigDecimal year = new BigDecimal(78); // BigDecimal | year for which datasets shall be queried
        BigDecimal month = new BigDecimal(78); // BigDecimal | month for which datasets shall be queried
        BigDecimal day = new BigDecimal(78); // BigDecimal | day for which datasets shall be queried
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getPublicSpatialUnitsByIdAndYearAndMonth(spatialUnitId, year, month, day, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicApi#getPublicSpatialUnitsByIdAndYearAndMonth");
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
| **spatialUnitId** | **String**| the unique identifier of the spatial level | |
| **year** | **BigDecimal**| year for which datasets shall be queried | |
| **month** | **BigDecimal**| month for which datasets shall be queried | |
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


## getPublicSpatialUnitsSchemaById

> String getPublicSpatialUnitsSchemaById(spatialUnitId)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsPublicApi apiInstance = new SpatialUnitsPublicApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        try {
            String result = apiInstance.getPublicSpatialUnitsSchemaById(spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsPublicApi#getPublicSpatialUnitsSchemaById");
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
| **spatialUnitId** | **String**| the unique identifier of the spatial level | |

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


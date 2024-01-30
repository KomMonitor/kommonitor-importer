# GeoresourcesPublicApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllPublicGeoresourceFeaturesById**](GeoresourcesPublicApi.md#getAllPublicGeoresourceFeaturesById) | **GET** /public/georesources/{georesourceId}/allFeatures | retrieve all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity) |
| [**getAllPublicGeoresourceFeaturesByIdWithoutGeometry**](GeoresourcesPublicApi.md#getAllPublicGeoresourceFeaturesByIdWithoutGeometry) | **GET** /public/georesources/{georesourceId}/allFeatures/without-geometry | retrieve only the properties without geometry of all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity) |
| [**getPublicGeoresourceById**](GeoresourcesPublicApi.md#getPublicGeoresourceById) | **GET** /public/georesources/{georesourceId} | retrieve information about available features of the selected public geo-resource dataset |
| [**getPublicGeoresourceByIdAndYearAndMonth**](GeoresourcesPublicApi.md#getPublicGeoresourceByIdAndYearAndMonth) | **GET** /public/georesources/{georesourceId}/{year}/{month}/{day} | retrieve the features according to the selected public geo-resource dataset and selected year and month as GeoJSON |
| [**getPublicGeoresourceByIdAndYearAndMonthWithoutGeometry**](GeoresourcesPublicApi.md#getPublicGeoresourceByIdAndYearAndMonthWithoutGeometry) | **GET** /public/georesources/{georesourceId}/{year}/{month}/{day}/without-geometry | retrieve only the properties without geometry of the features according to the selected public geo-resource dataset and selected year and month as GeoJSON |
| [**getPublicGeoresourceSchemaByLevel**](GeoresourcesPublicApi.md#getPublicGeoresourceSchemaByLevel) | **GET** /public/georesources/{georesourceId}/schema | retrieve the JSON schema for the selected public geo-resource dataset |
| [**getPublicGeoresources**](GeoresourcesPublicApi.md#getPublicGeoresources) | **GET** /public/georesources | retrieve information about available features of different public geo-resource datasets |
| [**getPublicSingleGeoresourceFeatureById**](GeoresourcesPublicApi.md#getPublicSingleGeoresourceFeatureById) | **GET** /public/georesources/{georesourceId}/singleFeature/{featureId} | retrieve single feature database records for all applicable periods of validity for the selected geo-resource dataset (hence might contain the target feature multiple times if it exists for different periods of validity) |
| [**getPublicSingleGeoresourceFeatureRecordById**](GeoresourcesPublicApi.md#getPublicSingleGeoresourceFeatureRecordById) | **GET** /public/georesources/{georesourceId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | retrieve single feature database record specified by its unique database primary key id |



## getAllPublicGeoresourceFeaturesById

> byte[] getAllPublicGeoresourceFeaturesById(georesourceId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesPublicApi apiInstance = new GeoresourcesPublicApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the public geo-resource dataset
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.\"
        try {
            byte[] result = apiInstance.getAllPublicGeoresourceFeaturesById(georesourceId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesPublicApi#getAllPublicGeoresourceFeaturesById");
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
| **georesourceId** | **String**| the identifier of the public geo-resource dataset | |
| **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; | [optional] [default to original] [enum: original, weak, medium, strong] |

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


## getAllPublicGeoresourceFeaturesByIdWithoutGeometry

> byte[] getAllPublicGeoresourceFeaturesByIdWithoutGeometry(georesourceId)

retrieve only the properties without geometry of all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)

retrieve only the properties without geometry of all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesPublicApi apiInstance = new GeoresourcesPublicApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        try {
            byte[] result = apiInstance.getAllPublicGeoresourceFeaturesByIdWithoutGeometry(georesourceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesPublicApi#getAllPublicGeoresourceFeaturesByIdWithoutGeometry");
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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesPublicApi apiInstance = new GeoresourcesPublicApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | identifier of the public geo-resource dataset
        try {
            GeoresourceOverviewType result = apiInstance.getPublicGeoresourceById(georesourceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesPublicApi#getPublicGeoresourceById");
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
| **georesourceId** | **String**| identifier of the public geo-resource dataset | |

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

> byte[] getPublicGeoresourceByIdAndYearAndMonth(georesourceId, year, month, day, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesPublicApi apiInstance = new GeoresourcesPublicApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | identifier of the public geo-resource dataset
        BigDecimal year = new BigDecimal(78); // BigDecimal | year for which datasets shall be queried
        BigDecimal month = new BigDecimal(78); // BigDecimal | month for which datasets shall be queried
        BigDecimal day = new BigDecimal(78); // BigDecimal | day for which datasets shall be queried
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getPublicGeoresourceByIdAndYearAndMonth(georesourceId, year, month, day, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesPublicApi#getPublicGeoresourceByIdAndYearAndMonth");
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
| **georesourceId** | **String**| identifier of the public geo-resource dataset | |
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


## getPublicGeoresourceByIdAndYearAndMonthWithoutGeometry

> byte[] getPublicGeoresourceByIdAndYearAndMonthWithoutGeometry(georesourceId, year, month, day)

retrieve only the properties without geometry of the features according to the selected public geo-resource dataset and selected year and month as GeoJSON

retrieve only the properties without geometry of the features according to the selected public geo-resource dataset and selected year and month as GeoJSON

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesPublicApi apiInstance = new GeoresourcesPublicApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        BigDecimal year = new BigDecimal(78); // BigDecimal | year
        BigDecimal month = new BigDecimal(78); // BigDecimal | month
        BigDecimal day = new BigDecimal(78); // BigDecimal | day
        try {
            byte[] result = apiInstance.getPublicGeoresourceByIdAndYearAndMonthWithoutGeometry(georesourceId, year, month, day);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesPublicApi#getPublicGeoresourceByIdAndYearAndMonthWithoutGeometry");
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
| **year** | **BigDecimal**| year | |
| **month** | **BigDecimal**| month | |
| **day** | **BigDecimal**| day | |

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesPublicApi apiInstance = new GeoresourcesPublicApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the public geo-resource dataset
        try {
            String result = apiInstance.getPublicGeoresourceSchemaByLevel(georesourceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesPublicApi#getPublicGeoresourceSchemaByLevel");
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
| **georesourceId** | **String**| the identifier of the public geo-resource dataset | |

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

> List&lt;GeoresourceOverviewType&gt; getPublicGeoresources()

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesPublicApi apiInstance = new GeoresourcesPublicApi(defaultClient);
        try {
            List<GeoresourceOverviewType> result = apiInstance.getPublicGeoresources();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesPublicApi#getPublicGeoresources");
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

[**List&lt;GeoresourceOverviewType&gt;**](GeoresourceOverviewType.md)

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


## getPublicSingleGeoresourceFeatureById

> byte[] getPublicSingleGeoresourceFeatureById(georesourceId, featureId, simplifyGeometries)

retrieve single feature database records for all applicable periods of validity for the selected geo-resource dataset (hence might contain the target feature multiple times if it exists for different periods of validity)

retrieve single feature database records for all applicable periods of validity for the selected geo-resource dataset (hence might contain the target feature multiple times if it exists for different periods of validity)

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesPublicApi apiInstance = new GeoresourcesPublicApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
        String featureId = "featureId_example"; // String | the identifier of the geo-resource dataset feature
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getPublicSingleGeoresourceFeatureById(georesourceId, featureId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesPublicApi#getPublicSingleGeoresourceFeatureById");
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
| **georesourceId** | **String**| the identifier of the geo-resource dataset | |
| **featureId** | **String**| the identifier of the geo-resource dataset feature | |
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


## getPublicSingleGeoresourceFeatureRecordById

> byte[] getPublicSingleGeoresourceFeatureRecordById(georesourceId, featureId, featureRecordId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesPublicApi apiInstance = new GeoresourcesPublicApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
        String featureId = "featureId_example"; // String | the identifier of the geo-resource dataset feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the geo-resource dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getPublicSingleGeoresourceFeatureRecordById(georesourceId, featureId, featureRecordId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesPublicApi#getPublicSingleGeoresourceFeatureRecordById");
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
| **georesourceId** | **String**| the identifier of the geo-resource dataset | |
| **featureId** | **String**| the identifier of the geo-resource dataset feature | |
| **featureRecordId** | **String**| the unique database record identifier of the geo-resource dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity | |
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


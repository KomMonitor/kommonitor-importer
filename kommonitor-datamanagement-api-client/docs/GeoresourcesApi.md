# GeoresourcesApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addGeoresourceAsBody**](GeoresourcesApi.md#addGeoresourceAsBody) | **POST** /georesources | Add a new geo-resource |
| [**deleteAllGeoresourceFeaturesById**](GeoresourcesApi.md#deleteAllGeoresourceFeaturesById) | **DELETE** /georesources/{georesourceId}/allFeatures | Delete all features/contents of the selected geo-resource dataset |
| [**deleteGeoresourceById**](GeoresourcesApi.md#deleteGeoresourceById) | **DELETE** /georesources/{georesourceId} | Delete the features/contents of the selected geo-resource dataset |
| [**deleteGeoresourceByIdAndYearAndMonth**](GeoresourcesApi.md#deleteGeoresourceByIdAndYearAndMonth) | **DELETE** /georesources/{georesourceId}/{year}/{month}/{day} | Delete the features/contents of the selected geo-resource dataset, selected by year and month |
| [**deleteSingleGeoresourceFeatureById**](GeoresourcesApi.md#deleteSingleGeoresourceFeatureById) | **DELETE** /georesources/{georesourceId}/singleFeature/{featureId} | Delete all database records for the specified feature of the selected geo-resource dataset |
| [**deleteSingleGeoresourceFeatureRecordById**](GeoresourcesApi.md#deleteSingleGeoresourceFeatureRecordById) | **DELETE** /georesources/{georesourceId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | Delete single feature database record specified by its unique database primary key id for the specified feature of the selected geo-resource dataset |
| [**filterGeoresources**](GeoresourcesApi.md#filterGeoresources) | **POST** /georesources/filter | Filter georesources |
| [**getAllGeoresourceFeaturesById**](GeoresourcesApi.md#getAllGeoresourceFeaturesById) | **GET** /georesources/{georesourceId}/allFeatures | retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity) |
| [**getAllGeoresourceFeaturesByIdWithoutGeometry**](GeoresourcesApi.md#getAllGeoresourceFeaturesByIdWithoutGeometry) | **GET** /georesources/{georesourceId}/allFeatures/without-geometry | retrieve only the properties without geometry of all feature entries for all applicable periods of validity for the selected public geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity) |
| [**getGeoresourceById**](GeoresourcesApi.md#getGeoresourceById) | **GET** /georesources/{georesourceId} | retrieve information about available features of the selected geo-resource dataset |
| [**getGeoresourceByIdAndYearAndMonth**](GeoresourcesApi.md#getGeoresourceByIdAndYearAndMonth) | **GET** /georesources/{georesourceId}/{year}/{month}/{day} | retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON |
| [**getGeoresourceByIdAndYearAndMonthWithoutGeometry**](GeoresourcesApi.md#getGeoresourceByIdAndYearAndMonthWithoutGeometry) | **GET** /georesources/{georesourceId}/{year}/{month}/{day}/without-geometry | retrieve only the properties without geometry of the features according to the selected public geo-resource dataset and selected year and month as GeoJSON |
| [**getGeoresourcePermissionsById**](GeoresourcesApi.md#getGeoresourcePermissionsById) | **GET** /georesources/{georesourceId}/permissions | retrieve information about the permissions for the selected geo-resource |
| [**getGeoresourceSchemaByLevel**](GeoresourcesApi.md#getGeoresourceSchemaByLevel) | **GET** /georesources/{georesourceId}/schema | retrieve the JSON schema for the selected geo-resource dataset |
| [**getGeoresources**](GeoresourcesApi.md#getGeoresources) | **GET** /georesources | retrieve information about available features of different geo-resource datasets |
| [**getSingleGeoresourceFeatureById**](GeoresourcesApi.md#getSingleGeoresourceFeatureById) | **GET** /georesources/{georesourceId}/singleFeature/{featureId} | retrieve single feature database records for all applicable periods of validity for the selected geo-resource dataset (hence might contain the target feature multiple times if it exists for different periods of validity) |
| [**getSingleGeoresourceFeatureRecordById**](GeoresourcesApi.md#getSingleGeoresourceFeatureRecordById) | **GET** /georesources/{georesourceId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | retrieve single feature database record specified by its unique database primary key id |
| [**updateGeoresourceAsBody**](GeoresourcesApi.md#updateGeoresourceAsBody) | **PUT** /georesources/{georesourceId} | Modify/Update the features of the selected geo-resource dataset |
| [**updateGeoresourceFeatureRecordAsBody**](GeoresourcesApi.md#updateGeoresourceFeatureRecordAsBody) | **PUT** /georesources/{georesourceId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | Modify/Update the feature record of the selected georesource dataset feature |
| [**updateGeoresourceMetadataAsBody**](GeoresourcesApi.md#updateGeoresourceMetadataAsBody) | **PATCH** /georesources/{georesourceId} | Modify/Update the metadata of the selected geo-resource dataset |
| [**updateGeoresourceOwnership**](GeoresourcesApi.md#updateGeoresourceOwnership) | **PUT** /georesources/{georesourceId}/ownership | update the ownership for the selected geo-resource dataset |
| [**updateGeoresourcePermissions**](GeoresourcesApi.md#updateGeoresourcePermissions) | **PUT** /georesources/{georesourceId}/permissions | update the permissions for the selected geo-resource dataset |



## addGeoresourceAsBody

> GeoresourceOverviewType addGeoresourceAsBody(georesourcePOSTInputType)

Add a new geo-resource

Add/Register a geo-resource dataset for a certain period of time

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        GeoresourcePOSTInputType georesourcePOSTInputType = new GeoresourcePOSTInputType(); // GeoresourcePOSTInputType | feature data
        try {
            GeoresourceOverviewType result = apiInstance.addGeoresourceAsBody(georesourcePOSTInputType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#addGeoresourceAsBody");
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
| **georesourcePOSTInputType** | [**GeoresourcePOSTInputType**](GeoresourcePOSTInputType.md)| feature data | |

### Return type

[**GeoresourceOverviewType**](GeoresourceOverviewType.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


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

> deleteAllGeoresourceFeaturesById(georesourceId)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
        try {
            apiInstance.deleteAllGeoresourceFeaturesById(georesourceId);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#deleteAllGeoresourceFeaturesById");
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

### Return type

null (empty response body)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |


## deleteGeoresourceById

> deleteGeoresourceById(georesourceId)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
        try {
            apiInstance.deleteGeoresourceById(georesourceId);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#deleteGeoresourceById");
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
| **georesourceId** | **String**| identifier of the geo-resource dataset | |

### Return type

null (empty response body)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |


## deleteGeoresourceByIdAndYearAndMonth

> deleteGeoresourceByIdAndYearAndMonth(georesourceId, year, month, day)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
        BigDecimal year = new BigDecimal(78); // BigDecimal | year for which datasets shall be queried
        BigDecimal month = new BigDecimal(78); // BigDecimal | month for which datasets shall be queried
        BigDecimal day = new BigDecimal(78); // BigDecimal | day for which datasets shall be queried
        try {
            apiInstance.deleteGeoresourceByIdAndYearAndMonth(georesourceId, year, month, day);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#deleteGeoresourceByIdAndYearAndMonth");
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
| **georesourceId** | **String**| identifier of the geo-resource dataset | |
| **year** | **BigDecimal**| year for which datasets shall be queried | |
| **month** | **BigDecimal**| month for which datasets shall be queried | |
| **day** | **BigDecimal**| day for which datasets shall be queried | |

### Return type

null (empty response body)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |


## deleteSingleGeoresourceFeatureById

> deleteSingleGeoresourceFeatureById(georesourceId, featureId)

Delete all database records for the specified feature of the selected geo-resource dataset

Delete all database records for the specified feature of the selected geo-resource dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
        String featureId = "featureId_example"; // String | the identifier of the geo-resource dataset feature
        try {
            apiInstance.deleteSingleGeoresourceFeatureById(georesourceId, featureId);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#deleteSingleGeoresourceFeatureById");
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

### Return type

null (empty response body)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |


## deleteSingleGeoresourceFeatureRecordById

> deleteSingleGeoresourceFeatureRecordById(georesourceId, featureId, featureRecordId)

Delete single feature database record specified by its unique database primary key id for the specified feature of the selected geo-resource dataset

Delete single feature database record specified by its unique database primary key id for the specified feature of the selected geo-resource dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
        String featureId = "featureId_example"; // String | the identifier of the geo-resource dataset feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the geo-resource dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        try {
            apiInstance.deleteSingleGeoresourceFeatureRecordById(georesourceId, featureId, featureRecordId);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#deleteSingleGeoresourceFeatureRecordById");
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

### Return type

null (empty response body)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |


## filterGeoresources

> List&lt;GeoresourceOverviewType&gt; filterGeoresources(resourceFilterType)

Filter georesources

Filter georesource datasets according to the specified filter

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        ResourceFilterType resourceFilterType = new ResourceFilterType(); // ResourceFilterType | filter data
        try {
            List<GeoresourceOverviewType> result = apiInstance.filterGeoresources(resourceFilterType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#filterGeoresources");
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

[**List&lt;GeoresourceOverviewType&gt;**](GeoresourceOverviewType.md)

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


## getAllGeoresourceFeaturesById

> byte[] getAllGeoresourceFeaturesById(georesourceId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.\"
        try {
            byte[] result = apiInstance.getAllGeoresourceFeaturesById(georesourceId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#getAllGeoresourceFeaturesById");
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


## getAllGeoresourceFeaturesByIdWithoutGeometry

> byte[] getAllGeoresourceFeaturesByIdWithoutGeometry(georesourceId)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        try {
            byte[] result = apiInstance.getAllGeoresourceFeaturesByIdWithoutGeometry(georesourceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#getAllGeoresourceFeaturesByIdWithoutGeometry");
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


## getGeoresourceById

> GeoresourceOverviewType getGeoresourceById(georesourceId)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
        try {
            GeoresourceOverviewType result = apiInstance.getGeoresourceById(georesourceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#getGeoresourceById");
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
| **georesourceId** | **String**| identifier of the geo-resource dataset | |

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

> byte[] getGeoresourceByIdAndYearAndMonth(georesourceId, year, month, day, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
        BigDecimal year = new BigDecimal(78); // BigDecimal | year for which datasets shall be queried
        BigDecimal month = new BigDecimal(78); // BigDecimal | month for which datasets shall be queried
        BigDecimal day = new BigDecimal(78); // BigDecimal | day for which datasets shall be queried
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getGeoresourceByIdAndYearAndMonth(georesourceId, year, month, day, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#getGeoresourceByIdAndYearAndMonth");
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
| **georesourceId** | **String**| identifier of the geo-resource dataset | |
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


## getGeoresourceByIdAndYearAndMonthWithoutGeometry

> byte[] getGeoresourceByIdAndYearAndMonthWithoutGeometry(georesourceId, year, month, day)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | georesourceId
        BigDecimal year = new BigDecimal("0"); // BigDecimal | year
        BigDecimal month = new BigDecimal("0"); // BigDecimal | month
        BigDecimal day = new BigDecimal("0"); // BigDecimal | day
        try {
            byte[] result = apiInstance.getGeoresourceByIdAndYearAndMonthWithoutGeometry(georesourceId, year, month, day);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#getGeoresourceByIdAndYearAndMonthWithoutGeometry");
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


## getGeoresourcePermissionsById

> List&lt;PermissionLevelType&gt; getGeoresourcePermissionsById(georesourceId)

retrieve information about the permissions for the selected geo-resource

retrieve information about the permissions for the selected geo-resource

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
        try {
            List<PermissionLevelType> result = apiInstance.getGeoresourcePermissionsById(georesourceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#getGeoresourcePermissionsById");
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
| **georesourceId** | **String**| identifier of the geo-resource dataset | |

### Return type

[**List&lt;PermissionLevelType&gt;**](PermissionLevelType.md)

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


## getGeoresourceSchemaByLevel

> String getGeoresourceSchemaByLevel(georesourceId)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
        try {
            String result = apiInstance.getGeoresourceSchemaByLevel(georesourceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#getGeoresourceSchemaByLevel");
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

> List&lt;GeoresourceOverviewType&gt; getGeoresources()

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        try {
            List<GeoresourceOverviewType> result = apiInstance.getGeoresources();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#getGeoresources");
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


## getSingleGeoresourceFeatureById

> byte[] getSingleGeoresourceFeatureById(georesourceId, featureId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
        String featureId = "featureId_example"; // String | the identifier of the geo-resource dataset feature
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.\"
        try {
            byte[] result = apiInstance.getSingleGeoresourceFeatureById(georesourceId, featureId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#getSingleGeoresourceFeatureById");
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


## getSingleGeoresourceFeatureRecordById

> byte[] getSingleGeoresourceFeatureRecordById(georesourceId, featureId, featureRecordId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
        String featureId = "featureId_example"; // String | the identifier of the geo-resource dataset feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the geo-resource dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.\"
        try {
            byte[] result = apiInstance.getSingleGeoresourceFeatureRecordById(georesourceId, featureId, featureRecordId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#getSingleGeoresourceFeatureRecordById");
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


## updateGeoresourceAsBody

> updateGeoresourceAsBody(georesourceId, featureData)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
        GeoresourcePUTInputType featureData = new GeoresourcePUTInputType(); // GeoresourcePUTInputType | feature data
        try {
            apiInstance.updateGeoresourceAsBody(georesourceId, featureData);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#updateGeoresourceAsBody");
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
| **georesourceId** | **String**| identifier of the geo-resource dataset | |
| **featureData** | [**GeoresourcePUTInputType**](GeoresourcePUTInputType.md)| feature data | |

### Return type

null (empty response body)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | Created |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


## updateGeoresourceFeatureRecordAsBody

> updateGeoresourceFeatureRecordAsBody(georesourceId, featureId, featureRecordId, georesourceFeatureRecordData)

Modify/Update the feature record of the selected georesource dataset feature

Modify/Update the feature record of the selected georesource dataset feature

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
        String featureId = "featureId_example"; // String | the identifier of the geo-resource dataset feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the geo-resource dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        String georesourceFeatureRecordData = "georesourceFeatureRecordData_example"; // String | georesource feature record data
        try {
            apiInstance.updateGeoresourceFeatureRecordAsBody(georesourceId, featureId, featureRecordId, georesourceFeatureRecordData);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#updateGeoresourceFeatureRecordAsBody");
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
| **georesourceFeatureRecordData** | **String**| georesource feature record data | |

### Return type

null (empty response body)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK - Updated |  -  |
| **201** | Created |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


## updateGeoresourceMetadataAsBody

> updateGeoresourceMetadataAsBody(georesourceId, metadata)

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
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
        GeoresourcePATCHInputType metadata = new GeoresourcePATCHInputType(); // GeoresourcePATCHInputType | metadata input
        try {
            apiInstance.updateGeoresourceMetadataAsBody(georesourceId, metadata);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#updateGeoresourceMetadataAsBody");
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
| **georesourceId** | **String**| identifier of the geo-resource dataset | |
| **metadata** | [**GeoresourcePATCHInputType**](GeoresourcePATCHInputType.md)| metadata input | |

### Return type

null (empty response body)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **405** | Invalid input |  -  |


## updateGeoresourceOwnership

> updateGeoresourceOwnership(georesourceId, ownerInputType)

update the ownership for the selected geo-resource dataset

update the ownership for the selected geo-resource dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
        OwnerInputType ownerInputType = new OwnerInputType(); // OwnerInputType | GeoResource ownership input
        try {
            apiInstance.updateGeoresourceOwnership(georesourceId, ownerInputType);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#updateGeoresourceOwnership");
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
| **georesourceId** | **String**| identifier of the geo-resource dataset | |
| **ownerInputType** | [**OwnerInputType**](OwnerInputType.md)| GeoResource ownership input | [optional] |

### Return type

null (empty response body)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Invalid status value |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## updateGeoresourcePermissions

> updateGeoresourcePermissions(georesourceId, permissionLevelInputType)

update the permissions for the selected geo-resource dataset

update the permissions for the selected geo-resource dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        GeoresourcesApi apiInstance = new GeoresourcesApi(defaultClient);
        String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
        PermissionLevelInputType permissionLevelInputType = new PermissionLevelInputType(); // PermissionLevelInputType | GeoResource permission level input
        try {
            apiInstance.updateGeoresourcePermissions(georesourceId, permissionLevelInputType);
        } catch (ApiException e) {
            System.err.println("Exception when calling GeoresourcesApi#updateGeoresourcePermissions");
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
| **georesourceId** | **String**| identifier of the geo-resource dataset | |
| **permissionLevelInputType** | [**PermissionLevelInputType**](PermissionLevelInputType.md)| GeoResource permission level input | [optional] |

### Return type

null (empty response body)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Invalid status value |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


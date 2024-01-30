# SpatialUnitsApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addSpatialUnitAsBody**](SpatialUnitsApi.md#addSpatialUnitAsBody) | **POST** /spatial-units | Add a new spatial-unit |
| [**deleteAllSpatialUnitFeaturesById**](SpatialUnitsApi.md#deleteAllSpatialUnitFeaturesById) | **DELETE** /spatial-units/{spatialUnitId}/allFeatures | Delete all features/contents of the selected spatial-unit dataset |
| [**deleteSingleSpatialUnitFeatureById**](SpatialUnitsApi.md#deleteSingleSpatialUnitFeatureById) | **DELETE** /spatial-units/{spatialUnitId}/singleFeature/{featureId} | Delete all database records for the specified feature of the selected spatial-unit dataset |
| [**deleteSingleSpatialUnitFeatureRecordById**](SpatialUnitsApi.md#deleteSingleSpatialUnitFeatureRecordById) | **DELETE** /spatial-units/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | Delete single feature database record specified by its unique database primary key id for the specified feature of the selected spatial-unit dataset |
| [**deleteSpatialUnitById**](SpatialUnitsApi.md#deleteSpatialUnitById) | **DELETE** /spatial-units/{spatialUnitId} | Delete the features/contents of the selected spatial-unit |
| [**deleteSpatialUnitByIdAndYearAndMonth**](SpatialUnitsApi.md#deleteSpatialUnitByIdAndYearAndMonth) | **DELETE** /spatial-units/{spatialUnitId}/{year}/{month}/{day} | Delete the features/contents of the selected spatial-unit, year and month |
| [**getAllSpatialUnitFeaturesById**](SpatialUnitsApi.md#getAllSpatialUnitFeaturesById) | **GET** /spatial-units/{spatialUnitId}/allFeatures | retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity) |
| [**getSingleSpatialUnitFeatureById**](SpatialUnitsApi.md#getSingleSpatialUnitFeatureById) | **GET** /spatial-units/{spatialUnitId}/singleFeature/{featureId} | retrieve single feature database records for all applicable periods of validity for the selected spatial-unit dataset (hence might contain the target feature multiple times if it exists for different periods of validity) |
| [**getSingleSpatialUnitFeatureRecordById**](SpatialUnitsApi.md#getSingleSpatialUnitFeatureRecordById) | **GET** /spatial-units/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | retrieve single feature database record specified by its unique database primary key id |
| [**getSpatialUnits**](SpatialUnitsApi.md#getSpatialUnits) | **GET** /spatial-units | retrieve information about available features of different spatial units/levels |
| [**getSpatialUnitsById**](SpatialUnitsApi.md#getSpatialUnitsById) | **GET** /spatial-units/{spatialUnitId} | retrieve information about available features of the selected spatial unit/level |
| [**getSpatialUnitsByIdAndYearAndMonth**](SpatialUnitsApi.md#getSpatialUnitsByIdAndYearAndMonth) | **GET** /spatial-units/{spatialUnitId}/{year}/{month}/{day} | retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON |
| [**getSpatialUnitsPermissionsById**](SpatialUnitsApi.md#getSpatialUnitsPermissionsById) | **GET** /spatial-units/{spatialUnitId}/permissions | retrieve information about the permissions for the selected spatial unit dataset |
| [**getSpatialUnitsSchemaById**](SpatialUnitsApi.md#getSpatialUnitsSchemaById) | **GET** /spatial-units/{spatialUnitId}/schema | retrieve the JSON schema for the selected spatial unit/level |
| [**updateSpatialUnitAsBody**](SpatialUnitsApi.md#updateSpatialUnitAsBody) | **PUT** /spatial-units/{spatialUnitId} | Modify/Update the features of the selected spatial-unit |
| [**updateSpatialUnitFeatureRecordAsBody**](SpatialUnitsApi.md#updateSpatialUnitFeatureRecordAsBody) | **PUT** /spatial-units/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | Modify/Update the feature record of the selected spatial-unit dataset feature |
| [**updateSpatialUnitMetadataAsBody**](SpatialUnitsApi.md#updateSpatialUnitMetadataAsBody) | **PATCH** /spatial-units/{spatialUnitId} | Modify/Update the metadata of the selected spatial-unit |



## addSpatialUnitAsBody

> SpatialUnitOverviewType addSpatialUnitAsBody(featureData)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        SpatialUnitPOSTInputType featureData = new SpatialUnitPOSTInputType(); // SpatialUnitPOSTInputType | feature data
        try {
            SpatialUnitOverviewType result = apiInstance.addSpatialUnitAsBody(featureData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#addSpatialUnitAsBody");
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
| **featureData** | [**SpatialUnitPOSTInputType**](SpatialUnitPOSTInputType.md)| feature data | |

### Return type

[**SpatialUnitOverviewType**](SpatialUnitOverviewType.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

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


## deleteAllSpatialUnitFeaturesById

> deleteAllSpatialUnitFeaturesById(spatialUnitId)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        try {
            apiInstance.deleteAllSpatialUnitFeaturesById(spatialUnitId);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#deleteAllSpatialUnitFeaturesById");
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


## deleteSingleSpatialUnitFeatureById

> deleteSingleSpatialUnitFeatureById(spatialUnitId, featureId)

Delete all database records for the specified feature of the selected spatial-unit dataset

Delete all database records for the specified feature of the selected spatial-unit dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the identifier of the spatial-unit dataset
        String featureId = "featureId_example"; // String | the identifier of the spatial-unit dataset feature
        try {
            apiInstance.deleteSingleSpatialUnitFeatureById(spatialUnitId, featureId);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#deleteSingleSpatialUnitFeatureById");
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
| **spatialUnitId** | **String**| the identifier of the spatial-unit dataset | |
| **featureId** | **String**| the identifier of the spatial-unit dataset feature | |

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


## deleteSingleSpatialUnitFeatureRecordById

> deleteSingleSpatialUnitFeatureRecordById(spatialUnitId, featureId, featureRecordId)

Delete single feature database record specified by its unique database primary key id for the specified feature of the selected spatial-unit dataset

Delete single feature database record specified by its unique database primary key id for the specified feature of the selected spatial-unit dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the identifier of the spatial-unit dataset
        String featureId = "featureId_example"; // String | the identifier of the spatial-unit dataset feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        try {
            apiInstance.deleteSingleSpatialUnitFeatureRecordById(spatialUnitId, featureId, featureRecordId);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#deleteSingleSpatialUnitFeatureRecordById");
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
| **spatialUnitId** | **String**| the identifier of the spatial-unit dataset | |
| **featureId** | **String**| the identifier of the spatial-unit dataset feature | |
| **featureRecordId** | **String**| the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity | |

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


## deleteSpatialUnitById

> deleteSpatialUnitById(spatialUnitId)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        try {
            apiInstance.deleteSpatialUnitById(spatialUnitId);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#deleteSpatialUnitById");
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


## deleteSpatialUnitByIdAndYearAndMonth

> deleteSpatialUnitByIdAndYearAndMonth(spatialUnitId, year, month, day)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        BigDecimal year = new BigDecimal(78); // BigDecimal | year for which datasets shall be queried
        BigDecimal month = new BigDecimal(78); // BigDecimal | month for which datasets shall be queried
        BigDecimal day = new BigDecimal(78); // BigDecimal | day for which datasets shall be queried
        try {
            apiInstance.deleteSpatialUnitByIdAndYearAndMonth(spatialUnitId, year, month, day);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#deleteSpatialUnitByIdAndYearAndMonth");
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


## getAllSpatialUnitFeaturesById

> byte[] getAllSpatialUnitFeaturesById(spatialUnitId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        String simplifyGeometries = "original"; // String | ontrols simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getAllSpatialUnitFeaturesById(spatialUnitId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#getAllSpatialUnitFeaturesById");
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
| **simplifyGeometries** | **String**| ontrols simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong] |

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


## getSingleSpatialUnitFeatureById

> byte[] getSingleSpatialUnitFeatureById(spatialUnitId, featureId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the identifier of the spatial-unit dataset
        String featureId = "featureId_example"; // String | the identifier of the spatial-unit dataset feature
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getSingleSpatialUnitFeatureById(spatialUnitId, featureId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#getSingleSpatialUnitFeatureById");
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
| **spatialUnitId** | **String**| the identifier of the spatial-unit dataset | |
| **featureId** | **String**| the identifier of the spatial-unit dataset feature | |
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


## getSingleSpatialUnitFeatureRecordById

> byte[] getSingleSpatialUnitFeatureRecordById(spatialUnitId, featureId, featureRecordId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the identifier of the spatial-unit dataset
        String featureId = "featureId_example"; // String | the identifier of the spatial-unit dataset feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getSingleSpatialUnitFeatureRecordById(spatialUnitId, featureId, featureRecordId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#getSingleSpatialUnitFeatureRecordById");
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
| **spatialUnitId** | **String**| the identifier of the spatial-unit dataset | |
| **featureId** | **String**| the identifier of the spatial-unit dataset feature | |
| **featureRecordId** | **String**| the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity | |
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


## getSpatialUnits

> List&lt;SpatialUnitOverviewType&gt; getSpatialUnits()

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        try {
            List<SpatialUnitOverviewType> result = apiInstance.getSpatialUnits();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#getSpatialUnits");
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


## getSpatialUnitsById

> SpatialUnitOverviewType getSpatialUnitsById(spatialUnitId)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        try {
            SpatialUnitOverviewType result = apiInstance.getSpatialUnitsById(spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#getSpatialUnitsById");
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


## getSpatialUnitsByIdAndYearAndMonth

> byte[] getSpatialUnitsByIdAndYearAndMonth(spatialUnitId, year, month, day, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        BigDecimal year = new BigDecimal(78); // BigDecimal | year for which datasets shall be queried
        BigDecimal month = new BigDecimal(78); // BigDecimal | month for which datasets shall be queried
        BigDecimal day = new BigDecimal(78); // BigDecimal | day for which datasets shall be queried
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getSpatialUnitsByIdAndYearAndMonth(spatialUnitId, year, month, day, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#getSpatialUnitsByIdAndYearAndMonth");
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


## getSpatialUnitsPermissionsById

> List&lt;PermissionLevelType&gt; getSpatialUnitsPermissionsById(spatialUnitId)

retrieve information about the permissions for the selected spatial unit dataset

retrieve information about the permissions for the selected spatial unit dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | identifier of the spatial unit dataset
        try {
            List<PermissionLevelType> result = apiInstance.getSpatialUnitsPermissionsById(spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#getSpatialUnitsPermissionsById");
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
| **spatialUnitId** | **String**| identifier of the spatial unit dataset | |

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


## getSpatialUnitsSchemaById

> String getSpatialUnitsSchemaById(spatialUnitId)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        try {
            String result = apiInstance.getSpatialUnitsSchemaById(spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#getSpatialUnitsSchemaById");
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


## updateSpatialUnitAsBody

> updateSpatialUnitAsBody(spatialUnitId, featureData)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        SpatialUnitPUTInputType featureData = new SpatialUnitPUTInputType(); // SpatialUnitPUTInputType | feature data
        try {
            apiInstance.updateSpatialUnitAsBody(spatialUnitId, featureData);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#updateSpatialUnitAsBody");
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
| **featureData** | [**SpatialUnitPUTInputType**](SpatialUnitPUTInputType.md)| feature data | |

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


## updateSpatialUnitFeatureRecordAsBody

> updateSpatialUnitFeatureRecordAsBody(spatialUnitId, featureId, featureRecordId, spatialUnitFeatureRecordData)

Modify/Update the feature record of the selected spatial-unit dataset feature

Modify/Update the feature record of the selected spatial-unit dataset feature

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the identifier of the spatial-unit dataset
        String featureId = "featureId_example"; // String | the identifier of the spatial-unit dataset feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        String spatialUnitFeatureRecordData = "spatialUnitFeatureRecordData_example"; // String | spatial-unit feature record data
        try {
            apiInstance.updateSpatialUnitFeatureRecordAsBody(spatialUnitId, featureId, featureRecordId, spatialUnitFeatureRecordData);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#updateSpatialUnitFeatureRecordAsBody");
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
| **spatialUnitId** | **String**| the identifier of the spatial-unit dataset | |
| **featureId** | **String**| the identifier of the spatial-unit dataset feature | |
| **featureRecordId** | **String**| the unique database record identifier of the spatial-unit dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity | |
| **spatialUnitFeatureRecordData** | **String**| spatial-unit feature record data | |

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


## updateSpatialUnitMetadataAsBody

> updateSpatialUnitMetadataAsBody(spatialUnitId, metadata)

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
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        SpatialUnitsApi apiInstance = new SpatialUnitsApi(defaultClient);
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        SpatialUnitPATCHInputType metadata = new SpatialUnitPATCHInputType(); // SpatialUnitPATCHInputType | metadata input
        try {
            apiInstance.updateSpatialUnitMetadataAsBody(spatialUnitId, metadata);
        } catch (ApiException e) {
            System.err.println("Exception when calling SpatialUnitsApi#updateSpatialUnitMetadataAsBody");
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
| **metadata** | [**SpatialUnitPATCHInputType**](SpatialUnitPATCHInputType.md)| metadata input | |

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


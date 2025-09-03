# IndicatorsApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addIndicatorAsBody**](IndicatorsApi.md#addIndicatorAsBody) | **POST** /indicators | Add a new indicator dataset |
| [**deleteIndicatorById**](IndicatorsApi.md#deleteIndicatorById) | **DELETE** /indicators/{indicatorId} | Delete the features/contents of the selected indicator dataset |
| [**deleteIndicatorByIdAndSpatialUnitId**](IndicatorsApi.md#deleteIndicatorByIdAndSpatialUnitId) | **DELETE** /indicators/{indicatorId}/{spatialUnitId} | Delete the features/contents of the selected indicator dataset for the selected spatial unit |
| [**deleteIndicatorByIdAndYearAndMonth**](IndicatorsApi.md#deleteIndicatorByIdAndYearAndMonth) | **DELETE** /indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day} | Delete the features/contents of the selected indicator dataset, selected by year and month |
| [**deleteSingleIndicatorFeatureById**](IndicatorsApi.md#deleteSingleIndicatorFeatureById) | **DELETE** /indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId} | Delete all database records for the specified feature of the selected indicator dataset |
| [**deleteSingleIndicatorFeatureRecordById**](IndicatorsApi.md#deleteSingleIndicatorFeatureRecordById) | **DELETE** /indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | Delete single feature database record specified by its unique database primary key id for the specified feature of the selected indicator dataset |
| [**filterIndicators**](IndicatorsApi.md#filterIndicators) | **POST** /indicators/filter | Filter indicators |
| [**getIndicatorById**](IndicatorsApi.md#getIndicatorById) | **GET** /indicators/{indicatorId} | retrieve information about the selected indicator |
| [**getIndicatorBySpatialUnitIdAndId**](IndicatorsApi.md#getIndicatorBySpatialUnitIdAndId) | **GET** /indicators/{indicatorId}/{spatialUnitId} | retrieve the indicator for the selected spatial unit as GeoJSON |
| [**getIndicatorBySpatialUnitIdAndIdAndYearAndMonth**](IndicatorsApi.md#getIndicatorBySpatialUnitIdAndIdAndYearAndMonth) | **GET** /indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day} | retrieve the indicator for the selected spatial unit, year and month as GeoJSON |
| [**getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry**](IndicatorsApi.md#getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry) | **GET** /indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}/without-geometry | retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries! |
| [**getIndicatorBySpatialUnitIdAndIdWithoutGeometry**](IndicatorsApi.md#getIndicatorBySpatialUnitIdAndIdWithoutGeometry) | **GET** /indicators/{indicatorId}/{spatialUnitId}/without-geometry | retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries! |
| [**getIndicatorPermissionsById**](IndicatorsApi.md#getIndicatorPermissionsById) | **GET** /indicators/{indicatorId}/permissions | retrieve information about the permissions for the selected indicator dataset |
| [**getIndicatorPermissionsBySpatialUnitIdAndId**](IndicatorsApi.md#getIndicatorPermissionsBySpatialUnitIdAndId) | **GET** /indicators/{indicatorId}/{spatialUnitId}/permissions | retrieve information about the permissions for the selected indicator and spatial unit dataset |
| [**getIndicators**](IndicatorsApi.md#getIndicators) | **GET** /indicators | retrieve information about available indicators |
| [**getSingleIndicatorFeatureById**](IndicatorsApi.md#getSingleIndicatorFeatureById) | **GET** /indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId} | retrieve single feature database records for all applicable periods of validity for the selected indicator dataset (hence might contain the target feature multiple times if it exists for different periods of validity) |
| [**getSingleIndicatorFeatureRecordById**](IndicatorsApi.md#getSingleIndicatorFeatureRecordById) | **GET** /indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | retrieve single feature database record specified by its unique database primary key id test |
| [**updateIndicatorAsBody**](IndicatorsApi.md#updateIndicatorAsBody) | **PUT** /indicators/{indicatorId} | Modify/Update the contents of the selected indicator dataset |
| [**updateIndicatorDisplayOrder**](IndicatorsApi.md#updateIndicatorDisplayOrder) | **PATCH** /indicators/display-order | Update displayOrder for submitted indicators |
| [**updateIndicatorFeatureRecordAsBody**](IndicatorsApi.md#updateIndicatorFeatureRecordAsBody) | **PUT** /indicators/{indicatorId}/{spatialUnitId}/singleFeature/{featureId}/singleFeatureRecord/{featureRecordId} | Modify/Update the feature record of the selected indicator dataset feature |
| [**updateIndicatorMetadataAsBody**](IndicatorsApi.md#updateIndicatorMetadataAsBody) | **PATCH** /indicators/{indicatorId} | Modify/Update the metadata of the selected indicator dataset |
| [**updateIndicatorOwnership**](IndicatorsApi.md#updateIndicatorOwnership) | **PUT** /indicators/{indicatorId}/ownership | Modify/Update the selected indicator dataset ownership |
| [**updateIndicatorOwnershipBySpatialUnit**](IndicatorsApi.md#updateIndicatorOwnershipBySpatialUnit) | **PUT** /indicators/{indicatorId}/{spatialUnitId}/ownership | Modify/Update the selected indicator dataset ownership |
| [**updateIndicatorPermissions**](IndicatorsApi.md#updateIndicatorPermissions) | **PUT** /indicators/{indicatorId}/permissions | Modify/Update the selected indicator dataset permissions |
| [**updateIndicatorPermissionsBySpatialUnit**](IndicatorsApi.md#updateIndicatorPermissionsBySpatialUnit) | **PUT** /indicators/{indicatorId}/{spatialUnitId}/permissions | Modify/Update the selected indicator dataset permissions |



## addIndicatorAsBody

> IndicatorOverviewType addIndicatorAsBody(indicatorData)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        IndicatorPOSTInputType indicatorData = new IndicatorPOSTInputType(); // IndicatorPOSTInputType | indicator data
        try {
            IndicatorOverviewType result = apiInstance.addIndicatorAsBody(indicatorData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#addIndicatorAsBody");
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
| **indicatorData** | [**IndicatorPOSTInputType**](IndicatorPOSTInputType.md)| indicator data | |

### Return type

[**IndicatorOverviewType**](IndicatorOverviewType.md)

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
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


## deleteIndicatorById

> deleteIndicatorById(indicatorId)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        try {
            apiInstance.deleteIndicatorById(indicatorId);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#deleteIndicatorById");
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


## deleteIndicatorByIdAndSpatialUnitId

> deleteIndicatorByIdAndSpatialUnitId(indicatorId, spatialUnitId)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        try {
            apiInstance.deleteIndicatorByIdAndSpatialUnitId(indicatorId, spatialUnitId);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#deleteIndicatorByIdAndSpatialUnitId");
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


## deleteIndicatorByIdAndYearAndMonth

> deleteIndicatorByIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        BigDecimal year = new BigDecimal(78); // BigDecimal | year for which the indicator shall be queried
        BigDecimal month = new BigDecimal(78); // BigDecimal | month for which the indicator shall be queried
        BigDecimal day = new BigDecimal(78); // BigDecimal | day for which datasets shall be queried
        try {
            apiInstance.deleteIndicatorByIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#deleteIndicatorByIdAndYearAndMonth");
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


## deleteSingleIndicatorFeatureById

> deleteSingleIndicatorFeatureById(indicatorId, spatialUnitId, featureId)

Delete all database records for the specified feature of the selected indicator dataset

Delete all database records for the specified feature of the selected indicator dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        String featureId = "featureId_example"; // String | the identifier of the indicator dataset spatial feature
        try {
            apiInstance.deleteSingleIndicatorFeatureById(indicatorId, spatialUnitId, featureId);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#deleteSingleIndicatorFeatureById");
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


## deleteSingleIndicatorFeatureRecordById

> deleteSingleIndicatorFeatureRecordById(indicatorId, spatialUnitId, featureId, featureRecordId)

Delete single feature database record specified by its unique database primary key id for the specified feature of the selected indicator dataset

Delete single feature database record specified by its unique database primary key id for the specified feature of the selected indicator dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        String featureId = "featureId_example"; // String | the identifier of the indicator dataset feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        try {
            apiInstance.deleteSingleIndicatorFeatureRecordById(indicatorId, spatialUnitId, featureId, featureRecordId);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#deleteSingleIndicatorFeatureRecordById");
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
| **featureId** | **String**| the identifier of the indicator dataset feature | |
| **featureRecordId** | **String**| the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity | |

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


## filterIndicators

> List&lt;IndicatorOverviewType&gt; filterIndicators(resourceFilterType)

Filter indicators

Filter indicators datasets according to the specified filter

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        ResourceFilterType resourceFilterType = new ResourceFilterType(); // ResourceFilterType | filter data
        try {
            List<IndicatorOverviewType> result = apiInstance.filterIndicators(resourceFilterType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#filterIndicators");
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


## getIndicatorById

> IndicatorOverviewType getIndicatorById(indicatorId)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        try {
            IndicatorOverviewType result = apiInstance.getIndicatorById(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getIndicatorById");
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

> byte[] getIndicatorBySpatialUnitIdAndId(indicatorId, spatialUnitId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            byte[] result = apiInstance.getIndicatorBySpatialUnitIdAndId(indicatorId, spatialUnitId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getIndicatorBySpatialUnitIdAndId");
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


## getIndicatorBySpatialUnitIdAndIdAndYearAndMonth

> byte[] getIndicatorBySpatialUnitIdAndIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        BigDecimal year = new BigDecimal(78); // BigDecimal | year for which the indicator shall be queried
        BigDecimal month = new BigDecimal(78); // BigDecimal | month for which the indicator shall be queried
        BigDecimal day = new BigDecimal(78); // BigDecimal | day for which datasets shall be queried
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.\"
        try {
            byte[] result = apiInstance.getIndicatorBySpatialUnitIdAndIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
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
| **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification.\&quot; | [optional] [default to original] [enum: original, weak, medium, strong] |

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

> List&lt;IndicatorPropertiesWithoutGeomType&gt; getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(indicatorId, spatialUnitId, year, month, day)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        BigDecimal year = new BigDecimal(78); // BigDecimal | year for which the indicator shall be queried
        BigDecimal month = new BigDecimal(78); // BigDecimal | month for which the indicator shall be queried
        BigDecimal day = new BigDecimal(78); // BigDecimal | day for which datasets shall be queried
        try {
            List<IndicatorPropertiesWithoutGeomType> result = apiInstance.getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(indicatorId, spatialUnitId, year, month, day);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
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


## getIndicatorBySpatialUnitIdAndIdWithoutGeometry

> List&lt;IndicatorPropertiesWithoutGeomType&gt; getIndicatorBySpatialUnitIdAndIdWithoutGeometry(indicatorId, spatialUnitId)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        try {
            List<IndicatorPropertiesWithoutGeomType> result = apiInstance.getIndicatorBySpatialUnitIdAndIdWithoutGeometry(indicatorId, spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getIndicatorBySpatialUnitIdAndIdWithoutGeometry");
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


## getIndicatorPermissionsById

> List&lt;PermissionLevelType&gt; getIndicatorPermissionsById(indicatorId)

retrieve information about the permissions for the selected indicator dataset

retrieve information about the permissions for the selected indicator dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        try {
            List<PermissionLevelType> result = apiInstance.getIndicatorPermissionsById(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getIndicatorPermissionsById");
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


## getIndicatorPermissionsBySpatialUnitIdAndId

> List&lt;PermissionLevelType&gt; getIndicatorPermissionsBySpatialUnitIdAndId(indicatorId, spatialUnitId)

retrieve information about the permissions for the selected indicator and spatial unit dataset

retrieve information about the permissions for the selected indicator and spatial unit dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        try {
            List<PermissionLevelType> result = apiInstance.getIndicatorPermissionsBySpatialUnitIdAndId(indicatorId, spatialUnitId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getIndicatorPermissionsBySpatialUnitIdAndId");
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


## getIndicators

> List&lt;IndicatorOverviewType&gt; getIndicators()

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        try {
            List<IndicatorOverviewType> result = apiInstance.getIndicators();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getIndicators");
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


## getSingleIndicatorFeatureById

> List&lt;IndicatorPropertiesWithoutGeomType&gt; getSingleIndicatorFeatureById(indicatorId, spatialUnitId, featureId, simplifyGeometries)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        String featureId = "featureId_example"; // String | the identifier of the indicator dataset spatial feature
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            List<IndicatorPropertiesWithoutGeomType> result = apiInstance.getSingleIndicatorFeatureById(indicatorId, spatialUnitId, featureId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getSingleIndicatorFeatureById");
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
| **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong] |

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


## getSingleIndicatorFeatureRecordById

> List&lt;IndicatorPropertiesWithoutGeomType&gt; getSingleIndicatorFeatureRecordById(indicatorId, spatialUnitId, featureId, featureRecordId, simplifyGeometries)

retrieve single feature database record specified by its unique database primary key id test

retrieve single feature database record specified by its unique database primary key id test

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        String featureId = "featureId_example"; // String | the identifier of the indicator dataset spatial feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
        try {
            List<IndicatorPropertiesWithoutGeomType> result = apiInstance.getSingleIndicatorFeatureRecordById(indicatorId, spatialUnitId, featureId, featureRecordId, simplifyGeometries);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#getSingleIndicatorFeatureRecordById");
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
| **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong] |

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


## updateIndicatorAsBody

> updateIndicatorAsBody(indicatorId, indicatorData)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        IndicatorPUTInputType indicatorData = new IndicatorPUTInputType(); // IndicatorPUTInputType | indicator data
        try {
            apiInstance.updateIndicatorAsBody(indicatorId, indicatorData);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#updateIndicatorAsBody");
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
| **indicatorData** | [**IndicatorPUTInputType**](IndicatorPUTInputType.md)| indicator data | |

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        List<IndicatorPATCHDisplayOrderInputType> indicatorOrderArray = Arrays.asList(); // List<IndicatorPATCHDisplayOrderInputType> | array of indicator id and displayOrder items
        try {
            apiInstance.updateIndicatorDisplayOrder(indicatorOrderArray);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#updateIndicatorDisplayOrder");
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
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | Created |  -  |
| **204** | No Content |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


## updateIndicatorFeatureRecordAsBody

> updateIndicatorFeatureRecordAsBody(indicatorId, spatialUnitId, featureId, featureRecordId, indicatorFeatureRecordData)

Modify/Update the feature record of the selected indicator dataset feature

Modify/Update the feature record of the selected indicator dataset feature

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        String featureId = "featureId_example"; // String | the identifier of the indicator dataset feature
        String featureRecordId = "featureRecordId_example"; // String | the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity
        IndicatorPropertiesWithoutGeomType indicatorFeatureRecordData = new IndicatorPropertiesWithoutGeomType(); // IndicatorPropertiesWithoutGeomType | indicator feature record data
        try {
            apiInstance.updateIndicatorFeatureRecordAsBody(indicatorId, spatialUnitId, featureId, featureRecordId, indicatorFeatureRecordData);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#updateIndicatorFeatureRecordAsBody");
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
| **featureId** | **String**| the identifier of the indicator dataset feature | |
| **featureRecordId** | **String**| the unique database record identifier of the indicator dataset feature - multiple records may exist for the same real world object if they apply to different periods of validity | |
| **indicatorFeatureRecordData** | [**IndicatorPropertiesWithoutGeomType**](IndicatorPropertiesWithoutGeomType.md)| indicator feature record data | |

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


## updateIndicatorMetadataAsBody

> updateIndicatorMetadataAsBody(indicatorId, metadata)

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
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        IndicatorMetadataPATCHInputType metadata = new IndicatorMetadataPATCHInputType(); // IndicatorMetadataPATCHInputType | metadata input
        try {
            apiInstance.updateIndicatorMetadataAsBody(indicatorId, metadata);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#updateIndicatorMetadataAsBody");
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
| **metadata** | [**IndicatorMetadataPATCHInputType**](IndicatorMetadataPATCHInputType.md)| metadata input | |

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


## updateIndicatorOwnership

> updateIndicatorOwnership(indicatorId, indicatorData)

Modify/Update the selected indicator dataset ownership

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        OwnerInputType indicatorData = new OwnerInputType(); // OwnerInputType | Indicator parameters input
        try {
            apiInstance.updateIndicatorOwnership(indicatorId, indicatorData);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#updateIndicatorOwnership");
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
| **indicatorData** | [**OwnerInputType**](OwnerInputType.md)| Indicator parameters input | |

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
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **405** | Invalid input |  -  |


## updateIndicatorOwnershipBySpatialUnit

> updateIndicatorOwnershipBySpatialUnit(indicatorId, spatialUnitId, indicatorData)

Modify/Update the selected indicator dataset ownership

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        OwnerInputType indicatorData = new OwnerInputType(); // OwnerInputType | Indicator parameters input
        try {
            apiInstance.updateIndicatorOwnershipBySpatialUnit(indicatorId, spatialUnitId, indicatorData);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#updateIndicatorOwnershipBySpatialUnit");
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
| **indicatorData** | [**OwnerInputType**](OwnerInputType.md)| Indicator parameters input | |

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


## updateIndicatorPermissions

> updateIndicatorPermissions(indicatorId, indicatorData)

Modify/Update the selected indicator dataset permissions

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        PermissionLevelInputType indicatorData = new PermissionLevelInputType(); // PermissionLevelInputType | Indicator parameters input
        try {
            apiInstance.updateIndicatorPermissions(indicatorId, indicatorData);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#updateIndicatorPermissions");
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
| **indicatorData** | [**PermissionLevelInputType**](PermissionLevelInputType.md)| Indicator parameters input | |

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
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **405** | Invalid input |  -  |


## updateIndicatorPermissionsBySpatialUnit

> updateIndicatorPermissionsBySpatialUnit(indicatorId, spatialUnitId, indicatorData)

Modify/Update the selected indicator dataset permissions

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        IndicatorsApi apiInstance = new IndicatorsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
        PermissionLevelInputType indicatorData = new PermissionLevelInputType(); // PermissionLevelInputType | Indicator parameters input
        try {
            apiInstance.updateIndicatorPermissionsBySpatialUnit(indicatorId, spatialUnitId, indicatorData);
        } catch (ApiException e) {
            System.err.println("Exception when calling IndicatorsApi#updateIndicatorPermissionsBySpatialUnit");
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
| **indicatorData** | [**PermissionLevelInputType**](PermissionLevelInputType.md)| Indicator parameters input | |

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


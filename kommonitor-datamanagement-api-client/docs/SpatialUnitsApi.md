# SpatialUnitsApi

All URIs are relative to *http://localhost:8085/management*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addSpatialUnitAsBody**](SpatialUnitsApi.md#addSpatialUnitAsBody) | **POST** /spatial-units | Add a new spatial-unit
[**deleteSpatialUnitById**](SpatialUnitsApi.md#deleteSpatialUnitById) | **DELETE** /spatial-units/{spatialUnitId} | Delete the features/contents of the selected spatial-unit
[**deleteSpatialUnitByIdAndYearAndMonth**](SpatialUnitsApi.md#deleteSpatialUnitByIdAndYearAndMonth) | **DELETE** /spatial-units/{spatialUnitId}/{year}/{month}/{day} | Delete the features/contents of the selected spatial-unit, year and month
[**getAllSpatialUnitFeaturesById**](SpatialUnitsApi.md#getAllSpatialUnitFeaturesById) | **GET** /spatial-units/{spatialUnitId}/allFeatures | retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)
[**getSpatialUnits**](SpatialUnitsApi.md#getSpatialUnits) | **GET** /spatial-units | retrieve information about available features of different spatial units/levels
[**getSpatialUnitsById**](SpatialUnitsApi.md#getSpatialUnitsById) | **GET** /spatial-units/{spatialUnitId} | retrieve information about available features of the selected spatial unit/level
[**getSpatialUnitsByIdAndYearAndMonth**](SpatialUnitsApi.md#getSpatialUnitsByIdAndYearAndMonth) | **GET** /spatial-units/{spatialUnitId}/{year}/{month}/{day} | retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON
[**getSpatialUnitsSchemaById**](SpatialUnitsApi.md#getSpatialUnitsSchemaById) | **GET** /spatial-units/{spatialUnitId}/schema | retrieve the JSON schema for the selected spatial unit/level
[**updateSpatialUnitAsBody**](SpatialUnitsApi.md#updateSpatialUnitAsBody) | **PUT** /spatial-units/{spatialUnitId} | Modify/Update the features of the selected spatial-unit
[**updateSpatialUnitMetadataAsBody**](SpatialUnitsApi.md#updateSpatialUnitMetadataAsBody) | **PATCH** /spatial-units/{spatialUnitId} | Modify/Update the metadata of the selected spatial-unit


<a name="addSpatialUnitAsBody"></a>
# **addSpatialUnitAsBody**
> addSpatialUnitAsBody(featureData)

Add a new spatial-unit

Add/Register a spatial unit for a certain period of time

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

SpatialUnitsApi apiInstance = new SpatialUnitsApi();
SpatialUnitPOSTInputType featureData = new SpatialUnitPOSTInputType(); // SpatialUnitPOSTInputType | feature data
try {
    apiInstance.addSpatialUnitAsBody(featureData);
} catch (ApiException e) {
    System.err.println("Exception when calling SpatialUnitsApi#addSpatialUnitAsBody");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **featureData** | [**SpatialUnitPOSTInputType**](SpatialUnitPOSTInputType.md)| feature data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="deleteSpatialUnitById"></a>
# **deleteSpatialUnitById**
> deleteSpatialUnitById(spatialUnitId)

Delete the features/contents of the selected spatial-unit

Delete the features/contents of the selected spatial-unit

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

SpatialUnitsApi apiInstance = new SpatialUnitsApi();
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
try {
    apiInstance.deleteSpatialUnitById(spatialUnitId);
} catch (ApiException e) {
    System.err.println("Exception when calling SpatialUnitsApi#deleteSpatialUnitById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **spatialUnitId** | **String**| the unique identifier of the spatial level |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteSpatialUnitByIdAndYearAndMonth"></a>
# **deleteSpatialUnitByIdAndYearAndMonth**
> deleteSpatialUnitByIdAndYearAndMonth(spatialUnitId, year, month, day)

Delete the features/contents of the selected spatial-unit, year and month

Delete the features/contents of the selected spatial-unit, year and month

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

SpatialUnitsApi apiInstance = new SpatialUnitsApi();
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
BigDecimal year = new BigDecimal(); // BigDecimal | year for which datasets shall be queried
BigDecimal month = new BigDecimal(); // BigDecimal | month for which datasets shall be queried
BigDecimal day = new BigDecimal(); // BigDecimal | day for which datasets shall be queried
try {
    apiInstance.deleteSpatialUnitByIdAndYearAndMonth(spatialUnitId, year, month, day);
} catch (ApiException e) {
    System.err.println("Exception when calling SpatialUnitsApi#deleteSpatialUnitByIdAndYearAndMonth");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **spatialUnitId** | **String**| the unique identifier of the spatial level |
 **year** | **BigDecimal**| year for which datasets shall be queried |
 **month** | **BigDecimal**| month for which datasets shall be queried |
 **day** | **BigDecimal**| day for which datasets shall be queried |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getAllSpatialUnitFeaturesById"></a>
# **getAllSpatialUnitFeaturesById**
> String getAllSpatialUnitFeaturesById(spatialUnitId, simplifyGeometries)

retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)

retrieve all feature entries for all applicable periods of validity for the selected spatial unit/level (hence might contain each feature multiple times if they exist for different periods of validity)

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

SpatialUnitsApi apiInstance = new SpatialUnitsApi();
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
try {
    String result = apiInstance.getAllSpatialUnitFeaturesById(spatialUnitId, simplifyGeometries);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SpatialUnitsApi#getAllSpatialUnitFeaturesById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **spatialUnitId** | **String**| the unique identifier of the spatial level |
 **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong]

### Return type

**String**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSpatialUnits"></a>
# **getSpatialUnits**
> List&lt;SpatialUnitOverviewType&gt; getSpatialUnits()

retrieve information about available features of different spatial units/levels

retrieve information about available features of different spatial units/levels

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

SpatialUnitsApi apiInstance = new SpatialUnitsApi();
try {
    List<SpatialUnitOverviewType> result = apiInstance.getSpatialUnits();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SpatialUnitsApi#getSpatialUnits");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;SpatialUnitOverviewType&gt;**](SpatialUnitOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSpatialUnitsById"></a>
# **getSpatialUnitsById**
> SpatialUnitOverviewType getSpatialUnitsById(spatialUnitId)

retrieve information about available features of the selected spatial unit/level

retrieve information about available features of the selected spatial unit/level

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

SpatialUnitsApi apiInstance = new SpatialUnitsApi();
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
try {
    SpatialUnitOverviewType result = apiInstance.getSpatialUnitsById(spatialUnitId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SpatialUnitsApi#getSpatialUnitsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **spatialUnitId** | **String**| the unique identifier of the spatial level |

### Return type

[**SpatialUnitOverviewType**](SpatialUnitOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSpatialUnitsByIdAndYearAndMonth"></a>
# **getSpatialUnitsByIdAndYearAndMonth**
> byte[] getSpatialUnitsByIdAndYearAndMonth(spatialUnitId, year, month, day, simplifyGeometries)

retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON

retrieve the features according to the selected spatial unit/level and selected year and month as GeoJSON

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

SpatialUnitsApi apiInstance = new SpatialUnitsApi();
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
BigDecimal year = new BigDecimal(); // BigDecimal | year for which datasets shall be queried
BigDecimal month = new BigDecimal(); // BigDecimal | month for which datasets shall be queried
BigDecimal day = new BigDecimal(); // BigDecimal | day for which datasets shall be queried
String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
try {
    byte[] result = apiInstance.getSpatialUnitsByIdAndYearAndMonth(spatialUnitId, year, month, day, simplifyGeometries);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SpatialUnitsApi#getSpatialUnitsByIdAndYearAndMonth");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **spatialUnitId** | **String**| the unique identifier of the spatial level |
 **year** | **BigDecimal**| year for which datasets shall be queried |
 **month** | **BigDecimal**| month for which datasets shall be queried |
 **day** | **BigDecimal**| day for which datasets shall be queried |
 **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong]

### Return type

**byte[]**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octed-stream

<a name="getSpatialUnitsSchemaById"></a>
# **getSpatialUnitsSchemaById**
> String getSpatialUnitsSchemaById(spatialUnitId)

retrieve the JSON schema for the selected spatial unit/level

retrieve the JSON schema for the selected spatial unit/level. The JSON schema indicates the property structure of the dataset.

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

SpatialUnitsApi apiInstance = new SpatialUnitsApi();
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
try {
    String result = apiInstance.getSpatialUnitsSchemaById(spatialUnitId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SpatialUnitsApi#getSpatialUnitsSchemaById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **spatialUnitId** | **String**| the unique identifier of the spatial level |

### Return type

**String**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateSpatialUnitAsBody"></a>
# **updateSpatialUnitAsBody**
> updateSpatialUnitAsBody(spatialUnitId, featureData)

Modify/Update the features of the selected spatial-unit

Modify/Update the features of the selected spatial-unit. The interface expects a full upload of all geometries for the spatial unit. Internally, those geometries are compared to the existing ones to mark &#39;old&#39; geometries that are no longer in use as outdated. Hence, each geometric object is only persisted once and its use is controlled by time validity marks.

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

SpatialUnitsApi apiInstance = new SpatialUnitsApi();
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
SpatialUnitPUTInputType featureData = new SpatialUnitPUTInputType(); // SpatialUnitPUTInputType | feature data
try {
    apiInstance.updateSpatialUnitAsBody(spatialUnitId, featureData);
} catch (ApiException e) {
    System.err.println("Exception when calling SpatialUnitsApi#updateSpatialUnitAsBody");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **spatialUnitId** | **String**| the unique identifier of the spatial level |
 **featureData** | [**SpatialUnitPUTInputType**](SpatialUnitPUTInputType.md)| feature data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateSpatialUnitMetadataAsBody"></a>
# **updateSpatialUnitMetadataAsBody**
> updateSpatialUnitMetadataAsBody(spatialUnitId, metadata)

Modify/Update the metadata of the selected spatial-unit

Modify/Update the metadata of the selected spatial-unit. This replaces the formerly stored metadata.

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

SpatialUnitsApi apiInstance = new SpatialUnitsApi();
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
SpatialUnitPATCHInputType metadata = new SpatialUnitPATCHInputType(); // SpatialUnitPATCHInputType | metadata input
try {
    apiInstance.updateSpatialUnitMetadataAsBody(spatialUnitId, metadata);
} catch (ApiException e) {
    System.err.println("Exception when calling SpatialUnitsApi#updateSpatialUnitMetadataAsBody");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **spatialUnitId** | **String**| the unique identifier of the spatial level |
 **metadata** | [**SpatialUnitPATCHInputType**](SpatialUnitPATCHInputType.md)| metadata input |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


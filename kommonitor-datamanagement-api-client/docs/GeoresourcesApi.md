# GeoresourcesApi

All URIs are relative to *http://localhost:8085/management*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addGeoresourceAsBody**](GeoresourcesApi.md#addGeoresourceAsBody) | **POST** /georesources | Add a new geo-resource
[**deleteGeoresourceById**](GeoresourcesApi.md#deleteGeoresourceById) | **DELETE** /georesources/{georesourceId} | Delete the features/contents of the selected geo-resource dataset
[**deleteGeoresourceByIdAndYearAndMonth**](GeoresourcesApi.md#deleteGeoresourceByIdAndYearAndMonth) | **DELETE** /georesources/{georesourceId}/{year}/{month}/{day} | Delete the features/contents of the selected geo-resource dataset, selected by year and month
[**getAllGeoresourceFeaturesById**](GeoresourcesApi.md#getAllGeoresourceFeaturesById) | **GET** /georesources/{georesourceId}/allFeatures | retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)
[**getGeoresourceById**](GeoresourcesApi.md#getGeoresourceById) | **GET** /georesources/{georesourceId} | retrieve information about available features of the selected geo-resource dataset
[**getGeoresourceByIdAndYearAndMonth**](GeoresourcesApi.md#getGeoresourceByIdAndYearAndMonth) | **GET** /georesources/{georesourceId}/{year}/{month}/{day} | retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON
[**getGeoresourceSchemaByLevel**](GeoresourcesApi.md#getGeoresourceSchemaByLevel) | **GET** /georesources/{georesourceId}/schema | retrieve the JSON schema for the selected geo-resource dataset
[**getGeoresources**](GeoresourcesApi.md#getGeoresources) | **GET** /georesources | retrieve information about available features of different geo-resource datasets
[**updateGeoresourceAsBody**](GeoresourcesApi.md#updateGeoresourceAsBody) | **PUT** /georesources/{georesourceId} | Modify/Update the features of the selected geo-resource dataset
[**updateGeoresourceMetadataAsBody**](GeoresourcesApi.md#updateGeoresourceMetadataAsBody) | **PATCH** /georesources/{georesourceId} | Modify/Update the metadata of the selected geo-resource dataset


<a name="addGeoresourceAsBody"></a>
# **addGeoresourceAsBody**
> addGeoresourceAsBody(featureData)

Add a new geo-resource

Add/Register a geo-resource dataset for a certain period of time

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

GeoresourcesApi apiInstance = new GeoresourcesApi();
GeoresourcePOSTInputType featureData = new GeoresourcePOSTInputType(); // GeoresourcePOSTInputType | feature data
try {
    apiInstance.addGeoresourceAsBody(featureData);
} catch (ApiException e) {
    System.err.println("Exception when calling GeoresourcesApi#addGeoresourceAsBody");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **featureData** | [**GeoresourcePOSTInputType**](GeoresourcePOSTInputType.md)| feature data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="deleteGeoresourceById"></a>
# **deleteGeoresourceById**
> deleteGeoresourceById(georesourceId)

Delete the features/contents of the selected geo-resource dataset

Delete the features/contents of the selected geo-resource dataset

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

GeoresourcesApi apiInstance = new GeoresourcesApi();
String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
try {
    apiInstance.deleteGeoresourceById(georesourceId);
} catch (ApiException e) {
    System.err.println("Exception when calling GeoresourcesApi#deleteGeoresourceById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **georesourceId** | **String**| identifier of the geo-resource dataset |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteGeoresourceByIdAndYearAndMonth"></a>
# **deleteGeoresourceByIdAndYearAndMonth**
> deleteGeoresourceByIdAndYearAndMonth(georesourceId, year, month, day)

Delete the features/contents of the selected geo-resource dataset, selected by year and month

Delete the features/contents of the selected geo-resource dataset, selected by year and month

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

GeoresourcesApi apiInstance = new GeoresourcesApi();
String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
BigDecimal year = new BigDecimal(); // BigDecimal | year for which datasets shall be queried
BigDecimal month = new BigDecimal(); // BigDecimal | month for which datasets shall be queried
BigDecimal day = new BigDecimal(); // BigDecimal | day for which datasets shall be queried
try {
    apiInstance.deleteGeoresourceByIdAndYearAndMonth(georesourceId, year, month, day);
} catch (ApiException e) {
    System.err.println("Exception when calling GeoresourcesApi#deleteGeoresourceByIdAndYearAndMonth");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **georesourceId** | **String**| identifier of the geo-resource dataset |
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

<a name="getAllGeoresourceFeaturesById"></a>
# **getAllGeoresourceFeaturesById**
> String getAllGeoresourceFeaturesById(georesourceId, simplifyGeometries)

retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)

retrieve all feature entries for all applicable periods of validity for the selected geo-resource dataset (hence might contain each feature multiple times if they exist for different periods of validity)

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

GeoresourcesApi apiInstance = new GeoresourcesApi();
String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
try {
    String result = apiInstance.getAllGeoresourceFeaturesById(georesourceId, simplifyGeometries);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GeoresourcesApi#getAllGeoresourceFeaturesById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **georesourceId** | **String**| the identifier of the geo-resource dataset |
 **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong]

### Return type

**String**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGeoresourceById"></a>
# **getGeoresourceById**
> GeoresourceOverviewType getGeoresourceById(georesourceId)

retrieve information about available features of the selected geo-resource dataset

retrieve information about available features of the selected geo-resource dataset

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

GeoresourcesApi apiInstance = new GeoresourcesApi();
String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
try {
    GeoresourceOverviewType result = apiInstance.getGeoresourceById(georesourceId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GeoresourcesApi#getGeoresourceById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **georesourceId** | **String**| identifier of the geo-resource dataset |

### Return type

[**GeoresourceOverviewType**](GeoresourceOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGeoresourceByIdAndYearAndMonth"></a>
# **getGeoresourceByIdAndYearAndMonth**
> byte[] getGeoresourceByIdAndYearAndMonth(georesourceId, year, month, day, simplifyGeometries)

retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON

retrieve the features according to the selected geo-resource dataset and selected year and month as GeoJSON

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

GeoresourcesApi apiInstance = new GeoresourcesApi();
String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
BigDecimal year = new BigDecimal(); // BigDecimal | year for which datasets shall be queried
BigDecimal month = new BigDecimal(); // BigDecimal | month for which datasets shall be queried
BigDecimal day = new BigDecimal(); // BigDecimal | day for which datasets shall be queried
String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
try {
    byte[] result = apiInstance.getGeoresourceByIdAndYearAndMonth(georesourceId, year, month, day, simplifyGeometries);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GeoresourcesApi#getGeoresourceByIdAndYearAndMonth");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **georesourceId** | **String**| identifier of the geo-resource dataset |
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

<a name="getGeoresourceSchemaByLevel"></a>
# **getGeoresourceSchemaByLevel**
> String getGeoresourceSchemaByLevel(georesourceId)

retrieve the JSON schema for the selected geo-resource dataset

retrieve the JSON schema for the selected geo-resource dataset. The JSON schema indicates the property structure of the dataset.

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

GeoresourcesApi apiInstance = new GeoresourcesApi();
String georesourceId = "georesourceId_example"; // String | the identifier of the geo-resource dataset
try {
    String result = apiInstance.getGeoresourceSchemaByLevel(georesourceId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GeoresourcesApi#getGeoresourceSchemaByLevel");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **georesourceId** | **String**| the identifier of the geo-resource dataset |

### Return type

**String**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGeoresources"></a>
# **getGeoresources**
> List&lt;GeoresourceOverviewType&gt; getGeoresources()

retrieve information about available features of different geo-resource datasets

retrieve information about available features of different geo-resource datasets

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

GeoresourcesApi apiInstance = new GeoresourcesApi();
try {
    List<GeoresourceOverviewType> result = apiInstance.getGeoresources();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GeoresourcesApi#getGeoresources");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;GeoresourceOverviewType&gt;**](GeoresourceOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateGeoresourceAsBody"></a>
# **updateGeoresourceAsBody**
> updateGeoresourceAsBody(georesourceId, featureData)

Modify/Update the features of the selected geo-resource dataset

Modify/Update the features of the selected geo-resource dataset.  The interface expects a full upload of all geometries for the spatial unit. Internally, those geometries are compared to the existing ones to mark &#39;old&#39; geometries that are no longer in use as outdated. Hence, each geometric object is only persisted once and its use is controlled by time validity marks.

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

GeoresourcesApi apiInstance = new GeoresourcesApi();
String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
GeoresourcePUTInputType featureData = new GeoresourcePUTInputType(); // GeoresourcePUTInputType | feature data
try {
    apiInstance.updateGeoresourceAsBody(georesourceId, featureData);
} catch (ApiException e) {
    System.err.println("Exception when calling GeoresourcesApi#updateGeoresourceAsBody");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **georesourceId** | **String**| identifier of the geo-resource dataset |
 **featureData** | [**GeoresourcePUTInputType**](GeoresourcePUTInputType.md)| feature data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateGeoresourceMetadataAsBody"></a>
# **updateGeoresourceMetadataAsBody**
> updateGeoresourceMetadataAsBody(georesourceId, metadata)

Modify/Update the metadata of the selected geo-resource dataset

Modify/Update the metadata of the selected geo-resource dataset. This replaces the formerly stored metadata.

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

GeoresourcesApi apiInstance = new GeoresourcesApi();
String georesourceId = "georesourceId_example"; // String | identifier of the geo-resource dataset
GeoresourcePATCHInputType metadata = new GeoresourcePATCHInputType(); // GeoresourcePATCHInputType | metadata input
try {
    apiInstance.updateGeoresourceMetadataAsBody(georesourceId, metadata);
} catch (ApiException e) {
    System.err.println("Exception when calling GeoresourcesApi#updateGeoresourceMetadataAsBody");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **georesourceId** | **String**| identifier of the geo-resource dataset |
 **metadata** | [**GeoresourcePATCHInputType**](GeoresourcePATCHInputType.md)| metadata input |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


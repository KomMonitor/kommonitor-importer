# IndicatorsApi

All URIs are relative to *http://localhost:8085/management*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addIndicatorAsBody**](IndicatorsApi.md#addIndicatorAsBody) | **POST** /indicators | Add a new indicator dataset
[**deleteIndicatorById**](IndicatorsApi.md#deleteIndicatorById) | **DELETE** /indicators/{indicatorId} | Delete the features/contents of the selected indicator dataset
[**deleteIndicatorByIdAndSpatialUnitId**](IndicatorsApi.md#deleteIndicatorByIdAndSpatialUnitId) | **DELETE** /indicators/{indicatorId}/{spatialUnitId} | Delete the features/contents of the selected indicator dataset for the selected spatial unit
[**deleteIndicatorByIdAndYearAndMonth**](IndicatorsApi.md#deleteIndicatorByIdAndYearAndMonth) | **DELETE** /indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day} | Delete the features/contents of the selected indicator dataset, selected by year and month
[**getIndicatorById**](IndicatorsApi.md#getIndicatorById) | **GET** /indicators/{indicatorId} | retrieve information about the selected indicator
[**getIndicatorBySpatialUnitIdAndId**](IndicatorsApi.md#getIndicatorBySpatialUnitIdAndId) | **GET** /indicators/{indicatorId}/{spatialUnitId} | retrieve the indicator for the selected spatial unit as GeoJSON
[**getIndicatorBySpatialUnitIdAndIdAndYearAndMonth**](IndicatorsApi.md#getIndicatorBySpatialUnitIdAndIdAndYearAndMonth) | **GET** /indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day} | retrieve the indicator for the selected spatial unit, year and month as GeoJSON
[**getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry**](IndicatorsApi.md#getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry) | **GET** /indicators/{indicatorId}/{spatialUnitId}/{year}/{month}/{day}/without-geometry | retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!
[**getIndicatorBySpatialUnitIdAndIdWithoutGeometry**](IndicatorsApi.md#getIndicatorBySpatialUnitIdAndIdWithoutGeometry) | **GET** /indicators/{indicatorId}/{spatialUnitId}/without-geometry | retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!
[**getIndicators**](IndicatorsApi.md#getIndicators) | **GET** /indicators | retrieve information about available indicators
[**updateIndicatorAsBody**](IndicatorsApi.md#updateIndicatorAsBody) | **PUT** /indicators/{indicatorId} | Modify/Update the contents of the selected indicator dataset
[**updateIndicatorMetadataAsBody**](IndicatorsApi.md#updateIndicatorMetadataAsBody) | **PATCH** /indicators/{indicatorId} | Modify/Update the metadata of the selected indicator dataset


<a name="addIndicatorAsBody"></a>
# **addIndicatorAsBody**
> addIndicatorAsBody(indicatorData)

Add a new indicator dataset

Add/Register an indicator dataset for a certain period of time and spatial unit/level

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
IndicatorPOSTInputType indicatorData = new IndicatorPOSTInputType(); // IndicatorPOSTInputType | indicator data
try {
    apiInstance.addIndicatorAsBody(indicatorData);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#addIndicatorAsBody");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorData** | [**IndicatorPOSTInputType**](IndicatorPOSTInputType.md)| indicator data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="deleteIndicatorById"></a>
# **deleteIndicatorById**
> deleteIndicatorById(indicatorId)

Delete the features/contents of the selected indicator dataset

Delete the features/contents of the selected indicator dataset

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
try {
    apiInstance.deleteIndicatorById(indicatorId);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#deleteIndicatorById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteIndicatorByIdAndSpatialUnitId"></a>
# **deleteIndicatorByIdAndSpatialUnitId**
> deleteIndicatorByIdAndSpatialUnitId(indicatorId, spatialUnitId)

Delete the features/contents of the selected indicator dataset for the selected spatial unit

Delete the features/contents of the selected indicator dataset for the selected spatial unit

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
try {
    apiInstance.deleteIndicatorByIdAndSpatialUnitId(indicatorId, spatialUnitId);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#deleteIndicatorByIdAndSpatialUnitId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |
 **spatialUnitId** | **String**| the unique identifier of the spatial level |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteIndicatorByIdAndYearAndMonth"></a>
# **deleteIndicatorByIdAndYearAndMonth**
> deleteIndicatorByIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day)

Delete the features/contents of the selected indicator dataset, selected by year and month

Delete the features/contents of the selected indicator dataset, selected by year and month

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
BigDecimal year = new BigDecimal(); // BigDecimal | year for which the indicator shall be queried
BigDecimal month = new BigDecimal(); // BigDecimal | month for which the indicator shall be queried
BigDecimal day = new BigDecimal(); // BigDecimal | day for which datasets shall be queried
try {
    apiInstance.deleteIndicatorByIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#deleteIndicatorByIdAndYearAndMonth");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |
 **spatialUnitId** | **String**| the unique identifier of the spatial level |
 **year** | **BigDecimal**| year for which the indicator shall be queried |
 **month** | **BigDecimal**| month for which the indicator shall be queried |
 **day** | **BigDecimal**| day for which datasets shall be queried |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getIndicatorById"></a>
# **getIndicatorById**
> IndicatorOverviewType getIndicatorById(indicatorId)

retrieve information about the selected indicator

retrieve information about the selected indicator

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
try {
    IndicatorOverviewType result = apiInstance.getIndicatorById(indicatorId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#getIndicatorById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |

### Return type

[**IndicatorOverviewType**](IndicatorOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getIndicatorBySpatialUnitIdAndId"></a>
# **getIndicatorBySpatialUnitIdAndId**
> byte[] getIndicatorBySpatialUnitIdAndId(indicatorId, spatialUnitId, simplifyGeometries)

retrieve the indicator for the selected spatial unit as GeoJSON

retrieve the indicator for the selected spatial unit as GeoJSON

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
try {
    byte[] result = apiInstance.getIndicatorBySpatialUnitIdAndId(indicatorId, spatialUnitId, simplifyGeometries);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#getIndicatorBySpatialUnitIdAndId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |
 **spatialUnitId** | **String**| the unique identifier of the spatial level |
 **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong]

### Return type

**byte[]**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octed-stream

<a name="getIndicatorBySpatialUnitIdAndIdAndYearAndMonth"></a>
# **getIndicatorBySpatialUnitIdAndIdAndYearAndMonth**
> byte[] getIndicatorBySpatialUnitIdAndIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day, simplifyGeometries)

retrieve the indicator for the selected spatial unit, year and month as GeoJSON

retrieve the indicator for the selected spatial unit, year and month as GeoJSON

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
BigDecimal year = new BigDecimal(); // BigDecimal | year for which the indicator shall be queried
BigDecimal month = new BigDecimal(); // BigDecimal | month for which the indicator shall be queried
BigDecimal day = new BigDecimal(); // BigDecimal | day for which datasets shall be queried
String simplifyGeometries = "original"; // String | Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from 'weak' to 'strong', while 'original' will return original feature geometries without any simplification.
try {
    byte[] result = apiInstance.getIndicatorBySpatialUnitIdAndIdAndYearAndMonth(indicatorId, spatialUnitId, year, month, day, simplifyGeometries);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#getIndicatorBySpatialUnitIdAndIdAndYearAndMonth");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |
 **spatialUnitId** | **String**| the unique identifier of the spatial level |
 **year** | **BigDecimal**| year for which the indicator shall be queried |
 **month** | **BigDecimal**| month for which the indicator shall be queried |
 **day** | **BigDecimal**| day for which datasets shall be queried |
 **simplifyGeometries** | **String**| Controls simplification of feature geometries. Each option will preserve topology to neighbour features. Simplification increases from &#39;weak&#39; to &#39;strong&#39;, while &#39;original&#39; will return original feature geometries without any simplification. | [optional] [default to original] [enum: original, weak, medium, strong]

### Return type

**byte[]**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octed-stream

<a name="getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry"></a>
# **getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry**
> List&lt;IndicatorPropertiesWithoutGeomType&gt; getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(indicatorId, spatialUnitId, year, month, day)

retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!

retrieve the indicator values and other properties for the selected spatial unit, year and month. It does not include the spatial geometries!

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
BigDecimal year = new BigDecimal(); // BigDecimal | year for which the indicator shall be queried
BigDecimal month = new BigDecimal(); // BigDecimal | month for which the indicator shall be queried
BigDecimal day = new BigDecimal(); // BigDecimal | day for which datasets shall be queried
try {
    List<IndicatorPropertiesWithoutGeomType> result = apiInstance.getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry(indicatorId, spatialUnitId, year, month, day);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#getIndicatorBySpatialUnitIdAndIdAndYearAndMonthWithoutGeometry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |
 **spatialUnitId** | **String**| the unique identifier of the spatial level |
 **year** | **BigDecimal**| year for which the indicator shall be queried |
 **month** | **BigDecimal**| month for which the indicator shall be queried |
 **day** | **BigDecimal**| day for which datasets shall be queried |

### Return type

[**List&lt;IndicatorPropertiesWithoutGeomType&gt;**](IndicatorPropertiesWithoutGeomType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getIndicatorBySpatialUnitIdAndIdWithoutGeometry"></a>
# **getIndicatorBySpatialUnitIdAndIdWithoutGeometry**
> List&lt;IndicatorPropertiesWithoutGeomType&gt; getIndicatorBySpatialUnitIdAndIdWithoutGeometry(indicatorId, spatialUnitId)

retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!

retrieve the indicator values and other properties for the selected spatial unit. It does not include the spatial geometries!

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
String spatialUnitId = "spatialUnitId_example"; // String | the unique identifier of the spatial level
try {
    List<IndicatorPropertiesWithoutGeomType> result = apiInstance.getIndicatorBySpatialUnitIdAndIdWithoutGeometry(indicatorId, spatialUnitId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#getIndicatorBySpatialUnitIdAndIdWithoutGeometry");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |
 **spatialUnitId** | **String**| the unique identifier of the spatial level |

### Return type

[**List&lt;IndicatorPropertiesWithoutGeomType&gt;**](IndicatorPropertiesWithoutGeomType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getIndicators"></a>
# **getIndicators**
> List&lt;IndicatorOverviewType&gt; getIndicators()

retrieve information about available indicators

retrieve information about available indicators

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
try {
    List<IndicatorOverviewType> result = apiInstance.getIndicators();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#getIndicators");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;IndicatorOverviewType&gt;**](IndicatorOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateIndicatorAsBody"></a>
# **updateIndicatorAsBody**
> updateIndicatorAsBody(indicatorId, indicatorData)

Modify/Update the contents of the selected indicator dataset

Modify/Update the contents of the selected indicator dataset

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
IndicatorPUTInputType indicatorData = new IndicatorPUTInputType(); // IndicatorPUTInputType | indicator data
try {
    apiInstance.updateIndicatorAsBody(indicatorId, indicatorData);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#updateIndicatorAsBody");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |
 **indicatorData** | [**IndicatorPUTInputType**](IndicatorPUTInputType.md)| indicator data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateIndicatorMetadataAsBody"></a>
# **updateIndicatorMetadataAsBody**
> updateIndicatorMetadataAsBody(indicatorId, metadata)

Modify/Update the metadata of the selected indicator dataset

Modify/Update the metadata of the selected indicator dataset. This replaces the formerly stored metadata.

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
IndicatorPATCHInputType metadata = new IndicatorPATCHInputType(); // IndicatorPATCHInputType | metadata input
try {
    apiInstance.updateIndicatorMetadataAsBody(indicatorId, metadata);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#updateIndicatorMetadataAsBody");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |
 **metadata** | [**IndicatorPATCHInputType**](IndicatorPATCHInputType.md)| metadata input |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


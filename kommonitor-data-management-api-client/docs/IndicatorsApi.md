# IndicatorsApi

All URIs are relative to *http://localhost:8087/import*

Method | HTTP request | Description
------------- | ------------- | -------------
[**importIndicator**](IndicatorsApi.md#importIndicator) | **POST** /indicators | Import a new indicator dataset


<a name="importIndicator"></a>
# **importIndicator**
> importIndicator(indicatorData)

Import a new indicator dataset

Import an indicator dataset for a certain period of time and spatial unit/level. Parses Input source, extracts relevant data, performs schema mapping to KomMonitor data model and calls POST /indicators of KomMonitor Data Management API

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.ApiClient;
//import org.n52.kommonitor.datamanagement.ApiException;
//import org.n52.kommonitor.datamanagement.Configuration;
//import org.n52.kommonitor.datamanagement.auth.*;
//import org.n52.kommonitor.datamanagement.client.IndicatorsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

IndicatorsApi apiInstance = new IndicatorsApi();
ImportIndicatorPOSTInputType indicatorData = new ImportIndicatorPOSTInputType(); // ImportIndicatorPOSTInputType | indicator data
try {
    apiInstance.importIndicator(indicatorData);
} catch (ApiException e) {
    System.err.println("Exception when calling IndicatorsApi#importIndicator");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorData** | [**ImportIndicatorPOSTInputType**](ImportIndicatorPOSTInputType.md)| indicator data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


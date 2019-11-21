# GeoresourcesApi

All URIs are relative to *http://localhost:8087/import*

Method | HTTP request | Description
------------- | ------------- | -------------
[**importGeoresource**](GeoresourcesApi.md#importGeoresource) | **POST** /georesources | Import a new geo-resource


<a name="importGeoresource"></a>
# **importGeoresource**
> importGeoresource(featureData)

Import a new geo-resource

Import a geo-resource dataset for a certain period of time. Parses Input source, extracts relevant data, performs schema mapping to KomMonitor data model and calls POST /georesources of KomMonitor Data Management API

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.ApiClient;
//import org.n52.kommonitor.datamanagement.ApiException;
//import org.n52.kommonitor.datamanagement.Configuration;
//import org.n52.kommonitor.datamanagement.auth.*;
//import org.n52.kommonitor.datamanagement.client.GeoresourcesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

GeoresourcesApi apiInstance = new GeoresourcesApi();
ImportGeoresourcePOSTInputType featureData = new ImportGeoresourcePOSTInputType(); // ImportGeoresourcePOSTInputType | feature data
try {
    apiInstance.importGeoresource(featureData);
} catch (ApiException e) {
    System.err.println("Exception when calling GeoresourcesApi#importGeoresource");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **featureData** | [**ImportGeoresourcePOSTInputType**](ImportGeoresourcePOSTInputType.md)| feature data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


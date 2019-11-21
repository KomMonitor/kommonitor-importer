# SpatialUnitsApi

All URIs are relative to *http://localhost:8087/import*

Method | HTTP request | Description
------------- | ------------- | -------------
[**importSpatialUnit**](SpatialUnitsApi.md#importSpatialUnit) | **POST** /spatial-units | Import a new spatial-unit


<a name="importSpatialUnit"></a>
# **importSpatialUnit**
> importSpatialUnit(featureData)

Import a new spatial-unit

Import a new spatial unit for a certain period of time. Parses Input source, extracts relevant data, performs schema mapping to KomMonitor data model and calls POST /spatial-units of KomMonitor Data Management API

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.ApiClient;
//import org.n52.kommonitor.datamanagement.ApiException;
//import org.n52.kommonitor.datamanagement.Configuration;
//import org.n52.kommonitor.datamanagement.auth.*;
//import org.n52.kommonitor.datamanagement.client.SpatialUnitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

SpatialUnitsApi apiInstance = new SpatialUnitsApi();
ImportSpatialUnitPOSTInputType featureData = new ImportSpatialUnitPOSTInputType(); // ImportSpatialUnitPOSTInputType | feature data
try {
    apiInstance.importSpatialUnit(featureData);
} catch (ApiException e) {
    System.err.println("Exception when calling SpatialUnitsApi#importSpatialUnit");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **featureData** | [**ImportSpatialUnitPOSTInputType**](ImportSpatialUnitPOSTInputType.md)| feature data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


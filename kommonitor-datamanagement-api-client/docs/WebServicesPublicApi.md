# WebServicesPublicApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getPublicWebServices**](WebServicesPublicApi.md#getPublicWebServices) | **GET** /public/web-services | retrieve information about available public web services |
| [**getWebPublicServiceById**](WebServicesPublicApi.md#getWebPublicServiceById) | **GET** /public/web-services/{webServiceId} | retrieve information about a certain public web service |



## getPublicWebServices

> List&lt;WebServiceOverviewType&gt; getPublicWebServices(resourceType)

retrieve information about available public web services

retrieve information about available public web services

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.WebServicesPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        WebServicesPublicApi apiInstance = new WebServicesPublicApi(defaultClient);
        String resourceType = "indicator"; // String | Controls whether only web services for indicators or georesources should be returned. Supported values are ['georesource', 'indicator']
        try {
            List<WebServiceOverviewType> result = apiInstance.getPublicWebServices(resourceType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebServicesPublicApi#getPublicWebServices");
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
| **resourceType** | **String**| Controls whether only web services for indicators or georesources should be returned. Supported values are [&#39;georesource&#39;, &#39;indicator&#39;] | [optional] [enum: indicator, georesource] |

### Return type

[**List&lt;WebServiceOverviewType&gt;**](WebServiceOverviewType.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getWebPublicServiceById

> WebServiceOverviewType getWebPublicServiceById(webServiceId)

retrieve information about a certain public web service

retrieve information about a certain public web service

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.WebServicesPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        WebServicesPublicApi apiInstance = new WebServicesPublicApi(defaultClient);
        String webServiceId = "webServiceId_example"; // String | identifier of the web service metadata entry
        try {
            WebServiceOverviewType result = apiInstance.getWebPublicServiceById(webServiceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebServicesPublicApi#getWebPublicServiceById");
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
| **webServiceId** | **String**| identifier of the web service metadata entry | |

### Return type

[**WebServiceOverviewType**](WebServiceOverviewType.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


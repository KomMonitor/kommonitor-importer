# ProcessScriptsPublicApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getProcessScriptCodeForPublicIndicator**](ProcessScriptsPublicApi.md#getProcessScriptCodeForPublicIndicator) | **GET** /public/process-scripts/usingIndicatorId/{indicatorId}/scriptCode | retrieve the process script code associated to a certain public indicator as JavaScript file |
| [**getProcessScriptForPublicIndicator**](ProcessScriptsPublicApi.md#getProcessScriptForPublicIndicator) | **GET** /public/process-scripts/usingIndicatorId/{indicatorId} | retrieve information about the associated process script for a certain public indicator |
| [**getPublicProcessScriptCode**](ProcessScriptsPublicApi.md#getPublicProcessScriptCode) | **GET** /public/process-scripts/{scriptId}/scriptCode | retrieve the process script code associated to a certain public indicator as JavaScript file |
| [**getPublicProcessScriptForScriptId**](ProcessScriptsPublicApi.md#getPublicProcessScriptForScriptId) | **GET** /public/process-scripts/{scriptId} | retrieve information about the associated process script for a certain scriptId associated to a public indicator |
| [**getPublicProcessScripts**](ProcessScriptsPublicApi.md#getPublicProcessScripts) | **GET** /public/process-scripts | retrieve information about available process scripts associated to public indicators |



## getProcessScriptCodeForPublicIndicator

> byte[] getProcessScriptCodeForPublicIndicator(indicatorId)

retrieve the process script code associated to a certain public indicator as JavaScript file

retrieve the process script code associated to a certain public indicator as JavaScript file

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsPublicApi apiInstance = new ProcessScriptsPublicApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        try {
            byte[] result = apiInstance.getProcessScriptCodeForPublicIndicator(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsPublicApi#getProcessScriptCodeForPublicIndicator");
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

**byte[]**

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/javascript


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Invalid status value |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getProcessScriptForPublicIndicator

> ProcessScriptOverviewType getProcessScriptForPublicIndicator(indicatorId)

retrieve information about the associated process script for a certain public indicator

retrieve information about the associated process script for a certain indicator

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsPublicApi apiInstance = new ProcessScriptsPublicApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected public indicator dataset
        try {
            ProcessScriptOverviewType result = apiInstance.getProcessScriptForPublicIndicator(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsPublicApi#getProcessScriptForPublicIndicator");
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
| **indicatorId** | **String**| unique identifier of the selected public indicator dataset | |

### Return type

[**ProcessScriptOverviewType**](ProcessScriptOverviewType.md)

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


## getPublicProcessScriptCode

> byte[] getPublicProcessScriptCode(scriptId)

retrieve the process script code associated to a certain public indicator as JavaScript file

retrieve the process script code associated to a certain public indicator as JavaScript file

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsPublicApi apiInstance = new ProcessScriptsPublicApi(defaultClient);
        String scriptId = "scriptId_example"; // String | unique identifier of the selected script
        try {
            byte[] result = apiInstance.getPublicProcessScriptCode(scriptId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsPublicApi#getPublicProcessScriptCode");
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
| **scriptId** | **String**| unique identifier of the selected script | |

### Return type

**byte[]**

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/javascript


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Invalid status value |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |


## getPublicProcessScriptForScriptId

> ProcessScriptOverviewType getPublicProcessScriptForScriptId(scriptId)

retrieve information about the associated process script for a certain scriptId associated to a public indicator

retrieve information about the associated process script for a certain scriptId associated to a public indicator

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsPublicApi apiInstance = new ProcessScriptsPublicApi(defaultClient);
        String scriptId = "scriptId_example"; // String | unique identifier of the selected script
        try {
            ProcessScriptOverviewType result = apiInstance.getPublicProcessScriptForScriptId(scriptId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsPublicApi#getPublicProcessScriptForScriptId");
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
| **scriptId** | **String**| unique identifier of the selected script | |

### Return type

[**ProcessScriptOverviewType**](ProcessScriptOverviewType.md)

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


## getPublicProcessScripts

> List&lt;ProcessScriptOverviewType&gt; getPublicProcessScripts()

retrieve information about available process scripts associated to public indicators

retrieve information about available process scripts associated to public indicators

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsPublicApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsPublicApi apiInstance = new ProcessScriptsPublicApi(defaultClient);
        try {
            List<ProcessScriptOverviewType> result = apiInstance.getPublicProcessScripts();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsPublicApi#getPublicProcessScripts");
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

[**List&lt;ProcessScriptOverviewType&gt;**](ProcessScriptOverviewType.md)

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


# ScriptPublicControllerApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getProcessScriptCode1**](ScriptPublicControllerApi.md#getProcessScriptCode1) | **GET** /management/public/process-scripts/{scriptId}/scriptCode | retrieve the process script code associated to a certain public indicator as JavaScript file |
| [**getProcessScriptCodeForIndicator1**](ScriptPublicControllerApi.md#getProcessScriptCodeForIndicator1) | **GET** /management/public/process-scripts/usingIndicatorId/{indicatorId}/scriptCode | retrieve the process script code associated to a certain public indicator as JavaScript file |
| [**getProcessScriptForIndicator1**](ScriptPublicControllerApi.md#getProcessScriptForIndicator1) | **GET** /management/public/process-scripts/usingIndicatorId/{indicatorId} | retrieve information about the associated process script for a certain public indicator |
| [**getProcessScriptForScriptId1**](ScriptPublicControllerApi.md#getProcessScriptForScriptId1) | **GET** /management/public/process-scripts/{scriptId} | retrieve information about the associated process script for a certain scriptId associated to a public indicator |
| [**getProcessScripts1**](ScriptPublicControllerApi.md#getProcessScripts1) | **GET** /management/public/process-scripts | retrieve information about available process scripts associated to public indicators |



## getProcessScriptCode1

> byte[] getProcessScriptCode1(scriptId)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptPublicControllerApi apiInstance = new ScriptPublicControllerApi(defaultClient);
        String scriptId = "scriptId_example"; // String | scriptId
        try {
            byte[] result = apiInstance.getProcessScriptCode1(scriptId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptPublicControllerApi#getProcessScriptCode1");
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
| **scriptId** | **String**| scriptId | |

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


## getProcessScriptCodeForIndicator1

> byte[] getProcessScriptCodeForIndicator1(indicatorId)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptPublicControllerApi apiInstance = new ScriptPublicControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        try {
            byte[] result = apiInstance.getProcessScriptCodeForIndicator1(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptPublicControllerApi#getProcessScriptCodeForIndicator1");
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
| **indicatorId** | **String**| indicatorId | |

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


## getProcessScriptForIndicator1

> ProcessScriptOverviewType getProcessScriptForIndicator1(indicatorId)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptPublicControllerApi apiInstance = new ScriptPublicControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        try {
            ProcessScriptOverviewType result = apiInstance.getProcessScriptForIndicator1(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptPublicControllerApi#getProcessScriptForIndicator1");
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
| **indicatorId** | **String**| indicatorId | |

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


## getProcessScriptForScriptId1

> ProcessScriptOverviewType getProcessScriptForScriptId1(scriptId)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptPublicControllerApi apiInstance = new ScriptPublicControllerApi(defaultClient);
        String scriptId = "scriptId_example"; // String | scriptId
        try {
            ProcessScriptOverviewType result = apiInstance.getProcessScriptForScriptId1(scriptId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptPublicControllerApi#getProcessScriptForScriptId1");
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
| **scriptId** | **String**| scriptId | |

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


## getProcessScripts1

> ProcessScriptOverviewType getProcessScripts1()

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
import org.n52.kommonitor.datamanagement.api.client.ScriptPublicControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptPublicControllerApi apiInstance = new ScriptPublicControllerApi(defaultClient);
        try {
            ProcessScriptOverviewType result = apiInstance.getProcessScripts1();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptPublicControllerApi#getProcessScripts1");
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


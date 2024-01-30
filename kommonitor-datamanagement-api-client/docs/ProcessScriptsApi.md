# ProcessScriptsApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addProcessScriptAsBody**](ProcessScriptsApi.md#addProcessScriptAsBody) | **POST** /process-scripts | Register a new process script |
| [**deleteProcessScript**](ProcessScriptsApi.md#deleteProcessScript) | **DELETE** /process-scripts/usingIndicatorId/{indicatorId} | Delete the process script |
| [**deleteProcessScriptByScriptId**](ProcessScriptsApi.md#deleteProcessScriptByScriptId) | **DELETE** /process-scripts/{scriptId} | Delete the process script |
| [**getProcessScriptCode**](ProcessScriptsApi.md#getProcessScriptCode) | **GET** /process-scripts/{scriptId}/scriptCode | retrieve the process script code associated to a certain indicator as JavaScript file |
| [**getProcessScriptCodeForIndicator**](ProcessScriptsApi.md#getProcessScriptCodeForIndicator) | **GET** /process-scripts/usingIndicatorId/{indicatorId}/scriptCode | retrieve the process script code associated to a certain indicator as JavaScript file |
| [**getProcessScriptForIndicator**](ProcessScriptsApi.md#getProcessScriptForIndicator) | **GET** /process-scripts/usingIndicatorId/{indicatorId} | retrieve information about the associated process script for a certain indicator |
| [**getProcessScriptForScriptId**](ProcessScriptsApi.md#getProcessScriptForScriptId) | **GET** /process-scripts/{scriptId} | retrieve information about the associated process script for a certain scriptId |
| [**getProcessScriptTemplate**](ProcessScriptsApi.md#getProcessScriptTemplate) | **GET** /process-scripts/template | retrieve an empty script template, that defines how to implement process scripts for KomMonitor as JavaScript file. |
| [**getProcessScripts**](ProcessScriptsApi.md#getProcessScripts) | **GET** /process-scripts | retrieve information about available process scripts |
| [**updateProcessScriptAsBody**](ProcessScriptsApi.md#updateProcessScriptAsBody) | **PUT** /process-scripts/usingIndicatorId/{indicatorId} | Modify/Update an existing process script |
| [**updateProcessScriptAsBodyByScriptId**](ProcessScriptsApi.md#updateProcessScriptAsBodyByScriptId) | **PUT** /process-scripts/{scriptId} | Modify/Update an existing process script |



## addProcessScriptAsBody

> ProcessScriptOverviewType addProcessScriptAsBody(processScriptData)

Register a new process script

Register a process script associated to a certain indicator

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsApi apiInstance = new ProcessScriptsApi(defaultClient);
        ProcessScriptPOSTInputType processScriptData = new ProcessScriptPOSTInputType(); // ProcessScriptPOSTInputType | details necessary to register the process script
        try {
            ProcessScriptOverviewType result = apiInstance.addProcessScriptAsBody(processScriptData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsApi#addProcessScriptAsBody");
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
| **processScriptData** | [**ProcessScriptPOSTInputType**](ProcessScriptPOSTInputType.md)| details necessary to register the process script | |

### Return type

[**ProcessScriptOverviewType**](ProcessScriptOverviewType.md)

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
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


## deleteProcessScript

> deleteProcessScript(indicatorId)

Delete the process script

Delete the process script associated to the specified indicator

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsApi apiInstance = new ProcessScriptsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        try {
            apiInstance.deleteProcessScript(indicatorId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsApi#deleteProcessScript");
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


## deleteProcessScriptByScriptId

> deleteProcessScriptByScriptId(scriptId)

Delete the process script

Delete the process script associated to the specified scriptId

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsApi apiInstance = new ProcessScriptsApi(defaultClient);
        String scriptId = "scriptId_example"; // String | unique identifier of the selected script
        try {
            apiInstance.deleteProcessScriptByScriptId(scriptId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsApi#deleteProcessScriptByScriptId");
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


## getProcessScriptCode

> byte[] getProcessScriptCode(scriptId)

retrieve the process script code associated to a certain indicator as JavaScript file

retrieve the process script code associated to a certain indicator as JavaScript file

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsApi apiInstance = new ProcessScriptsApi(defaultClient);
        String scriptId = "scriptId_example"; // String | unique identifier of the selected script
        try {
            byte[] result = apiInstance.getProcessScriptCode(scriptId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsApi#getProcessScriptCode");
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


## getProcessScriptCodeForIndicator

> byte[] getProcessScriptCodeForIndicator(indicatorId)

retrieve the process script code associated to a certain indicator as JavaScript file

retrieve the process script code associated to a certain indicator as JavaScript file

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsApi apiInstance = new ProcessScriptsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        try {
            byte[] result = apiInstance.getProcessScriptCodeForIndicator(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsApi#getProcessScriptCodeForIndicator");
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


## getProcessScriptForIndicator

> ProcessScriptOverviewType getProcessScriptForIndicator(indicatorId)

retrieve information about the associated process script for a certain indicator

retrieve information about the associated process script for a certain indicator

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsApi apiInstance = new ProcessScriptsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        try {
            ProcessScriptOverviewType result = apiInstance.getProcessScriptForIndicator(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsApi#getProcessScriptForIndicator");
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


## getProcessScriptForScriptId

> ProcessScriptOverviewType getProcessScriptForScriptId(scriptId)

retrieve information about the associated process script for a certain scriptId

retrieve information about the associated process script for a certain scriptId

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsApi apiInstance = new ProcessScriptsApi(defaultClient);
        String scriptId = "scriptId_example"; // String | unique identifier of the selected script
        try {
            ProcessScriptOverviewType result = apiInstance.getProcessScriptForScriptId(scriptId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsApi#getProcessScriptForScriptId");
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


## getProcessScriptTemplate

> byte[] getProcessScriptTemplate()

retrieve an empty script template, that defines how to implement process scripts for KomMonitor as JavaScript file.

retrieve an empty script template, that defines how to implement process scripts for KomMonitor. The script works as a template for a NodeJS module. Hence, it predefines required methods that are called by the executing processing engine (a NodeJS runtimne environment). As a script developer, those predefined methods have to be implemented. The template contains detailed documentation on how to implement those methods.

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsApi apiInstance = new ProcessScriptsApi(defaultClient);
        try {
            byte[] result = apiInstance.getProcessScriptTemplate();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsApi#getProcessScriptTemplate");
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


## getProcessScripts

> List&lt;ProcessScriptOverviewType&gt; getProcessScripts()

retrieve information about available process scripts

retrieve information about available process scripts

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsApi apiInstance = new ProcessScriptsApi(defaultClient);
        try {
            List<ProcessScriptOverviewType> result = apiInstance.getProcessScripts();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsApi#getProcessScripts");
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


## updateProcessScriptAsBody

> updateProcessScriptAsBody(indicatorId, processScriptData)

Modify/Update an existing process script

Modify/Update an existing process script associated to a certain indicator

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsApi apiInstance = new ProcessScriptsApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
        ProcessScriptPUTInputType processScriptData = new ProcessScriptPUTInputType(); // ProcessScriptPUTInputType | details necessary to modify the process script
        try {
            apiInstance.updateProcessScriptAsBody(indicatorId, processScriptData);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsApi#updateProcessScriptAsBody");
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
| **processScriptData** | [**ProcessScriptPUTInputType**](ProcessScriptPUTInputType.md)| details necessary to modify the process script | |

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
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


## updateProcessScriptAsBodyByScriptId

> updateProcessScriptAsBodyByScriptId(scriptId, processScriptData)

Modify/Update an existing process script

Modify/Update an existing process script associated to a certain scriptId

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ProcessScriptsApi apiInstance = new ProcessScriptsApi(defaultClient);
        String scriptId = "scriptId_example"; // String | unique identifier of the selected script
        ProcessScriptPUTInputType processScriptData = new ProcessScriptPUTInputType(); // ProcessScriptPUTInputType | details necessary to modify the process script
        try {
            apiInstance.updateProcessScriptAsBodyByScriptId(scriptId, processScriptData);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessScriptsApi#updateProcessScriptAsBodyByScriptId");
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
| **processScriptData** | [**ProcessScriptPUTInputType**](ProcessScriptPUTInputType.md)| details necessary to modify the process script | |

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
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


# ScriptControllerApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addProcessScriptAsBody**](ScriptControllerApi.md#addProcessScriptAsBody) | **POST** /management/process-scripts | Register a new process script |
| [**deleteProcessScript**](ScriptControllerApi.md#deleteProcessScript) | **DELETE** /management/process-scripts/usingIndicatorId/{indicatorId} | Delete the process script |
| [**deleteProcessScriptByScriptId**](ScriptControllerApi.md#deleteProcessScriptByScriptId) | **DELETE** /management/process-scripts/{scriptId} | Delete the process script |
| [**getProcessScriptCode**](ScriptControllerApi.md#getProcessScriptCode) | **GET** /management/process-scripts/{scriptId}/scriptCode | retrieve the process script code associated to a certain indicator as JavaScript file |
| [**getProcessScriptCodeForIndicator**](ScriptControllerApi.md#getProcessScriptCodeForIndicator) | **GET** /management/process-scripts/usingIndicatorId/{indicatorId}/scriptCode | retrieve the process script code associated to a certain indicator as JavaScript file |
| [**getProcessScriptForIndicator**](ScriptControllerApi.md#getProcessScriptForIndicator) | **GET** /management/process-scripts/usingIndicatorId/{indicatorId} | retrieve information about the associated process script for a certain indicator |
| [**getProcessScriptForScriptId**](ScriptControllerApi.md#getProcessScriptForScriptId) | **GET** /management/process-scripts/{scriptId} | retrieve information about the associated process script for a certain scriptId |
| [**getProcessScriptTemplate**](ScriptControllerApi.md#getProcessScriptTemplate) | **GET** /management/process-scripts/template | retrieve an empty script template, that defines how to implement process scripts for KomMonitor as JavaScript file. |
| [**getProcessScripts**](ScriptControllerApi.md#getProcessScripts) | **GET** /management/process-scripts | retrieve information about available process scripts |
| [**updateProcessScriptAsBody**](ScriptControllerApi.md#updateProcessScriptAsBody) | **PUT** /management/process-scripts/usingIndicatorId/{indicatorId} | Modify/Update an existing process script |
| [**updateProcessScriptAsBodyByScriptId**](ScriptControllerApi.md#updateProcessScriptAsBodyByScriptId) | **PUT** /management/process-scripts/{scriptId} | Modify/Update an existing process script |



## addProcessScriptAsBody

> ResponseEntity addProcessScriptAsBody(processScriptData)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptControllerApi apiInstance = new ScriptControllerApi(defaultClient);
        ProcessScriptPOSTInputType processScriptData = new ProcessScriptPOSTInputType(); // ProcessScriptPOSTInputType | processScriptData
        try {
            ResponseEntity result = apiInstance.addProcessScriptAsBody(processScriptData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptControllerApi#addProcessScriptAsBody");
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
| **processScriptData** | [**ProcessScriptPOSTInputType**](ProcessScriptPOSTInputType.md)| processScriptData | |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


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

> ResponseEntity deleteProcessScript(indicatorId)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptControllerApi apiInstance = new ScriptControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        try {
            ResponseEntity result = apiInstance.deleteProcessScript(indicatorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptControllerApi#deleteProcessScript");
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

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |


## deleteProcessScriptByScriptId

> ResponseEntity deleteProcessScriptByScriptId(scriptId)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptControllerApi apiInstance = new ScriptControllerApi(defaultClient);
        String scriptId = "scriptId_example"; // String | scriptId
        try {
            ResponseEntity result = apiInstance.deleteProcessScriptByScriptId(scriptId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptControllerApi#deleteProcessScriptByScriptId");
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

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |


## getProcessScriptCode

> byte[] getProcessScriptCode(scriptId, name)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptControllerApi apiInstance = new ScriptControllerApi(defaultClient);
        String scriptId = "scriptId_example"; // String | scriptId
        String name = "name_example"; // String | 
        try {
            byte[] result = apiInstance.getProcessScriptCode(scriptId, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptControllerApi#getProcessScriptCode");
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
| **name** | **String**|  | [optional] |

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

> byte[] getProcessScriptCodeForIndicator(indicatorId, name)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptControllerApi apiInstance = new ScriptControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        String name = "name_example"; // String | 
        try {
            byte[] result = apiInstance.getProcessScriptCodeForIndicator(indicatorId, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptControllerApi#getProcessScriptCodeForIndicator");
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
| **name** | **String**|  | [optional] |

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

> ProcessScriptOverviewType getProcessScriptForIndicator(indicatorId, name)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptControllerApi apiInstance = new ScriptControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        String name = "name_example"; // String | 
        try {
            ProcessScriptOverviewType result = apiInstance.getProcessScriptForIndicator(indicatorId, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptControllerApi#getProcessScriptForIndicator");
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
| **name** | **String**|  | [optional] |

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

> ProcessScriptOverviewType getProcessScriptForScriptId(scriptId, name)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptControllerApi apiInstance = new ScriptControllerApi(defaultClient);
        String scriptId = "scriptId_example"; // String | scriptId
        String name = "name_example"; // String | 
        try {
            ProcessScriptOverviewType result = apiInstance.getProcessScriptForScriptId(scriptId, name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptControllerApi#getProcessScriptForScriptId");
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
| **name** | **String**|  | [optional] |

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
import org.n52.kommonitor.datamanagement.api.client.ScriptControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptControllerApi apiInstance = new ScriptControllerApi(defaultClient);
        try {
            byte[] result = apiInstance.getProcessScriptTemplate();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptControllerApi#getProcessScriptTemplate");
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

> ProcessScriptOverviewType getProcessScripts(name)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptControllerApi apiInstance = new ScriptControllerApi(defaultClient);
        String name = "name_example"; // String | 
        try {
            ProcessScriptOverviewType result = apiInstance.getProcessScripts(name);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptControllerApi#getProcessScripts");
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
| **name** | **String**|  | [optional] |

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


## updateProcessScriptAsBody

> ResponseEntity updateProcessScriptAsBody(indicatorId, processScriptData)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptControllerApi apiInstance = new ScriptControllerApi(defaultClient);
        String indicatorId = "indicatorId_example"; // String | indicatorId
        ProcessScriptPUTInputType processScriptData = new ProcessScriptPUTInputType(); // ProcessScriptPUTInputType | processScriptData
        try {
            ResponseEntity result = apiInstance.updateProcessScriptAsBody(indicatorId, processScriptData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptControllerApi#updateProcessScriptAsBody");
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
| **processScriptData** | [**ProcessScriptPUTInputType**](ProcessScriptPUTInputType.md)| processScriptData | |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


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

> ResponseEntity updateProcessScriptAsBodyByScriptId(scriptId, processScriptData)

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
import org.n52.kommonitor.datamanagement.api.client.ScriptControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        ScriptControllerApi apiInstance = new ScriptControllerApi(defaultClient);
        String scriptId = "scriptId_example"; // String | scriptId
        ProcessScriptPUTInputType processScriptData = new ProcessScriptPUTInputType(); // ProcessScriptPUTInputType | processScriptData
        try {
            ResponseEntity result = apiInstance.updateProcessScriptAsBodyByScriptId(scriptId, processScriptData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScriptControllerApi#updateProcessScriptAsBodyByScriptId");
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
| **processScriptData** | [**ProcessScriptPUTInputType**](ProcessScriptPUTInputType.md)| processScriptData | |

### Return type

[**ResponseEntity**](ResponseEntity.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | Created |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **405** | Invalid input |  -  |


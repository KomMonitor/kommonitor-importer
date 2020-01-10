# ProcessScriptsApi

All URIs are relative to *http://localhost:8085/management*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addProcessScriptAsBody**](ProcessScriptsApi.md#addProcessScriptAsBody) | **POST** /process-scripts | Register a new process script
[**deleteProcessScript**](ProcessScriptsApi.md#deleteProcessScript) | **DELETE** /process-scripts/usingIndicatorId/{indicatorId} | Delete the process script
[**deleteProcessScriptByScriptId**](ProcessScriptsApi.md#deleteProcessScriptByScriptId) | **DELETE** /process-scripts/{scriptId} | Delete the process script
[**getProcessScriptCode**](ProcessScriptsApi.md#getProcessScriptCode) | **GET** /process-scripts/{scriptId}/scriptCode | retrieve the process script code associated to a certain indicator as JavaScript file
[**getProcessScriptCodeForIndicator**](ProcessScriptsApi.md#getProcessScriptCodeForIndicator) | **GET** /process-scripts/usingIndicatorId/{indicatorId}/scriptCode | retrieve the process script code associated to a certain indicator as JavaScript file
[**getProcessScriptForIndicator**](ProcessScriptsApi.md#getProcessScriptForIndicator) | **GET** /process-scripts/usingIndicatorId/{indicatorId} | retrieve information about the associated process script for a certain indicator
[**getProcessScriptForScriptId**](ProcessScriptsApi.md#getProcessScriptForScriptId) | **GET** /process-scripts/{scriptId} | retrieve information about the associated process script for a certain scriptId
[**getProcessScriptTemplate**](ProcessScriptsApi.md#getProcessScriptTemplate) | **GET** /process-scripts/template | retrieve an empty script template, that defines how to implement process scripts for KomMonitor as JavaScript file.
[**getProcessScripts**](ProcessScriptsApi.md#getProcessScripts) | **GET** /process-scripts | retrieve information about available process scripts
[**updateProcessScriptAsBody**](ProcessScriptsApi.md#updateProcessScriptAsBody) | **PUT** /process-scripts/usingIndicatorId/{indicatorId} | Modify/Update an existing process script
[**updateProcessScriptAsBodyByScriptId**](ProcessScriptsApi.md#updateProcessScriptAsBodyByScriptId) | **PUT** /process-scripts/{scriptId} | Modify/Update an existing process script


<a name="addProcessScriptAsBody"></a>
# **addProcessScriptAsBody**
> addProcessScriptAsBody(processScriptData)

Register a new process script

Register a process script associated to a certain indicator

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

ProcessScriptsApi apiInstance = new ProcessScriptsApi();
ProcessScriptPOSTInputType processScriptData = new ProcessScriptPOSTInputType(); // ProcessScriptPOSTInputType | details necessary to register the process script
try {
    apiInstance.addProcessScriptAsBody(processScriptData);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessScriptsApi#addProcessScriptAsBody");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **processScriptData** | [**ProcessScriptPOSTInputType**](ProcessScriptPOSTInputType.md)| details necessary to register the process script |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="deleteProcessScript"></a>
# **deleteProcessScript**
> deleteProcessScript(indicatorId)

Delete the process script

Delete the process script associated to the specified indicator

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

ProcessScriptsApi apiInstance = new ProcessScriptsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
try {
    apiInstance.deleteProcessScript(indicatorId);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessScriptsApi#deleteProcessScript");
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

<a name="deleteProcessScriptByScriptId"></a>
# **deleteProcessScriptByScriptId**
> deleteProcessScriptByScriptId(scriptId)

Delete the process script

Delete the process script associated to the specified scriptId

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

ProcessScriptsApi apiInstance = new ProcessScriptsApi();
String scriptId = "scriptId_example"; // String | unique identifier of the selected script
try {
    apiInstance.deleteProcessScriptByScriptId(scriptId);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessScriptsApi#deleteProcessScriptByScriptId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scriptId** | **String**| unique identifier of the selected script |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getProcessScriptCode"></a>
# **getProcessScriptCode**
> byte[] getProcessScriptCode(scriptId)

retrieve the process script code associated to a certain indicator as JavaScript file

retrieve the process script code associated to a certain indicator as JavaScript file

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

ProcessScriptsApi apiInstance = new ProcessScriptsApi();
String scriptId = "scriptId_example"; // String | unique identifier of the selected script
try {
    byte[] result = apiInstance.getProcessScriptCode(scriptId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessScriptsApi#getProcessScriptCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scriptId** | **String**| unique identifier of the selected script |

### Return type

**byte[]**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/javascript

<a name="getProcessScriptCodeForIndicator"></a>
# **getProcessScriptCodeForIndicator**
> byte[] getProcessScriptCodeForIndicator(indicatorId)

retrieve the process script code associated to a certain indicator as JavaScript file

retrieve the process script code associated to a certain indicator as JavaScript file

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

ProcessScriptsApi apiInstance = new ProcessScriptsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
try {
    byte[] result = apiInstance.getProcessScriptCodeForIndicator(indicatorId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessScriptsApi#getProcessScriptCodeForIndicator");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |

### Return type

**byte[]**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/javascript

<a name="getProcessScriptForIndicator"></a>
# **getProcessScriptForIndicator**
> ProcessScriptOverviewType getProcessScriptForIndicator(indicatorId)

retrieve information about the associated process script for a certain indicator

retrieve information about the associated process script for a certain indicator

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

ProcessScriptsApi apiInstance = new ProcessScriptsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
try {
    ProcessScriptOverviewType result = apiInstance.getProcessScriptForIndicator(indicatorId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessScriptsApi#getProcessScriptForIndicator");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |

### Return type

[**ProcessScriptOverviewType**](ProcessScriptOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getProcessScriptForScriptId"></a>
# **getProcessScriptForScriptId**
> ProcessScriptOverviewType getProcessScriptForScriptId(scriptId)

retrieve information about the associated process script for a certain scriptId

retrieve information about the associated process script for a certain scriptId

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

ProcessScriptsApi apiInstance = new ProcessScriptsApi();
String scriptId = "scriptId_example"; // String | unique identifier of the selected script
try {
    ProcessScriptOverviewType result = apiInstance.getProcessScriptForScriptId(scriptId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessScriptsApi#getProcessScriptForScriptId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scriptId** | **String**| unique identifier of the selected script |

### Return type

[**ProcessScriptOverviewType**](ProcessScriptOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getProcessScriptTemplate"></a>
# **getProcessScriptTemplate**
> byte[] getProcessScriptTemplate()

retrieve an empty script template, that defines how to implement process scripts for KomMonitor as JavaScript file.

retrieve an empty script template, that defines how to implement process scripts for KomMonitor. The script works as a template for a NodeJS module. Hence, it predefines required methods that are called by the executing processing engine (a NodeJS runtimne environment). As a script developer, those predefined methods have to be implemented. The template contains detailed documentation on how to implement those methods.

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

ProcessScriptsApi apiInstance = new ProcessScriptsApi();
try {
    byte[] result = apiInstance.getProcessScriptTemplate();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessScriptsApi#getProcessScriptTemplate");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**byte[]**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/javascript

<a name="getProcessScripts"></a>
# **getProcessScripts**
> List&lt;ProcessScriptOverviewType&gt; getProcessScripts()

retrieve information about available process scripts

retrieve information about available process scripts

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

ProcessScriptsApi apiInstance = new ProcessScriptsApi();
try {
    List<ProcessScriptOverviewType> result = apiInstance.getProcessScripts();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessScriptsApi#getProcessScripts");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;ProcessScriptOverviewType&gt;**](ProcessScriptOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateProcessScriptAsBody"></a>
# **updateProcessScriptAsBody**
> updateProcessScriptAsBody(indicatorId, processScriptData)

Modify/Update an existing process script

Modify/Update an existing process script associated to a certain indicator

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

ProcessScriptsApi apiInstance = new ProcessScriptsApi();
String indicatorId = "indicatorId_example"; // String | unique identifier of the selected indicator dataset
ProcessScriptPUTInputType processScriptData = new ProcessScriptPUTInputType(); // ProcessScriptPUTInputType | details necessary to modify the process script
try {
    apiInstance.updateProcessScriptAsBody(indicatorId, processScriptData);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessScriptsApi#updateProcessScriptAsBody");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indicatorId** | **String**| unique identifier of the selected indicator dataset |
 **processScriptData** | [**ProcessScriptPUTInputType**](ProcessScriptPUTInputType.md)| details necessary to modify the process script |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateProcessScriptAsBodyByScriptId"></a>
# **updateProcessScriptAsBodyByScriptId**
> updateProcessScriptAsBodyByScriptId(scriptId, processScriptData)

Modify/Update an existing process script

Modify/Update an existing process script associated to a certain scriptId

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.ProcessScriptsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

ProcessScriptsApi apiInstance = new ProcessScriptsApi();
String scriptId = "scriptId_example"; // String | unique identifier of the selected script
ProcessScriptPUTInputType processScriptData = new ProcessScriptPUTInputType(); // ProcessScriptPUTInputType | details necessary to modify the process script
try {
    apiInstance.updateProcessScriptAsBodyByScriptId(scriptId, processScriptData);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessScriptsApi#updateProcessScriptAsBodyByScriptId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scriptId** | **String**| unique identifier of the selected script |
 **processScriptData** | [**ProcessScriptPUTInputType**](ProcessScriptPUTInputType.md)| details necessary to modify the process script |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


# RolesApi

All URIs are relative to *http://localhost:8085/management*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRole**](RolesApi.md#addRole) | **POST** /roles | Register a new role
[**deleteRole**](RolesApi.md#deleteRole) | **DELETE** /roles/{roleId} | Delete the role
[**getRoleById**](RolesApi.md#getRoleById) | **GET** /roles/{roleId} | retrieve information about the selected role
[**getRoles**](RolesApi.md#getRoles) | **GET** /roles | retrieve information about available roles
[**updateRole**](RolesApi.md#updateRole) | **PUT** /roles/{roleId} | Modify role information


<a name="addRole"></a>
# **addRole**
> addRole(roleData)

Register a new role

Add/Register a role

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.RolesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RolesApi apiInstance = new RolesApi();
RoleInputType roleData = new RoleInputType(); // RoleInputType | role input data
try {
    apiInstance.addRole(roleData);
} catch (ApiException e) {
    System.err.println("Exception when calling RolesApi#addRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleData** | [**RoleInputType**](RoleInputType.md)| role input data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="deleteRole"></a>
# **deleteRole**
> deleteRole(roleId)

Delete the role

Delete the role

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.RolesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RolesApi apiInstance = new RolesApi();
String roleId = "roleId_example"; // String | unique identifier of the role
try {
    apiInstance.deleteRole(roleId);
} catch (ApiException e) {
    System.err.println("Exception when calling RolesApi#deleteRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleId** | **String**| unique identifier of the role |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getRoleById"></a>
# **getRoleById**
> RoleOverviewType getRoleById(roleId)

retrieve information about the selected role

retrieve information about the selected role

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.RolesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RolesApi apiInstance = new RolesApi();
String roleId = "roleId_example"; // String | unique identifier of the role
try {
    RoleOverviewType result = apiInstance.getRoleById(roleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RolesApi#getRoleById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleId** | **String**| unique identifier of the role |

### Return type

[**RoleOverviewType**](RoleOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRoles"></a>
# **getRoles**
> List&lt;RoleOverviewType&gt; getRoles()

retrieve information about available roles

retrieve information about available roles

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.RolesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RolesApi apiInstance = new RolesApi();
try {
    List<RoleOverviewType> result = apiInstance.getRoles();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RolesApi#getRoles");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;RoleOverviewType&gt;**](RoleOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateRole"></a>
# **updateRole**
> updateRole(roleId, roleData)

Modify role information

Modify role information

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.RolesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

RolesApi apiInstance = new RolesApi();
String roleId = "roleId_example"; // String | unique identifier of the role
RoleInputType roleData = new RoleInputType(); // RoleInputType | role input data
try {
    apiInstance.updateRole(roleId, roleData);
} catch (ApiException e) {
    System.err.println("Exception when calling RolesApi#updateRole");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **roleId** | **String**| unique identifier of the role |
 **roleData** | [**RoleInputType**](RoleInputType.md)| role input data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


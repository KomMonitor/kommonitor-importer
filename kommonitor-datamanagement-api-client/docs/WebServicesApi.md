# WebServicesApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addWebServiceAsBody**](WebServicesApi.md#addWebServiceAsBody) | **POST** /web-services | Add a new web service |
| [**deleteWebServiceById**](WebServicesApi.md#deleteWebServiceById) | **DELETE** /web-services/{webServiceId} | Delete the metadata of a certain web service |
| [**getWebServiceById**](WebServicesApi.md#getWebServiceById) | **GET** /web-services/{webServiceId} | retrieve information about a certain web service |
| [**getWebServicePermissionsById**](WebServicesApi.md#getWebServicePermissionsById) | **GET** /web-services/{webServiceId}/permissions | retrieve information about the permissions for the selected web service |
| [**getWebServices**](WebServicesApi.md#getWebServices) | **GET** /web-services | retrieve information about available web services |
| [**updateWebServiceMetadataAsBody**](WebServicesApi.md#updateWebServiceMetadataAsBody) | **PUT** /web-services/{webServiceId} | Modify/Update the metadata of a web service |
| [**updateWebServiceOwnership**](WebServicesApi.md#updateWebServiceOwnership) | **PUT** /web-services/{webServiceId}/ownership | update the ownership for the selected web service |
| [**updateWebServicePermissions**](WebServicesApi.md#updateWebServicePermissions) | **PUT** /web-services/{webServiceId}/permissions | update the permissions for the selected web service dataset |



## addWebServiceAsBody

> WebServiceOverviewType addWebServiceAsBody(webServiceCreationType)

Add a new web service

Add/Register a web service that provides georesources or indicators data

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.WebServicesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");

        WebServicesApi apiInstance = new WebServicesApi(defaultClient);
        WebServiceCreationType webServiceCreationType = new WebServiceCreationType(); // WebServiceCreationType | web service metadata
        try {
            WebServiceOverviewType result = apiInstance.addWebServiceAsBody(webServiceCreationType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebServicesApi#addWebServiceAsBody");
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
| **webServiceCreationType** | [**WebServiceCreationType**](WebServiceCreationType.md)| web service metadata | |

### Return type

[**WebServiceOverviewType**](WebServiceOverviewType.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | Created |  -  |


## deleteWebServiceById

> deleteWebServiceById(webServiceId)

Delete the metadata of a certain web service

Delete the metadata of a certain web service

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.WebServicesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        WebServicesApi apiInstance = new WebServicesApi(defaultClient);
        String webServiceId = "webServiceId_example"; // String | identifier of the web service metadata entry
        try {
            apiInstance.deleteWebServiceById(webServiceId);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebServicesApi#deleteWebServiceById");
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


## getWebServiceById

> WebServiceOverviewType getWebServiceById(webServiceId)

retrieve information about a certain web service

retrieve information about a certain web service

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.WebServicesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        WebServicesApi apiInstance = new WebServicesApi(defaultClient);
        String webServiceId = "webServiceId_example"; // String | identifier of the web service metadata entry
        try {
            WebServiceOverviewType result = apiInstance.getWebServiceById(webServiceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebServicesApi#getWebServiceById");
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


## getWebServicePermissionsById

> List&lt;PermissionLevelType&gt; getWebServicePermissionsById(webServiceId)

retrieve information about the permissions for the selected web service

retrieve information about the permissions for the selected web service

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.WebServicesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        WebServicesApi apiInstance = new WebServicesApi(defaultClient);
        String webServiceId = "webServiceId_example"; // String | identifier of the web service dataset
        try {
            List<PermissionLevelType> result = apiInstance.getWebServicePermissionsById(webServiceId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebServicesApi#getWebServicePermissionsById");
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
| **webServiceId** | **String**| identifier of the web service dataset | |

### Return type

[**List&lt;PermissionLevelType&gt;**](PermissionLevelType.md)

### Authorization

[kommonitor-data-access_oauth](../README.md#kommonitor-data-access_oauth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getWebServices

> List&lt;WebServiceOverviewType&gt; getWebServices(resourceType)

retrieve information about available web services

retrieve information about available web services

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.WebServicesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        WebServicesApi apiInstance = new WebServicesApi(defaultClient);
        String resourceType = "indicator"; // String | Controls whether only web services for indicators or georesources should be returned. Supported values are ['georesource', 'indicator']
        try {
            List<WebServiceOverviewType> result = apiInstance.getWebServices(resourceType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebServicesApi#getWebServices");
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


## updateWebServiceMetadataAsBody

> updateWebServiceMetadataAsBody(webServiceId, webServiceData)

Modify/Update the metadata of a web service

Modify/Update the metadata of a web service

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.WebServicesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        WebServicesApi apiInstance = new WebServicesApi(defaultClient);
        String webServiceId = "webServiceId_example"; // String | identifier of the web service metadata entry
        WebServiceType webServiceData = new WebServiceType(); // WebServiceType | feature data
        try {
            apiInstance.updateWebServiceMetadataAsBody(webServiceId, webServiceData);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebServicesApi#updateWebServiceMetadataAsBody");
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
| **webServiceData** | [**WebServiceType**](WebServiceType.md)| feature data | |

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


## updateWebServiceOwnership

> updateWebServiceOwnership(webServiceId, ownerInputType)

update the ownership for the selected web service

update the ownership for the selected web service

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.WebServicesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        WebServicesApi apiInstance = new WebServicesApi(defaultClient);
        String webServiceId = "webServiceId_example"; // String | identifier of the web service dataset
        OwnerInputType ownerInputType = new OwnerInputType(); // OwnerInputType | Web service ownership input
        try {
            apiInstance.updateWebServiceOwnership(webServiceId, ownerInputType);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebServicesApi#updateWebServiceOwnership");
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
| **webServiceId** | **String**| identifier of the web service dataset | |
| **ownerInputType** | [**OwnerInputType**](OwnerInputType.md)| Web service ownership input | [optional] |

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
| **204** | No Content |  -  |


## updateWebServicePermissions

> updateWebServicePermissions(webServiceId, permissionLevelInputType)

update the permissions for the selected web service dataset

update the permissions for the selected web service dataset

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.WebServicesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        WebServicesApi apiInstance = new WebServicesApi(defaultClient);
        String webServiceId = "webServiceId_example"; // String | identifier of the web service dataset
        PermissionLevelInputType permissionLevelInputType = new PermissionLevelInputType(); // PermissionLevelInputType | Web service permission level input
        try {
            apiInstance.updateWebServicePermissions(webServiceId, permissionLevelInputType);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebServicesApi#updateWebServicePermissions");
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
| **webServiceId** | **String**| identifier of the web service dataset | |
| **permissionLevelInputType** | [**PermissionLevelInputType**](PermissionLevelInputType.md)| Web service permission level input | [optional] |

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
| **204** | No Content |  -  |


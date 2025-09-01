# UserInfoApi

All URIs are relative to *http://localhost:8085*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addUserInfo**](UserInfoApi.md#addUserInfo) | **POST** /userInfos | Register new additional information about a user |
| [**deleteUserInfo**](UserInfoApi.md#deleteUserInfo) | **DELETE** /userInfos/{userId} | Delete additional information of a user |
| [**getUserInfoById**](UserInfoApi.md#getUserInfoById) | **GET** /userInfos/{userId} | Retrieve additional information about a user |
| [**getUserInfoForUser**](UserInfoApi.md#getUserInfoForUser) | **GET** /userInfos/user | Retrieve additional information about the current user |
| [**getUserInfos**](UserInfoApi.md#getUserInfos) | **GET** /userInfos | Retrieve additional information about registered users such as favourite lists |
| [**updateUserInfo**](UserInfoApi.md#updateUserInfo) | **PUT** /userInfos/{userId} | Modify/Update additional information of a user |
| [**updateUserInfoPartially**](UserInfoApi.md#updateUserInfoPartially) | **PATCH** /userInfos/{userId} | Modify/Update additional information of a user in parts |



## addUserInfo

> UserInfoOverviewType addUserInfo(userInfoInputType)

Register new additional information about a user

Register new additional information about a user

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.UserInfoApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        UserInfoApi apiInstance = new UserInfoApi(defaultClient);
        UserInfoInputType userInfoInputType = new UserInfoInputType(); // UserInfoInputType | user info data
        try {
            UserInfoOverviewType result = apiInstance.addUserInfo(userInfoInputType);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserInfoApi#addUserInfo");
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
| **userInfoInputType** | [**UserInfoInputType**](UserInfoInputType.md)| user info data | |

### Return type

[**UserInfoOverviewType**](UserInfoOverviewType.md)

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


## deleteUserInfo

> deleteUserInfo(userId)

Delete additional information of a user

Delete additional information of a user

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.UserInfoApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        UserInfoApi apiInstance = new UserInfoApi(defaultClient);
        String userId = "userId_example"; // String | identifier of the user information
        try {
            apiInstance.deleteUserInfo(userId);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserInfoApi#deleteUserInfo");
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
| **userId** | **String**| identifier of the user information | |

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


## getUserInfoById

> UserInfoOverviewType getUserInfoById(userId)

Retrieve additional information about a user

Retrieve additional information about a user

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.UserInfoApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        UserInfoApi apiInstance = new UserInfoApi(defaultClient);
        String userId = "userId_example"; // String | User info ID
        try {
            UserInfoOverviewType result = apiInstance.getUserInfoById(userId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserInfoApi#getUserInfoById");
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
| **userId** | **String**| User info ID | |

### Return type

[**UserInfoOverviewType**](UserInfoOverviewType.md)

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


## getUserInfoForUser

> UserInfoOverviewType getUserInfoForUser()

Retrieve additional information about the current user

Retrieve additional information about the current user

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.UserInfoApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        UserInfoApi apiInstance = new UserInfoApi(defaultClient);
        try {
            UserInfoOverviewType result = apiInstance.getUserInfoForUser();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserInfoApi#getUserInfoForUser");
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

[**UserInfoOverviewType**](UserInfoOverviewType.md)

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


## getUserInfos

> List&lt;UserInfoOverviewType&gt; getUserInfos()

Retrieve additional information about registered users such as favourite lists

Retrieve additional information about registered users such as favourite lists

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.UserInfoApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        UserInfoApi apiInstance = new UserInfoApi(defaultClient);
        try {
            List<UserInfoOverviewType> result = apiInstance.getUserInfos();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserInfoApi#getUserInfos");
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

[**List&lt;UserInfoOverviewType&gt;**](UserInfoOverviewType.md)

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


## updateUserInfo

> UserInfoOverviewType updateUserInfo(userId, userInfoData)

Modify/Update additional information of a user

Modify/Update additional information of a user

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.UserInfoApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        UserInfoApi apiInstance = new UserInfoApi(defaultClient);
        String userId = "userId_example"; // String | identifier of the user information
        UserInfoInputType userInfoData = new UserInfoInputType(); // UserInfoInputType | user info data
        try {
            UserInfoOverviewType result = apiInstance.updateUserInfo(userId, userInfoData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserInfoApi#updateUserInfo");
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
| **userId** | **String**| identifier of the user information | |
| **userInfoData** | [**UserInfoInputType**](UserInfoInputType.md)| user info data | |

### Return type

[**UserInfoOverviewType**](UserInfoOverviewType.md)

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
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **405** | Invalid input |  -  |


## updateUserInfoPartially

> UserInfoOverviewType updateUserInfoPartially(userId, userInfoData)

Modify/Update additional information of a user in parts

Modify/Update additional information of a user in parts

### Example

```java
// Import classes:
import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.n52.kommonitor.datamanagement.api.ApiException;
import org.n52.kommonitor.datamanagement.api.Configuration;
import org.n52.kommonitor.datamanagement.api.auth.*;
import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.datamanagement.api.client.UserInfoApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8085");
        
        // Configure OAuth2 access token for authorization: kommonitor-data-access_oauth
        OAuth kommonitor-data-access_oauth = (OAuth) defaultClient.getAuthentication("kommonitor-data-access_oauth");
        kommonitor-data-access_oauth.setAccessToken("YOUR ACCESS TOKEN");

        UserInfoApi apiInstance = new UserInfoApi(defaultClient);
        String userId = "userId_example"; // String | identifier of the user information
        UserInfoInputType userInfoData = new UserInfoInputType(); // UserInfoInputType | user info data
        try {
            UserInfoOverviewType result = apiInstance.updateUserInfoPartially(userId, userInfoData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UserInfoApi#updateUserInfoPartially");
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
| **userId** | **String**| identifier of the user information | |
| **userInfoData** | [**UserInfoInputType**](UserInfoInputType.md)| user info data | |

### Return type

[**UserInfoOverviewType**](UserInfoOverviewType.md)

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
| **204** | No Content |  -  |
| **401** | API key is missing or invalid |  -  |
| **403** | Forbidden |  -  |
| **405** | Invalid input |  -  |


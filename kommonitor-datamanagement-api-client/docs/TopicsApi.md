# TopicsApi

All URIs are relative to *http://localhost:8085/management*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addTopic**](TopicsApi.md#addTopic) | **POST** /topics | Register a new topic
[**deleteTopic**](TopicsApi.md#deleteTopic) | **DELETE** /topics/{topicId} | Delete the topic
[**getTopicById**](TopicsApi.md#getTopicById) | **GET** /topics/{topicId} | retrieve information about the selected topic
[**getTopics**](TopicsApi.md#getTopics) | **GET** /topics | retrieve information about available topics
[**updateTopic**](TopicsApi.md#updateTopic) | **PUT** /topics/{topicId} | Modify topic information


<a name="addTopic"></a>
# **addTopic**
> addTopic(topicData)

Register a new topic

Add/Register a topic

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.TopicsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

TopicsApi apiInstance = new TopicsApi();
TopicInputType topicData = new TopicInputType(); // TopicInputType | topic input data
try {
    apiInstance.addTopic(topicData);
} catch (ApiException e) {
    System.err.println("Exception when calling TopicsApi#addTopic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **topicData** | [**TopicInputType**](TopicInputType.md)| topic input data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="deleteTopic"></a>
# **deleteTopic**
> deleteTopic(topicId)

Delete the topic

Delete the topic

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.TopicsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

TopicsApi apiInstance = new TopicsApi();
String topicId = "topicId_example"; // String | unique identifier of the topic
try {
    apiInstance.deleteTopic(topicId);
} catch (ApiException e) {
    System.err.println("Exception when calling TopicsApi#deleteTopic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **topicId** | **String**| unique identifier of the topic |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getTopicById"></a>
# **getTopicById**
> TopicOverviewType getTopicById(topicId)

retrieve information about the selected topic

retrieve information about the selected topic

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.TopicsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

TopicsApi apiInstance = new TopicsApi();
String topicId = "topicId_example"; // String | unique identifier of the topic
try {
    TopicOverviewType result = apiInstance.getTopicById(topicId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopicsApi#getTopicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **topicId** | **String**| unique identifier of the topic |

### Return type

[**TopicOverviewType**](TopicOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTopics"></a>
# **getTopics**
> List&lt;TopicOverviewType&gt; getTopics()

retrieve information about available topics

retrieve information about available topics

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.TopicsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

TopicsApi apiInstance = new TopicsApi();
try {
    List<TopicOverviewType> result = apiInstance.getTopics();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopicsApi#getTopics");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;TopicOverviewType&gt;**](TopicOverviewType.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateTopic"></a>
# **updateTopic**
> updateTopic(topicId, topicData)

Modify topic information

Modify topic information

### Example
```java
// Import classes:
//import org.n52.kommonitor.datamanagement.api.ApiClient;
//import org.n52.kommonitor.datamanagement.api.ApiException;
//import org.n52.kommonitor.datamanagement.api.Configuration;
//import org.n52.kommonitor.datamanagement.api.auth.*;
//import org.n52.kommonitor.datamanagement.api.client.TopicsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: basicAuth
HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
basicAuth.setUsername("YOUR USERNAME");
basicAuth.setPassword("YOUR PASSWORD");

TopicsApi apiInstance = new TopicsApi();
String topicId = "topicId_example"; // String | unique identifier of the topic
TopicInputType topicData = new TopicInputType(); // TopicInputType | topic input data
try {
    apiInstance.updateTopic(topicId, topicData);
} catch (ApiException e) {
    System.err.println("Exception when calling TopicsApi#updateTopic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **topicId** | **String**| unique identifier of the topic |
 **topicData** | [**TopicInputType**](TopicInputType.md)| topic input data |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


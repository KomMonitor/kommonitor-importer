
# TopicInputType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**topicName** | **String** | the topic name | 
**topicDescription** | **String** | short description of the topic | 
**topicType** | [**TopicTypeEnum**](#TopicTypeEnum) | topic type indicating if the topic object is a subtopic or a main topic - only topics of type &#39;sub&#39; shall be subTopics of topics with type &#39;main&#39; | 
**subTopics** | [**List&lt;TopicInputType&gt;**](TopicInputType.md) | optional list of subTopics |  [optional]


<a name="TopicTypeEnum"></a>
## Enum: TopicTypeEnum
Name | Value
---- | -----
MAIN | &quot;main&quot;
SUB | &quot;sub&quot;




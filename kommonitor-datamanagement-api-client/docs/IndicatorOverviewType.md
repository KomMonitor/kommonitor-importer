
# IndicatorOverviewType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**indicatorName** | **String** | name of the indicator | 
**characteristicValue** | **String** | the distuingishing characteristic value of the indicator | 
**indicatorId** | **String** | unique identifier of this resource | 
**indicatorType** | [**IndicatorTypeEnum**](#IndicatorTypeEnum) | indicates whether the indicator is a status indicator (values represent the extent of the watched phenomenon for a certain point in time) or a dynamic indicator (values represent the change of extent of the watched phenomenon within a certain period of time) |  [optional]
**unit** | **String** | unit of the indicator values | 
**metadata** | [**CommonMetadataType**](CommonMetadataType.md) |  | 
**processDescription** | **String** | description about how the indicator was computed | 
**applicableSpatialUnits** | **List&lt;String&gt;** | array of spatial unit levels for which the dataset is applicable | 
**applicableDates** | **List&lt;String&gt;** | array of applicable dates (year and month and day as YEAR-MONTH-DAY) according to ISO 8601 (e.g. 2018-01-30) | 
**topicReference** | **String** | id of the last topic hierarchy entity  | 
**allowedRoles** | **List&lt;String&gt;** | list of role identifiers that have read access rights for this dataset |  [optional]
**referencedIndicators** | [**List&lt;IndicatorReferenceType&gt;**](IndicatorReferenceType.md) | list of references to other indicators |  [optional]
**referencedGeoresources** | [**List&lt;GeoresourceReferenceType&gt;**](GeoresourceReferenceType.md) | list of references to georesources |  [optional]
**creationType** | [**CreationTypeEnum**](#CreationTypeEnum) | indicates if the data is simply inserted (INSERTION), computed by an automated script (COMPUTATION) or automatically aggregated by a script (AGGREGATION) | 
**lowestSpatialUnitForComputation** | **String** | identifier/name of the lowest spatial unit for which the indicator can be computed and thus is available (only necessary for computable indicators) |  [optional]
**defaultClassificationMapping** | [**DefaultClassificationMappingType**](DefaultClassificationMappingType.md) |  |  [optional]
**ogcServices** | [**List&lt;OgcServicesType&gt;**](OgcServicesType.md) | list of available OGC services for that indicator for different spatial units | 
**abbreviation** | **String** | abbreviated mark of the indicator | 
**interpretation** | **String** | interpretation of the indicator values | 
**isHeadlineIndicator** | **Boolean** | boolean value indicating if the indicator is a headline indicator | 
**tags** | **List&lt;String&gt;** | list of tag labels for the indicator | 


<a name="IndicatorTypeEnum"></a>
## Enum: IndicatorTypeEnum
Name | Value
---- | -----
STATUS_ABSOLUTE | &quot;STATUS_ABSOLUTE&quot;
DYNAMIC_ABSOLUTE | &quot;DYNAMIC_ABSOLUTE&quot;
STATUS_RELATIVE | &quot;STATUS_RELATIVE&quot;
DYNAMIC_RELATIVE | &quot;DYNAMIC_RELATIVE&quot;
STATUS_STANDARDIZED | &quot;STATUS_STANDARDIZED&quot;
DYNAMIC_STANDARDIZED | &quot;DYNAMIC_STANDARDIZED&quot;


<a name="CreationTypeEnum"></a>
## Enum: CreationTypeEnum
Name | Value
---- | -----
INSERTION | &quot;INSERTION&quot;
COMPUTATION | &quot;COMPUTATION&quot;
AGGREGATION | &quot;AGGREGATION&quot;




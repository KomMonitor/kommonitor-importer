
# IndicatorPOSTInputType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**datasetName** | **String** | the meaningful name of the indicator | 
**characteristicValue** | **String** | the distuingishing characteristic value of the indicator |  [optional]
**indicatorType** | [**IndicatorTypeEnum**](#IndicatorTypeEnum) | indicates whether the indicator is a status indicator (values represent the extent of the watched phenomenon for a certain point in time) or a dynamic indicator (values represent the change of extent of the watched phenomenon within a certain period of time) |  [optional]
**applicableSpatialUnit** | **String** | identifier/name of the spatial unit level | 
**topicReference** | **String** | id of the last topic hierarchy entity  | 
**metadata** | [**CommonMetadataType**](CommonMetadataType.md) |  | 
**processDescription** | **String** | description about how the indicator was computed | 
**unit** | **String** | unit of the indicator values | 
**creationType** | [**CreationTypeEnum**](#CreationTypeEnum) | indicates if the data is simply inserted (INSERTION), computed by an automated script (COMPUTATION) or automatically aggregated by a script (AGGREGATION) | 
**abbreviation** | **String** | abbreviated mark of the indicator |  [optional]
**interpretation** | **String** | interpretation of the indicator values | 
**isHeadlineIndicator** | **Boolean** | boolean value indicating if the indicator is a headline indicator | 
**tags** | **List&lt;String&gt;** | list of tag labels for the indicator |  [optional]
**lowestSpatialUnitForComputation** | **String** | identifier/name of the lowest spatial unit for which the indicator can be computed and thus is available (only necessary for computable indicators) |  [optional]
**defaultClassificationMapping** | [**DefaultClassificationMappingType**](DefaultClassificationMappingType.md) |  | 
**allowedRoles** | **List&lt;String&gt;** | list of role identifiers that have read access rights for this dataset |  [optional]
**refrencesToOtherIndicators** | [**List&lt;IndicatorPOSTInputTypeRefrencesToOtherIndicators&gt;**](IndicatorPOSTInputTypeRefrencesToOtherIndicators.md) | array of references to other indicators. E.g., if an indicator is defined by combining four other indicators, then the identifiers of those other indicators can be referenced here |  [optional]
**refrencesToGeoresources** | [**List&lt;IndicatorPOSTInputTypeRefrencesToGeoresources&gt;**](IndicatorPOSTInputTypeRefrencesToGeoresources.md) | array of references to other georesource datasets. E.g., if an indicator is defined by performing geometric-topological operations, then the identifiers of those required georesources can be referenced here |  [optional]
**indicatorValues** | [**List&lt;IndicatorPOSTInputTypeIndicatorValues&gt;**](IndicatorPOSTInputTypeIndicatorValues.md) | an array of entries containing indicator values and mapping to spatial features via identifiers |  [optional]


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




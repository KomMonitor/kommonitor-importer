
# ProcessInputType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | the name of the process input parameter | 
**description** | **String** | a short description of the process input | 
**dataType** | [**DataTypeEnum**](#DataTypeEnum) | the data type of the process input | 
**defaultValue** | **String** | the default value of the process parameter | 
**maxParameterValueForNumericInputs** | [**BigDecimal**](BigDecimal.md) | the maximum value that is allowed for the process parameter |  [optional]
**minParameterValueForNumericInputs** | [**BigDecimal**](BigDecimal.md) | the minimum value that is allowed for the process parameter |  [optional]


<a name="DataTypeEnum"></a>
## Enum: DataTypeEnum
Name | Value
---- | -----
STRING | &quot;string&quot;
BOOLEAN | &quot;boolean&quot;
INTEGER | &quot;integer&quot;
DOUBLE | &quot;double&quot;




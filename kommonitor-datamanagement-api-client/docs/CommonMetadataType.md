
# CommonMetadataType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | description of the dataset | 
**sridEPSG** | [**BigDecimal**](BigDecimal.md) | the coordinate reference system of the dataset as EPSG code | 
**datasource** | **String** | information about the origin/source of the dataset | 
**databasis** | **String** | information about data used as a basis to generate the dataset |  [optional]
**note** | **String** | an optional note with background information about the dataset |  [optional]
**literature** | **String** | an optional hint to literature about the dataset (e.g. URL or book/article name) |  [optional]
**contact** | **String** | contact details where additional information can be achieved | 
**lastUpdate** | [**LocalDate**](LocalDate.md) | a timestamp representing the lastUpdate according to ISO 8601 (e.g. 2018-01-30) |  [optional]
**updateInterval** | [**UpdateIntervalEnum**](#UpdateIntervalEnum) |  | 


<a name="UpdateIntervalEnum"></a>
## Enum: UpdateIntervalEnum
Name | Value
---- | -----
ARBITRARY | &quot;ARBITRARY&quot;
MONTHLY | &quot;MONTHLY&quot;
QUARTERLY | &quot;QUARTERLY&quot;
HALF_YEARLY | &quot;HALF_YEARLY&quot;
YEARLY | &quot;YEARLY&quot;




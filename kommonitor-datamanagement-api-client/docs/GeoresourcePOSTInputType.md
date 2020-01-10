
# GeoresourcePOSTInputType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**datasetName** | **String** | the meaningful name of the dataset | 
**periodOfValidity** | [**PeriodOfValidityType**](PeriodOfValidityType.md) |  | 
**metadata** | [**CommonMetadataType**](CommonMetadataType.md) |  | 
**allowedRoles** | **List&lt;String&gt;** | list of role identifiers that have read access rights for this dataset |  [optional]
**topicReference** | **String** | id of the last topic hierarchy entity |  [optional]
**isPOI** | **Boolean** | boolean value indicating if the dataset contains points of interest |  [optional]
**isLOI** | **Boolean** | boolean value indicating if the dataset contains lines of interest |  [optional]
**isAOI** | **Boolean** | boolean value indicating if the dataset contains areas of interest |  [optional]
**loiColor** | **String** | color name or color code (i.e. hex number) for lines of interest |  [optional]
**loiDashArrayString** | **String** | sring of line stroke dash array for lines of interest (e.g. 20,20; see https://developer.mozilla.org/de/docs/Web/SVG/Attribute/stroke-dasharray) |  [optional]
**aoiColor** | **String** | color name or color code (i.e. hex number) for areas of interest |  [optional]
**poiSymbolBootstrap3Name** | **String** | If georesource is a POI then custom POI marker symbol can be set by specifying the name of a Bootstrap 3 glyphicon symbol (i.e. \&quot;home\&quot; for a home symbol or \&quot;education\&quot; for a students hat symbol) |  [optional]
**poiMarkerColor** | [**PoiMarkerColorEnum**](#PoiMarkerColorEnum) | If georesource is a POI then custom POI marker color can be set by specifying one of the following color names |  [optional]
**poiSymbolColor** | [**PoiSymbolColorEnum**](#PoiSymbolColorEnum) | If georesource is a POI then custom POI symbol color can be set by specifying one of the following color names |  [optional]
**jsonSchema** | **String** | a JSON schema as string that defines the data model for this dataset. It can be used to validate the geoJsonString property. |  [optional]
**geoJsonString** | **String** | a valid GeoJSON string containing the features consisting of a geometry and properties specific to the dataset | 


<a name="PoiMarkerColorEnum"></a>
## Enum: PoiMarkerColorEnum
Name | Value
---- | -----
WHITE | &quot;white&quot;
RED | &quot;red&quot;
ORANGE | &quot;orange&quot;
BEIGE | &quot;beige&quot;
GREEN | &quot;green&quot;
BLUE | &quot;blue&quot;
PURPLE | &quot;purple&quot;
PINK | &quot;pink&quot;
GRAY | &quot;gray&quot;
BLACK | &quot;black&quot;


<a name="PoiSymbolColorEnum"></a>
## Enum: PoiSymbolColorEnum
Name | Value
---- | -----
WHITE | &quot;white&quot;
RED | &quot;red&quot;
ORANGE | &quot;orange&quot;
BEIGE | &quot;beige&quot;
GREEN | &quot;green&quot;
BLUE | &quot;blue&quot;
PURPLE | &quot;purple&quot;
PINK | &quot;pink&quot;
GRAY | &quot;gray&quot;
BLACK | &quot;black&quot;




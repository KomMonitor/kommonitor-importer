
# SpatialUnitPOSTInputType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**spatialUnitLevel** | **String** | the name and identifier of the spatial unit level the features apply to | 
**periodOfValidity** | [**PeriodOfValidityType**](PeriodOfValidityType.md) |  | 
**metadata** | [**CommonMetadataType**](CommonMetadataType.md) |  | 
**nextLowerHierarchyLevel** | **String** | the identifier/name of the spatial unit level that contains the features of the nearest lower hierarchy level |  [optional]
**nextUpperHierarchyLevel** | **String** | the identifier/name of the spatial unit level that contains the features of the nearest upper hierarchy level |  [optional]
**jsonSchema** | **String** | a JSON schema as string that defines the data model for this dataset. It can be used to validate the geoJsonString property. |  [optional]
**geoJsonString** | **String** | a valid GeoJSON string containing the features consisting of a geometry and a unique identifier as property &#39;uuid&#39; |  [optional]




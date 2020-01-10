
# DefaultClassificationMappingType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**colorBrewerSchemeName** | **String** | the name of the colorBrewer color scheme used to define the colors for classification (see project http://colorbrewer2.org/#type&#x3D;sequential&amp;scheme&#x3D;BuGn&amp;n&#x3D;3 for colorSchemes). Set to &#39;INDIVIDUAL&#39; if colors are set arbitrarily. |  [optional]
**items** | [**List&lt;DefaultClassificationMappingItemType&gt;**](DefaultClassificationMappingItemType.md) | array of classification mapping items. The order of the items corresponds to indicator value intervals from low to high. The number of items represents the number of classes. In combination they represent the default classification and mapping to custom rating of the indicator values |  [optional]




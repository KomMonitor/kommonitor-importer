
# ProcessScriptPUTInputType

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | name of the process script | 
**description** | **String** | short description of the scripts content (what does it do) | 
**scriptCodeBase64** | **String** | the actual script code (JavaScript) as BASE64 encoded string | 
**requiredIndicatorIds** | **List&lt;String&gt;** | identifiers of indicators that are used within the script. | 
**requiredGeoresourceIds** | **List&lt;String&gt;** | identifiers of georesources that are used within the script. | 
**variableProcessParameters** | [**List&lt;ProcessInputType&gt;**](ProcessInputType.md) | list of process parameters that can be set by an expert user. They are used within the script to parameterize the indicator computation | 




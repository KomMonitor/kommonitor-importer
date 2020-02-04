# KomMonitor Importer

This projects implements a webapp that enables the import of spatial datasets (SpatialUnits, Georesources and Indicators) 
into the _KomMonitor Spatial Data Infrastructure_. The webapp provides an API for retrieving data from various datasources 
that come in the shape of certain formats and converting the datasets into a KomMonitor related schema. The converted 
datasets come available within the KomMonitor Spatial Data Infrastructure by publishing them via the _Data Management API_.

# Project Structure

The KomMonitor Importer project comprises different modules that encapsulate different tasks:  

## [KomMonitor Importer Models](https://github.com/SebaDro/kommonitor-importer/tree/master/kommonitor-importer-models)  
This module contains the API model classes which will be used for serialization and deserialization of JSON payload for 
API calls via [Jackson annotations](https://github.com/FasterXML/jackson-annotations). The model classes were auto-generated
from an OpenAPI schema definition by the use of [Swagger Codegen](https://github.com/swagger-api/swagger-codegen).

## [KomMonitor Importer Core](https://github.com/SebaDro/kommonitor-importer/tree/master/kommonitor-importer-core)  
The core module provides the main data entities that represent KomMonitor related resources as well as classes that are
responsible for importing datasets. In particular, these are: 
* _DataSourceRetriever_ implementations for fetching datasets
 from a certain datasource  
 (package: _org.n52.kommonitor.importer.io.datasource_)
* _Converter_ implementations that supports the conversion certain data formats  
(package: _org.n52.kommonitor.importer.converter_).  

The above mentioned packages also provide interfaces that can be implemented to extend the project by additional 
datasource retriever and converters. 
 
In addition, the module contains some helper and service classes for:
* performing HTPP requests 
* storing uploaded files
* performing common geometrical operations
* dealing with the GeoTools [Feature model](https://docs.geotools.org/latest/userguide/library/opengis/feature.html) for
decoding properties and geometries  

## [KomMonitor Importer API](https://github.com/SebaDro/kommonitor-importer/tree/master/kommonitor-importer-api)  
The API module primarily comprises three kinds of classes that are responsible for implementing the API endpoints:
* _API_ interfaces contain request mappings for all API endpoints that are defined by 
[Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc) annotations as well
as [Swagger Annotations](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X) for generating API
documentations  
(package: _org.n52.kommonitor.importer.api_)
* _Controller_ classes, which are annotated with _@Controller_ for enabling Spring's autodetection, implement the API interfaces
(package: _org.n52.kommonitor.importer.api_)
* _Handler_ classes are be used by the Controllers, to delegate the request handling dependent on a particular request  
(package: _org.n52.kommonitor.importer.api.handler_)

Just like the API model classes, the API interfaces were auto-generated from an OpenAPI schema definition by the use of
[Swagger Codegen](https://github.com/swagger-api/swagger-codegen).

## [KomMonitor API Client](https://github.com/SebaDro/kommonitor-importer/tree/master/kommonitor-importer-api-client)  
This module provides API clients for the _Data Management API_ endpoints. The client implementation is based on 
[Spring RestTemplate](https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#rest-resttemplate)
and was generated from the  _Data Management API_ OpenAPI schema definition via
[Swagger Codegen](https://github.com/swagger-api/swagger-codegen). In addition, End-to-End tests for some of the 
client methods, that are required for the Importer, have been implemented using
[Spring MockRestServiceServer](https://docs.spring.io/spring/docs/current/spring-framework-reference/testing.html#spring-mvc-test-client).  

## [KomMonitor Importer App](https://github.com/SebaDro/kommonitor-importer/tree/master/kommonitor-importer-app)
The App module contains the main class that is responsible for launching the Spring Boot application and an _application.yml_
that provides different properties for externalized configuration. Furthermore, some configuration classes are located 
in the module, that utilize _application.yml_ properties for configuring different Spring Beans that will be injected
within the other modules.  

# Installation
## Build from Source
There are some requirements on your building environment in order to build and run the KomMonitor Importer API from source:
* at least Java SE Development Kit 8 must be available
* to build the project from source, [Maven](https://maven.apache.org/index.html) is required
* for cloning the repository, [Git](https://git-scm.com/) must be installed
* if you wish to run the application as Docker container, you also need [Docker](https://www.docker.com/)

You can download the latest branch directly from GitHub or if you have installed Git in your environment just run 
`git clone https://github.com/SebaDro/kommonitor-importer.git`.

After cloning the repository, just run `mvn clean install` from the repositories root directory to build the whole
project from source.

## Configuration
KomMonitor Importer API is a Spring Boot application and provides a `application.yml` within the 
[KomMonitor Importer App module](https://github.com/SebaDro/kommonitor-importer/tree/master/kommonitor-importer-app) for
externalized configurations. The properties within this file can be used to configure the application. A documentation
for common application properties can be found under https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html  
  
Furthermore, the `application.yml` contains some additional and custom configuration properties:
* `kommonitor.importer.datamanagement-api-url:`: endpoint of the KomMonitor Data Management API
* `kommonitor.importer.fileStorageLocation`: path to the file storage directory that will be used for storing uploaded files
* `springfox.documentation.swagger.v2.path`: defines the default context path for retrieving the API documentation

## Start the Application
There are different deployment patterns for running the application:  
### JAR  
If you have built the project from source, the KomMonitor Importer App has been packaged as JAR artifact. So, just execute
execute the JAR within the target folder of the `kommonitor-importer-app` module to run the application.
### Maven
You can also start the application by running `mvn spring-boot:run` from the root
of the `kommonitor-importer-app` module.
### Docker
The repository also contains a Dockerfile for building a Docker image of the application. To build the image,
run `docker build -t kommonitor/importer:latest .` from the root of the repository. Finally, a container with published
port 8087 can be started with `docker run -p 8087:8087 kommonitor/importer`.
 
By default, the started application is available under http://localhost:8087.

# User Guide
## Interact with the API
The entrypoint for the KomMonitor Importer API ist http://localhost:8087. If you call this URL without any additional endpoint,
you will be redirected to  http://localhost:8087/swagger-ui.html. This page provides a Swagger UI, which has been generated
from the OpenAPI specification for visualization and interacting with the API resources. So, feel free to try out the
different API endpoints via Swagger UI to get started.

## Supported Data Source Types
The Importer API supports selected data source types. For each type, the application contains an appropriate implementation
that is responsible for accessing the data source and retrieving datasets from it. The API has two endpoints for retrieving
information about the supported data source types:
* `/datasourceTypes`: lists all supported types of a data source
* `datasourceTypes/{type}`: provides detailed information and supported parameters for a certain datasource type  

## Supported Data Formats
Retrieving datasets from a certain data source is only one aspect the Importer API has to consider. Another one is the
ability for parsing the dataset in order to map it to a format the DataManagement API can deal with. Hence, the API
provides different converters, each one supporting a certain data format. You will find information about the available
converters via the following endpoints:
* `/converters`: lists all available converters and its' supported data formats
* `/converters/{name}`: provides detailed information and supported parameters for a certain converter

## File Upload
If you plan to import a dataset that is stored within a file, you first have to upload this file to the server so that
it gets accessible for the data source retriever.  

The upload is done by performing a POST request with a multi-part message that contains the file on the `/upload` endpoint.
Optionally, you can set a custom file name within the multi-part message that will be used for storing the file on the server.  

You can retrieve a list of all ever uploaded files by doing a GET request on the `/upload` endpoint.

## Import Datasets
For each resource type of the KomMonitor DataManagement API (Georesources, Spatial Units, Indicators), the Importer API
provides an appropriate endpoint. By sending a POST request the import process will be triggered. Within the POST body
you have to define some required information about how to access a certain dataset and how to convert it into the KomMonitor 
specific schema.

### Import Georesources
You can trigger the import of Georesources by sending a POST request to the `/georesources` endpoint. The request body
has to contain the following properties:
* `georesourcePostBody`: A JSON object in accordance to the POST request body for the `/georesources` endpoint of the
Data Management API. Only the `geoJsonString` property must not be set, since its value will be generated as part of the
import process. For all other properties, you can find detailed descriptions in the Data Management API documentation.
* `datasource`: Definition of the data source from which new datasets should be imported. See the _Datasource Definition_
section.
* `converter`: Definition of the converter that should be used for converting the imported dataset. See the
_Converter Definition_ section.
* `propertyMapping`: Definitions for mapping properties from the imported dataset to required properties for spatial resources.
See the _Spatial Resource Property Mapping_ section.

### Import Spatial Units
The import of Spatial Units is done by sending a POST request to the `/spatial-units` endpoint. The request body
has to contain the following properties:
* `spatialUnitPostBody`: A JSON object in accordance to the POST request body for the `/spatialUnits` endpoint of the
Data Management API. Only the `geoJsonString` property must not be set, since its value will be generated as part of the
import process. For all other properties, you can find detailed descriptions in the Data Management API documentation.
* `datasource`: Definition of the data source from which new datasets should be imported. See the _Datasource Definition_
section.
* `converter`: Definition of the converter that should be used for converting the imported dataset. See the
_Converter Definition_ section.
* `propertyMapping`: Definitions for mapping properties from the imported dataset to required properties for spatial resources.
See the _Spatial Resource Property Mapping_ section.

### Import Indicators
For importing an Indicator you have to perform a POST request to the `/indicators` endpoint. The request body
has to contain the following properties:
* `indicatorPostBody`: A JSON object in accordance to the POST request body for the `/indicators` endpoint of the
Data Management API. Only the `indicatorValues` property must not be set, since the time series values will be generated 
as part of the import process. For all other properties, you can find detailed descriptions in the Data Management API documentation.
* `datasource`: Definition of the data source from which new datasets should be imported. See the _Datasource Definition_
section.
* `converter`: Definition of the converter that should be used for converting the imported dataset. See the
_Converter Definition_ section.
* `propertyMapping`: Definitions for mapping properties from the imported dataset to required properties for Indicators.
See the _Indicator Property Mapping_ section.

### Import Definitions
As you can see from the above sections, you have to provide some properties within the request body about the dataset 
that are required for performing the import. The following sections give you some examples of how to define those properties.
#### Datasource Definition
The `dataSource` property is required within the POST request body for each resource endpoint. It contains information
about the data source type and additional parameters that are required for fetching datasets from it. You'll get a information
of all supported data source types from the `/datasourceTypes` endpoint (also see the _Supported Data Source Types_ section).
As an example, the following snipped shows how to define a HTTP datasource with a URL parameter that will be used for performing a
HTTP GET request: 
```json
{
  "dataSource": {
    "type": "HTTP",
    "parameters": [
      {
        "name": "URL",
        "value": "http://www.webgis-server.de/endpoint?SERVICE=WFS&REQUEST=getFeature&VERSION=1.1.0&TypeName=ns0:testType"
      }
    ]
  }
}
```
#### Converter Definition
The `converter` property is another mandatory property that has to be defined within the POST request body. It contains
configurations for the converter that should be used for importing a dataset. Ideally, you choose a converter appropriate to
the dataset's format. The `/converters` endpoints provides a list of all available converter implementations and its
supported properties like encoding, mimeType, schema and additional properties.
Following, you'll find an example for a converter configuration according to a dataset that comes in the shape of a WFS 1.0.0
schema:
```json
{
  "converter": {
    "name": "org.n52.kommonitor.importer.converter.wfs.v1",
    "encoding": "UTF-8",
    "mimeType": "application/xml",
    "schema": "http://schemas.opengis.net/wfs/1.0.0/wfs.xsd",
    "parameters": [
      {
        "name": "CRS",
        "value": "EPSG:25832"
      }
    ]
  }
}
```
If you wish to get some additional information about the WFS 1.0.0 converter, feel free to call its API endpoint 
`/converters/org.n52.kommonitor.importer.converter.wfs.v1`. You will notice, that the converter supports multiple schemas 
and in addition a `CRS` parameter to define the coordinate reference system of the dataset to import. Make sure, you'll know
both in order to define the converter properly for the import request.

#### Spatial Resource Property Mapping
As part of the import process, a GeoJSON FeatureCollection will be generated from the imported dataset, that will be used
for adding new resources via the Data Management API. This FeatureCollection contains the geometry from the imported dataset
and some additional properties, according to the Data Management API schema for those resources. To tell the Import API 
which properties from the original dataset should be used for the FeatureCollcetion properties, a property mapping has 
to be provided. E.g. assume the following GeoJSON dataset:
```json
{
	"type": "FeatureCollection",
	"name": "Baubloecke",
	"features": [
		{
			"type": "Feature",
			"properties": {
				"baublock_id": "_170",
				"EreignisintervallStart": "2019-05-06",
				"EreignisintervallEnde": "2019-05-28",
				"altersdurchschnitt": 43.4123
			},
			"geometry": {
				"type": "MultiPolygon",
				"coordinates": [[[
					[384891.959,5713511.4441],
					[384898.084,5713509.1401],
					[384947.758,5713522.8651],
					[385030.73,5713539.248],
					[384891.959,5713511.4441]
				]]]
			}
		}
	]
} 
```
An appropriate property mapping would be:
```json
{
  "propertyMapping": {
    "identifierProperty": "baublock_id",
	"nameProperty": "baublock_id",
	"validEndDateProperty": "EreignisintervallStart",
	"validStartDateProperty": "EreignisintervallEnde"
  }
}
```
Note, that up to now only flat property hierarchies are supported. Nested properties in the original dataset can't be covered
with the property mapping, so the import will fail for such a dataset.

#### Indicator Property Mapping
The property mapping for indicators is different to the mapping for spatial features. Since there are different strategies
of how to encode time series values for spatial features, the time series mapping also supports different strategies for mapping
those values, which will be explained in the following.

**Related indicator values for the same times eries are encoded within different features**  
In this case, each single indicator value of the same time series is encoded as a separate feature. In the example below,
there are two features for the same Spatial Unit. Both features have the same ID and also the same geometry. Only the
properties are different, because each feature comprises the properties for single timestep of a common time series.
```json
{
	"type": "FeatureCollection",
	"name": "Baubloecke",
	"features": [
		{
			"type": "Feature",
			"properties": {
				"baublock_id": "_170",
				"date": "2019-05-06",
				"altersdurchschnitt": 43.4123
			},
			"geometry": { }
		},
		{
			"type": "Feature",
			"properties": {
				"baublock_id": "_170",
				"date": "2020-04-23",
				"altersdurchschnitt": 48.4123
			},
			"geometry": { }
		}
	]
} 
```
For this case, you only have to define a single `timeseriesMapping` beside the mapping for the `spatialReferenceKey`.
If you provide such definition to the Import API, the responsible converter automatically tries to group the features
by its' values for the `spatialReferenceKey`, so that it can merge the single indicator values to a time series for each
spatial feature. Note, that you have to define both, the property that holds the indicator value and the property that
holds the timestamp information:
```json
{
  "propertyMapping": {
    "spatialReferenceKeyProperty": "baublock_id",
	"timeseriesMappings": [
	  {
	    "indicatorValueProperty": "altersdurchschnitt",
	    "timestampProperty": "date"
	  }
	]
  }
}
```
**Each feature contains the whole time series**  
This encoding stratetgy for time series values implies, that a single feature has the complete time series for an indicator
encoded within its properties. For each time step there is a separate property that holds the indicator value for this 
time step. Like in the example below, the property name may contain the timestamp information for an indicator.
```json
{
	"type": "FeatureCollection",
	"name": "Baubloecke",
	"features": [
		{
			"type": "Feature",
			"properties": {
				"baublock_id": "_170",
				"date_2019-05-06": "2019-05-06",
				"altersdurchschnitt2019-05-06": 43.4123,
                "altersdurchschnitt2020-04-23": 48.4123
			},
			"geometry": { }
		}
	]
} 
```
If the time series is encoded in a way like the example above, you have to provide multiple time series mappings. For
each time step you have to define, which property contains the corresponding indicator value. Note, that in such a case
you have to provide the timestamp within the mapping, rather than defining the property that holds the timestamp information.
```json
{
  "propertyMapping": {
    "spatialReferenceKeyProperty": "baublock_id",
	"timeseriesMappings": [
	  {
        "indicatorValueProperty": "altersdurchschnitt2019-05-06",
       	"timestamp": "2019-05-06"
      },
	  {
	    "indicatorValueProperty": "altersdurchschnitt2020-04-23",
	    "timestamp": "2020-04-23"
	  }
	]
  }
}
```
## Update Datasets
The KomMonitor Import API also provides dedicated endpoints for updating existing resources. Just like the simple import,
datasets will be imported from a datasource and converted in an appropriate format. The only difference is, that finally
a PUT request will be performed on the resources endpoint of the Data Management API, in order to update an existing
resource and not creating a new one.

### Update Georesources
The update of Georesources is done by sending a POST request to the `/georesources/update` endpoint. The request body
has to contain the following properties:
* `georesourceId`: The ID of the existing Georesource within the Data Management API
* `georesourcePutBody`: A JSON object in accordance to the PUT request body for the `/georesources` endpoint of the
Data Management API. You can find detailed descriptions in the Data Management API documentation.
* `datasource`: Definition of the data source from which new datasets should be imported. See the _Datasource Definition_
section.
* `converter`: Definition of the converter that should be used for converting the imported dataset. See the
_Converter Definition_ section.
* `propertyMapping`: Definitions for mapping properties from the imported dataset to required properties for spatial resources.
See the _Spatial Resource Property Mapping_ section.

### Update Spatial Units
You can update a Spatial Unit by sending a POST request to the `/spatial-units/update` endpoint. The request body
has to contain the following properties:
* `spatialUnitId`: The ID of the existing Spatial Unit within the Data Management API
* `spatialUnitPutBody`: A JSON object in accordance to the PUT request body for the `/spatial-units` endpoint of the
Data Management API. You can find detailed descriptions in the Data Management API documentation.
* `datasource`: Definition of the data source from which new datasets should be imported. See the _Datasource Definition_
section.
* `converter`: Definition of the converter that should be used for converting the imported dataset. See the
_Converter Definition_ section.
* `propertyMapping`: Definitions for mapping properties from the imported dataset to required properties for spatial resources.
See the _Spatial Resource Property Mapping_ section.

### Update Indicator
You you want to update an Indicator you have to send a POST request to the `/indicators/update` endpoint. The request body
has to contain the following properties:
* `indicatorId`: The ID of the existing Indicator within the Data Management API
* `indicatorPutBody`: A JSON object in accordance to the PUT request body for the `/indicators` endpoint of the
Data Management API. You can find detailed descriptions in the Data Management API documentation.
* `datasource`: Definition of the data source from which new datasets should be imported. See the _Datasource Definition_
section.
* `converter`: Definition of the converter that should be used for converting the imported dataset. See the
_Converter Definition_ section.
* `propertyMapping`: Definitions for mapping properties from the imported dataset to required properties for Indicators.
See the _Indicator Property Mapping_ section.

# Extend the Importer API
## Class Diagram
If you want to extend the Importer API, you should have to know about the relevant classes and their relationships with
each other. Therefore, you'll find a simple class diagram below, that shows the most relevant classes:  
<img src="./docs/class-diagrams/KomMonitor_Importer_ClassDiagram.png" alt="KomMonitor Importer Class Diagram"/>

## How to provide additional DataSourceRetriever

## How to provide additional Converters

## Generate API and models
The project comes with the latest API and model classes. However, if you wish to customize the KomMonitor Importer API or 
the DataManagement API client, use one of the Maven build profiles that are provided within the single modules. 
These profiles are configured to automate code generation of the corresponding API and model classes from the OpenAPI specification. 
Just run `mvn compile -Pgenerate-models` from _kommonitor-importer-models_, `mvn compile -Pgenerate-api` from _kommonitor-importer-api_ 
or `mvn compile -Pgenerate-client` from _kommonitor-datamanagement-api-client_. Note, that you have to make the OpenAPI specs
available as artifacts within your build environment, in beforehand. You can find the OpenAPI spec documents at
https://gitlab.fbg-hsbo.de/kommonitor/kommonitor-api-specs.




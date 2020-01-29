# KomMonitor Importer

This projects implements a webapp that enables the import of spatial datasets (SpatialUnits, Georesources and Indicators) 
into the _KomMonitor Spatial Data Infrastructure_. The webapp provides an API for retrieving data from various datasources 
that come in the shape of certain formats and converting the datasets into a KomMonitor related schema. The converted 
datasets come available within the KomMonitor Spatial Data Infrastructure by publishing them via the _Data Management API_.

# Project structure

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
* if you want to clone the repository, [Git](https://git-scm.com/) must be installed

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

# Get Started
## Generate API and models
The project comes with the latest API and model classes. However, if you wish to customize the KomMonitor Importer API or 
the DataManagement API client, use one of the Maven build profiles that are provided within the single modules. 
These profiles are configured to automate code generation of the corresponding API and model classes from the OpenAPI specification. 
Just run `mvn compile -Pgenerate-models` from _kommonitor-importer-models_, `mvn compile -Pgenerate-api` from _kommonitor-importer-api_ 
or `mvn compile -Pgenerate-client` from _kommonitor-datamanagement-api-client_. Note, that you have to make the OpenAPI specs
available as artifacts within your build environment, in beforehand. You can find the OpenAPI spec documents at
https://gitlab.fbg-hsbo.de/kommonitor/kommonitor-api-specs.
## Start the application
The KomMonitor Importer API has been implemented with Spring Boot. So, after you built the whole project 
with `mvn clean install`, just run `mvn spring-boot:run` from the root of the _kommonitor-importer-app_ module to start the application.  
A Swagger UI documentation is available under http://localhost:8087/swagger-ui.html.
To configure the application just customize the _application.yml_. 

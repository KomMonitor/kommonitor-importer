# KomMonitor Importer

This projects implements an API importing spatial data (SpatialUnits, Georesources and Indicators) from various datasources into the KomMonitor project.

# Get Started
## Generate API and models
The project comes with the latest API and model classes. However, if you wish to customize the KomMonitor Importer API or 
the DataManagement API client, use one of the Maven build profiles that are provided within the single modules. 
These profiles are configured to automate code generation of the corresponding API and model classes from the OpenAPI specification. 
Just run `mvn compile -Pgenerate-models` from _kommonitor-importer-models_, `mvn compile -Pgenerate-api` from _kommonitor-importer-api_ 
or `mvn compile -Pgenerate-client` from _kommonitor-datamanagement-api-client_. Note, that you have to make the OpenAPI specs
available as artifacts within your build environment, in beforehand. You can find the OpenAPI spec documents at https://gitlab.fbg-hsbo.de/kommonitor/kommonitor-api-specs.
## Start the application
The KomMonitor Importer API has been implemented with Spring Boot. So, after you built the whole project 
with `mvn clean install`, just run `mvn spring-boot:run` from the root of the _kommonitor-importer-app_ module to start the application.  
A Swagger UI documentation is available under http://localhost:8087/swagger-ui.html.
To configure the application just customize the _application.yml_. 

# KomMonitor Importer

This projects implements an API importing spatial data (SpatialUnits, Georesources and Indicators) from various datasources into the KomMonitor project.

# Get Started
## Generate API and models
The project comes with the latest API and model classes. However, if you wish to customize the importer API, seperated build profiles are provided, that automates code generation of the corresponding API and model classes from the OpenAPI specification. Just run `mvn compile -Pgenerate-models` from _kommonitor-importer-models_ or `mvn compile -Pgenerate-api` from _kommonitor-importer-api_.
## Start the application
The KomMonitor Importer API has been implemented with Spring Boot. So run `mvn spring-boot:run` from the root of the _kommonitor-importer-app_ module to start the application.  
A Swagger UI documentation is available under http://localhost:8087/swagger-ui.html.
To configure the application just customize the _application.yml_. 

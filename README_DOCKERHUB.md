# KomMonitor Importer

This project implements a webapp that enables the import of spatial datasets (_SpatialUnits_, _Georesources_ and _Indicators_) 
into the _KomMonitor Spatial Data Infrastructure_. The webapp provides an API for retrieving data from various data sources 
that come in the shape of certain formats and converting the datasets into a KomMonitor related schema. The converted 
datasets come available within the KomMonitor Spatial Data Infrastructure by publishing them via the _Data Management API_.

## Quick Links And Further Information on KomMonitor
   - [DockerHub repositories of KomMonitor Stack](https://hub.docker.com/orgs/kommonitor/repositories)
   - [Github Repositories of KomMonitor Stack](https://github.com/KomMonitor)
   - [Github Wiki for KomMonitor Guidance and central Documentation](https://github.com/KomMonitor/KomMonitor-Docs/wiki)
   - [Technical Guidance](https://github.com/KomMonitor/KomMonitor-Docs/wiki/Technische-Dokumentation) and [Deployment Information](https://github.com/KomMonitor/KomMonitor-Docs/wiki/Setup-Guide) for complete KomMonitor stack on Github Wiki
   - [KomMonitor Website](https://kommonitor.de/)  

## Dependencies to other KomMonitor Components
KomMonitor Importer requires 
   - a running instance of **KomMonitor Data Management**, to forward any import/update requests.
   - an optional and configurable connection to a running **Keycloak** server, if role-based data access is activated via configuration of KomMonitor stack


## Exemplar docker-compose File with explanatory comments

Only contains subset of whole KomMonitor stack to focus on the config parameters of this component

```yml

version: '2.1'

networks:
  kommonitor:
    driver: bridge
services:

    # importer component that can import spatial resources from different data sources (e.g. GeoJSON, CSV, WFS), 
    # sanity-check them and forward data integration requests to data management component
    kommonitor-importer:
      image: 'kommonitor/importer'
      container_name: kommonitor-importer
      #restart: unless-stopped
      ports:
        - 8087:8087
      volumes:
       - importer_data:/tmp/importer      # storage location where to store "uploaded files"; files can be uploaded to importer, but currently will never be deleted; hence manually delete them if required
      environment:
       - kommonitor.importer.datamanagement-api-url=http://kommonitor-data-management:8085/management   # target URL to running Data Management component ending with "/management" (/management is internal base path of data management component)- best use docker name and port within same network
       - JAVA_OPTS=-Dorg.geotools.referencing.forceXY=true       # important setting that coordinate system axes shall follow order XY (default is YX, but KomMonitor Data Management component expects axis order XY; e.g. longitude, latitude)
       - logging.level.org.n52.kommonitor=ERROR         # adjust logging level [e.g. "INFO", "WARN", "ERROR"] - ERROR logs only errors 
       - KOMMONITOR_SWAGGERUI_BASEPATH=        #depending on DNS Routing and Reverse Proxy setup a base path can be set here to access swagger-ui interface (e.g. set '/data-importer' if https://kommonitor-url.de/data-importer works as entry point for localhost:8087)   
       - KOMMONITOR_SWAGGER_UI_SECURITY_CLIENT_ID=kommonitor-importer   # client/resource id of importer component in Keycloak realm
       - KOMMONITOR_SWAGGER_UI_SECURITY_SECRET=secret                   # WARNING: DO NOT SET IN PRODUCTION!!! Keycloak secret of this component within Credentials tab of respective Keycloak client; secret for swagger-ui to authorize swagger-ui requests in a Keycloak-active scenario (mostly this should not be set, as users with access to swagger-ui (e.g. 'http://localhost:8087/swagger-ui.html') could then authorize without own user account and perform CRUD requests)
       - KEYCLOAK_ENABLED=false                                       # enable/disable role-based data access using Keycloak (true requires working Keycloak Setup and enforces that all other components must be configured to enable Keycloak as well)
       - KEYCLOAK_AUTH_SERVER_URL=https://keycloak.fbg-hsbo.de/auth   # Keycloak URL ending with '/auth/'
       - KEYCLOAK_REALM=kommonitor                                    # Keycloak realm name
       - KEYCLOAK_RESOURCE=kommonitor-importer                        # client/resource id of importer component in Keycloak realm
       - KEYCLOAK_CREDENTIALS_SECRET=secret                           # Keycloak secret of this component within Credentials tab of respective Keycloak client; must be set here
       - SERVER_PORT=8087                                             # Server port; default is 8087
      networks:
       - kommonitor


    # database container; must use PostGIS database
    # database is not required to run in docker - will be configured in Data Management component
    kommonitor-db:
      image: mdillon/postgis
      container_name: kommonitor-db
      #restart: unless-stopped
      ports:
        - 5432:5432
      environment:
        - POSTGRES_USER=kommonitor      # database user (will be created on startup if not exists) - same settings in data management service
        - POSTGRES_PASSWORD=kommonitor  # database password (will be created on startup if not exists) - same settings in data management service 
        - POSTGRES_DB=kommonitor_data   # database name (will be created on startup if not exists) - same settings in data management service
      volumes:
        - postgres_data:/var/lib/postgresql/data   # persist database data on disk (crucial for compose down calls to let data survive)
      networks:
        - kommonitor

    # Data Management component encapsulating the database access and management as REST service
    kommonitor-data-management:
      image: kommonitor/data-management
      container_name: kommonitor-data-management
      #restart: unless-stopped
      depends_on:
        - kommonitor-db    # only if database runs as docker container as well
      ports:
        - "8085:8085"
      networks:
        - kommonitor
      links:
        - kommonitor-db
      environment:
      # - env parameters omitted here for brevity


volumes:
 postgres_data:
 importer_data:


```

## Contact
|    Name   |   Organization    |    Mail    |
| :-------------: |:-------------:| :-----:|
| Christian Danowski-Buhren | Bochum University of Applied Sciences | christian.danowski-buhren@hs-bochum.de |
| Sebastian Drost | 52°North GmbH | s.drost@52north.org |
| Andreas Wytzisk  | Bochum University of Applied Sciences | Andreas-Wytzisk@hs-bochum.de |

## Credits and Contributing Organizations
- Department of Geodesy, Bochum University of Applied Sciences
- Department for Cadastre and Geoinformation, Essen
- Department for Geodata Management, Surveying, Cadastre and Housing Promotion, Mülheim an der Ruhr
- Department of Geography, Ruhr University of Bochum
- 52°North GmbH, Münster
- Kreis Recklinghausen
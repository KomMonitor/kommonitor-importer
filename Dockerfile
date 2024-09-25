# ---- Base Maven build ----
FROM maven:3-eclipse-temurin-17-alpine as build
WORKDIR /app

# Cache dependencies as long as the POM changes
COPY ./pom.xml ./kommonitor-importer/pom.xml
COPY ./kommonitor-datamanagement-api-client/pom.xml ./kommonitor-importer/kommonitor-datamanagement-api-client/pom.xml
COPY ./kommonitor-importer-api/pom.xml ./kommonitor-importer/kommonitor-importer-api/
COPY ./kommonitor-importer-core/pom.xml ./kommonitor-importer/kommonitor-importer-core/
COPY ./kommonitor-models/pom.xml ./kommonitor-importer/kommonitor-models/
COPY ./kommonitor-importer-app/pom.xml ./kommonitor-importer/kommonitor-importer-app/
RUN mvn -f ./kommonitor-importer/pom.xml dependency:go-offline --fail-never

# Copy source files for build
COPY . /app/kommonitor-importer/

# Run the Maven build
RUN mvn -f ./kommonitor-importer/pom.xml clean install -Dapp.finalName=kommonitor-importer-app

# ---- Run the application ----
FROM eclipse-temurin:17.0.11_9-jdk-alpine
WORKDIR /app

# Copy from the base build image
COPY --from=build app/kommonitor-importer/kommonitor-importer-app/target/kommonitor-importer-app.jar /app/kommonitor-importer-app.jar

# Set the entrypoint for starting the app
CMD ["sh", "-c", "java ${JAVA_OPTS} -jar /app/kommonitor-importer-app.jar"]
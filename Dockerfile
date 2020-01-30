# ---- Base Maven build ----
FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app

# Copy source files for build
COPY . /app/kommonitor-importer/

# Run the Maven build
RUN mvn -f ./kommonitor-importer/pom.xml clean install -Dapp.finalName=kommonitor-importer-app

# ---- Run the application ----
FROM openjdk:alpine
WORKDIR /app

# Copy from the base build image
COPY --from=build app/kommonitor-importer/kommonitor-importer-app/target/kommonitor-importer-app.jar /app/kommonitor-importer-app.jar
CMD ["java", "-jar", "/app/kommonitor-importer-app.jar"]
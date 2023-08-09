/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.n52.kommonitor.importer.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.n52.kommonitor.models.Error;
import org.n52.kommonitor.models.ImportResponseType;
import org.n52.kommonitor.models.ImportSpatialUnitPOSTInputType;
import org.n52.kommonitor.models.UpdateSpatialUnitPOSTInputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-26T14:16:35.930+01:00")

@Tag(name = "spatial-units", description = "the spatial-units API")
public interface SpatialUnitsApi {

    Logger log = LoggerFactory.getLogger(SpatialUnitsApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Import a new spatial unit",
            description = "Import a new spatial unit for a certain period of time. Parses input source, extracts relevant data, performs schema mapping to KomMonitor data model and calls POST /spatial-units of KomMonitor Data Management API",
            tags = {"spatial-units",},
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ImportResponseType.class)) }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)) }),
                    @ApiResponse(responseCode = "401", description = "API key is missing or invalid"),
                    @ApiResponse(responseCode = "500", description = "Unexpected error", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)) })}
    )
    @RequestMapping(value = "/spatial-units",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ImportResponseType> importSpatialUnit(
            @Parameter(description = "feature data" ,required=true )
            @Valid @RequestBody ImportSpatialUnitPOSTInputType featureData) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"importedFeatures\" : [ \"importedFeatures\", \"importedFeatures\" ],  \"failedFeatures\" : [ \"failedFeatures\", \"failedFeatures\" ],  \"uri\" : \"uri\"}", ImportResponseType.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default SpatialUnitsApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(
            summary = "Update a spatial unit",
            description = "Update a new spatial unit for a certain period of time. Parses input source, extracts relevant data, performs schema mapping to KomMonitor data model and calls PUT /spatial-units of KomMonitor Data Management API",
            tags={ "spatial-units", },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ImportResponseType.class)) }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ImportResponseType.class)) }),
                    @ApiResponse(responseCode = "401", description = "API key is missing or invalid"),
                    @ApiResponse(responseCode = "200", description = "Unexpected error", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ImportResponseType.class)) }) }
    )
    @RequestMapping(value = "/spatial-units/update",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ImportResponseType> updateSpatialUnit(
            @Parameter(description = "feature data" ,required=true )
            @Valid @RequestBody UpdateSpatialUnitPOSTInputType featureData) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"importedFeatures\" : [ \"importedFeatures\", \"importedFeatures\" ],  \"failedFeatures\" : [ \"failedFeatures\", \"failedFeatures\" ],  \"uri\" : \"uri\"}", ImportResponseType.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default SpatialUnitsApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.n52.kommonitor.importer.api;

import org.n52.kommonitor.models.Error;
import org.n52.kommonitor.models.ImportResponseType;
import org.n52.kommonitor.models.UpdateIndicatorPOSTInputType;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-09T11:12:13.634041800+02:00[Europe/Berlin]")
@Validated
@Tag(name = "indicators", description = "Municipal indicators that provide statiscial time series information")
public interface IndicatorsApi {

    /**
     * POST /indicators/update : Update or create a new indicator dataset
     * Update or create an indicator dataset for a certain period of time and spatial unit/level. Parses Input source, extracts relevant data, performs schema mapping to KomMonitor data model and calls PUT /indicators of KomMonitor Data Management API
     *
     * @param indicatorData indicator data (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or API key is missing or invalid (status code 401)
     *         or Unexpected error (status code 200)
     */
    @Operation(
        operationId = "updateIndicator",
        summary = "Update or create a new indicator dataset",
        description = "Update or create an indicator dataset for a certain period of time and spatial unit/level. Parses Input source, extracts relevant data, performs schema mapping to KomMonitor data model and calls PUT /indicators of KomMonitor Data Management API",
        tags = { "indicators" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ImportResponseType.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "*/*", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "401", description = "API key is missing or invalid"),
            @ApiResponse(responseCode = "default", description = "Unexpected error", content = {
                @Content(mediaType = "*/*", schema = @Schema(implementation = Error.class))
            })
        },
        security = {
            @SecurityRequirement(name = "oauth2")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/indicators/update",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<ImportResponseType> updateIndicator(
        @Parameter(name = "indicator-data", description = "indicator data", required = true) @Valid @RequestBody UpdateIndicatorPOSTInputType indicatorData
    );

}

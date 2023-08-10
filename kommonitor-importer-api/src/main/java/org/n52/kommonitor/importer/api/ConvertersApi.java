/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.n52.kommonitor.importer.api;

import org.n52.kommonitor.models.ConverterType;
import org.n52.kommonitor.models.Error;
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
@Tag(name = "converters", description = "the converters API")
public interface ConvertersApi {

    /**
     * GET /converters/{name} : Retrieve information about the selected converters
     * Retrieve information such like supported formats and decoding options about the selected converters for decoding a certain dataset and importing it into the KomMonitor Data Management layer
     *
     * @param name unique name of the converter (required)
     * @return OK (status code 200)
     *         or API key is missing or invalid (status code 401)
     *         or A converter with the specified name was not found (status code 404)
     */
    @Operation(
        operationId = "getConverterByName",
        summary = "Retrieve information about the selected converters",
        description = "Retrieve information such like supported formats and decoding options about the selected converters for decoding a certain dataset and importing it into the KomMonitor Data Management layer",
        tags = { "converters" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConverterType.class))
            }),
            @ApiResponse(responseCode = "401", description = "API key is missing or invalid"),
            @ApiResponse(responseCode = "404", description = "A converter with the specified name was not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        },
        security = {
            @SecurityRequirement(name = "oauth2")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/converters/{name}",
        produces = { "application/json" }
    )
    ResponseEntity<ConverterType> getConverterByName(
        @Parameter(name = "name", description = "unique name of the converter", required = true, in = ParameterIn.PATH) @PathVariable("name") String name
    );


    /**
     * GET /converters : Retrieve information about all available converters
     * Retrieve information such like supported formats and importing options about all available converters for decoding datasets and importing them into the KomMonitor Data Management layer
     *
     * @return OK (status code 200)
     *         or API key is missing or invalid (status code 401)
     */
    @Operation(
        operationId = "getConverters",
        summary = "Retrieve information about all available converters",
        description = "Retrieve information such like supported formats and importing options about all available converters for decoding datasets and importing them into the KomMonitor Data Management layer",
        tags = { "converters" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ConverterType.class)))
            }),
            @ApiResponse(responseCode = "401", description = "API key is missing or invalid")
        },
        security = {
            @SecurityRequirement(name = "oauth2")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/converters",
        produces = { "application/json" }
    )
    ResponseEntity<List<ConverterType>> getConverters(
        
    );

}

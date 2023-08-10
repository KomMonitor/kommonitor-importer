/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.n52.kommonitor.importer.api;

import org.n52.kommonitor.models.Error;
import org.n52.kommonitor.models.UploadedFileType;
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
@Tag(name = "upload", description = "the upload API")
public interface UploadApi {

    /**
     * GET /upload : Get a list of files
     * Retrieve a list of information for all uploaded files
     *
     * @return OK (status code 200)
     *         or API key is missing or invalid (status code 401)
     */
    @Operation(
        operationId = "getUploadedFiles",
        summary = "Get a list of files",
        description = "Retrieve a list of information for all uploaded files",
        tags = { "upload" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UploadedFileType.class)))
            }),
            @ApiResponse(responseCode = "401", description = "API key is missing or invalid")
        },
        security = {
            @SecurityRequirement(name = "oauth2")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/upload",
        produces = { "application/json" }
    )
    ResponseEntity<List<UploadedFileType>> getUploadedFiles(
        
    );


    /**
     * POST /upload : Upload a file
     * Upload a file that can be used as datasource for importing or updating a KomMonitor resource.
     *
     * @param file The file to upload (required)
     * @param filename The name that will be used for storing the file on the server (required)
     * @return Created (status code 201)
     *         or Bad Request (status code 400)
     *         or API key is missing or invalid (status code 401)
     *         or Unexpected error (status code 200)
     */
    @Operation(
        operationId = "upload",
        summary = "Upload a file",
        description = "Upload a file that can be used as datasource for importing or updating a KomMonitor resource.",
        tags = { "upload" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                @Content(mediaType = "*/*", schema = @Schema(implementation = String.class))
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
        value = "/upload",
        produces = { "*/*" },
        consumes = { "multipart/form-data" }
    )
    ResponseEntity<String> upload(
        @Parameter(name = "file", description = "The file to upload", required = true) @RequestPart(value = "file", required = true) MultipartFile file,
        @Parameter(name = "filename", description = "The name that will be used for storing the file on the server", required = true) @Valid @RequestParam(value = "filename", required = true) String filename
    );

}

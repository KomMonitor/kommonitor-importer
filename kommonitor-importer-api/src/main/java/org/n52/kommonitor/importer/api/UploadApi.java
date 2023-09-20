/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.n52.kommonitor.importer.api;

import org.n52.kommonitor.importer.api.exceptions.UploadException;
import org.n52.kommonitor.models.Error;
import org.springframework.core.io.Resource;
import org.n52.kommonitor.models.UploadedFileType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-22T08:55:12.468+01:00")

@Api(value = "upload", description = "the upload API")
public interface UploadApi {

    Logger log = LoggerFactory.getLogger(UploadApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Get a list of files", nickname = "getUploadedFiles", notes = "Retrieve a list of information for all uploaded files", response = UploadedFileType.class, responseContainer = "List", authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "upload", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = UploadedFileType.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "API key is missing or invalid") })
    @RequestMapping(value = "/upload",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<UploadedFileType>> getUploadedFiles() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"name\" : \"name\",  \"contentType\" : \"contentType\"}, {  \"name\" : \"name\",  \"contentType\" : \"contentType\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UploadApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Upload a file", nickname = "upload", notes = "Upload a file that can be used as datasource for importing or updating a KomMonitor resource.", response = String.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "upload", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = String.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/upload",
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    default ResponseEntity<String> upload(@ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile file,@ApiParam(value = "The name that will be used for storing the file on the server", required=true) @RequestParam(value="filename", required=true)  String filename) throws UploadException {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("\"\"", String.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UploadApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

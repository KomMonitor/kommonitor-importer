/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.n52.kommonitor.importer.api;

import org.n52.kommonitor.importer.models.ImportGeoresourcePOSTInputType;
import io.swagger.annotations.*;
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

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-21T17:15:04.699+01:00")

@Api(value = "georesources", description = "the georesources API")
public interface GeoresourcesApi {

    @ApiOperation(value = "Import a new geo-resource", nickname = "importGeoresource", notes = "Import a geo-resource dataset for a certain period of time. Parses Input source, extracts relevant data, performs schema mapping to KomMonitor data model and calls POST /georesources of KomMonitor Data Management API", authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "georesources", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "API key is missing or invalid"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/georesources",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> importGeoresource(@ApiParam(value = "feature data" ,required=true )  @Valid @RequestBody ImportGeoresourcePOSTInputType featureData);

}

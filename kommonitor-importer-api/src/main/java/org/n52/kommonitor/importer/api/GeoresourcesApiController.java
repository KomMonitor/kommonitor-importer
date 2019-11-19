package org.n52.kommonitor.importer.api;

import org.n52.kommonitor.importer.models.ImportGeoresourcePOSTInputType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-19T07:54:02.554+01:00")

@Controller
public class GeoresourcesApiController implements GeoresourcesApi {

    private static final Logger log = LoggerFactory.getLogger(GeoresourcesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GeoresourcesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> importGeoresource(@ApiParam(value = "feature data" ,required=true )  @Valid @RequestBody ImportGeoresourcePOSTInputType featureData) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}

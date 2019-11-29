package org.n52.kommonitor.importer.api;

import org.n52.kommonitor.importer.models.ImporterType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-29T14:03:48.485+01:00")

@Controller
public class ImportersApiController implements ImportersApi {

    private static final Logger log = LoggerFactory.getLogger(ImportersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ImportersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ImporterType> getImporterByName(@ApiParam(value = "unique name of the importer",required=true) @PathVariable("name") String name) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ImporterType>(objectMapper.readValue("{  \"encodings\" : [ \"encodings\", \"encodings\" ],  \"schemas\" : [ \"schemas\", \"schemas\" ],  \"name\" : \"name\",  \"mimeType\" : [ \"mimeType\", \"mimeType\" ],  \"parameters\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  } ]}", ImporterType.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ImporterType>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ImporterType>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ImporterType>> getImporters() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ImporterType>>(objectMapper.readValue("[ {  \"encodings\" : [ \"encodings\", \"encodings\" ],  \"schemas\" : [ \"schemas\", \"schemas\" ],  \"name\" : \"name\",  \"mimeType\" : [ \"mimeType\", \"mimeType\" ],  \"parameters\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  } ]}, {  \"encodings\" : [ \"encodings\", \"encodings\" ],  \"schemas\" : [ \"schemas\", \"schemas\" ],  \"name\" : \"name\",  \"mimeType\" : [ \"mimeType\", \"mimeType\" ],  \"parameters\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  } ]} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ImporterType>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ImporterType>>(HttpStatus.NOT_IMPLEMENTED);
    }

}

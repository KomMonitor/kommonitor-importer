package org.n52.kommonitor.importer.api;

import org.n52.kommonitor.importer.models.ConverterType;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-02T13:41:56.747+01:00")

@Controller
public class ConvertersApiController implements ConvertersApi {

    private static final Logger log = LoggerFactory.getLogger(ConvertersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ConvertersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ConverterType> getConverterByName(@ApiParam(value = "unique name of the converter",required=true) @PathVariable("name") String name) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConverterType>(objectMapper.readValue("{  \"encodings\" : [ \"encodings\", \"encodings\" ],  \"schemas\" : [ \"schemas\", \"schemas\" ],  \"name\" : \"name\",  \"mimeType\" : \"mimeType\",  \"parameters\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  } ]}", ConverterType.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConverterType>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConverterType>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ConverterType>> getConverters() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ConverterType>>(objectMapper.readValue("[ {  \"encodings\" : [ \"encodings\", \"encodings\" ],  \"schemas\" : [ \"schemas\", \"schemas\" ],  \"name\" : \"name\",  \"mimeType\" : \"mimeType\",  \"parameters\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  } ]}, {  \"encodings\" : [ \"encodings\", \"encodings\" ],  \"schemas\" : [ \"schemas\", \"schemas\" ],  \"name\" : \"name\",  \"mimeType\" : \"mimeType\",  \"parameters\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"type\" : \"string\"  } ]} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ConverterType>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ConverterType>>(HttpStatus.NOT_IMPLEMENTED);
    }

}

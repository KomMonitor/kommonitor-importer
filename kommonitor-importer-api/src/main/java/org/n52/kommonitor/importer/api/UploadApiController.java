package org.n52.kommonitor.importer.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.n52.kommonitor.importer.api.exceptions.ImportException;
import org.n52.kommonitor.importer.io.file.FileStorageService;
import org.n52.kommonitor.models.ConverterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-16T11:05:39.297+01:00")

@Controller
public class UploadApiController implements UploadApi {

    private static final Logger LOG = LoggerFactory.getLogger(UploadApiController.class);
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private FileStorageService storageService;

    @org.springframework.beans.factory.annotation.Autowired
    public UploadApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<String> upload(
            @ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile file,
            @ApiParam(value = "The name that will be used for storing the file on the server", required = true) @RequestParam(value = "filename", required = true) String filename) {
        LOG.info("Recevied 'upload' request for file: {}", filename != null ? filename : file.getOriginalFilename());

        try {
            String name = storageService.store(file, filename);
            return new ResponseEntity<String>(name, HttpStatus.CREATED);
        } catch (IOException e) {
            throw new ImportException(String.format("Could not store uploaded file '%s'", filename != null ? filename : file.getOriginalFilename()));
        }
    }
}

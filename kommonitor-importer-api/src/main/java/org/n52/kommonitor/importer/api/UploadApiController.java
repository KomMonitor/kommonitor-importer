package org.n52.kommonitor.importer.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import org.n52.kommonitor.importer.api.exceptions.UploadException;
import org.n52.kommonitor.importer.io.file.FileStorageService;
import org.n52.kommonitor.models.UploadedFileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-16T11:05:39.297+01:00")

@BaseController
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
            @Parameter(description = "The name that will be used for storing the file on the server", required = true)
            @RequestParam(value = "filename", required = true) String filename,
            @Parameter(description = "file detail")
            @Valid @RequestPart("file") MultipartFile file
            ) throws UploadException {
        LOG.info("Recevied 'upload' request for file: {}", filename != null ? filename : file.getOriginalFilename());

        try {
            String name = storageService.store(file, filename);
            LOG.info("Succesfully stored uploaded file: {}", name);
            return new ResponseEntity<String>(name, HttpStatus.CREATED);
        } catch (IOException ex) {
            throw new UploadException(file, ex);
        }
    }

    public ResponseEntity<List<UploadedFileType>> getUploadedFiles() {
        LOG.info("Recevied 'getUploadedFiles' request");

        List<UploadedFileType> fileList = storageService.getAll()
                .stream()
                .map(f -> createUploadedFileType(f))
                .collect(Collectors.toList());

        return new ResponseEntity<List<UploadedFileType>>(fileList, HttpStatus.OK);
    }

    private UploadedFileType createUploadedFileType(File file) {
        UploadedFileType fileType = new UploadedFileType();
        fileType.setName(file.getName());

        try {
            String contentType = storageService.getMetadata(FileStorageService.META_MIMETYPE, file);
            fileType.setContentType(contentType);
        } catch (IOException e) {
            LOG.warn(String.format("Could not get metadata '%s' for file '%s'", FileStorageService.META_MIMETYPE, file.getName()));
        }

        return fileType;
    }
}

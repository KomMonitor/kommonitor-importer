package org.n52.kommonitor.importer.api;

import org.n52.kommonitor.importer.api.handler.GeoresourceImportHandler;
import org.n52.kommonitor.importer.api.utils.ErrorFactory;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
import org.n52.kommonitor.importer.models.Error;
import org.n52.kommonitor.importer.models.ImportGeoresourcePOSTInputType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-02T16:59:46.021+01:00")

@Controller
public class GeoresourcesApiController implements GeoresourcesApi {

    private static final Logger LOG = LoggerFactory.getLogger(GeoresourcesApiController.class);

    @Autowired
    private ConverterRepository converterRepository;

    @Autowired
    private DataSourceRetrieverRepository retrieverRepository;

    @Autowired
    private GeoresourceImportHandler importHandler;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GeoresourcesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<String>> importGeoresource(@ApiParam(value = "feature data", required = true) @Valid @RequestBody ImportGeoresourcePOSTInputType featureData) {
        LOG.info("Received 'importGeoresource' request for dataset name: {}", featureData.getDatasetName());
        LOG.debug("'importGeoresource' POST request body: {}", featureData);
        return importHandler.handleImportRequest(featureData, featureData.getDataSource(), featureData.getConverter());
    }


}

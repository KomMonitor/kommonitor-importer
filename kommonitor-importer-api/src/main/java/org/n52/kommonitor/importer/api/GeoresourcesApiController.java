package org.n52.kommonitor.importer.api;

import org.n52.kommonitor.importer.api.handler.GeoresourceImportHandler;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
import org.n52.kommonitor.models.ImportGeoresourcePOSTInputType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

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
        LOG.info("Received 'importGeoresource' request for dataset name: {}", featureData.getGeoresourcePostBody().getDatasetName());
        LOG.debug("'importGeoresource' POST request body: {}", featureData);
        return importHandler.handleImportRequest(featureData, featureData.getDataSource(), featureData.getConverter());
    }


}

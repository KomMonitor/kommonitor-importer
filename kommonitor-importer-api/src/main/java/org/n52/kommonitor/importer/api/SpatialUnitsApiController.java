package org.n52.kommonitor.importer.api;

import org.n52.kommonitor.importer.api.handler.GeoresourceImportHandler;
import org.n52.kommonitor.importer.api.handler.SpatialUnitImportHandler;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
import org.n52.kommonitor.importer.models.Error;
import org.n52.kommonitor.importer.models.ImportSpatialUnitPOSTInputType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-02T16:59:46.021+01:00")

@Controller
public class SpatialUnitsApiController implements SpatialUnitsApi {

    private static final Logger LOG = LoggerFactory.getLogger(SpatialUnitsApiController.class);

    @Autowired
    private ConverterRepository converterRepository;

    @Autowired
    private DataSourceRetrieverRepository retrieverRepository;

    @Autowired
    private SpatialUnitImportHandler importHandler;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SpatialUnitsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<String>> importSpatialUnit(@ApiParam(value = "feature data", required = true) @Valid @RequestBody ImportSpatialUnitPOSTInputType featureData) {
        LOG.info("Received 'importSpatialUnit' request for spatial unit level: {}", featureData.getSpatialUnitPostBody().getSpatialUnitLevel());
        LOG.debug("'importSpatialUnit' request POST body: {}", featureData);
        return importHandler.handleImportRequest(featureData, featureData.getDataSource(), featureData.getConverter());
    }

}

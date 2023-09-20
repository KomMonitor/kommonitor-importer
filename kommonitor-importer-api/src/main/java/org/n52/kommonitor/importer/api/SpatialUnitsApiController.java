package org.n52.kommonitor.importer.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import org.n52.kommonitor.importer.api.exceptions.ImportException;
import org.n52.kommonitor.importer.api.handler.AbstractRequestHandler;
import org.n52.kommonitor.importer.api.handler.RequestHandlerRepository;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
import org.n52.kommonitor.models.ImportResponseType;
import org.n52.kommonitor.models.ImportSpatialUnitPOSTInputType;
import org.n52.kommonitor.models.UpdateSpatialUnitPOSTInputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-02T16:59:46.021+01:00")

@BaseController
public class SpatialUnitsApiController implements SpatialUnitsApi {

    private static final Logger LOG = LoggerFactory.getLogger(SpatialUnitsApiController.class);

    @Autowired
    private ConverterRepository converterRepository;

    @Autowired
    private DataSourceRetrieverRepository retrieverRepository;

    @Autowired
    private RequestHandlerRepository requestHandlerRepository;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SpatialUnitsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ImportResponseType> importSpatialUnit(
            @Parameter(description = "feature data", required = true)
            @Valid @RequestBody ImportSpatialUnitPOSTInputType featureData) throws ImportException, ImportParameterException {
        LOG.info("Received 'importSpatialUnit' request for spatial unit level: {}", featureData.getSpatialUnitPostBody().getSpatialUnitLevel());
        LOG.debug("'importSpatialUnit' request POST body: {}", featureData);

        Optional<AbstractRequestHandler> requestHandlertOpt = requestHandlerRepository.getRequestHandler(featureData);
        if (!requestHandlertOpt.isPresent()) {
            throw new ImportException(String.format("No request handler found for request type '%s'", featureData.getClass()));
        }
        return requestHandlertOpt.get().handleRequest(featureData, featureData.getDataSource(), featureData.getConverter());
    }


    @Override
    public ResponseEntity<ImportResponseType> updateSpatialUnit(@Valid UpdateSpatialUnitPOSTInputType featureData) throws ImportException, ImportParameterException {
        LOG.info("Received 'updateSpatialUnit' request for spatial unit: {}", featureData.getSpatialUnitId());
        LOG.debug("'updateSpatialUnit' request POST body: {}", featureData);

        Optional<AbstractRequestHandler> requestHandlertOpt = requestHandlerRepository.getRequestHandler(featureData);
        if (!requestHandlertOpt.isPresent()) {
            throw new ImportException(String.format("No request handler found for request type '%s'", featureData.getClass()));
        }
        return requestHandlertOpt.get().handleRequest(featureData, featureData.getDataSource(), featureData.getConverter());
    }

}

package org.n52.kommonitor.importer.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.n52.kommonitor.importer.api.exceptions.ImportException;
import org.n52.kommonitor.importer.api.handler.AbstractRequestHandler;
import org.n52.kommonitor.importer.api.handler.RequestHandlerRepository;
import org.n52.kommonitor.models.ImportResponseType;
import org.n52.kommonitor.models.UpdateIndicatorPOSTInputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-02T16:59:46.021+01:00")

@BaseController
public class IndicatorsApiController implements IndicatorsApi {

    private static final Logger LOG = LoggerFactory.getLogger(IndicatorsApiController.class);

    @Autowired
    private RequestHandlerRepository requestHandlerRepository;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public IndicatorsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<ImportResponseType> updateIndicator(@Valid UpdateIndicatorPOSTInputType indicatorData) {
        LOG.info("Received 'updateIndicator' request for Indicator: {}", indicatorData.getIndicatorId());
        LOG.debug("'updateGeoresource' POST request body: {}", indicatorData);

        Optional<AbstractRequestHandler> requestHandlertOpt = requestHandlerRepository.getRequestHandler(indicatorData);
        if (!requestHandlertOpt.isPresent()) {
            throw new ImportException(String.format("No request handler found for request type '%s'", indicatorData.getClass()));
        }
        return requestHandlertOpt.get().handleRequest(indicatorData, indicatorData.getDataSource(), indicatorData.getConverter());
    }


}

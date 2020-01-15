package org.n52.kommonitor.importer.api.handler;

import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;
import org.n52.kommonitor.importer.api.encoder.IndicatorEncoder;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPUTInputType;
import org.n52.kommonitor.models.UpdateIndicatorPOSTInputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.List;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class IndicatorUpdateHandler extends AbstractRequestHandler<UpdateIndicatorPOSTInputType> {

    private final static Logger LOG = LoggerFactory.getLogger(IndicatorUpdateHandler.class);

    @Autowired
    private IndicatorEncoder encoder;

    @Autowired
    private IndicatorsApi apiClient;

    @Override
    protected ResponseEntity<List<String>> performRequestHandling(UpdateIndicatorPOSTInputType requestResourceType,
                                                                  AbstractConverter converter,
                                                                  ConverterDefinitionType converterDefinition, Dataset dataset)
            throws ConverterException, ImportParameterException, RestClientException {
        LOG.info("Converting dataset with converter: {}", converter.getName());
        LOG.debug("Converter definition: {}", converterDefinition);
        List<IndicatorValue> spatialResources = converter.convertIndicators(
                converterDefinition,
                dataset,
                requestResourceType.getPropertyMapping());
        IndicatorPUTInputType indicatorPutInput = null;
        indicatorPutInput = encoder.encode(requestResourceType, spatialResources);

        LOG.info("Perform 'updateIndicator' request for Indicator: {}", requestResourceType.getIndicatorId());
        LOG.debug("'addIndicator' request POST body: {}", indicatorPutInput);
        ResponseEntity<Void> response = apiClient.updateIndicatorAsBodyWithHttpInfo(requestResourceType.getIndicatorId(), indicatorPutInput);
        List<String> locations = response.getHeaders().get(LOCATION_HEADER_KEY);
        LOG.info("Successfully executed 'updateIndicator' request. Updated Indicators: {}", locations);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(locations);
    }
}

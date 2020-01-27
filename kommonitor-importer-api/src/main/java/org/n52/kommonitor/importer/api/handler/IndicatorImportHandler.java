package org.n52.kommonitor.importer.api.handler;

import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;
import org.n52.kommonitor.importer.api.encoder.IndicatorEncoder;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.ImportIndicatorPOSTInputType;
import org.n52.kommonitor.models.IndicatorPOSTInputType;
import org.n52.kommonitor.models.UpdateGeoresourcePOSTInputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;

/**
 * Handles a Indicator import request by converting a {@link Dataset} into a {@link List< IndicatorValue >} and
 * encoding it into a {@link IndicatorPOSTInputType} in order to request the KomMonitor DataManagement API
 * for creating new Indicators.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class IndicatorImportHandler extends AbstractRequestHandler<ImportIndicatorPOSTInputType> {

    private final static Logger LOG = LoggerFactory.getLogger(IndicatorImportHandler.class);

    @Autowired
    private IndicatorEncoder encoder;

    @Autowired
    private IndicatorsApi apiClient;

    public boolean supports(Object requestType) {
        return requestType instanceof ImportIndicatorPOSTInputType;
    }

    @Override
    public ResponseEntity<List<String>> handleRequestForType(ImportIndicatorPOSTInputType importResourceType,
                                                             AbstractConverter converter,
                                                             ConverterDefinitionType converterDefinition,
                                                             Dataset dataset)
            throws ConverterException, ImportParameterException, RestClientException {
        LOG.info("Converting dataset with converter: {}", converter.getName());
        LOG.debug("Converter definition: {}", converterDefinition);
        List<IndicatorValue> indicatorValues = converter.convertIndicators(
                converterDefinition,
                dataset,
                importResourceType.getPropertyMapping());
        IndicatorPOSTInputType indicatorPostInput = null;
        indicatorPostInput = encoder.encode(importResourceType, indicatorValues);

        LOG.info("Perform 'addIndicator' request for Indicator: {}", indicatorPostInput.getDatasetName());
        LOG.debug("'addIndicator' request POST body: {}", indicatorPostInput);
        ResponseEntity<Void> response = apiClient.addIndicatorAsBodyWithHttpInfo(indicatorPostInput);
        List<String> locations = response.getHeaders().get(LOCATION_HEADER_KEY);
        LOG.info("Successfully executed 'addIndicator' request. Created Indicators: {}", locations);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(locations);
    }

}

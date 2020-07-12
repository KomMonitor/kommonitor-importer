package org.n52.kommonitor.importer.api.handler;

import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;
import org.n52.kommonitor.importer.api.encoder.IndicatorEncoder;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.ImportIndicatorPOSTInputType;
import org.n52.kommonitor.models.ImportResponseType;
import org.n52.kommonitor.models.IndicatorPOSTInputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.stream.Collectors;

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
    public ImportResponseType handleRequestForType(ImportIndicatorPOSTInputType requestResourceType,
                                                   AbstractConverter converter,
                                                   ConverterDefinitionType converterDefinition,
                                                   Dataset dataset)
            throws ConverterException, ImportParameterException, RestClientException {
        LOG.info("Converting dataset with converter: {}", converter.getName());
        LOG.debug("Converter definition: {}", converterDefinition);
        List<IndicatorValue> indicatorValues = converter.convertIndicators(
                converterDefinition,
                dataset,
                requestResourceType.getPropertyMapping());

        List<IndicatorValue> validIndicators = indicatorValues.stream()
                .filter(s -> validator.isValid(s, requestResourceType.getPropertyMapping().getKeepMissingOrNullValueIndicator()))
                .collect(Collectors.toList());
        if (validIndicators.isEmpty()) {
            throw new ConverterException("No valid Indicator could be parsed from the specified data source");
        }

        ImportResponseType importResponse = new ImportResponseType();

        if (!requestResourceType.isDryRun()) {
            IndicatorPOSTInputType indicatorPostInput = encoder.encode(requestResourceType, validIndicators);
            LOG.info("Perform 'addIndicator' request for Indicator: {}", indicatorPostInput.getDatasetName());
            LOG.debug("'addIndicator' request POST body: {}", indicatorPostInput);
            ResponseEntity<Void> response = apiClient.addIndicatorAsBodyWithHttpInfo(indicatorPostInput);
            String location = response.getHeaders().getFirst(LOCATION_HEADER_KEY);
            LOG.info("Successfully executed 'addIndicator' request. Created Indicators: {}", location);
            importResponse.setUri(location);
        }

        List<String> convertedResourceIds = validIndicators.stream()
                .map(s -> s.getSpatialReferenceKey())
                .collect(Collectors.toList());
        importResponse.setImportedFeatures(convertedResourceIds);
        return importResponse;
    }

}

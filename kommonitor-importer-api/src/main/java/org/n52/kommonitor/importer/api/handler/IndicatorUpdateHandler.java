package org.n52.kommonitor.importer.api.handler;

import jakarta.validation.constraints.NotNull;
import org.n52.kommonitor.datamanagement.api.client.IndicatorsApi;
import org.n52.kommonitor.importer.api.encoder.IndicatorEncoder;
import org.n52.kommonitor.importer.calculator.IndicatorCalculator;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class IndicatorUpdateHandler extends AbstractRequestHandler<UpdateIndicatorPOSTInputType> {

    private final static Logger LOG = LoggerFactory.getLogger(IndicatorUpdateHandler.class);

    @Autowired
    private IndicatorEncoder encoder;

    @Autowired
    private IndicatorsApi apiClient;

    @Autowired
    private IndicatorCalculator indicatorCalculator;

    public boolean supports(Object requestType) {
        return requestType instanceof UpdateIndicatorPOSTInputType;
    }

    @Override
    protected ImportResponseType handleRequestForType(UpdateIndicatorPOSTInputType requestResourceType,
                                                      AbstractConverter converter,
                                                      ConverterDefinitionType converterDefinition, Dataset<?> dataset)
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

        Map<String, List<IndicatorValue>> aggregatedIndicators;
        if (!(requestResourceType.getAggregations() != null && requestResourceType.getAggregations().isEmpty())) {
            aggregatedIndicators = new HashMap<>();
            requestResourceType.getAggregations().forEach(a -> {
                String spatialRefKeyProp = a.getSpatialReferenceKeyProperty();
                if (aggregatedIndicators.containsKey(spatialRefKeyProp)) {
                    LOG.warn("Aggregation for spatial reference key '{}' already exists and will be overwritten.", spatialRefKeyProp);
                }
                List<IndicatorValue> aggregation = null;
                try {
                    aggregation = indicatorCalculator.aggregate(validIndicators, a.getAggregateFunction(), a.getSpatialReferenceKeyProperty());
                    aggregatedIndicators.put(spatialRefKeyProp, aggregation);
                } catch (ImportParameterException e) {
                    LOG.error("Can not calculate aggregation for spatial unit with reference key property '{}'." +
                            " Aggregate function '{}' is not supported.", spatialRefKeyProp, a.getAggregateFunction());
                }
            });
        }

        ImportResponseType importResponse;

        if (!requestResourceType.getDryRun()) {
            importResponse = postUpdateIndicatorRequest(requestResourceType, validIndicators);
        } else {
            importResponse = new ImportResponseType();
        }

        List<String> convertedResourceIds = validIndicators.stream()
                .map(IndicatorValue::getSpatialReferenceKey)
                .collect(Collectors.toList());
        importResponse.setImportedFeatures(convertedResourceIds);
        return importResponse;
    }

    private ImportResponseType postUpdateIndicatorRequest(UpdateIndicatorPOSTInputType requestResourceType, List<IndicatorValue> validIndicators) {
        IndicatorPUTInputType indicatorPutInput = encoder.encode(requestResourceType, validIndicators);
        LOG.info("Perform 'updateIndicator' request for Indicator: {}", requestResourceType.getIndicatorId());
        LOG.debug("'updateIndicator' request PUT body: {}", indicatorPutInput);
        ResponseEntity<Void> response = apiClient.updateIndicatorAsBodyWithHttpInfo(requestResourceType.getIndicatorId(), indicatorPutInput);
        String location = response.getHeaders().getFirst(LOCATION_HEADER_KEY);
        LOG.info("Successfully executed 'updateIndicator' request. Updated Indicators: {}", location);

        ImportResponseType importResponse = new ImportResponseType();
        importResponse.setUri(location);
        return importResponse;
    }
}

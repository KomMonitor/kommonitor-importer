package org.n52.kommonitor.importer.api.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;
import org.n52.kommonitor.importer.api.encoder.SpatialResourceJsonEncoder;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles a SpatialUnit import request by converting a {@link Dataset} into a {@link List<SpatialResource>} and
 * encoding it into a {@link SpatialUnitPOSTInputType} in order to request the KomMonitor DataManagement API
 * for creating new SpatialUnits.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class SpatialUnitImportHandler extends AbstractRequestHandler<ImportSpatialUnitPOSTInputType> {

    private final static Logger LOG = LoggerFactory.getLogger(SpatialUnitImportHandler.class);

    public boolean supports(Object requestType) {
        return requestType instanceof ImportSpatialUnitPOSTInputType;
    }

    @Autowired
    private SpatialResourceJsonEncoder spatialResourceEncoder;

    @Autowired
    private SpatialUnitsApi apiClient;

    @Override
    public ImportResponseType handleRequestForType(ImportSpatialUnitPOSTInputType requestResourceType,
                                                   AbstractConverter converter,
                                                   ConverterDefinitionType converterDefinition,
                                                   Dataset dataset)
            throws ConverterException, ImportParameterException, RestClientException {
        LOG.info("Converting dataset with converter: {}", converter.getName());
        LOG.debug("Converter definition: {}", converterDefinition);
        List<SpatialResource> spatialResources = converter.convertSpatialResources(
                converterDefinition,
                dataset,
                requestResourceType.getPropertyMapping());

        List<SpatialResource> validResources = spatialResources.stream().filter(s -> validator.isValid(s)).collect(Collectors.toList());
        if (validResources.isEmpty()) {
            throw new ConverterException("No valid SpatialUnit could be parsed from the specified data source");
        }

        ImportResponseType importResponse = new ImportResponseType();

        if(!requestResourceType.getDryRun()){
            SpatialUnitPOSTInputType spatialUnitPostInput = requestResourceType.getSpatialUnitPostBody();
            try {
                spatialUnitPostInput.setGeoJsonString(spatialResourceEncoder.encodeSpatialResourcesAsString(validResources));
            } catch (JsonProcessingException ex) {
                throw new ImportParameterException("Could not encode SpatialUnit.", ex);
            }

            LOG.info("Perform 'addSpatialUnit' request for SpatialUnit level: {}", spatialUnitPostInput.getSpatialUnitLevel());
            LOG.debug("'addSpatialUnit' request POST body: {}", spatialUnitPostInput);
            ResponseEntity<SpatialUnitOverviewType> response = apiClient.addSpatialUnitAsBodyWithHttpInfo(spatialUnitPostInput);
            String location = response.getHeaders().getFirst(LOCATION_HEADER_KEY);
            LOG.info("Successfully executed 'addSpatialUnit' request. Created SpatialUnits: {}", location);
            importResponse.setUri(location);
        }

        List<String> convertedResourceIds = validResources.stream()
                .map(s -> s.getId())
                .collect(Collectors.toList());
        importResponse.setImportedFeatures(convertedResourceIds);
        return importResponse;
    }
}

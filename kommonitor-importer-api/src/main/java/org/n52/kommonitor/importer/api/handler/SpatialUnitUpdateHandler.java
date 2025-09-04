package org.n52.kommonitor.importer.api.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;
import org.n52.kommonitor.importer.api.encoder.SpatialResourceJsonEncoder;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.ImportResponseType;
import org.n52.kommonitor.models.SpatialUnitPUTInputType;
import org.n52.kommonitor.models.UpdateSpatialUnitPOSTInputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles a SpatialUnit update request by converting a {@link Dataset} into a {@link List<SpatialResource>} and
 * encoding it into a {@link SpatialUnitPUTInputType} in order to request the KomMonitor DataManagement API
 * for updating existing SpatialUnits.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class SpatialUnitUpdateHandler extends AbstractRequestHandler<UpdateSpatialUnitPOSTInputType> {

    private final static Logger LOG = LoggerFactory.getLogger(SpatialUnitUpdateHandler.class);

    @Autowired
    private SpatialResourceJsonEncoder spatialResourceEncoder;

    @Autowired
    private SpatialUnitsApi apiClient;

    public boolean supports(Object requestType) {
        return requestType instanceof UpdateSpatialUnitPOSTInputType;
    }

    @Override
    protected ImportResponseType handleRequestForType(UpdateSpatialUnitPOSTInputType requestResourceType,
                                                      AbstractConverter converter,
                                                      ConverterDefinitionType converterDefinition,
                                                      Dataset<?> dataset)
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

        if (!requestResourceType.getDryRun()) {
            SpatialUnitPUTInputType spatialUnitPutInput = requestResourceType.getSpatialUnitPutBody();
            try {
                spatialUnitPutInput.setGeoJsonString(spatialResourceEncoder.encodeSpatialResourcesAsString(validResources));
                spatialUnitPutInput.isPartialUpdate(requestResourceType.getSpatialUnitPutBody().getIsPartialUpdate());
            } catch (JsonProcessingException ex) {
                throw new ImportParameterException("Could not encode SpatialUnit.", ex);
            }

            LOG.info("Perform 'updateSpatialUnit' request for SpatialUnit: {}", requestResourceType.getSpatialUnitId());
            LOG.debug("'updateSpatialUnit' request PUT body: {}", spatialUnitPutInput);
            ResponseEntity<Void> response = apiClient.updateSpatialUnitAsBodyWithHttpInfo(requestResourceType.getSpatialUnitId(), spatialUnitPutInput);
            String location = response.getHeaders().getFirst(LOCATION_HEADER_KEY);
            LOG.info("Successfully executed 'updateSpatialUnit' request. Updated SpatialUnits: {}", location);
            importResponse.setUri(location);
        }

        List<String> convertedResourceIds = validResources.stream()
                .map(SpatialResource::getId)
                .collect(Collectors.toList());
        importResponse.setImportedFeatures(convertedResourceIds);
        return importResponse;
    }
}

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
import org.n52.kommonitor.models.ImportSpatialUnitPOSTInputType;
import org.n52.kommonitor.models.SpatialUnitPUTInputType;
import org.n52.kommonitor.models.UpdateSpatialUnitPOSTInputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;

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
    protected ResponseEntity<List<String>> performRequestHandling(UpdateSpatialUnitPOSTInputType requestResourceType,
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
        SpatialUnitPUTInputType spatialUnitPutInput = requestResourceType.getSpatialUnitPutBody();
        try {
            spatialUnitPutInput.setGeoJsonString(spatialResourceEncoder.encodeSpatialResourcesAsString(spatialResources));
        } catch (JsonProcessingException ex) {
            throw new ImportParameterException("Could not encode SpatialUnit.", ex);
        }

        LOG.info("Perform 'updateSpatialUnit' request for SpatialUnit: {}", requestResourceType.getSpatialUnitId());
        LOG.debug("'addSpatialUnit' request POST body: {}", spatialUnitPutInput);
        ResponseEntity<Void> response = apiClient.updateSpatialUnitAsBodyWithHttpInfo(requestResourceType.getSpatialUnitId(), spatialUnitPutInput);
        List<String> locations = response.getHeaders().get(LOCATION_HEADER_KEY);
        LOG.info("Successfully executed 'updateSpatialUnit' request. Updated SpatialUnits: {}", locations);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(locations);
    }
}

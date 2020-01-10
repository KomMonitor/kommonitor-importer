package org.n52.kommonitor.importer.api.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.n52.kommonitor.datamanagement.api.client.SpatialUnitsApi;
import org.n52.kommonitor.importer.api.encoder.SpatialUnitEncoder;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.ImportSpatialUnitPOSTInputType;
import org.n52.kommonitor.importer.models.SpatialUnitPOSTInputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;

/**
 * Handles a SpatialUnit import request by converting a {@link Dataset} into a {@link List<SpatialResource>} and
 * encoding it into a {@link SpatialUnitPOSTInputType} in order to request the KomMonitor DataManagement API
 * for creating new SpatialUnits.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class SpatialUnitImportHandler extends AbstractImportHandler<ImportSpatialUnitPOSTInputType> {

    private final static Logger LOG = LoggerFactory.getLogger(SpatialUnitImportHandler.class);

    @Autowired
    private SpatialUnitEncoder encoder;

    @Autowired
    private SpatialUnitsApi apiClient;

    @Override
    public ResponseEntity<List<String>> importResource(ImportSpatialUnitPOSTInputType importResourceType,
                                                       AbstractConverter converter,
                                                       ConverterDefinitionType converterDefinition,
                                                       Dataset dataset)
            throws ConverterException, ImportParameterException, RestClientException {
        LOG.info("Converting dataset with converter: {}", converter.getName());
        LOG.debug("Converter definition: {}", converterDefinition);
        List<SpatialResource> spatialResources = converter.convertSpatialResources(
                converterDefinition,
                dataset,
                importResourceType.getPropertyMapping());
        SpatialUnitPOSTInputType spatialUnitPostInput = null;
        try {
            spatialUnitPostInput = encoder.encode(importResourceType, spatialResources);
        } catch (JsonProcessingException ex) {
            throw new ImportParameterException("Could not encode SpatialUnit.", ex);
        }

        LOG.info("Perform 'addSpatialUnit' request for SpatialUnit level: {}", spatialUnitPostInput.getSpatialUnitLevel());
        LOG.debug("'addSpatialUnit' request POST body: {}", spatialUnitPostInput);
        ResponseEntity<Void> response = apiClient.addSpatialUnitAsBodyWithHttpInfo(spatialUnitPostInput);
        List<String> locations = response.getHeaders().get(LOCATION_HEADER_KEY);
        LOG.info("Successfully executed 'addSpatialUnit' request. Created SpatialUnits: {}", locations);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(locations);
    }
}

package org.n52.kommonitor.importer.api.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;

/**
 * Handles a Georesource update request by converting a {@link Dataset} into a {@link List<SpatialResource>} and
 * encoding it into a {@link GeoresourcePOSTInputType} in order to request the KomMonitor DataManagement API
 * for updateing an existing Georesource.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class GeoresourceUpdateHandler extends AbstractRequestHandler<UpdateGeoresourcePOSTInputType> {

    private final static Logger LOG = LoggerFactory.getLogger(GeoresourceUpdateHandler.class);

    @Autowired
    private SpatialResourceJsonEncoder spatialResourceEncoder;

    @Autowired
    private GeoresourcesApi apiClient;

    public boolean supports(Object requestType) {
        return requestType instanceof UpdateGeoresourcePOSTInputType;
    }

    @Override
    public ResponseEntity<List<String>> performRequestHandling(UpdateGeoresourcePOSTInputType requestResourceType,
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
        GeoresourcePUTInputType georesourcePutInput = requestResourceType.getGeoresourcePutBody();
        try {
            georesourcePutInput.setGeoJsonString(spatialResourceEncoder.encodeSpatialResourcesAsString(spatialResources));
        } catch (JsonProcessingException ex) {
            throw new ImportParameterException("Could not encode Georesource.", ex);
        }

        LOG.info("Perform 'updateGeoresource' request for Georesource dataset: {}", requestResourceType.getGeoresourceId());
        LOG.debug("'updateGeoresource' request PUT body: {}", georesourcePutInput);
        ResponseEntity<Void> response = apiClient.updateGeoresourceAsBodyWithHttpInfo(requestResourceType.getGeoresourceId(), georesourcePutInput);
        List<String> locations = response.getHeaders().get(LOCATION_HEADER_KEY);
        LOG.info("Successfully executed 'updateGeoresource' request. Updated Georesources: {}", locations);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(locations);
    }
}
package org.n52.kommonitor.importer.api.handler;

import org.n52.kommonitor.datamanagement.api.client.GeoresourcesApi;
import org.n52.kommonitor.datamanagement.api.models.GeoresourcePOSTInputType;
import org.n52.kommonitor.importer.api.encoder.GeoresourceEncoder;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;

import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.ImportGeoresourcePOSTInputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;

/**
 * Handles a georesource import request by converting a {@link Dataset} into a {@link List<SpatialResource>} and
 * mapping
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class GeoresourceImportHandler extends AbstractImportHandler<ImportGeoresourcePOSTInputType> {
    private static final String LOCATION_HEADER_KEY = "location";

    @Autowired
    private GeoresourceEncoder encoder;

    @Autowired
    private GeoresourcesApi apiClient;

    @Override
    public ResponseEntity importResource(ImportGeoresourcePOSTInputType importResourceType,
                                         AbstractConverter converter,
                                         ConverterDefinitionType converterDefinition,
                                         Dataset dataset)
            throws ConverterException, RestClientException, ImportParameterException {
        List<SpatialResource> spatialResources = converter.convertSpatialResources(
                converterDefinition,
                dataset,
                importResourceType.getPropertyMapping());
        GeoresourcePOSTInputType georesourcePostInput = encoder.encode(importResourceType, spatialResources);

        ResponseEntity<Void> response = apiClient.addGeoresourceAsBodyWithHttpInfo(georesourcePostInput);
        List<String> locations = response.getHeaders().get(LOCATION_HEADER_KEY);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(locations);
    }
}

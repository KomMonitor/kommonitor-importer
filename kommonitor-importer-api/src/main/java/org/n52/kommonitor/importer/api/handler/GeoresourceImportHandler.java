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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles a Georesource import request by converting a {@link Dataset} into a {@link List<SpatialResource>} and
 * encoding it into a {@link GeoresourcePOSTInputType} in order to request the KomMonitor DataManagement API
 * for creating new Georesource.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class GeoresourceImportHandler extends AbstractRequestHandler<ImportGeoresourcePOSTInputType> {

    private final static Logger LOG = LoggerFactory.getLogger(GeoresourceImportHandler.class);

    @Autowired
    private SpatialResourceJsonEncoder spatialResourceEncoder;

    @Autowired
    private GeoresourcesApi apiClient;

    public boolean supports(Object requestType) {
        return requestType instanceof ImportGeoresourcePOSTInputType;
    }

    @Override
    public ImportResponseType handleRequestForType(ImportGeoresourcePOSTInputType requestResourceType,
                                                   AbstractConverter converter,
                                                   ConverterDefinitionType converterDefinition,
                                                   Dataset dataset)
            throws ConverterException, RestClientException, ImportParameterException {
        LOG.info("Converting dataset with converter: {}", converter.getName());
        LOG.debug("Converter definition: {}", converterDefinition);
        List<SpatialResource> spatialResources = converter.convertSpatialResources(
                converterDefinition,
                dataset,
                requestResourceType.getPropertyMapping());

        List<SpatialResource> validResources = spatialResources.stream().filter(s -> validator.isValid(s)).collect(Collectors.toList());
        if (validResources.isEmpty()) {
            throw new ConverterException("No valid Georesource could be parsed from the specified data source - no features found!");
        }

        ImportResponseType importResponse = new ImportResponseType();

        if (!requestResourceType.getDryRun()) {
            GeoresourcePOSTInputType georesourcePostInput = requestResourceType.getGeoresourcePostBody();
            try {
                georesourcePostInput.setGeoJsonString(spatialResourceEncoder.encodeSpatialResourcesAsString(validResources));
            } catch (JsonProcessingException ex) {
                throw new ImportParameterException("Could not encode Georesource.", ex);
            }

            LOG.info("Perform 'addGeoresource' request for Georesource dataset: {}", georesourcePostInput.getDatasetName());
            LOG.debug("'addGeoresource' request POST body: {}", georesourcePostInput);
            ResponseEntity<GeoresourceOverviewType> response = apiClient.addGeoresourceAsBodyWithHttpInfo(georesourcePostInput);
            String location = response.getHeaders().getFirst(LOCATION_HEADER_KEY);
            LOG.info("Successfully executed 'addGeoresource' request. Created Georesources: {}", location);
            importResponse.setUri(location);
        }

        List<String> convertedResourceIds = validResources.stream()
                .map(s -> s.getId())
                .collect(Collectors.toList());
        importResponse.setImportedFeatures(convertedResourceIds);
        return importResponse;
    }
}

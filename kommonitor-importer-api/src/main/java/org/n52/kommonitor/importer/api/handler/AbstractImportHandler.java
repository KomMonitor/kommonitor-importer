package org.n52.kommonitor.importer.api.handler;

import org.n52.kommonitor.importer.api.utils.ErrorFactory;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.DataSourceDefinitionType;
import org.n52.kommonitor.importer.models.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.Optional;

/**
 * Abstract handler for import requests. Takes an import resource of type T and delegates the dataset retrieving and
 * converting into a certain resource that will be imported into the KomMonitor Data Management layer.
 * The import has to be implemented by extending classes by the use of a certain API client that will send a typed
 * import request to the KomMonitor Data Management.
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public abstract class AbstractImportHandler<T> {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private ConverterRepository converterRepository;

    @Autowired
    private DataSourceRetrieverRepository retrieverRepository;

    /**
     * Handles import of a certain resource for a import request by performing the dataset retrieving and converting
     * as well as the import of the converted resource.
     *
     * @param importResourceType   an import resource type that holds all definitions for importing a certain resource
     * @param datasourceDefinition definition of the datasource to retrieve a dataset from
     * @param converterDefinition  definition of the converter to be used for converting the retrieved dataset
     * @return {@link ResponseEntity<List<String>>} that holds the IDs for the imported resources within the
     * Data Management API if the import was succesful or {@link ResponseEntity<Error>} that holds an error message
     * if the import failed.
     */
    public ResponseEntity handleImportRequest(T importResourceType, DataSourceDefinitionType datasourceDefinition, ConverterDefinitionType converterDefinition) {
        Optional<AbstractDataSourceRetriever> retrieverOpt = retrieverRepository.getDatasourceRetriever(datasourceDefinition.getType().name());

        if (!retrieverOpt.isPresent()) {
            String message = "Datasource type not found: " + datasourceDefinition.getType().name();
            LOG.error(message, message);
            Error error = ErrorFactory.getError(HttpStatus.BAD_REQUEST.value(),
                    "No support for the specified datasource type: " + datasourceDefinition.getType().name());
            ResponseEntity entity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            return entity;
        }
        Optional<AbstractConverter> converterOpt = converterRepository.getConverter(converterDefinition.getName());
        if (!converterOpt.isPresent()) {
            String message = "Converter type not found: " + converterDefinition.getName();
            LOG.error(message, message);
            Error error = ErrorFactory.getError(HttpStatus.BAD_REQUEST.value(),
                    "No support for the specified converter: " + converterDefinition.getName());
            ResponseEntity entity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            return entity;
        }
        try {
            Dataset dataset = retrieverOpt.get().retrieveDataset(datasourceDefinition);

            return importResource(importResourceType, converterOpt.get(), converterDefinition, dataset);
        } catch (ConverterException | DataSourceRetrieverException | RestClientException ex) {
            String message = "Error while importing resource: ";
            LOG.error(message, ex.getMessage());
            LOG.debug(message, ex);
            Error error = ErrorFactory.getError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    ex.getMessage());
            ResponseEntity entity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
            return entity;
        } catch (ImportParameterException ex) {
            String message = "Invalid request parameters: ";
            LOG.error(message, ex.getMessage());
            LOG.debug(message, ex);
            Error error = ErrorFactory.getError(HttpStatus.BAD_REQUEST.value(),
                    ex.getMessage());
            ResponseEntity entity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            return entity;
        }
    }

    public abstract ResponseEntity importResource(T importResourceType, AbstractConverter converter, ConverterDefinitionType converterDefinition, Dataset dataset) throws ConverterException, ImportParameterException, RestClientException;
}
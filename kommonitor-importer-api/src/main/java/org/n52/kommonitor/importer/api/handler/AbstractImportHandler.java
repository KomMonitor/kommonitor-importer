package org.n52.kommonitor.importer.api.handler;

import org.n52.kommonitor.importer.api.exceptions.ImportException;
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
import org.springframework.context.annotation.Import;
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
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public abstract class AbstractImportHandler<T> {

    protected static final String LOCATION_HEADER_KEY = "location";

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
    public ResponseEntity<List<String>> handleImportRequest(T importResourceType, DataSourceDefinitionType datasourceDefinition, ConverterDefinitionType converterDefinition) throws ImportParameterException, ImportException {
        Optional<AbstractDataSourceRetriever> retrieverOpt = retrieverRepository.getDatasourceRetriever(datasourceDefinition.getType().name());

        if (!retrieverOpt.isPresent()) {
            throw new ImportParameterException("No support for the specified datasource type: " + datasourceDefinition.getType().name());
        }
        Optional<AbstractConverter> converterOpt = converterRepository.getConverter(converterDefinition.getName());
        if (!converterOpt.isPresent()) {
            throw new ImportParameterException("No support for the specified converter: " + converterDefinition.getName());
        }
        converterOpt.get().validateDefinition(converterDefinition);
        try {
            LOG.info("Retrieving dataset from datasource: {}", datasourceDefinition.getType());
            LOG.debug("Datasource definition: {}", datasourceDefinition);
            Dataset dataset = retrieverOpt.get().retrieveDataset(datasourceDefinition);

            return importResource(importResourceType, converterOpt.get(), converterDefinition, dataset);
        } catch (ConverterException | DataSourceRetrieverException | RestClientException ex) {
            String baseMessage = "Error while importing resource.";
            LOG.error(String.format("%s%n%s", baseMessage, ex.getMessage()));
            LOG.debug(String.format("%s%n%s", baseMessage, importResourceType), ex);
            throw new ImportException("Error while importing resource", ex);
        }
    }

    public abstract ResponseEntity<List<String>> importResource(T importResourceType, AbstractConverter converter, ConverterDefinitionType converterDefinition, Dataset dataset) throws ConverterException, ImportParameterException, RestClientException;
}
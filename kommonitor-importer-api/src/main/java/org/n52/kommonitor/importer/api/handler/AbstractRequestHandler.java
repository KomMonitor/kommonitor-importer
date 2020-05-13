package org.n52.kommonitor.importer.api.handler;

import org.n52.kommonitor.importer.api.exceptions.ImportException;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
import org.n52.kommonitor.importer.utils.EntityValidator;
import org.n52.kommonitor.importer.utils.ImportMonitor;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.Error;
import org.n52.kommonitor.models.ImportResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

/**
 * Abstract handler for import requests. Takes an import resource of type T and delegates the dataset retrieving and
 * converting into a certain resource that will be imported into the KomMonitor Data Management layer.
 * The import has to be implemented by extending classes by the use of a certain API client that will send a typed
 * import request to the KomMonitor Data Management.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public abstract class AbstractRequestHandler<T> {

    protected static final String LOCATION_HEADER_KEY = "location";

    private final Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    protected EntityValidator validator;

    @Autowired
    private ConverterRepository converterRepository;

    @Autowired
    private DataSourceRetrieverRepository retrieverRepository;

    @Autowired
    private ImportMonitor monitor;

    /**
     * Checks if a certain request type is supported by this request handler
     *
     * @param requestType the request type to check
     * @return true if the request type is supported
     */
    public abstract boolean supports(Object requestType);

    /**
     * Handles a certain request for importing or updating a certain resource by performing the dataset retrieving and converting
     * as well as the import/update of the converted resource.
     *
     * @param requestResourceType  an request resource type that holds all definitions for handling the request
     * @param dataSourceDefinition definition of the datasource to retrieve a dataset from
     * @param converterDefinition  definition of the converter to be used for converting the retrieved dataset
     * @return {@link ResponseEntity<ImportResponseType>} that holds the IDs for the affected resources within the
     * Data Management API if the request was succesfull or {@link ResponseEntity<Error>} that holds an error message
     * if the request failed.
     */
    public ResponseEntity<ImportResponseType> handleRequest(T requestResourceType,
                                                            DataSourceDefinitionType dataSourceDefinition,
                                                            ConverterDefinitionType converterDefinition)
            throws ImportParameterException, ImportException {
        Optional<AbstractDataSourceRetriever> retrieverOpt = retrieverRepository.getDataSourceRetriever(dataSourceDefinition.getType().name());
        Optional<AbstractConverter> converterOpt = converterRepository.getConverter(converterDefinition.getName());
        checkRequest(retrieverOpt, converterOpt, dataSourceDefinition, converterDefinition);
        try {
            LOG.info("Retrieving dataset from datasource: {}", dataSourceDefinition.getType());
            LOG.debug("Datasource definition: {}", dataSourceDefinition);
            Dataset dataset = retrieverOpt.get().retrieveDataset(dataSourceDefinition);

            ImportResponseType importResponse = handleRequestForType(requestResourceType, converterOpt.get(), converterDefinition, dataset);
            importResponse.setErrors(monitor.getErrorMessages());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(importResponse);

        } catch (ConverterException | DataSourceRetrieverException | RestClientException ex) {
            String baseMessage = "Error while handling request.";
            LOG.error(String.format("%s%n%s", baseMessage, ex.getMessage()));
            LOG.debug(String.format("%s%n%s", baseMessage, requestResourceType), ex);
            throw new ImportException(ex.getMessage());
        }
    }

    protected abstract ImportResponseType handleRequestForType(T requestResourceType,
                                                               AbstractConverter abstractConverter,
                                                               ConverterDefinitionType converterDefinition,
                                                               Dataset dataset) throws ConverterException, ImportParameterException, RestClientException;


    private void checkRequest(Optional<AbstractDataSourceRetriever> retrieverOpt,
                              Optional<AbstractConverter> converterOpt,
                              DataSourceDefinitionType datasourceDefinition,
                              ConverterDefinitionType converterDefinition) throws ImportParameterException {
        if (!retrieverOpt.isPresent()) {
            throw new ImportParameterException("No support for the specified datasource type: " + datasourceDefinition.getType().name());
        }

        if (!converterOpt.isPresent()) {
            throw new ImportParameterException("No support for the specified converter: " + converterDefinition.getName());
        }
        converterOpt.get().validateDefinition(converterDefinition);
    }


}
package org.n52.kommonitor.importer.io.datasource;

import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.file.FileStorageService;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Retriever for datasets within a file that has become available in the internal file storage by uploading it
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class FileRetriever extends AbstractDataSourceRetriever<File> {

    private static final String TYPE = "FILE";
    private static final String PARAM_NAME = "NAME";
    private static final String PARAM_NAME_DESC = "The name of the file that is stored within the internal data storage " +
            "and contains the datasets that should be imported.";

    private FileStorageService storageService;

    @Autowired
    public FileRetriever(FileStorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    protected String initType() {
        return TYPE;
    }

    @Override
    protected Set<DataSourceParameter> initSupportedParameters() {
        Set<DataSourceParameter> parameters = new HashSet<>();
        DataSourceParameter payloadParam = new DataSourceParameter(PARAM_NAME, PARAM_NAME_DESC, DataSourceParameter.ParameterTypeValues.STRING);
        parameters.add(payloadParam);
        return parameters;
    }

    @Override
    public Dataset<File> retrieveDataset(DataSourceDefinitionType datasource) throws DataSourceRetrieverException, ImportParameterException {
        Optional<String> fileNameOpt = this.getParameterValue(PARAM_NAME, datasource.getParameters());
        if (!fileNameOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_NAME);
        }
        File file = storageService.get(fileNameOpt.get());
        if (!file.exists()) {
            throw new DataSourceRetrieverException("No stored file with name: " + fileNameOpt.get());
        }
        return new Dataset<>(file);
    }
}

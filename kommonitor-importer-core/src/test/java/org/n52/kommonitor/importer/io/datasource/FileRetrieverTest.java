package org.n52.kommonitor.importer.io.datasource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.file.FileStorageService;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.ParameterValueType;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class FileRetrieverTest {

    private static final String FILE_NAME = "test-file.xml";

    @Test
    @DisplayName("Test retrieve file dataset for an existing file")
    void testRetrieveFileDatasetForExistingFile() throws DataSourceRetrieverException, ImportParameterException {
        FileStorageService storageService = Mockito.mock(FileStorageService.class);
        File file = Mockito.mock(File.class);
        Mockito.when(file.getName()).thenReturn(FILE_NAME);
        Mockito.when(file.exists()).thenReturn(true);
        Mockito.when(storageService.get(Mockito.anyString())).thenReturn(file);

        FileRetriever retriever = new FileRetriever(storageService);
        DataSourceDefinitionType dataSourceDefinition = createDataSourceDefinition();

        Dataset<File> dataset = retriever.retrieveDataset(dataSourceDefinition);

        Assertions.assertEquals(FILE_NAME, dataset.getData().getName());
    }

    @Test
    @DisplayName("Test retrieve file dataset should throw ImportParameterException for non valid parameters")
    void testRetrieveFileDatasetShouldThrowImportParameterExceptionForNonValidParameters() {
        FileStorageService storageService = Mockito.mock(FileStorageService.class);

        FileRetriever retriever = new FileRetriever(storageService);
        DataSourceDefinitionType dataSourceDefinition = createDataSourceDefinition();
        dataSourceDefinition.setParameters(Collections.emptyList());

        Assertions.assertThrows(ImportParameterException.class, () -> retriever.retrieveDataset(dataSourceDefinition));
    }

    @Test
    @DisplayName("Test retrieve file dataset should throw DataSourceRetrieverException for non existing file")
    void testRetrieveFileDatasetShouldThrowDatasourceRetrieverExceptionForNonExistingFile() {
        FileStorageService storageService = Mockito.mock(FileStorageService.class);
        File file = Mockito.mock(File.class);
        Mockito.when(file.getName()).thenReturn(FILE_NAME);
        Mockito.when(file.exists()).thenReturn(false);
        Mockito.when(storageService.get(Mockito.anyString())).thenReturn(file);

        FileRetriever retriever = new FileRetriever(storageService);
        DataSourceDefinitionType dataSourceDefinition = createDataSourceDefinition();

        Assertions.assertThrows(DataSourceRetrieverException.class, () -> retriever.retrieveDataset(dataSourceDefinition));

    }

    private DataSourceDefinitionType createDataSourceDefinition() {
        DataSourceDefinitionType dataSourceDefinition = new DataSourceDefinitionType();
        dataSourceDefinition.setType(DataSourceDefinitionType.TypeEnum.FILE);

        ParameterValueType parameter = new ParameterValueType();
        parameter.setName("NAME");
        parameter.setValue(FILE_NAME);
        List<ParameterValueType> parameterList = Collections.singletonList(parameter);

        dataSourceDefinition.setParameters(parameterList);

        return dataSourceDefinition;
    }
}

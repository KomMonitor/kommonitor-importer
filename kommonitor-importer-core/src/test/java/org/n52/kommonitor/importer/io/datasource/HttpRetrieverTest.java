package org.n52.kommonitor.importer.io.datasource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.file.FileStorageService;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.ParameterValueType;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class HttpRetrieverTest {

    private static final String URL = "http://www.dummy-test.de";

    @Test
    @DisplayName("Test retrieve HTTP dataset should throw ImportParameterException for non valid parameters")
    void testRetrieveHttpDatasetShouldThrowImportParameterExceptionForNonValidParameters() throws IOException {
        HttpRetriever retriever = new HttpRetriever();
        retriever.postConstruct();
        DataSourceDefinitionType dataSourceDefinition = createDataSourceDefinition();
        dataSourceDefinition.setParameters(Collections.emptyList());

        Assertions.assertThrows(ImportParameterException.class, () -> retriever.retrieveDataset(dataSourceDefinition));
    }

    @Test
    @DisplayName("Test retrieve HTTP dataset should throw DataSourceRetrieverException for non retrievable URL")
    void testRetrieveHttpDatasetShouldThrowImportParameterExceptionForNonRetrievableUrl() throws IOException {
        HttpRetriever retriever = new HttpRetriever();
        retriever.postConstruct();
        DataSourceDefinitionType dataSourceDefinition = createDataSourceDefinition();

        Assertions.assertThrows(DataSourceRetrieverException.class, () -> retriever.retrieveDataset(dataSourceDefinition));
    }

    private DataSourceDefinitionType createDataSourceDefinition() {
        DataSourceDefinitionType dataSourceDefinition = new DataSourceDefinitionType();
        dataSourceDefinition.setType(DataSourceDefinitionType.TypeEnum.HTTP);

        ParameterValueType parameter = new ParameterValueType();
        parameter.setName("URL");
        parameter.setValue(URL);
        List<ParameterValueType> parameterList = Collections.singletonList(parameter);

        dataSourceDefinition.setParameters(parameterList);

        return dataSourceDefinition;
    }
}

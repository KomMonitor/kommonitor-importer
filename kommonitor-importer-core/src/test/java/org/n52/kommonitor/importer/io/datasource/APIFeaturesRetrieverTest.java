package org.n52.kommonitor.importer.io.datasource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.ParameterValueType;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Sebastian Drost</a>
 */
public class APIFeaturesRetrieverTest {

    private static final String URL = "https://ogc-api.nrw.de/inspire-lu-ble/v1/collections/existinglanduseobject/items";

    @Test
    @DisplayName("Test retrieve HTTP dataset")
    void testRetrieveHttpDataset() throws DataSourceRetrieverException, IOException, ImportParameterException {

        APIFeaturesRetriever retriever = new APIFeaturesRetriever();
        DataSourceDefinitionType dataSourceDefinition = createDataSourceDefinition();

        retriever.retrieveDataset(dataSourceDefinition);
    }


    private DataSourceDefinitionType createDataSourceDefinition() {
        DataSourceDefinitionType dataSourceDefinition = new DataSourceDefinitionType(DataSourceDefinitionType.TypeEnum.HTTP);

        List<ParameterValueType> parameterList = new LinkedList<>();
        parameterList.add(new ParameterValueType("URL", URL));
        parameterList.add(new ParameterValueType("BBOX", "6.909098920295065,51.24069410819487,7.038505820439525,51.30733176596053"));
        dataSourceDefinition.setParameters(parameterList);
        return dataSourceDefinition;
    }

}

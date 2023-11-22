package org.n52.kommonitor.importer.io.datasource;

import org.apache.commons.io.IOUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.geotools.feature.FeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.http.HttpHelper;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.n52.kommonitor.models.ParameterValueType;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.argThat;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Sebastian Drost</a>
 */
public class APIFeaturesRetrieverTest {

    private static final String URL = "https://test-api.de/test/v1/collections/test/items";

    @Test
    @DisplayName("Test retrieve HTTP dataset")
    void testRetrieveHttpDataset() throws DataSourceRetrieverException, IOException, ImportParameterException {
        InputStream input = ClassLoader.getSystemResourceAsStream("./ogc-api-response-test.json");
        HttpHelper httpHelper = Mockito.mock(HttpHelper.class);

        Mockito
                .when(httpHelper.executeHttpGetRequest((HttpGet) argThat(
                        r -> ((HttpGet) r).getAuthority().getHostName().equals("test-api.de")
                                && ((HttpGet) r).getPath().equals("/test/v1/collections/test/items?limit=200&f=json&bbox=6.909098920295065%2C51.24069410819487%2C7.038505820439525%2C51.30733176596053"))))
                .thenReturn(IOUtils.toByteArray(input));

        APIFeaturesRetriever retriever = new APIFeaturesRetriever(httpHelper);
        DataSourceDefinitionType dataSourceDefinition = createDataSourceDefinition();

        Dataset<InputStream> dataset = retriever.retrieveDataset(dataSourceDefinition);
        FeatureCollection fc = new FeatureJSON().readFeatureCollection(dataset.getData());

        Assertions.assertFalse(fc.isEmpty());
        Assertions.assertEquals(2, fc.size());
    }


    private DataSourceDefinitionType createDataSourceDefinition() {
        DataSourceDefinitionType dataSourceDefinition = new DataSourceDefinitionType(DataSourceDefinitionType.TypeEnum.HTTP);

        List<ParameterValueType> parameterList = new LinkedList<>();
        parameterList.add(new ParameterValueType("url", URL));
        parameterList.add(new ParameterValueType("bbox", "6.909098920295065,51.24069410819487,7.038505820439525,51.30733176596053"));
        parameterList.add(new ParameterValueType("bboxType", "literal"));
        dataSourceDefinition.setParameters(parameterList);
        return dataSourceDefinition;
    }

}

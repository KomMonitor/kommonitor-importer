package org.n52.kommonitor.importer.io.datasources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DataSourceRetrieverRepository.class, AbstractDataSourceRetriever.class})
public class DataSourceRetrieverRepositoryTest {

    private static final String RETRIEVER_TYPE = "testRetriever";

    @MockBean
    private AbstractDataSourceRetriever retriever;

    @Autowired
    private DataSourceRetrieverRepository repo;

    @Test
    @DisplayName("test get all DataSourceRetriever")
    void testGetAllConverters() {
        Mockito.when(retriever.getType()).thenReturn(RETRIEVER_TYPE);

        List<AbstractDataSourceRetriever> retrieverList = repo.getAll();

        Assertions.assertEquals(1, retrieverList.size());
    }

    @Test
    @DisplayName("test get DataSourceRetriever for name is present")
    void testGetConverterIsPresent() {
        Mockito.when(retriever.getType()).thenReturn(RETRIEVER_TYPE);

        Optional<AbstractDataSourceRetriever> retrieverOpt = repo.getDatasourceRetriever(RETRIEVER_TYPE);

        Assertions.assertTrue(retrieverOpt.isPresent());
    }

    @Test
    @DisplayName("test get DataSourceRetriever for name is not present")
    void testGetConverterIsNotPresent() {
        Mockito.when(retriever.getType()).thenReturn(RETRIEVER_TYPE);

        Optional<AbstractDataSourceRetriever> retrieverOpt = repo.getDatasourceRetriever("anotherRetriever");

        Assertions.assertFalse(retrieverOpt.isPresent());
    }
}

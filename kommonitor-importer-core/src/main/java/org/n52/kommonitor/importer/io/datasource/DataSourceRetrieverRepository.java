package org.n52.kommonitor.importer.io.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Repository for {@link AbstractDataSourceRetriever} implementations
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class DataSourceRetrieverRepository {

    @Autowired
    private List<AbstractDataSourceRetriever<?>> retrieverList;

    /**
     * Retrieve a certain {@link AbstractDataSourceRetriever} implementation by its name
     *
     * @param type the type of a certain {@link AbstractDataSourceRetriever} implementation
     * @return an {@link Optional} describing the found {@link AbstractDataSourceRetriever} implementation
     */
    public Optional<AbstractDataSourceRetriever<?>> getDataSourceRetriever(String type) {
        Optional<AbstractDataSourceRetriever<?>> retrieverOpt = this.retrieverList.stream()
                .filter(i -> i.getType().equals(type))
                .findFirst();
        return retrieverOpt;
    }

    /**
     * Retrieve a list of all registered {@link AbstractDataSourceRetriever} implementations
     *
     * @return a list of all registered {@link AbstractDataSourceRetriever} implementations
     */
    public List<AbstractDataSourceRetriever<?>> getAll() {
        return Collections.unmodifiableList(this.retrieverList);
    }
}

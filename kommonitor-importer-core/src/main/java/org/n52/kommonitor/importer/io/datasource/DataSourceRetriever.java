package org.n52.kommonitor.importer.io.datasource;

import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.DataSourceDefinitionType;

/**
 * An interface for retrieving datasets from a certain datasource type
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public interface DataSourceRetriever<T> {

    public String getType();

    /**
     * Retrieve a {@link Dataset} from a certain datasource that is defined by a {@link DataSourceDefinitionType}
     *
     * @param datasource definition of the datasource as {@link DataSourceDefinitionType}
     * @return a {@link Dataset} of type T
     * @throws DataSourceRetrieverException
     */
    Dataset<T> retrieveDataset(DataSourceDefinitionType datasource) throws DataSourceRetrieverException, ImportParameterException;

}

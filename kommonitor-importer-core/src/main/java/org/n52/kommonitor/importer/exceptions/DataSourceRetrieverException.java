package org.n52.kommonitor.importer.exceptions;

/**
 * An exception for errors that occur when trying to retrieve a dataset from a datasource
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class DataSourceRetrieverException extends Exception {
    public DataSourceRetrieverException() {
        super();
    }

    public DataSourceRetrieverException(String message) {
        super(message);
    }

    public DataSourceRetrieverException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataSourceRetrieverException(Throwable cause) {
        super(cause);
    }
}

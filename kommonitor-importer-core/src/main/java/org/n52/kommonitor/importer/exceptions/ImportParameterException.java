package org.n52.kommonitor.importer.exceptions;

/**
 * Indicates that an invalid parameter (e.g. {@link org.n52.kommonitor.importer.io.datasource.DataSourceParameter}
 * or {@link org.n52.kommonitor.importer.converter.ConverterParameter}) has been defined so that
 * an import request can not be resolved properly.
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class ImportParameterException extends Exception {
    public ImportParameterException() {
        super();
    }

    public ImportParameterException(String message) {
        super(message);
    }

    public ImportParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImportParameterException(Throwable cause) {
        super(cause);
    }
}

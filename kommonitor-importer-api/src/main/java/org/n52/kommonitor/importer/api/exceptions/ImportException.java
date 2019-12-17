package org.n52.kommonitor.importer.api.exceptions;

/**
 * Indicates that the import of a new resource failed
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class ImportException extends RuntimeException {

    public ImportException() {
    }

    public ImportException(String message) {
        super(message);
    }

    public ImportException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImportException(Throwable cause) {
        super(cause);
    }
}

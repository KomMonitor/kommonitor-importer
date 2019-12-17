package org.n52.kommonitor.importer.exceptions;

/**
 * Indicates that an error has occurred during dataset converting
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class ConverterException extends Exception {

    public ConverterException(String message) {
        super(message);
    }

    public ConverterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConverterException(Throwable cause) {
        super(cause);
    }
}

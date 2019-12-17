package org.n52.kommonitor.importer.exceptions;

/**
 * Indicates that a decoding operation failed
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class DecodingException extends Exception {

    public DecodingException() {
        super();
    }

    public DecodingException(String message) {
        super(message);
    }

    public DecodingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DecodingException(Throwable cause) {
        super(cause);
    }
}

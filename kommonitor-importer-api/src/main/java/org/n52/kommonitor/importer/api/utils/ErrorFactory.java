package org.n52.kommonitor.importer.api.utils;

import org.n52.kommonitor.importer.models.Error;

/**
 * Helper class for constructing {@link Error} objects for HTTP responses
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class ErrorFactory {

    private final static int DEFAULT_STATUS_CODE = 500;

    private final static String DEFAULT_ERROR_MESSAGE = "An unexpected error occured.";

    /**
     * Creates a default error with default message for HTTP status code 500
     *
     * @return default {@link Error}
     */
    public static Error getDefaultError() {
        return getError(DEFAULT_STATUS_CODE, DEFAULT_ERROR_MESSAGE);
    }

    /**
     * Creates a default error with custom message for HTTP status code 500
     *
     * @return default {@link Error} with custom message
     */
    public static Error getError(String message) {
        return getError(DEFAULT_STATUS_CODE, message);
    }

    /**
     * Creates a error with custom message for a given HTTP status code
     *
     * @return {@link Error} with custom status code and message
     */
    public static Error getError(int statusCode, String message) {
        Error error = new Error();
        error.setCode(statusCode);
        error.setMessage(message);
        return error;
    }
}

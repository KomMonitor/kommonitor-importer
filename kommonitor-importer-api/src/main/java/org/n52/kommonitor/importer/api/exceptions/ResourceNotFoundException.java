package org.n52.kommonitor.importer.api.exceptions;

/**
 * Indicates that a certain resource was not found
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Class clazz, String type) {
        super(String.format("Resource '%s' with identifier '%s' was not found.", clazz.getName(), type));
    }
}

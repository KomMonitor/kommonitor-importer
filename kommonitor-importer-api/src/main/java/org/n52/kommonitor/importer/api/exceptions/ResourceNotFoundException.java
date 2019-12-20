package org.n52.kommonitor.importer.api.exceptions;

/**
 * Indicates that a certain resource was not found
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class ResourceNotFoundException extends RuntimeException {

    private Class resource;

    private String type;

    public Class getResource() {
        return resource;
    }

    public String getType() {
        return type;
    }

    public ResourceNotFoundException(Class clazz, String type) {
        super(String.format("Resource '%s' with identifier '%s' was not found.", clazz.getName(), type));
        this.resource = clazz;
        this.type = type;
    }
}

package org.n52.kommonitor.importer.converter;

/**
 * Encapsulates additional converter specific parameters that are required for converting a dataset from a certain
 * datasource into the internal KomMonitor models for spatial resources and indicator values.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class ConverterParameter {

    private String name;

    private String description;

    private ParameterTypeValues type;

    public ConverterParameter(String name, String description, ParameterTypeValues type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ParameterTypeValues getType() {
        return type;
    }

    public enum ParameterTypeValues {
        CHARACTER, STRING, NUMBER, BOOLEAN, ARRAY
    }

}

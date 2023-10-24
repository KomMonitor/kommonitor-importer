package org.n52.kommonitor.importer.io.datasource;

/**
 * Encapsulates a specific datasource related parameter that is required for retrieving a dataset
 * from a certain data source.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class DataSourceParameter {

    private String name;

    private String description;

    private ParameterTypeValues type;
    private boolean mandatory;

    public DataSourceParameter(String name, String description, ParameterTypeValues type) {
        this(name, description, type, true);
    }

    public DataSourceParameter(String name, String description, ParameterTypeValues type, boolean mandatory) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.mandatory = mandatory;
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

    public boolean isMandatory() {
        return mandatory;
    }

    public static enum ParameterTypeValues {
        STRING, NUMBER, BOOLEAN, ARRAY
    }

}

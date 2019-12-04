package org.n52.kommonitor.importer.io.datasource;

/**
 * Encapsulates a specific datasource related parameter that is required for retrieving a dataset
 * from a certain data source.
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class DataSourceParameter {

    private String name;

    private String description;

    private ParameterTypeValues type;

    public DataSourceParameter(String name, String description, ParameterTypeValues type) {
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

    public static enum ParameterTypeValues {
        STRING, NUMBER, BOOLEAN, ARRAY
    }

}

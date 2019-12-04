package org.n52.kommonitor.importer.converter;

import org.n52.kommonitor.importer.entities.Indicator;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.DataSourceType;

/**
 * An interface for converting spatial resources and indicators from a certain dataset format into
 * internal KomMonitor models for spatial resources and indicator values
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public interface Converter {

    String getName();

    /**
     * Converts a dataset into a {@link SpatialResource} according to a given {@link ConverterDefinitionType}
     *
     * @param importerDefinition the {@link ConverterDefinitionType} used to decode the dataset
     * @param datasource         definition of the datasource that contains a dataset
     * @return the decoded {@link SpatialResource}
     */
    SpatialResource convertSpatialResource(ConverterDefinitionType importerDefinition, DataSourceType datasource);

    /**
     * Decodes a dataset into a {@link Indicator} according to a given {@link ConverterDefinitionType}
     *
     * @param importerDefinition the {@link ConverterDefinitionType} used to decode the dataset
     * @param datasource         definition of the datasource that contains a dataset
     * @return the decoded {@link Indicator}
     */
    Indicator convertIndicator(ConverterDefinitionType importerDefinition, DataSourceType datasource);

}

package org.n52.kommonitor.importer.converter;

import org.n52.kommonitor.importer.entities.Dataset;
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
     * Converts a {@link Dataset} into a {@link SpatialResource}  Faccording to a given {@link ConverterDefinitionType}
     *
     * @param importerDefinition the {@link ConverterDefinitionType} used to decode the dataset
     * @param dataset            the {@link Dataset} that contains the data to convert
     * @return the converted {@link SpatialResource}
     */
    SpatialResource convertSpatialResource(ConverterDefinitionType importerDefinition, Dataset dataset);

    /**
     * Decodes a dataset into a {@link Indicator} according to a given {@link ConverterDefinitionType}
     *
     * @param importerDefinition the {@link ConverterDefinitionType} used to decode the dataset
     * @param dataset            the {@link Dataset} that contains the data to convert
     * @return the converted {@link Indicator}
     */
    Indicator convertIndicator(ConverterDefinitionType importerDefinition, Dataset dataset);

}

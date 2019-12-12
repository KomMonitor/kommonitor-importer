package org.n52.kommonitor.importer.converter;

import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.Indicator;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.importer.models.SpatialResourcePropertyMappingType;

import java.util.List;

/**
 * An interface for converting spatial resources and indicators from a certain dataset format into
 * internal KomMonitor models for spatial resources and indicator values
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public interface Converter {

    String getName();

    /**
     * Converts a {@link Dataset} into {@link List<SpatialResource>}  according to a given {@link ConverterDefinitionType}
     *
     * @param importerDefinition the {@link ConverterDefinitionType} used to decode the dataset
     * @param dataset            the {@link Dataset} that contains the data to convert
     * @return the converted {@link List<SpatialResource>}}
     */
    List<SpatialResource> convertSpatialResources(ConverterDefinitionType importerDefinition, Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) throws ConverterException;

    /**
     * Decodes a dataset into {@link List<Indicator>} according to a given {@link ConverterDefinitionType}
     *
     * @param importerDefinition the {@link ConverterDefinitionType} used to decode the dataset
     * @param dataset            the {@link Dataset} that contains the data to convert
     * @return the converted {@link List<Indicator>}
     */
    List<Indicator> convertIndicators(ConverterDefinitionType importerDefinition, Dataset dataset, IndicatorPropertyMappingType propertyMapping) throws ConverterException;

}

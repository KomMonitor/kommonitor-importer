package org.n52.kommonitor.importer.converter;

import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.AggregationType;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;

import java.util.List;

/**
 * An interface for converting spatial resources and indicators from a certain dataset format into
 * internal KomMonitor models for spatial resources and indicator values
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public interface Converter {

    String getName();

    /**
     * Converts a {@link Dataset} into {@link List<SpatialResource>}  according to a given {@link ConverterDefinitionType}
     *
     * @param converterDefinition the {@link ConverterDefinitionType} used to decode the dataset
     * @param dataset            the {@link Dataset} that contains the data to convert
     * @return the converted {@link List<SpatialResource>}}
     */
    List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition, Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) throws ConverterException, ImportParameterException;

    /**
     * Decodes a dataset into {@link List<IndicatorValue>} according to a given {@link ConverterDefinitionType}
     *
     * @param converterDefinition the {@link ConverterDefinitionType} used to decode the dataset
     * @param dataset            the {@link Dataset} that contains the data to convert
     * @return the converted {@link List<IndicatorValue>}
     */
    List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition, Dataset dataset, IndicatorPropertyMappingType propertyMapping) throws ConverterException, ImportParameterException;

    /**
     * Decodes a dataset into {@link List<IndicatorValue>} according to a given {@link ConverterDefinitionType}
     *
     * @param converterDefinition the {@link ConverterDefinitionType} used to decode the dataset
     * @param dataset the {@link Dataset} that contains the data to convert
     * @param aggregationDefinitions defines aggregations for higher spatial units
     * @return the converted {@link List<IndicatorValue>}
     */
    List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition, Dataset dataset, IndicatorPropertyMappingType propertyMapping, List<AggregationType> aggregationDefinitions) throws ConverterException, ImportParameterException;

}

package org.n52.kommonitor.importer.api.encoder;

import org.n52.kommonitor.datamanagement.api.models.*;
import org.n52.kommonitor.importer.entities.IndicatorValue;

import org.n52.kommonitor.importer.entities.TimeseriesValue;
import org.n52.kommonitor.importer.models.DefaultClassificationMappingItemType;
import org.n52.kommonitor.importer.models.DefaultClassificationMappingType;
import org.n52.kommonitor.importer.models.ImportIndicatorPOSTInputType;
import org.n52.kommonitor.importer.models.ResourceReferenceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Encodes a {@link ImportIndicatorPOSTInputType} and a {@link List <IndicatorValues>} into a {@link IndicatorPOSTInputType}
 * for usage within a {@link org.n52.kommonitor.importer.api.IndicatorsApi} client.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class IndicatorEncoder {

    @Autowired
    private ApiEncodingHelper encodingHelper;

    public IndicatorPOSTInputType encode(ImportIndicatorPOSTInputType importResourceType, List<IndicatorValue> indicatorValues) {
        IndicatorPOSTInputType indicator = new IndicatorPOSTInputType();
        indicator.setAbbreviation(importResourceType.getAbbreviation());
        indicator.setAllowedRoles(importResourceType.getAllowedRoles());
        indicator.setApplicableSpatialUnit(importResourceType.getApplicableSpatialUnit());
        indicator.setApplicableTopics(importResourceType.getApplicableTopics());
        indicator.setCreationType(IndicatorPOSTInputType.CreationTypeEnum.valueOf(importResourceType.getCreationType().name()));
        indicator.setDatasetName(importResourceType.getDatasetName());
        indicator.setDefaultClassificationMapping(encodeDefaultClassificationMapping(importResourceType.getDefaultClassificationMapping()));
        indicator.setIndicatorType(IndicatorPOSTInputType.IndicatorTypeEnum.valueOf(importResourceType.getIndicatorType().name()));
        if (indicatorValues != null) {
            indicator.setIndicatorValues(indicatorValues.stream()
                    .map(this::encodeIndicatorValues)
                    .collect(Collectors.toList()));
        }
        indicator.setInterpretation(importResourceType.getInterpretation());
        indicator.setIsHeadlineIndicator(importResourceType.isIsHeadlineIndicator());
        indicator.setLowestSpatialUnitForComputation(importResourceType.getLowestSpatialUnitForComputation());
        indicator.setMetadata(encodingHelper.encodeMetadata(importResourceType.getMetadata()));
        indicator.setProcessDescription(importResourceType.getProcessDescription());
        if (importResourceType.getReferencesToGeoresources() != null) {
            indicator.setRefrencesToGeoresources(importResourceType.getReferencesToGeoresources().stream()
                    .map(this::encodeGeoresourceReferences)
                    .collect(Collectors.toList()));
        }
        if (importResourceType.getReferencesToOtherIndicators() != null) {
            indicator.setRefrencesToOtherIndicators(importResourceType.getReferencesToOtherIndicators().stream()
                    .map(this::encodeIndicatorReferences)
                    .collect(Collectors.toList()));
        }
        indicator.setTags(importResourceType.getTags());
        indicator.setUnit(importResourceType.getUnit());
        return indicator;
    }

    private IndicatorPOSTInputTypeRefrencesToOtherIndicators encodeIndicatorReferences(ResourceReferenceType reference) {
        IndicatorPOSTInputTypeRefrencesToOtherIndicators result = new IndicatorPOSTInputTypeRefrencesToOtherIndicators();
        result.setIndicatorId(reference.getResourceId());
        result.setReferenceDescription(reference.getReferenceDescription());
        return result;
    }

    private IndicatorPOSTInputTypeRefrencesToGeoresources encodeGeoresourceReferences(ResourceReferenceType reference) {
        IndicatorPOSTInputTypeRefrencesToGeoresources result = new IndicatorPOSTInputTypeRefrencesToGeoresources();
        result.setGeoresourceId(reference.getResourceId());
        result.setReferenceDescription(reference.getReferenceDescription());
        return result;
    }

    private IndicatorPOSTInputTypeIndicatorValues encodeIndicatorValues(IndicatorValue indicatorValues) {
        IndicatorPOSTInputTypeIndicatorValues result = new IndicatorPOSTInputTypeIndicatorValues();
        result.setSpatialReferenceKey(indicatorValues.getSpatialReferenceKey());
        result.setValueMapping(indicatorValues.getTimeSeriesValueList().stream()
                .map(this::encodeTimeSeriesValues)
                .collect(Collectors.toList()));
        return result;
    }

    private IndicatorPOSTInputTypeValueMapping encodeTimeSeriesValues(TimeseriesValue timeseriesValue) {
        IndicatorPOSTInputTypeValueMapping result = new IndicatorPOSTInputTypeValueMapping();
        result.setIndicatorValue(timeseriesValue.getValue());
        result.setTimestamp(timeseriesValue.getTimestamp());
        return result;
    }

    private org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingType encodeDefaultClassificationMapping(DefaultClassificationMappingType defaultClassificationMapping) {
        org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingType result
                = new org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingType();
        result.setColorBrewerSchemeName(defaultClassificationMapping.getColorBrewerSchemeName());
        result.setItems(defaultClassificationMapping.getItems().stream()
                .map(dCM -> encodeMappingItems(dCM))
                .collect(Collectors.toList()));
        return result;
    }

    private org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingItemType encodeMappingItems(DefaultClassificationMappingItemType dCM) {
        org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingItemType result
                = new org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingItemType();
        result.setDefaultColorAsHex(dCM.getDefaultColorAsHex());
        result.setDefaultCustomRating(dCM.getDefaultCustomRating());
        return result;
    }


}

package org.n52.kommonitor.importer.api.encoder;

import org.n52.kommonitor.importer.entities.IndicatorValue;

import org.n52.kommonitor.importer.entities.TimeseriesValue;
import org.n52.kommonitor.importer.models.ImportIndicatorPOSTInputType;
import org.n52.kommonitor.importer.models.IndicatorPOSTInputType;
import org.n52.kommonitor.importer.models.IndicatorPOSTInputTypeIndicatorValues;
import org.n52.kommonitor.importer.models.IndicatorPOSTInputTypeValueMapping;
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

    public IndicatorPOSTInputType encode(ImportIndicatorPOSTInputType importResourceType, List<IndicatorValue> indicatorValues) {
        IndicatorPOSTInputType indicator = importResourceType.getIndicatorPostBody();
        if (indicatorValues != null) {
            indicator.setIndicatorValues(indicatorValues.stream()
                    .map(this::encodeIndicatorValues)
                    .collect(Collectors.toList()));
        }
        return indicator;
    }

//    private IndicatorPOSTInputTypeRefrencesToOtherIndicators encodeIndicatorReferences(ResourceReferenceType reference) {
//        IndicatorPOSTInputTypeRefrencesToOtherIndicators result = new IndicatorPOSTInputTypeRefrencesToOtherIndicators();
//        result.setIndicatorId(reference.getResourceId());
//        result.setReferenceDescription(reference.getReferenceDescription());
//        return result;
//    }
//
//    private IndicatorPOSTInputTypeRefrencesToGeoresources encodeGeoresourceReferences(ResourceReferenceType reference) {
//        IndicatorPOSTInputTypeRefrencesToGeoresources result = new IndicatorPOSTInputTypeRefrencesToGeoresources();
//        result.setGeoresourceId(reference.getResourceId());
//        result.setReferenceDescription(reference.getReferenceDescription());
//        return result;
//    }

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

//    private org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingType encodeDefaultClassificationMapping(DefaultClassificationMappingType defaultClassificationMapping) {
//        org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingType result
//                = new org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingType();
//        result.setColorBrewerSchemeName(defaultClassificationMapping.getColorBrewerSchemeName());
//        result.setItems(defaultClassificationMapping.getItems().stream()
//                .map(dCM -> encodeMappingItems(dCM))
//                .collect(Collectors.toList()));
//        return result;
//    }
//
//    private org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingItemType encodeMappingItems(DefaultClassificationMappingItemType dCM) {
//        org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingItemType result
//                = new org.n52.kommonitor.datamanagement.api.models.DefaultClassificationMappingItemType();
//        result.setDefaultColorAsHex(dCM.getDefaultColorAsHex());
//        result.setDefaultCustomRating(dCM.getDefaultCustomRating());
//        return result;
//    }


}

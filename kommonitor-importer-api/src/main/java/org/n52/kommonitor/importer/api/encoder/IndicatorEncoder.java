package org.n52.kommonitor.importer.api.encoder;

import org.n52.kommonitor.importer.decoder.DecoderConfig;
import org.n52.kommonitor.importer.entities.IndicatorValue;

import org.n52.kommonitor.importer.entities.TimeseriesValue;
import org.n52.kommonitor.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Encodes a {@link UpdateIndicatorPOSTInputType} and a {@link List <IndicatorValues>} into a {@link IndicatorPUTInputType}
 * for usage within a {@link org.n52.kommonitor.importer.api.IndicatorsApi} client.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class IndicatorEncoder {

    @Autowired
    private DecoderConfig decoderConfig;

    public IndicatorPUTInputType encode(UpdateIndicatorPOSTInputType importResourceType, List<IndicatorValue> indicatorValues) {
        IndicatorPUTInputType indicator = importResourceType.getIndicatorPutBody();
        if (indicatorValues != null) {
            indicator.setIndicatorValues(indicatorValues.stream()
                    .map(this::encodeIndicatorValues)
                    .collect(Collectors.toList()));
        }
        return indicator;
    }

    public IndicatorPUTInputType encode(IndicatorPUTInputType indicatorPutType, List<IndicatorValue> indicatorValues) {
        if (indicatorValues != null) {
            indicatorPutType.setIndicatorValues(indicatorValues.stream()
                    .map(this::encodeIndicatorValues)
                    .collect(Collectors.toList()));
        }
        return indicatorPutType;
    }

    private IndicatorPOSTInputTypeIndicatorValues encodeIndicatorValues(IndicatorValue indicatorValues) {
        IndicatorPOSTInputTypeIndicatorValues result = new IndicatorPOSTInputTypeIndicatorValues();
        result.setValueType(getIndicatorValueType());
        result.setSpatialReferenceKey(indicatorValues.getSpatialReferenceKey());
        result.setValueMapping(indicatorValues.getTimeSeriesValueList().stream()
                .map(this::encodeTimeSeriesValues)
                .collect(Collectors.toList()));
        return result;
    }

    private IndicatorPOSTInputTypeValueMapping encodeTimeSeriesValues(TimeseriesValue<?> timeseriesValue) {
        Object value = timeseriesValue.getValue();
        if (value instanceof String s) {
            IndicatorPOSTInputTypeCategoricalValueMapping result = new IndicatorPOSTInputTypeCategoricalValueMapping();
            result.setIndicatorValue(s);
            result.setTimestamp(timeseriesValue.getTimestamp());
            return result;
        } else {
            IndicatorPOSTInputTypeNumericalValueMapping result = new IndicatorPOSTInputTypeNumericalValueMapping();
            result.setIndicatorValue(value instanceof Float f ? f : null);
            result.setTimestamp(timeseriesValue.getTimestamp());
            return result;
        }
    }

    private IndicatorValueTypeEnum getIndicatorValueType() {
        if (decoderConfig.getClassificationType().equals(ClassificationTypeEnum.QUANTITATIVE)) {
            return IndicatorValueTypeEnum.NUMERIC;
        } else if (decoderConfig.getClassificationType().equals(ClassificationTypeEnum.QUALITATIVE)) {
            return IndicatorValueTypeEnum.CATEGORICAL;
        } else {
            return IndicatorValueTypeEnum.NUMERIC;
        }
    }
}

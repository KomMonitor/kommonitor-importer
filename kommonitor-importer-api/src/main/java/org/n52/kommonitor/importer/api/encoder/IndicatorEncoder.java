package org.n52.kommonitor.importer.api.encoder;

import org.n52.kommonitor.importer.entities.IndicatorValue;

import org.n52.kommonitor.importer.entities.TimeseriesValue;
import org.n52.kommonitor.models.ImportIndicatorPOSTInputType;
import org.n52.kommonitor.models.IndicatorPOSTInputType;
import org.n52.kommonitor.models.IndicatorPOSTInputTypeIndicatorValues;
import org.n52.kommonitor.models.IndicatorPOSTInputTypeValueMapping;
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
}

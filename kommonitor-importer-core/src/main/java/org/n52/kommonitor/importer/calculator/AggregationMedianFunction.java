package org.n52.kommonitor.importer.calculator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.common.math.Quantiles;

public class AggregationMedianFunction extends AbstractAggregationFunction{

    @Override
    protected Float aggregateValues(List<Float> values) {
        List<Float> filteredValues = values.stream()
                .filter(Objects::nonNull)
                .toList();
        if (filteredValues.isEmpty()) {
            return Float.NaN;
        } else {
            return (float) Quantiles.median().compute(filteredValues);
        }
    }
}

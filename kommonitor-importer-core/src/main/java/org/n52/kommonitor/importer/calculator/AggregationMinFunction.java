package org.n52.kommonitor.importer.calculator;

import java.util.List;
import java.util.Objects;

public class AggregationMinFunction extends AbstractAggregationFunction{

    @Override
    protected Float aggregateValues(List<Float> values) {
        return (float) values.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Float::doubleValue)
                .min()
                .orElse(Double.NaN);
    }
}

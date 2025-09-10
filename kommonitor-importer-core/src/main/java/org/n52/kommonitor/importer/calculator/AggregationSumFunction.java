package org.n52.kommonitor.importer.calculator;

import java.util.List;
import java.util.Objects;

public class AggregationSumFunction extends AbstractAggregationFunction{

    @Override
    protected Float aggregateValues(List<Float> values) {
        return values.stream()
                .filter(Objects::nonNull)
                .reduce(Float::sum)
                .orElse(Float.NaN);
    }
}

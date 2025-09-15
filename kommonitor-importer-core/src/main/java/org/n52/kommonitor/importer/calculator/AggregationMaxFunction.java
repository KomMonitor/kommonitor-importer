package org.n52.kommonitor.importer.calculator;

import java.util.List;
import java.util.Objects;

public class AggregationMaxFunction extends AbstractAggregationFunction{

    @Override
    protected Float aggregateValues(List<Float> values) {
        return (float) values.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Float::doubleValue)
                .max()
                .orElse(Double.NaN);
    }
}

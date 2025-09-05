package org.n52.kommonitor.importer.calculator;

import java.util.List;
import java.util.Objects;

public class AggregationCountFunction extends AbstractAggregationFunction{

    @Override
    protected Float aggregateValues(List<Float> values) {
        return (float) values.stream().filter(Objects::nonNull).count();
    }
}

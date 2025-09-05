package org.n52.kommonitor.importer.calculator;

import java.util.List;

public class AggregationCountFunction extends AbstractAggregationFunction{

    @Override
    protected Float aggregateValues(List<Float> values) {
        return (float) values.size();
    }
}

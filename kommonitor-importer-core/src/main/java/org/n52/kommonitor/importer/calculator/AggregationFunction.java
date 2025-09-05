package org.n52.kommonitor.importer.calculator;

import org.n52.kommonitor.importer.entities.IndicatorValue;

import java.util.List;

public interface AggregationFunction {
    List<IndicatorValue> aggregate(List<IndicatorValue> preparedIndicators);
}

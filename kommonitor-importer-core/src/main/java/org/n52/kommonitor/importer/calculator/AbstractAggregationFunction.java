package org.n52.kommonitor.importer.calculator;

import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.TimeseriesValue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractAggregationFunction implements AggregationFunction {

    @Override
    public List<IndicatorValue> aggregate(List<IndicatorValue> indicators) {
        Map<String, List<IndicatorValue>> groupedIndicators = groupIndicatorsBySpatialUnit(indicators);
        List<IndicatorValue> aggregatedIndicators = new ArrayList<>();
        groupedIndicators.forEach((k,v) -> {
            Map<LocalDate, List<Float>> groupedValues = groupIndicatorsByTimestamp(v);
            List<TimeseriesValue> aggregatedValues = aggregateValues(groupedValues);
            IndicatorValue aggregatedIndicator = new IndicatorValue(k, aggregatedValues);
            aggregatedIndicators.add(aggregatedIndicator);
        });
        return aggregatedIndicators;
    }

    /**
     * Groups indicators by its spatial unit reference key
     *
     * @param indicators list of indicators to group
     * @return @return Map with the spatial unit reference key as key and belonging IndicatorValues as value
     */
    protected Map<String, List<IndicatorValue>> groupIndicatorsBySpatialUnit(List<IndicatorValue> indicators) {
        return indicators.stream().collect(Collectors.groupingBy(IndicatorValue::getSpatialReferenceKey));
    }

    /**
     * Groups indicator values by timestamp
     *
     * @param indicators list of indicators to group
     * @return Map with the timestamp as key and belonging timeseries values as value
     */
    protected Map<LocalDate, List<Float>> groupIndicatorsByTimestamp(List<IndicatorValue> indicators) {
        Map<LocalDate, List<Float>> groupedIndicators = new HashMap<>();
        indicators.forEach(i -> {
            i.getTimeSeriesValueList().forEach(t -> {
                if (groupedIndicators.containsKey(t.getTimestamp())) {
                    groupedIndicators.get(t.getTimestamp()).add(t.getValue());
                } else {
                    List<Float> values = new ArrayList<>();
                    values.add(t.getValue());
                    groupedIndicators.put(t.getTimestamp(), values);
                }
            });
        });
        return groupedIndicators;
    }

    private List<TimeseriesValue> aggregateValues(Map<LocalDate, List<Float>> groupedValues) {
        return groupedValues.entrySet().stream()
                .map(e -> new TimeseriesValue(aggregateValues(e.getValue()), e.getKey()))
                .collect(Collectors.toList());
    }

    protected abstract Float aggregateValues(List<Float> value);

}

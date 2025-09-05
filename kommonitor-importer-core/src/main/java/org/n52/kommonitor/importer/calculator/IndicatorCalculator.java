package org.n52.kommonitor.importer.calculator;

import jakarta.validation.constraints.NotNull;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.AggregationType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IndicatorCalculator {

    public List<IndicatorValue> aggregate(
            List<IndicatorValue> indicators,
            AggregationType.@NotNull AggregateFunctionEnum aggregateFunction,
            @NotNull String spatialReferenceKeyProperty) throws ImportParameterException {
        List<IndicatorValue> preparedIndicators = indicators.stream()
                .map(i -> new IndicatorValue(
                        i.getUpperSpatialUnitReferences().get(spatialReferenceKeyProperty),
                        i.getTimeSeriesValueList()))
                .toList();
        AggregationFunction aggregationFunction = getAggregationFunction(aggregateFunction);
        return aggregationFunction.aggregate(preparedIndicators);
    }

    private AggregationFunction getAggregationFunction(AggregationType.AggregateFunctionEnum aggregateFunction) throws ImportParameterException {
        switch (aggregateFunction) {
            case COUNT -> {
                return new AggregationCountFunction();
            }
            default -> {
                throw new ImportParameterException(String.format("Aggregate function '%s' is not supported.", aggregateFunction));
            }
        }
    }
}

package org.n52.kommonitor.importer.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.n52.kommonitor.importer.entities.IndicatorValue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AggregationCountFunctionTest {

    protected static AggregationTestDataProvider provider;

    @BeforeAll
    static void init() {
        provider = new AggregationTestDataProvider();
    }

    @Test
    void testAggregateValuesCount() {
        List<Float> values = Arrays.asList(10f, 11f, 12f, 13f, null, 14f);

        AbstractAggregationFunction aggregationFunction = new AggregationCountFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(5, result);
    }

    @Test
    void testAggregateValuesCountForEmptyList() {
        List<Float> values = List.of();

        AbstractAggregationFunction aggregationFunction = new AggregationCountFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(0, result);
    }

    @Test
    void testAggregateCount() {
        List<IndicatorValue> valueList = Arrays.asList(provider.getValue01(), provider.getValue02(), provider.getValue03(),
                provider.getValue04(), provider.getValue05(), provider.getValue06());

        AbstractAggregationFunction aggregationFunction = new AggregationCountFunction();
        List<IndicatorValue> result = aggregationFunction.aggregate(valueList);

        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("01", result.get(0).getSpatialReferenceKey());
        Assertions.assertEquals("02", result.get(1).getSpatialReferenceKey());
        Assertions.assertEquals("03", result.get(2).getSpatialReferenceKey());

        Assertions.assertEquals(LocalDate.of(2020,1,1), result.get(0).getTimeSeriesValueList().get(0).getTimestamp());
        Assertions.assertEquals(6, result.get(0).getTimeSeriesValueList().size());
        Assertions.assertEquals(1f, result.get(0).getTimeSeriesValueList().get(0).getValue());

        Assertions.assertEquals(LocalDate.of(2024,1,1), result.get(1).getTimeSeriesValueList().get(3).getTimestamp());
        Assertions.assertEquals(5, result.get(1).getTimeSeriesValueList().size());
        Assertions.assertEquals(2f, result.get(1).getTimeSeriesValueList().get(1).getValue());
        Assertions.assertEquals(1f, result.get(1).getTimeSeriesValueList().get(3).getValue());

        Assertions.assertEquals(LocalDate.of(2024,1,1), result.get(2).getTimeSeriesValueList().get(4).getTimestamp());
        Assertions.assertEquals(6, result.get(2).getTimeSeriesValueList().size());
        Assertions.assertEquals(3f, result.get(2).getTimeSeriesValueList().get(0).getValue());
        Assertions.assertEquals(2f, result.get(2).getTimeSeriesValueList().get(1).getValue());
        Assertions.assertEquals(2f, result.get(2).getTimeSeriesValueList().get(3).getValue());
    }
}

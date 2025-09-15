package org.n52.kommonitor.importer.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AggregationMedianFunctionTest {

    protected static AggregationTestDataProvider provider;

    @BeforeAll
    static void init() {
        provider = new AggregationTestDataProvider();
    }

    @Test
    void testAggregateOddValuesMedian() {
        List<Float> values = Arrays.asList(10f, 12f, 11f, 13f, null, 14f);

        AbstractAggregationFunction aggregationFunction = new AggregationMedianFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(12f, result);
    }

    @Test
    void testAggregateEvenValuesMedian() {
        List<Float> values = Arrays.asList(10f, 12f, 11f,  14f, 13f, null, 15f);

        AbstractAggregationFunction aggregationFunction = new AggregationMedianFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(12.5f, result);
    }

    @Test
    void testAggregateValuesMedianEmptyListReturnNaN() {
        List<Float> values = List.of();

        AbstractAggregationFunction aggregationFunction = new AggregationMedianFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(Float.NaN, result);
    }

    @Test
    void testAggregateValuesMedianNullListReturnNaN() {
        List<Float> values = Arrays.asList(null, null, null);

        AbstractAggregationFunction aggregationFunction = new AggregationMedianFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(Float.NaN, result);
    }


}

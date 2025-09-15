package org.n52.kommonitor.importer.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AggregationMaxFunctionTest {

    protected static AggregationTestDataProvider provider;

    @BeforeAll
    static void init() {
        provider = new AggregationTestDataProvider();
    }

    @Test
    void testAggregateValuesMax() {
        List<Float> values = Arrays.asList(10f, 10f, 10.1f, 11f, 12f, 13f, null, 14f);

        AbstractAggregationFunction aggregationFunction = new AggregationMaxFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(14f, result);
    }

    @Test
    void testAggregateValuesMaxEmptyListReturnNaN() {
        List<Float> values = List.of();

        AbstractAggregationFunction aggregationFunction = new AggregationMaxFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(Float.NaN, result);
    }

    @Test
    void testAggregateValuesMaxNullListReturnNaN() {
        List<Float> values = Arrays.asList(null, null, null);

        AbstractAggregationFunction aggregationFunction = new AggregationMaxFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(Float.NaN, result);
    }


}

package org.n52.kommonitor.importer.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.n52.kommonitor.importer.entities.IndicatorValue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AggregationMeanFunctionTest {

    protected static AggregationTestDataProvider provider;

    @BeforeAll
    static void init() {
        provider = new AggregationTestDataProvider();
    }

    @Test
    void testAggregateValuesMean() {
        List<Float> values = Arrays.asList(10f, 11f, 12f, 13f, null, 14f);

        AbstractAggregationFunction aggregationFunction = new AggregationMeanFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(12f, result);
    }

    @Test
    void testAggregateValuesMeanEmptyListReturnNaN() {
        List<Float> values = List.of();

        AbstractAggregationFunction aggregationFunction = new AggregationMeanFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(Float.NaN, result);
    }

    @Test
    void testAggregateValuesMeanNullListReturnNaN() {
        List<Float> values = Arrays.asList(null, null, null);

        AbstractAggregationFunction aggregationFunction = new AggregationMeanFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(Float.NaN, result);
    }


}

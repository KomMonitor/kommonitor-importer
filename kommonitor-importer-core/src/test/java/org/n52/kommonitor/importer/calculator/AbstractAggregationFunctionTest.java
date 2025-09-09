package org.n52.kommonitor.importer.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.n52.kommonitor.importer.entities.IndicatorValue;

import java.time.LocalDate;
import java.util.*;

public class AbstractAggregationFunctionTest {

    protected static AggregationTestDataProvider provider;

    @BeforeAll
    static void init() {
        provider = new AggregationTestDataProvider();
    }

    @Test
    void testGroupIndicatorsBySpatialUnit() {
        List<IndicatorValue> valueList = Arrays.asList(provider.getValue01(), provider.getValue02(), provider.getValue03(),
                provider.getValue04(), provider.getValue05(), provider.getValue06());

        AbstractAggregationFunction aggregationFunction = new AggregationCountFunction();
        Map<String, List<IndicatorValue>> groupedValues = aggregationFunction.groupIndicatorsBySpatialUnit(valueList);

        Assertions.assertEquals(3, groupedValues.size());

        Assertions.assertEquals(1, groupedValues.get("01").size());
        Assertions.assertEquals(2, groupedValues.get("02").size());
        Assertions.assertEquals(3, groupedValues.get("03").size());

        Assertions.assertEquals("01", groupedValues.get("01").get(0).getSpatialReferenceKey());
        Assertions.assertEquals(6, groupedValues.get("01").get(0).getTimeSeriesValueList().size());

        Assertions.assertEquals("02", groupedValues.get("02").get(0).getSpatialReferenceKey());
        Assertions.assertEquals("02", groupedValues.get("02").get(1).getSpatialReferenceKey());
        Assertions.assertEquals(4, groupedValues.get("02").get(1).getTimeSeriesValueList().size());

        Assertions.assertEquals("03", groupedValues.get("03").get(0).getSpatialReferenceKey());
        Assertions.assertEquals("03", groupedValues.get("03").get(1).getSpatialReferenceKey());
        Assertions.assertEquals("03", groupedValues.get("03").get(2).getSpatialReferenceKey());
        Assertions.assertEquals(4, groupedValues.get("03").get(1).getTimeSeriesValueList().size());
    }

    @Test
    void testGroupIndicatorsByTimestamp() {
        List<IndicatorValue> valueList = Arrays.asList(provider.getValue04(), provider.getValue05(), provider.getValue06());

        AbstractAggregationFunction aggregationFunction = new AggregationCountFunction();
        Map<LocalDate, List<Float>> groupedValues = aggregationFunction.groupIndicatorsByTimestamp(valueList);

        Assertions.assertEquals(6, groupedValues.size());
        Assertions.assertTrue(groupedValues.containsKey(LocalDate.of(2022,1,1)));
        Assertions.assertFalse(groupedValues.containsKey(LocalDate.of(2002,1,1)));

        Assertions.assertEquals(3, groupedValues.get(LocalDate.of(2022,1,1)).size());
        Assertions.assertEquals(2, groupedValues.get(LocalDate.of(2021,1,1)).size());
        Assertions.assertEquals(2, groupedValues.get(LocalDate.of(2025,1,1)).size());

        Assertions.assertEquals(52f, groupedValues.get(LocalDate.of(2022,1,1)).get(2));
        Assertions.assertEquals(51f, groupedValues.get(LocalDate.of(2021,1,1)).get(1));
        Assertions.assertEquals(25f, groupedValues.get(LocalDate.of(2025,1,1)).get(0));
    }

}

package org.n52.kommonitor.importer.calculator;

import org.apache.commons.io.IOUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.TimeseriesValue;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

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

    @Test
    void testAggregateValues() {
        Map<LocalDate, List<Float>> groupedValues = new HashMap<>();
        List<Float> valueList01 = Arrays.asList(12f, 13f, 14f, 15f, 16f);
        List<Float> valueList02 = Arrays.asList(12f, 13f, 14f, null, 16f);
        List<Float> valueList03 = Arrays.asList(null, null);
        List<Float> valueList04 = List.of();

        groupedValues.put(LocalDate.of(2020, 1, 1), valueList01);
        groupedValues.put(LocalDate.of(2021, 1, 1), valueList02);
        groupedValues.put(LocalDate.of(2022, 1, 1), valueList03);
        groupedValues.put(LocalDate.of(2023, 1, 1), valueList04);

        AbstractAggregationFunction aggregationFunction = new AggregationMeanFunction();

        List<TimeseriesValue> result = aggregationFunction.aggregateValues(groupedValues);

        Assertions.assertEquals(4, result.size());

        Assertions.assertEquals(LocalDate.of(2020, 1, 1), result.get(0).getTimestamp());
        Assertions.assertNotNull(result.get(0).getValue());

        Assertions.assertEquals(LocalDate.of(2021, 1, 1), result.get(1).getTimestamp());
        Assertions.assertNotNull(result.get(1).getValue());

        Assertions.assertEquals(LocalDate.of(2022, 1, 1), result.get(2).getTimestamp());
        Assertions.assertNull(result.get(2).getValue());

        Assertions.assertEquals(LocalDate.of(2023, 1, 1), result.get(3).getTimestamp());
        Assertions.assertNull(result.get(3).getValue());
    }

}

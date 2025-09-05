package org.n52.kommonitor.importer.calculator;

import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.TimeseriesValue;

import java.time.LocalDate;
import java.util.*;

public class AggregationFunctionTest {

    protected static IndicatorValue value01;
    protected static IndicatorValue value02;
    protected static IndicatorValue value03;
    protected static IndicatorValue value04;
    protected static IndicatorValue value05;
    protected static IndicatorValue value06;

    @BeforeAll
    static void init() {
        value01 = new IndicatorValue("01", createTimeseriesValues01());
        value02 = new IndicatorValue("02", createTimeseriesValues02());
        value03 = new IndicatorValue("02", createTimeseriesValues03());
        value04 = new IndicatorValue("03", createTimeseriesValues01());
        value05 = new IndicatorValue("03", createTimeseriesValues03());
        value06 = new IndicatorValue("03", createTimeseriesValues04());
    }

    private static @NotNull List<TimeseriesValue> createTimeseriesValues01() {
        List<TimeseriesValue> timeseries = new ArrayList<>();
        timeseries.add(new TimeseriesValue(20f, LocalDate.of(2020,1,1)));
        timeseries.add(new TimeseriesValue(21f, LocalDate.of(2021,1,1)));
        timeseries.add(new TimeseriesValue(22f, LocalDate.of(2022,1,1)));
        timeseries.add(new TimeseriesValue(23f, LocalDate.of(2023,1,1)));
        timeseries.add(new TimeseriesValue(24f, LocalDate.of(2024,1,1)));
        timeseries.add(new TimeseriesValue(25f, LocalDate.of(2025,1,1)));
        return timeseries;
    }

    private static @NotNull List<TimeseriesValue> createTimeseriesValues02() {
        List<TimeseriesValue> timeseries = new ArrayList<>();
        timeseries.add(new TimeseriesValue(30f, LocalDate.of(2020,1,1)));
        timeseries.add(new TimeseriesValue(32f, LocalDate.of(2022,1,1)));
        timeseries.add(new TimeseriesValue(33f, LocalDate.of(2023,1,1)));
        timeseries.add(new TimeseriesValue(34f, LocalDate.of(2024,1,1)));
        timeseries.add(new TimeseriesValue(35f, LocalDate.of(2025,1,1)));
        return timeseries;
    }

    private static @NotNull List<TimeseriesValue> createTimeseriesValues03() {
        List<TimeseriesValue> timeseries = new ArrayList<>();
        timeseries.add(new TimeseriesValue(40f, LocalDate.of(2020,1,1)));
        timeseries.add(new TimeseriesValue(42f, LocalDate.of(2022,1,1)));
        timeseries.add(new TimeseriesValue(43f, LocalDate.of(2023,1,1)));
        timeseries.add(new TimeseriesValue(45f, LocalDate.of(2025,1,1)));
        return timeseries;
    }

    private static @NotNull List<TimeseriesValue> createTimeseriesValues04() {
        List<TimeseriesValue> timeseries = new ArrayList<>();
        timeseries.add(new TimeseriesValue(50f, LocalDate.of(2020,1,1)));
        timeseries.add(new TimeseriesValue(51f, LocalDate.of(2021,1,1)));
        timeseries.add(new TimeseriesValue(52f, LocalDate.of(2022,1,1)));
        timeseries.add(new TimeseriesValue(null, LocalDate.of(2023,1,1)));
        timeseries.add(new TimeseriesValue(54f, LocalDate.of(2024,1,1)));
        return timeseries;
    }

    @Test
    void testGroupIndicatorsBySpatialUnit() {
        List<IndicatorValue> valueList = Arrays.asList(value01, value02, value03, value04, value05, value06);


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
        List<IndicatorValue> valueList = Arrays.asList(value04, value05, value06);

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
    void testAggregateValuesCount() {
        List<Float> values = Arrays.asList(10f, 11f, 12f, 13f, 14f);

        AbstractAggregationFunction aggregationFunction = new AggregationCountFunction();
        Float result = aggregationFunction.aggregateValues(values);

        Assertions.assertEquals(5, result);
    }

    @Test
    void testAggregateCount() {
        List<IndicatorValue> valueList = Arrays.asList(value01, value02, value03, value04, value05, value06);

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

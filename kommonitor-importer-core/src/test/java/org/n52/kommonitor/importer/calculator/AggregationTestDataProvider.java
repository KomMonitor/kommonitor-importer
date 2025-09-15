package org.n52.kommonitor.importer.calculator;

import jakarta.validation.constraints.NotNull;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.TimeseriesValue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AggregationTestDataProvider {

    private IndicatorValue value01;
    private static IndicatorValue value02;
    private static IndicatorValue value03;
    private static IndicatorValue value04;
    private static IndicatorValue value05;
    private static IndicatorValue value06;

    public AggregationTestDataProvider() {
        value01 = new IndicatorValue("01", createTimeseriesValues01());
        value02 = new IndicatorValue("02", createTimeseriesValues02());
        value03 = new IndicatorValue("02", createTimeseriesValues03());
        value04 = new IndicatorValue("03", createTimeseriesValues01());
        value05 = new IndicatorValue("03", createTimeseriesValues03());
        value06 = new IndicatorValue("03", createTimeseriesValues04());
    }

    public IndicatorValue getValue01() {
        return value01;
    }

    public IndicatorValue getValue02() {
        return value02;
    }

    public IndicatorValue getValue03() {
        return value03;
    }

    public IndicatorValue getValue04() {
        return value04;
    }

    public IndicatorValue getValue05() {
        return value05;
    }

    public IndicatorValue getValue06() {
        return value06;
    }

    private @NotNull List<TimeseriesValue> createTimeseriesValues01() {
        List<TimeseriesValue> timeseries = new ArrayList<>();
        timeseries.add(new TimeseriesValue(20f, LocalDate.of(2020,1,1)));
        timeseries.add(new TimeseriesValue(21f, LocalDate.of(2021,1,1)));
        timeseries.add(new TimeseriesValue(22f, LocalDate.of(2022,1,1)));
        timeseries.add(new TimeseriesValue(23f, LocalDate.of(2023,1,1)));
        timeseries.add(new TimeseriesValue(24f, LocalDate.of(2024,1,1)));
        timeseries.add(new TimeseriesValue(25f, LocalDate.of(2025,1,1)));
        return timeseries;
    }

    private @NotNull List<TimeseriesValue> createTimeseriesValues02() {
        List<TimeseriesValue> timeseries = new ArrayList<>();
        timeseries.add(new TimeseriesValue(30f, LocalDate.of(2020,1,1)));
        timeseries.add(new TimeseriesValue(32f, LocalDate.of(2022,1,1)));
        timeseries.add(new TimeseriesValue(33f, LocalDate.of(2023,1,1)));
        timeseries.add(new TimeseriesValue(34f, LocalDate.of(2024,1,1)));
        timeseries.add(new TimeseriesValue(35f, LocalDate.of(2025,1,1)));
        return timeseries;
    }

    private @NotNull List<TimeseriesValue> createTimeseriesValues03() {
        List<TimeseriesValue> timeseries = new ArrayList<>();
        timeseries.add(new TimeseriesValue(40f, LocalDate.of(2020,1,1)));
        timeseries.add(new TimeseriesValue(42f, LocalDate.of(2022,1,1)));
        timeseries.add(new TimeseriesValue(43f, LocalDate.of(2023,1,1)));
        timeseries.add(new TimeseriesValue(45f, LocalDate.of(2025,1,1)));
        return timeseries;
    }

    private @NotNull List<TimeseriesValue> createTimeseriesValues04() {
        List<TimeseriesValue> timeseries = new ArrayList<>();
        timeseries.add(new TimeseriesValue(50f, LocalDate.of(2020,1,1)));
        timeseries.add(new TimeseriesValue(51f, LocalDate.of(2021,1,1)));
        timeseries.add(new TimeseriesValue(52f, LocalDate.of(2022,1,1)));
        timeseries.add(new TimeseriesValue(null, LocalDate.of(2023,1,1)));
        timeseries.add(new TimeseriesValue(54f, LocalDate.of(2024,1,1)));
        return timeseries;
    }
}

package org.n52.kommonitor.importer.entities;

import jakarta.validation.constraints.NotNull;

import java.util.*;

/**
 * POJO for indicator related information
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class IndicatorValue {

    private String spatialReferenceKey;
    private List<TimeseriesValue> timeSeriesValueList;
    private Map<String, String> upperSpatialUnitReferences;

    public IndicatorValue(){

    }

    public IndicatorValue(@NotNull String spatialReferenceKey, @NotNull List<TimeseriesValue> timeSeriesValueList) {
        this.spatialReferenceKey = spatialReferenceKey;
        this.timeSeriesValueList = timeSeriesValueList;
        this.upperSpatialUnitReferences = new HashMap<>();
    }

    public IndicatorValue(@NotNull String spatialReferenceKey, @NotNull List<TimeseriesValue> timeSeriesValueList, @NotNull Map<String, String> spatialUnitReferences) {
        this.spatialReferenceKey = spatialReferenceKey;
        this.timeSeriesValueList = timeSeriesValueList;
        this.upperSpatialUnitReferences = spatialUnitReferences;
    }

    public String getSpatialReferenceKey() {
        return spatialReferenceKey;
    }

    public List<TimeseriesValue> getTimeSeriesValueList() {
        return timeSeriesValueList;
    }

    public void setTimeSeriesValueList(@NotNull List<TimeseriesValue> timeSeriesValueList) {
        this.timeSeriesValueList = timeSeriesValueList;
    }

    public Map<String, String> getUpperSpatialUnitReferences() {
        return upperSpatialUnitReferences;
    }

    public void setUpperSpatialUnitReferences(@NotNull Map<String, String> upperSpatialUnitReferences) {
        this.upperSpatialUnitReferences = upperSpatialUnitReferences;
    }
}

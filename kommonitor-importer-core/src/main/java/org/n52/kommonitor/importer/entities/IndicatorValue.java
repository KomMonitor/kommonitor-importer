package org.n52.kommonitor.importer.entities;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * POJO for indicator related information
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class IndicatorValue {

    private String spatialReferenceKey;

    private List<TimeseriesValue> timeSeriesValueList;

    public IndicatorValue(){

    }

    public IndicatorValue(@NotNull String spatialReferenceKey, @NotNull List<TimeseriesValue> timeSeriesValueList) {
        this.spatialReferenceKey = spatialReferenceKey;
        this.timeSeriesValueList = timeSeriesValueList;
    }

    public String getSpatialReferenceKey() {
        return spatialReferenceKey;
    }

    public void setSpatialReferenceKey(@NotNull String spatialReferenceKey) {
        this.spatialReferenceKey = spatialReferenceKey;
    }

    public List<TimeseriesValue> getTimeSeriesValueList() {
        return timeSeriesValueList;
    }

    public void setTimeSeriesValueList(@NotNull List<TimeseriesValue> timeSeriesValueList) {
        this.timeSeriesValueList = timeSeriesValueList;
    }
}

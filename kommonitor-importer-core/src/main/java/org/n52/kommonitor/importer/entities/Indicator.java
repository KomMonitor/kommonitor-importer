package org.n52.kommonitor.importer.entities;

import java.util.List;

/**
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class Indicator {

    private String spatialReferenceKey;

    private List<TimeseriesValue> timeSeriesValueList;

    public String getSpatialReferenceKey() {
        return spatialReferenceKey;
    }

    public void setSpatialReferenceKey(String spatialReferenceKey) {
        this.spatialReferenceKey = spatialReferenceKey;
    }

    public List<TimeseriesValue> getTimeSeriesValueList() {
        return timeSeriesValueList;
    }

    public void setTimeSeriesValueList(List<TimeseriesValue> timeSeriesValueList) {
        this.timeSeriesValueList = timeSeriesValueList;
    }
}

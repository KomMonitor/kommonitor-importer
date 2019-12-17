package org.n52.kommonitor.importer.entities;

import java.time.LocalDateTime;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class TimeseriesValue {

    private double value;

    private LocalDateTime timestamp;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

package org.n52.kommonitor.importer.entities;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class TimeseriesValue {

    private Float value;

    private LocalDate timestamp;

    public TimeseriesValue (){

    }

    public TimeseriesValue(Float value, @NotNull LocalDate timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NotNull LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}

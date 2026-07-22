package org.n52.kommonitor.importer.entities;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class TimeseriesValue<T> {

    private T value;

    private LocalDate timestamp;

    public TimeseriesValue() {

    }

    public TimeseriesValue(T value, @NotNull LocalDate timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NotNull LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}

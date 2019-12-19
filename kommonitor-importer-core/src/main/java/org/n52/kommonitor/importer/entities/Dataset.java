package org.n52.kommonitor.importer.entities;

/**
 * Generic wrapper for a certain dataset of type T
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class Dataset<T> {

    private T data;

    public Dataset(T data) {
        this.data = data;

    }

    public T getData() {
        return data;
    }
}

package org.n52.kommonitor.importer.entities;

import org.locationtech.jts.geom.Geometry;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * A spatial resource that encapsulates the GeoJSON values for spatial units and georesources
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class SpatialResource {
    private String id;
    private String name;
    private LocalDateTime startDate;
    private Optional<LocalDateTime> endDate;
    private Geometry geom;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Optional<LocalDateTime> getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = Optional.ofNullable(endDate);
    }
}

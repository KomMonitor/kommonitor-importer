package org.n52.kommonitor.importer.entities;

import org.locationtech.jts.geom.Geometry;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * A spatial resource that encapsulates the GeoJSON values for spatial units and georesources.
 * Note that the geometries are implicit inthe WGS 84 coordinate system.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class SpatialResource {
    private String id;
    private String name;
    private Geometry geom;
    private Optional<String> arisenFrom;
    private Optional<LocalDate> startDate;
    private Optional<LocalDate> endDate;

    public SpatialResource() {

    }


    public SpatialResource(@NotNull String id, @NotNull String name, @NotNull Geometry geom, String arisenFrom, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.geom = geom;
        this.arisenFrom = Optional.ofNullable(arisenFrom);
        this.startDate = Optional.ofNullable(startDate);
        this.endDate = Optional.ofNullable(endDate);
    }

    public String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(@NotNull Geometry geom) {
        this.geom = geom;
    }

    public Optional<String> getArisenFrom() {
        return arisenFrom;
    }

    public void setArisenFrom(String arisenFrom) {
        this.arisenFrom = Optional.ofNullable(arisenFrom);
    }

    public Optional<LocalDate> getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = Optional.ofNullable(startDate);
    }

    public Optional<LocalDate> getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = Optional.ofNullable(endDate);
    }
}

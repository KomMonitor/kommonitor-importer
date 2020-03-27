package org.n52.kommonitor.importer.entities;

import org.locationtech.jts.geom.Geometry;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
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
    private Optional<Map> attributes;

    public SpatialResource() {

    }


    public SpatialResource(@NotNull String id, @NotNull String name, @NotNull Geometry geom, String arisenFrom, LocalDate startDate, LocalDate endDate, Map attributes) {
        this.id = id;
        this.name = name;
        this.geom = geom;
        this.arisenFrom = Optional.ofNullable(arisenFrom);
        this.startDate = Optional.ofNullable(startDate);
        this.endDate = Optional.ofNullable(endDate);
        this.attributes = Optional.ofNullable(attributes);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Geometry getGeom() {
        return geom;
    }

    public Optional<String> getArisenFrom() {
        return arisenFrom;
    }

    public Optional<LocalDate> getStartDate() {
        return startDate;
    }

    public Optional<LocalDate> getEndDate() {
        return endDate;
    }

    public Optional<Map> getAttributes() {
        return attributes;
    }
}

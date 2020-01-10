package org.n52.kommonitor.importer.api.encoder;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.models.ImportSpatialUnitPOSTInputType;
import org.n52.kommonitor.importer.models.SpatialUnitPOSTInputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Encodes a {@link ImportSpatialUnitPOSTInputType} and a {@link List<SpatialResource>} into a {@link SpatialUnitPOSTInputType}
 * for usage within a {@link org.n52.kommonitor.importer.api.SpatialUnitsApi} client.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class SpatialUnitEncoder {

    @Autowired
    private SpatialResourceJsonEncoder spatialResourceEncoder;

    public SpatialUnitPOSTInputType encode(ImportSpatialUnitPOSTInputType importType, List<SpatialResource> spatialResources) throws JsonProcessingException {
        SpatialUnitPOSTInputType spatialUnit = importType.getSpatialUnitPostBody();
        spatialUnit.setGeoJsonString(spatialResourceEncoder.encodeSpatialResourcesAsString(spatialResources));
        return spatialUnit;
    }
}

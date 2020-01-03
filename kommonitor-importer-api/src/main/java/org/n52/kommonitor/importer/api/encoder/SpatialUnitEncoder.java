package org.n52.kommonitor.importer.api.encoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.n52.kommonitor.datamanagement.api.models.GeoresourcePOSTInputType;
import org.n52.kommonitor.datamanagement.api.models.SpatialUnitPOSTInputType;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.models.ImportGeoresourcePOSTInputType;
import org.n52.kommonitor.importer.models.ImportSpatialUnitPOSTInputType;
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
    private ApiEncodingHelper encodingHelper;

    @Autowired
    private SpatialResourceJsonEncoder spatialResourceEncoder;

    public SpatialUnitPOSTInputType encode(ImportSpatialUnitPOSTInputType importType, List<SpatialResource> spatialResources) throws JsonProcessingException {
        SpatialUnitPOSTInputType spatialUnit = new SpatialUnitPOSTInputType();
        spatialUnit.setJsonSchema(importType.getJsonSchema());
        if (importType.getMetadata() != null) {
            spatialUnit.setMetadata(encodingHelper.encodeMetadata(importType.getMetadata()));
        }
        spatialUnit.setNextLowerHierarchyLevel(importType.getNextLowerHierarchyLevel());
        spatialUnit.setNextUpperHierarchyLevel(importType.getNextUpperHierarchyLevel());
        if (importType.getPeriodOfValidity() != null) {
            spatialUnit.setPeriodOfValidity(encodingHelper.encodePeriodOfValidity(importType.getPeriodOfValidity()));
        }
        spatialUnit.setSpatialUnitLevel(importType.getSpatialUnitLevel());
        spatialUnit.setGeoJsonString(spatialResourceEncoder.encodeSpatialResourcesAsString(spatialResources));
        return spatialUnit;
    }
}

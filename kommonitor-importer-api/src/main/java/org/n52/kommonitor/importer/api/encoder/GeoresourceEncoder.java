package org.n52.kommonitor.importer.api.encoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.models.GeoresourcePOSTInputType;
import org.n52.kommonitor.importer.models.ImportGeoresourcePOSTInputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Encodes a {@link ImportGeoresourcePOSTInputType} and a {@link List<SpatialResource>} into a {@link GeoresourcePOSTInputType}
 * for usage within a {@link org.n52.kommonitor.importer.api.GeoresourcesApi} client.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class GeoresourceEncoder {

    @Autowired
    private SpatialResourceJsonEncoder spatialResourceEncoder;

    public GeoresourcePOSTInputType encode(ImportGeoresourcePOSTInputType importType, List<SpatialResource> spatialResources) throws JsonProcessingException {
        GeoresourcePOSTInputType geoResource = importType.getGeoresourcePostBody();
        geoResource.setGeoJsonString(spatialResourceEncoder.encodeSpatialResourcesAsString(spatialResources));
        return geoResource;
    }


}

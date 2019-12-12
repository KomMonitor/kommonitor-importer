package org.n52.kommonitor.importer.api.encoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Helper class for encoding {@link List<SpatialResource>} into GeoJSON FeatureCollection
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class SpatialResourceEncoder implements InitializingBean {

    private ObjectMapper mapper;

    public String encodeSpatialresources(List<SpatialResource> spatialResource) {
        //TODO implement GeoJSON feature collection encoding
        return "";
    }

    public String encodeSpatialresource(SpatialResource resource) {
        //TODO implement GeoJSON feature encoding
        return "";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        mapper = new ObjectMapper();
    }
}

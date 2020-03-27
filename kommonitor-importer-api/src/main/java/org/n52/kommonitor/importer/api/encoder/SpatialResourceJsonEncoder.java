package org.n52.kommonitor.importer.api.encoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.geotools.geojson.geom.GeometryJSON;
import org.locationtech.jts.geom.Geometry;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Helper class for encoding {@link List<SpatialResource>} into GeoJSON FeatureCollection
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
/**
 * Helper class to encode {@link SpatialResource} objects as JSON
 */
public class SpatialResourceJsonEncoder implements InitializingBean {

    private static final Logger LOG = LoggerFactory.getLogger(SpatialResourceJsonEncoder.class);

    private static final String FIELD_NAME_TYPE = "type";
    private static final String FIELD_NAME_FEATURES = "features";
    private static final String FIELD_NAME_PROPERTIES = "properties";
    private static final String FIELD_NAME_GEOMETRY = "geometry";
    private static final String FIELD_NAME_ID = "ID";
    private static final String FIELD_NAME_NAME = "NAME";
    private static final String FIELD_NAME_ARISEN_FROM = "arisenFrom";
    private static final String FIELD_NAME_VALID_START_DATE = "validStartDate";
    private static final String FIELD_NAME_VALID_END_DATE = "validEndDate";


    private static final String TYPE_VALUE_FEATURE_COLLECTION = "FeatureCollection";
    private static final String TYPE_VALUE_FEATURE = "Feature";

    private ObjectMapper mapper;
    private GeometryJSON geomJson;

    /**
     * Encodes a list of {@link SpatialResource} objects as JSON
     *
     * @param spatialResource {@link SpatialResource} objects to encode
     * @return a JSON object that represents the list of {@link SpatialResource} objects
     */
    public JsonNode encodeSpatialResourcesAsJsonNode(List<SpatialResource> spatialResource) {
        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.put(FIELD_NAME_TYPE, TYPE_VALUE_FEATURE_COLLECTION);
        ArrayNode featuresArrayNode = mapper.createArrayNode();
        spatialResource.forEach(s -> {
            try {
                featuresArrayNode.add(encodeSpatialResourceAsJsonNode(s));
            } catch (JsonProcessingException e) {
                LOG.warn("Could not encode geometry: {}", s.getGeom().toText());
            }
        });
        rootNode.set(FIELD_NAME_FEATURES, featuresArrayNode);
        return rootNode;
    }

    public String encodeSpatialResourcesAsString(List<SpatialResource> spatialResource) throws JsonProcessingException {
        return mapper.writeValueAsString(encodeSpatialResourcesAsJsonNode(spatialResource));
    }

    public JsonNode encodeSpatialResourceAsJsonNode(SpatialResource resource) throws JsonProcessingException {
        ObjectNode featureNode = mapper.createObjectNode();
        featureNode.put(FIELD_NAME_TYPE, TYPE_VALUE_FEATURE);
        featureNode.set(FIELD_NAME_PROPERTIES, encodeProperties(resource));
        featureNode.set(FIELD_NAME_GEOMETRY, encodeGeometry(resource.getGeom()));
        return featureNode;
    }

    public JsonNode encodeProperties(SpatialResource resource) {
        ObjectNode propertiesNode = mapper.createObjectNode();
        propertiesNode.put(FIELD_NAME_ID, resource.getId());
        propertiesNode.put(FIELD_NAME_NAME, resource.getName());
        resource.getArisenFrom().ifPresent(arisenFrom -> propertiesNode.put(FIELD_NAME_ARISEN_FROM, arisenFrom));
        resource.getStartDate().ifPresent(startDate -> propertiesNode.put(FIELD_NAME_VALID_START_DATE, startDate.toString()));
        resource.getEndDate().ifPresent(endDate -> propertiesNode.put(FIELD_NAME_VALID_END_DATE, endDate.toString()));
        resource.getAttributes().ifPresent(attributes -> writeAttributeMap(propertiesNode, attributes));
        return propertiesNode;
    }

    public JsonNode encodeGeometry(Geometry geom) throws JsonProcessingException {
        return mapper.readTree(geomJson.toString(geom));
    }

    void writeAttributeMap(ObjectNode propertiesNode, Map<String, Object> attributes) {
        attributes.forEach((k, v) -> {
            if (v instanceof Integer) {
                propertiesNode.put(k, (Integer) v);
            } else if (v instanceof Float) {
                propertiesNode.put(k, (Float) v);
            } else if (v instanceof LocalDate) {
                propertiesNode.put(k, ((LocalDate) v).toString());
            } else {
                propertiesNode.put(k, String.valueOf(v));
            }
        });
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        mapper = new ObjectMapper();
        geomJson = new GeometryJSON();
    }
}

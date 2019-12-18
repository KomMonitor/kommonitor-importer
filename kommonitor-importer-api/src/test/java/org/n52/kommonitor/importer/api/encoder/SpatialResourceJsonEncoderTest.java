package org.n52.kommonitor.importer.api.encoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.n52.kommonitor.importer.entities.SpatialResource;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class SpatialResourceJsonEncoderTest {

    private static final String RESOURCE_NAME = "testName";
    private static final String RESOURCE_ID = "testId";
    private static final String RESOURCE_ARISEN_FROM = "testRefId";
    private static final String RESOURCE_TYPE_FEATURE = "Feature";
    private static final String RESOURCE_TYPE_FEATURE_COLLECTION = "FeatureCollection";

    private LocalDate startDate;
    private LocalDate endDate;
    private SpatialResource resource;
    private SpatialResourceJsonEncoder encoder;

    @BeforeEach
    void init() throws Exception {
        startDate = LocalDate.of(2019, 12, 16);
        endDate = LocalDate.of(2020, 11, 30);
        GeometryFactory geomFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate(7.123, 52.123);
        resource = new SpatialResource(RESOURCE_ID, RESOURCE_NAME, geomFactory.createPoint(coordinate), RESOURCE_ARISEN_FROM, startDate, endDate);


        encoder = new SpatialResourceJsonEncoder();
        encoder.afterPropertiesSet();
    }

    @Test
    @DisplayName("Test encode completely filled properties")
    public void testEncodeCompleteProperties() {
        JsonNode propertiesNode = encoder.encodeProperties(resource);

        Assertions.assertEquals(RESOURCE_NAME, propertiesNode.get("NAME").asText());
        Assertions.assertEquals(RESOURCE_ID, propertiesNode.get("ID").asText());
        Assertions.assertEquals(RESOURCE_ARISEN_FROM, propertiesNode.get("arisenFrom").asText());
        Assertions.assertEquals(startDate.toString(), propertiesNode.get("validStartDate").asText());
        Assertions.assertEquals(endDate.toString(), propertiesNode.get("validEndDate").asText());
    }

    @Test
    @DisplayName("Test null property should not be encoded")
    public void testEncodeNullProperty() {
        resource.setArisenFrom(null);
        JsonNode propertiesNode = encoder.encodeProperties(resource);

        Assertions.assertFalse(propertiesNode.has("arisenFrom"));
    }

    @Test
    @DisplayName("Test encode Feature")
    public void testEncodeFeature() throws JsonProcessingException {
        JsonNode featureNode = encoder.encodeSpatialResourceAsJsonNode(resource);

        Assertions.assertEquals(RESOURCE_TYPE_FEATURE, featureNode.get("type").asText());
        Assertions.assertTrue(featureNode.has("geometry"));
        Assertions.assertTrue(featureNode.has("properties"));
    }

    @Test
    @DisplayName("Test encode FeatureCollection")
    public void testEncodeFeatureCollection() throws JsonProcessingException {
        JsonNode featureNode = encoder.encodeSpatialResourcesAsJsonNode(Arrays.asList(resource, resource));

        Assertions.assertEquals(RESOURCE_TYPE_FEATURE_COLLECTION, featureNode.get("type").asText());
        Assertions.assertTrue(featureNode.has("features"));
        Assertions.assertEquals(2, ((ArrayNode) featureNode.get("features")).size());
    }

}

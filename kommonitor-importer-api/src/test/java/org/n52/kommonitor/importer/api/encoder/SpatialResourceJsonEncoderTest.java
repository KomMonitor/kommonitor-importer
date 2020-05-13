package org.n52.kommonitor.importer.api.encoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.*;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.n52.kommonitor.importer.entities.SpatialResource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class SpatialResourceJsonEncoderTest {

    private static final String RESOURCE_NAME = "testName";
    private static final String RESOURCE_ID = "testId";
    private static final String RESOURCE_ARISEN_FROM = "testRefId";
    private static final String RESOURCE_TYPE_FEATURE = "Feature";
    private static final String RESOURCE_TYPE_FEATURE_COLLECTION = "FeatureCollection";

    private static LocalDate startDate;
    private static LocalDate endDate;
    private static SpatialResource resource;
    private static Point point;
    private static SpatialResourceJsonEncoder encoder;

    @BeforeAll
    static void init() throws Exception {
        startDate = LocalDate.of(2019, 12, 16);
        endDate = LocalDate.of(2020, 11, 30);
        GeometryFactory geomFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate(7.123, 52.123);
        point = geomFactory.createPoint(coordinate);

        encoder = new SpatialResourceJsonEncoder();
        encoder.afterPropertiesSet();
    }

    @Test
    @DisplayName("Test encode completely filled properties")
    public void testEncodeProperties() {
        Map<String, Object> attrMap = new HashMap<>();
        attrMap.put("testStr", "strValue");
        attrMap.put("testInt", 123);
        attrMap.put("testFloat", 123.123f);
        LocalDate testDate =LocalDate.of(2020, 11, 30);
        attrMap.put("testDate", testDate);
        resource = new SpatialResource(RESOURCE_ID, RESOURCE_NAME, point, RESOURCE_ARISEN_FROM, startDate, endDate, attrMap);
        JsonNode propertiesNode = encoder.encodeProperties(resource);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Assertions.assertEquals(RESOURCE_NAME, propertiesNode.get("NAME").asText());
        Assertions.assertEquals(RESOURCE_ID, propertiesNode.get("ID").asText());
        Assertions.assertEquals(RESOURCE_ARISEN_FROM, propertiesNode.get("arisenFrom").asText());
        Assertions.assertEquals(startDate.toString(), propertiesNode.get("validStartDate").asText());
        Assertions.assertEquals(endDate.toString(), propertiesNode.get("validEndDate").asText());
        Assertions.assertEquals("strValue", propertiesNode.get("testStr").asText());
        Assertions.assertEquals(123, propertiesNode.get("testInt").asInt());
        Assertions.assertEquals(123.123f, propertiesNode.get("testFloat").asDouble());
        Assertions.assertEquals(testDate.toString(), propertiesNode.get("testDate").asText());
    }

    @Test
    @DisplayName("Test null property should not be encoded")
    public void testEncodeNullProperty() {
        resource = new SpatialResource(RESOURCE_ID, RESOURCE_NAME, point, null, null, null, null);
        JsonNode propertiesNode = encoder.encodeProperties(resource);

        Assertions.assertFalse(propertiesNode.has("arisenFrom"));
        Assertions.assertFalse(propertiesNode.has("validStartDate"));
        Assertions.assertFalse(propertiesNode.has("validEndDate"));
    }

    @Test
    @DisplayName("Test encode Feature")
    public void testEncodeFeature() throws JsonProcessingException {
        resource = new SpatialResource(RESOURCE_ID, RESOURCE_NAME, point, RESOURCE_ARISEN_FROM, startDate, endDate, null);
        JsonNode featureNode = encoder.encodeSpatialResourceAsJsonNode(resource);

        Assertions.assertEquals(RESOURCE_TYPE_FEATURE, featureNode.get("type").asText());
        Assertions.assertTrue(featureNode.has("geometry"));
        Assertions.assertTrue(featureNode.has("properties"));
    }

    @Test
    @DisplayName("Test encode FeatureCollection")
    public void testEncodeFeatureCollection() throws JsonProcessingException {
        resource = new SpatialResource(RESOURCE_ID, RESOURCE_NAME, point, RESOURCE_ARISEN_FROM, startDate, endDate, null);
        JsonNode featureNode = encoder.encodeSpatialResourcesAsJsonNode(Arrays.asList(resource, resource));

        Assertions.assertEquals(RESOURCE_TYPE_FEATURE_COLLECTION, featureNode.get("type").asText());
        Assertions.assertTrue(featureNode.has("features"));
        Assertions.assertEquals(2, ((ArrayNode) featureNode.get("features")).size());
    }

}

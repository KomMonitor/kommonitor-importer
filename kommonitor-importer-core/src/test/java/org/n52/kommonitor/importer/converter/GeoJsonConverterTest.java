package org.n52.kommonitor.importer.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.utils.GeometryHelper;
import org.n52.kommonitor.models.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class GeoJsonConverterTest {

    private final static String MIME_TYPE = "application/geo+json";
    private final static String ENCODING = "UTF-8";

    private static ConverterDefinitionType convDef;
    private static SpatialResourcePropertyMappingType spatialResourcePropertyMapping;
    private static IndicatorPropertyMappingType indicatorPropertyMapping;

    private static GeoJsonConverter converter;

    @BeforeAll
    static void init() throws Exception {
        GeometryHelper geomHelper = new GeometryHelper();
        geomHelper.afterPropertiesSet();
        converter = new GeoJsonConverter(new FeatureDecoder(geomHelper));

        convDef = new ConverterDefinitionType();
        convDef.setMimeType(MIME_TYPE);
        convDef.setEncoding(ENCODING);
        ParameterValueType param = new ParameterValueType();
        param.setName("CRS");
        param.setValue("EPSG:25832");
        convDef.setParameters(Arrays.asList(param));

        spatialResourcePropertyMapping = new SpatialResourcePropertyMappingType();
        spatialResourcePropertyMapping.setIdentifierProperty("Baublock_ID");
        spatialResourcePropertyMapping.setNameProperty("Baublock_ID");
        spatialResourcePropertyMapping.setValidStartDateProperty("EreignisintervallStart");
        spatialResourcePropertyMapping.setValidEndDateProperty("EreignisintervallEnde");

        indicatorPropertyMapping = new IndicatorPropertyMappingType();
        indicatorPropertyMapping.setSpatialReferenceKeyProperty("Baublock_ID");

        TimeseriesMappingType timeseriesMapping = new TimeseriesMappingType();
        timeseriesMapping.setIndicatorValueProperty("dmg_altrstr_drchschnaltr");
        timeseriesMapping.setTimestampProperty("EreignisintervallStart");

        indicatorPropertyMapping.setTimeseriesMappings(Arrays.asList(timeseriesMapping));
    }

    @Test
    @DisplayName("Test convert SpatialResources for GeoJson dataset")
    void testConvertSpatialResourcesForGeoJsonDataset() throws ConverterException {
        InputStream input = getClass().getResourceAsStream("/features-test.geojson");
        Dataset<InputStream> dataset = new Dataset<>(input);

        List<SpatialResource> spatialResources = converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping);

        Assertions.assertEquals(3, spatialResources.size());
    }

    @Test
    @DisplayName("Test convert SpatialResources for GeoJson dataset throws ConverterException for non parsable dataset")
    void testConvertSpatialResourcesForGeoJsonDatasetThrowsConverterExceptionForNotParsableDataset() {
        Dataset<String> dataset = new Dataset<>("nonParsableFeatureCollection");

        Assertions.assertThrows(ConverterException.class, () -> converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping));
    }

}

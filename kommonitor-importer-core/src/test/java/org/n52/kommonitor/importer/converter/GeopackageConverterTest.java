package org.n52.kommonitor.importer.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.entities.TimeseriesValue;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.utils.GeometryHelper;
import org.n52.kommonitor.importer.utils.ImportMonitor;
import org.n52.kommonitor.models.*;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class GeopackageConverterTest {

    private final static String MIME_TYPE = "application/geopackage+sqlite3";
    private final static String ENCODING = "UTF-8";

    private static ConverterDefinitionType convDef;
    private static SpatialResourcePropertyMappingType spatialResourcePropertyMapping;

    private static GeopackageConverter converter;

    @BeforeAll
    static void init() throws Exception {
        GeometryHelper geomHelper = new GeometryHelper();
        geomHelper.afterPropertiesSet();
        ImportMonitor monitor = new ImportMonitor();
        converter = new GeopackageConverter(new FeatureDecoder(geomHelper, monitor));

        convDef = new ConverterDefinitionType();
        convDef.setMimeType(MIME_TYPE);
        convDef.setEncoding(ENCODING);
        ParameterValueType param = new ParameterValueType();
        param.setName("CRS");
        param.setValue("EPSG:4326");
//        convDef.setParameters(Collections.singletonList(param));

        convDef.setParameters(Arrays.asList(
                new ParameterValueType()
                        .name("CRS")
                        .value("EPSG:4326"),
                new ParameterValueType()
                        .name("Layer")
                        .value("timeseries"))
        );

        spatialResourcePropertyMapping = new SpatialResourcePropertyMappingType();
        spatialResourcePropertyMapping.setIdentifierProperty("baublock_id");
        spatialResourcePropertyMapping.setNameProperty("baublock_name");
        spatialResourcePropertyMapping.setKeepMissingOrNullValueAttributes(false);
    }

    @Test
    @DisplayName("Test convert SpatialResources for Geopackage dataset")
    void testConvertSpatialResourcesForGeopackageDataset() throws ConverterException {
        InputStream input = getClass().getResourceAsStream("/features-test.gpkg");
        Dataset<InputStream> dataset = new Dataset<>(input);
        spatialResourcePropertyMapping.setKeepAttributes(false);

        List<SpatialResource> spatialResources = converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping);
        SpatialResource resource = spatialResources.get(1);

        Assertions.assertEquals(4, spatialResources.size());
        Assertions.assertEquals("b_02", resource.getId());
        Assertions.assertEquals("baublock_02", resource.getName());
        Assertions.assertTrue(resource.getAttributes().isEmpty());
    }

    @Test
    @DisplayName("Test convert SpatialResources for Geopackage dataset with keeping additional attributes")
    void testConvertSpatialResourcesForGeoJsonDatasetWithKeepAttributes() throws ConverterException {
        InputStream input = getClass().getResourceAsStream("/features-test.gpkg");
        Dataset<InputStream> dataset = new Dataset<>(input);
        spatialResourcePropertyMapping.setKeepAttributes(true);

        List<SpatialResource> spatialResources = converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping);
        SpatialResource resource = spatialResources.get(2);

        Assertions.assertEquals(4, spatialResources.size());
        Assertions.assertEquals("b_03", resource.getId());
        Assertions.assertEquals("baublock_03", resource.getName());
        Assertions.assertTrue(resource.getAttributes().isPresent());
        Assertions.assertEquals("Baublock GHI", resource.getAttributes().get().get("alias"));
    }

    @Test
    @DisplayName("Test convert SpatialResources for Geopackage dataset throws ConverterException for non parsable dataset")
    void testConvertSpatialResourcesForGeopackageDatasetThrowsConverterExceptionForNotParsableDataset() {
        Dataset<String> dataset = new Dataset<>("nonParsableFeatureCollection");

        Assertions.assertThrows(ConverterException.class, () -> converter.convertSpatialResources(convDef, dataset, spatialResourcePropertyMapping));
    }

    @Test
    @DisplayName("Test convert Indicators for Geopackage dataset")
    void testConvertIndicators() throws ConverterException {
        IndicatorPropertyMappingType indicatorPropertyMapping = createDateAttributeTimeseriesMapping();

        InputStream input = getClass().getResourceAsStream("/features-test-timeseries.gpkg");
        Dataset<InputStream> dataset = new Dataset<>(input);

        List<IndicatorValue> indicators = converter.convertIndicators(convDef, dataset, indicatorPropertyMapping);
        IndicatorValue indicator = indicators.get(1);

        Assertions.assertEquals(4, indicators.size());
        Assertions.assertEquals("b_02", indicator.getSpatialReferenceKey());

        TimeseriesValue tv = indicator.getTimeSeriesValueList().get(0);
        Assertions.assertEquals("2020-01-01", tv.getTimestamp().toString());
        Assertions.assertEquals(40158.f, tv.getValue());
        tv = indicator.getTimeSeriesValueList().get(1);
        Assertions.assertEquals(42300.f, tv.getValue());
        Assertions.assertEquals("2021-01-01", tv.getTimestamp().toString());
        tv = indicator.getTimeSeriesValueList().get(2);
        Assertions.assertEquals(40573.f, tv.getValue());
        Assertions.assertEquals("2022-01-01", tv.getTimestamp().toString());
    }

    @Test
    @DisplayName("Test convert Indicators for GeoJson dataset with manual date values")
    void testConvertIndicatorsWithManualDateValues() throws ConverterException {
        IndicatorPropertyMappingType indicatorPropertyMapping = createManualDateValueTimeseriesMapping();

        InputStream input = getClass().getResourceAsStream("/features-test.gpkg");
        Dataset<InputStream> dataset = new Dataset<>(input);

        List<IndicatorValue> indicators = converter.convertIndicators(convDef, dataset, indicatorPropertyMapping);
        IndicatorValue indicator = indicators.get(2);

        Assertions.assertEquals(4, indicators.size());
        Assertions.assertEquals("b_03", indicator.getSpatialReferenceKey());

        TimeseriesValue tv = indicator.getTimeSeriesValueList().get(0);
        Assertions.assertEquals("2020-01-01", tv.getTimestamp().toString());
        Assertions.assertEquals(30875.f, tv.getValue());
        tv = indicator.getTimeSeriesValueList().get(1);
        Assertions.assertEquals(32930.f, tv.getValue());
        Assertions.assertEquals("2021-01-01", tv.getTimestamp().toString());
        tv = indicator.getTimeSeriesValueList().get(2);
        Assertions.assertEquals(29162, tv.getValue());
        Assertions.assertEquals("2022-01-01", tv.getTimestamp().toString());
    }

    private IndicatorPropertyMappingType createDateAttributeTimeseriesMapping() {
        IndicatorPropertyMappingType indicatorPropertyMapping = new IndicatorPropertyMappingType();
        indicatorPropertyMapping.setSpatialReferenceKeyProperty("baublock_id");
        indicatorPropertyMapping.setKeepMissingOrNullValueIndicator(false);

        TimeseriesMappingType timeseriesMapping = new TimeseriesMappingType();
        timeseriesMapping.setIndicatorValueProperty("einwohner");
        timeseriesMapping.setTimestampProperty("datum");

        indicatorPropertyMapping.setTimeseriesMappings(Collections.singletonList(timeseriesMapping));
        return indicatorPropertyMapping;
    }

    private IndicatorPropertyMappingType createManualDateValueTimeseriesMapping() {
        IndicatorPropertyMappingType indicatorPropertyMapping = new IndicatorPropertyMappingType();
        indicatorPropertyMapping.setSpatialReferenceKeyProperty("baublock_id");
        indicatorPropertyMapping.setKeepMissingOrNullValueIndicator(false);

        indicatorPropertyMapping.setTimeseriesMappings(Arrays.asList(
                new TimeseriesMappingType()
                        .indicatorValueProperty("einwohner_2020-01-01")
                        .timestamp(LocalDate.parse("2020-01-01")),
                new TimeseriesMappingType()
                        .indicatorValueProperty("einwohner_2021-01-01")
                        .timestamp(LocalDate.parse("2021-01-01")),
                new TimeseriesMappingType()
                        .indicatorValueProperty("einwohner_2022-01-01")
                        .timestamp(LocalDate.parse("2022-01-01"))));
        return indicatorPropertyMapping;
    }

    @Test
    @DisplayName(("Test group IndicatorValues"))
    void testGroupIndicatorValues() {
        String refKey = "ID_01";
        List<TimeseriesValue> timeSeriesValues01 = new ArrayList<>();
        timeSeriesValues01.add(new TimeseriesValue(1.234f, LocalDate.now()));
        List<TimeseriesValue> timeSeriesValues02 = new ArrayList<>();
        timeSeriesValues02.add(new TimeseriesValue(9.876f, LocalDate.now()));
        List<IndicatorValue> indicatorValues = Arrays.asList(
                new IndicatorValue(refKey, timeSeriesValues01),
                new IndicatorValue(refKey, timeSeriesValues02));

        List<IndicatorValue> groupedIndicatorValues = converter.groupIndicatorValues(indicatorValues);

        Assertions.assertEquals(1, groupedIndicatorValues.size());
        Assertions.assertEquals(refKey, groupedIndicatorValues.get(0).getSpatialReferenceKey());
    }

}
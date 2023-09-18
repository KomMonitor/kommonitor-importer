package org.n52.kommonitor.importer.converter;

import org.apache.commons.io.FileUtils;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.referencing.CRS;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.DecodingException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Converter for Geopackage datasets. Parses a Geopackage file as {@link FeatureCollection}
 * and converts it into KomMonitor resources.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class GeopackageConverter extends AbstractConverter {
    private static final String NAME = "Geopackage (*.gpkg)";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String PARAM_CRS = "CRS";
    private static final String PARAM_CRS_DESC = "Angabe des Koordinatenreferenzsystems als EPSG-Code (z.B. EPSG:4326)";

    private FeatureDecoder featureDecoder;

    @Autowired
    public GeopackageConverter(FeatureDecoder featureDecoder) {
        this.featureDecoder = featureDecoder;
    }

    @Override
    public String initName() {
        return NAME;
    }

    @Override
    public Set<String> initSupportedMimeType() {
        Set<String> mimeTypes = new HashSet<>();
        mimeTypes.add("application/geopackage+sqlite3");
        return mimeTypes;
    }

    @Override
    public Set<String> initSupportedSchemas() {
        return null;
    }

    @Override
    public Set<String> initSupportedEncoding() {
        Set<String> encodings = new HashSet<>();
        encodings.add(DEFAULT_ENCODING);

        return encodings;
    }

    @Override
    public Set<ConverterParameter> initConverterParameters() {
        Set<ConverterParameter> params = new HashSet();
        params.add(createCrsParameter());

        return params;
    }

    @Override
    public List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition,
                                                         Dataset dataset,
                                                         SpatialResourcePropertyMappingType propertyMapping)
            throws ConverterException, ImportParameterException {
        InputStream input = getInputStream(converterDefinition, dataset);
        try {
            return convertSpatialResources(converterDefinition, input, propertyMapping);
        } catch (IOException ex) {
            throw new ConverterException("Error while parsing dataset.", ex);
        }
    }

    private List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition,
                                                          InputStream dataset,
                                                          SpatialResourcePropertyMappingType propertyMapping)
            throws ImportParameterException, IOException {

        Optional<String> crsOpt = this.getParameterValue(PARAM_CRS, converterDefinition.getParameters());

        if (crsOpt.isEmpty()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_CRS);
        }

        List<SpatialResource> spatialResources = new ArrayList<>();

        // Store temp file file
        Path tmpFile = storeDatasetAsTempFile(dataset);

        Map<String, Object> params = new HashMap();
        params.put("dbtype", "geopkg");
        params.put("database", tmpFile.toString());
        params.put("read-only", true);

        DataStore dataStore = DataStoreFinder.getDataStore(params);
        String typeName = dataStore.getTypeNames()[0];

        FeatureSource<SimpleFeatureType, SimpleFeature> source =
                dataStore.getFeatureSource(typeName);

        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures();
        try (FeatureIterator<SimpleFeature> features = collection.features()) {
            while (features.hasNext()) {
                SimpleFeature simpleFeature = features.next();
                try {
                    spatialResources.add(featureDecoder.decodeFeatureToSpatialResource(simpleFeature, propertyMapping, CRS.decode(crsOpt.get())));
                } catch (DecodingException ex) {
                    LOG.error(String.format("Decoding failed for feature %s", simpleFeature.getID()));
                    LOG.debug(String.format("Failed feature decoding attributes: %s", simpleFeature.getAttributes()));
                    featureDecoder.addMonitoringMessage(propertyMapping.getIdentifierProperty(), simpleFeature, ex.getMessage());
                } catch (Exception ex) {
                    throw new ImportParameterException(String.format("Invalid CRS parameter '%s'.", crsOpt.get()), ex);
                }finally {
					tmpFile.toFile().delete();
				}
            }
        }

        return spatialResources;
    }
    
    public Path storeDatasetAsTempFile(InputStream dataset) throws IOException {
    	// create tmp file where content will be stored
    	Path tmpFilePath = Files.createTempFile("tmp_geopackage_import_", ".gpkg");
        FileUtils.copyInputStreamToFile(dataset, tmpFilePath.toFile());
        return tmpFilePath;
    }

    @Override
    public List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition,
                                                  Dataset dataset,
                                                  IndicatorPropertyMappingType propertyMapping)
            throws ConverterException, ImportParameterException {
        InputStream input = getInputStream(converterDefinition, dataset);
        try {
            return convertIndicators(input, propertyMapping);
        } catch (IOException ex) {
            throw new ConverterException("Error while parsing dataset.", ex);
        }
    }

    private List<IndicatorValue> convertIndicators(InputStream dataset,
                                                   IndicatorPropertyMappingType propertyMapping)
            throws IOException {
        List<IndicatorValue> indicatorValueList = new ArrayList<>();

        // UNZIP file
        Path tmpFile = storeDatasetAsTempFile(dataset);

        Map<String, Object> params = new HashMap();
        params.put("dbtype", "geopkg");
        params.put("database", tmpFile.toString());
        params.put("read-only", true);

        DataStore dataStore = DataStoreFinder.getDataStore(params);
        String typeName = dataStore.getTypeNames()[0];

        FeatureSource<SimpleFeatureType, SimpleFeature> source =
                dataStore.getFeatureSource(typeName);

        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures();
      
        try (FeatureIterator<SimpleFeature> features = collection.features()) {
            while (features.hasNext()) {
                SimpleFeature simpleFeature = features.next();
                try {
                    indicatorValueList.add(featureDecoder.decodeFeatureToIndicatorValue(simpleFeature, propertyMapping));
                    // Due to the GeoTools decoding issues, the grouping of Features with same ID but different timestamps
                    // can't be performed by the FeatureDecoder. Therefore, the grouping has to be done for IndicatorValues
                    // in the following.
                    if (propertyMapping.getTimeseriesMappings().size() == 1) {
                        indicatorValueList = groupIndicatorValues(indicatorValueList);
                    }
                } catch (DecodingException ex) {
                    LOG.error(String.format("Decoding failed for feature %s", simpleFeature.getID()));
                    LOG.debug(String.format("Failed feature decoding attributes: %s", simpleFeature.getAttributes()));
                    featureDecoder.addMonitoringMessage(propertyMapping.getSpatialReferenceKeyProperty(), simpleFeature, ex.getMessage());
                }finally {
					tmpFile.toFile().delete();
				}
            }
        }

        return indicatorValueList;
    }

    /**
     * Groups a List of {@link IndicatorValue} based on common reference key values.
     * The list to group contains several IndicatorValues with the same reference key but different TimeSeriesValues.
     *
     * @param indicatorValueList List of {@link IndicatorValue} that should be grouped
     * @return List of grouped {@link IndicatorValue}
     */
    protected List<IndicatorValue> groupIndicatorValues(List<IndicatorValue> indicatorValueList) {
        Map<String, IndicatorValue> values = new HashMap<>();
        indicatorValueList.forEach(v -> {
            if (values.containsKey(v.getSpatialReferenceKey())) {
                values.get(v.getSpatialReferenceKey()).getTimeSeriesValueList().addAll(v.getTimeSeriesValueList());
            } else {
                values.put(v.getSpatialReferenceKey(), v);
            }
        });
        return new ArrayList<>(values.values());
    }

    private ConverterParameter createCrsParameter() {
        return new ConverterParameter(PARAM_CRS, PARAM_CRS_DESC, ConverterParameter.ParameterTypeValues.STRING, true);
    }

}

package org.n52.kommonitor.importer.converter;

import org.apache.commons.io.FileUtils;
import org.geotools.api.data.DataStore;
import org.geotools.api.data.DataStoreFinder;
import org.geotools.api.data.FeatureSource;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.feature.FeatureCollection;
import org.geotools.referencing.CRS;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.DataSourceType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.geotools.api.feature.simple.SimpleFeature;
import org.geotools.api.feature.simple.SimpleFeatureType;
import org.geotools.api.referencing.FactoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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
    private static final String PARAM_LAYER_ = "Layer";
    private static final String PARAM_LAYER_DESC = "Angabe des Geopackage Layers, der SpatialUnits und/oder Indikatoren enthält";
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
    public String getDefaultEncoding() {
        return DEFAULT_ENCODING;
    }

    @Override
    public Set<String> initSupportedDatasources() {
        Set<String> types = new HashSet<>();
        types.add(DataSourceType.TypeEnum.FILE.getValue());
        types.add(DataSourceType.TypeEnum.HTTP.getValue());
        types.add(DataSourceType.TypeEnum.FTP.getValue());
        return types;
    }

    @Override
    public Set<ConverterParameter> initConverterParameters() {
        Set<ConverterParameter> params = new HashSet<>();
        params.add(createCrsParameter());
        params.add(createLayerParameter());

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

        List<SpatialResource> spatialResources;
        // Store temp file file
        Path tmpFile = storeDatasetAsTempFile(dataset);
        LOG.debug("Stored Geopackage dataset temporarily under {}", tmpFile.toFile().getPath());

        try {
            FeatureCollection<SimpleFeatureType, SimpleFeature> collection = readFeatureCollection(tmpFile, converterDefinition);
            spatialResources = featureDecoder.decodeFeatureCollectionToSpatialResources((SimpleFeatureCollection) collection, propertyMapping, CRS.decode(crsOpt.get()));
        } catch (FactoryException ex) {
            throw new ImportParameterException(String.format("Invalid CRS parameter '%s'.", crsOpt.get()), ex);
        } finally {
            boolean deleted = tmpFile.toFile().delete();
            if(deleted)
                LOG.debug("Temp file {} successfully deleted.", tmpFile.toFile().getPath());
            else
                LOG.warn("Temp file {} could not be deleted.", tmpFile.toFile().getPath());
        }
        return spatialResources;
    }

    @Override
    public List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition,
                                                  Dataset dataset,
                                                  IndicatorPropertyMappingType propertyMapping)
            throws ConverterException, ImportParameterException {
        InputStream input = getInputStream(converterDefinition, dataset);
        try {
            return convertIndicators(input, converterDefinition, propertyMapping);
        } catch (IOException ex) {
            throw new ConverterException("Error while parsing dataset.", ex);
        }
    }

    private Path storeDatasetAsTempFile(InputStream dataset) throws IOException {
        // create tmp file where content will be stored
        Path tmpFilePath = Files.createTempFile("tmp_geopackage_import_", ".gpkg");
        FileUtils.copyInputStreamToFile(dataset, tmpFilePath.toFile());
        return tmpFilePath;
    }

    private List<IndicatorValue> convertIndicators(InputStream dataset,
                                                   ConverterDefinitionType converterDefinition,
                                                   IndicatorPropertyMappingType propertyMapping)
            throws IOException, ImportParameterException {
        // Store temp file
        Path tmpFile = storeDatasetAsTempFile(dataset);
        LOG.debug("Stored Geopackage dataset temporarily under {}", tmpFile.toFile().getPath());

        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = readFeatureCollection(tmpFile, converterDefinition);

        List<IndicatorValue> indicatorValueList = featureDecoder.decodeFeatureCollectionToIndicatorValues((SimpleFeatureCollection) collection, propertyMapping);

        // Due to the GeoTools decoding issues, the grouping of Features with same ID but different timestamps
        // can't be performed by the FeatureDecoder. Therefore, the grouping has to be done for IndicatorValues
        // in the following.
        if (propertyMapping.getTimeseriesMappings().size() == 1) {
            indicatorValueList = groupIndicatorValues(indicatorValueList);
        }
        boolean deleted = tmpFile.toFile().delete();
        if(deleted)
            LOG.debug("Temp file {} successfully deleted.", tmpFile.toFile().getPath());
        else
            LOG.warn("Temp file {} could not be deleted.", tmpFile.toFile().getPath());
        return indicatorValueList;
    }

    private FeatureCollection<SimpleFeatureType, SimpleFeature> readFeatureCollection(Path tmpFile, ConverterDefinitionType converterDefinition)
            throws IOException, ImportParameterException {

        Optional<String> layerOpt = this.getParameterValue(PARAM_LAYER_, converterDefinition.getParameters());

        Map<String, Object> params = new HashMap();
        params.put("dbtype", "geopkg");
        params.put("database", tmpFile.toString());
        params.put("read-only", true);

        DataStore dataStore = DataStoreFinder.getDataStore(params);
        if (dataStore == null) {
            throw new IOException("Error while reading Geopackage data source.");
        }

        // Check if the layer parameter is set. If so, check if the layer is present within the Geopackage.
        // Otherwise, use the first layer name of the Geopackage.
        String typeName = dataStore.getTypeNames()[0];
        if (layerOpt.isPresent()){
            if (Arrays.stream(dataStore.getTypeNames()).anyMatch(t -> t.equals(layerOpt.get()))){
                typeName = layerOpt.get();
            }
            else {
                throw new ImportParameterException(String.format("Layer with name %s is not present in Geopackage.", layerOpt.get()));
            }
        }
        LOG.debug("Use Geopackage layer {} for fetching Features.", typeName);

        FeatureSource<SimpleFeatureType, SimpleFeature> source =
                dataStore.getFeatureSource(typeName);

        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures();
        return collection;
    }

    private ConverterParameter createCrsParameter() {
        return new ConverterParameter(PARAM_CRS, PARAM_CRS_DESC, ConverterParameter.ParameterTypeValues.STRING, true);
    }

    private ConverterParameter createLayerParameter() {
        return new ConverterParameter(PARAM_LAYER_, PARAM_LAYER_DESC, ConverterParameter.ParameterTypeValues.STRING, false);
    }

    }

package org.n52.kommonitor.importer.converter;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Converter for GeoJson datasets. Parses a GeoJson document as {@link org.geotools.feature.FeatureCollection}
 * and converts it into KomMonitor resources.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class ShapeConverter extends AbstractConverter {
    private static final String NAME = "Shapefile (ZIP-Ordner mit .shp, .dbf, .prj)";
    private static final String DEFAULT_ENCODING = "ISO-8859-1";
    private static final String UTF8_ENCODING = "UTF-8";
    private static final String OTHER_ENCODING = "Other";
    private static final String PARAM_CRS = "CRS";
    private static final String PARAM_CRS_DESC = "Angabe des Koordinatenreferenzsystems als EPSG-Code (z.B. EPSG:4326)";

    private FeatureDecoder featureDecoder;

    @Autowired
    public ShapeConverter(FeatureDecoder featureDecoder) {
        this.featureDecoder = featureDecoder;
    }

    @Override
    public String initName() {
        return NAME;
    }

    @Override
    public Set<String> initSupportedMimeType() {
        Set<String> mimeTypes = new HashSet<>();
        mimeTypes.add("application/zip");
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
        encodings.add(UTF8_ENCODING);
        encodings.add(OTHER_ENCODING);

        return encodings;
    }

    @Override
    public Set<ConverterParameter> initConverterParameters() {
        Set<ConverterParameter> params = new HashSet<>();
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

        // UNZIP file
        Path tmpDir = unzipFolder(dataset);

        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = readFeatureCollection(tmpDir, converterDefinition, dataset);

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
                } finally {
                    boolean deleted = tmpDir.toFile().delete();
                    if (deleted)
                        LOG.debug("Temp file {} successfully deleted.", tmpDir.toFile().getPath());
                    else
                        LOG.warn("Temp file {} could not be deleted.", tmpDir.toFile().getPath());
                }
            }
        }
        return spatialResources;
    }

    private String extractEncoding(File file) throws IOException {
        if (file.exists()) {
            try (Stream<String> s = Files.lines(file.toPath())) {
                Optional<String> encodingOpt = s.findFirst();
                return encodingOpt.orElse(null);
            }
        } else {
            return null;
        }
    }

    public Path unzipFolder(InputStream dataset) throws IOException {

        // create tmp folder where content will be stored
        Path newTmpDirPath = Files.createTempDirectory("tmpDirShapeImport_");

        try (ZipInputStream zis = new ZipInputStream(dataset)) {

            // list files in zip
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {
                Path newPath = zipSlipProtect(zipEntry, newTmpDirPath);
                // copy files, nio
                Files.copy(zis, newPath, StandardCopyOption.REPLACE_EXISTING);

                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();

            // rename file to input.*
            File dir = newTmpDirPath.toFile();

            if (dir.isDirectory()) { // make sure it's a directory
                for (final File f : dir.listFiles()) {

                    if (f.getAbsolutePath().endsWith(".shp")) {
                        Files.move(f.toPath(), new File(f.toPath().getParent() + "/input.shp").toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } else if (f.getAbsolutePath().endsWith(".prj")) {
                        Files.move(f.toPath(), new File(f.toPath().getParent() + "/input.prj").toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } else if (f.getAbsolutePath().endsWith(".dbf")) {
                        Files.move(f.toPath(), new File(f.toPath().getParent() + "/input.dbf").toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } else if (f.getAbsolutePath().endsWith(".cpg")) {
                        Files.move(f.toPath(), new File(f.toPath().getParent() + "/input.cpg").toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } else if (f.getAbsolutePath().endsWith(".shx")) {
                        Files.move(f.toPath(), new File(f.toPath().getParent() + "/input.shx").toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }

        } catch (IOException e) {
            String errorMessage = "Exception while trying to unzip and store Shape ZIP content to disk. Error is: " + e.getMessage();
            LOG.error(String.format(errorMessage));
            boolean deleted = newTmpDirPath.toFile().delete();
            if (deleted)
                LOG.debug("Temp file {} successfully deleted.", newTmpDirPath.toFile().getPath());
            else
                LOG.warn("Temp file {} could not be deleted.", newTmpDirPath.toFile().getPath());
            throw new Error(errorMessage);
        }
        return newTmpDirPath;

    }

    // protect zip slip attack
    public Path zipSlipProtect(ZipEntry zipEntry, Path targetDir)
            throws IOException {

        // test zip slip vulnerability
        // Path targetDirResolved = targetDir.resolve("../../" + zipEntry.getName());

        Path targetDirResolved = targetDir.resolve(zipEntry.getName());

        // make sure normalized file still has targetDir as its prefix
        // else throws exception
        Path normalizePath = targetDirResolved.normalize();
        if (!normalizePath.startsWith(targetDir)) {
            throw new IOException("Bad zip entry: " + zipEntry.getName());
        }

        return normalizePath;
    }

    @Override
    public List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition,
                                                  Dataset dataset,
                                                  IndicatorPropertyMappingType propertyMapping)
            throws ConverterException, ImportParameterException {
        InputStream input = getInputStream(converterDefinition, dataset);
        try {
            return convertIndicators(converterDefinition, input, propertyMapping);
        } catch (IOException ex) {
            throw new ConverterException("Error while parsing dataset.", ex);
        }
    }

    private List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition,
                                                   InputStream dataset,
                                                   IndicatorPropertyMappingType propertyMapping)
            throws IOException {
        List<IndicatorValue> indicatorValueList = new ArrayList<>();

        // UNZIP file
        Path tmpDir = unzipFolder(dataset);

        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = readFeatureCollection(tmpDir, converterDefinition, dataset);

        try (FeatureIterator<SimpleFeature> features = collection.features()) {
            while (features.hasNext()) {
                SimpleFeature simpleFeature = features.next();
                try {
                    indicatorValueList.add(featureDecoder.decodeFeatureToIndicatorValue(simpleFeature, propertyMapping));
                } catch (DecodingException ex) {
                    LOG.error(String.format("Decoding failed for feature %s", simpleFeature.getID()));
                    LOG.debug(String.format("Failed feature decoding attributes: %s", simpleFeature.getAttributes()));
                    featureDecoder.addMonitoringMessage(propertyMapping.getSpatialReferenceKeyProperty(), simpleFeature, ex.getMessage());
                } finally {
                    boolean deleted = tmpDir.toFile().delete();
                    if (deleted)
                        LOG.debug("Temp file {} successfully deleted.", tmpDir.toFile().getPath());
                    else
                        LOG.warn("Temp file {} could not be deleted.", tmpDir.toFile().getPath());
                }
            }
        }
        // Due to the GeoTools decoding issues, the grouping of Features with same ID but different timestamps
        // can't be performed by the FeatureDecoder. Therefore, the grouping has to be done for IndicatorValues
        // in the following.
        if (propertyMapping.getTimeseriesMappings().size() == 1) {
            indicatorValueList = groupIndicatorValues(indicatorValueList);
        }

        return indicatorValueList;
    }

    private FeatureCollection<SimpleFeatureType, SimpleFeature> readFeatureCollection(Path tmpDir,
                                                                                      ConverterDefinitionType converterDefinition,
                                                                                      InputStream dataset) throws IOException {

            String encoding = DEFAULT_ENCODING;
            if (converterDefinition.getEncoding().equals(OTHER_ENCODING)) {
                String shpEncoding = extractEncoding(new File(tmpDir + "/input.cpg"));
                if (shpEncoding != null && !shpEncoding.isEmpty()) {
                    encoding = shpEncoding;
                }
            } else {
                encoding = converterDefinition.getEncoding();
            }

            File file = new File(tmpDir + "/input.shp");
            Map<String, Object> map = new HashMap<>();
            map.put("url", file.toURI().toURL());
            map.put("charset", encoding);

            DataStore dataStore = DataStoreFinder.getDataStore(map);
            String typeName = dataStore.getTypeNames()[0];

            FeatureSource<SimpleFeatureType, SimpleFeature> source =
                    dataStore.getFeatureSource(typeName);

            return source.getFeatures();
    }

    private ConverterParameter createCrsParameter() {
        return new ConverterParameter(PARAM_CRS, PARAM_CRS_DESC, ConverterParameter.ParameterTypeValues.STRING, true);
    }

}

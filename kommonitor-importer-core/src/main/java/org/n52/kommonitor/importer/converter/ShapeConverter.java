package org.n52.kommonitor.importer.converter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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

/**
 * Converter for GeoJson datasets. Parses a GeoJson document as {@link org.geotools.feature.FeatureCollection}
 * and converts it into KomMonitor resources.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class ShapeConverter extends AbstractConverter {
    private static final String NAME = "Shapefile (ZIP-Ordner mit .shp, .dbf, .prj)";
    private static final String DEFAULT_ENCODING = "UTF-8";
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

        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_CRS);
        }

        List<SpatialResource> spatialResources = new ArrayList<>();
        
        
        // UNZIP file
        Path tmpDir = unzipFolder(dataset);
        
        File file = new File(tmpDir + "/input.shp");
        Map<String, Object> map = new HashMap<>();
        map.put("url", file.toURI().toURL());

        DataStore dataStore = DataStoreFinder.getDataStore(map);
        String typeName = dataStore.getTypeNames()[0];

        FeatureSource<SimpleFeatureType, SimpleFeature> source =
                dataStore.getFeatureSource(typeName);
        Filter filter = Filter.INCLUDE; // ECQL.toFilter("BBOX(THE_GEOM, 10,20,30,40)")

        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(filter);
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
					tmpDir.toFile().delete();
				}
            }
        }

        return spatialResources;
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

                    // copy files, classic
                    /*try (FileOutputStream fos = new FileOutputStream(newPath.toFile())) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }*/
                

                zipEntry = zis.getNextEntry();

            }
            zis.closeEntry();
            
            // rename file to input.*
            
            File dir = newTmpDirPath.toFile();

            if (dir.isDirectory()) { // make sure it's a directory
                for (final File f : dir.listFiles()) {
                    try {
                    	
                    	if(f.getAbsolutePath().endsWith(".shp")) {
                    		Files.move(f.toPath(), new File(f.toPath().getParent() + "/input.shp").toPath(), StandardCopyOption.REPLACE_EXISTING);
                    	}
                    	else if(f.getAbsolutePath().endsWith(".prj")) {
                    		Files.move(f.toPath(), new File(f.toPath().getParent() + "/input.prj").toPath(), StandardCopyOption.REPLACE_EXISTING);
                    	}
                    	else if(f.getAbsolutePath().endsWith(".dbf")) {
                    		Files.move(f.toPath(), new File(f.toPath().getParent() + "/input.dbf").toPath(), StandardCopyOption.REPLACE_EXISTING);
                    	}
                    	
                    	
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                        newTmpDirPath.toFile().delete();
                        throw e;
                    }
                }
               }

        } catch (Exception e) {
        	e.printStackTrace();
        	LOG.error(String.format("Exception while trying to unzip and store Shape ZIP content to disk. Error is: " + e.getMessage() + ""));
        	newTmpDirPath.toFile().delete();
			throw new Error("Exception while trying to unzip and store Shape ZIP content to disk. Error is: " + e.getMessage());		
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
        Path tmpDir = unzipFolder(dataset);
        
        File file = new File(tmpDir + "/input.shp");
        Map<String, Object> map = new HashMap<>();
        map.put("url", file.toURI().toURL());

        DataStore dataStore = DataStoreFinder.getDataStore(map);
        String typeName = dataStore.getTypeNames()[0];

        FeatureSource<SimpleFeatureType, SimpleFeature> source =
                dataStore.getFeatureSource(typeName);
        Filter filter = Filter.INCLUDE; // ECQL.toFilter("BBOX(THE_GEOM, 10,20,30,40)")

        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(filter);
      
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
					tmpDir.toFile().delete();
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

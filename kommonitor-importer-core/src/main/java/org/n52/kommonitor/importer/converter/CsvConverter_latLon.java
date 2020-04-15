package org.n52.kommonitor.importer.converter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.csv.CSVDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.FeatureCollection;
import org.geotools.referencing.CRS;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.FactoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CsvConverter_latLon extends AbstractConverter {
	
	private static final String NAME = "org.n52.kommonitor.importer.converter.csvLatLon";
    private static final String PARAM_SEP = "separator";
    private static final String PARAM_SEP_DESC = "The separator of the CSV dataset";
    private static final String PARAM_X_COORD_COL = "xCoordColumn";
    private static final String PARAM_X_COORD_DESC = "The column that contains the X-coordinate";
    private static final String PARAM_Y_COORD_COL = "yCoordColumn";
    private static final String PARAM_Y_COORD_DESC = "The column that contains the Y-coordinate";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String PARAM_CRS = "CRS";
    private static final String PARAM_CRS_DESC = "Code of the coordinate reference system of the input dataset (e.g. 'EPSG:4326')";

    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_REPLACE_CHAR = ";";
    private static final String SEPARATOR_REPLACE_CHAR_BACKUP = "|";
    
    private static final String GEOMETRY_ATTRIBUTE_NAME = "location";
    
    private FeatureDecoder featureDecoder;

    @Autowired
    public CsvConverter_latLon(FeatureDecoder featureDecoder) {
        this.featureDecoder = featureDecoder;
    }
    
	@Override
	public List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition, Dataset dataset,
			SpatialResourcePropertyMappingType propertyMapping) throws ConverterException, ImportParameterException {
		
        try {
            return convertSpatialResourcesFromCsv(converterDefinition, dataset, propertyMapping);
        } catch (IOException ex) {
            throw new ConverterException("Error while parsing dataset.", ex);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConverterException("Error while parsing dataset.", e);
		}
	}

	private List<SpatialResource> convertSpatialResourcesFromCsv(ConverterDefinitionType converterDefinition,
			Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) throws Exception {
		Optional<String> sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());
        if (!sepOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_SEP);
        }

        Optional<String> crsOpt = this.getParameterValue(PARAM_CRS, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_CRS);
        }
        
        Optional<String> xCoordOpt = this.getParameterValue(PARAM_X_COORD_COL, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_X_COORD_COL);
        }
        Optional<String> yCoordOpt = this.getParameterValue(PARAM_Y_COORD_COL, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_Y_COORD_COL);
        }

     // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromCSV(converterDefinition, dataset, sepOpt, crsOpt, xCoordOpt, yCoordOpt);
        
        try {
            return featureDecoder.decodeFeatureCollectionToSpatialResources(featureCollection, propertyMapping, CRS.decode(crsOpt.get()));
        } catch (FactoryException ex) {
            throw new ImportParameterException(String.format("Invalid CRS parameter '%s'.", crsOpt.get()), ex);
        }
	}

	private SimpleFeatureCollection retrieveFeatureCollectionFromCSV(ConverterDefinitionType converterDefinition, Dataset dataset, Optional<String> sepOpt,
			Optional<String> crsOpt, Optional<String> xCoordOpt, Optional<String> yCoordOpt) throws Exception {

		Map<String, Serializable> params = new HashMap<String, Serializable>();
		Object data = dataset.getData();
		
		File csvFile;
		
		csvFile = convertDataToFile(converterDefinition, dataset, data);
		
		// replace separator if it is not comma
		if(! SEPARATOR_COMMA.equalsIgnoreCase(sepOpt.get())) {
			csvFile = replaceCSVSeparatorToComma(csvFile, sepOpt);
		}
		
		
		params.put(CSVDataStoreFactory.URL_PARAM.key, csvFile.toURI());
		params.put(CSVDataStoreFactory.FILE_PARAM.key, csvFile);
		params.put(CSVDataStoreFactory.STRATEGYP.key, CSVDataStoreFactory.SPECIFC_STRATEGY);
		// swap coordinate order as CSV store creates a location property with POINT (lat, lng)
		params.put(CSVDataStoreFactory.LATFIELDP.key, xCoordOpt.get());
		params.put(CSVDataStoreFactory.LnGFIELDP.key, yCoordOpt.get());
//		params.put(CSVDataStoreFactory.SEPERATORCHAR.key, sepOpt.get().charAt(0));
		DataStore store = DataStoreFinder.getDataStore(params);		

		String typeName = store.getTypeNames()[0];

		FeatureSource<SimpleFeatureType, SimpleFeature> source =
				store.getFeatureSource(typeName);

		FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures();
		SimpleFeatureCollection simpleFeatureCollection = new DefaultFeatureCollection(collection);
		
		if(simpleFeatureCollection == null || simpleFeatureCollection.size() == 0) {
			throw new ConverterException("No features could be parsed from CSV data input.");
		}
		
		SimpleFeatureIterator features = simpleFeatureCollection.features();
		
		while(features.hasNext()) {
			SimpleFeature next = features.next();
			
			next.setDefaultGeometry(next.getAttribute(GEOMETRY_ATTRIBUTE_NAME));
		}
		
		features.close();
		
		
//		simpleFeatureCollection = enrichWithPointGeometry(simpleFeatureCollection, schema, xCoordOpt, yCoordOpt, crsOpt);
		
		return simpleFeatureCollection;
	}

	private File convertDataToFile(ConverterDefinitionType converterDefinition, Dataset dataset, Object data)
			throws IOException, ConverterException {
		File csvFile;
		if(data instanceof File) {
			csvFile = (File) data;
		}	 
		else if(data instanceof String) {
			// write String to tmpFile first
			String dataString = (String) data;
			Path newTmpFilePath = Files.createTempFile("tmp-CSV-", ".csv");
			Files.write(newTmpFilePath, dataString.getBytes());
			
			csvFile = newTmpFilePath.toFile();
		}
		else {
			InputStream inputStream = getInputStream(converterDefinition, dataset);
			Path newTmpFilePath = Files.createTempFile("tmp-CSV-", ".csv");
			
			java.nio.file.Files.copy(
					inputStream, 
					newTmpFilePath, 
				      StandardCopyOption.REPLACE_EXISTING);
			
			csvFile = newTmpFilePath.toFile();
		}
		return csvFile;
	}

	private File replaceCSVSeparatorToComma(File csvFile, Optional<String> sepOpt) throws IOException {
		try {
			LOG.info("Replacing original separator '{}' from original CSV file with '{}' in order to enforce correct column separation", sepOpt.get(), SEPARATOR_COMMA);
			
			final Path path = Paths.get(csvFile.toURI());
			byte[] buff = Files.readAllBytes(path);
			String s = new String(buff, Charset.defaultCharset());
			// first find occurrences of target replace char
			if (s.contains(SEPARATOR_COMMA)) {
				if (s.contains(SEPARATOR_REPLACE_CHAR)) {
					s.replaceAll(SEPARATOR_COMMA, SEPARATOR_REPLACE_CHAR_BACKUP);
				}
				else {
					s.replaceAll(SEPARATOR_COMMA, SEPARATOR_REPLACE_CHAR);
				}
			}
			
			s = s.replaceAll(sepOpt.get(), SEPARATOR_COMMA);
			Files.write(path, s.getBytes());
            LOG.info("Find and Replace done!!!");
            return csvFile;
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("There was an error while trying to replace specified separator {} from original csv file to enforce usage of comma-separator.", sepOpt.get());
            throw e;
        }
	}

	@Override
	public List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition, Dataset dataset,
			IndicatorPropertyMappingType propertyMapping) throws ConverterException, ImportParameterException {
		try {
            return convertIndicatorsFromCsv(converterDefinition, dataset, propertyMapping);
        } catch (IOException ex) {
            throw new ConverterException("Error while parsing dataset.", ex);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConverterException("Error while parsing dataset.", e);
		}
	}

	private List<IndicatorValue> convertIndicatorsFromCsv(ConverterDefinitionType converterDefinition, Dataset dataset,
			IndicatorPropertyMappingType propertyMapping) throws Exception {
		Optional<String> sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());
        if (!sepOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_SEP);
        }

        Optional<String> crsOpt = this.getParameterValue(PARAM_CRS, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_CRS);
        }
        
        Optional<String> xCoordOpt = this.getParameterValue(PARAM_X_COORD_COL, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_X_COORD_COL);
        }
        Optional<String> yCoordOpt = this.getParameterValue(PARAM_Y_COORD_COL, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_Y_COORD_COL);
        }

     // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromCSV(converterDefinition, dataset, sepOpt, crsOpt, xCoordOpt, yCoordOpt);
        
        try {
            return featureDecoder.decodeFeatureCollectionToIndicatorValues(featureCollection, propertyMapping);
        } catch (IOException ex) {
            throw ex;
        }
	}

	@Override
	public String initName() {
		return NAME;
	}

	@Override
	public Set<String> initSupportedMimeType() {
		Set<String> mimeTypes = new HashSet<>();
        mimeTypes.add("text/csv");
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
        params.add(new ConverterParameter(PARAM_SEP, PARAM_SEP_DESC, ConverterParameter.ParameterTypeValues.STRING));
        params.add(new ConverterParameter(PARAM_CRS, PARAM_CRS_DESC, ConverterParameter.ParameterTypeValues.STRING));
        params.add(new ConverterParameter(PARAM_X_COORD_COL, PARAM_X_COORD_DESC, ConverterParameter.ParameterTypeValues.NUMBER));
        params.add(new ConverterParameter(PARAM_Y_COORD_COL, PARAM_Y_COORD_DESC, ConverterParameter.ParameterTypeValues.NUMBER));
        return params;
	}

}

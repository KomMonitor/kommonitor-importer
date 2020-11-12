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

import org.apache.commons.lang3.NotImplementedException;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.csv.CSVDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.FeatureCollection;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CsvConverter_indicator extends AbstractConverter {
	
	private static final String NAME = "org.n52.kommonitor.importer.converter.csv_onlyIndicator";
    private static final String PARAM_SEP = "separator";
    private static final String PARAM_SEP_DESC = "The separator of the CSV dataset";
    private static final String DEFAULT_ENCODING = "UTF-8";

    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_REPLACE_CHAR = ";";
    private static final String SEPARATOR_REPLACE_CHAR_BACKUP = "|";
    
    private FeatureDecoder featureDecoder;

    @Autowired
    public CsvConverter_indicator(FeatureDecoder featureDecoder) {
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
		throw new NotImplementedException("The import of spatial resources via CSVConverter_indicator is not supported");
	}

	private SimpleFeatureCollection retrieveFeatureCollectionFromCSV(ConverterDefinitionType converterDefinition, Dataset dataset, Optional<String> sepOpt
			) throws Exception {

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
		params.put(CSVDataStoreFactory.STRATEGYP.key, CSVDataStoreFactory.ATTRIBUTES_ONLY_STRATEGY);
		DataStore store = DataStoreFinder.getDataStore(params);		

		String typeName = store.getTypeNames()[0];

		FeatureSource<SimpleFeatureType, SimpleFeature> source =
				store.getFeatureSource(typeName);

		FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures();
		SimpleFeatureCollection simpleFeatureCollection = new DefaultFeatureCollection(collection);
		
		if(simpleFeatureCollection == null || simpleFeatureCollection.size() == 0) {
			throw new ConverterException("No features could be parsed from CSV data input.");
		}
		
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

     // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromCSV(converterDefinition, dataset, sepOpt);
        
        try {
            return featureDecoder.decodeFeatureCollectionToIndicatorValues(featureCollection, propertyMapping);
        } catch (Exception ex) {
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
        params.add(new ConverterParameter(PARAM_SEP, PARAM_SEP_DESC, ConverterParameter.ParameterTypeValues.STRING, true));
        return params;
	}

}

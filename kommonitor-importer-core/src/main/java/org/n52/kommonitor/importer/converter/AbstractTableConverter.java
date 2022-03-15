package org.n52.kommonitor.importer.converter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.csv.CSVDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.locationtech.jts.geom.Point;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.geocoder.model.GeocodingFeatureType;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.springframework.beans.factory.annotation.Value;

/**
 * An abstract converter that encapsulates definitions of supported format types for a converter
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public abstract class AbstractTableConverter extends AbstractConverter {

	protected static final String DEFAULT_ENCODING = "UTF-8";
	protected static final String GEOMETRY_ATTRIBUTE_NAME = "location";
	
	protected static final String SEPARATOR_COMMA = ",";
	protected static final String SEPARATOR_REPLACE_CHAR = ";";
	protected static final String SEPARATOR_REPLACE_CHAR_BACKUP = "|";
	
	@Value("${kommonitor.importer.geocoder-api-url:https://geocoder.fbg-hsbo.de/geocoder}")
    protected String geocoder_baseUrl;
	
	protected FeatureDecoder featureDecoder;
	
	public AbstractTableConverter(FeatureDecoder featureDecoder) {
		this.featureDecoder = featureDecoder;
		
		if(this.geocoder_baseUrl == null) {
			this.geocoder_baseUrl = "https://geocoder.fbg-hsbo.de/geocoder";
		}
	}
	
	@Override
	public Set<String> initSupportedMimeType() {
		Set<String> mimeTypes = new HashSet<>();
        mimeTypes.add("text/csv");
        mimeTypes.add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
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
	
	protected abstract List<SpatialResource> convertSpatialResourcesFromCsv(ConverterDefinitionType converterDefinition,
			Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) throws Exception;

	protected abstract List<IndicatorValue> convertIndicatorsFromCsv(ConverterDefinitionType converterDefinition,
			Dataset dataset, IndicatorPropertyMappingType propertyMapping) throws Exception;

	protected File convertDataToFile(ConverterDefinitionType converterDefinition, Dataset dataset, Object data)
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
	
	protected String encodeValue(String value) throws UnsupportedEncodingException {
	    String encoded = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
	    // return space character as %20
		return encoded.replace("+", "%20");
	}
	
	protected SimpleFeatureType getGeometryEnrichedFeatureTypeBuilder(SimpleFeature feature) {
		SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
		SimpleFeatureType featureType_withoutGeom = feature.getFeatureType();
		
		//set global state
		builder.setName( "kommonitor" );
		builder.setNamespaceURI( "http://www.geotools.org/" );
		builder.setSRS( "EPSG:4326" );
		
		builder.addAll(featureType_withoutGeom.getAttributeDescriptors());
		builder.add(GEOMETRY_ATTRIBUTE_NAME, Point.class );
		builder.setDefaultGeometry(GEOMETRY_ATTRIBUTE_NAME);
		
		return builder.buildFeatureType();
	}
	
	protected @Valid List<GeocodingFeatureType> filterBuildingFeatures(@Valid List<GeocodingFeatureType> features) {
		return features.stream()
			      .filter(feature -> {
			    	  boolean hasHousenumber = feature.getProperties().getHousenumber() != null;
			    	  boolean isCategoryBuilding = feature.getProperties().getCategory() != null && feature.getProperties().getCategory().equalsIgnoreCase("building");
			    	  return hasHousenumber && isCategoryBuilding;
			    	  })
			      .collect(Collectors.toList());
	}
	
	private File replaceCSVSeparatorToComma(File csvFile, Optional<String> sepOpt) throws IOException {
		try {
			LOG.info("Replacing original separator '{}' from original CSV file with '{}' in order to enforce correct column separation", sepOpt.get(), SEPARATOR_COMMA);
			
			final Path path = Paths.get(csvFile.toURI());
			byte[] buff = Files.readAllBytes(path);
			String s = new String(buff, Charset.defaultCharset());
			// first find occurrences of target replace char
			if (s.contains(SEPARATOR_COMMA)) {
				if (s.contains(SEPARATOR_REPLACE_CHAR) && sepOpt.get().equalsIgnoreCase(SEPARATOR_REPLACE_CHAR)) {
					s = s.replaceAll(SEPARATOR_COMMA, SEPARATOR_REPLACE_CHAR_BACKUP);
				}
				else {
					s = s.replaceAll(SEPARATOR_COMMA, SEPARATOR_REPLACE_CHAR);
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
	
	protected SimpleFeatureCollection retrieveFeatureCollectionFromCSV_attributesOnly(ConverterDefinitionType converterDefinition, Dataset dataset, Optional<String> sepOpt) throws Exception {
		
		Object data = dataset.getData();
		
		File csvFile;
		
		csvFile = convertDataToFile(converterDefinition, dataset, data);
		
		// replace separator if it is not comma
		if(! SEPARATOR_COMMA.equalsIgnoreCase(sepOpt.get())) {
			csvFile = replaceCSVSeparatorToComma(csvFile, sepOpt);
		}
		
		
		Map<String, Serializable> params = new HashMap<String, Serializable>();
		
		params.put(CSVDataStoreFactory.URL_PARAM.key, csvFile.toURI());
		params.put(CSVDataStoreFactory.FILE_PARAM.key, csvFile);
		params = setDataStoreParams_attributes(params);
		
		DataStore store = DataStoreFinder.getDataStore(params);		

		String typeName = store.getTypeNames()[0];

		FeatureSource<SimpleFeatureType, SimpleFeature> source =
				store.getFeatureSource(typeName);

		FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures();
		SimpleFeatureCollection simpleFeatureCollection = new DefaultFeatureCollection(collection);
		
		if(simpleFeatureCollection == null || simpleFeatureCollection.size() == 0) {
			throw new ConverterException("No features could be parsed from CSV data input.");
		}		
		
//		SimpleFeatureIterator features = simpleFeatureCollection.features();
//		
//		while(features.hasNext()) {
//			SimpleFeature next = features.next();
//			
//			next.setDefaultGeometry(next.getAttribute(GEOMETRY_ATTRIBUTE_NAME));
//		}
//		
//		features.close();
		
		return simpleFeatureCollection;
	}
	
	protected SimpleFeatureCollection retrieveFeatureCollectionFromCSV_latLon(ConverterDefinitionType converterDefinition,
			Dataset dataset, Optional<String> sepOpt, Optional<String> crsOpt, Optional<String> xCoordOpt,
			Optional<String> yCoordOpt) throws IOException, ConverterException {
		Object data = dataset.getData();
		
		File csvFile;
		
		csvFile = convertDataToFile(converterDefinition, dataset, data);
		
		// replace separator if it is not comma
		if(! SEPARATOR_COMMA.equalsIgnoreCase(sepOpt.get())) {
			csvFile = replaceCSVSeparatorToComma(csvFile, sepOpt);
		}
		
		
		Map<String, Serializable> params = new HashMap<String, Serializable>();
		
		params.put(CSVDataStoreFactory.URL_PARAM.key, csvFile.toURI());
		params.put(CSVDataStoreFactory.FILE_PARAM.key, csvFile);
		params = setDataStoreParams_latLon(params, xCoordOpt, yCoordOpt);
		
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
		
		return simpleFeatureCollection;
	}
	
	private Map<String, Serializable> setDataStoreParams_attributes(Map<String, Serializable> params) {
		// attributes only strategy in order to only parse attributes without geometry
		params.put(CSVDataStoreFactory.STRATEGYP.key, CSVDataStoreFactory.ATTRIBUTES_ONLY_STRATEGY);
		// params.put(CSVDataStoreFactory.SEPERATORCHAR.key, sepOpt.get().charAt(0));
		return params;
	}
	
	private Map<String, Serializable> setDataStoreParams_latLon(Map<String, Serializable> params, Optional<String> xCoordOpt, Optional<String> yCoordOpt) {
		params.put(CSVDataStoreFactory.STRATEGYP.key, CSVDataStoreFactory.SPECIFC_STRATEGY);
		// swap coordinate order as CSV store creates a location property with POINT (lat, lng)
		params.put(CSVDataStoreFactory.LATFIELDP.key, xCoordOpt.get());
		params.put(CSVDataStoreFactory.LnGFIELDP.key, yCoordOpt.get());
//		params.put(CSVDataStoreFactory.SEPERATORCHAR.key, sepOpt.get().charAt(0));
		return params;
	}

}

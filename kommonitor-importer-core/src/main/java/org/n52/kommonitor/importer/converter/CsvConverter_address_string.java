package org.n52.kommonitor.importer.converter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
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
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.referencing.CRS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.geocoder.model.GeocodingFeatureType;
import org.n52.kommonitor.importer.geocoder.model.GeocodingOutputType;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CsvConverter_address_string extends AbstractConverter {
	
	private static final String EPSG_4326 = "EPSG:4326";
	private static final String NAME = "org.n52.kommonitor.importer.converter.csvAddressString";
    private static final String PARAM_SEP = "separator";
    private static final String PARAM_SEP_DESC = "The separator of the CSV dataset";
    private static final String PARAM_ADDRESS_COL = "addressColumn";
    private static final String PARAM_ADDRESS_DESC = "The column that contains the Address information as a single string with arbitrary structure";
    private static final String DEFAULT_ENCODING = "UTF-8";

    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_REPLACE_CHAR = ";";
    private static final String SEPARATOR_REPLACE_CHAR_BACKUP = "|";
    
    private static final String GEOMETRY_ATTRIBUTE_NAME = "geom";
    
    @Value("${kommonitor.importer.geocoder-api-url:https://geocoder.fbg-hsbo.de/geocoder}")
    private String geocoder_baseUrl;
    
    private FeatureDecoder featureDecoder;

    @Autowired
    public CsvConverter_address_string(FeatureDecoder featureDecoder) {
        this.featureDecoder = featureDecoder;
        
        if(this.geocoder_baseUrl == null) {
        	this.geocoder_baseUrl = "https://geocoder.fbg-hsbo.de/geocoder";
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

	private List<SpatialResource> convertSpatialResourcesFromCsv(ConverterDefinitionType converterDefinition,
			Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) throws Exception {
		Optional<String> sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());
        if (!sepOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_SEP);
        }
        
        Optional<String> addressCoordOpt = this.getParameterValue(PARAM_ADDRESS_COL, converterDefinition.getParameters());
        if (!addressCoordOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_ADDRESS_COL);
        }

     // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromCSV(converterDefinition, dataset, sepOpt);
            
        return decodeFeatureCollectionToSpatialResources(featureCollection, propertyMapping, CRS.decode(EPSG_4326), addressCoordOpt);

	}

	private List<SpatialResource> decodeFeatureCollectionToSpatialResources(SimpleFeatureCollection featureCollection,
			SpatialResourcePropertyMappingType propertyMapping, CoordinateReferenceSystem crs, Optional<String> addressCoordOpt) {
		List<SpatialResource> result = new ArrayList<>();
        SimpleFeatureIterator iterator = featureCollection.features();
        
        SimpleFeatureType featureType = null;
        SimpleFeatureBuilder featureBuilder = null;
        while (iterator.hasNext()) {
            SimpleFeature feature = iterator.next();
            if(featureType == null) {
            	featureType = getGeometryEnrichedFeatureTypeBuilder(feature);
            	featureBuilder = new SimpleFeatureBuilder(featureType);
            }
            try {
            	// now get geometry from address string
            	feature = queryGeometryFromAddressString(feature, addressCoordOpt, featureBuilder);
            	
                result.add(featureDecoder.decodeFeatureToSpatialResource(feature, propertyMapping, crs));
            } catch (Exception e) {
                LOG.warn("Could not decode feature {}. Cause: {}.", feature.getID(), e.getMessage());
                featureDecoder.addMonitoringMessage(propertyMapping.getIdentifierProperty(), feature, e.getMessage());
            }
        }
        iterator.close();
        return result;
	}

	private SimpleFeatureType getGeometryEnrichedFeatureTypeBuilder(SimpleFeature feature) {
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

	private SimpleFeatureCollection retrieveFeatureCollectionFromCSV(ConverterDefinitionType converterDefinition, Dataset dataset, Optional<String> sepOpt) throws Exception {

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
		// attributes only strategy in order to only parse attributes without geometry
		params.put(CSVDataStoreFactory.STRATEGYP.key, CSVDataStoreFactory.ATTRIBUTES_ONLY_STRATEGY);
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
		
		return simpleFeatureCollection;
	}

	private SimpleFeature queryGeometryFromAddressString(SimpleFeature feature, Optional<String> addressCoordOpt, SimpleFeatureBuilder featureBuilder) throws Exception {
		
		String addressAsString = (String)feature.getAttribute(addressCoordOpt.get());
		
		if(addressAsString == null) {
			LOG.error("address column does not contain any value for geocoding feature to geometry.");
			throw new Exception("address column does not contain any value for geocoding feature to geometry.");
		}
				
		String geocoderQueryUrl = this.geocoder_baseUrl + "/geocode/query-string?q=" + URLEncoder.encode(addressAsString, StandardCharsets.UTF_8.toString());
		
    	URI uri = URI.create(geocoderQueryUrl);
		
		LOG.info("Querying KomMonitor geocoder service for address with URL: {}", uri);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    GeocodingOutputType geocoderResponse = restTemplate.getForObject(uri, GeocodingOutputType.class);
		
	    @Valid
		List<GeocodingFeatureType> features_geolocated = filterBuildingFeatures(geocoderResponse.getFeatures());
	    int numFeatures = features_geolocated.size();
		if(numFeatures == 0) {
	    	LOG.error("the number of geocoded features was 0. Hence the address {} could not be resolved to a valid geopoint.", addressAsString);
			throw new Exception("the number of geocoded features was 0. Hence the address '" + addressAsString + "' could not be resolved to a valid geopoint.");
	    }
	    else if(numFeatures > 1) {
	    	LOG.error("the number of geocoded features was {}. Hence the address {} was resolved to more than one possible geopoint.", numFeatures, addressAsString);
			throw new Exception("the number of geocoded features was " + numFeatures + ". Hence the address '" + addressAsString + "' could not be resolved to a valid geopoint.");
	    }
	    else {
	    	GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
	        List<Float> feature_geocoded_geometry = features_geolocated.get(0).getGeometry().getCoordinates();
			Coordinate coords = new Coordinate(feature_geocoded_geometry.get(0), feature_geocoded_geometry.get(1));
	        Geometry point = geometryFactory.createPoint(coords);
	        
	        featureBuilder.addAll(feature.getAttributes());
	        featureBuilder.add(point);
	        
	        // make new GeometryDescriptor	  
	    }
	    
		return featureBuilder.buildFeature(null);
	}

	private @Valid List<GeocodingFeatureType> filterBuildingFeatures(@Valid List<GeocodingFeatureType> features) {
		return features.stream()
			      .filter(feature -> {
			    	  boolean hasHousenumber = feature.getProperties().getHousenumber() != null;
			    	  boolean isCategoryBuilding = feature.getProperties().getCategory() != null && feature.getProperties().getCategory().equalsIgnoreCase("building");
			    	  return hasHousenumber && isCategoryBuilding;
			    	  })
			      .collect(Collectors.toList());
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

        Optional<String> addressOpt = this.getParameterValue(PARAM_ADDRESS_COL, converterDefinition.getParameters());

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
	public Set<ConverterParameter> initConverterParameters() {
		Set<ConverterParameter> params = new HashSet();
        params.add(new ConverterParameter(PARAM_SEP, PARAM_SEP_DESC, ConverterParameter.ParameterTypeValues.STRING, true));
        params.add(new ConverterParameter(PARAM_ADDRESS_COL, PARAM_ADDRESS_DESC, ConverterParameter.ParameterTypeValues.STRING, true));
        return params;
	}

}

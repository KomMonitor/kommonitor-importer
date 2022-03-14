package org.n52.kommonitor.importer.converter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
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
public class CsvConverter_address_structured extends AbstractConverter {
	
	private static final String COMMA_URL_ENCODED = "%2C";
	private static final String EPSG_4326 = "EPSG:4326";
	private static final String NAME = "org.n52.kommonitor.importer.converter.csvAddressStructured";
    private static final String PARAM_SEP = "separator";
    private static final String PARAM_SEP_DESC = "The separator of the CSV dataset";
    private static final String PARAM_COUNTRY_COL = "countryColumn";
    private static final String PARAM_COUNTRY_DESC = "The column that contains the Country information";
    private static final String PARAM_STATE_COL = "stateColumn";
    private static final String PARAM_STATE_DESC = "The column that contains the State information";
    private static final String PARAM_CITY_COL = "cityColumn";
    private static final String PARAM_CITY_DESC = "The column that contains the City information";
    private static final String PARAM_DISTRICT_COL = "districtColumn";
    private static final String PARAM_DISTRICT_DESC = "The column that contains the District information";
    private static final String PARAM_STREET_COL = "streetColumn";
    private static final String PARAM_STREET_DESC = "The column that contains the Street information";
    private static final String PARAM_POSTCODE_COL = "postcodeColumn";
    private static final String PARAM_POSTCODE_DESC = "The column that contains the Postcode information";
    private static final String PARAM_HOUSENUMBER_COL = "housenumberColumn";
    private static final String PARAM_HOUSENUMBER_DESC = "The column that contains the Housenumber information";
    private static final String DEFAULT_ENCODING = "UTF-8";

    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_REPLACE_CHAR = ";";
    private static final String SEPARATOR_REPLACE_CHAR_BACKUP = "|";
    
    private static final String GEOMETRY_ATTRIBUTE_NAME = "geom";
    
    @Value("${kommonitor.importer.geocoder-api-url:https://geocoder.fbg-hsbo.de/geocoder}")
    private String geocoder_baseUrl;
    
    private FeatureDecoder featureDecoder;

    @Autowired
    public CsvConverter_address_structured(FeatureDecoder featureDecoder) {
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
        
        Optional<String> countryOpt = this.getParameterValue(PARAM_COUNTRY_COL, converterDefinition.getParameters());
        Optional<String> stateOpt = this.getParameterValue(PARAM_STATE_COL, converterDefinition.getParameters());
        Optional<String> cityOpt = this.getParameterValue(PARAM_CITY_COL, converterDefinition.getParameters());
        Optional<String> districtOpt = this.getParameterValue(PARAM_DISTRICT_COL, converterDefinition.getParameters());
        Optional<String> postcodeOpt = this.getParameterValue(PARAM_POSTCODE_COL, converterDefinition.getParameters());
        Optional<String> streetOpt = this.getParameterValue(PARAM_STREET_COL, converterDefinition.getParameters());
        if (!streetOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_STREET_COL);
        }
        Optional<String> housenumberOpt = this.getParameterValue(PARAM_HOUSENUMBER_COL, converterDefinition.getParameters());
        if (!housenumberOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_HOUSENUMBER_COL);
        }

     // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromCSV(converterDefinition, dataset, sepOpt);
            
        return decodeFeatureCollectionToSpatialResources(featureCollection, propertyMapping, CRS.decode(EPSG_4326), countryOpt,
        		stateOpt, cityOpt, districtOpt, postcodeOpt, streetOpt, housenumberOpt);

	}

	private List<SpatialResource> decodeFeatureCollectionToSpatialResources(SimpleFeatureCollection featureCollection,
			SpatialResourcePropertyMappingType propertyMapping, CoordinateReferenceSystem crs, Optional<String> countryOpt, Optional<String> stateOpt, Optional<String> cityOpt, Optional<String> districtOpt, Optional<String> postcodeOpt, Optional<String> streetOpt, Optional<String> housenumberOpt) {
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
            	feature = queryGeometryFromAddressStructured(feature, featureBuilder, countryOpt, stateOpt, cityOpt, districtOpt, postcodeOpt, streetOpt, housenumberOpt);
            	
                result.add(featureDecoder.decodeFeatureToSpatialResource(feature, propertyMapping, crs));
            } catch (Exception e) {
                LOG.warn("Could not decode feature {}. Cause: {}.", feature.getID(), e.getMessage());
                featureDecoder.addMonitoringMessage(propertyMapping.getIdentifierProperty(), feature, e.getMessage());
            }
        }
        iterator.close();
        return result;
	}
	
	private String encodeValue(String value) throws UnsupportedEncodingException {
	    String encoded = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
	    // return space character as %20
		return encoded.replace("+", "%20");
	}

	private SimpleFeature queryGeometryFromAddressStructured(SimpleFeature feature, SimpleFeatureBuilder featureBuilder,
			Optional<String> countryOpt, Optional<String> stateOpt, Optional<String> cityOpt,
			Optional<String> districtOpt, Optional<String> postcodeOpt, Optional<String> streetOpt,
			Optional<String> housenumberOpt) throws Exception {
		String country = (String)feature.getAttribute(countryOpt.isEmpty() ? null : countryOpt.get());
		String state = (String)feature.getAttribute(stateOpt.isEmpty() ? null : stateOpt.get());
		String city = (String)feature.getAttribute(cityOpt.isEmpty() ? null : cityOpt.get());
		String district = (String)feature.getAttribute(districtOpt.isEmpty() ? null : districtOpt.get());
		String postcode = String.valueOf(feature.getAttribute(postcodeOpt.isEmpty() ? null : postcodeOpt.get()));
		String street = (String)feature.getAttribute(streetOpt.get());
		String housenumber = String.valueOf(feature.getAttribute(housenumberOpt.get()));
		
		if(street == null || housenumber == null) {
			LOG.error("street or housenumber column does not contain any value for geocoding feature to geometry.");
			throw new Exception("street or housenumber column does not contain any value for geocoding feature to geometry.");
		}
		
		String queryString = "street=" + encodeValue(street) + "&housenumber=" + encodeValue(housenumber);
		
		if(postcode != null) {
    		queryString += "&postcode=" + encodeValue(postcode);
    	}
    	if(city != null) {
    		queryString += "&city=" + encodeValue(city);
    	}
    	if(country != null) {
    		queryString += "&country=" + encodeValue(country);
    	}
    	if(state != null) {
    		queryString += "&state=" + encodeValue(state);
    	}
    	if(district != null) {
    		queryString += "&district=" + encodeValue(district);
    	}		
		String geocoderQueryUrl = this.geocoder_baseUrl + "/geocode/query-structured?" + queryString;		
		
    	URI uri = URI.create(geocoderQueryUrl);
    	
		LOG.info("Querying KomMonitor geocoder service for address with URL: {}", uri);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    GeocodingOutputType geocoderResponse = restTemplate.getForObject(uri, GeocodingOutputType.class);
		
	    List<GeocodingFeatureType> features_geolocated = filterBuildingFeatures(geocoderResponse.getFeatures());
	    int numFeatures = features_geolocated.size();
		if(numFeatures == 0) {
	    	LOG.error("the number of geocoded features was 0. Hence the query {} could not be resolved to a valid geopoint.", geocoderQueryUrl);
	    	LOG.info("Will try to query by building a single query string from adress information");
	    	
	    	queryString = "q=" + encodeValue(street) + COMMA_URL_ENCODED + encodeValue(housenumber);
	    	if(postcode != null) {
	    		queryString += COMMA_URL_ENCODED + encodeValue(postcode);
	    	}
	    	if(city != null) {
	    		queryString += COMMA_URL_ENCODED + encodeValue(city);
	    	}
	    	if(country != null) {
	    		queryString += COMMA_URL_ENCODED + encodeValue(country);
	    	}
	    	if(state != null) {
	    		queryString += COMMA_URL_ENCODED + encodeValue(state);
	    	}
	    	if(district != null) {
	    		queryString += COMMA_URL_ENCODED + encodeValue(district);
	    	}
	    	String geocoderQueryUrl_singleString = this.geocoder_baseUrl + "/geocode/query-string?" + queryString;					
	    	
	    	uri = URI.create(geocoderQueryUrl_singleString);
			
			LOG.info("Querying KomMonitor geocoder service for address with URL: {}", uri);			
		    
		    geocoderResponse = restTemplate.getForObject(uri, GeocodingOutputType.class);
		    features_geolocated = filterBuildingFeatures(geocoderResponse.getFeatures());
		    numFeatures = features_geolocated.size();
		    
		    if(numFeatures == 0) {
		    	throw new Exception("the number of geocoded features was 0. Hence neither the query '" + geocoderQueryUrl + "' nor '" + geocoderQueryUrl_singleString + "' could not be resolved to a valid geopoint.");
		    }			
	    }
	    else if(numFeatures > 1) {
	    	LOG.error("the number of geocoded features was {}. Hence the query {} was resolved to more than one possible geopoint.", numFeatures, geocoderQueryUrl);
			throw new Exception("the number of geocoded features was " + numFeatures + ". Hence the query '" + geocoderQueryUrl + "' could not be resolved to a valid geopoint.");
	    }
	    
		// if code reaches this place, then feature can be built
	    	GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
	        List<Float> feature_geocoded_geometry = features_geolocated.get(0).getGeometry().getCoordinates();
			Coordinate coords = new Coordinate(feature_geocoded_geometry.get(0), feature_geocoded_geometry.get(1));
	        Geometry point = geometryFactory.createPoint(coords);
	        
	        featureBuilder.addAll(feature.getAttributes());
	        featureBuilder.add(point);
	        
	        // make new GeometryDescriptor	  
	    
	    
		return featureBuilder.buildFeature(null);
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
        params.add(new ConverterParameter(PARAM_STREET_COL, PARAM_STREET_DESC, ConverterParameter.ParameterTypeValues.STRING, true));
        params.add(new ConverterParameter(PARAM_HOUSENUMBER_COL, PARAM_HOUSENUMBER_DESC, ConverterParameter.ParameterTypeValues.NUMBER, true));
        params.add(new ConverterParameter(PARAM_COUNTRY_COL, PARAM_COUNTRY_DESC, ConverterParameter.ParameterTypeValues.STRING, false));
        params.add(new ConverterParameter(PARAM_STATE_COL, PARAM_STATE_DESC, ConverterParameter.ParameterTypeValues.STRING, false));
        params.add(new ConverterParameter(PARAM_CITY_COL, PARAM_CITY_DESC, ConverterParameter.ParameterTypeValues.STRING, false));
        params.add(new ConverterParameter(PARAM_DISTRICT_COL, PARAM_DISTRICT_DESC, ConverterParameter.ParameterTypeValues.STRING, false));
        params.add(new ConverterParameter(PARAM_POSTCODE_COL, PARAM_POSTCODE_DESC, ConverterParameter.ParameterTypeValues.NUMBER, false));        
        return params;
	}

}

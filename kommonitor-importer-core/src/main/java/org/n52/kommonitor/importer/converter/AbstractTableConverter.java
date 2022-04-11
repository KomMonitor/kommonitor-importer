package org.n52.kommonitor.importer.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Hex;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.n52.kommonitor.importer.geocoder.model.GeocodingStructuredBatchInputType;
import org.n52.kommonitor.importer.utils.FileUtils;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.ParameterValueType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * An abstract converter that encapsulates definitions of supported format types for a converter
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public abstract class AbstractTableConverter extends AbstractConverter {

	protected static final String COMMA_URL_ENCODED = "%2C";
//	private static final String MIME_EXCEL = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	private static final String MIME_EXCEL = "application/excel-spreadsheet";
	private static final String MIME_CSV = "text/csv";
	protected static final String DEFAULT_ENCODING = "UTF-8";
	protected static final String GEOMETRY_ATTRIBUTE_NAME = "location";
	
	protected static final String SEPARATOR_COMMA = ",";
//	protected static final String SEPARATOR_REPLACE_CHAR = ";";
//	protected static final String SEPARATOR_REPLACE_CHAR_BACKUP = "|";
	
	protected static final String PARAM_SEP = "Trennzeichen";
	protected static final String PARAM_SEP_DESC = "Trennzeichensymbol des CSV Datensatzes - nur bei CSV anzugeben";
	
	@Value("${kommonitor.importer.geocoder-api-url:https://geocoder.fbg-hsbo.de/geocoder}")
    protected String geocoder_baseUrl;
	
	protected FeatureDecoder featureDecoder;
	
	protected Set<ConverterParameter> params;
	
	public AbstractTableConverter(FeatureDecoder featureDecoder) {
		this.featureDecoder = featureDecoder;
		
		this.params = new HashSet<ConverterParameter>();
		this.params.add(new ConverterParameter(PARAM_SEP, PARAM_SEP_DESC, ConverterParameter.ParameterTypeValues.STRING, false));
		
		if(this.geocoder_baseUrl == null) {
			this.geocoder_baseUrl = "https://geocoder.fbg-hsbo.de/geocoder";
		}
	}
	
	@Override
	public Set<String> initSupportedMimeType() {
		Set<String> mimeTypes = new HashSet<>();
        mimeTypes.add(MIME_CSV);
        mimeTypes.add(MIME_EXCEL);
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
            return convertIndicatorsFromTable(converterDefinition, dataset, propertyMapping);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConverterException("Error while parsing dataset. Error message: " + e.getMessage(), e);
		}
	}
	
	@Override
	public List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition, Dataset dataset,
			SpatialResourcePropertyMappingType propertyMapping) throws ConverterException, ImportParameterException {
		
        try {
            return convertSpatialResourcesFromTable(converterDefinition, dataset, propertyMapping);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConverterException("Error while parsing dataset. Error message: " + e.getMessage(), e);
		}
	}
	
	protected abstract List<SpatialResource> convertSpatialResourcesFromTable(ConverterDefinitionType converterDefinition,
			Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) throws Exception;

	protected abstract List<IndicatorValue> convertIndicatorsFromTable(ConverterDefinitionType converterDefinition,
			Dataset dataset, IndicatorPropertyMappingType propertyMapping) throws Exception;

	protected File convertDataToFile(ConverterDefinitionType converterDefinition, Dataset dataset, Object data)
			throws IOException, ConverterException {
		
		
//		if(data instanceof File) {
//			csvFile = (File) data;
//		}	 
//		else if(data instanceof String) {
//			// write String to tmpFile first
//			String dataString = (String) data;
//			Path newTmpFilePath = Files.createTempFile("tmp-CSV-", ".csv");
//			Files.write(newTmpFilePath, dataString.getBytes());
//			
//			csvFile = newTmpFilePath.toFile();
//		}
//		else {
		
		File csvFile;
		String fileName = "tmp-CSV-";
		String fileEnding = ".csv";
		if(converterDefinition.getMimeType().equalsIgnoreCase(MIME_EXCEL)) {
			csvFile = convertExcelToCsvFile(converterDefinition, dataset, fileName, fileEnding, SEPARATOR_COMMA);			
			forceSeparatorConverterParameter_asComma(converterDefinition);
		}
		else {
			csvFile = convertToCsvFile(converterDefinition, dataset, fileName, fileEnding);
		}		
//		}
		
		// remove BOM if inlcuded
		removeBom(csvFile.toPath());
		
		return csvFile;
	}

	private void forceSeparatorConverterParameter_asComma(ConverterDefinitionType converterDefinition) {
		List<ParameterValueType> parameters = converterDefinition.getParameters();
		List<ParameterValueType> parameters_new = new ArrayList<ParameterValueType>();
		
		ParameterValueType param_separator = new ParameterValueType();
		param_separator.setName(PARAM_SEP);
		param_separator.setValue(SEPARATOR_COMMA);
		
		for (ParameterValueType parameterValueType : parameters) {
			if (! parameterValueType.getName().equalsIgnoreCase(PARAM_SEP)) {
				parameters_new.add(parameterValueType);
			}
		}
		
		parameters_new.add(param_separator);
		converterDefinition.setParameters(parameters_new);
	}

	private File convertToCsvFile(ConverterDefinitionType converterDefinition, Dataset dataset, String fileName, String fileEnding)
			throws ConverterException, IOException {
		File csvFile;
		InputStream inputStream = getInputStream(converterDefinition, dataset);
		Path newTmpFilePath = Files.createTempFile(fileName, fileEnding);
		
		java.nio.file.Files.copy(
				inputStream, 
				newTmpFilePath, 
			      StandardCopyOption.REPLACE_EXISTING);		
		
		csvFile = newTmpFilePath.toFile();
//		FileUtils.convertFileToUtf8(csvFile, csvFile);
		return csvFile;
	}
	
	static private Pattern rxquote = Pattern.compile("\"");

	static private String encodeExcelValue(String value) {
	    boolean needQuotes = false;
	    if ( value.indexOf(',') != -1 || value.indexOf('"') != -1 ||
	         value.indexOf('\n') != -1 || value.indexOf('\r') != -1 )
	        needQuotes = true;
	    Matcher m = rxquote.matcher(value);
	    if ( m.find() ) needQuotes = true; value = m.replaceAll("\"\"");
	    if ( needQuotes ) return "\"" + value + "\"";
	    else return value;
	}
	
	private File convertExcelToCsvFile(ConverterDefinitionType converterDefinition, Dataset dataset, String fileName, String fileEnding, String csvSeparator) throws ConverterException, IOException {
		InputStream inputStream = getInputStream(converterDefinition, dataset);
		Path newTmpFilePath = Files.createTempFile(fileName, fileEnding);
		File csvFile = newTmpFilePath.toFile();
		
		Workbook wb = new XSSFWorkbook(inputStream);
		int sheetNo = 0;

		DataFormatter formatter = new DataFormatter();
		PrintStream out = new PrintStream(new FileOutputStream(csvFile),
		                                  true, StandardCharsets.UTF_8);
//		byte[] bom = {(byte)0xEF, (byte)0xBB, (byte)0xBF};
//		out.write(bom);
		{
		    Sheet sheet = wb.getSheetAt(sheetNo);
		    for (int r = 0, rn = sheet.getLastRowNum() ; r <= rn ; r++) {
		        Row row = sheet.getRow(r);
		        if ( row == null ) { out.println(csvSeparator); continue; }
		        boolean firstCell = true;
		        for (int c = 0, cn = row.getLastCellNum() ; c < cn ; c++) {
		            Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		            if ( ! firstCell ) out.print(csvSeparator);
		            if ( cell != null ) {
		                String value = formatter.formatCellValue(cell);
		                out.print(encodeExcelValue(value));
		            }
		            firstCell = false;
		        }
		        out.println();
		    }
		}
		out.close();
		wb.close();
		
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
	
	protected SimpleFeatureCollection addGeolocation(SimpleFeatureCollection featureCollection,
			Map<String, GeocodingOutputType> geolocationObjectMap, SpatialResourcePropertyMappingType propertyMapping) {
		DefaultFeatureCollection resultCollection = new DefaultFeatureCollection();
		
		SimpleFeatureIterator iterator = featureCollection.features();
		SimpleFeatureType featureType = null;
        SimpleFeatureBuilder featureBuilder = null;
        while (iterator.hasNext()) {
            SimpleFeature feature = iterator.next();
            if(featureType == null) {
            	featureType = getGeometryEnrichedFeatureTypeBuilder(feature);
            	featureBuilder = new SimpleFeatureBuilder(featureType);
            }
            String featureId = String.valueOf(feature.getAttribute(propertyMapping.getIdentifierProperty()));
			if(geolocationObjectMap.containsKey(featureId)) {        
				List<GeocodingFeatureType> features_geolocated = geolocationObjectMap.get(featureId).getFeatures();
            	int numFeatures = features_geolocated.size();
        		if(numFeatures == 0) {
        	    	LOG.error("the number of geocoded features was 0 for feature with ID '{}'.", featureId);
        	    	featureDecoder.addMonitoringMessage(propertyMapping.getIdentifierProperty(), feature, "the number of geocoded features was 0");
        	    	continue;
        	    }
        	    else if(numFeatures > 1) {
        			LOG.error("the number of geocoded features for the given address information was {} for feature with ID '{}'.", numFeatures, featureId);
        	    	featureDecoder.addMonitoringMessage(propertyMapping.getIdentifierProperty(), feature, "the number of geocoded features for the given address information was " + numFeatures);
        	    	continue;
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
        	    
        		resultCollection.add(featureBuilder.buildFeature(null));
            }        
        }
        iterator.close();
        
        return resultCollection;
	}
	
	protected Map<String, GeocodingOutputType> queryGeolocation_byQueryString(Map<String, String> queryStrings) {
		
		List<String> queryStringList = new ArrayList<String>();
		List<String> featureIdList = new ArrayList<String>();
		
		Set<Entry<String, String>> entrySet = queryStrings.entrySet();
		for (Entry<String, String> entry : entrySet) {
			queryStringList.add(entry.getValue());
			featureIdList.add(entry.getKey());
		}
		
		
		GeocodingOutputType[] geocoderResponseArray = executeQueryByStrings(queryStringList);
	    
	    Map<String, GeocodingOutputType> geocoderResponseMap = new HashMap<String, GeocodingOutputType>();
	    
	    for (int i = 0; i < geocoderResponseArray.length; i++) {
	    	geocoderResponseMap.put(featureIdList.get(i), geocoderResponseArray[i]);
		}
		
	    return filterGeocodingResults(geocoderResponseMap);
	}

	private GeocodingOutputType[] executeQueryByStrings(List<String> queryStringList) {
		String geocoderQueryUrl = this.geocoder_baseUrl + "/geocode/query-string/batch";
		
    	URI uri = URI.create(geocoderQueryUrl);
		
		LOG.info("Querying KomMonitor geocoder service for address with URL: {}", uri);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    GeocodingOutputType[] geocoderResponseArray = restTemplate.postForObject(uri, queryStringList.toArray(), GeocodingOutputType[].class);
		return geocoderResponseArray;
	}
	
	protected Map<String, GeocodingOutputType> queryGeolocation_byStructuredInput(
			Map<String, GeocodingStructuredBatchInputType> queryStructuredInputs) throws UnsupportedEncodingException {
		List<GeocodingStructuredBatchInputType> queryInputList = new ArrayList<GeocodingStructuredBatchInputType>();
		List<String> featureIdList = new ArrayList<String>();
		
		Set<Entry<String, GeocodingStructuredBatchInputType>> entrySet = queryStructuredInputs.entrySet();
		for (Entry<String, GeocodingStructuredBatchInputType> entry : entrySet) {
			queryInputList.add(entry.getValue());
			featureIdList.add(entry.getKey());
		}
		
		
		String geocoderQueryUrl = this.geocoder_baseUrl + "/geocode/query-structured/batch";
		
    	URI uri = URI.create(geocoderQueryUrl);
		
		LOG.info("Querying KomMonitor geocoder service for address with URL: {}", uri);
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    GeocodingOutputType[] geocoderResponseArray = restTemplate.postForObject(uri, queryInputList.toArray(), GeocodingOutputType[].class);
	    
	    Map<String, GeocodingOutputType> geocoderResponseMap = new HashMap<String, GeocodingOutputType>();
	    List<GeocodingStructuredBatchInputType> failedQueryInputList = new ArrayList<GeocodingStructuredBatchInputType>();
	    List<String> failedFeatureIdList = new ArrayList<String>();
	    
	    for (int i = 0; i < geocoderResponseArray.length; i++) {
	    	if(geocoderResponseArray[i].getFeatures().size() == 0) {
	    		// no geolocation was found for the query input
	    		failedQueryInputList.add(queryInputList.get(i));
	    		failedFeatureIdList.add(featureIdList.get(i));
	    	}
	    	else {
	    		geocoderResponseMap.put(featureIdList.get(i), geocoderResponseArray[i]);
	    	}	    	
		}
	    
	    // if any failed input was detected we try to use query-string based geolocation, which is more typo tolerant
	    if(failedQueryInputList.size() > 0) {
	    	geocoderResponseMap = retryFailedQueryInputs_asQueryString(failedQueryInputList, failedFeatureIdList, geocoderResponseMap);
	    }
		
	    return filterGeocodingResults(geocoderResponseMap);
	}
	
	private Map<String, GeocodingOutputType> retryFailedQueryInputs_asQueryString(
			List<GeocodingStructuredBatchInputType> failedQueryInputList,
			List<String> failedFeatureIdList, Map<String, GeocodingOutputType> geocoderResponseMap) throws UnsupportedEncodingException {
		
		List<String> queryStrings = new ArrayList<String>();
		
		for (int i = 0; i < failedFeatureIdList.size(); i++) {
			LOG.error("the number of geocoded features by structured query was 0 for feature with id {}.", failedFeatureIdList.get(i));
	    	LOG.info("Will try to query by building a single query string from adress information");
	    	
	    	GeocodingStructuredBatchInputType failedStructuredInput = failedQueryInputList.get(i);	    	
	    	
//	    	String queryString = "" + encodeValue(failedStructuredInput.getStreet()) + COMMA_URL_ENCODED + encodeValue(failedStructuredInput.getHousenumber());
//	    	if(failedStructuredInput.getPostcode() != null && failedStructuredInput.getPostcode() != "") {
//	    		queryString += COMMA_URL_ENCODED + encodeValue(failedStructuredInput.getPostcode());
//	    	}
//	    	if(failedStructuredInput.getCity() != null && failedStructuredInput.getCity() != "") {
//	    		queryString += COMMA_URL_ENCODED + encodeValue(failedStructuredInput.getCity());
//	    	}
//	    	if(failedStructuredInput.getCountry() != null && failedStructuredInput.getCountry() != "") {
//	    		queryString += COMMA_URL_ENCODED + encodeValue(failedStructuredInput.getCountry());
//	    	}
//	    	if(failedStructuredInput.getState() != null && failedStructuredInput.getState() != "") {
//	    		queryString += COMMA_URL_ENCODED + encodeValue(failedStructuredInput.getState());
//	    	}
//	    	if(failedStructuredInput.getDistrict() != null && failedStructuredInput.getDistrict() != "") {
//	    		queryString += COMMA_URL_ENCODED + encodeValue(failedStructuredInput.getDistrict());
//	    	}
	    	
	    	String queryString = "" + failedStructuredInput.getStreet() + ","  + failedStructuredInput.getHousenumber();
	    	if(failedStructuredInput.getPostcode() != null && failedStructuredInput.getPostcode() != "") {
	    		queryString += "," + failedStructuredInput.getPostcode();
	    	}
	    	if(failedStructuredInput.getCity() != null && failedStructuredInput.getCity() != "") {
	    		queryString += "," + failedStructuredInput.getCity();
	    	}
	    	if(failedStructuredInput.getCountry() != null && failedStructuredInput.getCountry() != "") {
	    		queryString += "," + failedStructuredInput.getCountry();
	    	}
	    	if(failedStructuredInput.getState() != null && failedStructuredInput.getState() != "") {
	    		queryString += "," + failedStructuredInput.getState();
	    	}
	    	if(failedStructuredInput.getDistrict() != null && failedStructuredInput.getDistrict() != "") {
	    		queryString += "," + failedStructuredInput.getDistrict();
	    	}
	    	
	    	queryStrings.add(queryString);
		}
		
		GeocodingOutputType[] geocoderResponseArray = executeQueryByStrings(queryStrings);
		
		for (int i = 0; i < geocoderResponseArray.length; i++) {
	    	geocoderResponseMap.put(failedFeatureIdList.get(i), geocoderResponseArray[i]);
		}

    	return geocoderResponseMap;
	}

	protected List<GeocodingFeatureType> filterBuildingFeatures(@Valid List<GeocodingFeatureType> features) throws Exception {
		features = features.stream()
			      .filter(feature -> {
			    	  boolean hasHousenumber = feature.getProperties().getHousenumber() != null;
//			    	  boolean isAcceptedCategory = isAcceptedCategory(feature.getProperties().getCategory());
//			    	  return hasHousenumber && isAcceptedCategory;
			    	  return hasHousenumber;
			    	  })
			      .collect(Collectors.toList());
		
		// include a check for the actual street name of the results
		// if there are different street names then the geocoding was not resolvable 
		int numDifferentStreetNamesResolved = 1;
		if(features.size() > 0) {
			String firstStreetName = features.get(0).getProperties().getStreet();
			
			for (GeocodingFeatureType geocodingFeature : features) {
				String street = geocodingFeature.getProperties().getStreet();
				if(street != null && ! street.equalsIgnoreCase(firstStreetName) ) {
					numDifferentStreetNamesResolved++;
				}
			}
			if (numDifferentStreetNamesResolved > 1) {
				throw new Exception("geocoding was resolved to " + numDifferentStreetNamesResolved + " different streets. Please check for possible spelling mistakes.");
			}
		}
		
		
		
		
		// filter output to one result only
		List<GeocodingFeatureType> oneItemList = new ArrayList<GeocodingFeatureType>();
		if(features.size() > 0) {
			oneItemList.add(features.get(0));
		}
		
		return oneItemList;
	}
	
	private boolean isAcceptedCategory(String category) {
		boolean isAccepted = category != null && 
				(
					   category.equalsIgnoreCase("building")
					|| category.equalsIgnoreCase("amenity")
				);
		return isAccepted;
	}

	protected Map<String, GeocodingOutputType> filterGeocodingResults(Map<String, GeocodingOutputType> geocoderResponseMap) {
		
		Set<Entry<String, GeocodingOutputType>> geocoderResponseSet = geocoderResponseMap.entrySet();

		for (Entry<String, GeocodingOutputType> entry : geocoderResponseSet) {
			try {
				entry.getValue().setFeatures(filterBuildingFeatures(entry.getValue().getFeatures()));
			} catch (Exception e) {
				LOG.error(e.getMessage());
    	    	featureDecoder.addMonitoringMessage(entry.getKey(), e.getMessage());
			}			
		}
		return geocoderResponseMap;
	}
	
//	private File replaceCSVSeparatorToComma(File csvFile, Optional<String> sepOpt) throws IOException {
//		try {
//			LOG.info("Replacing original separator '{}' from original CSV file with '{}' in order to enforce correct column separation", sepOpt.get(), SEPARATOR_COMMA);
//			
//			final Path path = Paths.get(csvFile.toURI());
//			byte[] buff = Files.readAllBytes(path);
//			String s = new String(buff, FileUtils.getFileEncoding(csvFile));
//			// first find occurrences of target replace char
//			if (s.contains(SEPARATOR_COMMA)) {
//				if (s.contains(SEPARATOR_REPLACE_CHAR) && sepOpt.get().equalsIgnoreCase(SEPARATOR_REPLACE_CHAR)) {
//					s = s.replace(SEPARATOR_COMMA, SEPARATOR_REPLACE_CHAR_BACKUP);
//				}
//				else {
//					s = s.replace(SEPARATOR_COMMA, SEPARATOR_REPLACE_CHAR);
//				}
//			}
//			
//			s = s.replace(sepOpt.get(), SEPARATOR_COMMA);
//			Files.write(path, s.getBytes());		
//            
//            LOG.info("Find and Replace done!!!");
//            return csvFile;
//        } catch (IOException e) {
//            e.printStackTrace();
//            LOG.error("There was an error while trying to replace specified separator {} from original csv file to enforce usage of comma-separator.", sepOpt.get());
//            throw e;
//        }
//	}
	
	protected SimpleFeatureCollection retrieveFeatureCollectionFromTable_attributesOnly(ConverterDefinitionType converterDefinition, Dataset dataset, Optional<String> sepOpt) throws Exception {
		
		if(! sepOpt.isPresent()) {
			forceSeparatorConverterParameter_asComma(converterDefinition);
		}
		
		Object data = dataset.getData();
		
		File csvFile;
		
		csvFile = convertDataToFile(converterDefinition, dataset, data);
		
		// replace separator if it is not comma
		// make sure to take the most current seperator definition, as it might have changed due to excel conversion
		sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());
//		if(! SEPARATOR_COMMA.equalsIgnoreCase(sepOpt.get())) {
//			csvFile = replaceCSVSeparatorToComma(csvFile, sepOpt);
//		}
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put(CSVDataStoreFactory.URL_PARAM.key, csvFile.toURI());
		params.put(CSVDataStoreFactory.FILE_PARAM.key, csvFile);
		params.put("separator", sepOpt.get());
		params.put(CSVDataStoreFactory.SEPERATORCHAR.key, String.valueOf(sepOpt.get()).charAt(0));
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
		
		store.dispose();
		csvFile.delete();
		
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
	
	protected SimpleFeatureCollection retrieveFeatureCollectionFromTable_latLon(ConverterDefinitionType converterDefinition,
			Dataset dataset, Optional<String> sepOpt, Optional<String> crsOpt, Optional<String> xCoordOpt,
			Optional<String> yCoordOpt) throws IOException, ConverterException {
		
		if(! sepOpt.isPresent()) {
			forceSeparatorConverterParameter_asComma(converterDefinition);
		}
		
		Object data = dataset.getData();
		
		File csvFile;
		
		csvFile = convertDataToFile(converterDefinition, dataset, data);
		
		// replace separator if it is not comma
//		if(! SEPARATOR_COMMA.equalsIgnoreCase(sepOpt.get())) {
//			csvFile = replaceCSVSeparatorToComma(csvFile, sepOpt);
//		}
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put(CSVDataStoreFactory.URL_PARAM.key, csvFile.toURI());
		params.put(CSVDataStoreFactory.FILE_PARAM.key, csvFile);
		params.put("separator", sepOpt.get());
		params.put(CSVDataStoreFactory.SEPERATORCHAR.key, String.valueOf(sepOpt.get()).charAt(0));
		params = setDataStoreParams_latLon(params, xCoordOpt, yCoordOpt);
//		
//		CSVDataStoreFactory factory = new CSVDataStoreFactory();		
//		DataStore datastore = factory.createNewDataStore(params);
		
		
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
		
		store.dispose();
		csvFile.delete();
		
		return simpleFeatureCollection;
	}
	
	private Map<String, Object> setDataStoreParams_attributes(Map<String, Object> params) {
		// attributes only strategy in order to only parse attributes without geometry
		params.put(CSVDataStoreFactory.STRATEGYP.key, CSVDataStoreFactory.ATTRIBUTES_ONLY_STRATEGY);
		// params.put(CSVDataStoreFactory.SEPERATORCHAR.key, sepOpt.get().charAt(0));
		return params;
	}
	
	private Map<String, Object> setDataStoreParams_latLon(Map<String, Object> params, Optional<String> xCoordOpt, Optional<String> yCoordOpt) {
		params.put(CSVDataStoreFactory.STRATEGYP.key, CSVDataStoreFactory.SPECIFC_STRATEGY);
		params.put(CSVDataStoreFactory.LATFIELDP.key, yCoordOpt.get());
		params.put(CSVDataStoreFactory.LnGFIELDP.key, xCoordOpt.get());
//		params.put(CSVDataStoreFactory.SEPERATORCHAR.key, sepOpt.get().charAt(0));
		return params;
	}
	
	private static boolean isContainBOM(Path path) throws IOException {

	      if (Files.notExists(path)) {
	          throw new IllegalArgumentException("Path: " + path + " does not exists!");
	      }

	      boolean result = false;

	      byte[] bom = new byte[3];
	      try (InputStream is = new FileInputStream(path.toFile())) {

	          // read 3 bytes of a file.
	          is.read(bom);

	          // BOM encoded as ef bb bf
	          String content = new String(Hex.encodeHex(bom));
	          if ("efbbbf".equalsIgnoreCase(content)) {
	              result = true;
	          }

	      }

	      return result;
	  }

	  private static void removeBom(Path path) throws IOException {

	      if (isContainBOM(path)) {

	          byte[] bytes = Files.readAllBytes(path);

	          ByteBuffer bb = ByteBuffer.wrap(bytes);

	          System.out.println("Found BOM!");

	          byte[] bom = new byte[3];
	          // get the first 3 bytes
	          bb.get(bom, 0, bom.length);

	          // remaining
	          byte[] contentAfterFirst3Bytes = new byte[bytes.length - 3];
	          bb.get(contentAfterFirst3Bytes, 0, contentAfterFirst3Bytes.length);

	          System.out.println("Remove the first 3 bytes, and overwrite the file!");

	          // override the same path
	          Files.write(path, contentAfterFirst3Bytes);

	      } else {
	          System.out.println("This file doesn't contains UTF-8 BOM!");
	      }

	  }

}

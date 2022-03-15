package org.n52.kommonitor.importer.converter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import org.n52.kommonitor.models.ParameterValueType;
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

	private static final String MIME_EXCEL = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	private static final String MIME_CSV = "text/csv";
	protected static final String DEFAULT_ENCODING = "UTF-8";
	protected static final String GEOMETRY_ATTRIBUTE_NAME = "location";
	
	protected static final String SEPARATOR_COMMA = ",";
	protected static final String SEPARATOR_REPLACE_CHAR = ";";
	protected static final String SEPARATOR_REPLACE_CHAR_BACKUP = "|";
	
	protected static final String PARAM_SEP = "separator";
	protected static final String PARAM_SEP_DESC = "The separator of a CSV dataset - only required for CSV dataset";
	
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
		File csvFile = newTmpFilePath.toFile();;
		
		Workbook wb = new XSSFWorkbook(inputStream);
		int sheetNo = 0;

		DataFormatter formatter = new DataFormatter();
		PrintStream out = new PrintStream(new FileOutputStream(csvFile),
		                                  true, "UTF-8");
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

package org.n52.kommonitor.importer.converter;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.referencing.CRS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TableConverter_address_structured extends AbstractTableConverter {
	
	private static final String COMMA_URL_ENCODED = "%2C";
	private static final String EPSG_4326 = "EPSG:4326";
	private static final String NAME = "org.n52.kommonitor.importer.converter.table_addressStructuredToGeoresource";
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

    @Autowired
    public TableConverter_address_structured(FeatureDecoder featureDecoder) {
        super(featureDecoder);
    }
    
	@Override
	public List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition, Dataset dataset,
			SpatialResourcePropertyMappingType propertyMapping) throws ConverterException, ImportParameterException {
		
        try {
            return convertSpatialResourcesFromTable(converterDefinition, dataset, propertyMapping);
        } catch (IOException ex) {
            throw new ConverterException("Error while parsing dataset.", ex);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConverterException("Error while parsing dataset.", e);
		}
	}

	protected List<SpatialResource> convertSpatialResourcesFromTable(ConverterDefinitionType converterDefinition,
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
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromTable_attributesOnly(converterDefinition, dataset, sepOpt);
            
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

	protected List<IndicatorValue> convertIndicatorsFromTable(ConverterDefinitionType converterDefinition, Dataset dataset,
			IndicatorPropertyMappingType propertyMapping) throws Exception {
		Optional<String> sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());
        if (!sepOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_SEP);
        }

     // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromTable_attributesOnly(converterDefinition, dataset, sepOpt);
        
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
	public Set<ConverterParameter> initConverterParameters() {
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

package org.n52.kommonitor.importer.converter;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

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
public class TableConverter_address_string extends AbstractTableConverter {
	
	private static final String EPSG_4326 = "EPSG:4326";
	private static final String NAME = "Tabelle_Geokodierung_beliebige_Zeichenkette";    
    private static final String PARAM_ADDRESS_COL = "Adresse_Spaltenname";
    private static final String PARAM_ADDRESS_DESC = "Splate mit gesamter Adressinformation als eine Zeichenkette mit beliebiger Struktur";

    @Autowired
    public TableConverter_address_string(FeatureDecoder featureDecoder) {
    	super(featureDecoder);        
    }
    
	

	protected List<SpatialResource> convertSpatialResourcesFromTable(ConverterDefinitionType converterDefinition,
			Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) throws Exception {
		Optional<String> sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());
        
        Optional<String> addressCoordOpt = this.getParameterValue(PARAM_ADDRESS_COL, converterDefinition.getParameters());
        if (!addressCoordOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_ADDRESS_COL);
        }

     // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromTable_attributesOnly(converterDefinition, dataset, sepOpt);
            
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

	

	private SimpleFeature queryGeometryFromAddressString(SimpleFeature feature, Optional<String> addressCoordOpt, SimpleFeatureBuilder featureBuilder) throws Exception {
		
		String addressAsString = (String)feature.getAttribute(addressCoordOpt.get());
		
		if(addressAsString == null) {
			LOG.error("address column does not contain any value for geocoding feature to geometry.");
			throw new Exception("address column does not contain any value for geocoding feature to geometry.");
		}
				
		String geocoderQueryUrl = this.geocoder_baseUrl + "/geocode/query-string?q=" + encodeValue(addressAsString);
		
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

	

	

	

	

	protected List<IndicatorValue> convertIndicatorsFromTable(ConverterDefinitionType converterDefinition, Dataset dataset,
			IndicatorPropertyMappingType propertyMapping) throws Exception {
		Optional<String> sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());

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
        params.add(new ConverterParameter(PARAM_ADDRESS_COL, PARAM_ADDRESS_DESC, ConverterParameter.ParameterTypeValues.STRING, true));
        return params;
	}

}

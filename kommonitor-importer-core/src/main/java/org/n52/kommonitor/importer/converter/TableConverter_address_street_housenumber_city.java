package org.n52.kommonitor.importer.converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.referencing.CRS;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.geocoder.model.GeocodingOutputType;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableConverter_address_street_housenumber_city extends AbstractTableConverter {
	
	private static final String EPSG_4326 = "EPSG:4326";
	private static final String NAME = "Tabelle_Geokodierung_Strasse_Hausnummer_Stadt";    
    private static final String PARAM_STREET_HOUSENUMBER_COL = "Strasse_Hausnummer_Spaltenname";
    private static final String PARAM_STREET_HOUSENUMBER_DESC = "Spalte mit Strasse und Hausnummer in beliebiger Struktur";
    private static final String PARAM_CITY_COL = "Stadt_Spaltenname";
    private static final String PARAM_CITY_DESC = "Spalte mit Stadtnamen";
    private static final String PARAM_POSTCODE_COL = "Postleitzahl_Spaltenname";
    private static final String PARAM_POSTCODE_DESC = "Spalte mit Postleitzahl";


    @Autowired
    public TableConverter_address_street_housenumber_city(FeatureDecoder featureDecoder) {
    	super(featureDecoder);        
    }
    
	

	protected List<SpatialResource> convertSpatialResourcesFromTable(ConverterDefinitionType converterDefinition,
			Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) throws Exception {
		Optional<String> sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());
        
        Optional<String> streetHousenumberOpt = this.getParameterValue(PARAM_STREET_HOUSENUMBER_COL, converterDefinition.getParameters());
        if (!streetHousenumberOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_STREET_HOUSENUMBER_COL);
        }
        
        Optional<String> cityOpt = this.getParameterValue(PARAM_CITY_COL, converterDefinition.getParameters());
        Optional<String> postcodeOpt = this.getParameterValue(PARAM_POSTCODE_COL, converterDefinition.getParameters());

     // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromTable_attributesOnly(converterDefinition, dataset, sepOpt);
            
        return decodeFeatureCollectionToSpatialResources(featureCollection, propertyMapping, CRS.decode(EPSG_4326), streetHousenumberOpt, cityOpt, postcodeOpt);

	}

	private List<SpatialResource> decodeFeatureCollectionToSpatialResources(SimpleFeatureCollection featureCollection,
			SpatialResourcePropertyMappingType propertyMapping, CoordinateReferenceSystem crs, Optional<String> streetHousenumberOpt, Optional<String> cityOpt, Optional<String> postcodeOpt) throws Exception {
		featureCollection = queryGeometryFromAddressStrings(featureCollection, streetHousenumberOpt, cityOpt, postcodeOpt, propertyMapping);
		
		return featureDecoder.decodeFeatureCollectionToSpatialResources(featureCollection, propertyMapping, crs);
	}

	

	private SimpleFeatureCollection queryGeometryFromAddressStrings(SimpleFeatureCollection featureCollection, Optional<String> streetHousenumberOpt, Optional<String> cityOpt, Optional<String> postcodeOpt, SpatialResourcePropertyMappingType propertyMapping) throws Exception {
		
		Map<String, String> queryStrings = collectGeocodingQueryStrings(featureCollection, streetHousenumberOpt, cityOpt, postcodeOpt, propertyMapping);
		
		Map<String, GeocodingOutputType> geolocationObjectMap = queryGeolocation_byQueryString(queryStrings);
		
		SimpleFeatureCollection resultCollection = addGeolocation(featureCollection, geolocationObjectMap, propertyMapping);
		
		return resultCollection;
	}
	
	private Map<String, String> collectGeocodingQueryStrings(SimpleFeatureCollection featureCollection, Optional<String> streetHousenumberOpt, Optional<String> cityOpt, Optional<String> postcodeOpt, SpatialResourcePropertyMappingType propertyMapping) {
		SimpleFeatureIterator iterator = featureCollection.features();
		Map<String, String> queryStrings = new HashMap<String, String>();

        while (iterator.hasNext()) {
            SimpleFeature feature = iterator.next();
            
            String streetHousenumber = (String)feature.getAttribute(streetHousenumberOpt.get());		
    		
    		if(streetHousenumber == null) {
    			LOG.error("streetHousenumber column does not contain any value for geocoding feature to geometry.");
//    			throw new Exception("streetHousenumber column does not contain any value for geocoding feature to geometry.");
    		}
    		String addressAsString = streetHousenumber;
    		
    		if(!cityOpt.isPresent() && !postcodeOpt.isPresent()) {
    			LOG.warn("neither city column nor postcodeColumn available. Geocoding might not return unique results.");
    		}
    		
    		if (postcodeOpt.isPresent()) {
    			String postcode = String.valueOf(feature.getAttribute(postcodeOpt.get()));
    			if(postcode != null && !postcode.isEmpty()) {
    				addressAsString += " " + postcode;
    			}			
    		}
    		
    		if (cityOpt.isPresent() ) {
    			String city = (String)feature.getAttribute(cityOpt.get());
    			if(city != null && !city.isEmpty()) {
    				addressAsString += " " + city;
    			}
    		}
    		
    		if(addressAsString == null) {
    			LOG.error("address does not contain sufficient information for geocoding feature to geometry for feature with ID {}.", feature.getID());  
    			featureDecoder.addMonitoringMessage(propertyMapping.getIdentifierProperty(), feature, "address does not contain sufficient information for geocoding feature to geometry");
    		}
    		else {
    			queryStrings.put(String.valueOf(feature.getAttribute(propertyMapping.getIdentifierProperty())), addressAsString);
    		}            
        }
        iterator.close();
        
        return queryStrings;
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
        params.add(new ConverterParameter(PARAM_STREET_HOUSENUMBER_COL, PARAM_STREET_HOUSENUMBER_DESC, ConverterParameter.ParameterTypeValues.STRING, true));
        params.add(new ConverterParameter(PARAM_CITY_COL, PARAM_CITY_DESC, ConverterParameter.ParameterTypeValues.STRING, false));
        params.add(new ConverterParameter(PARAM_POSTCODE_COL, PARAM_POSTCODE_DESC, ConverterParameter.ParameterTypeValues.STRING, false));
        return params;
	}

}

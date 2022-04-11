package org.n52.kommonitor.importer.converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.referencing.CRS;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.geocoder.model.GeocodingOutputType;
import org.n52.kommonitor.importer.geocoder.model.GeocodingStructuredBatchInputType;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableConverter_address_structured extends AbstractTableConverter {
	
	private static final String EPSG_4326 = "EPSG:4326";
	private static final String NAME = "Tabelle_Geokodierung_Adresse_strukturierte_Einzelspalten";
    private static final String PARAM_COUNTRY_COL = "Land_Spaltenname";
    private static final String PARAM_COUNTRY_DESC = "Spalte mit Landnamen";
    private static final String PARAM_STATE_COL = "Bundesland_Spaltenname";
    private static final String PARAM_STATE_DESC = "Spalte mit Bundeslandsnamen";
    private static final String PARAM_CITY_COL = "Stadt_Spaltenname";
    private static final String PARAM_CITY_DESC = "Spalte mit Stadtnamen";
    private static final String PARAM_DISTRICT_COL = "Bezirk_Spaltenname";
    private static final String PARAM_DISTRICT_DESC = "Spalte mit Bezirksnamen";
    private static final String PARAM_STREET_COL = "Strasse_Spaltenname";
    private static final String PARAM_STREET_DESC = "Spalte mit Strassennamen";
    private static final String PARAM_POSTCODE_COL = "Postleitzahl_Spaltenname";
    private static final String PARAM_POSTCODE_DESC = "Spalte mit Postleitzahl";
    private static final String PARAM_HOUSENUMBER_COL = "Hausnummer_Spaltenname";
    private static final String PARAM_HOUSENUMBER_DESC = "Spalte mit Hausnummer";

    @Autowired
    public TableConverter_address_structured(FeatureDecoder featureDecoder) {
        super(featureDecoder);
    }

	protected List<SpatialResource> convertSpatialResourcesFromTable(ConverterDefinitionType converterDefinition,
			Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) throws Exception {
		Optional<String> sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());
        
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
			SpatialResourcePropertyMappingType propertyMapping, CoordinateReferenceSystem crs, Optional<String> countryOpt, Optional<String> stateOpt, Optional<String> cityOpt, 
			Optional<String> districtOpt, Optional<String> postcodeOpt, Optional<String> streetOpt, Optional<String> housenumberOpt) throws Exception {
		featureCollection = queryGeometryFromAddressStructured(featureCollection, propertyMapping, countryOpt, stateOpt, cityOpt, districtOpt, postcodeOpt, streetOpt, housenumberOpt);
    	
		return featureDecoder.decodeFeatureCollectionToSpatialResources(featureCollection, propertyMapping, crs);
	}

	private SimpleFeatureCollection queryGeometryFromAddressStructured(SimpleFeatureCollection featureCollection,
			SpatialResourcePropertyMappingType propertyMapping,
			Optional<String> countryOpt, Optional<String> stateOpt, Optional<String> cityOpt,
			Optional<String> districtOpt, Optional<String> postcodeOpt, Optional<String> streetOpt,
			Optional<String> housenumberOpt) throws Exception {
		
		Map<String, GeocodingStructuredBatchInputType> queryStructuredInputs = collectGeocodingQueryStructuredInputs(featureCollection, countryOpt, stateOpt, cityOpt,
				districtOpt, postcodeOpt, streetOpt,
				housenumberOpt, propertyMapping);
		
		Map<String, GeocodingOutputType> geolocationObjectMap = queryGeolocation_byStructuredInput(queryStructuredInputs);
		
		SimpleFeatureCollection resultCollection = addGeolocation(featureCollection, geolocationObjectMap, propertyMapping);
		
		return resultCollection;
	}

	

	private Map<String, GeocodingStructuredBatchInputType> collectGeocodingQueryStructuredInputs(
			SimpleFeatureCollection featureCollection, Optional<String> countryOpt, Optional<String> stateOpt,
			Optional<String> cityOpt, Optional<String> districtOpt, Optional<String> postcodeOpt,
			Optional<String> streetOpt, Optional<String> housenumberOpt,
			SpatialResourcePropertyMappingType propertyMapping) {
		
		SimpleFeatureIterator iterator = featureCollection.features();
		Map<String, GeocodingStructuredBatchInputType> queryStructuredInputs = new HashMap<String, GeocodingStructuredBatchInputType>();

        while (iterator.hasNext()) {
            SimpleFeature feature = iterator.next();
            
            GeocodingStructuredBatchInputType batchInput = new GeocodingStructuredBatchInputType();
            
            String country = (String)feature.getAttribute(! countryOpt.isPresent() ? null : countryOpt.get());
    		String state = (String)feature.getAttribute(! stateOpt.isPresent() ? null : stateOpt.get());
    		String city = (String)feature.getAttribute(! cityOpt.isPresent() ? null : cityOpt.get());
    		String district = (String)feature.getAttribute(! districtOpt.isPresent() ? null : districtOpt.get());    		
    		String street = (String)feature.getAttribute(streetOpt.get());
    		String postcode = String.valueOf(feature.getAttribute(! postcodeOpt.isPresent() ? null : postcodeOpt.get()));
    		String housenumber = String.valueOf(feature.getAttribute(housenumberOpt.get()));
    		
    		if (postcode.equalsIgnoreCase("null")) {
    			postcode = null;
    		}
    		if (housenumber.equalsIgnoreCase("null")) {
    			housenumber = null;
    		}
    		
    		if(!cityOpt.isPresent() && !postcodeOpt.isPresent()) {
    			LOG.warn("neither city column nor postcodeColumn available. Geocoding might not return unique results.");
    		}

    		if(street != null) {
    			batchInput.setStreet(street);
        	}
    		if(housenumber != null && !housenumber.isEmpty()) {
    			batchInput.setHousenumber(housenumber);
        	}
    		if(postcode != null && !postcode.isEmpty()) {
    			batchInput.setPostcode(postcode);
        	}
        	if(city != null) {
        		batchInput.setCity(city);
        	}
        	if(country != null) {
        		batchInput.setCountry(country);
        	}
        	if(state != null) {
        		batchInput.setState(state);
        	}
        	if(district != null) {
        		batchInput.setDistrict(district);
        	}            
    		
        	if(street == null || housenumber == null) {
    			LOG.error("street or housenumber column does not contain any value for geocoding feature to geometry.");
    			featureDecoder.addMonitoringMessage(propertyMapping.getIdentifierProperty(), feature, "address does not contain sufficient information for geocoding feature to geometry - street or housenumber column is empty");
    		}
    		else {
    			queryStructuredInputs.put(String.valueOf(feature.getAttribute(propertyMapping.getIdentifierProperty())), batchInput);
    		}            
        }
        iterator.close();
        
        return queryStructuredInputs;
        
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
        params.add(new ConverterParameter(PARAM_STREET_COL, PARAM_STREET_DESC, ConverterParameter.ParameterTypeValues.STRING, true));
        params.add(new ConverterParameter(PARAM_HOUSENUMBER_COL, PARAM_HOUSENUMBER_DESC, ConverterParameter.ParameterTypeValues.NUMBER, true));
//        params.add(new ConverterParameter(PARAM_COUNTRY_COL, PARAM_COUNTRY_DESC, ConverterParameter.ParameterTypeValues.STRING, false));
//        params.add(new ConverterParameter(PARAM_STATE_COL, PARAM_STATE_DESC, ConverterParameter.ParameterTypeValues.STRING, false));
        params.add(new ConverterParameter(PARAM_CITY_COL, PARAM_CITY_DESC, ConverterParameter.ParameterTypeValues.STRING, false));
//        params.add(new ConverterParameter(PARAM_DISTRICT_COL, PARAM_DISTRICT_DESC, ConverterParameter.ParameterTypeValues.STRING, false));
        params.add(new ConverterParameter(PARAM_POSTCODE_COL, PARAM_POSTCODE_DESC, ConverterParameter.ParameterTypeValues.NUMBER, false));        
        return params;
	}

}

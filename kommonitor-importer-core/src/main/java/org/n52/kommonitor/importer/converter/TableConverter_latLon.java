package org.n52.kommonitor.importer.converter;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.referencing.CRS;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.opengis.referencing.FactoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableConverter_latLon extends AbstractTableConverter {
	
	private static final String NAME = "Tabelle_XY_Koordinate_zu_Punkt";
    private static final String PARAM_X_COORD_COL = "X_Koordinatenspalte_(Rechtswert)";
    private static final String PARAM_X_COORD_DESC = "Spalte mit Rechtswert";
    private static final String PARAM_Y_COORD_COL = "Y_Koordinatenspalte_(Hochwert)";
    private static final String PARAM_Y_COORD_DESC = "Spalte mit Hochwert";
    private static final String PARAM_CRS = "CRS";
    private static final String PARAM_CRS_DESC = "Angabe des Koordinatenreferenzsystems als EPSG-Code (z.B. EPSG:4326)";    

    @Autowired
    public TableConverter_latLon(FeatureDecoder featureDecoder) {
        super(featureDecoder);
    }

	protected List<SpatialResource> convertSpatialResourcesFromTable(ConverterDefinitionType converterDefinition,
			Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) throws Exception {
		Optional<String> sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());

        Optional<String> crsOpt = this.getParameterValue(PARAM_CRS, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_CRS);
        }
        
        Optional<String> xCoordOpt = this.getParameterValue(PARAM_X_COORD_COL, converterDefinition.getParameters());
        if (!xCoordOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_X_COORD_COL);
        }
        Optional<String> yCoordOpt = this.getParameterValue(PARAM_Y_COORD_COL, converterDefinition.getParameters());
        if (!yCoordOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_Y_COORD_COL);
        }

     // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromTable_latLon(converterDefinition, dataset, sepOpt, crsOpt, xCoordOpt, yCoordOpt);
        
        try {
            return featureDecoder.decodeFeatureCollectionToSpatialResources(featureCollection, propertyMapping, CRS.decode(crsOpt.get()));
        } catch (FactoryException ex) {
            throw new ImportParameterException(String.format("Invalid CRS parameter '%s'.", crsOpt.get()), ex);
        }
	}

	protected List<IndicatorValue> convertIndicatorsFromTable(ConverterDefinitionType converterDefinition, Dataset dataset,
			IndicatorPropertyMappingType propertyMapping) throws Exception {
		Optional<String> sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());

        Optional<String> crsOpt = this.getParameterValue(PARAM_CRS, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_CRS);
        }
        
        Optional<String> xCoordOpt = this.getParameterValue(PARAM_X_COORD_COL, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_X_COORD_COL);
        }
        Optional<String> yCoordOpt = this.getParameterValue(PARAM_Y_COORD_COL, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_Y_COORD_COL);
        }

     // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromTable_latLon(converterDefinition, dataset, sepOpt, crsOpt, xCoordOpt, yCoordOpt);
        
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
        params.add(new ConverterParameter(PARAM_CRS, PARAM_CRS_DESC, ConverterParameter.ParameterTypeValues.STRING, true));
        params.add(new ConverterParameter(PARAM_X_COORD_COL, PARAM_X_COORD_DESC, ConverterParameter.ParameterTypeValues.NUMBER, true));
        params.add(new ConverterParameter(PARAM_Y_COORD_COL, PARAM_Y_COORD_DESC, ConverterParameter.ParameterTypeValues.NUMBER, true));
        return params;
	}

}

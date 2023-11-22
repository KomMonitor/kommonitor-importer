package org.n52.kommonitor.importer.converter;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.NotImplementedException;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableConverter_indicator extends AbstractTableConverter {
	
	private static final String NAME = "Tabelle_Zeitreihe_zu_Indikator";

    @Autowired
    public TableConverter_indicator(FeatureDecoder featureDecoder) {
        super(featureDecoder);
    }

    @Override
	protected List<SpatialResource> convertSpatialResourcesFromTable(ConverterDefinitionType converterDefinition,
			Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) {
		throw new NotImplementedException("The import of spatial resources via CSVConverter_indicator is not supported");
	}

	protected List<IndicatorValue> convertIndicatorsFromTable(ConverterDefinitionType converterDefinition, Dataset dataset,
			IndicatorPropertyMappingType propertyMapping) throws Exception {
		Optional<String> sepOpt = this.getParameterValue(PARAM_SEP, converterDefinition.getParameters());

     // Due to GeoTools decoding issues when handling SimpleFeatures with different schemas within a FeatureCollection,
        // the FeatureCollection will be read with a Jackson based parser, first.
        SimpleFeatureCollection featureCollection = retrieveFeatureCollectionFromTable_attributesOnly(converterDefinition, dataset, sepOpt);

        return featureDecoder.decodeFeatureCollectionToIndicatorValues(featureCollection, propertyMapping);
	}

	@Override
	public String initName() {
		return NAME;
	}

	@Override
	public Set<ConverterParameter> initConverterParameters() {
        return params;
	}

}

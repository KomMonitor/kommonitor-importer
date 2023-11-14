package org.n52.kommonitor.importer.converter;

import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.models.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class APIFeaturesConverter extends GeoJsonConverter {

    private static final String NAME = "OGC API - Features";

    @Autowired
    public APIFeaturesConverter(FeatureDecoder featureDecoder) {
        super(featureDecoder);
    }

    @Override
    public String initName() {
        return NAME;
    }

    @Override
    public Set<String> initSupportedDatasources() {
        Set<String> types = new HashSet<>();
        types.add(DataSourceType.TypeEnum.OGCAPI_FEATURES.getValue());
        return types;
    }
}

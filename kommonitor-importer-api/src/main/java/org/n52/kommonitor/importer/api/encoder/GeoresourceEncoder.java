package org.n52.kommonitor.importer.api.encoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.n52.kommonitor.datamanagement.api.models.GeoresourcePOSTInputType;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.models.CommonMetadataType;
import org.n52.kommonitor.importer.models.ImportGeoresourcePOSTInputType;
import org.n52.kommonitor.importer.models.PeriodOfValidityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Encodes a {@link ImportGeoresourcePOSTInputType} and a {@link List<SpatialResource>} into a {@link GeoresourcePOSTInputType}
 * for usage within a {@link org.n52.kommonitor.importer.api.GeoresourcesApi} client.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class GeoresourceEncoder {

    @Autowired
    private ApiEncodingHelper encodingHelper;

    @Autowired
    private SpatialResourceJsonEncoder spatialResourceEncoder;

    public GeoresourcePOSTInputType encode(ImportGeoresourcePOSTInputType importType, List<SpatialResource> spatialResources) throws JsonProcessingException {
        GeoresourcePOSTInputType geoResource = new GeoresourcePOSTInputType();
        geoResource.setAllowedRoles(importType.getAllowedRoles());
        geoResource.setApplicableTopics(importType.getApplicableTopics());
        geoResource.setDatasetName(importType.getDatasetName());
        geoResource.setIsPOI(importType.isIsPOI());
        geoResource.setJsonSchema(importType.getJsonSchema());
        if (importType.getMetadata() != null) {
            geoResource.setMetadata(encodingHelper.encodeMetadata(importType.getMetadata()));
        }
        if (importType.getPeriodOfValidity() != null) {
            geoResource.setPeriodOfValidity(encodingHelper.encodePeriodOfValidity(importType.getPeriodOfValidity()));
        }
        geoResource.setPoiMarkerColor(org.n52.kommonitor.datamanagement.api.models.GeoresourcePOSTInputType.PoiMarkerColorEnum.valueOf(importType.getPoiMarkerColor().name()));
        geoResource.setPoiSymbolBootstrap3Name(importType.getPoiSymbolBootstrap3Name());
        geoResource.setPoiSymbolColor(org.n52.kommonitor.datamanagement.api.models.GeoresourcePOSTInputType.PoiSymbolColorEnum.valueOf(importType.getPoiSymbolColor().name()));
        geoResource.setGeoJsonString(spatialResourceEncoder.encodeSpatialResourcesAsString(spatialResources));
        return geoResource;
    }


}

package org.n52.kommonitor.importer.api.encoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.n52.kommonitor.datamanagement.api.models.GeoresourcePOSTInputType;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.models.CommonMetadataType;
import org.n52.kommonitor.importer.models.ImportGeoresourcePOSTInputType;
import org.n52.kommonitor.importer.models.PeriodOfValidityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * Encodes a {@link ImportGeoresourcePOSTInputType} and a {@link List<SpatialResource>} into a {@link GeoresourcePOSTInputType}
 * for usage within a {@link org.n52.kommonitor.importer.api.GeoresourcesApi} client.
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class GeoresourceEncoder {

    @Autowired
    private SpatialResourceJsonEncoder spatialResourceEncoder;

    public GeoresourcePOSTInputType encode(ImportGeoresourcePOSTInputType importType, List<SpatialResource> spatialResource) throws JsonProcessingException {
        GeoresourcePOSTInputType geoResource = new GeoresourcePOSTInputType();
        geoResource.setAllowedRoles(importType.getAllowedRoles());
        geoResource.setApplicableTopics(importType.getApplicableTopics());
        geoResource.setDatasetName(importType.getDatasetName());
        geoResource.setIsPOI(importType.isIsPOI());
        geoResource.setJsonSchema(importType.getJsonSchema());
        geoResource.setMetadata(encodeMetadata(importType.getMetadata()));
        geoResource.setPeriodOfValidity(encodePeriodOfValidity(importType.getPeriodOfValidity()));
        geoResource.setPoiMarkerColor(org.n52.kommonitor.datamanagement.api.models.GeoresourcePOSTInputType.PoiMarkerColorEnum.valueOf(importType.getPoiMarkerColor().name()));
        geoResource.setPoiSymbolBootstrap3Name(importType.getPoiSymbolBootstrap3Name());
        geoResource.setPoiSymbolColor(org.n52.kommonitor.datamanagement.api.models.GeoresourcePOSTInputType.PoiSymbolColorEnum.valueOf(importType.getPoiSymbolColor().name()));
        geoResource.setGeoJsonString(spatialResourceEncoder.encodeSpatialResourcesAsString(spatialResource));
        return geoResource;
    }

    private org.n52.kommonitor.datamanagement.api.models.PeriodOfValidityType encodePeriodOfValidity(PeriodOfValidityType pOV) {
        org.n52.kommonitor.datamanagement.api.models.PeriodOfValidityType res = new org.n52.kommonitor.datamanagement.api.models.PeriodOfValidityType();
        res.setEndDate(LocalDate.of(pOV.getEndDate().getYear(), pOV.getEndDate().getMonthOfYear(), pOV.getEndDate().getDayOfMonth()));
        res.setStartDate(LocalDate.of(pOV.getStartDate().getYear(), pOV.getStartDate().getMonthOfYear(), pOV.getStartDate().getDayOfMonth()));
        return res;
    }

    private org.n52.kommonitor.datamanagement.api.models.CommonMetadataType encodeMetadata(CommonMetadataType meta) {
        org.n52.kommonitor.datamanagement.api.models.CommonMetadataType res = new org.n52.kommonitor.datamanagement.api.models.CommonMetadataType();
        res.setContact(meta.getContact());
        res.setDatabasis(meta.getDatabasis());
        res.setDatasource(meta.getDatasource());
        res.setDescription(meta.getDescription());
        res.setLastUpdate(LocalDate.of(meta.getLastUpdate().getYear(), meta.getLastUpdate().getMonthOfYear(), meta.getLastUpdate().getDayOfMonth()));
        res.setLiterature(meta.getLiterature());
        res.setNote(meta.getNote());
        res.setSridEPSG(meta.getSridEPSG());
        res.setUpdateInterval(org.n52.kommonitor.datamanagement.api.models.CommonMetadataType.UpdateIntervalEnum.valueOf(meta.getUpdateInterval().name()));
        return res;
    }
}

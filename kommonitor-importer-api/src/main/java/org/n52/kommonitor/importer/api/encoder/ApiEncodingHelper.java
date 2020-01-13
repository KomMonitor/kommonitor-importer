package org.n52.kommonitor.importer.api.encoder;

import org.springframework.stereotype.Component;

/**
 * Helper class for encoding common API model types
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class ApiEncodingHelper {

//    public org.n52.kommonitor.datamanagement.api.models.CommonMetadataType encodeMetadata(CommonMetadataType meta) {
//        org.n52.kommonitor.datamanagement.api.models.CommonMetadataType res = new org.n52.kommonitor.datamanagement.api.models.CommonMetadataType();
//        res.setContact(meta.getContact());
//        res.setDatabasis(meta.getDatabasis());
//        res.setDatasource(meta.getDatasource());
//        res.setDescription(meta.getDescription());
//        res.setLastUpdate(meta.getLastUpdate());
//        res.setLiterature(meta.getLiterature());
//        res.setNote(meta.getNote());
//        res.setSridEPSG(meta.getSridEPSG());
//        res.setUpdateInterval(org.n52.kommonitor.datamanagement.api.models.CommonMetadataType.UpdateIntervalEnum.valueOf(meta.getUpdateInterval().name()));
//        return res;
//    }
//
//    public org.n52.kommonitor.datamanagement.api.models.PeriodOfValidityType encodePeriodOfValidity(PeriodOfValidityType pOV) {
//        org.n52.kommonitor.datamanagement.api.models.PeriodOfValidityType res = new org.n52.kommonitor.datamanagement.api.models.PeriodOfValidityType();
//        res.setStartDate(pOV.getStartDate());
//        res.setEndDate(pOV.getEndDate());
//        return res;
//    }
}

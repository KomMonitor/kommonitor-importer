package org.n52.kommonitor.importer.utils;

import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.entities.TimeseriesValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Helper class to validate the consistency of entity properties
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class EntityValidator {

    private static final Logger LOG = LoggerFactory.getLogger(EntityValidator.class);

    /**
     * Checks if a {@link SpatialResource} is valid
     *
     * @param entity the entity to check validity for
     * @return true if the validation check was succesful
     */
    public boolean isValid(SpatialResource entity) {
        if (entity.getId() == null || entity.getId().isEmpty()) {
            LOG.warn("Missing ID property for SpatialResource: {}", entity);
            return false;
        }
        if (entity.getName() == null || entity.getName().isEmpty()) {
            LOG.warn("Missing NAME property for SpatialResource: {}", entity);
            return false;
        }
        if (entity.getGeom() == null || entity.getGeom().isEmpty()) {
            LOG.warn("Missing GEOM property for SpatialResource: {}", entity);
            return false;
        }
        return true;
    }

    /**
     * Checks if a {@link IndicatorValue} is valid
     *
     * @param entity the entity to check validity for
     * @return true if the validation check was succesful
     */
    public boolean isValid(IndicatorValue entity) {
        if (entity.getSpatialReferenceKey() == null || entity.getSpatialReferenceKey().isEmpty()) {
            LOG.warn("Missing SpatialReferenceKey property for Indicator: {}", entity);
            return false;
        }
        if (entity.getTimeSeriesValueList() == null || entity.getTimeSeriesValueList().isEmpty()) {
            LOG.warn("No TimeSeriesValues for Indicator: {}", entity);
            return false;
        }
        boolean isValid = true;
        for (TimeseriesValue t : entity.getTimeSeriesValueList()) {
            if (!isValid(t)) {
                isValid = false;
                LOG.warn("No valid TimeSeriesValue for Indicator: {}", t);
            }
        }
        return isValid;
    }

    /**
     * Checks if a {@link TimeseriesValue} is valid
     *
     * @param entity the entity to check validity for
     * @return true if the validation check was succesful
     */
    public boolean isValid(TimeseriesValue entity) {
        if (Float.isNaN(entity.getValue())) {
            return false;
        }
        if (entity.getTimestamp() == null) {
            return false;
        }
        return true;
    }

}

package org.n52.kommonitor.importer.utils;

import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.locationtech.jts.geom.Geometry;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Helper class that provides various simplified functions for geometric operations
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class GeometryHelper implements InitializingBean {

    public static final String EPSG_4326 = "EPSG:4326";

    private static CoordinateReferenceSystem DEFAULT_CRS;

    /**
     * Reprojects a {@link Geometry} from a source CRS into WGS 84 CRS
     *
     * @param geom      {@link Geometry} to reproject
     * @param sourceCrs {@link CoordinateReferenceSystem} of the feature geometry
     * @return the reprojected {@link Geometry}
     * @throws FactoryException
     * @throws TransformException
     */
    public Geometry reprojectGeomToWgs84(Geometry geom, CoordinateReferenceSystem sourceCrs)
            throws FactoryException, TransformException {
        return reprojectGeom(geom, sourceCrs, DEFAULT_CRS);
    }

    /**
     * Reprojects a {@link Geometry} from a source CRS into a target CRS
     *
     * @param geom      {@link Geometry} to reproject
     * @param sourceCrs source {@link CoordinateReferenceSystem} of a feature's geometry
     * @param targetCrs target {@link CoordinateReferenceSystem} to which a feature's geometry should be reprojected
     * @return the reprojected {@link Geometry}
     * @throws FactoryException
     * @throws TransformException
     */
    public Geometry reprojectGeom(Geometry geom, CoordinateReferenceSystem sourceCrs, CoordinateReferenceSystem targetCrs)
            throws FactoryException, TransformException {
        MathTransform transform = CRS.findMathTransform(sourceCrs, targetCrs);
        return JTS.transform(geom, transform);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        DEFAULT_CRS = CRS.decode(EPSG_4326);
    }
}

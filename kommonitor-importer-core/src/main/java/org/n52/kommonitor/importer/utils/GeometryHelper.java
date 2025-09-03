package org.n52.kommonitor.importer.utils;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.geom.GeometryFactory;
import org.geotools.api.feature.simple.SimpleFeature;
import org.geotools.api.referencing.FactoryException;
import org.geotools.api.referencing.crs.CoordinateReferenceSystem;
import org.geotools.api.referencing.operation.MathTransform;
import org.geotools.api.referencing.operation.TransformException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static Geometry combineGeometries(SimpleFeatureCollection fc) {
        List<Geometry> geometryList = new ArrayList<>();
        try (SimpleFeatureIterator iterator = fc.features()) {
            while (iterator.hasNext()) {
                SimpleFeature feature = iterator.next();
                if (feature.getDefaultGeometry() == null) {
                    continue;
                }
                geometryList.add((Geometry) feature.getDefaultGeometry());
            }
        }
        return combineGeometries(geometryList);
    }

    private static Geometry combineGeometries(List<Geometry> geometries) {
        GeometryFactory geoFac = new GeometryFactory();
        if (geometries.size() > 1) {
            GeometryCollection geometryCollection = (GeometryCollection) geoFac.buildGeometry(geometries);
            return geometryCollection.union();
        } else {
            return geometries.get(0);
        }
    }

    public static boolean spatiallyIntersects(Geometry feature, Geometry referenceGeometry) {
        if (referenceGeometry == null) {
            return true;
        } else {
            return feature.intersects(referenceGeometry);
        }
    }

}

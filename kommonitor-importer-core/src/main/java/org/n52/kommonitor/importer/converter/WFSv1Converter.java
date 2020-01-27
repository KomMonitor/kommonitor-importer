package org.n52.kommonitor.importer.converter;

import org.geotools.GML;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.referencing.CRS;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.opengis.referencing.FactoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Converter for WFS 1.0.0 and WFS 1.1.0 datasets.
 * Parses a WFS GetFeature response document as {@link org.geotools.feature.FeatureCollection}
 * and converts it into KomMonitor resources.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class WFSv1Converter extends AbstractConverter {
    private static final String NAME = "org.n52.kommonitor.importer.converter.wfs.v1";
    private static final String WFS_SCHEMA_100 = "http://schemas.opengis.net/wfs/1.0.0/wfs.xsd";
    private static final String WFS_SCHEMA_110 = "http://schemas.opengis.net/wfs/1.1.0/wfs.xsd";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String PARAM_CRS = "CRS";

    private FeatureDecoder featureDecoder;

    @Autowired
    public WFSv1Converter(FeatureDecoder featureDecoder) {
        this.featureDecoder = featureDecoder;
    }


    @Override
    public String initName() {
        return NAME;
    }

    @Override
    public Set<String> initSupportedMimeType() {
        Set<String> mimeTypes = new HashSet<>();
        mimeTypes.add("application/xml");
        mimeTypes.add("test/xml");
        return mimeTypes;
    }

    @Override
    public Set<String> initSupportedSchemas() {
        Set<String> schemas = new HashSet<>();
        schemas.add(WFS_SCHEMA_100);
        schemas.add(WFS_SCHEMA_110);

        return schemas;
    }

    @Override
    public Set<String> initSupportedEncoding() {
        Set<String> encodings = new HashSet<>();
        encodings.add(DEFAULT_ENCODING);

        return encodings;
    }

    @Override
    public Set<ConverterParameter> initConverterParameters() {
        Set<ConverterParameter> params = new HashSet();
        ConverterParameter crsParam = createCrsParameter();
        params.add(crsParam);
        return params;
    }

    @Override
    public List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition,
                                                         Dataset dataset,
                                                         SpatialResourcePropertyMappingType propertyMapping)
            throws ConverterException, ImportParameterException {
        InputStream input = getInputStream(converterDefinition, dataset);
        try {
            return convertSpatialResources(converterDefinition, input, propertyMapping);
        } catch (ParserConfigurationException | SAXException | IOException | FactoryException ex) {
            throw new ConverterException("Error while parsing dataset.", ex);
        }
    }


    @Override
    public List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition,
                                                  Dataset dataset,
                                                  IndicatorPropertyMappingType propertyMapping) throws ConverterException {
        InputStream input = getInputStream(converterDefinition, dataset);
        try {
            return convertIndicators(converterDefinition, input, propertyMapping);
        } catch (ParserConfigurationException | SAXException | IOException | FactoryException ex) {
            throw new ConverterException("Error while parsing dataset.", ex);
        }
    }

    /**
     * Get a GML parser for a certain GML schema version.
     * Supported schemas are:
     * - http://schemas.opengis.net/wfs/1.0.0/wfs.xsd
     * - http://schemas.opengis.net/wfs/1.1.0/wfs.xsd
     *
     * @param schema the GML schema version
     * @return a {@link GML} parser for the specified GML version
     * @throws ImportParameterException for an unsupported GML schema version
     */
    protected GML getGmlParserForSchema(String schema) throws ImportParameterException {
        if (schema.equals(WFS_SCHEMA_100)) {
            return new GML(GML.Version.WFS1_0);
        } else if (schema.equals(WFS_SCHEMA_110)) {
            return new GML(GML.Version.WFS1_1);
        } else {
            throw new ImportParameterException(String.format("The selected schema '%s' is not suported.", schema));
        }
    }

    private List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition,
                                                          InputStream dataset,
                                                          SpatialResourcePropertyMappingType propertyMapping)
            throws ImportParameterException, ParserConfigurationException, SAXException, IOException, FactoryException {
        GML gml = getGmlParserForSchema(converterDefinition.getSchema());

        gml.setEncoding(Charset.forName(converterDefinition.getEncoding()));

        if (converterDefinition.getParameters() == null) {
            throw new ImportParameterException("Missing converter parameters");
        }
        Optional<String> crsOpt = this.getParameterValue(PARAM_CRS, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_CRS);
        }

        SimpleFeatureCollection collection = gml.decodeFeatureCollection(dataset);

        return featureDecoder.decodeFeatureCollectionToSpatialResources(collection, propertyMapping, CRS.decode(crsOpt.get()));
    }

    private List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition,
                                                   InputStream dataset,
                                                   IndicatorPropertyMappingType propertyMapping)
            throws ImportParameterException, ParserConfigurationException, SAXException, IOException, FactoryException {
        GML gml = getGmlParserForSchema(converterDefinition.getSchema());
        gml.setEncoding(Charset.forName(converterDefinition.getEncoding()));

        SimpleFeatureCollection collection = gml.decodeFeatureCollection(dataset);

        return featureDecoder.decodeFeatureCollectionToIndicatorValues(collection, propertyMapping);
    }

    private ConverterParameter createCrsParameter() {
        String desc = "Code of the coordinate reference system of the input dataset (e.g. 'EPSG:4326')";
        return new ConverterParameter(PARAM_CRS, desc, ConverterParameter.ParameterTypeValues.STRING);
    }
}


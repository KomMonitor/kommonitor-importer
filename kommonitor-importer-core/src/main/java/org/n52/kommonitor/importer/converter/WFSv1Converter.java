package org.n52.kommonitor.importer.converter;

import net.opengis.wfs.impl.FeatureCollectionTypeImpl;
import org.geotools.GML;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.referencing.CRS;
import org.geotools.xml.Configuration;
import org.geotools.xml.Parser;
import org.geotools.xs.XSConfiguration;
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
import org.picocontainer.MutablePicoContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    private static final String PARAM_NAMESPACE = "NAMESPACE";
    private static final String PARAM_SCHEMA_LOCATION = "SCHEMA_LOCATION";

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
        params.add(createCrsParameter());
        params.add(createNamespaceParameter());
        params.add(createSchemaLocationParameter());

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
        } catch (ParserConfigurationException | SAXException | IOException ex) {
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
        } catch (ParserConfigurationException | SAXException | IOException ex) {
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
            throw new ImportParameterException(String.format("The selected schema '%s' is not supported.", schema));
        }
    }

    private List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition,
                                                          InputStream dataset,
                                                          SpatialResourcePropertyMappingType propertyMapping)
            throws ImportParameterException, ParserConfigurationException, SAXException, IOException, ConverterException {

        if (converterDefinition.getParameters() == null) {
            throw new ImportParameterException("Missing converter parameters");
        }
        Optional<String> crsOpt = this.getParameterValue(PARAM_CRS, converterDefinition.getParameters());
        if (!crsOpt.isPresent()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_CRS);
        }

        Optional<String> namespaceOpt = this.getParameterValue(PARAM_NAMESPACE, converterDefinition.getParameters());
        Optional<String> schemaLocationOpt = this.getParameterValue(PARAM_SCHEMA_LOCATION, converterDefinition.getParameters());

        SimpleFeatureCollection collection;

        if (namespaceOpt.isPresent() && schemaLocationOpt.isPresent()) {
            collection = parseFeatureCollectionForSchema(dataset, namespaceOpt.get(), schemaLocationOpt.get());
        } else {
            GML gml = getGmlParserForSchema(converterDefinition.getSchema());
            gml.setEncoding(Charset.forName(converterDefinition.getEncoding()));

            collection = gml.decodeFeatureCollection(dataset);
        }

        try {
            return featureDecoder.decodeFeatureCollectionToSpatialResources(collection, propertyMapping, CRS.decode(crsOpt.get()));
        } catch (FactoryException ex) {
            throw new ImportParameterException(String.format("Invalid CRS parameter '%s'.", crsOpt.get()), ex);
        }
    }

    private SimpleFeatureCollection parseFeatureCollectionForSchema(InputStream dataset, String namespace, String schemaLocation)
            throws IOException, SAXException, ParserConfigurationException, ConverterException {
        SimpleFeatureCollection collection;
        WFS100Configuration configuration = new WFS100Configuration(namespace, schemaLocation);
        Parser parser = new Parser(configuration);
        FeatureCollectionTypeImpl fc = (FeatureCollectionTypeImpl) parser.parse(dataset);
        if (fc.getFeature().get(0) instanceof SimpleFeatureCollection) {
            collection = ((SimpleFeatureCollection) fc.getFeature().get(0));
        } else {
            throw new ConverterException("No valid FeatureCollection could be parsed from dataset.");
        }
        return collection;
    }

    private List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition,
                                                   InputStream dataset,
                                                   IndicatorPropertyMappingType propertyMapping)
            throws ImportParameterException, ParserConfigurationException, SAXException, IOException {
        GML gml = getGmlParserForSchema(converterDefinition.getSchema());
        gml.setEncoding(Charset.forName(converterDefinition.getEncoding()));

        SimpleFeatureCollection collection = gml.decodeFeatureCollection(dataset);

        return featureDecoder.decodeFeatureCollectionToIndicatorValues(collection, propertyMapping);
    }

    private ConverterParameter createCrsParameter() {
        String desc = "Code of the coordinate reference system of the input dataset (e.g. 'EPSG:4326')";
        return new ConverterParameter(PARAM_CRS, desc, ConverterParameter.ParameterTypeValues.STRING);
    }

    private ConverterParameter createNamespaceParameter() {
        String desc = String.format("Namespace of the FeatureType that should be parsed (set only in combination with '%s' parameter)", PARAM_SCHEMA_LOCATION);
        return new ConverterParameter(PARAM_NAMESPACE, desc, ConverterParameter.ParameterTypeValues.STRING);
    }

    private ConverterParameter createSchemaLocationParameter() {
        String desc = String.format("Location of the application schema for the FeatureType that should be parsed (set only in combination with '%s' parameter)", PARAM_NAMESPACE);
        return new ConverterParameter(PARAM_SCHEMA_LOCATION, desc, ConverterParameter.ParameterTypeValues.STRING);
    }

    private class WFS100Configuration extends Configuration {
        public WFS100Configuration(String namespace, String schemaLocation) {
            super(new org.geotools.gml2.ApplicationSchemaXSD(namespace, schemaLocation));
            this.addDependency(new XSConfiguration());
            this.addDependency(new org.geotools.wfs.v1_0.WFSConfiguration());
            this.addDependency(new org.geotools.gml2.GMLConfiguration());
        }

        protected void registerBindings(MutablePicoContainer container) {
        }
    }
}


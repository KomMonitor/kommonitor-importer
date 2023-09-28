package org.n52.kommonitor.importer.converter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.referencing.CRS;
import org.geotools.wfs.GML;
import org.geotools.wfs.v1_0.WFSConfiguration_1_0;
import org.geotools.xs.XSConfiguration;
import org.geotools.xsd.Configuration;
import org.geotools.xsd.Parser;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.models.SpatialResourcePropertyMappingType;
import org.picocontainer.MutablePicoContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import net.opengis.wfs.impl.FeatureCollectionTypeImpl;

/**
 * Converter for WFS 1.0.0 and WFS 1.1.0 datasets.
 * Parses a WFS GetFeature response document as {@link org.geotools.feature.FeatureCollection}
 * and converts it into KomMonitor resources.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class WFSv1Converter extends AbstractConverter {
    private static final String NAME = "WFS_v1";
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
    public String getDefaultEncoding() {
        return DEFAULT_ENCODING;
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
                                                  IndicatorPropertyMappingType propertyMapping) throws ConverterException, ImportParameterException {
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

        SimpleFeatureCollection collection = parseFeatureCollection(converterDefinition, dataset);

        try {
            return featureDecoder.decodeFeatureCollectionToSpatialResources(collection, propertyMapping, CRS.decode(crsOpt.get()));
        } catch (Exception ex) {
            throw new ImportParameterException(String.format("Invalid CRS parameter '%s'.", crsOpt.get()), ex);
        }
    }

    private List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition,
                                                   InputStream dataset,
                                                   IndicatorPropertyMappingType propertyMapping)
            throws ImportParameterException, ParserConfigurationException, SAXException, IOException, ConverterException {

        SimpleFeatureCollection collection = parseFeatureCollection(converterDefinition, dataset);

        return featureDecoder.decodeFeatureCollectionToIndicatorValues(collection, propertyMapping);
    }

    private SimpleFeatureCollection parseFeatureCollection(ConverterDefinitionType converterDefinition, InputStream dataset)
            throws IOException, SAXException, ParserConfigurationException, ConverterException, ImportParameterException {
        Optional<String> namespaceOpt = this.getParameterValue(PARAM_NAMESPACE, converterDefinition.getParameters());
        Optional<String> schemaLocationOpt = this.getParameterValue(PARAM_SCHEMA_LOCATION, converterDefinition.getParameters());

        SimpleFeatureCollection collection;

        if (namespaceOpt.isPresent() && schemaLocationOpt.isPresent()) {
            checkNamespaceAndSchemaLocation(namespaceOpt.get(), schemaLocationOpt.get());

            collection = parseFeatureCollectionForSchema(dataset, namespaceOpt.get(), schemaLocationOpt.get());
        } else {
            GML gml = getGmlParserForSchema(converterDefinition.getSchema());
            gml.setEncoding(Charset.forName(converterDefinition.getEncoding()));

            collection = gml.decodeFeatureCollection(dataset);
        }
        return collection;
    }

    private void checkNamespaceAndSchemaLocation(String namespace, String schemaLocation) throws ImportParameterException {
        if (namespace.isEmpty()) {
            throw new ImportParameterException(String.format("Empty value for parameter '%s'.", PARAM_NAMESPACE));
        }
        if (schemaLocation.isEmpty()) {
            throw new ImportParameterException(String.format("Empty value for parameter '%s'.", PARAM_SCHEMA_LOCATION));
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

    private ConverterParameter createCrsParameter() {
        String desc = "Angabe des Koordinatenreferenzsystems als EPSG-Code (z.B. EPSG:4326)";
        return new ConverterParameter(PARAM_CRS, desc, ConverterParameter.ParameterTypeValues.STRING, true);
    }

    private ConverterParameter createNamespaceParameter() {
        String desc = String.format("Namespace des FeatureType der eingelesen werden soll (nur zusammen mit '%s' Parameter setzen," +
                " sonst wird er ignoriert)", PARAM_SCHEMA_LOCATION);
        return new ConverterParameter(PARAM_NAMESPACE, desc, ConverterParameter.ParameterTypeValues.STRING, false);
    }

    private ConverterParameter createSchemaLocationParameter() {
        String desc = String.format("Angabe des Schemas des FeatureType der eingelesen werden soll (nur zusammen mit '%s' Parameter setzen," +
                " sonst wird er ignoriert)", PARAM_NAMESPACE);
        return new ConverterParameter(PARAM_SCHEMA_LOCATION, desc, ConverterParameter.ParameterTypeValues.STRING, false);
    }

    private class WFS100Configuration extends Configuration {
        public WFS100Configuration(String namespace, String schemaLocation) {
            super(new org.geotools.gml2.ApplicationSchemaXSD(namespace, schemaLocation));
            this.addDependency(new XSConfiguration());
            this.addDependency(new WFSConfiguration_1_0());
            this.addDependency(new org.geotools.gml2.GMLConfiguration());
        }

        protected void registerBindings(MutablePicoContainer container) {
        }
    }
}


package org.n52.kommonitor.importer.converter;

import org.geotools.GML;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.Indicator;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.importer.models.SpatialResourcePropertyMappingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class WFSv1Converter extends AbstractConverter {
    private static final String NAME = "org.n52.kommonitor.importer.converter.wfs.v1";
    private static final String MIME_TYPE = "application/xml";
    private static final String WFS_SCHEMA_100 = "http://schemas.opengis.net/wfs/1.0.0/wfs.xsd";
    private static final String WFS_SCHEMA_110 = "http://schemas.opengis.net/wfs/1.1.0/wfs.xsd";
    private static final String DEFAULT_ENCODING = "UTF-8";

//    @Autowired
//    private FeatureDecoder featureDecoder;

    @Override
    public String initName() {
        return NAME;
    }

    @Override
    public String initSupportedMimeType() {
        return MIME_TYPE;
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
        return null;
    }

    @Override
    public List<SpatialResource> convertSpatialResources(ConverterDefinitionType importerDefinition, Dataset dataset, SpatialResourcePropertyMappingType propertyMapping) throws ConverterException, ImportParameterException {
        if (dataset.getData() instanceof String) {
            return convertSpatialResources(importerDefinition, (String) dataset.getData(), propertyMapping);
        } else if (dataset.getData() instanceof InputStream) {
            try {
                return convertSpatialResources(importerDefinition, (InputStream) dataset.getData(), propertyMapping);
            } catch (ParserConfigurationException | SAXException | IOException ex) {
                throw new ConverterException("Error while parsing dataset.", ex);
            }
        } else {
            throw new ConverterException(String.format("Dataset type '%s' is not supported. Supported types are: '%s'",
                    dataset.getData().getClass().getName(),
                    Arrays.toString(new String[]{String.class.getName(), InputStream.class.getName()})));
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

    @Override
    public List<Indicator> convertIndicators(ConverterDefinitionType importerDefinition, Dataset dataset, IndicatorPropertyMappingType propertyMapping) {
        return null;
    }


    protected List<SpatialResource> convertSpatialResources(ConverterDefinitionType importerDefinition, String dataset, SpatialResourcePropertyMappingType propertyMapping) {
        return null;
    }

    protected List<SpatialResource> convertSpatialResources(ConverterDefinitionType importerDefinition, InputStream dataset, SpatialResourcePropertyMappingType propertyMapping) throws ImportParameterException, ParserConfigurationException, SAXException, IOException {
        GML gml = getGmlParserForSchema(importerDefinition.getSchema());
        SimpleFeatureCollection collection = gml.decodeFeatureCollection(dataset);

        return new FeatureDecoder().decodeFeatureCollection(collection, propertyMapping);
    }

//    private List<SpatialResource> convertSpatialResources(InputStream dataset, SpatialResourcePropertyMappingType propertyMapping) throws IOException, XmlException, XPathExpressionException, ParserConfigurationException, SAXException {
//        List<SpatialResource> result = new ArrayList<>();
//        String namespace = "http://www.kreis-re.de/namespaces/Geofachdaten";
//        String schemaLocation = getClass().getResource("/kreis-re.xsd").toString();
//        Configuration configuration = new ApplicationSchemaConfiguration(namespace, schemaLocation);
//        Parser parser = new Parser(configuration);
//
//        SimpleFeatureCollection fc = (SimpleFeatureCollection) parser.parse(dataset);
//
//
//        FeatureCollectionDocument featureColDoc = FeatureCollectionDocument.Factory.parse(dataset);
//        FeaturePropertyType[] features = featureColDoc.getFeatureCollection2().getFeatureMemberArray();
//
//        List<SpatialResource> result = new ArrayList<>();
//        XPath xPath = XPathFactory.newInstance().newXPath();
//        String expression = "./" + propertyMapping.getIdentifierProperty();
//        FeaturePropertyDocument featurePropDoc = FeaturePropertyDocument.Factory.parse(features[0].newInputStream());
//        for (int i = 0; i < features.length; i++) {
//            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = builderFactory.newDocumentBuilder();
//            Document xmlDocument = builder.parse(features[i].newInputStream());
//            String id = xPath.compile(expression).evaluate(xmlDocument.getFirstChild());
//            System.out.println(id);
//        }
//        return result;
//    }
}


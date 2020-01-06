package org.n52.kommonitor.importer.converter;

import org.geotools.GML;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.n52.kommonitor.importer.decoder.FeatureDecoder;
import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.entities.SpatialResource;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.IndicatorPropertyMappingType;
import org.n52.kommonitor.importer.models.SpatialResourcePropertyMappingType;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class WFSv1Converter extends AbstractConverter {
    private static final String NAME = "org.n52.kommonitor.importer.converter.wfs.v1";
    private static final String MIME_TYPE = "application/xml";
    private static final String WFS_SCHEMA_100 = "http://schemas.opengis.net/wfs/1.0.0/wfs.xsd";
    private static final String WFS_SCHEMA_110 = "http://schemas.opengis.net/wfs/1.1.0/wfs.xsd";
    private static final String DEFAULT_ENCODING = "UTF-8";

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
            throw new ImportParameterException(String.format("The selected schema '%s' is not suported.", schema));
        }
    }

    private List<SpatialResource> convertSpatialResources(ConverterDefinitionType converterDefinition,
                                                          InputStream dataset,
                                                          SpatialResourcePropertyMappingType propertyMapping)
            throws ImportParameterException, ParserConfigurationException, SAXException, IOException {
        GML gml = getGmlParserForSchema(converterDefinition.getSchema());
        gml.setEncoding(Charset.forName(converterDefinition.getEncoding()));
        SimpleFeatureCollection collection = gml.decodeFeatureCollection(dataset);

        return new FeatureDecoder().decodeFeatureCollectionToSpatialResources(collection, propertyMapping);
    }

    private List<IndicatorValue> convertIndicators(ConverterDefinitionType converterDefinition,
                                                   InputStream dataset,
                                                   IndicatorPropertyMappingType propertyMapping)
            throws ImportParameterException, ParserConfigurationException, SAXException, IOException {
        GML gml = getGmlParserForSchema(converterDefinition.getSchema());
        gml.setEncoding(Charset.forName(converterDefinition.getEncoding()));
        SimpleFeatureCollection collection = gml.decodeFeatureCollection(dataset);

        return new FeatureDecoder().decodeFeatureCollectionToIndicatorValues(collection, propertyMapping);
    }

    private InputStream getInputStream(ConverterDefinitionType converterDefinition, Dataset dataset) throws ConverterException {
        InputStream input = null;
        if (dataset.getData() instanceof String) {
            try {
                input = new ByteArrayInputStream(((String) dataset.getData()).getBytes(converterDefinition.getEncoding()));
            } catch (UnsupportedEncodingException ex) {
                throw new ConverterException(String.format("Error while encoding dataset with charset '%s'.",
                        converterDefinition.getEncoding()), ex);
            }
        } else if (dataset.getData() instanceof InputStream) {
            input = (InputStream) dataset.getData();
        } else {
            throw new ConverterException(String.format("Dataset type '%s' is not supported. Supported types are: '%s'",
                    dataset.getData().getClass().getName(),
                    Arrays.toString(new String[]{String.class.getName(), InputStream.class.getName()})));
        }
        return input;
    }
}


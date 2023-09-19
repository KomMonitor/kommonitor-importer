package org.n52.kommonitor.importer.converter;

import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.entities.IndicatorValue;
import org.n52.kommonitor.importer.exceptions.ConverterException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.models.ConverterDefinitionType;
import org.n52.kommonitor.models.ParameterValueType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * An abstract converter that encapsulates definitions of supported format types for a converter
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public abstract class AbstractConverter implements InitializingBean, Converter {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    private String name;

    private Set<String> supportedMimeTypes;

    private Set<String> supportedSchemas;

    private Set<String> supportedEncodings;

    private Set<ConverterParameter> converterParameters;


    @Override
    public String getName() {
        return name;
    }

    /**
     * Validates if the specified {@link ConverterDefinitionType} contains definitions that are supported
     * by a certain converter. If any definition contains values that are not supported, an {@link ImportParameterException}
     * will be thrown.
     *
     * @param converterDefinition contains definition values for the converter
     * @throws ImportParameterException that contains information about the unvalid definition values
     */
    public void validateDefinition(ConverterDefinitionType converterDefinition) throws ImportParameterException {
        StringBuilder builder = new StringBuilder();
        AtomicBoolean isValid = new AtomicBoolean(true);
        if (!supportedMimeTypes.contains(converterDefinition.getMimeType())) {
            isValid.set(false);
            builder.append(String.format("Unsupported MIME type '%s' for converter '%s'. Supported MIME-types are '%s'.",
                    converterDefinition.getMimeType(), getName(), getSupportedMimeTypes()));
            builder.append(System.lineSeparator());
        }
        if (supportedSchemas != null && !supportedSchemas.contains(converterDefinition.getSchema())) {
            isValid.set(false);
            builder.append(String.format("Unsupported schema '%s' for converter '%s'. Supported schemas are '%s'.",
                    converterDefinition.getSchema(), getName(), getSupportedSchemas()));
            builder.append(System.lineSeparator());
        }
        if (!supportedEncodings.contains(converterDefinition.getEncoding())) {
            isValid.set(false);
            builder.append(System.lineSeparator());
            builder.append(String.format("Unsupported encoding '%s' for converter '%s'. Supported encodings are '%s'.",
                    converterDefinition.getEncoding(), getName(), getSupportedEncodings()));
            builder.append(System.lineSeparator());
        }

        converterParameters.forEach(p -> {
            if (p.isMandatory()) {
                boolean validParameter = converterDefinition.getParameters().stream()
                        .anyMatch(pV -> p.getName().equals(pV.getName()) && pV.getValue() != null && !pV.getValue().isEmpty());
                if (!validParameter) {
                    isValid.set(false);
                    builder.append(String.format("Mandatory parameter '%s' is missing.",
                            p.getName()));
                    builder.append(System.lineSeparator());
                }
            }
        });

        if (!isValid.get()) {
            throw new ImportParameterException(builder.substring(0, builder.lastIndexOf(System.lineSeparator())));
        }
    }

    protected InputStream getInputStream(ConverterDefinitionType converterDefinition, Dataset dataset) throws ConverterException {
        InputStream input;
        if (dataset.getData() instanceof String) {
            try {
                input = new ByteArrayInputStream(((String) dataset.getData()).getBytes(converterDefinition.getEncoding()));
            } catch (UnsupportedEncodingException ex) {
                throw new ConverterException(String.format("Error while encoding dataset with charset '%s'.",
                        converterDefinition.getEncoding()), ex);
            }
        } else if (dataset.getData() instanceof InputStream) {
            input = (InputStream) dataset.getData();
        } else if (dataset.getData() instanceof File) {
            try {
                input = new FileInputStream((File) dataset.getData());
            } catch (FileNotFoundException ex) {
                LOG.debug(String.format("Could not create InputStream from file '%s'", ((File) dataset.getData()).getName()), ex);

                throw new ConverterException(String.format("Could not create InputStream from file '%s'", ((File) dataset.getData()).getName()));
            }

        } else {
            throw new ConverterException(String.format("Dataset type '%s' is not supported. Supported types are: '%s'",
                    dataset.getData().getClass().getName(),
                    Arrays.toString(new String[]{String.class.getName(), InputStream.class.getName()})));
        }
        return input;
    }

    public Set<String> getSupportedMimeTypes() {
        return supportedMimeTypes;
    }

    public Set<String> getSupportedSchemas() {
        return supportedSchemas != null ? Collections.unmodifiableSet(supportedSchemas) : null;
    }

    public Set<String> getSupportedEncodings() {
        return supportedEncodings != null ? Collections.unmodifiableSet(supportedEncodings) : null;
    }

    public Set<ConverterParameter> getConverterParameters() {
        return converterParameters != null ? Collections.unmodifiableSet(converterParameters) : null;
    }

    public Optional<String> getParameterValue(String paramName, List<ParameterValueType> parameterValueList) {
        return parameterValueList.stream()
                .filter(p -> p.getName().equals(paramName))
                .findFirst()
                .map(ParameterValueType::getValue);
    }

    /**
     * Groups a List of {@link IndicatorValue} based on common reference key values.
     * The list to group contains several IndicatorValues with the same reference key but different TimeSeriesValues.
     *
     * @param indicatorValueList List of {@link IndicatorValue} that should be grouped
     * @return List of grouped {@link IndicatorValue}
     */
    protected List<IndicatorValue> groupIndicatorValues(List<IndicatorValue> indicatorValueList) {
        Map<String, IndicatorValue> values = new TreeMap<>();
        indicatorValueList.forEach(v -> {
            if (values.containsKey(v.getSpatialReferenceKey())) {
                values.get(v.getSpatialReferenceKey()).getTimeSeriesValueList().addAll(v.getTimeSeriesValueList());
            } else {
                values.put(v.getSpatialReferenceKey(), v);
            }
        });
        return new ArrayList<>(values.values());
    }

    /**
     * Initializes the unique name for the converter
     */
    public abstract String initName();

    /**
     * Initializes the supported MIME-types for the converter
     */
    public abstract Set<String> initSupportedMimeType();

    /**
     * Initializes a set of supported schemas for the converter
     */
    public abstract Set<String> initSupportedSchemas();

    /**
     * Initializes a set of supported encodings for the converter
     */
    public abstract Set<String> initSupportedEncoding();

    /**
     * Initializes the set of additional parameters for the converter
     */
    public abstract Set<ConverterParameter> initConverterParameters();

    @Override
    public void afterPropertiesSet() {
        this.name = initName();
        this.supportedMimeTypes = initSupportedMimeType();
        this.supportedSchemas = initSupportedSchemas();
        this.supportedEncodings = initSupportedEncoding();
        this.converterParameters = initConverterParameters();
    }
}
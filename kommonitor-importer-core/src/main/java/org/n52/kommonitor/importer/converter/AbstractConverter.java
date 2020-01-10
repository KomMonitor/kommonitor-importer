package org.n52.kommonitor.importer.converter;

import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.models.ConverterDefinitionType;
import org.n52.kommonitor.importer.models.ParameterValueType;
import org.springframework.beans.factory.InitializingBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * An abstract converter that encapsulates definitions of supported format types for a converter
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public abstract class AbstractConverter implements InitializingBean, Converter {

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
        boolean isValid = true;
        if (!supportedMimeTypes.contains(converterDefinition.getMimeType())) {
            isValid = false;
            builder.append(String.format("Unsupported MIME type '%s' for converter '%s'. Supported MIME-types are '%s'.",
                    converterDefinition.getMimeType(), getName(), getSupportedMimeTypes()));
        }
        if (!supportedSchemas.contains(converterDefinition.getSchema())) {
            isValid = false;
            builder.append(System.lineSeparator());
            builder.append(String.format("Unsupported schema '%s' for converter '%s'. Supported schemas are '%s'.",
                    converterDefinition.getSchema(), getName(), getSupportedSchemas()));
        }
        if (!supportedEncodings.contains(converterDefinition.getEncoding())) {
            isValid = false;
            builder.append(System.lineSeparator());
            builder.append(String.format("Unsupported encoding '%s' for converter '%s'. Supported encodings are '%s'.",
                    converterDefinition.getEncoding(), getName(), getSupportedEncodings()));
        }
        //TODO validate converterParameters
        // (depends on the possibiility to differentiate between mandatory and optional parameters)

        if (!isValid) {
            throw new ImportParameterException(builder.toString());
        }
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
    public void afterPropertiesSet() throws Exception {
        this.name = initName();
        this.supportedMimeTypes = initSupportedMimeType();
        this.supportedSchemas = initSupportedSchemas();
        this.supportedEncodings = initSupportedEncoding();
        this.converterParameters = initConverterParameters();
    }
}

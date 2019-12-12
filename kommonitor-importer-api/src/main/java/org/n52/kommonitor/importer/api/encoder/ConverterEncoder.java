package org.n52.kommonitor.importer.api.encoder;

import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.ConverterParameter;
import org.n52.kommonitor.importer.models.ConverterType;
import org.n52.kommonitor.importer.models.ParameterType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Helper class for encoding an {@link AbstractConverter} into {@link ConverterType}
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class ConverterEncoder {

    /**
     * Encodes an {@link AbstractConverter} into a corresponding type for API responses
     *
     * @param converter the {@link AbstractConverter} to convert
     * @return the encoded converter as {@link ConverterType}
     */
    public ConverterType encode(AbstractConverter converter) {
        ConverterType converterType = simpleEncode(converter);

        if (converter.getConverterParameters() != null && !converter.getConverterParameters().isEmpty()) {
            converterType.setParameters(converter.getConverterParameters()
                    .stream()
                    .map(this::encodeParameter)
                    .collect(Collectors.toList()));
        }

        return converterType;
    }

    /**
     * Encodes an {@link AbstractConverter} into a corresponding type for API responses without parameters
     *
     * @param converter the {@link AbstractConverter} to convert
     * @return the encoded converter as {@link ConverterType}
     */
    public ConverterType simpleEncode(AbstractConverter converter) {
        ConverterType converterType = new ConverterType();
        converterType.setName(converter.getName());
        converterType.setMimeType(converter.getSupportedMimeType());
        if (converter.getSupportedSchemas() != null && !converter.getSupportedSchemas().isEmpty()) {
            converterType.setSchemas(new ArrayList<>(converter.getSupportedSchemas()));
        }
        if (converter.getSupportedEncodings() != null && !converter.getSupportedEncodings().isEmpty()) {
            converterType.setEncodings(new ArrayList<>(converter.getSupportedEncodings()));
        }
        return converterType;
    }

    /**
     * Encodes an {@link ConverterParameter} into a corresponding type for API responses
     *
     * @param parameter the {@link ConverterParameter} to convert
     * @return the encoded parameters as {@link ParameterType}
     */
    public ParameterType encodeParameter(ConverterParameter parameter) {
        ParameterType paramType = new ParameterType();
        paramType.setName(parameter.getName());
        paramType.setDescription(parameter.getDescription());
        paramType.setType(ParameterType.TypeEnum.valueOf(parameter.getType().name()));
        return paramType;
    }
}

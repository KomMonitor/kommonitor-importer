package org.n52.kommonitor.importer.api.encoder;

import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.ConverterParameters;
import org.n52.kommonitor.importer.models.ConverterParameterType;
import org.n52.kommonitor.importer.models.ConverterType;
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
        ConverterType converterType = new ConverterType();
        converterType.setName(converter.getName());
        converterType.setMimeType(converter.getSupportedMimeType());
        if (converter.getSupportedSchemas() != null && !converter.getSupportedSchemas().isEmpty()) {
            converterType.setSchemas(new ArrayList<>(converter.getSupportedSchemas()));
        }
        if (converter.getSupportedEncodings() != null && !converter.getSupportedEncodings().isEmpty()) {
            converterType.setEncodings(new ArrayList(converter.getSupportedEncodings()));
        }
        if (converter.getConverterParameters() != null && !converter.getConverterParameters().isEmpty()) {
            converterType.setParameters(converter.getConverterParameters()
                    .stream()
                    .map(p -> encodeParameters(p))
                    .collect(Collectors.toList()));
        }

        return converterType;
    }

    /**
     * Encodes an {@link ConverterParameters} into a corresponding type for API responses
     *
     * @param parameters the {@link ConverterParameters} to convert
     * @return the encoded parameters as {@link ConverterParameterType}
     */
    public ConverterParameterType encodeParameters(ConverterParameters parameters) {
        ConverterParameterType paramType = new ConverterParameterType();
        paramType.setName(parameters.getName());
        paramType.setDescription(parameters.getDescription());
        paramType.setType(ConverterParameterType.TypeEnum.valueOf(parameters.getType().name()));
        return paramType;
    }
}

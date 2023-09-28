package org.n52.kommonitor.importer.api.encoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.ConverterParameter;
import org.n52.kommonitor.models.ConverterType;
import org.n52.kommonitor.models.ParameterType;
import org.springframework.stereotype.Component;

import com.rometools.rome.feed.atom.Person;

/**
 * Helper class for encoding an {@link AbstractConverter} into {@link ConverterType}
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
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
            List<ParameterType> parametersList = converter.getConverterParameters()
                    .stream()
                    .map(this::encodeParameter)
                    .collect(Collectors.toList());
            
            // sort list 
            parametersList.sort(new Comparator<ParameterType>(){
         	   @Override
         	   public int compare(final ParameterType lhs, ParameterType rhs) {
         	     //TODO return 1 if rhs should be before lhs 
         	     //     return -1 if lhs should be before rhs
         	     //     return 0 otherwise (meaning the order stays the same)
         		   // check parameter types for being mandatory and sort them alphabetically
         		   if(lhs.getMandatory() && ! rhs.getMandatory()) {
         			   return -1;
         		   }
         		   else if(! lhs.getMandatory() && rhs.getMandatory()) {
         			   return 1;
         		   }
         		   else {
         			   return lhs.getName().compareTo(rhs.getName());
         		   }
         	     }
         	 });
            
			converterType.setParameters(parametersList);            
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
        if (converter.getSupportedMimeTypes() != null && !converter.getSupportedMimeTypes().isEmpty()) {
            converterType.setMimeTypes(new ArrayList<>(converter.getSupportedMimeTypes()));
        }
        if (converter.getSupportedSchemas() != null && !converter.getSupportedSchemas().isEmpty()) {
            converterType.setSchemas(new ArrayList<>(converter.getSupportedSchemas()));
        }
        if (converter.getSupportedEncodings() != null && !converter.getSupportedEncodings().isEmpty()) {
            converterType.setEncodings(new ArrayList<>(converter.getSupportedEncodings()));
        }
        converterType.setDefaultEncoding(converter.getDefaultEncoding());
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
        paramType.setMandatory(parameter.isMandatory());
        return paramType;
    }
}

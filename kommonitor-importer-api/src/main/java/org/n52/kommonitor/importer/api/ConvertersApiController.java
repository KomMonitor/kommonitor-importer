package org.n52.kommonitor.importer.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.n52.kommonitor.importer.api.encoder.ConverterEncoder;
import org.n52.kommonitor.importer.api.utils.ErrorFactory;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.Converter;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.models.ConverterType;
import org.n52.kommonitor.importer.models.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-02T16:59:46.021+01:00")

@Controller
public class ConvertersApiController implements ConvertersApi {

    private static final Logger log = LoggerFactory.getLogger(ConvertersApiController.class);

    @Autowired
    private ConverterRepository converterRepository;

    @Autowired
    private ConverterEncoder encoder;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ConvertersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.request = request;
    }

    public ResponseEntity<ConverterType> getConverterByName(@ApiParam(value = "unique name of the converter", required = true) @PathVariable("name") String name) {
        Optional<AbstractConverter> converterOpt = converterRepository.getConverter(name);
        if (!converterOpt.isPresent()) {
            throw new ResourceNotFoundException(AbstractConverter.class, name);
        }
        return new ResponseEntity<ConverterType>(encoder.encode(converterOpt.get()), HttpStatus.OK);

    }

    public ResponseEntity<List<ConverterType>> getConverters() {
        return new ResponseEntity<List<ConverterType>>(converterRepository.getAll().stream()
                .map(c -> encoder.simpleEncode((AbstractConverter) c))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

}

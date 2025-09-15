package org.n52.kommonitor.importer.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Generated;
import jakarta.servlet.http.HttpServletRequest;
import org.n52.kommonitor.importer.api.encoder.ConverterEncoder;
import org.n52.kommonitor.importer.api.exceptions.ResourceNotFoundException;
import org.n52.kommonitor.importer.converter.AbstractConverter;
import org.n52.kommonitor.importer.converter.ConverterRepository;
import org.n52.kommonitor.models.ConverterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-02T16:59:46.021+01:00")
@BaseController
public class ConvertersApiController implements ConvertersApi {

    private static final Logger LOG = LoggerFactory.getLogger(ConvertersApiController.class);

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

    public ResponseEntity<ConverterType> getConverterByName(
            @Parameter(description = "unique name of the converter", required = true)
            @PathVariable("name") String name) {
        LOG.info("Recevied 'getConverterByName' request for name: {}", name);

        Optional<AbstractConverter> converterOpt = converterRepository.getConverter(name);
        if (converterOpt.isEmpty()) {
            throw new ResourceNotFoundException(AbstractConverter.class, name);
        }
        return new ResponseEntity<ConverterType>(encoder.encode(converterOpt.get()), HttpStatus.OK);

    }

    public ResponseEntity<List<ConverterType>> getConverters() {
        LOG.info("Recevied 'getConverters' request");

        List<ConverterType> list = converterRepository.getAll().stream()
                .map(c -> encoder.simpleEncode((AbstractConverter) c))
                .collect(Collectors.toList());
        list.sort(Comparator.comparing(ConverterType::getName));
		return new ResponseEntity<List<ConverterType>>(list, HttpStatus.OK);
    }

}

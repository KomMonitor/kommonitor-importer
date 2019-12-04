package org.n52.kommonitor.importer.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.n52.kommonitor.importer.api.encoder.DataSourceRetrieverEncoder;
import org.n52.kommonitor.importer.api.utils.ErrorFactory;
import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
import org.n52.kommonitor.importer.models.DataSourceType;
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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-04T14:17:33.692+01:00")

@Controller
public class DatasourceTypesApiController implements DatasourceTypesApi {

    private static final Logger log = LoggerFactory.getLogger(DatasourceTypesApiController.class);

    @Autowired
    private DataSourceRetrieverRepository retrieverRepository;

    @Autowired
    private DataSourceRetrieverEncoder encoder;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DatasourceTypesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.request = request;
    }


    public ResponseEntity<DataSourceType> getSupportedDataSourceTypeByType(@ApiParam(value = "unique type of the datasource", required = true) @PathVariable("type") String type) {
        Optional<AbstractDataSourceRetriever> retrieverOpt = retrieverRepository.getDatasourceRetreiver(type);
        if (!retrieverOpt.isPresent()) {
            Error error = ErrorFactory.getError(HttpStatus.NOT_FOUND.value(), "No support for the specified datasource type: " + type);
            ResponseEntity entity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            return entity;
        }
        return new ResponseEntity<DataSourceType>(encoder.encode(retrieverOpt.get()), HttpStatus.OK);
    }

    public ResponseEntity<List<DataSourceType>> getSupportedDataSourceTypes() {
        return new ResponseEntity<List<DataSourceType>>(retrieverRepository.getAll().stream()
                .map(r -> encoder.simpleEncode(r))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

}

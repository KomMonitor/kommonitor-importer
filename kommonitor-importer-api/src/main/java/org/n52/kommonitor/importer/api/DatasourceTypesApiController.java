package org.n52.kommonitor.importer.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.n52.kommonitor.importer.api.encoder.DataSourceRetrieverEncoder;
import org.n52.kommonitor.importer.api.exceptions.ResourceNotFoundException;
import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.io.datasource.DataSourceRetrieverRepository;
import org.n52.kommonitor.models.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-04T14:17:33.692+01:00")

@BaseController
public class DatasourceTypesApiController implements DatasourceTypesApi {

    private static final Logger LOG = LoggerFactory.getLogger(DatasourceTypesApiController.class);

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
        LOG.info("Recevied 'getSupportedDataSourceTypeByType' request for type: {}", type);

        Optional<AbstractDataSourceRetriever> retrieverOpt = retrieverRepository.getDataSourceRetriever(type);
        if (!retrieverOpt.isPresent()) {
            throw new ResourceNotFoundException(AbstractDataSourceRetriever.class, type);
        }
        return new ResponseEntity<DataSourceType>(encoder.encode(retrieverOpt.get()), HttpStatus.OK);
    }

    public ResponseEntity<List<DataSourceType>> getSupportedDataSourceTypes() {
        LOG.info("Recevied 'getSupportedDataSourceTypes' request");
        
        List<DataSourceType> list = retrieverRepository.getAll().stream()
                .map(r -> encoder.simpleEncode(r))
                .collect(Collectors.toList());
        list.sort(Comparator.comparing(DataSourceType::getType));
		return new ResponseEntity<List<DataSourceType>>(list, HttpStatus.OK);
    }

}

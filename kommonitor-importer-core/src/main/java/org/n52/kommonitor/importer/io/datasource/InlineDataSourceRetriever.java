package org.n52.kommonitor.importer.io.datasource;

import org.n52.kommonitor.importer.models.DataSourceDefinitionType;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Retrieves a dataset from an inline payload within a {@link DataSourceDefinitionType}
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class InlineDataSourceRetriever extends AbstractDataSourceRetriever<String> {

    private static final String TYPE = "INLINE";
    public static final String PARAM_PAYLOAD = "payload";
    public static final String PARAM_PAYLOAD_DESC = "The payload as plain text";

    @Override
    protected String initType() {
        return TYPE;
    }

    @Override
    protected Set<DataSourceParameter> initSupportedConverterParameters() {
        Set<DataSourceParameter> parameters = new HashSet<>();
        DataSourceParameter payloadParam = new DataSourceParameter(PARAM_PAYLOAD, PARAM_PAYLOAD_DESC, DataSourceParameter.ParameterTypeValues.STRING);
        parameters.add(payloadParam);
        return parameters;
    }

    @Override
    public Dataset<String> retrieveDataset(DataSourceDefinitionType datasource) throws DataSourceRetrieverException {
        Optional<String> payload = this.getParameterValue(PARAM_PAYLOAD, datasource.getParameters());
        if (!payload.isPresent()) {
            throw new DataSourceRetrieverException("Could not find parameter: " + PARAM_PAYLOAD);
        }
        return new Dataset<String>(payload.get());
    }
}

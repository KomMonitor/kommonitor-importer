package org.n52.kommonitor.importer.api.encoder;

import org.n52.kommonitor.importer.io.datasource.AbstractDataSourceRetriever;
import org.n52.kommonitor.importer.io.datasource.DataSourceParameter;
import org.n52.kommonitor.models.DataSourceType;
import org.n52.kommonitor.models.ParameterType;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class DataSourceRetrieverEncoder {

    /**
     * Encodes an {@link AbstractDataSourceRetriever} into a corresponding type for API responses
     *
     * @param retriever the {@link AbstractDataSourceRetriever} to convert
     * @return the encoded retriever as {@link DataSourceType}
     */
    public DataSourceType encode(AbstractDataSourceRetriever retriever) {
        DataSourceType dataSourceType = simpleEncode(retriever);

        if (retriever.getDataSourceParameters() != null && !retriever.getDataSourceParameters().isEmpty()) {
            Set<DataSourceParameter> parameters = retriever.getDataSourceParameters();
            List<ParameterType> list = parameters.stream()
                    .map(this::encodeParameters)
                    .collect(Collectors.toList());
            list.sort(Comparator.comparing(ParameterType::getName));
			dataSourceType.setParameters(list);
        }

        return dataSourceType;
    }

    /**
     * Encodes an {@link AbstractDataSourceRetriever} into a corresponding type for API responses
     * without parameters.
     *
     * @param retriever the {@link AbstractDataSourceRetriever} to convert
     * @return the encoded retriever as {@link DataSourceType}
     */
    public DataSourceType simpleEncode(AbstractDataSourceRetriever retriever) {
        DataSourceType dataSourceType = new DataSourceType();
        dataSourceType.setType(DataSourceType.TypeEnum.valueOf(retriever.getType()));

        return dataSourceType;
    }

    /**
     * Encodes a {@link DataSourceParameter} into a corresponding type for API responses
     *
     * @param parameter the {@link DataSourceParameter} to convert
     * @return the encoded parameters as {@link ParameterType}
     */
    public ParameterType encodeParameters(DataSourceParameter parameter) {
        ParameterType paramType = new ParameterType();
        paramType.setName(parameter.getName());
        paramType.setDescription(parameter.getDescription());
        paramType.setType(ParameterType.TypeEnum.valueOf(parameter.getType().name()));
        return paramType;
    }
}

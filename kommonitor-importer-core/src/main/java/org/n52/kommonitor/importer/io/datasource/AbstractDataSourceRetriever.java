package org.n52.kommonitor.importer.io.datasource;

import org.n52.kommonitor.models.ParameterValueType;
import org.springframework.beans.factory.InitializingBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * An abstract data source retriever that encapsulates definitions for supported data source types
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public abstract class AbstractDataSourceRetriever<T> implements DataSourceRetriever<T>, InitializingBean {

    private String type;

    private Set<DataSourceParameter> dataSourceParameters;

    public String getType() {
        return type;
    }

    public Set<DataSourceParameter> getDataSourceParameters() {
        return dataSourceParameters != null ? Collections.unmodifiableSet(dataSourceParameters) : null;
    }

    public Optional<String> getParameterValue(String paramName, List<ParameterValueType> parameterValueList) {
        return parameterValueList.stream()
                .filter(p -> p.getName().equals(paramName))
                .findFirst()
                .map(ParameterValueType::getValue);
    }

    public Optional<Integer> getParameterIntegerValue(String paramName, List<ParameterValueType> parameterValueList) {
        return getParameterValue(paramName, parameterValueList).map(Integer::parseInt);
    }

    public Optional<Float> getParameterFloatValue(String paramName, List<ParameterValueType> parameterValueList) {
        return getParameterValue(paramName, parameterValueList).map(Float::parseFloat);
    }

    public Optional<Boolean> getParameterBooleanValue(String paramName, List<ParameterValueType> parameterValueList) {
        return getParameterValue(paramName, parameterValueList).map(Boolean::parseBoolean);
    }

    protected abstract String initType();

    protected abstract Set<DataSourceParameter> initSupportedParameters();

    @Override
    public void afterPropertiesSet() throws Exception {
        type = initType();
        dataSourceParameters = initSupportedParameters();
    }

}

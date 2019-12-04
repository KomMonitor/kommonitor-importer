package org.n52.kommonitor.importer.io.datasource;

import org.n52.kommonitor.importer.models.ParameterType;
import org.n52.kommonitor.importer.models.ParameterValueType;
import org.springframework.beans.factory.InitializingBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * An abstract data source retriever that encapsulates definitions for supported data source types
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
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
                .map(p -> p.getValue());
    }

    public Optional<Integer> getParameterIntegerValue(String paramName, List<ParameterValueType> parameterValueList) {
        return getParameterValue(paramName, parameterValueList).map(p -> Integer.parseInt(p));
    }

    public Optional<Float> getParameterFloatValue(String paramName, List<ParameterValueType> parameterValueList) {
        return getParameterValue(paramName, parameterValueList).map(p -> Float.parseFloat(p));
    }

    public Optional<Boolean> getParameterBooleanValue(String paramName, List<ParameterValueType> parameterValueList) {
        return getParameterValue(paramName, parameterValueList).map(p -> Boolean.parseBoolean(p));
    }

    protected abstract String initType();

    protected abstract Set<DataSourceParameter> initSupportedConverterParameters();

    @Override
    public void afterPropertiesSet() throws Exception {
        type = initType();
        dataSourceParameters = initSupportedConverterParameters();
    }

}

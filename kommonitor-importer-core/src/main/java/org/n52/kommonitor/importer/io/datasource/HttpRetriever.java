package org.n52.kommonitor.importer.io.datasource;

import org.n52.kommonitor.importer.entities.Dataset;
import org.n52.kommonitor.importer.exceptions.DataSourceRetrieverException;
import org.n52.kommonitor.importer.exceptions.ImportParameterException;
import org.n52.kommonitor.importer.io.http.HttpHelper;
import org.n52.kommonitor.models.DataSourceDefinitionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Retriever for remote datasets that can be requested with a HTTP GET.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class HttpRetriever extends AbstractDataSourceRetriever<InputStream> {

    private static final Logger LOG = LoggerFactory.getLogger(HttpRetriever.class);

    private static final String TYPE = "HTTP";
    private static final String PARAM_URL = "URL";
    private static final String PARAM_URL_DESC = "An URL that references a dataset. " +
            "The dataset will be retrieved with a HTTP GET request for that URL.";
    private final HttpHelper httpHelper;

    @Value("${proxy.host:#{null}}")
    protected String proxyHost;

    @Value("${proxy.port:#{null}}")
    protected Integer proxyPort;

    public HttpRetriever() throws IOException {
        if (getProxyHost() != null && getProxyPort() != null) {
            httpHelper = HttpHelper.getProxyHttpHelper(getProxyHost(), getProxyPort());
        } else {
            httpHelper = HttpHelper.getBasicHttpHelper();
        }
    }

    @Override
    protected String initType() {
        return TYPE;
    }

    @Override
    protected Set<DataSourceParameter> initSupportedParameters() {
        Set<DataSourceParameter> parameters = new HashSet<>();
        DataSourceParameter payloadParam = new DataSourceParameter(PARAM_URL, PARAM_URL_DESC, DataSourceParameter.ParameterTypeValues.STRING);
        parameters.add(payloadParam);
        return parameters;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    @Override
    public Dataset<InputStream> retrieveDataset(DataSourceDefinitionType datasource) throws DataSourceRetrieverException, ImportParameterException {
        Optional<String> urlOpt = this.getParameterValue(PARAM_URL, datasource.getParameters());
        if (urlOpt.isEmpty()) {
            throw new ImportParameterException("Missing parameter: " + PARAM_URL);
        }
        try {
            byte[] response = httpHelper.executeHttpGetRequest(urlOpt.get());
            return new Dataset<>(new ByteArrayInputStream(response));
        } catch (IOException ex) {
            LOG.debug(String.format("Failed retrieving dataset for datasource: %n%s", datasource), ex);
            throw new DataSourceRetrieverException(String.format("Failed retrieving dataset from URL '%s'", urlOpt.get()), ex);
        }
    }
}

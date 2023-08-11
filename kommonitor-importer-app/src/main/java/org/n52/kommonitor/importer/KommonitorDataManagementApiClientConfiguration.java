package org.n52.kommonitor.importer;

import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("kommonitor.importer")
public class KommonitorDataManagementApiClientConfiguration implements InitializingBean {

    @Autowired
    public ApiClient client;

    private String dataManagementApiUrl;

    public String getDataManagementApiUrl() {
        return dataManagementApiUrl;
    }

    public void setDataManagementApiUrl(String dataManagementApiUrl) {
        this.dataManagementApiUrl = dataManagementApiUrl;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        client.setBasePath(getDataManagementApiUrl());
    }
}

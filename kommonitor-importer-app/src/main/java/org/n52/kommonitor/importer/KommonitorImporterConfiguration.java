package org.n52.kommonitor.importer;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Provider for KomMonitor Importer App configurations
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Configuration
public class KommonitorImporterConfiguration {

    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public void setBuilder(RestTemplateBuilder builder) {
        this.restTemplateBuilder = builder;
    }

    @Bean
    public RestTemplate configureDataAccessService() {

        List<Header> defaultHeaders = Arrays.asList(
                new BasicHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE),
                new BasicHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectTimeout(1000)
                .build();

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setDefaultHeaders(defaultHeaders)
                .build();

        return restTemplateBuilder
                .requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient))
                .build();
    }


}

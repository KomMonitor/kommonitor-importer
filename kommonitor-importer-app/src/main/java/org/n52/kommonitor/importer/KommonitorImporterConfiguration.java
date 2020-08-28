package org.n52.kommonitor.importer;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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

//      List<Header> defaultHeaders = Arrays.asList(
//      new BasicHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE),
//      new BasicHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
    	
    	// remove CONTENT_TYPE header as in some scenarios it lead to duplicate header value
    	// thus failing requst to KomMOnitor management component due to invalid content-type header
    	List<Header> defaultHeaders = Arrays.asList(
    			new BasicHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE));

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectTimeout(300000)
                .setSocketTimeout(300000)
                .setConnectionRequestTimeout(300000)
                .build();

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setDefaultHeaders(defaultHeaders)
                .build();

        return restTemplateBuilder
                .requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient))
                .build();
    }
    
    @Bean
    public FilterRegistrationBean corsFilter() {
      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.addAllowedOrigin("*"); // @Value: http://localhost:8080
      config.addAllowedHeader("*");
      config.addAllowedMethod("*");
      source.registerCorsConfiguration("/**/*", config);
      FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
      bean.setOrder(0);
      return bean;
    }


}

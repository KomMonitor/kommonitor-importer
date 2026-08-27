package org.n52.kommonitor.importer;

import org.n52.kommonitor.datamanagement.api.ApiClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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

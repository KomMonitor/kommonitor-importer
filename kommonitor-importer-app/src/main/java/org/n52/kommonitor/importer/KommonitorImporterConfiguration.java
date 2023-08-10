package org.n52.kommonitor.importer;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${keycloak.enabled}")
    private boolean keycloakEnabled;

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
                .setResponseTimeout(5, TimeUnit.MINUTES)
                .setConnectionRequestTimeout(5, TimeUnit.MINUTES)
                .build();

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setDefaultHeaders(defaultHeaders)
                .build();

        RestTemplate restTemplate = restTemplateBuilder
                .requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient))
                .build();

        if (keycloakEnabled) {
            restTemplate.getInterceptors().add(createAuthInterceptor());
        }

        return restTemplate;
    }

    private ClientHttpRequestInterceptor createAuthInterceptor(){
        return (request, body, execution) -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null) {
                return execution.execute(request, body);
            }

            if (!(authentication.getCredentials() instanceof AbstractOAuth2Token token)) {
                return execution.execute(request, body);
            }

            request.getHeaders().setBearerAuth(token.getTokenValue());
            return execution.execute(request, body);
        };
    }
    
    @Bean
    public FilterRegistrationBean corsFilter() {
      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
//      config.setAllowCredentials(true);
      config.addAllowedOrigin("*"); // @Value: http://localhost:8080
      config.addAllowedHeader("*");
      config.addAllowedMethod("*");
      source.registerCorsConfiguration("/**", config);
      FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
      bean.setOrder(0);
      return bean;
    }


}

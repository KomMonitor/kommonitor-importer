package org.n52.kommonitor.importer.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Value("${kommonitor.importer.allowed-cors-origins}")
    private String[] allowedOrigins;

    @Bean
    @ConditionalOnProperty(
            value="keycloak.enabled",
            havingValue = "true",
            matchIfMissing = false)
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(sessions -> sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/swagger-ui/*")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/swagger-ui.html")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/v3/api-docs")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/swagger-config")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/specs/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/**")).authenticated()
                        .anyRequest().denyAll()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));
        return http.build();
    }

    @Bean
    @ConditionalOnProperty(
            value="keycloak.enabled",
            havingValue = "false",
            matchIfMissing = false)
    SecurityFilterChain unsecuredFilterChain(final HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().permitAll()
                )
                .build();
    }

    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(allowedOrigins));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}

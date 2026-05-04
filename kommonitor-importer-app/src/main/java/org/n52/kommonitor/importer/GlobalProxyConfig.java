package org.n52.kommonitor.importer;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtIssuerValidator;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalProxyConfig {

    private static final Logger log = LoggerFactory.getLogger(GlobalProxyConfig.class);

    @Value("${proxy.host:#{null}}")
    private String proxyHost;

    @Value("${proxy.port:#{null}}")
    private Integer proxyPort;

    @Value("${proxy.user:#{null}}")
    private String proxyUser;

    @Value("${proxy.password:#{null}}")
    private String proxyPassword;
    
    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri:#{null}}")
    private String jwkSetUri;
    
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri:#{null}}")
    private String issuerUri;
    
    private Set<Pattern> nonProxyPatterns;
    
    @PostConstruct
    public void init() {
        // Erst die Hosts mergen und System Properties setzen
        setupSystemProperties();
        // Dann sofort die Patterns daraus generieren
        setupNonProxyPatterns();
    }
    
    private void setupSystemProperties() {
        if (proxyHost != null && proxyPort != null) {
            log.info("Initializing global JVM proxy settings: {}:{}", proxyHost, proxyPort);
            
            String existingHosts = System.getProperty("http.nonProxyHosts");
            Set<String> hosts = new HashSet<>(Arrays.asList(
                "localhost", "127.0.0.1", "host.docker.internal", 
                "kommonitor-data-management", "data-management", "*management"
            ));

            if (existingHosts != null && !existingHosts.isEmpty()) {
                Arrays.stream(existingHosts.split("\\|"))
                      .map(String::trim)
                      .filter(s -> !s.isEmpty())
                      .forEach(hosts::add);
            }

            String combinedHosts = String.join("|", hosts);
            System.setProperty("http.nonProxyHosts", combinedHosts);
            System.setProperty("https.nonProxyHosts", combinedHosts);
        	
            System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
            System.setProperty("http.proxyHost", proxyHost);
            System.setProperty("http.proxyPort", String.valueOf(proxyPort));
            System.setProperty("https.proxyHost", proxyHost);
            System.setProperty("https.proxyPort", String.valueOf(proxyPort));
            
            if (proxyUser != null && proxyPassword != null) {
                Authenticator.setDefault(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        // Explizite Prüfung: Nur für Proxies!
                        if (getRequestorType() == RequestorType.PROXY) {
                            return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
                        }
                        return null; 
                    }
                });
            }
        }
    }

    private void setupNonProxyPatterns() {
        String systemNonProxy = System.getProperty("http.nonProxyHosts", "");
        this.nonProxyPatterns = Arrays.stream(systemNonProxy.split("\\|"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(host -> host.replace(".", "\\.").replace("*", ".*"))
                .map(regex -> Pattern.compile("^" + regex + "$", Pattern.CASE_INSENSITIVE))
                .collect(Collectors.toSet());
                
        log.info("Initialized Proxy Bypass for hosts: {}", systemNonProxy);
    }
    
    private boolean isInternal(String host) {
        if (host == null || host.isEmpty()) return false;
        
        // Prüft, ob der Host gegen eines der Patterns matcht
        return nonProxyPatterns.stream().anyMatch(pattern -> pattern.matcher(host).matches());
    }
    
    @Bean
    @Primary
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
    	// (wir müsen berücksichtigen, dass Imorter intern Data Management aufruft)
    	// dies muss ohne proxy und ohne proxy headers erfolgen
    	
        // 1. HttpClient OHNE Authenticator bauen 
        HttpClient.Builder httpClientBuilder = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .proxy(new ProxySelector() {
                    @Override
                    public List<Proxy> select(URI uri) {
                        if (isInternal(uri.getHost())) {
                            return List.of(Proxy.NO_PROXY);
                        }
                        return List.of(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)));
                    }

                    @Override
                    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                        log.error("Proxy connection failed for {}", uri, ioe);
                    }
                });

        // 2. RequestFactory erstellen
        JdkClientHttpRequestFactory requestFactory = new JdkClientHttpRequestFactory(httpClientBuilder.build());

        // 3. Den Interceptor so bauen, dass er Proxy- UND Bearer-Auth sauber trennt
        return builder
                .requestFactory(() -> requestFactory)
                .additionalInterceptors((request, body, execution) -> {
                    String host = request.getURI().getHost();

                    // A) Immer den Bearer Token für den Ziel-Service setzen
                    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                    if (auth instanceof JwtAuthenticationToken jwt) {
                        request.getHeaders().setBearerAuth(jwt.getToken().getTokenValue());
                        log.debug("Setting Bearer Auth for request to {}", host);
                    }

                    // B) NUR wenn es EXTERN ist, manuell Proxy-Auth setzen
                    if (!isInternal(host) && proxyUser != null) {
                        String authStr = proxyUser + ":" + proxyPassword;
                        String encodedAuth = java.util.Base64.getEncoder().encodeToString(authStr.getBytes());
                        request.getHeaders().set("Proxy-Authorization", "Basic " + encodedAuth);
                        log.debug("Setting Proxy-Authorization for external request to {}", host);
                    }

                    return execution.execute(request, body);
                })
                .build();
    }
    
    @Bean
    public JwtDecoder jwtDecoder() {
    	NimbusJwtDecoder jwtDecoder = null;
		
    	// 1. Basis-Decoder mit der JWK-Set-URI erstellen
        if (proxyHost != null && !proxyHost.isEmpty() && proxyPort != null) {
            log.info("Configuring JwtDecoder to use Proxy {}:{}", proxyHost, proxyPort);
            
            HttpClient.Builder httpClientBuilder = HttpClient.newBuilder()
                    .proxy(ProxySelector.of(new InetSocketAddress(proxyHost, proxyPort)));

            if (proxyUser != null && !proxyUser.isEmpty()) {
                log.info("Proxy authentication enabled for user: {}", proxyUser);
                httpClientBuilder.authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
                    }
                });
            }

            JdkClientHttpRequestFactory requestFactory = new JdkClientHttpRequestFactory(httpClientBuilder.build());
            RestTemplate restTemplate = new RestTemplate(requestFactory);
            
            // WICHTIG: Verbessertes Error Handling für den Zertifikats-Abruf
            restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
                public void handleError(java.io.IOException e) {
                    log.error("Failed to fetch JWKS from {} via Proxy. Check proxy credentials and connectivity.", jwkSetUri, e);
                }
            });

            jwtDecoder = NimbusJwtDecoder.withJwkSetUri(jwkSetUri)
                    .restOperations(restTemplate)
                    .build();
        }
        else {
        	log.info("No proxy configured for JwtDecoder. Using direct connection to {}", jwkSetUri);
            jwtDecoder = NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
        }
        
     // 2. Optionale Validatoren vorbereiten
        OAuth2TokenValidator<Jwt> defaultValidator = JwtValidators.createDefault();

        if (issuerUri != null && !issuerUri.isEmpty()) {
            log.info("Adding optional Issuer validation for URI: {}", issuerUri);
            
            // Erstellt einen kombinierten Validator (Timestamp + Issuer)
            OAuth2TokenValidator<Jwt> issuerValidator = new JwtIssuerValidator(issuerUri);
            OAuth2TokenValidator<Jwt> combinedValidator = new DelegatingOAuth2TokenValidator<>(defaultValidator, issuerValidator);
            
            jwtDecoder.setJwtValidator(combinedValidator);
        } else {
            log.warn("No issuer-uri provided. JWT issuer validation is DISABLED!");
            jwtDecoder.setJwtValidator(defaultValidator);
        }
        
        return jwtDecoder; 

        
    }

    
}
package io.swagger.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.*;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

import java.util.Arrays;
import java.util.List;

/**
 * OAuth2 enabled configuration or Swagger-UI
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Configuration
@ConditionalOnProperty(value = "keycloak.enabled", havingValue = "true")
public class SwaggerSecurityConfig {

    @Value("${keycloak.auth-server-url}")
    private String AUTH_SERVER;

    @Value("${keycloak.realm}")
    private String REALM;

    @Value("${kommonitor.swagger-ui.security.client-id}")
    private String CLIENT_ID;

    @Value("${kommonitor.swagger-ui.security.secret}")
    private String SECRET;

    @Value("${kommonitor.swagger-ui.server}")
    private String SERVER;

    private static final String TITLE = "KomMonitor Data Import API";
    private static final String DESCRIPTION = "Import API to enable the import of spatial KomMonitor data (SpatialUnits," +
            " Georesources and Indicators) from various datasources.";
    private static final String LICENSE = "Apache 2.0";
    private static final String LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0.html";
    private static final String VERSION = "0.0.1";
    private static final String EMAIL = "s.drost@52north.org";
    private static final String GROUP_NAME = "kommonitor-importer";
    private static final String OAUTH_NAME = "spring_oauth";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url(SERVER))
                .components(new Components().addSecuritySchemes(OAUTH_NAME, createOAuthScheme()))
                .addSecurityItem(new SecurityRequirement().addList(OAUTH_NAME))
                .info(new Info()
                        .title(TITLE)
                        .description(DESCRIPTION)
                        .license(new License().name(LICENSE).url(LICENSE_URL))
                        .termsOfService("")
                        .version(VERSION)
                        .contact(new io.swagger.v3.oas.models.info.Contact().email(EMAIL)));
    }

    private SecurityScheme createOAuthScheme() {
        OAuthFlows flows = createOAuthFlows();
        return new SecurityScheme().type(SecurityScheme.Type.OAUTH2)
                .flows(flows);
    }

    private OAuthFlows createOAuthFlows() {
        OAuthFlow flow = createAuthorizationCodeFlow();
        return new OAuthFlows().authorizationCode(flow);
    }


    private OAuthFlow createAuthorizationCodeFlow() {
        return new OAuthFlow()
                .authorizationUrl(String.format("%s/realms/%s/protocol/openid-connect/auth", AUTH_SERVER, REALM))
                .tokenUrl(String.format("%s/realms/%s/protocol/openid-connect/token", AUTH_SERVER, REALM))
                .scopes(scopes());
    }

    private Scopes scopes() {
        return new Scopes();
    }

}

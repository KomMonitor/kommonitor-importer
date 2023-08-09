package io.swagger.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-18T13:37:04.985+01:00")

@Configuration
@ConditionalOnProperty(value = "keycloak.enabled", havingValue = "false")
public class SwaggerDocumentationConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("KomMonitor Data Import API")
                        .description("Import API to enable the import of spatial KomMonitor data (SpatialUnits, Georesources and Indicators) from various datasources.")
                        .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                        .termsOfService("TERMS_OF_SERVICE_URL")
                        .version("0.0.1")
                        .contact(new Contact().email("s.drost@52north.org")));
    }

}

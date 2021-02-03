package org.n52.kommonitor.importer;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;

public class KeycloakRestTemplateCustomizer implements RestTemplateCustomizer {

	private final KeycloakInterceptor keycloakInterceptor;

	public KeycloakRestTemplateCustomizer() {
		this(new KeycloakInterceptor());
	}

	protected KeycloakRestTemplateCustomizer(KeycloakInterceptor keycloakInterceptor) {
		this.keycloakInterceptor = keycloakInterceptor;
	}

	@Override
	public void customize(RestTemplate restTemplate) {
		restTemplate.getInterceptors().add(keycloakInterceptor);
	}
}

package org.kogito.dashbuilder.client;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.kogito.dashbuilder.Configuration;

public class KieServerClientProducer {

    @Inject
    Configuration configuration;

    @Produces
    @ApplicationScoped
    public KieServerClient produce() {
        var uriStr = configuration.url()
                .orElseThrow(() -> new IllegalArgumentException("Configuration URL is required."));
        var uri = URI.create(uriStr);
        return RestClientBuilder.newBuilder()
                .baseUri(uri)
                .build(KieServerClient.class);
    }

}

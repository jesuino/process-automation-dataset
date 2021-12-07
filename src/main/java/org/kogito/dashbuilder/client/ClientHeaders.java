package org.kogito.dashbuilder.client;

import java.nio.charset.StandardCharsets;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.kogito.dashbuilder.Configuration;

@ApplicationScoped
public class ClientHeaders implements ClientHeadersFactory {

    private static final String AUTHORIZATION = "Authorization";
    @Inject
    Configuration configuration;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders,
                                                 MultivaluedMap<String, String> outgoingHeaders) {
        var result = new MultivaluedHashMap<String, String>();
        addSecurity(result);
        return result;
    }

    private void addSecurity(MultivaluedMap<String, String> headers) {
        configuration.user().ifPresent(user -> {
            var password = configuration.password().orElse("");
            var auth = user + ":" + password;
            var encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
            headers.add(AUTHORIZATION, "basic " + new String(encodedAuth));
        });
        
        configuration.token().ifPresent(token -> {
            headers.add(AUTHORIZATION, "bearer " + token);
        });
    }

}

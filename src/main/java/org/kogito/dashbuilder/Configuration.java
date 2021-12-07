package org.kogito.dashbuilder;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class Configuration {

    @ConfigProperty(name = "automation.server.url")
    Optional<String> url;

    @ConfigProperty(name = "automation.server.user", defaultValue = "!")
    Optional<String> user;

    @ConfigProperty(name = "automation.server.password")
    Optional<String> password;

    @ConfigProperty(name = "automation.server.token")
    Optional<String> token;

    public Optional<String> url() {
        return url;
    }

    public Optional<String> user() {
        return user;
    }

    public Optional<String> password() {
        return password;
    }

    public Optional<String> token() {
        return token;
    }

}

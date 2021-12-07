package org.kogito.dashbuilder.model.ks;

import java.util.Date;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DateValue(@JsonProperty("java.util.Date") Date value) {

    public static String toString(DateValue value) {
        return Optional.ofNullable(value).map(v -> v.value.toInstant().toString()).orElse("");
    }

}

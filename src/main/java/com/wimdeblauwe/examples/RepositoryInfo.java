package com.wimdeblauwe.examples;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.ReflectiveAccess;

@Introspected
@ReflectiveAccess
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryInfo {
    private final String name;
    private final String description;

    @JsonCreator
    public RepositoryInfo(@JsonProperty("name") String name,
                          @JsonProperty("description") String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

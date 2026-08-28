package com.nexusmarket.domain.model;

import java.util.Map;
import java.util.Objects;

public class ProductVariant {
    private final String identifier;
    private final String name;
    private final Map<String, String> attributes;

    public ProductVariant(String identifier, String name, Map<String, String> attributes) {
        this.identifier = Objects.requireNonNull(identifier);
        this.name = Objects.requireNonNull(name);
        this.attributes = Map.copyOf(attributes == null ? Map.of() : attributes);
    }

    public String getIdentifier() { return identifier; }
    public String getName() { return name; }
    public Map<String, String> getAttributes() { return attributes; }
}

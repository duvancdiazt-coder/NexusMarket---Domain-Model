package com.nexusmarket.domain.valueobject;

import java.util.Objects;

public abstract class DomainCatalog {
    private final String code;
    private final String name;
    private final String description;

    protected DomainCatalog(String code, String name, String description) {
        this.code = Objects.requireNonNull(code);
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DomainCatalog other)) return false;
        return code.equals(other.code);
    }

    @Override
    public int hashCode() { return code.hashCode(); }
}

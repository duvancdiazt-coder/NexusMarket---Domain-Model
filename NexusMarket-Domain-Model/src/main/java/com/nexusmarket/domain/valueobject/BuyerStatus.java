package com.nexusmarket.domain.valueobject;

import java.util.Objects;

public final class BuyerStatus extends DomainCatalog {
    private BuyerStatus(String code, String name, String description) {
        super(code, name, description);
    }

    public static BuyerStatus of(String code, String name, String description) {
        return new BuyerStatus(
                Objects.requireNonNull(code),
                Objects.requireNonNull(name),
                Objects.requireNonNull(description)
        );
    }
}

package com.nexusmarket.domain.valueobject;

import java.util.Objects;

public final class SellerStatus extends DomainCatalog {
    private SellerStatus(String code, String name, String description) {
        super(code, name, description);
    }

    public static SellerStatus of(String code, String name, String description) {
        return new SellerStatus(
                Objects.requireNonNull(code),
                Objects.requireNonNull(name),
                Objects.requireNonNull(description)
        );
    }
}

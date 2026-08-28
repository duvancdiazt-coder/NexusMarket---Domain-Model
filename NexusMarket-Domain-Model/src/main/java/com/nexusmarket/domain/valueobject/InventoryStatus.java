package com.nexusmarket.domain.valueobject;

import java.util.Objects;

public final class InventoryStatus extends DomainCatalog {
    public static final InventoryStatus DAMAGED =
            new InventoryStatus("DAMAGED", "Damaged", "Inventory that cannot be reserved.");

    private InventoryStatus(String code, String name, String description) {
        super(code, name, description);
    }

    public static InventoryStatus of(String code, String name, String description) {
        return new InventoryStatus(
                Objects.requireNonNull(code),
                Objects.requireNonNull(name),
                Objects.requireNonNull(description)
        );
    }
}

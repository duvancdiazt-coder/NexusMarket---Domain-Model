package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.DomainCatalog;

import java.util.Objects;

public class InventoryMovement {
    private final String identifier;
    private final DomainCatalog type;
    private final int quantity;
    private final Inventory inventory;
    private final User performedBy;

    public InventoryMovement(String identifier, DomainCatalog type, int quantity,
                             Inventory inventory, User performedBy) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Movement quantity must be positive");
        }
        this.identifier = Objects.requireNonNull(identifier);
        this.type = Objects.requireNonNull(type);
        this.quantity = quantity;
        this.inventory = Objects.requireNonNull(inventory);
        this.performedBy = Objects.requireNonNull(performedBy);
    }

    public String getIdentifier() { return identifier; }
    public DomainCatalog getType() { return type; }
    public int getQuantity() { return quantity; }
    public Inventory getInventory() { return inventory; }
    public User getPerformedBy() { return performedBy; }
}

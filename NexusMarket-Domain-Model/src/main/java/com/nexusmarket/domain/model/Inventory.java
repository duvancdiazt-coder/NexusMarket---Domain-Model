package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.DomainCatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    private final String identifier;
    private final Product product;
    private final Warehouse warehouse;
    private int availableQuantity;
    private int reservedQuantity;
    private final DomainCatalog status;
    private final List<InventoryMovement> movements;

    public Inventory(String identifier, Product product, Warehouse warehouse,
                     int availableQuantity, int reservedQuantity, DomainCatalog status) {
        if (availableQuantity < 0 || reservedQuantity < 0) {
            throw new IllegalArgumentException("Inventory quantities cannot be negative");
        }
        this.identifier = Objects.requireNonNull(identifier);
        this.product = Objects.requireNonNull(product);
        this.warehouse = Objects.requireNonNull(warehouse);
        this.availableQuantity = availableQuantity;
        this.reservedQuantity = reservedQuantity;
        this.status = Objects.requireNonNull(status);
        this.movements = new ArrayList<>();
    }

    public String getIdentifier() { return identifier; }
    public Product getProduct() { return product; }
    public Warehouse getWarehouse() { return warehouse; }
    public int getAvailableQuantity() { return availableQuantity; }
    public int getReservedQuantity() { return reservedQuantity; }
    public DomainCatalog getStatus() { return status; }
    public List<InventoryMovement> getMovements() { return List.copyOf(movements); }

    public void addMovement(InventoryMovement movement) {
        movements.add(Objects.requireNonNull(movement));
    }
}

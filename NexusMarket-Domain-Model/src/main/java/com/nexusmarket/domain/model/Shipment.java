package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.DomainCatalog;

import java.time.LocalDateTime;
import java.util.Objects;

public class Shipment {
    private final String identifier;
    private final Order order;
    private final Warehouse warehouse;
    private final DomainCatalog status;
    private final LocalDateTime shipmentDate;
    private final LocalDateTime deliveryDate;

    public Shipment(String identifier, Order order, Warehouse warehouse,
                    DomainCatalog status, LocalDateTime shipmentDate,
                    LocalDateTime deliveryDate) {
        this.identifier = Objects.requireNonNull(identifier);
        this.order = Objects.requireNonNull(order);
        this.warehouse = Objects.requireNonNull(warehouse);
        this.status = Objects.requireNonNull(status);
        this.shipmentDate = shipmentDate;
        this.deliveryDate = deliveryDate;
    }

    public String getIdentifier() { return identifier; }
    public Order getOrder() { return order; }
    public Warehouse getWarehouse() { return warehouse; }
    public DomainCatalog getStatus() { return status; }
    public LocalDateTime getShipmentDate() { return shipmentDate; }
    public LocalDateTime getDeliveryDate() { return deliveryDate; }
}

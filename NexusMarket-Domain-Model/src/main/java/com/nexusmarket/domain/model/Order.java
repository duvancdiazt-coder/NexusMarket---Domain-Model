package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.DomainCatalog;
import com.nexusmarket.domain.valueobject.Money;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private final String identifier;
    private final Buyer buyer;
    private final List<OrderItem> items;
    private final Money total;
    private final DomainCatalog status;
    private final LocalDateTime creationDate;

    public Order(String identifier, Buyer buyer, List<OrderItem> items,
                 Money total, DomainCatalog status, LocalDateTime creationDate) {
        this.identifier = Objects.requireNonNull(identifier);
        this.buyer = Objects.requireNonNull(buyer);
        this.items = new ArrayList<>(items == null ? List.of() : items);
        this.total = Objects.requireNonNull(total);
        this.status = Objects.requireNonNull(status);
        this.creationDate = Objects.requireNonNull(creationDate);
    }

    public String getIdentifier() { return identifier; }
    public Buyer getBuyer() { return buyer; }
    public List<OrderItem> getItems() { return List.copyOf(items); }
    public Money getTotal() { return total; }
    public DomainCatalog getStatus() { return status; }
    public LocalDateTime getCreationDate() { return creationDate; }
}

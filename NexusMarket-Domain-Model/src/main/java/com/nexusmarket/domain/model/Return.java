package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.DomainCatalog;

import java.time.LocalDateTime;
import java.util.Objects;

public class Return {
    private final String identifier;
    private final Order order;
    private final LocalDateTime requestDate;
    private final String reason;
    private final DomainCatalog status;

    public Return(String identifier, Order order, LocalDateTime requestDate,
                  String reason, DomainCatalog status) {
        this.identifier = Objects.requireNonNull(identifier);
        this.order = Objects.requireNonNull(order);
        this.requestDate = Objects.requireNonNull(requestDate);
        this.reason = Objects.requireNonNull(reason);
        this.status = Objects.requireNonNull(status);
    }

    public String getIdentifier() { return identifier; }
    public Order getOrder() { return order; }
    public LocalDateTime getRequestDate() { return requestDate; }
    public String getReason() { return reason; }
    public DomainCatalog getStatus() { return status; }
}

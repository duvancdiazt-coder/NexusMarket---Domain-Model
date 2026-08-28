package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.DomainCatalog;
import com.nexusmarket.domain.valueobject.Money;

import java.time.LocalDateTime;
import java.util.Objects;

public class Refund {
    private final String identifier;
    private final Order order;
    private final Return returnRequest;
    private final Money amount;
    private final LocalDateTime date;
    private final DomainCatalog status;

    public Refund(String identifier, Order order, Return returnRequest,
                  Money amount, LocalDateTime date, DomainCatalog status) {
        this.identifier = Objects.requireNonNull(identifier);
        this.order = Objects.requireNonNull(order);
        this.returnRequest = Objects.requireNonNull(returnRequest);
        this.amount = Objects.requireNonNull(amount);
        this.date = Objects.requireNonNull(date);
        this.status = Objects.requireNonNull(status);
    }

    public String getIdentifier() { return identifier; }
    public Order getOrder() { return order; }
    public Return getReturnRequest() { return returnRequest; }
    public Money getAmount() { return amount; }
    public LocalDateTime getDate() { return date; }
    public DomainCatalog getStatus() { return status; }
}

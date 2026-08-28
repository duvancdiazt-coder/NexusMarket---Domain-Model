package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.DomainCatalog;
import com.nexusmarket.domain.valueobject.Money;

import java.time.LocalDateTime;
import java.util.Objects;

public class Payment {
    private final String identifier;
    private final Order order;
    private final Money amount;
    private final DomainCatalog status;
    private final LocalDateTime paymentDate;

    public Payment(String identifier, Order order, Money amount,
                   DomainCatalog status, LocalDateTime paymentDate) {
        this.identifier = Objects.requireNonNull(identifier);
        this.order = Objects.requireNonNull(order);
        this.amount = Objects.requireNonNull(amount);
        this.status = Objects.requireNonNull(status);
        this.paymentDate = paymentDate;
    }

    public String getIdentifier() { return identifier; }
    public Order getOrder() { return order; }
    public Money getAmount() { return amount; }
    public DomainCatalog getStatus() { return status; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
}

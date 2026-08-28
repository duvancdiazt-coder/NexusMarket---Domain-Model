package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.Money;

import java.time.LocalDateTime;
import java.util.Objects;

public class Invoice {
    private final String identifier;
    private final Order order;
    private final LocalDateTime issueDate;
    private final Money subtotal;
    private final Money total;

    public Invoice(String identifier, Order order, LocalDateTime issueDate,
                   Money subtotal, Money total) {
        this.identifier = Objects.requireNonNull(identifier);
        this.order = Objects.requireNonNull(order);
        this.issueDate = Objects.requireNonNull(issueDate);
        this.subtotal = Objects.requireNonNull(subtotal);
        this.total = Objects.requireNonNull(total);
    }

    public String getIdentifier() { return identifier; }
    public Order getOrder() { return order; }
    public LocalDateTime getIssueDate() { return issueDate; }
    public Money getSubtotal() { return subtotal; }
    public Money getTotal() { return total; }
}

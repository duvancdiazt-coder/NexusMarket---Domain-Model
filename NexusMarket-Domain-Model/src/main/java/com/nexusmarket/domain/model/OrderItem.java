package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.Money;

import java.util.Objects;

public class OrderItem {
    private final Product product;
    private final ProductVariant variant;
    private final int quantity;
    private final Money unitPrice;

    public OrderItem(Product product, ProductVariant variant, int quantity, Money unitPrice) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        this.product = Objects.requireNonNull(product);
        this.variant = variant;
        this.quantity = quantity;
        this.unitPrice = Objects.requireNonNull(unitPrice);
    }

    public Product getProduct() { return product; }
    public ProductVariant getVariant() { return variant; }
    public int getQuantity() { return quantity; }
    public Money getUnitPrice() { return unitPrice; }
}

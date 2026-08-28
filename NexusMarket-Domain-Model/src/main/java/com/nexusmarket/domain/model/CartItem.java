package com.nexusmarket.domain.model;

import java.util.Objects;

public class CartItem {
    private final Product product;
    private final ProductVariant variant;
    private final int quantity;

    public CartItem(Product product, ProductVariant variant, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        this.product = Objects.requireNonNull(product);
        this.variant = variant;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public ProductVariant getVariant() { return variant; }
    public int getQuantity() { return quantity; }
}

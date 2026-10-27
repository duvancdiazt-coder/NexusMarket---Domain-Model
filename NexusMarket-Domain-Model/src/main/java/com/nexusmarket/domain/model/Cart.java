package com.nexusmarket.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart {
    private final String identifier;
    private final Buyer buyer;
    private final List<CartItem> items;

    public Cart(String identifier, Buyer buyer) {
        this.identifier = Objects.requireNonNull(identifier);
        this.buyer = Objects.requireNonNull(buyer);
        this.items = new ArrayList<>();
    }

    public void removeItem(CartItem item) { items.remove(item); }
    public void clear() { items.clear(); }
    public String getIdentifier() { return identifier; }
    public Buyer getBuyer() { return buyer; }
    public List<CartItem> getItems() { return List.copyOf(items); }

    public void addItem(CartItem item) { items.add(Objects.requireNonNull(item)); }
}

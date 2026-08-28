package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.Address;
import com.nexusmarket.domain.valueobject.BuyerStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Buyer {
    private final User user;
    private final Address primaryAddress;
    private final List<Address> additionalAddresses;
    private final BuyerStatus commercialStatus;
    private Cart cart;
    private final List<Order> orders;

    public Buyer(User user, Address primaryAddress, List<Address> additionalAddresses,
                 BuyerStatus commercialStatus) {
        this.user = Objects.requireNonNull(user);
        this.primaryAddress = Objects.requireNonNull(primaryAddress);
        this.additionalAddresses = new ArrayList<>(
                additionalAddresses == null ? List.of() : additionalAddresses
        );
        this.commercialStatus = Objects.requireNonNull(commercialStatus);
        this.orders = new ArrayList<>();
    }

    public User getUser() { return user; }
    public Address getPrimaryAddress() { return primaryAddress; }
    public List<Address> getAdditionalAddresses() { return List.copyOf(additionalAddresses); }
    public BuyerStatus getCommercialStatus() { return commercialStatus; }
    public Cart getCart() { return cart; }
    public List<Order> getOrders() { return List.copyOf(orders); }

    public void assignCart(Cart cart) { this.cart = Objects.requireNonNull(cart); }
    public void addOrder(Order order) { orders.add(Objects.requireNonNull(order)); }
}

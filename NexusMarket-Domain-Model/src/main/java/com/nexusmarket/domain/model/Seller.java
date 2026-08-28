package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.SellerStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Seller {
    private final User user;
    private final SellerStatus status;
    private final List<Product> products;
    private final List<Warehouse> warehouses;

    public Seller(User user, SellerStatus status) {
        this.user = Objects.requireNonNull(user);
        this.status = Objects.requireNonNull(status);
        this.products = new ArrayList<>();
        this.warehouses = new ArrayList<>();
    }

    public User getUser() { return user; }
    public SellerStatus getStatus() { return status; }
    public List<Product> getProducts() { return List.copyOf(products); }
    public List<Warehouse> getWarehouses() { return List.copyOf(warehouses); }

    public void addProduct(Product product) { products.add(Objects.requireNonNull(product)); }
    public void addWarehouse(Warehouse warehouse) { warehouses.add(Objects.requireNonNull(warehouse)); }
}

package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.Address;
import com.nexusmarket.domain.valueobject.DomainCatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Warehouse {
    private final String identifier;
    private final String name;
    private final Address address;
    private final DomainCatalog type;
    private final Seller seller;
    private final List<Inventory> inventories;

    public Warehouse(String identifier, String name, Address address,
                     DomainCatalog type, Seller seller) {
        this.identifier = Objects.requireNonNull(identifier);
        this.name = Objects.requireNonNull(name);
        this.address = Objects.requireNonNull(address);
        this.type = Objects.requireNonNull(type);
        this.seller = seller;
        this.inventories = new ArrayList<>();
    }

    public String getIdentifier() { return identifier; }
    public String getName() { return name; }
    public Address getAddress() { return address; }
    public DomainCatalog getType() { return type; }
    public Seller getSeller() { return seller; }
    public List<Inventory> getInventories() { return List.copyOf(inventories); }

    public void addInventory(Inventory inventory) {
        inventories.add(Objects.requireNonNull(inventory));
    }
}

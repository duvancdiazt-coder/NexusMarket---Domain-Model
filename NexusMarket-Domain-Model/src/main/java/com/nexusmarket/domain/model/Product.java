package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.DomainCatalog;
import com.nexusmarket.domain.valueobject.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {
    private final String identifier;
    private final String name;
    private final String description;
    private final Money price;
    private final DomainCatalog type;
    private final DomainCatalog status;
    private final Seller seller;
    private final List<ProductVariant> variants;
    private final List<Inventory> inventories;

    public Product(String identifier, String name, String description, Money price,
                   DomainCatalog type, DomainCatalog status, Seller seller) {
        this.identifier = Objects.requireNonNull(identifier);
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
        this.price = Objects.requireNonNull(price);
        this.type = Objects.requireNonNull(type);
        this.status = Objects.requireNonNull(status);
        this.seller = Objects.requireNonNull(seller);
        this.variants = new ArrayList<>();
        this.inventories = new ArrayList<>();
    }

    public String getIdentifier() { return identifier; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Money getPrice() { return price; }
    public DomainCatalog getType() { return type; }
    public DomainCatalog getStatus() { return status; }
    public Seller getSeller() { return seller; }
    public List<ProductVariant> getVariants() { return List.copyOf(variants); }
    public List<Inventory> getInventories() { return List.copyOf(inventories); }

    public void addVariant(ProductVariant variant) { variants.add(Objects.requireNonNull(variant)); }
    public void addInventory(Inventory inventory) { inventories.add(Objects.requireNonNull(inventory)); }
}

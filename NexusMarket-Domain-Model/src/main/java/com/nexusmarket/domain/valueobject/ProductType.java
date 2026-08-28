package com.nexusmarket.domain.valueobject;

public final class ProductType extends DomainCatalog {
    public static final ProductType PHYSICAL = new ProductType("PHYSICAL", "Physical", "Physical product requiring inventory and dispatch.");
    public static final ProductType DIGITAL = new ProductType("DIGITAL", "Digital", "Digital product delivered immediately after payment.");

    private ProductType(String code, String name, String description) {
        super(code, name, description);
    }
}

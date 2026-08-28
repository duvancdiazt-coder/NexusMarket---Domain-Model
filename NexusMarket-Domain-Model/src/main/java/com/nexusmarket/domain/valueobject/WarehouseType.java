package com.nexusmarket.domain.valueobject;

public final class WarehouseType extends DomainCatalog {
    public static final WarehouseType MARKETPLACE =
            new WarehouseType("MARKETPLACE", "Marketplace Warehouse",
                    "Warehouse operated by the Marketplace.");

    public static final WarehouseType SELLER =
            new WarehouseType("SELLER", "Seller Warehouse",
                    "Warehouse operated by a seller.");

    private WarehouseType(String code, String name, String description) {
        super(code, name, description);
    }
}

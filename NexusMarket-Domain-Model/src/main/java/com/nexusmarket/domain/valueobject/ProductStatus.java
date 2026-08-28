package com.nexusmarket.domain.valueobject;

public final class ProductStatus extends DomainCatalog {
    public static final ProductStatus PUBLISHED = new ProductStatus("PUBLISHED", "Published", "Product is visible in the public catalog.");
    public static final ProductStatus SUSPENDED = new ProductStatus("SUSPENDED", "Suspended", "Product is temporarily unavailable in the catalog.");
    public static final ProductStatus DISCONTINUED = new ProductStatus("DISCONTINUED", "Discontinued", "Product is no longer offered.");

    private ProductStatus(String code, String name, String description) {
        super(code, name, description);
    }
}

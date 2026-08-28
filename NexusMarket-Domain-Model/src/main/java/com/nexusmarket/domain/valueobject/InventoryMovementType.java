package com.nexusmarket.domain.valueobject;

public final class InventoryMovementType extends DomainCatalog {
    public static final InventoryMovementType IN = new InventoryMovementType("IN", "Inventory Entry", "Entry of stock into inventory.");
    public static final InventoryMovementType RESERVATION = new InventoryMovementType("RESERVATION", "Reservation", "Reservation of inventory for a commercial operation.");
    public static final InventoryMovementType SALE_OUT = new InventoryMovementType("SALE_OUT", "Sale Out", "Stock leaving inventory because of a sale.");
    public static final InventoryMovementType ADJUSTMENT = new InventoryMovementType("ADJUSTMENT", "Adjustment", "Manual inventory adjustment.");
    public static final InventoryMovementType RETURN = new InventoryMovementType("RETURN", "Return", "Stock re-entering inventory due to a return.");

    private InventoryMovementType(String code, String name, String description) {
        super(code, name, description);
    }
}

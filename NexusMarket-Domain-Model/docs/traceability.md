# Functional Specification → Domain Model Traceability

| Functional area | Main domain classes | Main value objects |
|---|---|---|
| User administration | User | UserRole, UserStatus, Email |
| Buyer management | Buyer, Address, Cart, CartItem | BuyerStatus, Address |
| Seller management | Seller | SellerStatus |
| Warehouse management | Warehouse | Address, WarehouseType |
| Product catalog | Product, ProductVariant | ProductType, ProductStatus, Money |
| Inventory | Inventory, InventoryMovement | InventoryStatus, InventoryMovementType |
| Cart | Cart, CartItem | — |
| Orders | Order, OrderItem | OrderStatus, Money |
| Billing | Invoice | Money |
| Payments | Payment | Money |
| Logistics | Shipment | — |
| Returns | Return | — |
| Refunds | Refund | Money |
| Administrative consultation | Existing domain entities | Existing catalogs |

## Functional constraints represented in the model

- Unique user identification → `User.identifier`
- Unique email → `User.email`
- One role per user → `User.role`
- Seller registration by administrator → `Seller` is a business concept; the operation belongs to a future service
- Inventory linked to product and warehouse → `Inventory.product`, `Inventory.warehouse`
- No negative inventory → `Inventory` constructor validation
- Damaged inventory cannot be reserved → `InventoryStatus.DAMAGED`; reservation rule belongs to a future domain service
- Finalized orders cannot be modified → `OrderStatus`; enforcement belongs to a future domain service
- Physical/digital product distinction → `ProductType`

# Functional Areas → Services → Ports

| Functional area | Service | Output ports |
|---|---|---|
| User management | UserService | UserRepositoryPort, UserUniquenessPort |
| Buyer management | BuyerService | BuyerRepositoryPort |
| Seller administration | SellerService | SellerRepositoryPort |
| Warehouses | WarehouseService | WarehouseRepositoryPort |
| Catalog | ProductService | ProductRepositoryPort |
| Distributed inventory | InventoryService | InventoryRepositoryPort |
| Cart | CartService | CartRepositoryPort |
| Orders | OrderService | OrderRepositoryPort |
| Billing and payment record | BillingService | InvoiceRepositoryPort, PaymentRepositoryPort |
| Logistics | ShipmentService | ShipmentRepositoryPort |
| Returns and refunds | AfterSalesService | ReturnRepositoryPort, RefundRepositoryPort |
| Reports | ReportingService | OrderRepositoryPort |

The service names and ports are implementation design decisions derived from the NexusMarket functional areas, not a prescribed count from the assignment.

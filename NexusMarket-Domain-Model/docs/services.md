# NexusMarket — Implemented service contracts

This delivery has **14 service classes and 41 implemented public operations**, not 69 completed operations. The larger 69-item inventory is a candidate analysis list and includes operations needing business clarification.

| Input interface | Implemented operations |
|---|---:|
| `IBillingService` | 2 |
| `IBuyerService` | 3 |
| `ICartService` | 4 |
| `IInventoryService` | 6 |
| `IOrderService` | 6 |
| `IPaymentService` | 2 |
| `IProductService` | 4 |
| `IRefundService` | 2 |
| `IReportingService` | 1 |
| `IReturnService` | 2 |
| `ISellerService` | 2 |
| `IShipmentService` | 2 |
| `IUserService` | 3 |
| `IWarehouseService` | 2 |

Each service implements its input interface and uses output repository interfaces. Authentication, persistence adapters, external payment verification, atomic transactions, and complete logistics/return workflows are not supplied. See `service-rules.md`.

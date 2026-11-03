# NexusMarket — Service Rules and Limitations

## Implemented rules

- Only ACTIVE actors with an allowed `UserRole` can invoke a service.
- User registration rejects duplicate identification or email using `UserUniquenessPort`; real adapters must enforce uniqueness atomically too.
- Seller profile registration requires an administrator and a SELLER user.
- A buyer profile must be associated with a BUYER user.
- Buyer cart/profile/order consultation checks ownership.
- Seller product registration and variant changes check seller ownership.
- Inventory quantities must be positive for movements, cannot be negative, and damaged inventory cannot be reserved.
- An order starts with at least one item and PENDING_PAYMENT.
- An order has controlled transitions; COMPLETED orders cannot transition again.
- Invoice generation requires a paid/completed order.
- Shipment registration requires a paid order.
- Refund must refer to the same order as its return request.

## Known gaps — not claimed as implemented

- Real payment confirmation requires a trusted payment port and defined statuses. `registerPayment` records a Payment; it is NOT an external payment validation.
- `OrderService.markPaid` is an administrator-authorized model transition, not a payment-gateway integration. Do not use in production without verified payment.
- Inventory reserve/receive/sale operations update aggregate quantities but do not yet append a complete immutable movement history. This requires a defined movement lifecycle and atomic adapter transaction.
- Reservation and stock consistency under concurrent orders require atomic locking or optimistic concurrency in an adapter.
- Buyer self-registration and administrator registration flows need exact authorization agreement.
- Digital fulfillment, multi-seller and multi-warehouse shipment splitting, tax rules, refund acceptance and report definitions need specification.
- `DomainCatalog.of` for incomplete status catalogs remains provisional, not a finalized closed set.
- Existing August model exposes `DomainCatalog` for several fields; future refinement should make each field strongly typed.
- `Cart` is separate from `Order`; CART remains in the original `OrderStatus` catalog for backward compatibility but new orders start PENDING_PAYMENT.

## Testing

Compile all Java files with `javac`; run the standalone domain smoke test in `tests`. It uses a fake repository and requires no Spring or database.

## October revision

- Billing, Payment, Return, and Refund now have separate input interfaces and service classes (14 total).
- Product status is changed through a controlled domain method, not a generic setter.
- Inventory supports adjustment and release, enforcing nonnegative stock.
- Order transitions support shipment and delivery explicitly.
- Return requests require a delivered/completed order and a reason; refund amounts must be positive and not exceed the order total (a provisional single-refund guard, not aggregate refund accounting).
- No method here verifies a payment with an external processor. A production transition to PAID must be authorized by a trusted verified-payment workflow, not merely a user role.
- Current inventory service has no ownership check for SELLER; the seller role alone is insufficient in a multi-seller marketplace. Add warehouse/product ownership authorization before production use.
- Current service saves are not atomic across aggregates and do not yet guarantee full movement/audit history.

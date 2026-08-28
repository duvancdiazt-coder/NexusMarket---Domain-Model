# NexusMarket — Value Objects

## 1. Purpose

Value Objects represent controlled or immutable business concepts whose meaning is determined by their values.

The model avoids scattering arbitrary strings such as:

```text
"ACTIVE"
"BLOCKED"
"PHYSICAL"
"PUBLISHED"
```

throughout the domain.

---

## 2. Controlled domain catalogs

### UserRole

Allowed values:

```text
BUYER
SELLER
LOGISTIC_OPERATOR
ADMINISTRATOR
SUPERVISOR
```

### UserStatus

The functional specification explicitly mentions active and blocked users and indicates that additional states may exist.

For the current implementation:

```text
ACTIVE
BLOCKED
```

No additional state is invented.

### BuyerStatus

Represents the buyer's commercial condition.

The specification requires a commercial status but does not define its complete catalog. The implementation therefore keeps this as a controlled value object without inventing additional values.

### WarehouseType

```text
MARKETPLACE
SELLER
```

### ProductType

```text
PHYSICAL
DIGITAL
```

### ProductStatus

```text
PUBLISHED
SUSPENDED
DISCONTINUED
```

### InventoryMovementType

```text
IN
RESERVATION
SALE_OUT
ADJUSTMENT
RETURN
```

### InventoryStatus

The functional specification explicitly identifies `DAMAGED` because damaged inventory cannot be reserved.

No additional status values are invented in this delivery.

### OrderStatus

The specification defines:

```text
CART
PENDING_PAYMENT
PAID
SHIPPED
DELIVERED
COMPLETED
```

The specification writes "Delivered / Finalized"; therefore the distinction between `DELIVERED` and `COMPLETED` should be confirmed in the next refinement of the requirements.

---

## 3. General Value Objects

### Email

Represents the user's email address and centralizes email validation.

### Money

Represents a monetary value:

```text
amount
currency
```

It is used by:

- Product price
- Order total
- Order item price
- Payment amount
- Invoice values
- Refund amount

### Address

Represents a delivery or physical address:

```text
street
city
state
postalCode
country
```

---

## 4. Immutability

Value Objects should not expose operations that mutate their internal state.

They are created with their values and then treated as immutable.

---

## 5. Equality

Two Value Objects with the same business values represent the same value.

For example:

```text
Money(10000, COP)
```

has the same value as another:

```text
Money(10000, COP)
```

---

## 6. Design rule

A business concept should become a controlled catalog when the specification defines a finite set of valid business values.

A concept should not be turned into an invented enumeration simply because it could technically have one. The functional specification is the source for the current model.

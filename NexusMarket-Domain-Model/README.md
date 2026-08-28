# NexusMarket - Domain Model

## Course Deliverable

**Deliverable:** Domain Model  
**Project:** NexusMarket  
**Language:** Java  
**Architecture basis:** Domain-Driven Design (DDD) and Hexagonal Architecture principles.

## Objective

This repository contains the domain model of NexusMarket. It identifies the main business classes, their attributes, relationships, business value objects, and domain constraints derived from the functional specification.

The domain model is intentionally independent of Spring Boot, JPA, MySQL, MongoDB, REST, JSON, and other infrastructure technologies.

## Repository structure

```text
NexusMarket-Domain-Model/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── nexusmarket/
│                   └── domain/
│                       ├── model/
│                       ├── valueobject/
│                       └── exception/
├── docs/
│   ├── domain-model.md
│   └── value-objects.md
├── uml/
│   └── domain-model.puml
└── README.md
```

## Main domain classes

- User
- Buyer
- Seller
- Address
- Warehouse
- Product
- ProductVariant
- Inventory
- InventoryMovement
- Cart
- CartItem
- Order
- OrderItem
- Invoice
- Payment
- Shipment
- Return
- Refund

## Main value objects / controlled catalogs

- UserRole
- UserStatus
- BuyerStatus
- ProductType
- ProductStatus
- InventoryMovementType
- InventoryStatus
- OrderStatus
- Money
- Email
- Address

## Important domain rules

1. Every user has exactly one role.
2. Identification and email must be unique.
3. Sellers cannot self-register; they are registered by an Administrator.
4. Inventory belongs to one product and one warehouse.
5. Inventory cannot become negative.
6. Inventory cannot be reserved when it does not exist or is marked as damaged.
7. A completed order cannot be modified.
8. Physical products require inventory and shipment.
9. Digital products are delivered immediately after payment.
10. A participant may only operate according to their assigned role.

## Scope note

Only concepts supported by the functional specification are modeled as business concepts. Where the specification does not define a complete catalog of states or detailed attributes, the model avoids inventing business rules that should be defined later.

## GitHub delivery

Recommended repository name:

`nexusmarket-domain-model`

Commit sequence:

```text
Initial commit: NexusMarket domain model
Add domain value objects
Add domain documentation
Add domain UML diagram
```

The repository should be public or shared with the instructor according to the course requirements.

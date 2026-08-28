package com.nexusmarket.domain.valueobject;

public final class OrderStatus extends DomainCatalog {
    public static final OrderStatus CART = new OrderStatus("CART", "Cart", "Provisional product selection.");
    public static final OrderStatus PENDING_PAYMENT = new OrderStatus("PENDING_PAYMENT", "Pending Payment", "Order is waiting for payment confirmation.");
    public static final OrderStatus PAID = new OrderStatus("PAID", "Paid", "Payment has been confirmed.");
    public static final OrderStatus SHIPPED = new OrderStatus("SHIPPED", "Shipped", "Order has left the warehouse.");
    public static final OrderStatus DELIVERED = new OrderStatus("DELIVERED", "Delivered", "Order has been delivered.");
    public static final OrderStatus COMPLETED = new OrderStatus("COMPLETED", "Completed", "Order has reached its final state.");

    private OrderStatus(String code, String name, String description) {
        super(code, name, description);
    }
}

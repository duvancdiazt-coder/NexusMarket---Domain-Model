package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
import com.nexusmarket.domain.ports.in.IOrderService;
import com.nexusmarket.domain.ports.out.*;
public final class OrderService implements IOrderService {
    private final OrderRepositoryPort repository;

    public OrderService(OrderRepositoryPort repository) { this.repository = Objects.requireNonNull(repository); }
    private Order find(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Order not found: " + id));
    }
    @Override public Order create(User actor, Order order) { ServiceSupport.requireRole(actor, UserRole.BUYER); if (!order.getBuyer().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your order"); if (!order.getStatus().equals(OrderStatus.PENDING_PAYMENT) || order.getItems().isEmpty()) throw new IllegalArgumentException("Order must start pending payment with items"); return repository.save(order); }
    @Override public Order consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.BUYER, UserRole.SELLER, UserRole.LOGISTIC_OPERATOR, UserRole.ADMINISTRATOR, UserRole.SUPERVISOR); Order order=find(id); if (actor.getRole().equals(UserRole.BUYER) && !order.getBuyer().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your order"); return order; }
    @Override public Order markPaid(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR); Order order=find(id); order.transitionTo(OrderStatus.PAID); return repository.save(order); }
    @Override public Order complete(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.LOGISTIC_OPERATOR, UserRole.ADMINISTRATOR); Order order=find(id); order.transitionTo(OrderStatus.COMPLETED); return repository.save(order); }
    @Override public Order markShipped(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.LOGISTIC_OPERATOR); Order o=find(id); o.transitionTo(OrderStatus.SHIPPED); return repository.save(o); }
    @Override public Order markDelivered(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.LOGISTIC_OPERATOR); Order o=find(id); o.transitionTo(OrderStatus.DELIVERED); return repository.save(o); }
}

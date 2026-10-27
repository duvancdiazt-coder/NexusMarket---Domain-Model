package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
import com.nexusmarket.domain.ports.in.IShipmentService;
import com.nexusmarket.domain.ports.out.*;
public final class ShipmentService implements IShipmentService {
    private final ShipmentRepositoryPort repository;

    public ShipmentService(ShipmentRepositoryPort repository) { this.repository = Objects.requireNonNull(repository); }
    private Shipment find(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Shipment not found: " + id));
    }
    @Override public Shipment register(User actor, Shipment shipment) { ServiceSupport.requireRole(actor, UserRole.LOGISTIC_OPERATOR); if (!shipment.getOrder().getStatus().equals(OrderStatus.PAID)) throw new IllegalStateException("Order must be paid"); return repository.save(shipment); }
    @Override public Shipment consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.LOGISTIC_OPERATOR, UserRole.ADMINISTRATOR, UserRole.SUPERVISOR, UserRole.BUYER); Shipment shipment=find(id); if (actor.getRole().equals(UserRole.BUYER) && !shipment.getOrder().getBuyer().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your shipment"); return shipment; }
}

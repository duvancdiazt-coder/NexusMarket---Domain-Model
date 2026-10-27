package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
import com.nexusmarket.domain.ports.in.IInventoryService;
import com.nexusmarket.domain.ports.out.*;
public final class InventoryService implements IInventoryService {
    private final InventoryRepositoryPort repository;

    public InventoryService(InventoryRepositoryPort repository) { this.repository = Objects.requireNonNull(repository); }
    private Inventory find(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Inventory not found: " + id));
    }
    @Override public Inventory consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.SELLER, UserRole.LOGISTIC_OPERATOR, UserRole.ADMINISTRATOR, UserRole.SUPERVISOR); return find(id); }
    @Override public Inventory receive(User actor, String id, int quantity) { ServiceSupport.requireRole(actor, UserRole.SELLER, UserRole.LOGISTIC_OPERATOR); Inventory inventory=find(id); inventory.receive(quantity); return repository.save(inventory); }
    @Override public Inventory reserve(User actor, String id, int quantity) { ServiceSupport.requireRole(actor, UserRole.SELLER, UserRole.LOGISTIC_OPERATOR); Inventory inventory=find(id); inventory.reserve(quantity); return repository.save(inventory); }
    @Override public Inventory sellReserved(User actor, String id, int quantity) { ServiceSupport.requireRole(actor, UserRole.SELLER, UserRole.LOGISTIC_OPERATOR); Inventory inventory=find(id); inventory.sellReserved(quantity); return repository.save(inventory); }
    @Override public Inventory release(User actor, String id, int quantity) { ServiceSupport.requireRole(actor, UserRole.SELLER, UserRole.LOGISTIC_OPERATOR); Inventory i=find(id); i.release(quantity); return repository.save(i); }
    @Override public Inventory adjust(User actor, String id, int delta) { ServiceSupport.requireRole(actor, UserRole.SELLER, UserRole.LOGISTIC_OPERATOR); Inventory i=find(id); i.adjust(delta); return repository.save(i); }
}

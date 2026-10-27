package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
import com.nexusmarket.domain.ports.in.IWarehouseService;
import com.nexusmarket.domain.ports.out.*;
public final class WarehouseService implements IWarehouseService {
    private final WarehouseRepositoryPort repository;

    public WarehouseService(WarehouseRepositoryPort repository) { this.repository = Objects.requireNonNull(repository); }
    private Warehouse find(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Warehouse not found: " + id));
    }
    @Override public Warehouse register(User actor, Warehouse warehouse) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR); return repository.save(warehouse); }
    @Override public Warehouse consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR, UserRole.SUPERVISOR, UserRole.SELLER, UserRole.LOGISTIC_OPERATOR); return find(id); }
}

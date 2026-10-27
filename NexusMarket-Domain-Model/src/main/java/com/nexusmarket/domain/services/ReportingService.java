package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
import com.nexusmarket.domain.ports.in.IReportingService;
import com.nexusmarket.domain.ports.out.*;
public final class ReportingService implements IReportingService {
    private final OrderRepositoryPort repository;

    public ReportingService(OrderRepositoryPort repository) { this.repository = Objects.requireNonNull(repository); }
    private Order find(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Order not found: " + id));
    }
    @Override public List<Order> listOrders(User actor) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR, UserRole.SUPERVISOR); return repository.findAll(); }
}

package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import com.nexusmarket.domain.ports.in.IBillingService;
import com.nexusmarket.domain.ports.out.InvoiceRepositoryPort;
import java.util.*;
public final class BillingService implements IBillingService {
    private final InvoiceRepositoryPort repository;
    public BillingService(InvoiceRepositoryPort repository) { this.repository=Objects.requireNonNull(repository); }
    private Invoice find(String id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Invoice not found")); }
    @Override public Invoice generate(User actor, Invoice invoice) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR); if (!invoice.getOrder().getStatus().equals(OrderStatus.PAID) && !invoice.getOrder().getStatus().equals(OrderStatus.COMPLETED)) throw new IllegalStateException("Order not paid"); if (invoice.getTotal().getAmount().signum()<0) throw new IllegalArgumentException("Negative invoice"); return repository.save(invoice); }
    @Override public Invoice consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR, UserRole.SUPERVISOR, UserRole.BUYER); Invoice invoice=find(id); if(actor.getRole().equals(UserRole.BUYER) && !invoice.getOrder().getBuyer().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your invoice"); return invoice; }
}

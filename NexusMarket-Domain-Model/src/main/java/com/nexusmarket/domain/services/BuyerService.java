package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
import com.nexusmarket.domain.ports.in.IBuyerService;
import com.nexusmarket.domain.ports.out.*;
public final class BuyerService implements IBuyerService {
    private final BuyerRepositoryPort repository;

    public BuyerService(BuyerRepositoryPort repository) { this.repository = Objects.requireNonNull(repository); }
    private Buyer find(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Buyer not found: " + id));
    }
    @Override public Buyer register(User actor, Buyer buyer) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR, UserRole.BUYER); if (!buyer.getUser().getRole().equals(UserRole.BUYER)) throw new IllegalArgumentException("Buyer profile requires BUYER role"); return repository.save(buyer); }
    @Override public Buyer consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR, UserRole.SUPERVISOR, UserRole.BUYER); Buyer buyer=find(id); if (actor.getRole().equals(UserRole.BUYER) && !buyer.getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your buyer profile"); return buyer; }
    @Override public Buyer addAddress(User actor, String id, Address address) { Buyer buyer=consult(actor,id); buyer.addAddress(address); return repository.save(buyer); }
}

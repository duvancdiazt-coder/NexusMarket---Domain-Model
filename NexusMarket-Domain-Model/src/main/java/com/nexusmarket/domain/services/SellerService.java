package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
import com.nexusmarket.domain.ports.in.ISellerService;
import com.nexusmarket.domain.ports.out.*;
public final class SellerService implements ISellerService {
    private final SellerRepositoryPort repository;

    public SellerService(SellerRepositoryPort repository) { this.repository = Objects.requireNonNull(repository); }
    private Seller find(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Seller not found: " + id));
    }
    @Override public Seller register(User actor, Seller seller) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR); if (!seller.getUser().getRole().equals(UserRole.SELLER)) throw new IllegalArgumentException("Seller profile requires SELLER role"); return repository.save(seller); }
    @Override public Seller consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR, UserRole.SUPERVISOR, UserRole.SELLER); Seller seller=find(id); if (actor.getRole().equals(UserRole.SELLER) && !seller.getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your seller profile"); return seller; }
}

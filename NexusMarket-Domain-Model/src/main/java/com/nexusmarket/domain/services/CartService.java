package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
import com.nexusmarket.domain.ports.in.ICartService;
import com.nexusmarket.domain.ports.out.*;
public final class CartService implements ICartService {
    private final CartRepositoryPort repository;

    public CartService(CartRepositoryPort repository) { this.repository = Objects.requireNonNull(repository); }
    private Cart find(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Cart not found: " + id));
    }
    @Override public Cart consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.BUYER); Cart cart=find(id); if (!cart.getBuyer().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your cart"); return cart; }
    @Override public Cart addItem(User actor, String id, CartItem item) { Cart cart=consult(actor,id); cart.addItem(item); return repository.save(cart); }
    @Override public Cart removeItem(User actor, String id, CartItem item) { Cart cart=consult(actor,id); cart.removeItem(item); return repository.save(cart); }
    @Override public Cart clear(User actor, String id) { Cart cart=consult(actor,id); cart.clear(); return repository.save(cart); }
}

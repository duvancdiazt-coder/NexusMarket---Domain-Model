package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import com.nexusmarket.domain.ports.in.IReturnService;
import com.nexusmarket.domain.ports.out.ReturnRepositoryPort;
import java.util.*;
public final class ReturnService implements IReturnService {
    private final ReturnRepositoryPort repository;
    public ReturnService(ReturnRepositoryPort repository) { this.repository=Objects.requireNonNull(repository); }
    private Return find(String id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Return not found")); }
    @Override public Return request(User actor, Return request) { ServiceSupport.requireRole(actor, UserRole.BUYER); if(!request.getOrder().getBuyer().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your order"); if(request.getReason().isBlank()) throw new IllegalArgumentException("Reason required"); if(!request.getOrder().getStatus().equals(OrderStatus.DELIVERED) && !request.getOrder().getStatus().equals(OrderStatus.COMPLETED)) throw new IllegalStateException("Order not delivered"); return repository.save(request); }
    @Override public Return consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.BUYER, UserRole.ADMINISTRATOR); Return request=find(id); if(actor.getRole().equals(UserRole.BUYER) && !request.getOrder().getBuyer().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your return"); return request; }
}

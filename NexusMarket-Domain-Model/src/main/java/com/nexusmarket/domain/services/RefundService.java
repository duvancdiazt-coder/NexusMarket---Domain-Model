package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import com.nexusmarket.domain.ports.in.IRefundService;
import com.nexusmarket.domain.ports.out.RefundRepositoryPort;
import java.util.*;
public final class RefundService implements IRefundService {
    private final RefundRepositoryPort repository;
    public RefundService(RefundRepositoryPort repository) { this.repository=Objects.requireNonNull(repository); }
    private Refund find(String id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Refund not found")); }
    @Override public Refund register(User actor, Refund refund) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR); if(!refund.getOrder().getIdentifier().equals(refund.getReturnRequest().getOrder().getIdentifier())) throw new IllegalArgumentException("Return/order mismatch"); if(refund.getAmount().getAmount().signum()<=0 || refund.getAmount().getAmount().compareTo(refund.getOrder().getTotal().getAmount())>0) throw new IllegalArgumentException("Invalid refund amount"); if(!refund.getAmount().getCurrency().equals(refund.getOrder().getTotal().getCurrency())) throw new IllegalArgumentException("Currency mismatch"); return repository.save(refund); }
    @Override public Refund consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR, UserRole.BUYER); Refund refund=find(id); if(actor.getRole().equals(UserRole.BUYER) && !refund.getOrder().getBuyer().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your refund"); return refund; }
}

package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import com.nexusmarket.domain.ports.in.IPaymentService;
import com.nexusmarket.domain.ports.out.PaymentRepositoryPort;
import java.util.*;
public final class PaymentService implements IPaymentService {
    private final PaymentRepositoryPort repository;
    public PaymentService(PaymentRepositoryPort repository) { this.repository=Objects.requireNonNull(repository); }
    private Payment find(String id) { return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Payment not found")); }
    @Override public Payment register(User actor, Payment payment) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR); if(payment.getAmount().getAmount().signum()<=0) throw new IllegalArgumentException("Nonpositive payment"); if (!payment.getAmount().getCurrency().equals(payment.getOrder().getTotal().getCurrency())) throw new IllegalArgumentException("Currency mismatch"); return repository.save(payment); }
    @Override public Payment consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR, UserRole.SUPERVISOR, UserRole.BUYER); Payment payment=find(id); if(actor.getRole().equals(UserRole.BUYER) && !payment.getOrder().getBuyer().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your payment"); return payment; }
}

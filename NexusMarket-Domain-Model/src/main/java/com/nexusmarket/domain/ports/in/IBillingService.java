package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.*;
public interface IBillingService {
    Invoice generate(User actor, Invoice invoice);
    Invoice consult(User actor, String id);
}

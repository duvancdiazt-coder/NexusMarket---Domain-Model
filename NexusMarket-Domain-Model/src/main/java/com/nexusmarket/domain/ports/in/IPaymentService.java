package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.*;
public interface IPaymentService {
    Payment register(User actor, Payment payment);
    Payment consult(User actor, String id);
}

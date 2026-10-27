package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.*;
public interface IRefundService {
    Refund register(User actor, Refund refund);
    Refund consult(User actor, String id);
}

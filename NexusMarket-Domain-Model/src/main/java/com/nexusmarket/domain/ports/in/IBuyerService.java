package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.Buyer;
import com.nexusmarket.domain.model.User;
import com.nexusmarket.domain.valueobject.Address;
public interface IBuyerService {
    Buyer register(User actor, Buyer buyer);
    Buyer consult(User actor, String id);
    Buyer addAddress(User actor, String id, Address address);
}

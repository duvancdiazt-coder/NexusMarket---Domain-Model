package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
public interface IBuyerService {
    Buyer register(User actor, Buyer buyer);
    Buyer consult(User actor, String id);
    Buyer addAddress(User actor, String id, Address address);
}

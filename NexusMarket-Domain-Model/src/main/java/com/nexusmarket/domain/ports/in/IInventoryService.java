package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.Inventory;
import com.nexusmarket.domain.model.User;
public interface IInventoryService {
    Inventory consult(User actor, String id);
    Inventory receive(User actor, String id, int quantity);
    Inventory reserve(User actor, String id, int quantity);
    Inventory sellReserved(User actor, String id, int quantity);
    Inventory release(User actor, String id, int quantity);
    Inventory adjust(User actor, String id, int delta);
}

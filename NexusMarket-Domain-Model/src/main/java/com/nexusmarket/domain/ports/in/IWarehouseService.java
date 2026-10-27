package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.User;
import com.nexusmarket.domain.model.Warehouse;
public interface IWarehouseService {
    Warehouse register(User actor, Warehouse warehouse);
    Warehouse consult(User actor, String id);
}

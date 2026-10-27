package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
public interface IWarehouseService {
    Warehouse register(User actor, Warehouse warehouse);
    Warehouse consult(User actor, String id);
}

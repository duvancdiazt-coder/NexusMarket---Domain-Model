package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
public interface IShipmentService {
    Shipment register(User actor, Shipment shipment);
    Shipment consult(User actor, String id);
}

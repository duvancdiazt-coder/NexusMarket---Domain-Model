package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.Shipment;
import com.nexusmarket.domain.model.User;
public interface IShipmentService {
    Shipment register(User actor, Shipment shipment);
    Shipment consult(User actor, String id);
}

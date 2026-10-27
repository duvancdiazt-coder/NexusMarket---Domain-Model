package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.Order;
import com.nexusmarket.domain.model.User;
public interface IOrderService {
    Order create(User actor, Order order);
    Order consult(User actor, String id);
    Order markPaid(User actor, String id);
    Order complete(User actor, String id);
    Order markShipped(User actor, String id);
    Order markDelivered(User actor, String id);
}

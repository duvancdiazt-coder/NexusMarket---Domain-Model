package com.nexusmarket.domain.ports.in;
import java.util.List;
import com.nexusmarket.domain.model.Order;
import com.nexusmarket.domain.model.User;
public interface IReportingService {
    List<Order> listOrders(User actor);
}

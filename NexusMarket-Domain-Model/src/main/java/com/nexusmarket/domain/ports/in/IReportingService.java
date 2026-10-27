package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
public interface IReportingService {
    List<Order> listOrders(User actor);
}

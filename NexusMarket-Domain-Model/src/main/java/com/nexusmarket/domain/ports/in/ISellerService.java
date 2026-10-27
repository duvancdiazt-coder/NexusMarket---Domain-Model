package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.Seller;
import com.nexusmarket.domain.model.User;
public interface ISellerService {
    Seller register(User actor, Seller seller);
    Seller consult(User actor, String id);
}

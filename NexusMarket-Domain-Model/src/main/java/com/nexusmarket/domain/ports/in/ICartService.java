package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.Cart;
import com.nexusmarket.domain.model.CartItem;
import com.nexusmarket.domain.model.User;
public interface ICartService {
    Cart consult(User actor, String id);
    Cart addItem(User actor, String id, CartItem item);
    Cart removeItem(User actor, String id, CartItem item);
    Cart clear(User actor, String id);
}

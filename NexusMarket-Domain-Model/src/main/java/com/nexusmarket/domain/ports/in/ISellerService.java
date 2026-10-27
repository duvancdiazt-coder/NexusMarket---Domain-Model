package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
public interface ISellerService {
    Seller register(User actor, Seller seller);
    Seller consult(User actor, String id);
}

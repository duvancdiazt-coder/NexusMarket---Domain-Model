package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
public interface IProductService {
    Product register(User actor, Product product);
    Product consult(User actor, String id);
    Product addVariant(User actor, String id, ProductVariant variant);
    Product changeStatus(User actor, String id, ProductStatus status);
}

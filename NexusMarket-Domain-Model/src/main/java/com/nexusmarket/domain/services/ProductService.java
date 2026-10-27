package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
import com.nexusmarket.domain.ports.in.IProductService;
import com.nexusmarket.domain.ports.out.*;
public final class ProductService implements IProductService {
    private final ProductRepositoryPort repository;

    public ProductService(ProductRepositoryPort repository) { this.repository = Objects.requireNonNull(repository); }
    private Product find(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found: " + id));
    }
    @Override public Product register(User actor, Product product) { ServiceSupport.requireRole(actor, UserRole.SELLER); if (!product.getSeller().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your product"); return repository.save(product); }
    @Override public Product consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.BUYER, UserRole.SELLER, UserRole.ADMINISTRATOR, UserRole.SUPERVISOR); return find(id); }
    @Override public Product addVariant(User actor, String id, ProductVariant variant) { Product product=find(id); ServiceSupport.requireRole(actor, UserRole.SELLER); if (!product.getSeller().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your product"); product.addVariant(variant); return repository.save(product); }
    @Override public Product changeStatus(User actor, String id, ProductStatus status) { ServiceSupport.requireRole(actor, UserRole.SELLER); Product p=find(id); if(!p.getSeller().getUser().getIdentifier().equals(actor.getIdentifier())) throw new SecurityException("Not your product"); p.changeStatus(status); return repository.save(p); }
}

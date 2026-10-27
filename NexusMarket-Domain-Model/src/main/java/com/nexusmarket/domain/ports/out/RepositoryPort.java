package com.nexusmarket.domain.ports.out;
import java.util.*;
public interface RepositoryPort<T> {
    Optional<T> findById(String id);
    T save(T entity);
    List<T> findAll();
}

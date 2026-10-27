package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
import com.nexusmarket.domain.ports.in.IUserService;
import com.nexusmarket.domain.ports.out.*;
public final class UserService implements IUserService {
    private final UserRepositoryPort repository;
    private final UserUniquenessPort uniqueness;
    public UserService(UserRepositoryPort repository, UserUniquenessPort uniqueness) { this.repository = Objects.requireNonNull(repository); this.uniqueness = Objects.requireNonNull(uniqueness); }
    private User find(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found: " + id));
    }
    @Override public User register(User actor, User user) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR); if (uniqueness.existsByIdentifier(user.getIdentifier()) || uniqueness.existsByEmail(user.getEmail())) throw new IllegalArgumentException("Duplicate identity or email"); return repository.save(user); }
    @Override public User consult(User actor, String id) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR, UserRole.SUPERVISOR); return find(id); }
    @Override public User changeStatus(User actor, String id, UserStatus status) { ServiceSupport.requireRole(actor, UserRole.ADMINISTRATOR); User user=find(id); user.changeStatus(status); return repository.save(user); }
}

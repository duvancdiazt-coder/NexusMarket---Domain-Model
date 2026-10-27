package com.nexusmarket.domain.services;
import com.nexusmarket.domain.model.User;
import com.nexusmarket.domain.valueobject.UserRole;
import com.nexusmarket.domain.valueobject.UserStatus;
import java.util.Objects;
final class ServiceSupport {
    private ServiceSupport() {}
    static void requireRole(User actor, UserRole... allowed) {
        Objects.requireNonNull(actor, "Authenticated actor required");
        if (!UserStatus.ACTIVE.equals(actor.getStatus())) throw new SecurityException("Inactive actor");
        for (UserRole role : allowed) if (role.equals(actor.getRole())) return;
        throw new SecurityException("Operation not permitted for role " + actor.getRole().getCode());
    }
    static <T> T required(T value, String name) { return Objects.requireNonNull(value, name + " is required"); }
}

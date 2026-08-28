package com.nexusmarket.domain.model;

import com.nexusmarket.domain.valueobject.Email;
import com.nexusmarket.domain.valueobject.UserRole;
import com.nexusmarket.domain.valueobject.UserStatus;

import java.util.Objects;

public class User {
    private final String identifier;
    private final String fullName;
    private final Email email;
    private final UserRole role;
    private UserStatus status;

    public User(String identifier, String fullName, Email email, UserRole role, UserStatus status) {
        this.identifier = Objects.requireNonNull(identifier);
        this.fullName = Objects.requireNonNull(fullName);
        this.email = Objects.requireNonNull(email);
        this.role = Objects.requireNonNull(role);
        this.status = Objects.requireNonNull(status);
    }

    public String getIdentifier() { return identifier; }
    public String getFullName() { return fullName; }
    public Email getEmail() { return email; }
    public UserRole getRole() { return role; }
    public UserStatus getStatus() { return status; }
    public void changeStatus(UserStatus status) { this.status = Objects.requireNonNull(status); }
}

package com.nexusmarket.domain.valueobject;

public final class UserStatus extends DomainCatalog {
    public static final UserStatus ACTIVE = new UserStatus("ACTIVE", "Active", "User can operate normally.");
    public static final UserStatus BLOCKED = new UserStatus("BLOCKED", "Blocked", "User access is blocked.");

    private UserStatus(String code, String name, String description) {
        super(code, name, description);
    }
}

package com.nexusmarket.domain.valueobject;

public final class UserRole extends DomainCatalog {
    public static final UserRole BUYER = new UserRole("BUYER", "Buyer", "User who acquires products.");
    public static final UserRole SELLER = new UserRole("SELLER", "Seller", "User responsible for commercializing products.");
    public static final UserRole LOGISTIC_OPERATOR = new UserRole("LOGISTIC_OPERATOR", "Logistic Operator", "User responsible for warehouse and dispatch operations.");
    public static final UserRole ADMINISTRATOR = new UserRole("ADMINISTRATOR", "Administrator", "User responsible for sellers and warehouses administration.");
    public static final UserRole SUPERVISOR = new UserRole("SUPERVISOR", "Supervisor", "User responsible for operational consultation and monitoring.");

    private UserRole(String code, String name, String description) {
        super(code, name, description);
    }
}

package com.nexusmarket.domain.ports.out;
import com.nexusmarket.domain.valueobject.Email;
public interface UserUniquenessPort {
    boolean existsByIdentifier(String identifier);
    boolean existsByEmail(Email email);
}

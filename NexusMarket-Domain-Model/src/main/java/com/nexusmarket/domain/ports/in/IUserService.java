package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.*;
import com.nexusmarket.domain.valueobject.*;
import java.util.*;
public interface IUserService {
    User register(User actor, User user);
    User consult(User actor, String id);
    User changeStatus(User actor, String id, UserStatus status);
}

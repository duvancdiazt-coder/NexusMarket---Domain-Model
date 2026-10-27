package com.nexusmarket.domain.ports.in;
import com.nexusmarket.domain.model.*;
public interface IReturnService {
    Return request(User actor, Return request);
    Return consult(User actor, String id);
}

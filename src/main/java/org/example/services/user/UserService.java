package org.example.services.user;

import org.example.dtos.request.LoginRequest;
import org.example.dtos.request.RegisterRequest;

public interface UserService {
    void register(RegisterRequest registerRequest);

    void login(LoginRequest loginRequest);
}

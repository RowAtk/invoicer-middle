package com.rowatk.invoicer.auth;

import com.rowatk.invoicer.models.company.User;

import java.util.Optional;

public interface UserAuthService {

//    Optional<User> register(User user);

    Optional<String> login(String username, String password);

    Optional<User> findByToken(String token);

    void logout(User user);
}

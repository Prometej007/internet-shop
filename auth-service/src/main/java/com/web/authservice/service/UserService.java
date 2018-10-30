package com.web.authservice.service;

import com.web.authservice.model.User;

public interface UserService {
    User findByUsername(String username);
    User create(String username,String password);
    User save(User user);
}

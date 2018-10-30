package com.web.authservice.service.impl;

import com.web.authservice.model.User;
import com.web.authservice.repository.UserRepository;
import com.web.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User create(String username, String password) {
        return userRepository.save(new User().setUsername(username).setPassword(passwordEncoder.encode(password)));
    }

    @Override
    public User save(User user) {
        if (!ofNullable(findByUsername(user.getUsername())).isPresent())
            return userRepository.save(user.setPassword(passwordEncoder.encode(user.getPassword())));
        else
            return findByUsername(user.getUsername());
    }
}

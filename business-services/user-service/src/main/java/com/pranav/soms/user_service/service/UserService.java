package com.pranav.soms.user_service.service;

import com.pranav.soms.user_service.model.User;
import com.pranav.soms.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER"); // default role
        return repository.save(user);
    }

    public boolean existsByUsername(String username) {
        System.out.println("Checking if username exists: " + username);
        if(repository.findByUsername(username).isPresent()){
            return true;
        } else {
            System.out.println("Username does not exist: " + username);
            return false;
        }
    }
}

package com.pranav.soms.user_service.controller;

import com.pranav.soms.user_service.model.AuthenticationRequest;
import com.pranav.soms.user_service.model.AuthenticationResponse;
import com.pranav.soms.user_service.model.User;
import com.pranav.soms.user_service.service.AuthenticationService;
import com.pranav.soms.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        System.out.println("Registering user: " + user);
        if (user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if (user.getUsername().length() < 3 || user.getPassword().length() < 6) {
            return ResponseEntity.badRequest().build();
        }
        System.out.println("User credentials are valid, checking for existing username.");
        if (service.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        System.out.println("User is valid, proceeding with registration.");
        return ResponseEntity.ok(service.register(user));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}

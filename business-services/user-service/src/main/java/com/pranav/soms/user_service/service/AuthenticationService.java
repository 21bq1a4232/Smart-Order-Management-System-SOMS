package com.pranav.soms.user_service.service;

import com.pranav.soms.user_service.model.AuthenticationRequest;
import com.pranav.soms.user_service.model.AuthenticationResponse;
import com.pranav.soms.user_service.model.User;
import com.pranav.soms.user_service.repository.UserRepository;
import com.pranav.soms.user_service.security.JwtService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}

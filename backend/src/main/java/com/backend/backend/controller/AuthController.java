package com.backend.backend.controller;

import com.backend.backend.model.User;
import com.backend.backend.model.AuthRequest;
import com.backend.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            Optional<User> user = userRepository.findByEmail(request.getEmail());
            return ResponseEntity.ok(user);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
    }
}

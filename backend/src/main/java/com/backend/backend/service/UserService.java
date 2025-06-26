package com.backend.backend.service;

import com.backend.backend.model.User;
import com.backend.backend.repository.UserRepository;
import com.backend.backend.exception.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User cadastrar(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        return repository.save(user);
    }

    public List<User> listarTodos() {
        return repository.findAll();
    }

    public User buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com ID " + id + " não encontrado"));
    }
}

package com.backend.backend.servico;

import com.backend.backend.model.User;
import com.backend.backend.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User salvar(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
    

    public Optional<User> buscarPorEmail(String email) {
        return repo.findByEmail(email);
    }

    public List<User> listarUsuarios() {
        return repo.findAll();
    }

}
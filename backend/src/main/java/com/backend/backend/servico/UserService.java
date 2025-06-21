package com.backend.backend.servico;

import com.backend.backend.modelo.User;
import com.backend.backend.repositorio.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User salvar(User user) {
        return repo.save(user);
    }

    public List<User> listar() {
        return repo.findAll();
    }

}

package com.backend.backend.controller;

import com.backend.backend.model.User;
import com.backend.backend.servico.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User cadastrar(@RequestBody User user) {
        return service.cadastrar(user);
    }

    @GetMapping
    public List<User> listar() {
        return service.listarTodos();
    }
}

package com.backend.backend.controle;

import com.backend.backend.modelo.User;
import com.backend.backend.servico.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/usuarios")
public List<User> listar() {
    return service.listarUsuarios();
}

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody User user) {
        Optional<User> existente = service.buscarPorEmail(user.getEmail());
        if (existente.isPresent()) {
            return ResponseEntity.badRequest().body("Email já cadastrado.");
        }
        User salvo = service.salvar(user);
        return ResponseEntity.ok(salvo);
    }
}

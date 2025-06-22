package com.backend.backend.controle;

import com.backend.backend.modelo.Store;
import com.backend.backend.servico.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lojas")
public class StoreController {
    private final StoreService service;

    public StoreController(StoreService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Store> criar(@RequestBody Store loja) {
        Store salvo = service.salvar(loja);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public List<Store> listar() {
        return service.listar();
    }
}
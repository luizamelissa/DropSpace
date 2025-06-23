package com.backend.backend.controller;

import com.backend.backend.model.Store;
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
    public ResponseEntity<Store> criar(@RequestBody Store store) {
        Store salvo = service.salvar(store);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public List<Store> listar() {
        return service.listar();
    }
}
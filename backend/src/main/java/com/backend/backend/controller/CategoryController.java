package com.backend.backend.controller;

import com.backend.backend.model.Category;
import com.backend.backend.servico.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Category> criar(@RequestBody Category categoria) {
        return ResponseEntity.ok(service.salvar(categoria));
    }

    @GetMapping
    public List<Category> listar() {
        return service.listar();
    }
}
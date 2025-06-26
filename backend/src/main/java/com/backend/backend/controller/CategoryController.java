package com.backend.backend.controller;

import com.backend.backend.model.Category;
import com.backend.backend.service.CategoryService;

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
    public Category criar(@RequestBody Category category) {
        return service.salvar(category);
    }

    @GetMapping
    public List<Category> listar() {
        return service.listar();
    }
}

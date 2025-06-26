package com.backend.backend.controller;

import com.backend.backend.model.Supplier;
import com.backend.backend.service.SupplierService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class SupplierController {

    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @PostMapping
    public Supplier criar(@RequestBody Supplier supplier) {
        return service.salvar(supplier);
    }

    @GetMapping
    public List<Supplier> listar() {
        return service.listar();
    }
}

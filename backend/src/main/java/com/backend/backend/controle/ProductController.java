package com.backend.backend.controle;

import com.backend.backend.modelo.Product;
import com.backend.backend.servico.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Product produto) {
        try {
            Product salvo = service.salvar(produto);
            return ResponseEntity.ok(salvo);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Product> listar() {
        return service.listarTodos();
    }
}

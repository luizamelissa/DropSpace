package com.backend.backend.controller;

import com.backend.backend.model.Product;
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
    public Product criar(@RequestBody Product produto) {
        return service.salvar(produto);
    }

    @GetMapping
    public List<Product> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
public Product atualizar(@PathVariable Long id, @RequestBody Product produto) {
    return service.atualizar(id, produto);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deletar(@PathVariable Long id) {
    service.deletar(id);
    return ResponseEntity.noContent().build();
}

    @GetMapping("/loja/{storeId}")
public List<Product> listarPorLoja(@PathVariable Long storeId) {
    return service.listarPorLoja(storeId);
}

@GetMapping("/search")
public List<Product> pesquisar(
        @RequestParam(required = false) String nome,
        @RequestParam(required = false) Long categoria) {
    return service.filtrar(nome, categoria);
}

}

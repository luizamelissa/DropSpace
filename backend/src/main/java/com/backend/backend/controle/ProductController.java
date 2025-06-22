package com.backend.backend.controle;

import com.backend.backend.modelo.Product;
import com.backend.backend.modelo.ProductRequest;
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
    public ResponseEntity<?> criar(@RequestBody ProductRequest request) {
        try {
            Product product = new Product();
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setPrice(request.getPrice());
            product.setStock(request.getStock());
            Product salvo = service.salvar(product, request.getStoreId(), request.getCategoryId());

            return ResponseEntity.ok(salvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Product> listar() {
        return service.listar();
    }
    

    @GetMapping("/loja/{storeId}")
public ResponseEntity<List<Product>> listarPorLoja(@PathVariable Long storeId) {
    List<Product> produtos = service.listarPorLoja(storeId);
    return ResponseEntity.ok(produtos);
}
}

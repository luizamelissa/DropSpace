package com.backend.backend.controle;

import com.backend.backend.modelo.Product;
import com.backend.backend.servico.ProductService;
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
    public Product criar(@RequestBody Product product) {
        return service.salvar(product);
    }

    @GetMapping
    public List<Product> listar() {
        return service.listarTodos();
    }
}

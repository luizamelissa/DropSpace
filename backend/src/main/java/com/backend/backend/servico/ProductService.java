package com.backend.backend.servico;

import com.backend.backend.modelo.Product;
import com.backend.backend.repositorio.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product salvar(Product product) {
        return repo.save(product);
    }

    public List<Product> listarTodos() {
        return repo.findAll();
    }
}

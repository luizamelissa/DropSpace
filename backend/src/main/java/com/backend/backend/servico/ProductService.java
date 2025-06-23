package com.backend.backend.servico;

import com.backend.backend.model.Product;
import com.backend.backend.repository.ProductRepository;
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

    public List<Product> listar() {
        return repo.findAll();
    }
}

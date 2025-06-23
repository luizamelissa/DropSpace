package com.backend.backend.servico;

import com.backend.backend.model.Category;
import com.backend.backend.model.Product;
import com.backend.backend.model.Store;
import com.backend.backend.repository.CategoryRepository;
import com.backend.backend.repository.ProductRepository;
import com.backend.backend.repository.StoreRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repo, StoreRepository storeRepository, CategoryRepository categoryRepository) {
        this.repo = repo;
        this.storeRepository = storeRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product salvar(Product product, Long storeId, Long categoryId) {
        Store store = storeRepository.findById(storeId)
            .orElseThrow(() -> new IllegalArgumentException("Loja não encontrada"));
        product.setStore(store);

        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        product.setCategory(category);

        return repo.save(product);
    }

    public List<Product> listarPorLoja(Long storeId) {
        return repo.findByStoreId(storeId);
    }

    public List<Product> listar() {
        return repo.findAll();
    }
}
package com.backend.backend.servico;

import com.backend.backend.modelo.Product;
import com.backend.backend.repositorio.ProductRepository;
import com.backend.backend.repositorio.StoreRepository;
import com.backend.backend.modelo.Store;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final StoreRepository storeRepository;

    public ProductService(ProductRepository repo, StoreRepository storeRepository) {
        this.repo = repo;
        this.storeRepository = storeRepository;
    }

    public Product salvar(Product product, Long storeId) {
        Optional<Store> optionalStore = storeRepository.findById(storeId);
        if (optionalStore.isEmpty()) {
            throw new IllegalArgumentException("Loja com ID " + storeId + " não encontrada.");
        }
        product.setStore(optionalStore.get());
        return repo.save(product);
    }

    public List<Product> listar() {
        return repo.findAll();
    }
}

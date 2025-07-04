package com.backend.backend.service;

import com.backend.backend.model.Product;
import com.backend.backend.model.Store;
import com.backend.backend.repository.ProductRepository;
import com.backend.backend.repository.StoreRepository;
import com.backend.backend.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final StoreRepository storeRepository;

    public ProductService(ProductRepository repo, StoreRepository storeRepository) {
        this.repo = repo;
        this.storeRepository = storeRepository;
    }

    public Product salvar(Product product) {
        return repo.save(product);
    }

    public List<Product> listar() {
        return repo.findAll();
    }

    public Product atualizar(Long id, Product produtoAtualizado) {
        Product produtoExistente = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com ID " + id + " não encontrado"));

        produtoExistente.setName(produtoAtualizado.getName());
        produtoExistente.setDescription(produtoAtualizado.getDescription());
        produtoExistente.setPrice(produtoAtualizado.getPrice());
        produtoExistente.setStock(produtoAtualizado.getStock());
        produtoExistente.setCategory(produtoAtualizado.getCategory());
        produtoExistente.setStore(produtoAtualizado.getStore());

        return repo.save(produtoExistente);
    }

    public void deletar(Long id) {
        Product produto = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com ID " + id + " não encontrado"));
        repo.delete(produto);
    }

    public List<Product> listarPorLoja(Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Loja com ID " + storeId + " não encontrada"));
        return repo.findByStore(store);
    }

    public List<Product> filtrar(String nome, Long categoriaId) {
        if (nome != null && categoriaId != null) {
            return repo.findByNameContainingIgnoreCaseAndCategory_Id(nome, categoriaId);
        } else if (nome != null) {
            return repo.findByNameContainingIgnoreCase(nome);
        } else if (categoriaId != null) {
            return repo.findByCategory_Id(categoriaId);
        } else {
            return repo.findAll();
        }
    }
}

package com.backend.backend.servico;

import com.backend.backend.model.Product;
import com.backend.backend.model.Store;
import com.backend.backend.repository.StoreRepository;
import com.backend.backend.repository.ProductRepository;
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
        .orElseThrow(() -> new RuntimeException("Produto não encontrado com id " + id));

    produtoExistente.setName(produtoAtualizado.getName());
    produtoExistente.setDescription(produtoAtualizado.getDescription());
    produtoExistente.setPrice(produtoAtualizado.getPrice());
    produtoExistente.setStock(produtoAtualizado.getStock());
    produtoExistente.setCategory(produtoAtualizado.getCategory());
    produtoExistente.setStore(produtoAtualizado.getStore());

    return repo.save(produtoExistente);
}

public void deletar(Long id) {
    repo.deleteById(id);
}

public List<Product> listarPorLoja(Long storeId) {
    Store store = storeRepository.findById(storeId)
            .orElseThrow(() -> new RuntimeException("Loja não encontrada"));
    return repo.findByStore(store);
}

}

package com.backend.backend.servico;

import com.backend.backend.model.Store;
import com.backend.backend.repository.StoreRepository;
import com.backend.backend.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private final StoreRepository repo;

    public StoreService(StoreRepository repo) {
        this.repo = repo;
    }

    public Store salvar(Store store) {
        return repo.save(store);
    }

    public List<Store> listar() {
        return repo.findAll();
    }

    public Store buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loja com ID " + id + " não encontrada"));
    }
}

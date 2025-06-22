package com.backend.backend.servico;

import com.backend.backend.modelo.Store;
import com.backend.backend.repositorio.StoreRepository;
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

    public List<Store> listarTodos() {
        return repo.findAll();
    }
}
package com.backend.backend.service;

import com.backend.backend.model.Supplier;
import com.backend.backend.repository.SupplierRepository;
import com.backend.backend.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository repo;

    public SupplierService(SupplierRepository repo) {
        this.repo = repo;
    }

    public Supplier salvar(Supplier supplier) {
        return repo.save(supplier);
    }

    public List<Supplier> listar() {
        return repo.findAll();
    }

    public Supplier buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fornecedor com ID " + id + " não encontrado"));
    }
}

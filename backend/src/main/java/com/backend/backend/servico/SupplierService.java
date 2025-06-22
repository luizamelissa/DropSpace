package com.backend.backend.servico;

import com.backend.backend.modelo.Supplier;
import com.backend.backend.repositorio.SupplierRepository;
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
}
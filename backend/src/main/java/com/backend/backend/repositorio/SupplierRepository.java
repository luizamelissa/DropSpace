package com.backend.backend.repositorio;

import com.backend.backend.modelo.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}

package com.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}

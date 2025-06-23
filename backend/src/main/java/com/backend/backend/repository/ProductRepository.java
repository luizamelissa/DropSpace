package com.backend.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStoreId(Long storeId);
}

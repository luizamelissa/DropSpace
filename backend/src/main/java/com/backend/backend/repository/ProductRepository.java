package com.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

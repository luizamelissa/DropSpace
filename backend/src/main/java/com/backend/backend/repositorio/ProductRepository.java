package com.backend.backend.repositorio;

import com.backend.backend.modelo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

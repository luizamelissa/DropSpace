package com.backend.backend.repositorio;

import java.util.List;
import com.backend.backend.modelo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStoreId(Long storeId);
}

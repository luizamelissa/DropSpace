package com.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.backend.model.Product;

import java.util.List;
import com.backend.backend.model.Store;

public interface ProductRepository extends JpaRepository<Product, Long> {
List<Product> findByStore(Store store);

List<Product> findByNameContainingIgnoreCaseAndCategory_Id(String name, Long categoryId);

List<Product> findByNameContainingIgnoreCase(String name);

List<Product> findByCategory_Id(Long categoryId);
}

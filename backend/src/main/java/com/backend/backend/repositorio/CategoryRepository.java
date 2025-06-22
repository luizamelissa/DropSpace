package com.backend.backend.repositorio;

import com.backend.backend.modelo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}

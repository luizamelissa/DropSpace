package com.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}

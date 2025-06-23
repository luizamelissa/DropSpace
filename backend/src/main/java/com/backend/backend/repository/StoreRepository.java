package com.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {}

package com.backend.backend.repositorio;

import com.backend.backend.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}

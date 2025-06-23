package com.backend.backend.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DataIntegrityViolationException.class, SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<Map<String, String>> handleDatabaseExceptions(Exception ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", "Já existe um usuário com esse e-mail.");
        return ResponseEntity.badRequest().body(erro);
    }
}

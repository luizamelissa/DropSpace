package com.backend.backend.modelo;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}

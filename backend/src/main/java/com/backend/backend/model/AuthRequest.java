package com.backend.backend.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}

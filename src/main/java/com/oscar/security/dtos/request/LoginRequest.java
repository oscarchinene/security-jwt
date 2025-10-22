package com.oscar.security.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

        @Email(message = "Email é obrigatório")
        @NotBlank(message = "E-mail é obrigatório")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        String password
) {}

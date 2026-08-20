package com.tcc.nutriapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioPatchDto( String nome, @Email String email, @Size(min = 6) String senha) {
}

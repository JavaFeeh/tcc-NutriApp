package com.tcc.nutriapp.dto;

import com.tcc.nutriapp.entity.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateDto(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(min = 6) String senha,@NotNull TipoUsuario tipoUsuario) {
}

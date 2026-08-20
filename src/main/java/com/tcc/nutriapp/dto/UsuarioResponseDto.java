package com.tcc.nutriapp.dto;

import com.tcc.nutriapp.entity.TipoUsuario;

public record UsuarioResponseDto(Long id, String nome, String email, TipoUsuario tipoUsuario) {
}

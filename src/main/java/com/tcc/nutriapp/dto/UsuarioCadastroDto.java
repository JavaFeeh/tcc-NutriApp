package com.tcc.nutriapp.dto;

import com.tcc.nutriapp.entity.TipoUsuario;

public record UsuarioCadastroDto(String nome, String email, String senha, TipoUsuario tipoUsuario) {
}

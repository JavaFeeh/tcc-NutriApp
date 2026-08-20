package com.tcc.nutriapp.controller;


import com.tcc.nutriapp.dto.UsuarioCadastroDto;
import com.tcc.nutriapp.dto.UsuarioResponseDto;
import com.tcc.nutriapp.dto.UsuarioUpdateDto;
import com.tcc.nutriapp.entity.Usuario;
import com.tcc.nutriapp.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private UsuarioService usuarioServ;

    public UsuarioController(UsuarioService usuarioServ){
        this.usuarioServ = usuarioServ;
    }

    @GetMapping
    public List<UsuarioResponseDto> getUsuarios(){
        return usuarioServ.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDto getUsuario(@PathVariable Long id){
        return usuarioServ.getUsuario(id);
    }

    @PostMapping
    public UsuarioResponseDto postUsuario(@RequestBody UsuarioCadastroDto usuNovo){
        return usuarioServ.postUsuario(usuNovo);
    }

    @DeleteMapping("/{id}")
    public void delUsuario(@PathVariable Long id){
        usuarioServ.delUsuario(id);
    }

    @PutMapping("/{id}")
    public Usuario putUsuario(@PathVariable Long id, @RequestBody Usuario usuarioNovo){
       return usuarioServ.putUsuario(usuarioNovo, id);
    }

    @PatchMapping("/{id}")
    public Usuario patchUsuario(@PathVariable Long id, @RequestBody UsuarioUpdateDto usuario){
        return usuarioServ.patchUsuario(id, usuario);
    }
}

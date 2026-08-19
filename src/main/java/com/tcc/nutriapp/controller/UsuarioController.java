package com.tcc.nutriapp.controller;


import com.tcc.nutriapp.entity.Usuario;
import com.tcc.nutriapp.exception.ResourceNotFoundException;
import com.tcc.nutriapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired UsuarioRepository usuarioRepo;

    @GetMapping
    public List<Usuario> GetUsuarios(){
        return usuarioRepo.findAll();
    }

    @PostMapping
    public Usuario postUsuario(@RequestBody Usuario usuNovo){
        return usuarioRepo.save(usuNovo);
    }

    @DeleteMapping("/{id}")
    public void delUsuario(@PathVariable Long id){
        usuarioRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    public Usuario putUsuario(@PathVariable Long id, @RequestBody Usuario usuarioNovo){
       Usuario usuario = usuarioRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado!"));

       if(!usuarioNovo.getNome().isEmpty()){ usuario.setNome(usuarioNovo.getNome());}
       if(!usuarioNovo.getEmail().isEmpty()){ usuario.setEmail(usuarioNovo.getEmail());}
       if(!usuarioNovo.getSenha().isEmpty()){ usuario.setSenha(usuarioNovo.getSenha()); }

        return usuarioRepo.save(usuario);
    }
}

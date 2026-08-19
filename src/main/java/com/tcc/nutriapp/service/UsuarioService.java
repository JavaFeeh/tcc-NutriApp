package com.tcc.nutriapp.service;

import com.tcc.nutriapp.dto.UsuarioDto;
import com.tcc.nutriapp.entity.Usuario;
import com.tcc.nutriapp.exception.ResourceNotFoundException;
import com.tcc.nutriapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired UsuarioRepository usuarioRepo;

    public Usuario postUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepo.findAll();
    }

    public Usuario getUusario(Long id){
        return usuarioRepo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Usuario não encontrado!"));

    }

    public Usuario putUsuario(Usuario usuarioNovo, Long id){
        Usuario usuario = usuarioRepo.findById(id).orElseThrow( () -> ResourceNotFoundException("Usuario não encontrado!"));

        usuario.setNome(usuarioNovo.getNome());
        usuario.setSenha(usuarioNovo.getSenha());
        usuario.setEmail(usuarioNovo.getEmail());
        usuario.setTipoUsuario(usuarioNovo.getTipoUsuario());

        return usuarioRepo.save(usuario);

    public Usuario patchUsuario(UsuarioDto usuarioNovo)
    }


}

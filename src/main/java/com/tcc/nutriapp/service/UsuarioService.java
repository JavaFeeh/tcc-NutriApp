package com.tcc.nutriapp.service;

import com.tcc.nutriapp.dto.UsuarioCadastroDto;
import com.tcc.nutriapp.dto.UsuarioResponseDto;
import com.tcc.nutriapp.dto.UsuarioPatchDto;
import com.tcc.nutriapp.dto.UsuarioUpdateDto;
import com.tcc.nutriapp.entity.Usuario;
import com.tcc.nutriapp.exception.ResourceNotFoundException;
import com.tcc.nutriapp.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepo;

    public UsuarioService(UsuarioRepository usuarioRepo){
       this.usuarioRepo = usuarioRepo;
    }

    //Procurar(Usuario)
    public UsuarioResponseDto getUsuario(Long id){
        Usuario usuario = usuarioRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Usuario não encontrado!"));

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto(usuario.getId(), usuario.getNome(),
                usuario.getEmail(), usuario.getTipoUsuario());

        return usuarioResponseDto;
    }

    //Listar(Usuarios)
    public List<UsuarioResponseDto> listarUsuarios(){
        List<Usuario> usuarios = usuarioRepo.findAll();
        List<UsuarioResponseDto> usuarioResponseDtos= new ArrayList<UsuarioResponseDto>();

        for(Usuario usu: usuarios){

            UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto(usu.getId(), usu.getNome(),
                    usu.getEmail(), usu.getTipoUsuario());
            usuarioResponseDtos.add(usuarioResponseDto);

        }

        return usuarioResponseDtos;

    }

    //Adicionar(Usuario)
    public UsuarioResponseDto postUsuario( UsuarioCadastroDto usuario){
        Usuario usuNovo = new Usuario(usuario.nome(), usuario.email(), usuario.senha(), usuario.tipoUsuario());
        usuNovo = usuarioRepo.save(usuNovo);
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto(usuNovo.getId(), usuNovo.getNome(),
                usuNovo.getEmail(), usuNovo.getTipoUsuario());
        return usuarioResponseDto;
    }

    //Deletar(Usuario)
    public void delUsuario(Long id){
       usuarioRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario não encontrado!"));
       usuarioRepo.deleteById(id);
    }

    //Atualizar(Usuario)
    public UsuarioResponseDto putUsuario(UsuarioUpdateDto usuarioNovo, Long id) {
        Usuario usuario = usuarioRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Usuario não encontrado!"));

        usuario.setNome(usuarioNovo.nome());
        usuario.setSenha(usuarioNovo.senha());
        usuario.setEmail(usuarioNovo.email());
        usuario.setTipoUsuario(usuarioNovo.tipoUsuario());

        Usuario usuarioSave = usuarioRepo.save(usuario);

        UsuarioResponseDto usuarioAtualizado = new UsuarioResponseDto(usuarioSave.getId(), usuarioSave.getNome(),
                usuarioSave.getEmail(), usuarioSave.getTipoUsuario());


        return usuarioAtualizado;
    }

    //Atualizar parcialmente(Usuario)
    public UsuarioResponseDto patchUsuario(Long id, UsuarioPatchDto usuarioNovo) {
        Usuario usuario = usuarioRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado!"));

        if(usuarioNovo.email() != null){
            usuario.setEmail(usuarioNovo.email());
        }

        if(usuarioNovo.nome() != null){
            usuario.setNome(usuarioNovo.nome());
        }

        if(usuarioNovo.senha() != null){
            usuario.setSenha(usuarioNovo.senha());
        }

        Usuario usuarioSave = usuarioRepo.save(usuario);

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto(usuarioSave.getId(), usuarioSave.getNome(), usuarioSave.getEmail(), usuarioSave.getTipoUsuario());

        return usuarioResponseDto;
    }



}




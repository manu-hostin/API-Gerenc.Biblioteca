package com.exemplo.bilbioteca.mapper;

import com.exemplo.bilbioteca.dto.UsuarioRequisicaoDTO;
import com.exemplo.bilbioteca.dto.UsuarioRespostaDTO;
import com.exemplo.bilbioteca.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper {
    public Usuario paraEntidade (UsuarioRequisicaoDTO usuarioRequisicaoDTO){
        return new Usuario (
                usuarioRequisicaoDTO.nome(),
                usuarioRequisicaoDTO.email()
        );
    }
    public UsuarioRespostaDTO paraRespostaDTO (Usuario user){
        return new UsuarioRespostaDTO(
                user.getId(),
                user.getNome(),
                user.getEmail()
        );
    }

    public List<UsuarioRespostaDTO> paraRespostaLista (List<Usuario> lista){
        List<UsuarioRespostaDTO> users = new ArrayList<>();

        for (Usuario user : lista){
            users.add(paraRespostaDTO(user));
        }
        return users;
    }
}

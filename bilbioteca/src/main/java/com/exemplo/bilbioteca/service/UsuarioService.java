package com.exemplo.bilbioteca.service;

import com.exemplo.bilbioteca.DAO.UsuarioDAO;
import com.exemplo.bilbioteca.dto.UsuarioRequisicaoDTO;
import com.exemplo.bilbioteca.dto.UsuarioRespostaDTO;
import com.exemplo.bilbioteca.mapper.UsuarioMapper;
import com.exemplo.bilbioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDAO repo;

    private final UsuarioMapper mapper;

    public UsuarioService (UsuarioDAO repo, UsuarioMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    public UsuarioRespostaDTO cadastrarUser (UsuarioRequisicaoDTO requisicaoDTO) throws SQLException {
        Usuario user = mapper.paraEntidade(requisicaoDTO);
        return mapper.paraRespostaDTO(repo.cadastrarUsuario(user));
    }

    public List<UsuarioRespostaDTO> listarUsers () throws SQLException {
        List<Usuario> lista = repo.listarUsuarios();
        return mapper.paraRespostaLista(lista);
    }

    public Usuario listarUserID(int id) throws SQLException {
        return repo.listarUsuarioID(id);
    }

    public boolean atualizarUsuario(Usuario user, int id) throws SQLException {
        return repo.atualizarUsuarios(user, id);
    }

    public boolean deletarUsuarios(int id) throws SQLException {
        return repo.deletarUser(id);
    }

}

package com.exemplo.bilbioteca.service;

import com.exemplo.bilbioteca.DAO.UsuarioDAO;
import com.exemplo.bilbioteca.model.Emprestimo;
import com.exemplo.bilbioteca.model.Livro;
import com.exemplo.bilbioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDAO repo;

    public UsuarioService (UsuarioDAO repo){
        this.repo = repo;
    }

    public void cadastrarUser (Usuario user) throws SQLException {
        repo.cadastrarUsuario(user);
    }

    public List<Usuario> listarUsers () throws SQLException {
        return repo.listarUsuarios();
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

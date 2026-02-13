package com.weg.olamundo.service;

import com.weg.olamundo.model.Usuario;
import com.weg.olamundo.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<Usuario> obterUsuarios() throws SQLException {
        return userRepo.listarUser();
    }

    public Usuario salvarUser(Usuario user) throws SQLException {
        userRepo.salvarUser(user);
        return user;
    }

    public Usuario atualizarUsuario (Usuario user, int id) throws SQLException {
        user.setId(id);
        userRepo.atualizarUsuario(user);

        return user;
    }

    public Usuario buscarCttPorID (int id) throws SQLException {
        return userRepo.buscarCttPorID(id);
    }

    public void deletarPorID(int id) throws SQLException {
        if (!userRepo.contatoExiste(id)) {
            throw new RuntimeException("Contato não existe!");
        }
        userRepo.deletarCttPorID(id);
    }
}

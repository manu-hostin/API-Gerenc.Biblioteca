package com.weg.olamundo.controller;

import com.weg.olamundo.model.Usuario;
import com.weg.olamundo.repository.UserRepo;
import com.weg.olamundo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class OlaMundoController {

    private final UserService usuarioService;
    public OlaMundoController(UserService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/id-teste")
    public List<Usuario> buscarIDTeste () { // SEM SQLEXCEPTION, com try-catch
        List<Usuario> lista = new ArrayList<>();

        try {
            lista = usuarioService.obterUsuarios();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    @PostMapping("/cadastro")
    public Usuario postUser (@RequestBody Usuario user) { // Na hora de testar no postman, tem que ser com o mesmo nome/atributo daqui do intelliJ

        try {
            user = usuarioService.salvarUser(user);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @PutMapping("/{id}") // aqui tem que ser o mesmo nome do parametro entre ()
    public Usuario atualizarUsuario (@PathVariable int id, @RequestBody Usuario user) {

        try {
            return user = usuarioService.atualizarUsuario(user, id); // Segue a ordem dos parâmetros do service
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Usuario buscarContatoPorID (@PathVariable int id) {
        try {
            return usuarioService.buscarCttPorID(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletarContato (@PathVariable int id) {
        try {
            usuarioService.deletarPorID(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

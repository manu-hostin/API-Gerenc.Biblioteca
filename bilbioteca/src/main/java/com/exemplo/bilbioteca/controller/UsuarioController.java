package com.exemplo.bilbioteca.controller;

import com.exemplo.bilbioteca.dto.UsuarioRequisicaoDTO;
import com.exemplo.bilbioteca.dto.UsuarioRespostaDTO;
import com.exemplo.bilbioteca.model.Usuario;
import com.exemplo.bilbioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    @PostMapping ("/usuarios/cadastrar")
    public UsuarioRespostaDTO postUser (@RequestBody UsuarioRequisicaoDTO requisicaoDTO) {
        try {
            return service.cadastrarUser(requisicaoDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/usuarios/listar")
    public List<UsuarioRespostaDTO> getUsuarios () {
        List<Usuario> lista = new ArrayList<>();
        try {
            return service.listarUsers();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/usuarios/listar/{id}")
    public Usuario getUsuarioID (@PathVariable int id) {
        try {
            return service.listarUserID(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/usuarios/atualizar/{id}")
    public boolean putUser (@RequestBody Usuario user, @PathVariable int id) {
        try {
            return service.atualizarUsuario(user, id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/usuarios/deletar/{id}")
    public boolean deleteUser (@PathVariable int id){
        try {
            return service.deletarUsuarios(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }





}

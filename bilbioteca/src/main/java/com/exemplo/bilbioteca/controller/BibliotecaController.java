package com.exemplo.bilbioteca.controller;

import com.exemplo.bilbioteca.model.Livro;
import com.exemplo.bilbioteca.service.LivroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {

    private final LivroService service;

    public BibliotecaController (LivroService service){
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public Livro postLivro (@RequestBody Livro livro){
        try {
            livro = service.cadastrarLivro(livro);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return livro;
    }
}

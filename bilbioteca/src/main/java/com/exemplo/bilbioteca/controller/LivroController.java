package com.exemplo.bilbioteca.controller;

import com.exemplo.bilbioteca.model.Livro;
import com.exemplo.bilbioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service){
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

    @GetMapping("/listar")
    public List<Livro> getLivro (){
        List<Livro> livros = new ArrayList<>();
        try {
            livros = service.listarLivros();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return livros;
    }
}

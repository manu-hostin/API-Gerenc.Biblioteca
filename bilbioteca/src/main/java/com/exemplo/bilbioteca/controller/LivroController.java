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

    @PostMapping("/livros/cadastrar")
    public Livro postLivro (@RequestBody Livro livro) {
        try {
            livro = service.cadastrarLivro(livro);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return livro;
    }

    @GetMapping("/livros/listar")
    public List<Livro> getLivro (){
        List<Livro> livros = new ArrayList<>();
        try {
            livros = service.listarLivros();
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return livros;
    }

    @GetMapping("/livros/listar/{id}")
    public Livro getLivroID (@PathVariable int id) {
        try {
            return service.listarLivrosID(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/livros/atualizar/{id}")
    public boolean putLivro (@PathVariable int id, @RequestBody Livro livro){
        try {
            return service.atualizarLivro(id, livro);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/livros/deletar/{id}")
    public boolean deleteLivro (@PathVariable int id) {
        try {
            return service.deletarLivro(id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

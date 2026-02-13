package com.exemplo.bilbioteca.service;

import com.exemplo.bilbioteca.DAO.LivroDAO;
import com.exemplo.bilbioteca.model.Livro;

import java.sql.SQLException;

public class LivroService {

    private final LivroDAO repo;

    public LivroService (LivroDAO repo) {
        this.repo = repo;
    }

    public Livro cadastrarLivro (Livro livro) throws SQLException {
        return repo.cadastrarLivro(livro);
    }
}

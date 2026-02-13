package com.exemplo.bilbioteca.service;

import com.exemplo.bilbioteca.DAO.LivroDAO;
import com.exemplo.bilbioteca.model.Livro;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LivroService {

    private final LivroDAO repo;

    public LivroService (LivroDAO repo) {
        this.repo = repo;
    }

    public Livro cadastrarLivro (Livro livro) throws SQLException {
        return repo.cadastrarLivro(livro);
    }

    public List<Livro> listarLivros () throws SQLException {
        return repo.obterLivros();
    }
}

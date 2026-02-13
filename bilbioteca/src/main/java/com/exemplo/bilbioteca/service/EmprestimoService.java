package com.exemplo.bilbioteca.service;

import com.exemplo.bilbioteca.DAO.EmprestimoDAO;
import com.exemplo.bilbioteca.model.Emprestimo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

@Service
public class EmprestimoService {

    private final EmprestimoDAO repo;

    public EmprestimoService(EmprestimoDAO repo) {
        this.repo = repo;
    }

    public Emprestimo cadastrarEmprestimo (@RequestBody Emprestimo emprestimo) throws SQLException {
        return repo.cadastrarEmprestimo(emprestimo);
    }
}

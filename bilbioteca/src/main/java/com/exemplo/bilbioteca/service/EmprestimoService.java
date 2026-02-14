package com.exemplo.bilbioteca.service;

import com.exemplo.bilbioteca.DAO.EmprestimoDAO;
import com.exemplo.bilbioteca.model.Emprestimo;
import com.exemplo.bilbioteca.model.Livro;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoDAO repo;

    public EmprestimoService(EmprestimoDAO repo) {
        this.repo = repo;
    }

    public Emprestimo cadastrarEmprestimo (@RequestBody Emprestimo emprestimo) throws SQLException {
        return repo.cadastrarEmprestimo(emprestimo);
    }

    public List<Emprestimo> listarEmprestimos() throws SQLException {
        return repo.listarEmprestimos();
    }

    public List<Emprestimo> listarEmprestimosID(int id) throws SQLException {
        return repo.listarEmprestimosID(id);
    }

    public boolean atualizarEmprestimo (Emprestimo emprestimo, int id) throws SQLException {
        return repo.atualizarEmprestimo(emprestimo, id);
    }
    public boolean deletarEmprestimo(int id) throws SQLException {
        return repo.deletarEmprestimo(id);
    }

}

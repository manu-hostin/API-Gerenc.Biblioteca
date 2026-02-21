package com.exemplo.bilbioteca.service;

import com.exemplo.bilbioteca.DAO.EmprestimoDAO;
import com.exemplo.bilbioteca.dto.EmprestimoRequisicaoDTO;
import com.exemplo.bilbioteca.dto.EmprestimoRespostaDTO;
import com.exemplo.bilbioteca.mapper.EmprestimoMapper;
import com.exemplo.bilbioteca.model.Emprestimo;
import com.exemplo.bilbioteca.model.Livro;
import com.exemplo.bilbioteca.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoDAO repo;
    private final EmprestimoMapper mapper;

    public EmprestimoService (EmprestimoDAO repo, EmprestimoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public EmprestimoRespostaDTO cadastrarEmprestimo (EmprestimoRequisicaoDTO emprestimoRequisicaoDTO) throws SQLException {
        Emprestimo emp = mapper.paraEntidade(emprestimoRequisicaoDTO);
        return mapper.paraRespostaDTO(repo.cadastrarEmprestimo(emp));
    }

    public List<EmprestimoRespostaDTO> listarEmprestimos () throws SQLException {
        List<Emprestimo> lista = repo.listarEmprestimos();
        return mapper.paraRespostaLista(lista);
    }

    public List<Emprestimo> listarEmprestimosID (int id) throws SQLException {
        return repo.listarEmprestimosID(id);
    }

    public boolean atualizarEmprestimo (Emprestimo emprestimo, int id) throws SQLException {
        return repo.atualizarEmprestimo(emprestimo, id);
    }
    public boolean deletarEmprestimo (int id) throws SQLException {
        return repo.deletarEmprestimo(id);
    }

    public boolean registrarDevolucao (LocalDate devolucao, int id) throws SQLException {
        return repo.registrarDev(devolucao, id);
    }

    public List<Emprestimo> listarEmprestimosDoUser(int id) throws SQLException {
        return repo.listarEmprestimoDoUser(id);
    }
}

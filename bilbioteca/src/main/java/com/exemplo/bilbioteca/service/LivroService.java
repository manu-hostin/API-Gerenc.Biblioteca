package com.exemplo.bilbioteca.service;

import com.exemplo.bilbioteca.DAO.LivroDAO;
import com.exemplo.bilbioteca.dto.LivroRequisicaoDTO;
import com.exemplo.bilbioteca.dto.LivroRespostaDTO;
import com.exemplo.bilbioteca.mapper.LivroMapper;
import com.exemplo.bilbioteca.model.Livro;
import com.exemplo.bilbioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LivroService {

    private final LivroDAO repo;
    private final LivroMapper mapper;

    public LivroService (LivroDAO repo, LivroMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public LivroRespostaDTO cadastrarLivro (LivroRequisicaoDTO livroRequisicaoDTO) throws SQLException {
        Livro livro = mapper.paraEntidade(livroRequisicaoDTO);
        return mapper.paraRespostaDTO(repo.cadastrarLivro(livro));
    }

    public List<LivroRespostaDTO> listarLivros () throws SQLException {
        List<Livro> lista = repo.obterLivros();
        return mapper.paraRespostaLista(lista);
    }
    public Livro listarLivrosID (int id) throws SQLException {
        return repo.obterLivroByID(id);
    }

    public boolean atualizarLivro(int id, Livro livro) throws SQLException {
        return repo.atualizarLivro(id, livro);

    }
    public boolean deletarLivro(int id) throws SQLException {
        return repo.deletarLivro(id);
    }
}

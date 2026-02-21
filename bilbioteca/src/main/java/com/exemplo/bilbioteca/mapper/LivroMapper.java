package com.exemplo.bilbioteca.mapper;

import com.exemplo.bilbioteca.dto.LivroRequisicaoDTO;
import com.exemplo.bilbioteca.dto.LivroRespostaDTO;
import com.exemplo.bilbioteca.model.Livro;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LivroMapper {

    public Livro paraEntidade (LivroRequisicaoDTO livroRequisicaoDTO){
        return new Livro(
                livroRequisicaoDTO.titulo(),
                livroRequisicaoDTO.autor(),
                livroRequisicaoDTO.ano_publicacao()
        );
    }

    public LivroRespostaDTO paraRespostaDTO (Livro livro){
        return new LivroRespostaDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAno_publicacao()
        );
    }

    public List<LivroRespostaDTO> paraRespostaLista (List<Livro> lista){
        List<LivroRespostaDTO> livros = new ArrayList<>();

        for (Livro livro : lista){
            livros.add(paraRespostaDTO(livro));
        }
        return livros;
    }

}

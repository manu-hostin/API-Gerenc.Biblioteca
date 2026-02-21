package com.exemplo.bilbioteca.mapper;

import com.exemplo.bilbioteca.dto.EmprestimoRequisicaoDTO;
import com.exemplo.bilbioteca.dto.EmprestimoRespostaDTO;
import com.exemplo.bilbioteca.model.Emprestimo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmprestimoMapper {

    public Emprestimo paraEntidade (EmprestimoRequisicaoDTO emprestimoRequisicaoDTO){
        return new Emprestimo(
                emprestimoRequisicaoDTO.livro_id(),
                emprestimoRequisicaoDTO.usuario_id(),
                emprestimoRequisicaoDTO.data_emprestimo(),
                emprestimoRequisicaoDTO.data_devolucao()
        );
    }

    public EmprestimoRespostaDTO paraRespostaDTO (Emprestimo emprestimo){
        return new EmprestimoRespostaDTO(
                emprestimo.getId(),
                emprestimo.getLivro_id(),
                emprestimo.getUsuario_id(),
                emprestimo.getData_emprestimo(),
                emprestimo.getData_devolucao()
        );
    }

    public List<EmprestimoRespostaDTO> paraRespostaLista (List<Emprestimo> emp){
        List<EmprestimoRespostaDTO> lista = new ArrayList<>();

        for (Emprestimo emprestimo : emp){
            lista.add(paraRespostaDTO(emprestimo));
        }
        return lista;
    }
}

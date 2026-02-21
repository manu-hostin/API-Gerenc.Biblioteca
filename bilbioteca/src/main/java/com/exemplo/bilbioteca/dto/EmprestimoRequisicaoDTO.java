package com.exemplo.bilbioteca.dto;

import java.time.LocalDate;

public record EmprestimoRequisicaoDTO(
        int livro_id,
        int usuario_id,
        LocalDate data_emprestimo,
        LocalDate data_devolucao
) {
}

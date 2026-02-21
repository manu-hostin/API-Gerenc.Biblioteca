package com.exemplo.bilbioteca.dto;

import java.time.LocalDate;

public record EmprestimoRespostaDTO(
        int id,
        int livro_id,
        int usuario_id,
        LocalDate data_emprestimo,
        LocalDate data_devolucao
) {
}

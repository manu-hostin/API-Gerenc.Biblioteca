package com.exemplo.bilbioteca.dto;

public record LivroRespostaDTO(
        int id,
        String titulo,
        String autor,
        int ano_publicacao
) {
}

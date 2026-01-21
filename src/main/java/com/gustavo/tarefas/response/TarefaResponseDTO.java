package com.gustavo.tarefas.response;

import java.time.LocalDateTime;

public record TarefaResponseDTO(
        Long id,
        String titulo,
        String descricao,
        boolean status,
        String prioridade,
        LocalDateTime dtCriacao,
        LocalDateTime dtFim
) {
}

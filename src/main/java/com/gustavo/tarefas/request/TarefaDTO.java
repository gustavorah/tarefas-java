package com.gustavo.tarefas.request;

import java.time.LocalDateTime;

public record TarefaDTO(
        String titulo,
        String descricao,
        Boolean status,
        String prioridade,
        LocalDateTime dtCriacao,
        LocalDateTime dtFim,
        Long projeto_id
) {
}

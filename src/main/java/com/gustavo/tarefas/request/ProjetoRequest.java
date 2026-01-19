package com.gustavo.tarefas.request;

import java.time.LocalDateTime;

public record ProjetoRequest(
        String nome,
        String descricao,
        LocalDateTime dt_inicio,
        LocalDateTime dt_fim,
        Long usuarioId
) {
}

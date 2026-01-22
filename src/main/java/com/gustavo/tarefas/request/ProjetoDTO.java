package com.gustavo.tarefas.request;

import java.time.LocalDateTime;

public record ProjetoDTO(
        String nome,
        String descricao,
        LocalDateTime dtInicio,
        LocalDateTime dtFim,
        Long usuarioId
) {
}

package com.gustavo.tarefas.response;

import java.time.LocalDateTime;
import java.util.Set;

public record ProjetoResponseDTO (
        Long id,
        String nome,
        String descricao,
        LocalDateTime dtInicio,
        LocalDateTime dtFim,
        Set<TarefaResponseDTO> tarefas
) {
}

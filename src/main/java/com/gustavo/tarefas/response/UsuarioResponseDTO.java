package com.gustavo.tarefas.response;

import java.time.LocalDateTime;
import java.util.Set;

public record UsuarioResponseDTO (
        Long id,
        String nome,
        String email,
//        String senha,
        LocalDateTime dtCriacao,
        Set<ProjetoResponseDTO> projetos
) {
}

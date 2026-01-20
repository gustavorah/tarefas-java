package com.gustavo.tarefas.response;

import com.gustavo.tarefas.model.Projeto;

import java.time.LocalDateTime;
import java.util.Set;

public record UsuarioResponseDTO (
        Long id,
        String nome,
        String email,
        String senha,
        LocalDateTime dt_criacao
        //Set<Projeto>projetos
) {
}

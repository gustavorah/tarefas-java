package com.gustavo.tarefas.request;

public record TodoDTO (
        Long userId,
        Long id,
        String title,
        boolean completed
) {
}

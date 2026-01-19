package com.gustavo.tarefas.repository;

import com.gustavo.tarefas.model.Tarefa;
import org.springframework.data.repository.ListCrudRepository;

public interface TarefaRepository extends ListCrudRepository<Tarefa, Long> {
}

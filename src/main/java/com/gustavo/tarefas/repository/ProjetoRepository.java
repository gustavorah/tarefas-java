package com.gustavo.tarefas.repository;

import com.gustavo.tarefas.model.Projeto;
import org.springframework.data.repository.ListCrudRepository;

public interface ProjetoRepository extends ListCrudRepository<Projeto, Long> {

}

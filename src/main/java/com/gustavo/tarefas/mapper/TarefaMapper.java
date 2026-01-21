package com.gustavo.tarefas.mapper;

import com.gustavo.tarefas.model.Tarefa;
import com.gustavo.tarefas.response.TarefaResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    @Mapping(target = "id",  source = "entity.id")
    @Mapping(target = "titulo", source = "entity.titulo")
    @Mapping(target = "descricao", source = "entity.descricao")
    @Mapping(target = "status", source = "entity.status")
    @Mapping(target = "prioridade", source = "entity.prioridade")
    @Mapping(target = "dtCriacao", source = "entity.dtCriacao")
    @Mapping(target = "dtFim", source = "entity.dtFim")
    TarefaResponseDTO tarefaToTarefaResponseDTO(Tarefa entity);
}

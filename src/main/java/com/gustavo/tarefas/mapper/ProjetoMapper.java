package com.gustavo.tarefas.mapper;

import com.gustavo.tarefas.model.Projeto;
import com.gustavo.tarefas.response.ProjetoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjetoMapper {
    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "nome", source = "entity.nome")
    @Mapping(target = "descricao", source = "entity.descricao")
    @Mapping(target = "dtInicio", source = "entity.dt_inicio")
    @Mapping(target = "dtFim", source = "entity.dt_fim")
    ProjetoResponseDTO projetoToProjetoDTOResponse(Projeto entity);
}

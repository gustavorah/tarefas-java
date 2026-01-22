package com.gustavo.tarefas.mapper;

import com.gustavo.tarefas.model.Usuario;
import com.gustavo.tarefas.request.UsuarioDTO;
import com.gustavo.tarefas.response.UsuarioResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "nome", source = "dto.nome")
    @Mapping(target = "email", source = "dto.email")
    Usuario usuarioDTOToUsuario(UsuarioDTO dto);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "nome", source = "entity.nome")
    @Mapping(target = "email", source = "entity.email")
//    @Mapping(target = "senha", source = "entity.senha")
    @Mapping(target = "dtCriacao", source = "entity.dtCriacao")
    @Mapping(target = "projetos", source = "entity.projetos")
    UsuarioResponseDTO usuarioToUsuarioResponseDTO(Usuario entity);
}

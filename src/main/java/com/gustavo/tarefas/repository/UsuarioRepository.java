package com.gustavo.tarefas.repository;

import com.gustavo.tarefas.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends ListCrudRepository<Usuario, Long> {
    @Query("select u from Usuario u where u.email = :email")
    Optional<Usuario> findUsuarioByEmail(@Param("email") String email);

    @Query("select u from Usuario u where u.nome = :nome")
    Optional<Usuario> findByNome(@Param("nome") String nome);

    @Query("select u from Usuario u where u.nome = :nome and u.email = :email")
    Optional<Usuario> findByNomeAndEmail(@Param("nome") String nome, @Param("email") String email);
}

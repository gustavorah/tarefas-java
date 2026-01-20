package com.gustavo.tarefas.service;

import com.gustavo.tarefas.mapper.UsuarioMapper;
import com.gustavo.tarefas.model.Usuario;
import com.gustavo.tarefas.repository.UsuarioRepository;
import com.gustavo.tarefas.request.UsuarioDTO;
import com.gustavo.tarefas.response.UsuarioResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    final private UsuarioRepository repository;
    final private UsuarioMapper mapper;

    public List<UsuarioResponseDTO> listarTodos()
    {
        return repository.findAll()
                .stream()
                .map(mapper::usuarioToUsuarioResponseDTO)
                .toList();
    }

    public Usuario criar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario) {
        Usuario usuarioExistente = repository.findById(id).orElseThrow(NoSuchElementException::new);
        if (usuario.getNome() != null) {
            usuarioExistente.setNome(usuario.getNome());
        }
        if (usuario.getEmail() != null) {
            usuarioExistente.setEmail(usuario.getEmail());
        }
        if (usuario.getSenha() != null) {
            usuarioExistente.setSenha(usuario.getSenha());
        }
        return repository.save(usuarioExistente);
    }

    public void deletar(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(usuario);
    }

    public UsuarioResponseDTO findBy(UsuarioDTO usuario) {
        if (
                (usuario.nome() == null || usuario.nome().isEmpty())
                && (usuario.email() == null || usuario.email().isEmpty())
        ) {
            throw new RuntimeException("Argumentos incorretos");
        }
        System.out.println(usuario.nome());
        System.out.println(usuario.email());
        Optional<Usuario> user = (usuario.nome() != null && usuario.email() != null) ?
            user = repository.findByNomeAndEmail(usuario.nome(), usuario.email())
                : (usuario.nome() != null)
                ? repository.findByNome(usuario.nome())
                : repository.findUsuarioByEmail(usuario.email());
        return user
                .map(mapper::usuarioToUsuarioResponseDTO)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }
}

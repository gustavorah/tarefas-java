package com.gustavo.tarefas.service;

import com.gustavo.tarefas.model.Usuario;
import com.gustavo.tarefas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {
    final private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos()
    {
        return repository.findAll();
    }

    public Usuario criar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario) {
        Usuario usuarioExistente = repository.findById(id).orElseThrow(NoSuchElementException::new);
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setSenha(usuario.getSenha());
        return repository.save(usuarioExistente);
    }

    public void deletar(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(usuario);
    }

    public Usuario findUsuarioByEmail(String email) {
        return repository.findUsuarioByEmail(email).orElseThrow(NoSuchElementException::new);
    }
}

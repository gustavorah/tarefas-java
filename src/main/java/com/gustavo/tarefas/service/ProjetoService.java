package com.gustavo.tarefas.service;

import com.gustavo.tarefas.model.Projeto;
import com.gustavo.tarefas.model.Usuario;
import com.gustavo.tarefas.repository.ProjetoRepository;
import com.gustavo.tarefas.repository.UsuarioRepository;
import com.gustavo.tarefas.request.ProjetoRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjetoService {
    final private ProjetoRepository repository;
    final private UsuarioRepository usuarioRepository;

    public ProjetoService(
            ProjetoRepository repository,
            UsuarioRepository usuarioRepository
    )
    {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Projeto> listarTodos() {
        return repository.findAll();
    }

    public Projeto criar(ProjetoRequest projetoRequest) {
        Usuario usuario = usuarioRepository.findById(projetoRequest.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Projeto projeto = new Projeto(
                projetoRequest.nome(),
                projetoRequest.descricao(),
                projetoRequest.dt_inicio(),
                projetoRequest.dt_fim(),
                usuario
        );
        return repository.save(projeto);
    }

    public Projeto atualizar(Long id, ProjetoRequest request) {
        Projeto projetoExistente = repository.findById(id).
                orElseThrow(() -> new RuntimeException("Projeto Inexistente"));
        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário Inexistente"));
        projetoExistente.setNome(request.nome());
        projetoExistente.setDescricao(request.descricao());
        projetoExistente.setDt_inicio(request.dt_inicio());
        projetoExistente.setDt_fim(request.dt_fim());
        projetoExistente.setUsuario(usuario);
        return repository.save(projetoExistente);
    }

    public void deletar(Long id) {
        Projeto projeto = repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(projeto);
    }
}

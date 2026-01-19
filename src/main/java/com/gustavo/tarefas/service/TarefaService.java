package com.gustavo.tarefas.service;

import com.gustavo.tarefas.model.Projeto;
import com.gustavo.tarefas.model.Tarefa;
import com.gustavo.tarefas.repository.ProjetoRepository;
import com.gustavo.tarefas.repository.TarefaRepository;
import com.gustavo.tarefas.request.TarefaRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    final private TarefaRepository repository;
    final private ProjetoRepository projetoRepository;

    public TarefaService(
            TarefaRepository repository,
            ProjetoRepository projetoRepository
    ) {
        this.repository = repository;
        this.projetoRepository = projetoRepository;
    }

    @Transactional
    public List<Tarefa> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public Tarefa criar(TarefaRequest request) {
        Projeto projeto = projetoRepository.findById(request.projeto_id())
                .orElseThrow(() -> new RuntimeException("Projeto Inexistente"));
        boolean status = request.status() != null ? request.status() : true;
        Tarefa tarefa = new Tarefa(
                request.titulo(),
                request.descricao(),
                status,
                request.prioridade(),
                request.dtCriacao(),
                request.dtFim(),
                projeto
        );

        return repository.save(tarefa);
    }

    @Transactional
    public Tarefa atualizar(Long id, TarefaRequest request) {
        Tarefa tarefaExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa inexistente"));

        if (request.titulo() != null) {
            tarefaExistente.setTitulo(request.titulo());
        }
        if (request.descricao() != null) {
            tarefaExistente.setDescricao(request.descricao());
        }
        if (request.status() != null) {
            tarefaExistente.setStatus(request.status());
        }
        if (request.prioridade() != null) {
            tarefaExistente.setPrioridade(request.prioridade());
        }
        if (request.dtCriacao() != null) {
            tarefaExistente.setDtCriacao(request.dtCriacao());
        }
        if (request.dtFim() != null) {
            tarefaExistente.setDtFim(request.dtFim());
        }
        tarefaExistente.setProjeto(tarefaExistente.getProjeto());

        return repository.save(tarefaExistente);
    }

    @Transactional
    public void deletar(Long id) {
        Tarefa tarefa = repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Tarefa inexistente"));
        repository.delete(tarefa);
    }
}

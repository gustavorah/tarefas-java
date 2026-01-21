package com.gustavo.tarefas.service;

import com.gustavo.tarefas.mapper.TarefaMapper;
import com.gustavo.tarefas.model.Projeto;
import com.gustavo.tarefas.model.Tarefa;
import com.gustavo.tarefas.repository.ProjetoRepository;
import com.gustavo.tarefas.repository.TarefaRepository;
import com.gustavo.tarefas.request.TarefaDTO;
import com.gustavo.tarefas.response.TarefaResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    final private TarefaRepository repository;
    final private ProjetoRepository projetoRepository;
    final private TarefaMapper mapper;

    public TarefaService(
            TarefaRepository repository,
            ProjetoRepository projetoRepository,
            TarefaMapper mapper
    ) {
        this.repository = repository;
        this.projetoRepository = projetoRepository;
        this.mapper = mapper;
    }

    @Transactional
    public List<TarefaResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::tarefaToTarefaResponseDTO)
                .toList();
    }

    @Transactional
    public Tarefa criar(TarefaDTO request) {
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
    public Tarefa atualizar(Long id, TarefaDTO request) {
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

package com.gustavo.tarefas.service;

import com.gustavo.tarefas.mapper.ProjetoMapper;
import com.gustavo.tarefas.model.Projeto;
import com.gustavo.tarefas.model.Usuario;
import com.gustavo.tarefas.repository.ProjetoRepository;
import com.gustavo.tarefas.repository.UsuarioRepository;
import com.gustavo.tarefas.request.ProjetoDTO;
import com.gustavo.tarefas.response.ProjetoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjetoService {
    final private ProjetoRepository repository;
    final private UsuarioRepository usuarioRepository;
    final private ProjetoMapper mapper;

    public ProjetoService(
            ProjetoRepository repository,
            UsuarioRepository usuarioRepository,
            ProjetoMapper mapper
    )
    {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    public List<ProjetoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::projetoToProjetoDTOResponse)
                .toList();
    }

    public ProjetoResponseDTO criar(ProjetoDTO projetoRequest) {
        Usuario usuario = usuarioRepository.findById(projetoRequest.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Projeto projeto = new Projeto(
                projetoRequest.nome(),
                projetoRequest.descricao(),
                projetoRequest.dt_inicio(),
                projetoRequest.dt_fim(),
                usuario
        );
        projeto = repository.save(projeto);
        return mapper.projetoToProjetoDTOResponse(projeto);
    }

    public ProjetoResponseDTO atualizar(Long id, ProjetoDTO request) {
        Projeto projetoExistente = repository.findById(id).
                orElseThrow(() -> new RuntimeException("Projeto Inexistente"));
        Usuario usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário Inexistente"));
        if (request.nome() != null) {
            projetoExistente.setNome(request.nome());
        }
        if (request.descricao() != null) {
            projetoExistente.setDescricao(request.descricao());
        }
        if (request.dt_inicio() != null) {
            projetoExistente.setDt_inicio(request.dt_inicio());
        }
        if (request.dt_fim() != null) {
            projetoExistente.setDt_fim(request.dt_fim());
        }
        projetoExistente.setUsuario(usuario);
        projetoExistente = repository.save(projetoExistente);
        return mapper.projetoToProjetoDTOResponse(projetoExistente);
    }

    public void deletar(Long id) {
        Projeto projeto = repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(projeto);
    }
}

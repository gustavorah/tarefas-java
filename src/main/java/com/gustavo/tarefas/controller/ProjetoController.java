package com.gustavo.tarefas.controller;

import com.gustavo.tarefas.model.Projeto;
import com.gustavo.tarefas.request.ProjetoDTO;
import com.gustavo.tarefas.response.ProjetoResponseDTO;
import com.gustavo.tarefas.service.ProjetoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    final private ProjetoService service;

    public ProjetoController(ProjetoService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<ProjetoResponseDTO> listarTodos()
    {
        return service.listarTodos();
    }

    @PostMapping
    public ProjetoResponseDTO criar(@RequestBody ProjetoDTO projeto)
    {
        return service.criar(projeto);
    }

    @PutMapping("/{id}")
    public ProjetoResponseDTO atualizar(@PathVariable Long id, @RequestBody ProjetoDTO request)
    {
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

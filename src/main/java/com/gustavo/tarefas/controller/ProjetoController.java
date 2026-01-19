package com.gustavo.tarefas.controller;

import com.gustavo.tarefas.model.Projeto;
import com.gustavo.tarefas.request.ProjetoRequest;
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
    public List<Projeto> listarTodos()
    {
        return service.listarTodos();
    }

    @PostMapping
    public Projeto criar(@RequestBody ProjetoRequest projeto)
    {
        return service.criar(projeto);
    }

    @PutMapping("/{id}")
    public Projeto atualizar(@PathVariable Long id, @RequestBody ProjetoRequest request)
    {
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

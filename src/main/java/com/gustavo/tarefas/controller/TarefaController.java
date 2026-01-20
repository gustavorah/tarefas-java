package com.gustavo.tarefas.controller;

import com.gustavo.tarefas.model.Tarefa;
import com.gustavo.tarefas.request.TarefaDTO;
import com.gustavo.tarefas.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    final private TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return service.listarTodos();
    }

    @PostMapping
    public Tarefa criar(@RequestBody TarefaDTO tarefa) {
        return service.criar(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody TarefaDTO tarefa) {
        return service.atualizar(id,  tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

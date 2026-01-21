package com.gustavo.tarefas.controller;

import com.gustavo.tarefas.model.Usuario;
import com.gustavo.tarefas.request.UsuarioDTO;
import com.gustavo.tarefas.response.UsuarioResponseDTO;
import com.gustavo.tarefas.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4040")
public class UsuarioController {
    final private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/buscar")
    public UsuarioResponseDTO findBy(UsuarioDTO usuario) {
        return service.findBy(usuario);
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public UsuarioResponseDTO criar(Usuario usuario) {
        return service.criar(usuario);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.atualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

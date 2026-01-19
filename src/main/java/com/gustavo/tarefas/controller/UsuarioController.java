package com.gustavo.tarefas.controller;

import com.gustavo.tarefas.model.Usuario;
import com.gustavo.tarefas.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    final private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/{email}")
    public Usuario findUsuarioByEmail(@PathVariable String email) {
        return service.findUsuarioByEmail(email);
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Usuario criar(Usuario usuario) {
        return service.criar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(Long id, @RequestBody Usuario usuario) {
        return service.atualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

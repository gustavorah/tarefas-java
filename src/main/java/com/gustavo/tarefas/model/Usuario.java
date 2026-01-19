package com.gustavo.tarefas.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "HTE_USUARIOS",
    schema = "APP_TAREFAS")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    @CreationTimestamp
    private LocalDateTime dt_criacao;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    private Set<Projeto> projetos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(LocalDateTime dt_criacao) {
        this.dt_criacao = dt_criacao;
    }
}

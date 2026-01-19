package com.gustavo.tarefas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "HTE_PROJETOS",
schema = "APP_TAREFAS")
public class Projeto {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_projeto")
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    private LocalDateTime dt_inicio;
    private LocalDateTime dt_fim;

    protected Projeto() {}

    public Projeto(
            String nome,
            String descricao,
            LocalDateTime dt_inicio,
            LocalDateTime dt_fim,
            Usuario usuario
    ) {
        this.nome = nome;
        this.descricao = descricao;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDt_fim() {
        return dt_fim;
    }

    public void setDt_fim(LocalDateTime dt_fim) {
        this.dt_fim = dt_fim;
    }

    public LocalDateTime getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(LocalDateTime dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Tarefa> tarefas;
}

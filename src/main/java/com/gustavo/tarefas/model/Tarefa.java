package com.gustavo.tarefas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "HTE_TAREFAS",
schema = "APP_TAREFAS")
public class Tarefa {
    protected Tarefa() {}
    public Tarefa(
            String titulo,
            String descricao,
            boolean status,
            String prioridade,
            LocalDateTime dtCriacao,
            LocalDateTime dtFim,
            Projeto projeto
    ) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
        this.dtCriacao = dtCriacao;
        this.dtFim = dtFim;
        this.projeto = projeto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tarefa")
    private Long id;
    @Column(nullable = false)
    private String titulo;
    private String descricao;
    @Column(nullable = false)
    private boolean status = true;
    private String prioridade;
    private LocalDateTime dtCriacao;
    private LocalDateTime dtFim;

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public LocalDateTime getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDateTime dtFim) {
        this.dtFim = dtFim;
    }

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDateTime dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projeto projeto;
}

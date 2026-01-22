package com.gustavo.tarefas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TAREFAS",
schema = "APP_TAREFAS")
@Data
@NoArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tarefa")
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITULO", nullable = false)
    private String titulo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "STATUS", nullable = false)
    private boolean status = true;
    @Column(name = "PRIORIDADE")
    private String prioridade;
    @Column(name = "DTCRIACAO")
    private LocalDateTime dtCriacao;
    @Column(name = "DTFIM")
    private LocalDateTime dtFim;

    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false)
    @JsonBackReference
    private Projeto projeto;

    public Tarefa(String titulo, String descricao, boolean status, String prioridade, LocalDateTime dtCriacao, LocalDateTime dtFim, Projeto projeto) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
        this.dtCriacao = dtCriacao;
        this.dtFim = dtFim;
        this.projeto = projeto;
    }
}

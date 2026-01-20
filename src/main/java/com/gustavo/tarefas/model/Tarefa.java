package com.gustavo.tarefas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "HTE_TAREFAS",
schema = "APP_TAREFAS")
@Data
@NoArgsConstructor
public class Tarefa {
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

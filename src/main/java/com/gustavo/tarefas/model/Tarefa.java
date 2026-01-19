package com.gustavo.tarefas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "HTE_TAREFAS",
schema = "APP_TAREFAS")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tarefa")

    @Column(nullable = false)
    private String titulo;
    private String descricao;
    private boolean status = true;

}

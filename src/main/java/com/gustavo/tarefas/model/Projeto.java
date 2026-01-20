package com.gustavo.tarefas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "HTE_PROJETOS",
schema = "APP_TAREFAS")
@Data
@NoArgsConstructor
public class Projeto {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_projeto")
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    private LocalDateTime dt_inicio;
    private LocalDateTime dt_fim;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference
    private Usuario usuario;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Tarefa> tarefas;

    public Projeto(String nome, String descricao, LocalDateTime dt_inicio, LocalDateTime dt_fim, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
        this.usuario = usuario;
    }
}

package com.gustavo.tarefas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "PROJETOS",
schema = "APP_TAREFAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Projeto {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_projeto")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false)
    private String nome;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "DTINICIO")
    private LocalDateTime dtInicio;
    @Column(name = "DTFIM")
    private LocalDateTime dtFim;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference
    private Usuario usuario;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Tarefa> tarefas;

    public Projeto(String nome, String descricao, LocalDateTime dtInicio, LocalDateTime dtFim, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.usuario = usuario;
    }
}

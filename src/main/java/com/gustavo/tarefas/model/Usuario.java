package com.gustavo.tarefas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "HTE_USUARIOS",
    schema = "APP_TAREFAS")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    @CreationTimestamp
    private LocalDateTime dt_criacao;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Projeto> projetos;
}

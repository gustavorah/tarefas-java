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
@Table(name = "USUARIOS",
    schema = "APP_TAREFAS")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false)
    private String nome;
    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;
    @Column(name = "SENHA", nullable = false)
    private String senha;
    @Column(name = "DTCRIACAO")
    @CreationTimestamp
    private LocalDateTime dtCriacao;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Projeto> projetos;
}

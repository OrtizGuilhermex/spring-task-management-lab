package com.ctw.spring_task_management_lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    public Tarefa(String titulo, String status, Projeto projeto) {
        this.titulo = titulo;
        this.status = status;
        this.projeto = projeto;
    }
}

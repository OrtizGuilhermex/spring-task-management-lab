package com.ctw.spring_task_management_lab.repository;

import com.ctw.spring_task_management_lab.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByIdAndTitulo(Long id, String titulo);
    List<Tarefa> findByIdAndProjetoNome(Long id, String nome);

}

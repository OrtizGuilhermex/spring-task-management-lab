package com.ctw.spring_task_management_lab.repository;

import com.ctw.spring_task_management_lab.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto,Long> {
}

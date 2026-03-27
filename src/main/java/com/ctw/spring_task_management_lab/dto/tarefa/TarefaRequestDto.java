package com.ctw.spring_task_management_lab.dto.tarefa;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public record TarefaRequestDto(
        @Id
        @NotNull
        Long id,
        @NotNull
        String titulo,
        @NotNull
        String status,
        @NotNull
        Long projetoId
) {
}

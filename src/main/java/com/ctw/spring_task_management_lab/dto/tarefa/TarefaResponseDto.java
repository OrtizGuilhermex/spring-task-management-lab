package com.ctw.spring_task_management_lab.dto.tarefa;

import jakarta.validation.constraints.NotNull;

public record TarefaResponseDto(
        String titulo,
        String status,
        Long projetoId
) {
}

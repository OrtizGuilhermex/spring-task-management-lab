package com.ctw.spring_task_management_lab.dto.projeto;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public record ProjetoResponseDto(
        String nome,
        String descricao
) {
}

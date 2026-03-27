package com.ctw.spring_task_management_lab.dto.projeto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public record ProjetoRequestDto(
        @Id
        @NotNull
        Long id,
        @NotNull
        String nome,
        @NotNull
        String descricao
) {
}

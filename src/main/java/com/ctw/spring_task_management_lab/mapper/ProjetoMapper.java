package com.ctw.spring_task_management_lab.mapper;

import com.ctw.spring_task_management_lab.dto.projeto.ProjetoRequestDto;
import com.ctw.spring_task_management_lab.dto.projeto.ProjetoResponseDto;
import com.ctw.spring_task_management_lab.model.Projeto;
import com.ctw.spring_task_management_lab.model.Tarefa;

public class ProjetoMapper {

    public Projeto toEntity(
            ProjetoRequestDto projetoRequestDto
    ){
        return new Projeto(
                projetoRequestDto.nome(),
                projetoRequestDto.descricao()
        );
    }

    public ProjetoResponseDto toResponse(
            Projeto projeto
    ){
        return new ProjetoResponseDto(
                projeto.getNome(),
                projeto.getDescricao()
        );
    }
}

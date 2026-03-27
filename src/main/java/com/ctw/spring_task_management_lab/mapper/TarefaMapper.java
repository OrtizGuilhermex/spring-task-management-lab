package com.ctw.spring_task_management_lab.mapper;

import com.ctw.spring_task_management_lab.dto.tarefa.TarefaRequestDto;
import com.ctw.spring_task_management_lab.dto.tarefa.TarefaResponseDto;
import com.ctw.spring_task_management_lab.model.Projeto;
import com.ctw.spring_task_management_lab.model.Tarefa;

public class TarefaMapper {

    public Tarefa toEntity(
            TarefaRequestDto tarefaRequestDto,
            Projeto projeto
    ){
        return new Tarefa(
                tarefaRequestDto.titulo(),
                tarefaRequestDto.status(),
                projeto
        );
    }

    public TarefaResponseDto toResponse(
            Tarefa tarefa
    ){
        return new TarefaResponseDto(
                tarefa.getTitulo(),
                tarefa.getStatus(),
                tarefa.getProjeto().getId()
        );
    }
}

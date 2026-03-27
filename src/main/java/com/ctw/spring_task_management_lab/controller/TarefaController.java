package com.ctw.spring_task_management_lab.controller;

import com.ctw.spring_task_management_lab.dto.tarefa.TarefaRequestDto;
import com.ctw.spring_task_management_lab.dto.tarefa.TarefaResponseDto;
import com.ctw.spring_task_management_lab.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public TarefaResponseDto cadastrarTarefa(
            @RequestBody TarefaRequestDto tarefaRequestDto,
            @RequestParam Long projetoId
    ){
        return tarefaService.cadastrarTarefa(tarefaRequestDto,projetoId);
    }

    @GetMapping
    public List<TarefaResponseDto> listarTarefas(){
        return tarefaService.listarTarefas();
    }

    @GetMapping("/titulo")
    public List<TarefaResponseDto> listarTarefaPorIdTitulo(
            @RequestParam Long id,
            @RequestParam String titulo
    ){
        return tarefaService.listarTarefaPorIdTitulo(id, titulo);
    }

    @GetMapping("/projeto/nome")
    public List<TarefaResponseDto> listarTarefaPorIdProjetoNome(
            @RequestParam Long id,
            @RequestParam String nome
    ){
        return tarefaService.listarTarefaPorIdProjetoNome(id, nome);
    }
}

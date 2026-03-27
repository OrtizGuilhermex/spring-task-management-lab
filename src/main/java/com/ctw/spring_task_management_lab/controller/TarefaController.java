package com.ctw.spring_task_management_lab.controller;

import com.ctw.spring_task_management_lab.dto.tarefa.TarefaRequestDto;
import com.ctw.spring_task_management_lab.dto.tarefa.TarefaResponseDto;
import com.ctw.spring_task_management_lab.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaResponseDto> cadastrarTarefa(
            @RequestBody TarefaRequestDto tarefaRequestDto,
            @RequestParam Long projetoId
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(tarefaService.cadastrarTarefa(tarefaRequestDto,projetoId));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>> listarTarefas(){
        return ResponseEntity.status(HttpStatus.OK)
                        .body(tarefaService.listarTarefas());
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<TarefaResponseDto>> listarTarefaPorIdTitulo(
            @RequestParam Long id,
            @RequestParam String titulo
    ){
        return ResponseEntity.status(HttpStatus.OK)
                        .body(tarefaService.listarTarefaPorIdTitulo(id, titulo));
    }

    @GetMapping("/projeto/nome")
    public ResponseEntity<List<TarefaResponseDto>> listarTarefaPorIdProjetoNome(
            @RequestParam Long id,
            @RequestParam String nome
    ){
        return ResponseEntity.status(HttpStatus.OK)
                        .body(tarefaService.listarTarefaPorIdProjetoNome(id, nome));
    }
}

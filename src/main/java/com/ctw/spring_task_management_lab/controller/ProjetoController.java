package com.ctw.spring_task_management_lab.controller;

import com.ctw.spring_task_management_lab.dto.projeto.ProjetoRequestDto;
import com.ctw.spring_task_management_lab.dto.projeto.ProjetoResponseDto;
import com.ctw.spring_task_management_lab.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoResponseDto> cadastrarProjeto(
            @RequestBody ProjetoRequestDto projetoRequestDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(projetoService.cadastrarprojeto(projetoRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDto>> listarProjetos(){
        return ResponseEntity.status(HttpStatus.OK)
                        .body(projetoService.listarProjetos());
    }
}


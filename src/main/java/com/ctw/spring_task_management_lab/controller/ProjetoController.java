package com.ctw.spring_task_management_lab.controller;

import com.ctw.spring_task_management_lab.dto.projeto.ProjetoRequestDto;
import com.ctw.spring_task_management_lab.dto.projeto.ProjetoResponseDto;
import com.ctw.spring_task_management_lab.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @PostMapping
    public ProjetoResponseDto cadastrarProjeto(
            @RequestBody ProjetoRequestDto projetoRequestDto
    ){
        return projetoService.cadastrarprojeto(projetoRequestDto);
    }

    @GetMapping
    public List<ProjetoResponseDto> listarProjetos(){
        return projetoService.listarProjetos();
    }
}

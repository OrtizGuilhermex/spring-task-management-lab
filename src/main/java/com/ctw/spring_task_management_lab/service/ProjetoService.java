package com.ctw.spring_task_management_lab.service;

import com.ctw.spring_task_management_lab.dto.projeto.ProjetoRequestDto;
import com.ctw.spring_task_management_lab.dto.projeto.ProjetoResponseDto;
import com.ctw.spring_task_management_lab.mapper.ProjetoMapper;
import com.ctw.spring_task_management_lab.model.Projeto;
import com.ctw.spring_task_management_lab.model.Tarefa;
import com.ctw.spring_task_management_lab.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final ProjetoMapper projetoMapper;

    public ProjetoResponseDto cadastrarprojeto(
            ProjetoRequestDto projetoRequestDto
    ){
        Projeto projeto = projetoMapper.toEntity(projetoRequestDto);

        projetoRepository.save(projeto);

        return projetoMapper.toResponse(projeto);
    }

    public List<ProjetoResponseDto> listarProjetos(){
        List<Projeto> projetoList = projetoRepository.findAll();

        return projetoList.stream()
                .map(projetoMapper::toResponse)
                .toList();
    }
}

package com.ctw.spring_task_management_lab.service;

import com.ctw.spring_task_management_lab.dto.tarefa.TarefaRequestDto;
import com.ctw.spring_task_management_lab.dto.tarefa.TarefaResponseDto;
import com.ctw.spring_task_management_lab.mapper.TarefaMapper;
import com.ctw.spring_task_management_lab.model.Projeto;
import com.ctw.spring_task_management_lab.model.Tarefa;
import com.ctw.spring_task_management_lab.repository.ProjetoRepository;
import com.ctw.spring_task_management_lab.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;
    private final ProjetoRepository projetoRepository;

    public TarefaResponseDto cadastrarTarefa(
            TarefaRequestDto tarefaRequestDto,
            Long projetoId
    ){
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(()-> new RuntimeException("Projeto não foi encontrado"));

        Tarefa tarefa = tarefaMapper.toEntity(tarefaRequestDto,projeto);

        tarefaRepository.save(tarefa);

        return tarefaMapper.toResponse(tarefa);
    }

    public List<TarefaResponseDto> listarTarefas(){
        List<Tarefa> tarefaList = tarefaRepository.findAll();

        return tarefaList.stream()
                .map(tarefaMapper::toResponse)
                .toList();
    }

    public List<TarefaResponseDto> listarTarefaPorIdTitulo(
            Long id,
            String titulo
    ){
        List<Tarefa> tarefaList = tarefaRepository.findByIdAndTitulo(id, titulo);

        return tarefaList.stream()
                .map(tarefaMapper::toResponse)
                .toList();
    }

    public List<TarefaResponseDto> listarTarefaPorIdProjetoNome(
            Long id,
            String projetoNome
    ){
        List<Tarefa> tarefaList = tarefaRepository.findByIdAndProjetoNome(id, projetoNome);

        return tarefaList.stream()
                .map(tarefaMapper::toResponse)
                .toList();
    }
}

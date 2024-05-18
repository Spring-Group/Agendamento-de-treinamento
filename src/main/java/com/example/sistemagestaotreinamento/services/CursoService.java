package com.example.sistemagestaotreinamento.services;

import java.time.LocalDateTime;

// import java.util.List;

import com.example.sistemagestaotreinamento.dtos.CursoDTO;

public interface CursoService {
    void cadastrar(CursoDTO cursoDTO);

    void atualizar(Integer id, CursoDTO cursoDTO);

    void excluir(Integer id);

    void vincularCursoAProfessor(Integer cursoId, Integer professorId, LocalDateTime dataInicio, LocalDateTime dataFim);

    CursoDTO buscarPorId(Integer id);

}

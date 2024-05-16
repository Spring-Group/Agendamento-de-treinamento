package com.example.sistemagestaotreinamento.services;

import java.util.List;

import com.example.sistemagestaotreinamento.dtos.CursoDTO;

public interface CursoService {
    void cadastrar(CursoDTO cursoDTO);
    void atualizar(Integer id, CursoDTO cursoDTO);
    void excluir(Integer id);
    void vincularCursoAProfessor(Integer cursoId, Integer professorId);
    CursoDTO buscarPorId(Integer id);
    List<CursoDTO> buscarTodos();
    
}

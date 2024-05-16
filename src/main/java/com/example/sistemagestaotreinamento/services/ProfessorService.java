package com.example.sistemagestaotreinamento.services;

import java.util.List;

import com.example.sistemagestaotreinamento.dtos.ProfessorDTO;

public interface ProfessorService {
    void cadastrar(ProfessorDTO professorDTO);
    void atualizar(Integer id, ProfessorDTO professorDTO);
    void excluir(Integer id);
    void vincularCursoEAgendamento(Integer professorId, Integer cursoId, Integer agendamentoId);
    ProfessorDTO buscarPorId(Integer id);
    List<ProfessorDTO> buscarTodos();
}

package com.example.sistemagestaotreinamento.services;

import com.example.sistemagestaotreinamento.dtos.ProfessorDTO;

public interface ProfessorService {
    void cadastrar(ProfessorDTO professorDTO);

    void atualizar(Integer id, ProfessorDTO professorDTO);

    void excluir(Integer id);

    void vincularProfessorAAgendamento(Integer professorid, Integer agendamentoId);

    ProfessorDTO buscarPorId(Integer id);

}

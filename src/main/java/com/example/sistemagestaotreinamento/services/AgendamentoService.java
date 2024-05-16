package com.example.sistemagestaotreinamento.services;

// import java.util.List;

import com.example.sistemagestaotreinamento.dtos.AgendamentoDTO;

public interface AgendamentoService {

    void cadastrar(AgendamentoDTO agendamentoDTO);

    void atualizar(Integer id, AgendamentoDTO agendamentoDTO);

    void excluir(Integer id);

    // void vincularCursoEProfessor(Integer agendamentoId, Integer cursoId, Integer
    // professorId);
    AgendamentoDTO buscarPorId(Integer id);
    // List<AgendamentoDTO> buscarTodos();
}

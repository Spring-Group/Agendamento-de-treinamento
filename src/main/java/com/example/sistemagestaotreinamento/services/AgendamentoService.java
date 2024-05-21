package com.example.sistemagestaotreinamento.services;

import java.time.LocalDateTime;

import java.util.List;

import com.example.sistemagestaotreinamento.dtos.AgendamentoDTO;
import com.example.sistemagestaotreinamento.models.Agendamento;

public interface AgendamentoService {

    void cadastrar(AgendamentoDTO agendamentoDTO);

    void atualizar(Integer id, AgendamentoDTO agendamentoDTO);

    void excluir(Integer id);

    AgendamentoDTO buscarPorId(Integer id);

    List<Agendamento> findAgendamentosBetweenDates(LocalDateTime dataInicio, LocalDateTime dataFim);
}

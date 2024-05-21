package com.example.sistemagestaotreinamento.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sistemagestaotreinamento.models.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

  @Query("SELECT a FROM Agendamento a WHERE a.dataInicio >= :dataInicio AND a.dataFim <= :dataFim")
  List<Agendamento> findAgendamentosBetweenDates(@Param("dataInicio") LocalDateTime dataInicio,
      @Param("dataFim") LocalDateTime dataFim);
}

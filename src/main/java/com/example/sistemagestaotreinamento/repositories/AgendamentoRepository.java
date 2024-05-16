package com.example.sistemagestaotreinamento.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sistemagestaotreinamento.models.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    @Query("SELECT COUNT(a) FROM Agendamento a WHERE a.professor.id = :professorId AND (:dataInicio BETWEEN a.dataInicio AND a.dataFim OR :dataFim BETWEEN a.dataInicio AND a.dataFim)")
    int countAgendamentosByProfessorAndData(@Param("professorId") int professorId, @Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim") LocalDateTime dataFim);
    
    @Query("SELECT a FROM Agendamento a LEFT JOIN FETCH a.curso c LEFT JOIN FETCH a.professor p WHERE a.id = :agendamentoId")
    Agendamento findAgendamentoWithCursoAndProfessorById(int agendamentoId);
}

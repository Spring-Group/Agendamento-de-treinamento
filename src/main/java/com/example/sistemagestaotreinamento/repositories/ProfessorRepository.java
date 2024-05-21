package com.example.sistemagestaotreinamento.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sistemagestaotreinamento.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Query("SELECT DISTINCT a FROM Agendamento a LEFT JOIN FETCH a.professor p WHERE p.id = :professorId")
    Professor findProfessorWithAgendamentosById(@Param("professorId") int professorId);

}

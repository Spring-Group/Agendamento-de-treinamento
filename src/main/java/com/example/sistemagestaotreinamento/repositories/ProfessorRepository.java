package com.example.sistemagestaotreinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import com.example.sistemagestaotreinamento.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    // @Query("SELECT p FROM Professor p LEFT JOIN FETCH p.cursos WHERE p.id =
    // :professorId")
    // Professor findProfessorWithCursosById(int professorId);

    // @Query("SELECT p FROM Professor p LEFT JOIN FETCH p.agendamentos WHERE p.id =
    // :professorId")
    // Professor findProfessorWithAgendamentosById(int professorId);
}

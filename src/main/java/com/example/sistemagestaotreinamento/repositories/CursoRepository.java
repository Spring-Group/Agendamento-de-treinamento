package com.example.sistemagestaotreinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.example.sistemagestaotreinamento.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

    @Query("SELECT DISTINCT c FROM Curso c LEFT JOIN FETCH c.professores WHERE c.id = :cursoId")
    Curso findCursoWithProfessoresById(int cursoId);
}

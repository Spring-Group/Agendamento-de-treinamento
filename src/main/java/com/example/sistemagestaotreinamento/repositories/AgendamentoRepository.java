package com.example.sistemagestaotreinamento.repositories;

// import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

import com.example.sistemagestaotreinamento.models.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

}

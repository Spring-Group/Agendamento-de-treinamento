package com.example.sistemagestaotreinamento.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// import java.util.HashSet;
// import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private int cargaHoraria;
    @Column(length = 200, nullable = false)
    private String objetivos;
    @Column(length = 200, nullable = false)
    private String ementa;

    @ManyToMany(mappedBy = "cursos")
    private Set<Professor> professores = new HashSet<>();

    @OneToMany(mappedBy = "curso")
    private Set<Agendamento> agendamentos = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, cargaHoraria, objetivos, ementa);
    }

}

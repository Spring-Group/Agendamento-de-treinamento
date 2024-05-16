package com.example.sistemagestaotreinamento.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(length = 11, nullable = false)
    private String cpf;
    @Column(length = 10, nullable = false)
    private String rg;
    @Column(length = 200, nullable = false)
    private String endereco;
    @Column(length = 30, nullable = false)
    private String celular;

    @ManyToMany(mappedBy = "professores")
    private Set<Curso> cursos = new HashSet<>();

    @OneToMany(mappedBy = "professsor")
    private Set<Agendamento> agendamentos = new HashSet<>();
}

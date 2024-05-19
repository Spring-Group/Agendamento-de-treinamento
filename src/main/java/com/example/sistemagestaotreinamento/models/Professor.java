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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.OneToMany;
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

    @ManyToMany
    @JoinTable(name = "curso_professor", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private Set<Curso> cursos = new HashSet<>();

    @OneToMany(mappedBy = "professor")
    private Set<Agendamento> agendamentos = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, rg, endereco, celular);
    }
}

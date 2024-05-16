package com.example.sistemagestaotreinamento.dtos;

// import java.util.List;
// import com.example.sistemagestaotreinamento.models.Agendamento;
// import com.example.sistemagestaotreinamento.models.Curso;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDTO {
    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;
    // List<Curso> cursos;
    // List<Agendamento> agendamentos;
}

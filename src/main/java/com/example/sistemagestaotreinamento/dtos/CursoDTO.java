package com.example.sistemagestaotreinamento.dtos;

// import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CursoDTO {
    private String descricao;
    private int cargaHoraria;
    private String objetivos;
    private String ementa;
    // List<ProfessorDTO> professores;
}

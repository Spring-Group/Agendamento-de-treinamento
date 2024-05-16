package com.example.sistemagestaotreinamento.dtos;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgendamentoDTO {
    private int id;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String cidade;
    private String uf;
    private String cep;
    private String resumo;
    List<CursoDTO> cursos;
    List<ProfessorDTO> professores;
}

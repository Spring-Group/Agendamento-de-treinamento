package com.example.sistemagestaotreinamento.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemagestaotreinamento.dtos.AgendamentoDTO;
import com.example.sistemagestaotreinamento.models.Agendamento;
import com.example.sistemagestaotreinamento.services.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
  @Autowired
  private AgendamentoService agendamentoService;

  @PostMapping
  public void cadastrarAgendamento(@RequestBody AgendamentoDTO agendamentoDTO) {
    agendamentoService.cadastrar(agendamentoDTO);
  }

  @GetMapping("/{id}")
  public AgendamentoDTO buscarAgendamentoPorId(@PathVariable Integer id) {
    return agendamentoService.buscarPorId(id);
  }

  @PutMapping("/{id}")
  public void atualizarAgendamento(@PathVariable Integer id, @RequestBody AgendamentoDTO agendamentoDTO) {
    agendamentoService.atualizar(id, agendamentoDTO);
  }

  @DeleteMapping("/{id}")
  public void excluirAgendamento(@PathVariable Integer id) {
    agendamentoService.excluir(id);
  }

  @GetMapping("/agendamentos-between/{dataInicio}/{dataFim}")
  public List<AgendamentoDTO> getAgendamentosBetweenDates(
      @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
      @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {
    List<Agendamento> agendamentos = agendamentoService.findAgendamentosBetweenDates(dataInicio, dataFim);
    List<AgendamentoDTO> agendamentosDTO = new ArrayList<>();
    for (Agendamento agendamento : agendamentos) {
      AgendamentoDTO agendamentoDTO = new AgendamentoDTO();
      agendamentoDTO.setDescricao(agendamento.getDescricao());
      agendamentoDTO.setDataInicio(agendamento.getDataInicio());
      agendamentoDTO.setDataFim(agendamento.getDataFim());
      agendamentoDTO.setCidade(agendamento.getCidade());
      agendamentoDTO.setUf(agendamento.getUf());
      agendamentoDTO.setCep(agendamento.getCep());
      agendamentoDTO.setResumo(agendamento.getResumo());
      agendamentosDTO.add(agendamentoDTO);
    }
    return agendamentosDTO;
  }
}

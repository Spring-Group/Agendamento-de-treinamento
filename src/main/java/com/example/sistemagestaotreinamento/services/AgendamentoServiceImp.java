package com.example.sistemagestaotreinamento.services;

import org.springframework.stereotype.Service;

import com.example.sistemagestaotreinamento.dtos.AgendamentoDTO;
import com.example.sistemagestaotreinamento.exceptions.RegraNegocioException;
import com.example.sistemagestaotreinamento.models.Agendamento;
import com.example.sistemagestaotreinamento.repositories.AgendamentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendamentoServiceImp implements AgendamentoService {

  private final AgendamentoRepository agendamentoRepository;

  @Override
  public void cadastrar(AgendamentoDTO agendamentoDTO) {
    Agendamento agendamento = new Agendamento();
    agendamento.setDescricao(agendamentoDTO.getDescricao());
    agendamento.setDataInicio(agendamentoDTO.getDataInicio());
    agendamento.setDataFim(agendamentoDTO.getDataFim());
    agendamento.setCidade(agendamentoDTO.getCidade());
    agendamento.setCep(agendamentoDTO.getCep());
    agendamento.setUf(agendamentoDTO.getUf());
    agendamento.setResumo(agendamentoDTO.getResumo());
    agendamentoRepository.save(agendamento);
  }

  @Override
  public void atualizar(Integer id, AgendamentoDTO agendamentoDTO) {
    Agendamento agendamento = agendamentoRepository.findById(id)
        .orElseThrow(() -> new RegraNegocioException("Agendamento não encontrado"));

    agendamento.setDescricao(agendamentoDTO.getDescricao());
    agendamento.setDataInicio(agendamentoDTO.getDataInicio());
    agendamento.setDataFim(agendamentoDTO.getDataFim());
    agendamento.setCidade(agendamentoDTO.getCidade());
    agendamento.setCep(agendamentoDTO.getCep());
    agendamento.setUf(agendamentoDTO.getUf());
    agendamento.setResumo(agendamentoDTO.getResumo());
    agendamentoRepository.save(agendamento);

  }

  @Override
  public void excluir(Integer id) {
    agendamentoRepository.deleteById(id);
  }

  @Override
  public AgendamentoDTO buscarPorId(Integer id) {
    Agendamento agendamento = agendamentoRepository.findById(id)
        .orElseThrow(() -> new RegraNegocioException("Agendamento não encontrado"));

    return new AgendamentoDTO(agendamento.getDescricao(), agendamento.getDataInicio(), agendamento.getDataFim(),
        agendamento.getCidade(),
        agendamento.getUf(), agendamento.getCep(), agendamento.getResumo());
  }

}

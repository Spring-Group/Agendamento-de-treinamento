package com.example.sistemagestaotreinamento.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sistemagestaotreinamento.dtos.AgendamentoDTO;
import com.example.sistemagestaotreinamento.dtos.ProfessorDTO;
import com.example.sistemagestaotreinamento.exceptions.RegraNegocioException;
import com.example.sistemagestaotreinamento.models.Agendamento;
import com.example.sistemagestaotreinamento.models.Professor;
import com.example.sistemagestaotreinamento.repositories.AgendamentoRepository;
import com.example.sistemagestaotreinamento.repositories.ProfessorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImp implements ProfessorService {

  private final ProfessorRepository professorRepository;
  private final AgendamentoRepository agendamentoRepository;

  @Override
  @Transactional
  public void cadastrar(ProfessorDTO professorDTO) {
    Professor professor = new Professor();
    professor.setNome(professorDTO.getNome());
    professor.setCelular(professorDTO.getCelular());
    professor.setCpf(professorDTO.getCpf());
    professor.setRg(professorDTO.getRg());
    professor.setEndereco(professorDTO.getEndereco());
    professorRepository.save(professor);
  }

  @Override
  @Transactional
  public void atualizar(Integer id, ProfessorDTO professorDTO) {
    Professor professor = professorRepository.findById(id)
        .orElseThrow(() -> new RegraNegocioException("Professor não encontrado"));
    professor.setNome(professorDTO.getNome());
    professor.setCelular(professorDTO.getCelular());
    professor.setCpf(professorDTO.getCpf());
    professor.setRg(professorDTO.getRg());
    professor.setEndereco(professorDTO.getEndereco());
    professorRepository.save(professor);
  }

  @Override
  @Transactional
  public void excluir(Integer id) {
    professorRepository.deleteById(id);
  }

  @Override
  @Transactional
  public ProfessorDTO buscarPorId(Integer id) {
    Professor professor = professorRepository.findById(id)
        .orElseThrow(() -> new RegraNegocioException("Professor não encontrado"));

    Set<AgendamentoDTO> agendamentoDTOs = professor.getAgendamentos().stream()
        .map(agendamento -> new AgendamentoDTO(agendamento.getDescricao(), agendamento.getDataInicio(),
            agendamento.getDataFim(), agendamento.getCidade(), agendamento.getUf(), agendamento.getCep(),
            agendamento.getResumo()))
        .collect(Collectors.toSet());

    return new ProfessorDTO(professor.getNome(), professor.getCpf(), professor.getRg(),
        professor.getEndereco(), professor.getCelular(), agendamentoDTOs);
  }

  @Override
  public void vincularProfessorAAgendamento(Integer professorid, Integer agendamentoId) {

    Professor professor = professorRepository.findById(professorid)
        .orElseThrow(() -> new RegraNegocioException("Professor não encontrado"));

    Agendamento agendamento = agendamentoRepository.findById(agendamentoId)
        .orElseThrow(() -> new RegraNegocioException("Agendamento não encontrado"));

    professor.getAgendamentos().add(agendamento);
    professorRepository.save(professor);

  }

}
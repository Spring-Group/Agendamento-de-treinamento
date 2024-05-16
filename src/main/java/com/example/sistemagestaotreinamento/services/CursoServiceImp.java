package com.example.sistemagestaotreinamento.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sistemagestaotreinamento.dtos.CursoDTO;
import com.example.sistemagestaotreinamento.dtos.ProfessorDTO;
import com.example.sistemagestaotreinamento.exceptions.RegraNegocioException;
import com.example.sistemagestaotreinamento.models.Curso;
import com.example.sistemagestaotreinamento.models.Professor;
import com.example.sistemagestaotreinamento.repositories.CursoRepository;
import com.example.sistemagestaotreinamento.repositories.ProfessorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImp implements CursoService {

    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;

    @Override
    @Transactional
    public void cadastrar(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setDescricao(cursoDTO.getDescricao());
        curso.setCargaHoraria(cursoDTO.getCargaHoraria());
        curso.setObjetivos(cursoDTO.getObjetivos());
        curso.setEmenta(cursoDTO.getEmenta());
        cursoRepository.save(curso);

    }

    @Override
    @Transactional
    public void atualizar(Integer id, CursoDTO cursoDTO) {
       Curso curso = cursoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));
       curso.setDescricao(cursoDTO.getDescricao());
       curso.setCargaHoraria(cursoDTO.getCargaHoraria());
       curso.setObjetivos(cursoDTO.getObjetivos());
       curso.setEmenta(cursoDTO.getEmenta());

       cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void excluir(Integer id) {
        cursoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void vincularCursoAProfessor(Integer cursoId, Integer professorId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));

        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RegraNegocioException("Professor não encontrado"));

        curso.getProfessores().add(professor);
        cursoRepository.save(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public CursoDTO buscarPorId(Integer id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));

    List<ProfessorDTO> professoresDTO = curso.getProfessores().stream()
            .map(professor -> new ProfessorDTO(professor.getId(), professor.getNome(), professor.getCpf(), professor.getRg(), professor.getEndereco(), professor.getCelular(), null, null))
            .collect(Collectors.toList());

    return new CursoDTO(curso.getId(), curso.getDescricao(), curso.getCargaHoraria(), curso.getObjetivos(), curso.getEmenta(), professoresDTO);
}

    @Override
    @Transactional
    public List<CursoDTO> buscarTodos() {
       return cursoRepository.findAll().stream().map(curso -> new CursoDTO(curso.getId(), curso.getDescricao(), curso.getCargaHoraria(), curso.getObjetivos(), curso.getEmenta(), null)).collect(Collectors.toList());
    }
    
}

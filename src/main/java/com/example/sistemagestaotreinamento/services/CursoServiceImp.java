package com.example.sistemagestaotreinamento.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sistemagestaotreinamento.dtos.CursoDTO;
import com.example.sistemagestaotreinamento.exceptions.RegraNegocioException;
import com.example.sistemagestaotreinamento.models.Curso;
import com.example.sistemagestaotreinamento.repositories.CursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImp implements CursoService {

    private final CursoRepository cursoRepository;

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
    public CursoDTO buscarPorId(Integer id) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));

        return new CursoDTO(curso.getDescricao(), curso.getCargaHoraria(), curso.getObjetivos(), curso.getEmenta());
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

}

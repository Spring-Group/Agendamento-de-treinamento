package com.example.sistemagestaotreinamento.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemagestaotreinamento.dtos.CursoDTO;
import com.example.sistemagestaotreinamento.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
  @Autowired
  private CursoService cursoService;

  @PostMapping
  public void cadastrarCurso(@RequestBody CursoDTO cursoDTO) {
    cursoService.cadastrar(cursoDTO);
  }

  @GetMapping("/{id}")
  public CursoDTO buscarCursoPorId(@PathVariable Integer id) {
    return cursoService.buscarPorId(id);
  }

  @PutMapping("/{id}")
  public void atualizarCurso(@PathVariable Integer id, @RequestBody CursoDTO cursoDTO) {
    cursoService.atualizar(id, cursoDTO);
  }

  @DeleteMapping("/{id}")
  public void excluirCurso(@PathVariable Integer id) {
    cursoService.excluir(id);
  }

  @PostMapping("/{cursoId}/professores/{professorId}")
  public void vincularProfessorACurso(@PathVariable Integer cursoId, @PathVariable Integer professorId,
      @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
      @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {
    cursoService.vincularCursoAProfessor(cursoId, professorId, dataInicio, dataFim);
  }
}

package com.example.sistemagestaotreinamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemagestaotreinamento.dtos.ProfessorDTO;
import com.example.sistemagestaotreinamento.services.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
  @Autowired
  private ProfessorService professorService;

  @PostMapping
  public void cadastrarProfessor(@RequestBody ProfessorDTO professorDTO) {
    professorService.cadastrar(professorDTO);
  }

  @GetMapping("/{id}")
  public ProfessorDTO buscarProfessorPorId(@PathVariable Integer id) {
    return professorService.buscarPorId(id);
  }

  @PutMapping("/{id}")
  public void atualizarProfessor(@PathVariable Integer id, @RequestBody ProfessorDTO professorDTO) {
    professorService.atualizar(id, professorDTO);
  }

  @DeleteMapping("/{id}")
  public void excluirProfessor(@PathVariable Integer id) {
    professorService.excluir(id);
  }
}

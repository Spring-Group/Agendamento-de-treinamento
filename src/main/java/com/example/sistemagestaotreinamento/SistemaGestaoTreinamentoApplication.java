package com.example.sistemagestaotreinamento;

import java.time.LocalDateTime;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.sistemagestaotreinamento.models.Agendamento;
import com.example.sistemagestaotreinamento.models.Curso;
import com.example.sistemagestaotreinamento.models.Professor;
import com.example.sistemagestaotreinamento.repositories.AgendamentoRepository;
import com.example.sistemagestaotreinamento.repositories.CursoRepository;
import com.example.sistemagestaotreinamento.repositories.ProfessorRepository;
import com.example.sistemagestaotreinamento.services.AgendamentoService;
import com.example.sistemagestaotreinamento.services.CursoService;
import com.example.sistemagestaotreinamento.services.ProfessorService;

@SpringBootApplication
public class SistemaGestaoTreinamentoApplication {

	@Bean
	CommandLineRunner init(@Autowired CursoRepository cursoRepository, @Autowired ProfessorRepository professorRepository,
			@Autowired AgendamentoRepository agendamentoRepository, @Autowired CursoService cursoService,
			@Autowired ProfessorService professorService, @Autowired AgendamentoService agendamentoService) {
		return args -> {

			// Cadastrando o Professor
			Professor professor = new Professor();
			professor.setNome("Professor X");
			professor.setCpf("12345678900");
			professor.setRg("1234567");
			professor.setEndereco("Rua Teste, 123");
			professor.setCelular("(00) 98765-4321");
			professor = professorRepository.save(professor);

			// Cadastro o Curso
			Curso curso = new Curso();
			curso.setDescricao("React");
			curso.setCargaHoraria(40);
			curso.setObjetivos("Aprender React");
			curso.setEmenta("ementa teste");
			curso.setProfessores(new HashSet<>());
			curso.getProfessores().add(professor);

			// adicionando o curso ao professor
			professor.getCursos().add(curso);

			// Salvando as entidades
			cursoRepository.save(curso);
			professorRepository.save(professor);

			// Cadastrando o Agendamento
			Agendamento agendamento = new Agendamento();
			agendamento.setDescricao("Agendamento Teste");
			agendamento.setDataInicio(LocalDateTime.now());
			agendamento.setDataFim(LocalDateTime.now().plusHours(1));
			agendamento.setCidade("Cidade Teste");
			agendamento.setUf("UF");
			agendamento.setCep("00000-000");
			agendamento.setResumo("Resumo do agendamento teste");
			agendamento.setCurso(curso);
			agendamento.setProfessor(professor);

			agendamentoRepository.save(agendamento);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaGestaoTreinamentoApplication.class, args);
	}

}

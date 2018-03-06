package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TutorControllerTest {
	TutorController tutorController;
	
	@Before
	public void inicializar() {
		tutorController = new TutorController();
		tutorController.criarNovoTutor("111111111", "Otavio Rocha Alvez", "2", "(00) 00000-0000", "otavio@gmail.com");
		tutorController.cadastrarHorario("otavio@gmail.com", "15:30", "Seg");
		tutorController.cadastrarLocalDeAtendimento("otavio@gmail.com", "CAA");
	}
	
	@Test
	public void quantTutorTest() {
		String msg = "Avaliacao da quantidade de tutores registrados.";
		assertTrue(1 == tutorController.quantTudores());
	}
	
	@Test
	public void criarNovoTutorTest() {
		String msg = "Avaliacao do armazenamento adequado de Tutor.";
		tutorController.criarNovoTutor("000000000", "Otavio Rocha Alvez", "2", "(00) 00000-0000", "otavio@gmail.com");
		tutorController.criarNovoTutor("000000001", "Otavio Rocha Alvez", "2", "", "otavio@gmail.com");
		assertTrue(3 == tutorController.quantTudores());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void criarNovoTutorSemMatriculaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Tutor cuja matricula seja uma String vazia.";
		tutorController.criarNovoTutor("", "Otavio Rocha Alvez", "2", "(00) 00000-0000", "otavio@gmail.com");
		assertTrue(1 == tutorController.quantTudores());
	}	
	
	@Test
	public void tornarTutorTest() {
		String msg = "Avaliacao do funcionamento de tornar um Aluno Tutor.";
		tutorController.tornarTutor("111111111", "ATAl", 4);
	}
	
	@Test(expected = NullPointerException.class)
	public void tornarTutorMatriculaInvalidaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor com matricula no esteja cadastrada.";
		tutorController.tornarTutor("000000000", "ATAl", 4);
	}
	
	@Test(expected = NullPointerException.class)
	public void tornarTutorMatriculaVaziaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor com matricula seja vazia.";
		tutorController.tornarTutor("", "ATAl", 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tornarTutorProficienciaNegativaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor com proficiencia seja negativa.";
		tutorController.tornarTutor("111111111", "ATAl", -4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tornarTutorProficienciaZeroTest() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor com proficiencia seja zero.";
		tutorController.tornarTutor("111111111", "ATAl", 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tornarTutorDisciplinaVaziaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor com disciplina seja vazia.";
		tutorController.tornarTutor("111111111", "", 4);
	}
	
	@Test(expected = NullPointerException.class)
	public void tornarTutorDisciplinaNulaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor com disciplina nula.";
		tutorController.tornarTutor("111111111", null, 4);
	}
	
	@Test
	public void recuperaTutorTest() {
		String msg = "Avaliacao da representaço textual de um tutor.";
		assertEquals(msg ,"111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com",tutorController.recuperaTutor("111111111"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void recuperaTutorMatriculaInvalidaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recupear um tutor com matricula no esteja cadastrada.";
		assertEquals(msg ,"111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com",tutorController.recuperaTutor("110111111"));
	}
	
	@Test
	public void listarTutoresTest() {
		String msg = "Avaliacao da lista de representaçoes textuais dos tutores cadastrados.";
		assertEquals("111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com",tutorController.listarTutores());
	}
	
	@Test
	public void cadastrarHorarioTest() {
		String msg = "Avaliacao do funcionamento do cadastro de horario do Tutor.";
		tutorController.cadastrarHorario("otavio@gmail.com", "15:30", "Seg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarHorarioEmailInvalidoTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar horario de um tutor com email no cadastrado.";
		tutorController.cadastrarHorario("oavio@gmail.com", "15:30", "Seg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarHorarioEmailVazioTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar horario de um tutor com email vazio.";
		tutorController.cadastrarHorario("", "15:30", "Seg");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarHorarioEmailNuloTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um Horario cujo email seja um null.";
		tutorController.cadastrarHorario(null, "15:30", "Seg");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastrarHorarioHoraVaziaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar horario de um tutor com a hora vazia.";
		tutorController.cadastrarHorario("otavio@gmail.com", "", "Seg");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarHorarioHoraNulaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um Horario cuja hora seja um null.";
		tutorController.cadastrarHorario("otavio@gmail.com", null, "Seg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarHorarioDiaVazioTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar horario de um tutor com dia vazio.";
		tutorController.cadastrarHorario("otavio@gmail.com", "15:30", "");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarHorarioDianuloTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um Horario cujo dia seja um null.";
		tutorController.cadastrarHorario("otavio@gmail.com", "15:30", null);
	}

	@Test
	public void cadastrarLocalDeAtendimentoTest() {
		String msg = "Avaliacao do funcionamento do cadastro de local de atendimento do Tutor.";
		tutorController.cadastrarLocalDeAtendimento("otavio@gmail.com", "CAA");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarLocalDeAtendimentoEmailInvalidoTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar local de atendimento de um tutor com email no cadastrado.";
		tutorController.cadastrarLocalDeAtendimento("oavio@gmail.com", "CAA");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarLocalDeAtendimentoEmailVazioTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar local de atendimento de um tutor com email vazio.";
		tutorController.cadastrarLocalDeAtendimento("", "CAA");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarLocalDeAtendimentoEmailNuloTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar local de atendimento de um tutor com email nulo.";
		tutorController.cadastrarLocalDeAtendimento(null, "CAA");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarLocalDeAtendimentoLocalVazioTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar local de atendimento de um tutor local vazio.";
		tutorController.cadastrarLocalDeAtendimento("otavio@gmail.com", "");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarLocalDeAtendimentoLocalNuloTest() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um local de atendimento cujo local seja um null.";
		tutorController.cadastrarLocalDeAtendimento("otavio@gmail.com", null);
	}
	
	@Test
	public void consultaHorarioTest() {
		String msg = "Avaliacao da consulta do horario.";
		assertTrue(msg,tutorController.consultaHorario("otavio@gmail.com", "15:30", "Seg") == true);
	}
	
	@Test
	public void consultaHorarioNaoDisponivelTest() {
		String msg = "Avaliacao da consulta do horario com hora nao disponivel.";
		assertFalse(msg, tutorController.consultaHorario("otavio@gmail.com", "15:31", "Seg") == true);
	}
	
	@Test
	public void consultaHorarioDiaNaoDisponivelTest() {
		String msg = "Avaliacao da consulta do horario com dia no disponivel.";
		assertFalse(msg, tutorController.consultaHorario("otavio@gmail.com", "15:30", "Qua") == true);
	}
	
	@Test
	public void consultaLocalTest() {
		String msg = "Avaliacao da consulta do local de atendimento.";
		assertTrue(msg, tutorController.consultaLocal("otavio@gmail.com", "CAA") == true);
	}
	
	@Test
	public void consultaLocalErradoTest() {
		String msg = "Avaliacao da consulta do local de atendimento com local no disponivel.";
		assertFalse(msg, tutorController.consultaLocal("otavio@gmail.com", "CA") == true);
	}
	
}

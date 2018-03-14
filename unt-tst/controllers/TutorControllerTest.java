package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TutorControllerTest {
	
	private TutorController tutorController;
	
	@Before
	public void criaTutorController() {
		this.tutorController = new TutorController();
		this.tutorController.criarNovoTutor("1", "Nome 1", "1", "00000-0000", "adress@email.com");
		this.tutorController.tornarTutor("1", "Calculo", 4);
		this.tutorController.cadastrarHorario("adress@email.com", "15:30", "Seg");
		this.tutorController.cadastrarLocalDeAtendimento("adress@email.com", "CAA");
	}
	
	@Test
	public void testQuantTutor() {
		String msg = "Avaliacao da quantidade de tutores registrados.";
		assertTrue(msg, 1 == tutorController.getTotalTutores());
	}
	
	@Test
	public void testCriarNovoTutor() {
		String msg = "Avaliacao do armazenamento adequado de Tutor.";
		
		this.tutorController.criarNovoTutor("2", "Nome 2", "2", "00000-0000", "adress@email.com");
		this.tutorController.criarNovoTutor("3", "Nome 3", "3", "", "adress3@email.com");
		
		assertTrue(msg, 3 == tutorController.getTotalTutores());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCriarNovoTutorMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Tutor cuja matricula seja uma String vazia.";
		
		this.tutorController.criarNovoTutor("", "Nome 1", "1", "00000-0000", "adress@email.com");
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTornarTutorMatriculaInvalida() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor a partir de uma matricula nao cadastrada.";
		
		this.tutorController.tornarTutor("5", "ATAl", 4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTornarTutorMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor a partir de uma String vazia.";
		
		this.tutorController.tornarTutor("  ", "ATAl", 4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTornarTutorMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor a partir de uma matricula nula.";
		
		this.tutorController.tornarTutor(null, "ATAl", 4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTornarTutorProficienciaNegativa() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor a partir de uma proficiencia negativa.";
		
		this.tutorController.tornarTutor("1", "ATAl", -4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTornarTutorProficienciaZero() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor a partir de uma proficiencia nula.";
		
		this.tutorController.tornarTutor("1", "ATAl", 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTornarTutorDisciplinaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor a partir de uma disciplina vazia.";
		
		this.tutorController.tornarTutor("1", "", 4);
	}
	
	@Test(expected=NullPointerException.class)
	public void testTornarTutorDisciplinaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor a partir de uma disciplina nula.";
		
		this.tutorController.tornarTutor("1", null, 4);
	}
	
	@Test
	public void recuperaTutorTest() {
		String msg = "Avaliacao da representaco textual de um tutor.";
		assertEquals(msg ,"1 - Nome 1 - 1 - 00000-0000 - adress@email.com", this.tutorController.recuperaTutor("1"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRecuperaTutorMatriculaInvalida() {
		String msg = "Avaliacao da excecao lancada ao tentar recupear um tutor a partir de uma matricula nao cadastrada.";
		
		this.tutorController.recuperaTutor("5");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRecuperaTutorMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar recupear um tutor a partir de uma matricula vazia.";
		
		this.tutorController.recuperaTutor("   ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRecuperaTutorMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar recupear um tutor a partir de uma matricula nula.";
		
		this.tutorController.recuperaTutor(null);
	}
	
	@Test
	public void testListarTutores() {
		String msg = "Avaliacao da lista de representacoes textuais dos tutores cadastrados.";
		
		assertEquals("1 - Nome 1 - 1 - 00000-0000 - adress@email.com", this.tutorController.listarTutores());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarHorarioEmailInvalido() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar horario de um tutor a partir de um email nao cadastrado.";
		
		this.tutorController.cadastrarHorario("adress5@email.com", "15:30", "Seg");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarHorarioEmailVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar horario de um tutor a partir de um email vazio.";
		
		this.tutorController.cadastrarHorario("  ", "15:30", "Seg");
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarHorarioEmailNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um Horario de um tutor a partir de um email nulo.";
		
		this.tutorController.cadastrarHorario(null, "15:30", "Seg");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarHorarioHoraVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar horario de um tutor cuja hora seja uma String vazia.";
		
		this.tutorController.cadastrarHorario("adress@email.com", "  ", "Seg");
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarHorarioHoraNula() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um horario de um tutor cuja hora seja um null.";
		
		this.tutorController.cadastrarHorario("adress@email.com", null, "Seg");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarHorarioDiaVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar horario de um tutor cujo dia seja uma String vazia.";
		
		this.tutorController.cadastrarHorario("adress@email.com", "15:30", "");
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarHorarioDiaNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um horario de um tutor cujo dia seja um null.";
		
		this.tutorController.cadastrarHorario("adress@email.com", "15:30", null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoEmailInvalido() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar local de atendimento de um tutor a partir de um email nao cadastrado.";
		
		this.tutorController.cadastrarLocalDeAtendimento("adress5@email.com", "CAA");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoEmailVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar local de atendimento de um tutor a partir de um email vazio.";
		
		this.tutorController.cadastrarLocalDeAtendimento(" ", "CAA");
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarLocalDeAtendimentoEmailNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar local de atendimento de um tutor a partir de um email nulo.";
		
		this.tutorController.cadastrarLocalDeAtendimento(null, "CAA");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoLocalVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar local de atendimento de um tutor cujo nome seja uma String vazia.";
		
		this.tutorController.cadastrarLocalDeAtendimento("adress@email.com", "");
	}
	
	@Test(expected=NullPointerException.class)
	public void testCadastrarLocalDeAtendimentoLocalNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um local de atendimento de um tutor cujo nome seja um null.";
		
		this.tutorController.cadastrarLocalDeAtendimento("adress@email.com", null);
	}
	
	@Test
	public void testConsultaHorario() {
		String msg = "Avaliacao da consulta do horario.";
		
		assertTrue(msg, this.tutorController.consultaHorario("adress@email.com", "15:30", "Seg"));
	}
	
	@Test
	public void testConsultaHorarioNaoDisponivel() {
		String msg = "Avaliacao da consulta do horario com hora nao disponivel.";
		
		assertFalse(msg, this.tutorController.consultaHorario("adress@email.com", "15:31", "Seg"));
	}
	
	@Test
	public void testConsultaHorarioDiaNaoDisponivel() {
		String msg = "Avaliacao da consulta do horario com dia no disponivel.";
		
		assertFalse(msg, this.tutorController.consultaHorario("adress@email.com", "15:30", "Qua"));
	}
	
	@Test
	public void testConsultaLocal() {
		String msg = "Avaliacao da consulta do local de atendimento.";
		
		assertTrue(msg, this.tutorController.consultaLocal("adress@email.com", "CAA"));
	}
	
	@Test
	public void testConsultaLocalErrado() {
		String msg = "Avaliacao da consulta do local de atendimento com local no disponivel.";
		
		assertFalse(msg, this.tutorController.consultaLocal("adress@email.com", "CA"));
	}
	
	@Test
	public void testSelecionarCandidato() {
		String msg = "Avaliacao da selecao de candidato mais qualificado para ser tutor de determinada ajuda.";
		
		assertEquals("1",this.tutorController.selecionarCandidato("Calculo"));		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSelecionarCandidatoMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar selecionar cantidato a tutor a partir de uma matricula vazia.";
		
		this.tutorController.selecionarCandidato("   ");
	}
	
	@Test(expected=NullPointerException.class)
	public void testSelecionarCandidatoMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar selecionar cantidato a tutor a partir de uma matricula nula.";
		
		this.tutorController.selecionarCandidato(null);
	}
	
	@Test
	public void selecionarCandidato2() {
		String msg = "Avaliacao da selecao de candidato mais qualificado para ser tutor de determinada ajuda.";
		
		assertEquals("",this.tutorController.selecionarCandidato("Algebra", "15:30", "Seg", "CAA"));
		assertEquals("1",this.tutorController.selecionarCandidato("Calculo", "15:30", "Seg", "CAA"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSelecionarCandidato2DisciplinaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar selecionar cantidato a tutor a partir de uma disciplina vazia.";
		
		this.tutorController.selecionarCandidato("", "15:30", "Seg", "CAA");
	}
	
	@Test(expected=NullPointerException.class)
	public void testSelecionarCandidato2DisciplinaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar selecionar cantidato a tutor a partir de uma disciplina nula.";
		
		this.tutorController.selecionarCandidato(null, "15:30", "Seg", "CAA");
	}
	
	@Test
	public void testPegarNota() {
		String msg = "Verificao do retorno da nota de um Tutor a partir da matricula.";
		
		assertEquals("4,00",this.tutorController.pegarNota("1"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPegarNotaMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar pegar a nota de um Tutor a partir da matricula vazia.";
		
		assertEquals("4,00",this.tutorController.pegarNota(""));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPegarNotaMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar pegar a nota de um Tutor a partir da matricula nula.";
		
		assertEquals("4,00",this.tutorController.pegarNota(null));
	}
	
	@Test
	public void testPegarNivel() {
		String msg = "Verificao do retorno do nivel de um Tutor a partir da matricula.";
		
		assertEquals("Tutor",this.tutorController.pegarNivel("1"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPegarNivelMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar pegar o nivel de um Tutor a partir da matricula vazia.";
		
		assertEquals("Tutor",this.tutorController.pegarNivel(""));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPegarNivelMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar pegar a nota de um Tutor a partir da matricula nula.";
		
		assertEquals("Tutor",this.tutorController.pegarNivel(null));
	}
	
	@Test
	public void testAdicionarAvaliacao() {
		String msg = "Testa a adicao de uma avaliacao a um Tutor a partir da matricula.";
		
		this.tutorController.adicionarAvaliacao("1", 5);
		assertEquals("4,17", this.tutorController.pegarNota("1"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionarAvaliacaoMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar adicinar uma avalizacao a um Tutor a partir da matricula vazia.";
		
		this.tutorController.adicionarAvaliacao("", 5);
		assertEquals("4,17", this.tutorController.pegarNota("1"));	
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionarAvaliacaoMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar adicinar uma avalizacao a um Tutor a partir da matricula nula.";
		
		this.tutorController.adicionarAvaliacao(null, 5);
		assertEquals("4,17", this.tutorController.pegarNota("1"));	
	}
	
	@Test
	public void testCalcularComissao() {
		String msg = "Verifica o valor que sera respassado ao sistema pela doacao.";

		assertEquals(20,this.tutorController.calcularComissao("1", 100));
	}
	
	@Test
	public void testAdicionarDoacao() {
		String msg = "Verifica o sistema de doacao, verificando a porcentagem do tutor.";

		this.tutorController.adicionarDoacao("1", 100);
		assertEquals(80,this.tutorController.getTotalDinheiroTutor("adress@email.com"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarDoacaoMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar adicionar uma doacao com matricula de Tutor vazia.";

		this.tutorController.adicionarDoacao("", 100);
		assertEquals(80,this.tutorController.getTotalDinheiroTutor("adress@email.com"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarDoacaoMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar adicionar uma doacao com matricula de Tutor nula.";

		this.tutorController.adicionarDoacao(null, 100);
		assertEquals(80,this.tutorController.getTotalDinheiroTutor("adress@email.com"));
	}
	
}

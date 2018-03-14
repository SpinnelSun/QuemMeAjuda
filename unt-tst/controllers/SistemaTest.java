package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import controllers.Sistema;
import general.*;

public class SistemaTest {
	
	private Sistema sistema;
	
	@Before
	public void criaSistema() {
		this.sistema = new Sistema();
		
		this.sistema.cadastrarAluno("Nome 1", "1", 1, "00000-0000", "adress@email.com");
		this.sistema.cadastrarAluno("Nome 2", "2", 2, "", "adress2@email.com");
		
		this.sistema.tornarTutor("2", "ATAL", 3);
		this.sistema.cadastrarHorario("adress2@email.com", "15:30", "Seg");	
		this.sistema.cadastrarLocalDeAtendimento("adress2@email.com", "CAA - 104");
	}
	
	@Test(expected=AlunoException.class)
	public void testCadastrarAlunoNomeVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um aluno cujo nome seja uma String vazia.";
		
		this.sistema.cadastrarAluno("", "1", 1, "00000-0000", "adress@email.com");
	} 
	
	@Test(expected=AlunoException.class)
	public void testCadastrarAlunoNomeNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um aluno cujo nome seja um null.";
		
		this.sistema.cadastrarAluno(null, "1", 1, "00000-0000", "adress@email.com");
	} 
	
	@Test(expected=AlunoException.class)
	public void testCadastrarAlunoMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um aluno cuja matricula seja uma String vazia.";
		
		this.sistema.cadastrarAluno("Nome", "   ", 1, "00000-0000", "adress@email.com");
	} 
	
	@Test(expected=AlunoException.class)
	public void testCadastrarAlunoMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um aluno cuja matricula seja um null.";
		
		this.sistema.cadastrarAluno("Nome", null, 1, "00000-0000", "adress@email.com");
	} 
	
	@Test(expected=AlunoException.class)
	public void testCadastrarAlunoCodigoCursoZero() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um aluno cujo codigoCurso seja zero.";
		
		this.sistema.cadastrarAluno("Nome", "1", 0, "00000-0000", "adress@email.com");
	}
	
	@Test(expected=AlunoException.class)
	public void testCadastrarAlunoCodigoCursoNegativo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um aluno cujo codigoCurso seja negativo.";
		
		this.sistema.cadastrarAluno("Nome", "1", -1, "00000-0000", "adress@email.com");
	}
	
	@Test(expected=AlunoException.class)
	public void testCadastrarAlunoTelefoneNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um aluno cujo telefone seja um null.";
		
		this.sistema.cadastrarAluno("Nome", "1", 1, null, "adress@email.com");
	}
	
	@Test(expected=AlunoException.class)
	public void testCadastrarAlunoEmailVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um aluno cujo email seja uma String vazia.";
		
		this.sistema.cadastrarAluno("Nome", "1", 1, "00000-0000", "");
	}
	
	@Test(expected=AlunoException.class)
	public void testCadastrarAlunoEmailNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um aluno cujo email seja um null.";
		
		this.sistema.cadastrarAluno("Nome", "1", 1, "00000-0000", null);
	}
	
	@Test
	public void testGetInfoAluno() {
		String msg = "Avaliacao da obtenção do atributo nome do Aluno a partir da String passada como parametro.";
		assertEquals(msg, this.sistema.getInfoAluno("1", "nome"), "Nome 1");
		
		String msg2 = "Avaliacao da obtenção do atributo codigoCurso do Aluno a partir da String passada como parametro.";
		assertEquals(msg2, this.sistema.getInfoAluno("1", "curso"), "1");
		
		String msg3 = "Avaliacao da obtenção do atributo telefone do Aluno a partir da String passada como parametro.";
		assertEquals(msg3, this.sistema.getInfoAluno("1", "telefone"), "00000-0000");
		
		String msg4 = "Avaliacao da obtenção do atributo email do Aluno a partir da String passada como parametro.";
		assertEquals(msg4, this.sistema.getInfoAluno("1", "email"), "adress@email.com");
		
		String msg5 = "Avaliacao da obtenção do atributo nota do Aluno a partir da String passada como parametro.";
		assertEquals(msg5, this.sistema.getInfoAluno("1", "nota"), "5.0");
		
	}
	
	@Test(expected=AlunoException.class)
	public void testGetInfoAlunoAtributoInvalido() {
		String msg = "Avaliacao da excecao lancada ao tentar obter um atributo inexistente.";
		
		this.sistema.getInfoAluno("1", "idade");
	} 
	
	@Test
	public void testRecuperarAluno() {
		String msg = "Avaliacao da representacao textual de um aluno obtida a partir da matricula do aluno.";
		
		this.sistema.recuperaAluno("1");
	} 
	
	@Test(expected=AlunoException.class)
	public void testRecuperarAlunoMatriculaInvalida() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar um aluno nao cadastrado.";
		
		this.sistema.recuperaAluno("5");
	} 
	
	@Test(expected=AlunoException.class)
	public void testRecuperarAlunoMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar um aluno a partir de uma String vazia.";
		
		this.sistema.recuperaAluno("  ");
	} 
	
	@Test(expected=AlunoException.class)
	public void testRecuperarAlunoMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar um aluno a partir de uma null.";
		
		this.sistema.recuperaAluno(null);
	} 
	
	@Test
	public void testListarAlunos() {
		String msg = "Avaliacao da obtencao da listagem correta dos alunos cadastrados.";
		
		assertEquals(msg, this.sistema.listarAlunos(), "1 - Nome 1 - 1 - 00000-0000 - adress@email.com, 2 - Nome 2 - 2 - adress2@email.com");
	}
	
	@Test(expected=TutorException.class)
	public void testTornarTutorMatriculaInvalida() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor a partir de uma matricula nao cadastrada.";
		
		this.sistema.tornarTutor("5", "Vetorial", 1);
	}
	
	@Test(expected=TutorException.class)
	public void testTornarTutorMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor a partir de uma String vazia.";
		
		this.sistema.tornarTutor("   ", "Vetorial", 1);
	}
	
	@Test(expected=TutorException.class)
	public void testTornarTutorMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor a partir de um null.";
		
		this.sistema.tornarTutor(null, "Vetorial", 1);
	}
	
	@Test(expected=TutorException.class)
	public void testTornarTutorProeficienciaNegativa() {
		String msg = "Avaliacao da excecao lancada ao tentar tornar um aluno tutor com proficiencia negativa.";
		
		this.sistema.tornarTutor("1", "Vetorial", -1);
	}
	
	@Test
	public void testRecuperarTutor() {
		String msg = "Avaliacao da representacao textual de um tutor obtida a partir da matricula do tutor.";
		
		assertEquals(this.sistema.recuperaTutor("2"), "2 - Nome 2 - 2 - adress2@email.com");
	} 
	
	@Test(expected=TutorException.class)
	public void testRecuperarTutorMatriculaInvalida() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar um tutor nao cadastrado.";
		
		this.sistema.recuperaTutor("5");
	}
	
	@Test(expected=TutorException.class)
	public void testRecuperarTutorMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar um tutor a partir de uma String vazia.";
		
		this.sistema.recuperaTutor("   ");
	}
	
	@Test(expected=TutorException.class)
	public void testRecuperarTutorMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar um tutor a partir de um null.";
		
		this.sistema.recuperaTutor(null);
	}
	
	@Test
	public void testListarTutores() {
		String msg = "Avaliacao da obtencao da listagem correta dos tutores cadastrados.";
		
		assertEquals(this.sistema.listarTutores(), "2 - Nome 2 - 2 - adress2@email.com");
	}
	
	@Test(expected=TutorException.class)
	public void testCadastrarHorarioEmailVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um horario no tutor cujo email seja uma String vazia.";
		
		this.sistema.cadastrarHorario("", "15:30", "Seg");		
	}
	
	@Test(expected=TutorException.class)
	public void testCadastrarHorarioHorarioVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um horario no tutor cuja hora seja uma String vazia.";
		
		this.sistema.cadastrarHorario("adress2@email.com", "  ", "Seg");		
	}
	
	@Test(expected=TutorException.class)
	public void testCadastrarHorarioDiaVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um horario no tutor cujo dia seja uma String vazia.";
		
		this.sistema.cadastrarHorario("adress2@email.com", "15:30", "");		
	}
	
	@Test(expected=TutorException.class)
	public void testCadastrarHorarioEmailNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um horario no tutor cujo email seja um null.";
		
		this.sistema.cadastrarHorario(null, "15:30", "Seg");		
	}
	
	@Test(expected=TutorException.class)
	public void testCadastrarHorarioHorarioNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um horario no tutor cuja hora seja um null.";
		
		this.sistema.cadastrarHorario("adress2@email.com", null, "Seg");		
	}
	
	@Test(expected=TutorException.class)
	public void testCadastrarHorarioDiaNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um horario no tutor cujo dia seja um null.";
		
		this.sistema.cadastrarHorario("adress2@email.com", "15:30", null);		
	}
	
	@Test(expected=TutorException.class)
	public void testCadastrarLocalDeAtendimentoEmailVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um local no tutor cujo email seja uma String vazia.";
		
		this.sistema.cadastrarLocalDeAtendimento("", "CAA - 104");		
	}
	
	@Test(expected=TutorException.class)
	public void testCadastrarLocalDeAtendimentoLocalVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um local no tutor cujo nome do local seja uma String vazia.";
		
		this.sistema.cadastrarLocalDeAtendimento("adress2@email.com", "");		
	}
	
	@Test(expected=TutorException.class)
	public void testCadastrarLocalDeAtendimentoEmailNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um local no tutor cujo email seja um null.";
		
		this.sistema.cadastrarLocalDeAtendimento(null, "CAA - 104");		
	}
	
	@Test(expected=TutorException.class)
	public void testCadastrarLocalDeAtendimentoLocalNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar cadastrar um local no tutor cujo nome do local seja um null.";
		
		this.sistema.cadastrarLocalDeAtendimento("adress2@email.com", null);		
	}
	
	@Test
	public void testConsultarLocalDeAtendimento() {
		String msg = "Avaliacao da consulta de um local de atendimento cadastrado no tutor.";
		
		assertTrue(msg, this.sistema.consultaLocal("adress2@email.com", "CAA - 104"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testConsultarLocalDeAtendimentoEmailNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar consultar um local de atendimento a partir de um email nulo.";
		
		this.sistema.consultaLocal(null, "CAA - 104");
	}
	
	@Test(expected=NullPointerException.class)
	public void testConsultarLocalDeAtendimentoLocalNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar consultar um local de atendimento a partir de um local nulo.";
		
		this.sistema.consultaLocal("adress2@email.com", null);
	}
	
	@Test
	public void testConsultarHorarioDeAtendimento() {
		String msg = "Avaliacao da consulta de um horario de atendimento cadastrado no tutor.";
		
		assertTrue(msg, this.sistema.consultaHorario("adress2@email.com", "15:30", "Seg"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testConsultarHorarioDeAtendimentoEmailNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar consultar um horario de atendimento a partir de um email nulo.";
		
		this.sistema.consultaHorario(null, "15:30", "Seg");
	}
	
	@Test(expected=NullPointerException.class)
	public void testConsultarHorarioDeAtendimentoHorarioNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar consultar um horario de atendimento a partir de uma hora nula.";
		
		this.sistema.consultaHorario("adress2@email.com", null, "Seg");
	}
	
	@Test(expected=NullPointerException.class)
	public void testConsultarHorarioDeAtendimentoDiaNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar consultar um horario de atendimento a partir de um dia nulo.";
		
		this.sistema.consultaHorario("adress2@email.com", "15:30", null);
	}
	
	@Test
	public void testPegarTutorAjudaOnline() {
		String msg = "Avaliacao da obtencao das informacoes do tutor de uma ajuda online.";
		
		this.sistema.pedirAjudaOnline("1", "ATAL");
		
		assertEquals(msg, "Tutor - 2, disciplina - ATAL", this.sistema.pegarTutor(1));
	}
	
	@Test
	public void testPegarTutorAjudaPresencial() {
		String msg = "Avaliacao da obtencao das informacoes do tutor de uma ajuda presencial.";
		
		this.sistema.pedirAjudaPresencial("1", "ATAL", "10:00", "ter", "CAA");
		
		assertEquals(msg, "Tutor - 2, horario - 10:00, dia - ter, local - CAA, disciplina - ATAL", this.sistema.pegarTutor(1));
	}
	
	@Test(expected=AjudaException.class)
	public void testPegarTutorIdInexistente() {
		String msg = "Avaliacao da excecao lancada ao tentar pegar as informacoes de uma ajuda com id nao cadastrado.";
		
		this.sistema.pegarTutor(6);
	}
	
	@Test(expected=AjudaException.class)
	public void testPegarTutorIdNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar pegar as informacoes de uma ajuda a partir de um id nulo.";
		
		this.sistema.pegarTutor(0);
	}
	
	@Test(expected=AjudaException.class)
	public void testPegarTutorIdNegativo() {
		String msg = "Avaliacao da excecao lancada ao tentar pegar as informacoes de uma ajuda a partir de um id negativo.";
		
		this.sistema.pegarTutor(-3);
	}
	
	@Test
	public void testGetInfoAjudaOnline() {
		this.sistema.pedirAjudaOnline("1", "ATAL");
		
		String msg = "Avaliacao da obtencao da matricula do aluno que pediu a ajuda.";
		assertEquals(msg, "1", this.sistema.getInfo(1, "aluno"));
		
		String msg2 = "Avaliacao da obtencao da disciplina na qual o aluno pediu a ajuda.";
		assertEquals(msg2, "ATAL", this.sistema.getInfo(1, "disciplina"));
		
		String msg3 = "Avaliacao da obtencao da matricula do tutor que ira ajudar o aluno.";
		assertEquals(msg3, "2", this.sistema.getInfo(1, "tutor"));
	}
	
	@Test
	public void testGetInfoAjudaPresencial() {
		this.sistema.pedirAjudaPresencial("1", "ATAL", "10:00", "ter", "CAA");
		
		String msg = "Avaliacao da obtencao da matricula do aluno que pediu a ajuda.";
		assertEquals(msg, "1", this.sistema.getInfo(1, "aluno"));
		
		String msg2 = "Avaliacao da obtencao da disciplina na qual o aluno pediu a ajuda.";
		assertEquals(msg2, "ATAL", this.sistema.getInfo(1, "disciplina"));
		
		String msg3 = "Avaliacao da obtencao do horario de atendimento no qual o tutor ira ajudar o aluno.";
		assertEquals(msg3, "10:00", this.sistema.getInfo(1, "horario"));
		
		String msg4 = "Avaliacao da obtencao do dia de atendimento no qual o tutor ira ajudar o aluno.";
		assertEquals(msg4, "ter", this.sistema.getInfo(1, "dia"));
		
		String msg5 = "Avaliacao da obtencao do local de atendimento no qual o tutor ira ajudar o aluno.";
		assertEquals(msg5, "CAA", this.sistema.getInfo(1, "localInteresse"));
		
		String msg6 = "Avaliacao da obtencao da matricula do tutor que ira ajudar o aluno.";
		assertEquals(msg6, "2", this.sistema.getInfo(1, "tutor"));
	}
	
	@Test(expected=AjudaException.class)
	public void testGetInfoAjudaIdInexistente() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar um atributo de uma ajuda a partir de um id nao cadastrado.";
		
		this.sistema.getInfo(7, "aluno");
	}
	
	@Test(expected=AjudaException.class)
	public void testGetInfoAjudaIdNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar um atributo de uma ajuda a partir de um id nulo.";
		
		this.sistema.getInfo(0, "aluno");
	}
	
	@Test(expected=AjudaException.class)
	public void testGetInfoAjudaIdNegativo() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar um atributo de uma ajuda a partir de um id negativo.";
		
		this.sistema.getInfo(-5, "aluno");
	}
	
	@Test(expected=AjudaException.class)
	public void testGetInfoAjudaAtributoInexistente() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar um atributo inexistente.";
		
		this.sistema.pedirAjudaOnline("1", "ATAL");
		this.sistema.getInfo(1, "saude");
	}
	
	@Test(expected=AjudaException.class)
	public void testGetInfoAjudaAtributoVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar um atributo de uma ajuda a partir de uma String vazia.";
		
		this.sistema.pedirAjudaOnline("1", "ATAL");
		this.sistema.getInfo(1, "   ");
	}
	
	@Test(expected=AjudaException.class)
	public void testGetInfoAjudaAtributoNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar um atributo de uma ajuda a partir de um null.";
		
		this.sistema.pedirAjudaOnline("1", "ATAL");
		this.sistema.getInfo(1, null);
	}
	
	@Test
	public void testAvaliarTutor() {
		String msg = "Avaliacao do valor adequado da nota do tutor apos ser avaliado.";
		
		this.sistema.pedirAjudaOnline("1", "ATAL");
		this.sistema.avaliarTutor(1, 4);
		
		assertEquals(msg, "4,00", this.sistema.pegarNota("2"));
	}
	
	@Test(expected=AvaliacaoException.class)
	public void testAvaliarTutorIdInexistente() {
		String msg = "Avaliacao da excecao lancada ao tentar avaliar um tutor a partir de um id nao cadastrado.";
		
		this.sistema.avaliarTutor(5, 4);
	}
	
	@Test(expected=AvaliacaoException.class)
	public void testAvaliarTutorIdNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar avaliar um tutor a partir de um id nulo.";
		
		this.sistema.avaliarTutor(0, 4);
	}
	
	@Test(expected=AvaliacaoException.class)
	public void testAvaliarTutorIdNegativo() {
		String msg = "Avaliacao da excecao lancada ao tentar avaliar um tutor a partir de um id negativo.";
		
		this.sistema.avaliarTutor(-6, 4);
	}
	
	@Test(expected=AvaliacaoException.class)
	public void testAvaliarTutorNotaInvalida() {
		String msg = "Avaliacao da excecao lancada ao tentar avaliar um tutor com nota superior a 5.";
		
		this.sistema.pedirAjudaOnline("1", "ATAL");
		this.sistema.avaliarTutor(1, 6);
	}
	
	@Test(expected=AvaliacaoException.class)
	public void testAvaliarTutorNotaNegativa() {
		String msg = "Avaliacao da excecao lancada ao tentar avaliar um tutor com nota inferior a 0.";
		
		this.sistema.pedirAjudaOnline("1", "ATAL");
		this.sistema.avaliarTutor(1, -1);
	}
	
	@Test
	public void testPegarNivelTutor() {
		String msg = "Avaliacao da obtencao do nivel adequado do tutor.";
		
		assertEquals(msg, this.sistema.pegarNivel("2"), "Tutor");
	}
	
	@Test(expected=AvaliacaoException.class)
	public void testPegarNivelTutorNaoCadastrado() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar o nivel de um tutor a partir de uma matricula nao cadastrada.";
		
		this.sistema.pegarNivel("5");
	}
	
	@Test(expected=AvaliacaoException.class)
	public void testPegarNivelTutorMatriculaVaiza() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar o nivel de um tutor a partir de uma String vazia.";
		
		this.sistema.pegarNivel("");
	}
	
	@Test(expected=AvaliacaoException.class)
	public void testPegarNivelTutorMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar o nivel de um tutor a partir de um null.";
		
		this.sistema.pegarNivel(null);
	}
	
	@Test(expected=TutorException.class)
	public void testDoarMatriculaNaoCadastrada() {
		String msg = "Avaliacao da excecao lancada ao tentar doar para um tutor a partir de uma matricula nao cadastrada.";
		
		this.sistema.doar("5", 1000);
	}
	
	@Test(expected=TutorException.class)
	public void testDoarMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar doar para um tutor a partir de uma String vazia.";
		
		this.sistema.doar("   ", 1000);
	}
	
	@Test(expected=TutorException.class)
	public void testDoarMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar doar para um tutor a partir de um null.";
		
		this.sistema.doar(null, 1000);
	}
	
	@Test(expected=TutorException.class)
	public void testDoarValorNegativo() {
		String msg = "Avaliacao da excecao lancada ao tentar doar para um tutor um valor negativo.";
		
		this.sistema.doar("2", -3);
	}
	
	@Test
	public void testGetTotalDinheiroTutor() {
		String msg = "Avaliacao da obtencao do valor total recebido pelo tutor.";
		
		assertTrue(msg, this.sistema.totalDinheiroTutor("adress2@email.com") == 0);
	}
	
	@Test(expected=TutorException.class)
	public void testGetTotalDinheiroTutorMatriculaNaoCadastrada() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar o total de dinheiro doado a um tutor a partir de um email nao cadastrada.";
		
		this.sistema.totalDinheiroTutor("adress5@email.com");
	}
	
	@Test(expected=TutorException.class)
	public void testGetTotalDinheiroTutorMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar o total de dinheiro doado a um tutor a partir de uma String vazia.";
		
		this.sistema.totalDinheiroTutor("  ");
	}
	
	@Test(expected=TutorException.class)
	public void testGetTotalDinheiroTutorMatriculaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar resgatar o total de dinheiro doado a um tutor a partir de um null.";
		
		this.sistema.totalDinheiroTutor(null);
	}
	
	@Test
	public void testGetTotalSistema() {
		String msg = "Avaliacao do armazenamento adequado do valor destinado ao caixa do sistema.";
		
		assertTrue(msg, this.sistema.getCaixa() == 0);
	}
	
	@Test
	public void testConfigurarOrdemAlunos() {
		String msg = "Avaliacao da listagem adequada dos alunos apos ordenacao.";
		
		this.sistema.configurarOrdem("nome");
		
		String listagemEsperada = "1 - Nome 1 - 1 - 00000-0000 - adress@email.com, 2 - Nome 2 - 2 - adress2@email.com";
		assertEquals(msg, listagemEsperada, this.sistema.listarAlunos());
	}
	
	@Test
	public void testConfigurarOrdemTutores() {
		String msg = "Avaliacao da listagem adequada dos tutores apos ordenacao.";
		
		this.sistema.configurarOrdem("nome");
		
		String listagemEsperada = "2 - Nome 2 - 2 - adress2@email.com";
		assertEquals(msg, listagemEsperada, this.sistema.listarTutores());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConfigurarOrdemInvalida() {
		String msg = "Avaliacao da excecao lancada ao tentar configurar uma ordem invalida.";
		
		this.sistema.configurarOrdem("idade");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConfigurarOrdemVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar configurar ordem a partir de uma String vazia.";
		
		this.sistema.configurarOrdem("");
	}
	
	@Test(expected=NullPointerException.class)
	public void testConfigurarOrdemNula() {
		String msg = "Avaliacao da excecao lancada ao tentar configurar ordem a partir de um null.";
		
		this.sistema.configurarOrdem(null);
	}
	
}
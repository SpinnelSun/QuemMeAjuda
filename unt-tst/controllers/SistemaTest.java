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
	
}
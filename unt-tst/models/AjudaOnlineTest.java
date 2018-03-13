package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AjudaOnlineTest {
	
	private AjudaOnline ajuda;
	
	@Before
	public void criaAjudaOnline() {
		this.ajuda = new AjudaOnline("111111111", "Programacao 2", "999999999");
	}
	
	@Test
	public void testAjudaOnline() {
		String msg = "Avaliacao do armazenamento adequado da matricula do Aluno em uma AjudaOnline.";
		assertEquals(msg, "111111111", this.ajuda.getMatriculaAluno());
		
		String msg2 = "Avaliacao do armazenamento adequado da disciplina em uma AjudaOnline.";
		assertEquals(msg2, "Programacao 2", this.ajuda.getDisciplina());
		
		String msg3 = "Avaliacao do armazenamento adequado da matricula do Tutor em uma AjudaOnline.";
		assertEquals(msg3, "999999999", this.ajuda.getMatriculaTutor());	
		
		String msg4 = "Avaliacao do estado inicial adequado que define uma Ajuda como avaliada ou nao.";
		assertFalse(msg4, this.ajuda.getAvaliacaoConcluida());
	}
	
	@Test
	public void testRegistrarAvaliacao() {
		String msg = "Avaliacao do estado adequado de uma AjudaOnline ainda nao avaliada.";
		assertFalse(msg, this.ajuda.getAvaliacaoConcluida());
		
		this.ajuda.registrarAvaliacao();
		String msg2 = "Avaliacao do estado adequado de uma AjudaOnline ja avaliada.";
		assertTrue(msg2, this.ajuda.getAvaliacaoConcluida());
	}
	
	@Test
	public void testGetInfo() {
		String msg = "Avaliacao da obtenção do atributo matriculaAluno a partir do getInfo().";
		assertEquals(msg, "111111111", this.ajuda.getInfo("aluno"));
		
		String msg2 = "Avaliacao da obtenção do atributo disciplina a partir do getInfo().";
		assertEquals(msg2, "Programacao 2", this.ajuda.getInfo("disciplina"));
		
		String msg3 = "Avaliacao da obtenção do atributo matriculaTutor a partir do getInfo().";
		assertEquals(msg3, "999999999", this.ajuda.getInfo("tutor"));
	}
	
	@Test
	public void testToString() {
		String msg = "Avaliacao da representacao textual adequada de uma AjudaOnline.";
		assertEquals(msg, "Tutor - 999999999, disciplina - Programacao 2", this.ajuda.toString());	
	} 
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAtributoVazio() {
		String msg = "Avaliacao da excecao lancada ao utilizar uma String vazia para obter um atributo de uma AjudaOnline.";
		this.ajuda.getInfo("");
	}

	@Test(expected=NullPointerException.class)
	public void testGetInfoAtributoNulo() {
		String msg = "Avaliacao da excecao lancada ao utilizar um null para obter um atributo de uma AjudaOnline.";
		this.ajuda.getInfo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAjudaOnlineMatriculaAlunoVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaOnline cuja matricula do Aluno seja uma String vazia.";
		AjudaOnline ajudaInvalida = new AjudaOnline("   ", "Programacao 2", "1");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAjudaOnlineMatriculaAlunoNula() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaOnline cuja matricula do Aluno seja um null.";		
		AjudaOnline ajudaInvalida = new AjudaOnline(null, "Programacao 2", "1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAjudaOnlineDisciplinaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaOnline cuja disciplina seja uma String vazia.";
		AjudaOnline ajudaInvalida = new AjudaOnline("1", "", "2");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAjudaOnlineDisciplinaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaOnline cuja disciplina seja um null.";
		AjudaOnline ajudaInvalida = new AjudaOnline("1", null, "2");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAjudaOnlineMatriculaTutorNula() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaOnline cuja matricula do Tutor seja um null.";
		AjudaOnline ajudaInvalida = new AjudaOnline("1", "Programacao 2", null);
	}
	
}

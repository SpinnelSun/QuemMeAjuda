package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AjudaOnlineTest {
	
	private AjudaOnline ajuda;
	
	@Before
	public void criaAjudaOnline() {
		this.ajuda = new AjudaOnline("111111111", "Calculo 1", "999999999");
	}
	
	@Test
	public void testAjudaOnline() {
		String msg = "Avaliacao do armazenamento adequado da matricula do Aluno em uma AjudaOnline.";
		assertEquals(msg, "111111111", this.ajuda.getMatriculaAluno());
		
		String msg2 = "Avaliacao do armazenamento adequado da disciplina de uma ajuda em uma AjudaOnline.";
		assertEquals(msg2, "Calculo 1", this.ajuda.getDisciplina());
		
		String msg3 = "Avaliacao do armazenamento adequado da matricula do Tutor em uma AjudaOnline.";
		assertEquals(msg3, "999999999", this.ajuda.getMatriculaTutor());	
		
		String msg4 = "Avaliacao do estado inicial adequado que define uma Ajuda como avaliada ou nao.";
		assertFalse(msg4, this.ajuda.getAvaliacaoConcluida());
	}
	
	@Test
	public void testRegistrarAvaliacao() {
		String msg = "Avaliacao do estado adequado que define uma ajuda como avaliada ou nao.";
		
		this.ajuda.registrarAvaliacao();
		assertTrue(msg, this.ajuda.getAvaliacaoConcluida());
	}
	
	@Test
	public void testGetInfo() {
		String msg = "Avaliacao da obtenção do atributo matriculaAluno a partir da String passada como parametro.";
		assertEquals(msg, "111111111", this.ajuda.getInfo("aluno"));
		
		String msg2 = "Avaliacao da obtenção do atributo disciplina a partir da String passada como parametro.";
		assertEquals(msg2, "Calculo 1", this.ajuda.getInfo("disciplina"));
		
		String msg3 = "Avaliacao da obtenção do atributo matriculaTutor a partir da String passada como parametro.";
		assertEquals(msg3, "999999999", this.ajuda.getInfo("tutor"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAtributoVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar obter um atributo de uma AjudaOnline a partir de uma String vazia.";
		
		this.ajuda.getInfo("   ");
	}

	@Test(expected=NullPointerException.class)
	public void testGetInfoAtributoNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar obter um atributo de uma AjudaOnline a partir de um null.";
		
		this.ajuda.getInfo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAjudaOnlineMatriculaAlunoVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaOnline cuja matricula do Aluno seja uma String vazia.";
		
		AjudaOnline ajudaInvalida = new AjudaOnline("   ", "P2", "1");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAjudaOnlineMatriculaAlunoNula() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaOnline cuja matricula do Aluno seja um null.";
		
		AjudaOnline ajudaInvalida = new AjudaOnline(null, "P2", "1");
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
		
		AjudaOnline ajudaInvalida = new AjudaOnline("1", "P2", null);
	}
	
	@Test
	public void testToString() {
		String msg = "Avaliacao da representacao textual adequada de uma AjudaOnline.";
		
		assertEquals(msg, "Tutor - 999999999, disciplina - Calculo 1", this.ajuda.toString());	
	} 
	

}

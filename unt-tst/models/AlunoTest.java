package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {

	private Aluno alunoComTelefone;
	private Aluno alunoSemTelefone;
	
	@Before
	public void criaAluno() {
		this.alunoComTelefone = new Aluno("Nome 1", "111111111", 1, "0000-0000", "address@email.com");
		this.alunoSemTelefone = new Aluno("Nome 2", "222222222", 2, "", "adress2@email.com");
	}
	
	@Test
	public void testAluno() {
		String msg = "Avaliacao do armazenamento adequado do nome do aluno em um Aluno.";
		assertEquals(msg, "Nome 1", this.alunoComTelefone.getNome());
	
		String msg2 = "Avaliacao do armazenamento adequado da matricula do aluno em um Aluno.";
		assertEquals(msg2, "111111111", this.alunoComTelefone.getMatricula());
	
		String msg3 = "Avaliacao do armazenamento adequado do codigo do curso em um Aluno.";
		assertEquals(msg3, 1, this.alunoComTelefone.getCodigoCurso());
		
		String msg4 = "Avaliacao do armazenamento adequado do email em um Aluno.";
		assertEquals(msg4, "address@email.com", this.alunoComTelefone.getEmail());
		
		String msg5 = "Avaliacao do armazenamento adequado do telefone em um Aluno com telefone.";
		assertEquals(msg5, "0000-0000", this.alunoComTelefone.getTelefone());
		
		String msg6 = "Avaliacao do armazenamento adequado do telefone em um Aluno com telefone.";
		assertEquals(msg6, "", this.alunoSemTelefone.getTelefone());
		
		String msg7 = "Avaliacao do armazenamento adequado da nota do aluno em um Aluno.";
		assertTrue(msg7, this.alunoComTelefone.getNota() == 5.0);
	}

	@Test
	public void testToString() {
		String msg = "Avaliacao da representacao textual adequada de um Aluno.";
		assertEquals(msg, "111111111 - Nome 1 - 1 - 0000-0000 - address@email.com",
					 this.alunoComTelefone.toString());	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoNomeVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cujo nome seja uma String vazia.";
		Aluno alunoInvalido = new Aluno("     ", "A", 1, "0000-0000", "address@email.com");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoNomeNull() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cujo nome seja um null.";
		Aluno alunoInvalido = new Aluno(null, "A", 1, "0000-0000", "address@email.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoMatriculaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cuja matricula seja uma String vazia.";
		Aluno alunoInvalido = new Aluno("A", "", 1, "0000-0000", "address@email.com");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoMatriculaNull() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cuja matricula seja um null.";
		Aluno alunoInvalido = new Aluno("A", null, 1, "0000-0000", "address@email.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoCodigoCursoZero() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cujo codigo do curso seja 0.";
		Aluno alunoInvalido = new Aluno("A", "1", 0, "0000-0000", "address@email.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoCodigoCursoNegativo() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cujo codigo do curso seja negativo.";
		Aluno alunoInvalido = new Aluno("A", "1", -1, "0000-0000", "address@email.com");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoTelefoneNull() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cujo telefone seja um null.";
		Aluno alunoInvalido = new Aluno("A", "1", 1, null, "address@email.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoEmailVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cujo email seja uma String vazia.";
		Aluno alunoInvalido = new Aluno("A", "1", 1, "0000-0000", "");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoEmailNull() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cujo email seja um null.";
		Aluno alunoInvalido = new Aluno("A", "1", 1, "0000-0000", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoEmailIniciadoEmArroba() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cujo email comece em @.";
		Aluno alunoInvalido = new Aluno("A", "1", 1, "0000-0000", "@email.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoEmailTerminadoEmArroba() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cujo email comece em @.";
		Aluno alunoInvalido = new Aluno("A", "1", 1, "0000-0000", "address.email.com@");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoEmailSemArroba() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Aluno cujo email sem @.";
		Aluno alunoInvalido = new Aluno("A", "1", 1, "0000-0000", "address.email.com");
	}
	
}

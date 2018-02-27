package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {

	private Aluno alunoComTelefone;
	
	private Aluno alunoSemTelefone;
	
	@Before
	public void criaAluno() {
		this.alunoComTelefone = new Aluno("Nome 1", "111111111", 1, "9 8524-8775", "aluno.test@ccc.ufcg.edu.br");
		this.alunoSemTelefone = new Aluno("Nome 2", "222222222", 2, "", "aluno2.test@ccc.ufcg.edu.br");
	}
	
	@Test
	public void testGetNome() {
		String msg = "Avaliação do armazenamento adequado do nome do aluno em um Aluno.";
		
		assertEquals(msg, "Nome 1", this.alunoComTelefone.getNome());
		assertEquals(msg, "Nome 2", this.alunoSemTelefone.getNome());
	}
	
	@Test
	public void testGetMatricula() {
		String msg = "Avaliação do armazenamento adequado da matricula do aluno em um Aluno.";
		
		assertEquals(msg, "111111111", this.alunoComTelefone.getMatricula());
		assertEquals(msg, "222222222", this.alunoSemTelefone.getMatricula());
	}

	@Test
	public void testGetCodigoCurso() {
		String msg = "Avaliação do armazenamento adequado do codigo do curso do aluno em um Aluno.";
		
		assertEquals(msg, 1, this.alunoComTelefone.getCodigoCurso());
		assertEquals(msg, 2, this.alunoSemTelefone.getCodigoCurso());
	}

	@Test
	public void testGetNota() {
		String msg = "Avaliação do armazenamento adequado da nota do aluno em um Aluno.";
		
		assertTrue(msg, this.alunoComTelefone.getNota() == 5.0);
		assertTrue(msg, this.alunoSemTelefone.getNota() == 5.0);
	}

	@Test
	public void testSetNota() {
		String msg = "Avaliação da alteracao e do armazenamento adequado da nota do aluno em um Aluno.";
		
		this.alunoComTelefone.setNota(4.6);
		this.alunoSemTelefone.setNota(3.2);
		
		assertTrue(msg, this.alunoComTelefone.getNota() == 4.6);
		assertTrue(msg, this.alunoSemTelefone.getNota() == 3.2);
	}

	@Test
	public void testToString() {
		String msg = "Avaliação da representação textual adequada de um Aluno.";
		
		assertEquals(msg, "111111111 - Nome 1 - 1 - 9 8524-8775 - aluno.test@ccc.ufcg.edu.br", this.alunoComTelefone.toString());
		assertEquals(msg, "222222222 - Nome 2 - 2 - aluno2.test@ccc.ufcg.edu.br", this.alunoSemTelefone.toString());		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoNomeVazio() {
		String msg = "Avaliação da exceção lançada ao tentar criar um Aluno cujo nome seja uma String vazia.";
		
		Aluno alunoInvalido = new Aluno("     ", "333333333", 3, "9 8669-8274", "alunoNomeInvalido.test@ccc.ufcg.edu.br");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoNomeNull() {
		String msg = "Avaliação da exceção lançada ao tentar criar um Aluno cujo nome seja um null.";
		
		Aluno alunoInvalido = new Aluno(null, "444444444", 4, "9 8554-7425", "alunoNomeInvalido.test@ccc.ufcg.edu.br");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoMatriculaVazia() {
		String msg = "Avaliação da exceção lançada ao tentar criar um Aluno cuja matricula seja uma String vazia.";
		
		Aluno alunoInvalido = new Aluno("Nome 3", "           ", 5, "9 8362-1542", "alunoMatriculaInvalida.test@ccc.ufcg.edu.br");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoMatriculaNull() {
		String msg = "Avaliação da exceção lançada ao tentar criar um Aluno cuja matricula seja um null.";
		
		Aluno alunoInvalido = new Aluno("Nome 4", null, 6, "9 8861-0126", "alunoMatriculaInvalida.test@ccc.ufcg.edu.br");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoCodigoCursoInvalido() {
		String msg = "Avaliação da exceção lançada ao tentar criar um Aluno cujo codigo do curso seja menor que 1.";
		
		Aluno alunoInvalido = new Aluno("Nome 5", "555555555", 0, "9 8852-6320", "alunoCodigoCursoInvalido.test@ccc.ufcg.edu.br");
		Aluno alunoInvalido2 = new Aluno("Nome 6", "666666666", -2, "", "alunoCodigoCursoInvalido2.test@ccc.ufcg.edu.br");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoTelefoneNull() {
		String msg = "Avaliação da exceção lançada ao tentar criar um Aluno cujo telefone seja um null.";
		
		Aluno alunoInvalido = new Aluno("Nome 7", "777777777", 7, null, "alunoTelefoneInvalido.test@ccc.ufcg.edu.br");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarAlunoEmailVazio() {
		String msg = "Avaliação da exceção lançada ao tentar criar um Aluno cujo email seja uma String vazia.";
		
		Aluno alunoInvalido = new Aluno("Nome 8", "888888888", 8, "", "     ");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoEmailNull() {
		String msg = "Avaliação da exceção lançada ao tentar criar um Aluno cujo email seja um null.";
		
		Aluno alunoInvalido = new Aluno("Nome 9", "999999999", 9, "9 8504-2441", null);
	}
	
}

package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AlunoControllerTest {
	
	private AlunoController alunoController;
	
	@Before
	public void criaAlunoController() {
		alunoController = new AlunoController();
		alunoController.cadastrarAluno("Nome 1", "1", 2, "00000-0000", "adress@email.com");
	}
	
	@Test
	public void criarAlunoTest() {
		String msg = "Avaliacao da criaco e armazenamento de aluno.";
		alunoController.cadastrarAluno("Nome 2", "2", 2, "00000-0000", "adress2@email.com");
		assertTrue(msg, alunoController.quantAlunos() == 2);
	}
	
	@Test
	public void recuperaAlunoTest() {
		String msg = "Avaliacao da representaco textual de um Aluno.";
		assertEquals(msg ,"1 - Nome 1 - 2 - 00000-0000 - adress@email.com", alunoController.recuperaAluno("1"));
	}
	
	@Test
	public void listarAlunosTest() {
		String msg = "Avaliacao da lista de representacoes textuais dos alunos cadastrados.";
		assertEquals(msg,"1 - Nome 1 - 2 - 00000-0000 - adress@email.com", alunoController.listarAlunos());
	}
	
	@Test
	public void getInfoAlunoTest() {
		String msg = "Avaliacao da obtenção do nome do Aluno a partir da String passada como parametro.";
		assertEquals(msg, "Nome 1", alunoController.getInfoAluno("1", "nome"));
		
		String msg2 = "Avaliacao da obtenção da matricula do Aluno a partir da String passada como parametro.";
		assertEquals(msg2, "1", alunoController.getInfoAluno("1", "matricula"));
		
		String msg3 = "Avaliacao da obtenção do telefone do Aluno a partir da String passada como parametro.";
		assertEquals(msg3, "00000-0000", alunoController.getInfoAluno("1", "telefone"));
		
		String msg4 = "Avaliacao da obtenção do email do Aluno a partir da String passada como parametro.";
		assertEquals(msg4, "adress@email.com", alunoController.getInfoAluno("1", "email"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void criarAlunoMatriculaExistenteTest() {
		String msg = "Avaliacao da excecao lancada ao cadastrar um aluno ja cadastrado.";
		
		alunoController.cadastrarAluno("Nome 1", "1", 2, "00000-0000", "adress@email.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void recuperaAlunoMatriculaVaziaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recupear um aluno com matricula vazia.";
		
		this.alunoController.recuperaAluno("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void recuperaAlunoMatriculaNulaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recupear um aluno com matricula nula.";
		
		this.alunoController.recuperaAluno(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoMatriculaInvalidaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar nome de um aluno com matricula nao cadastrada.";
		
		this.alunoController.getInfoAluno("5", "nome");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoMatriculaVaziaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar nome de um aluno com matricula no vazia.";
		
		this.alunoController.getInfoAluno("", "nome");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoMatriculaNulaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar nome de um aluno com matricula nula.";
		
		this.alunoController.getInfoAluno(null, "nome");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoAtributoVazioTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar algo com campo vazio";
		this.alunoController.getInfoAluno("1", "");
	}
	
	@Test(expected = NullPointerException.class)
	public void getInfoAlunoAtributoNuloTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar algo com campo nulo";
		
		this.alunoController.getInfoAluno("1", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoAtributoInvalidoTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar algo com campo no existente";
		
		this.alunoController.getInfoAluno("1", "idade");
	}

}

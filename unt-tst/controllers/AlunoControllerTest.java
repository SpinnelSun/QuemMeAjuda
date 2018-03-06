package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AlunoControllerTest {
	AlunoController alunoController;
	
	@Before
	public void inicializar() {
		alunoController = new AlunoController();
		alunoController.cadastrarAluno("Otavio Rocha Alvez", "111111111", 2, "(00) 00000-0000", "otavio@gmail.com");
	}
	
	@Test
	public void criarNovoAlunoTest() {
		String msg = "Avaliacao da criação e armazenamento de aluno.";
		alunoController.cadastrarAluno("000000000", "Otavio Rocha Alvez", 2, "(00) 00000-0000", "otavio@gmail.com");
		assertTrue(msg,2 == alunoController.quantAlunos());
	}
	
	@Test//(expected = IllegalArgumentException.class)
	public void criarNovoAlunoMatriculaRepetidaTest() {
		alunoController.cadastrarAluno("111111111", "Otavio Rocha Alvez", 2, "(00) 00000-0000", "otavio@gmail.com");
	}

	@Test
	public void recuperaAlunoTest() {
		String msg = "Avaliacao da representação textual de um Aluno.";
		assertEquals(msg ,"111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com", alunoController.recuperaAluno("111111111"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void recuperaAlunoMatriculaVaziaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recupear um aluno com matricula vazia.";
		assertEquals(msg,"111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com", alunoController.recuperaAluno(""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void recuperaAlunoMatriculaNulaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recupear um aluno com matricula nula.";
		assertEquals(msg,"111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com", alunoController.recuperaAluno(null));
	}
	
	@Test
	public void listarAlunosTest() {
		String msg = "Avaliacao da lista de representações textuais dos alunos cadastrados.";
		assertEquals(msg,"111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com", alunoController.listarAlunos());
	}
	
	@Test
	public void getInfoAlunoTest() {
		String msg = "Avaliacao do retorno adequado dos atributos de um Aluno cadastrado.";
		assertEquals(msg, "Otavio Rocha Alvez", alunoController.getInfoAluno("111111111", "nome"));
		assertEquals(msg, "111111111", alunoController.getInfoAluno("111111111", "matricula"));
		assertEquals(msg, "(00) 00000-0000", alunoController.getInfoAluno("111111111", "telefone"));
		assertEquals(msg, "otavio@gmail.com", alunoController.getInfoAluno("111111111", "email"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoMatriculaInvalidaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar nome de um aluno com matricula não cadastrada.";
		assertEquals(msg, "Otavio Rocha Alvez", alunoController.getInfoAluno("110111111", "nome"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoMatriculaVaziaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar nome de um aluno com matricula não vazia.";
		assertEquals(msg, "Otavio Rocha Alvez", alunoController.getInfoAluno("", "nome"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoMatriculaNulaTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar nome de um aluno com matricula nula.";
		assertEquals(msg,"Otavio Rocha Alvez", alunoController.getInfoAluno(null, "nome"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoAtributoVazioTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar algo com campo vazio";
		assertEquals(msg,"Otavio Rocha Alvez", alunoController.getInfoAluno("111111111", ""));
	}
	
	@Test(expected = NullPointerException.class)
	public void getInfoAlunoAtributoNuloTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar algo com campo nulo";
		assertEquals(msg,"Otavio Rocha Alvez", alunoController.getInfoAluno("111111111", null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoAtributoInvalidoTest() {
		String msg = "Avaliacao da excecao lancada ao tentar recuperar algo com campo não existente";
		assertEquals(msg,"Otavio Rocha Alvez", alunoController.getInfoAluno("111111111", "idade"));
	}

}

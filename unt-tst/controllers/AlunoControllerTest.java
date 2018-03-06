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
	public void criarNovoTutorTest() {
		alunoController.cadastrarAluno("000000000", "Otavio Rocha Alvez", 2, "(00) 00000-0000", "otavio@gmail.com");
	}
	
	@Test//(expected = IllegalArgumentException.class)
	public void criarNovoTutorMatriculaRepetidaTest() {
		alunoController.cadastrarAluno("111111111", "Otavio Rocha Alvez", 2, "(00) 00000-0000", "otavio@gmail.com");
	}

	@Test
	public void recuperaAlunoTest() {
		assertEquals("111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com", alunoController.recuperaAluno("111111111"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void recuperaAlunoMatriculaVaziaTest() {
		assertEquals("111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com", alunoController.recuperaAluno(""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void recuperaAlunoMatriculaNulaTest() {
		assertEquals("111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com", alunoController.recuperaAluno(null));
	}
	
	@Test
	public void listarAlunosTest() {
		assertEquals("111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com", alunoController.listarAlunos());
	}
	
	@Test
	public void getInfoAlunoTest() {
		assertEquals("Otavio Rocha Alvez", alunoController.getInfoAluno("111111111", "nome"));
		assertEquals("111111111", alunoController.getInfoAluno("111111111", "matricula"));
		assertEquals("(00) 00000-0000", alunoController.getInfoAluno("111111111", "telefone"));
		assertEquals("otavio@gmail.com", alunoController.getInfoAluno("111111111", "email"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoMatriculaInvalidaTest() {
		assertEquals("Otavio Rocha Alvez", alunoController.getInfoAluno("110111111", "nome"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoMatriculaVaziaTest() {
		assertEquals("Otavio Rocha Alvez", alunoController.getInfoAluno("", "nome"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoMatriculaNulaTest() {
		assertEquals("Otavio Rocha Alvez", alunoController.getInfoAluno(null, "nome"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoAtributoVazioTest() {
		assertEquals("Otavio Rocha Alvez", alunoController.getInfoAluno("111111111", ""));
	}
	
	@Test(expected = NullPointerException.class)
	public void getInfoAlunoAtributoNuloTest() {
		assertEquals("Otavio Rocha Alvez", alunoController.getInfoAluno("111111111", null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoAtributoInvalidoTest() {
		assertEquals("Otavio Rocha Alvez", alunoController.getInfoAluno("111111111", "idade"));
	}

}

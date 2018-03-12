package controllers;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import models.Academico;
import models.Aluno;

public class AlunoPorMatriculaTest {

	private Comparator<Academico> comparator;
	
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	
	@Before
	public void criaAlunoPorMatricula() {
		this.comparator = new AcademicoPorMatricula();
		
		this.aluno1 = new Aluno("A", "1", 1, "00000-0000", "a@email.com");
		this.aluno2 = new Aluno("B", "2", 1, "00000-0000", "b@email.com");
		this.aluno3 = new Aluno("A", "3", 1, "00000-0000", "c@email.com");
	}
	
	@Test
	public void testCompareMenorMatriculaMaiorMatricula() {
		String msg = "Avaliacao da comparacao de um Aluno com outro de matricula lexicograficamente maior.";
		assertTrue(this.comparator.compare(this.aluno1, this.aluno2) < 0); 
	}
	
	@Test
	public void testCompareMaiorMatriculaMenorMatricula() {
		String msg = "Avaliacao da comparacao de um Aluno com outro de matricula lexicograficamente menor.";
		assertTrue(this.comparator.compare(this.aluno2, this.aluno1) > 0); 
	}
	
	@Test
	public void testCompareMatriculasIguais() {
		String msg = "Avaliacao da comparacao de um Aluno com outro de matricula lexicograficamente igual.";
		assertTrue(this.comparator.compare(this.aluno1, this.aluno3) < 0); 
	}

}

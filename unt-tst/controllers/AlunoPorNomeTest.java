package controllers;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import models.Academico;
import models.Aluno;
import controllers.AcademicoPorNome;

public class AlunoPorNomeTest {
	
	private Comparator<Academico> comparator;
	
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	
	@Before
	public void criaAlunoPorNome() {
		this.comparator = new AcademicoPorNome();
		
		this.aluno1 = new Aluno("A", "1", 1, "00000-0000", "a@email.com");
		this.aluno2 = new Aluno("B", "2", 1, "00000-0000", "b@email.com");
		this.aluno3 = new Aluno("A", "3", 1, "00000-0000", "c@email.com");
	}
	
	@Test
	public void testCompareMenorNomeMaiorNome() {
		String msg = "Avaliacao da comparacao de um Aluno com outro de nome lexicograficamente maior.";
		assertTrue(this.comparator.compare(this.aluno1, this.aluno2) < 0); 
	}
	
	@Test
	public void testCompareMaiorNomeMenorNome() {
		String msg = "Avaliacao da comparacao de um Aluno com outro de nome lexicograficamente menor.";
		assertTrue(this.comparator.compare(this.aluno2, this.aluno1) > 0); 
	}
	
	@Test
	public void testCompareNomesIguais() {
		String msg = "Avaliacao da comparacao de um Aluno com outro de nome lexicograficamente igual.";
		assertTrue(this.comparator.compare(this.aluno1, this.aluno3) < 0); 
	}

}

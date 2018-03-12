package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TutoriaTest {
	
	private Habilidade tutoria1;
	private Habilidade tutoria2;
	private Habilidade tutoria3;
	
	@Before
	public void criaTutoria() {
		this.tutoria1 = new Habilidade(" Programacao 2 ", 5);
		this.tutoria2 = new Habilidade("Programacao 1", 5);
		this.tutoria3 = new Habilidade("Programacao 2", 4);
	}

	@Test
	public void testTutoria() {
		String msg = "Avaliacao do armazenamento adequado da disciplina em uma Tutoria.";
		assertEquals(msg, this.tutoria1.getDisciplina(), "Programacao 2");
		
		String msg2 = "Avaliacao do armazenamento adequado da proficiencia em uma Tutoria.";
		assertTrue(msg2, this.tutoria1.getProficiencia() == 5);
	}

	@Test
	public void testEqualsObject() {
		String msg = "Avaliacao do resultado adequado do Equals de uma Tutoria com ela mesma.";
		assertTrue(msg, this.tutoria1.equals(this.tutoria1));
		
		String msg2 = "Avaliacao do resultado adequado do Equals de uma Tutoria com um null.";
		assertFalse(msg2, this.tutoria1.equals(null));
		
		String msg3 = "Avaliacao do resultado adequado do Equals de uma Tutoria com outra Tutoria igual.";
		assertTrue(msg3, this.tutoria1.equals(this.tutoria3));
		
		String msg4 = "Avaliacao do resultado adequado do Equals de uma Tutoria com outra Tutoria diferente.";
		assertFalse(msg4, this.tutoria1.equals(this.tutoria2));
	}

	@Test
	public void testToString() {
		String msg = "Avaliacao da representacao textual adequada de uma Tutoria.";
		assertEquals(msg, this.tutoria1.toString(), "Programacao 2 - 5");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarTutoriaDisciplinaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma Tutoria cuja disciplina esteja vazia.";
		
		Habilidade tutoria = new Habilidade("", 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarTutoriaDisciplinaNull() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma Tutoria cuja disciplina seja null.";
		
		Habilidade tutoria = new Habilidade(null, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarTutoriaProficienciaNegativa() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma Tutoria cuja proficiencia seja negativa.";
		
		Habilidade tutoria = new Habilidade("Programacao 2", -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarTutoriaProficienciaZero() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma Tutoria cuja proficiencia seja zero.";
		
		Habilidade tutoria = new Habilidade("Programacao 2", 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarTutoriaProficienciaPositiva() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma Tutoria com proficiencia maior que 5.";
		
		Habilidade tutoria = new Habilidade("Programacao 2", 6);
	}

}

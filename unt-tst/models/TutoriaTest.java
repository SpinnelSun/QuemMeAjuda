package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TutoriaTest {
	
	private Tutoria tutoria1;
	private Tutoria tutoria2;
	private Tutoria tutoria3;
	
	@Before
	public void criarTutoria() {
		this.tutoria1 = new Tutoria(" Programação 2 ", 5);
		this.tutoria2 = new Tutoria("Programação 1", 5);
		this.tutoria3 = new Tutoria("Programação 2", 4);
	}

	@Test
	public void testTutoria() {
		String msg = "Avaliação do armazenamento adequado da disciplina em uma Tutoria.";
		assertEquals(msg, this.tutoria1.getDisciplina(), "Programação 2");
		
		String msg2 = "Avaliação do armazenamento adequado da proficiência em uma Tutoria.";
		assertTrue(msg2, this.tutoria1.getProficiencia() == 5);
	}

	@Test
	public void testEqualsObject() {
		String msg = "Avaliação do resultado adequado do Equals de uma Tutoria com ela mesma.";
		assertTrue(msg, this.tutoria1.equals(this.tutoria1));
		
		String msg2 = "Avaliação do resultado adequado do Equals de uma Tutoria com um null.";
		assertFalse(msg2, this.tutoria1.equals(null));
		
		String msg3 = "Avaliação do resultado adequado do Equals de uma Tutoria com outra Tutoria igual.";
		assertTrue(msg3, this.tutoria1.equals(this.tutoria3));
		
		String msg4 = "Avaliação do resultado adequado do Equals de uma Tutoria com outra Tutoria diferente.";
		assertFalse(msg4, this.tutoria1.equals(this.tutoria2));
	}

	@Test
	public void testToString() {
		String msg = "Avaliação da representação textual adequada de uma Tutoria.";
		assertEquals(msg, this.tutoria1.toString(), "Programação 2 - 5");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarTutoriaDisciplinaVazia() {
		String msg = "Avaliação da exceção lançada ao tentar criar uma Tutoria cuja disciplina esteja vazia.";
		Tutoria tutoria = new Tutoria("", 5);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarTutoriaDisciplinaNull() {
		String msg = "Avaliação da exceção lançada ao tentar criar uma Tutoria cuja disciplina seja null.";
		Tutoria tutoria = new Tutoria(null, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarTutoriaProficienciaNegativa() {
		String msg = "Avaliação da exceção lançada ao tentar criar uma Tutoria cuja proficiencia seja negativa.";
		Tutoria tutoria = new Tutoria("Programação 2", -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarTutoriaProficienciaZero() {
		String msg = "Avaliação da exceção lançada ao tentar criar uma Tutoria cuja proficiencia seja zero.";
		Tutoria tutoria = new Tutoria("Programação 2", 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarTutoriaProficienciaMaior() {
		String msg = "Avaliação da exceção lançada ao tentar criar uma Tutoria com proficiencia maior que 5.";
		Tutoria tutoria = new Tutoria("Programação 2", 6);
	}

}

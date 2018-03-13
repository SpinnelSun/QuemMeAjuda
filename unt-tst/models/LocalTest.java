package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import general.Validador;

public class LocalTest {
	
	private Local local1;
	private Local local2;
	private Local local3;
	
	@Before
	public void criarLocal() {
		this.local1 = new Local("Primeiro Local");
		this.local2 = new Local("Segundo Local");
		this.local3 = new Local("Primeiro Local   ");
	}

	@Test
	public void testLocal() {
		String msg = "Avaliacao do armazenamento adequado do nome do local em um Local.";
		assertEquals(msg, this.local1.getNome(), "Primeiro Local");
	}

	@Test
	public void testEqualsObject() {
		String msg = "Avaliacao do resultado adequado do Equals de um Local com ele mesmo.";
		assertTrue(msg, this.local1.equals(this.local1));
		
		String msg2 = "Avaliacao do resultado adequado do Equals de um Local com um null.";
		assertFalse(msg2, this.local1.equals(null));
		
		String msg3 = "Avaliacao do resultado adequado do Equals de um Local com outro Local igual.";
		assertTrue(msg3, this.local1.equals(this.local3));
		
		String msg4 = "Avaliacao do resultado adequado do Equals de um Local com outro Local diferente.";
		assertFalse(msg4, this.local1.equals(this.local2));
	}

	@Test
	public void testToString() {
		String msg = "Avaliacao da representacao textual adequada de um Local.";
		assertEquals(msg, this.local1.toString(), "Primeiro Local");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarLocalNomeVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Local cujo nome seja uma String vazia.";
		Local local = new Local("");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarLocalNomeNull() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Local cujo nome seja um null.";
		Local local = new Local(null);
	}

}

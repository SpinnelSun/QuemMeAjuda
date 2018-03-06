package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HorarioTest {

	private Horario horario1;
	private Horario horario2;
	private Horario horario3;
	private Horario horario4;
	
	@Before
	public void criarHorario() {
		this.horario1 = new Horario("00:00", "Segunda");
		this.horario2 = new Horario("00:00", "Terca");
		this.horario3 = new Horario("00:00   ", "Segunda");
		this.horario4 = new Horario("00:01", "   Segunda");
	}

	@Test
	public void testHorario() {
		String msg = "Avaliacao do armazenamento adequado da hora de um Horario.";
		assertEquals(msg, this.horario1.getHora(), "00:00");
		
		String msg2 = "Avaliacao do armazenamento adequado do dia de um Horario.";
		assertEquals(msg2, this.horario1.getDia(), "Segunda");
	}

	@Test
	public void testEqualsObject() {
		String msg = "Avaliacao do resultado adequado do Equals de um Horario com ele mesmo.";
		assertTrue(msg, this.horario1.equals(this.horario1));
		
		String msg2 = "Avaliacao do resultado adequado do Equals de um Horario com um null.";
		assertFalse(msg2, this.horario1.equals(null));
		
		String msg3 = "Avaliacao do resultado adequado do Equals de um Horario com outro Horario igual.";
		assertTrue(msg3, this.horario1.equals(this.horario3));
		
		String msg4 = "Avaliacao do resultado adequado do Equals de um Horario com Horario diferente por hora.";
		assertFalse(msg4, this.horario1.equals(this.horario4));
		
		String msg5 = "Avaliacao do resultado adequado do Equals de um Horario com Horario diferente por dia.";
		assertFalse(msg4, this.horario1.equals(this.horario2));
	}

	@Test
	public void testToString() {
		String msg = "Avaliacao da representacao textual adequada de um Horario.";
		assertEquals(msg, this.horario1.toString(), "00:00 - Segunda");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarHorarioHoraVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Horario cuja hora seja uma String vazia.";
		Horario horario = new Horario("", "Segunda");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarHorarioHoraNull() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Horario cuja hora seja um null.";
		Horario horario = new Horario(null, "Segunda");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarHorarioDiaVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Horario cujo dia seja uma String vazia.";
		Horario horario = new Horario("00:00", "");
	}
	
	@Test(expected = NullPointerException.class)
	public void testCriarHorarioDiaNull() {
		String msg = "Avaliacao da excecao lancada ao tentar criar um Horario cujo dia seja um null.";
		Horario horario = new Horario("00:00", null);
	}

}

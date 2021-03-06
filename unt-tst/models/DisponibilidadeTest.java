package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DisponibilidadeTest {
	
	private Disponibilidade disponibilidade;
	
	@Before
	public void criarDisponibilidade() {
		this.disponibilidade = new Disponibilidade();
	}
	
	@Test
	public void testDisponibilidade() {
		String msg = "Avaliacao da criacao adequada do Set de Locais em uma Disponibilidade.";
		assertTrue(msg, this.disponibilidade.totalLocaisCadastrados() == 0);
		
		String msg2 = "Avaliacao da criacao adequada do Set de Horarios em uma Disponibilidade.";
		assertTrue(msg2, this.disponibilidade.totalHorariosCadastrados() == 0);
	}

	@Test
	public void testAdicionarLocal() {
		this.disponibilidade.adicionarLocal("CAA");
		
		String msg = "Avaliacao do armazenamento adequado de um Local na Disponibilidade.";
		assertTrue(msg, this.disponibilidade.totalLocaisCadastrados() == 1);
		
		this.disponibilidade.adicionarLocal("REENGE");
		String msg2 = "Avaliacao do armazenamento adequado de varios Local na Disponibilidade.";
		assertTrue(msg2, this.disponibilidade.totalLocaisCadastrados() == 2);
	}

	@Test
	public void testAdicionarHorario() {
		this.disponibilidade.adicionarHorario("00:00", "Segunda");
		
		String msg = "Avaliacao do armazenamento adequado de um Horario na Disponibilidade.";
		assertTrue(msg, this.disponibilidade.totalHorariosCadastrados() == 1);
		
		this.disponibilidade.adicionarHorario("01:00", "Terca");
		String msg2 = "Avaliacao do armazenamento adequado de varios Horario na Disponibilidade.";
		assertTrue(msg2, this.disponibilidade.totalHorariosCadastrados() == 2);
	}

	@Test
	public void testVerificarHorarioCadastrado() {
		this.disponibilidade.adicionarHorario("00:00", "Segunda");
		
		String msg = "Avaliacao da checagem adequada de um Horario cadastrado na Disponibilidade.";
		assertTrue(msg, this.disponibilidade.verificarHorarioCadastrado("00:00", "Segunda"));
		
		String msg2 = "Avaliacao da checagem adequada de um Horario nao cadastrado na Disponibilidade.";
		assertFalse(msg2, this.disponibilidade.verificarHorarioCadastrado("00:01", "Segunda"));
	}

	@Test
	public void testVerificarLocalCadastrado() {
		this.disponibilidade.adicionarLocal("CAA");
		
		String msg = "Avaliacao da checagem adequada de um Local cadastrado na Disponibilidade.";
		assertTrue(msg, this.disponibilidade.verificarLocalCadastrado("CAA"));
		
		String msg2 = "Avaliacao da checagem adequada de um Local nao cadastrado na Disponibilidade.";
		assertFalse(msg2, this.disponibilidade.verificarLocalCadastrado("CN"));
	}

}

package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TutorTest {
	
	private Tutor tutor;
	
	@Before
	public void criaTutor() {
		this.tutor = new Tutor("Nome 1", "111111111", 1, "9 8534-2004", "tutor.test@ccc.ufcg.edu.br");
		
		this.tutor.adicionarTutoria("P2", 5);
	}

	@Test
	public void testGetDinheiroRecebido() {
		String msg = "Avaliação do armazenamento adequado do dinheiro recebido do tutor em um Tutor.";
		
		assertTrue(msg, this.tutor.getDinheiroRecebido() == 0);
	}
	
	@Test
	public void testConsultaHorario() {
		String msg = "Avaliação da checagem adequada de um Horario cadastrado na Disponibilidade do Tutor.";
		
		this.tutor.cadastrarHorario("10:00", "Segunda");
		
		assertTrue(msg, this.tutor.consultaHorario("10:00", "Segunda"));
		assertFalse(msg, this.tutor.consultaHorario("8:00", "Quinta"));
	}

	@Test
	public void testConsultaLocal() {
		String msg = "Avaliação da checagem adequada de um Local cadastrado na Disponibilidade do Tutor.";
	
		this.tutor.cadastrarLocalDeAtendimento("CAA");
		
		assertTrue(msg, this.tutor.consultaLocal("CAA"));
		assertFalse(msg, this.tutor.consultaLocal("LCC 1"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarTutoriaRepetida() {
		String msg = "Avaliação da exceção lançada ao tentar adicionar uma tutoria já cadastrada.";
		
		this.tutor.adicionarTutoria("P2", 3);
	}
}

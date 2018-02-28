package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TutorTest {
	
	private Tutor tutor;
	
	@Before
	public void criaTutor() {
		this.tutor = new Tutor("Nome 1", "111111111", 1, "0000-0000", "address@gmail.com");
		this.tutor.adicionarTutoria("Programacao 2", 5);
	}

	@Test
	public void testGetDinheiroRecebido() {
		String msg = "Avaliacao do armazenamento adequado do dinheiro recebido do tutor em um Tutor.";
		assertTrue(msg, this.tutor.getDinheiroRecebido() == 0);
	}
	
	@Test
	public void testCadastroHorario() {
		this.tutor.cadastrarHorario("10:00", "Segunda");
		
		String msg = "Avaliacao da checagem adequada de um Horario cadastrado na Disponibilidade do Tutor.";
		assertTrue(msg, this.tutor.consultaHorario("10:00", "Segunda"));
		
		String msg2 = "Avaliacao da checagem adequada de um Horario nao cadastrado na Disponibilidade do Tutor.";
		assertFalse(msg2, this.tutor.consultaHorario("8:00", "Quinta"));
	}

	@Test
	public void testCadastroLocal() {
		this.tutor.cadastrarLocalDeAtendimento("CAA");
		
		String msg = "Avaliacao da checagem adequada de um Local cadastrado na Disponibilidade do Tutor.";
		assertTrue(msg, this.tutor.consultaLocal("CAA"));
		
		String msg2 = "Avaliacao da checagem adequada de um Local nao cadastrado na Disponibilidade do Tutor.";
		assertFalse(msg2, this.tutor.consultaLocal("LCC 1"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarTutoriaRepetida() {
		String msg = "Avaliacao da excecao lancada ao tentar adicionar uma Tutoria ja cadastrada.";
		this.tutor.adicionarTutoria("Programacao 2", 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarTutoriaDisciplinaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar adicionar uma Tutoria com Disciplina vazia.";
		this.tutor.adicionarTutoria("", 3);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionarTutoriaDisciplinaNull() {
		String msg = "Avaliacao da excecao lancada ao tentar adicionar uma Tutoria com Disciplina null.";
		this.tutor.adicionarTutoria(null, 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarTutoriaProficienciaZero() {
		String msg = "Avaliacao da excecao lancada ao tentar adicionar uma Tutoria com Proficiencia zero.";
		this.tutor.adicionarTutoria("Programacao 2", 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarTutoriaProficienciaNegativa() {
		String msg = "Avaliacao da excecao lancada ao tentar adicionar uma Tutoria com Proficiencia negativa.";
		this.tutor.adicionarTutoria("Programacao 2", -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarTutoriaProficienciaMaior() {
		String msg = "Avaliacao da excecao lancada ao tentar adicionar uma Tutoria com Proficiencia maior que 5.";
		this.tutor.adicionarTutoria("Programacao 2", 6);
	}
	
}

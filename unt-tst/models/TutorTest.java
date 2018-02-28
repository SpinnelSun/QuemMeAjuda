package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TutorTest {
	
	private Tutor tutor;
	
	@Before
	public void criaTutor() {
		this.tutor = new Tutor("Nome 1", "111111111", 1, "0000-0000", "address@gmail.com");
		this.tutor.adicionarTutoria("Programação 2", 5);
	}

	@Test
	public void testGetDinheiroRecebido() {
		String msg = "Avaliação do armazenamento adequado do dinheiro recebido do tutor em um Tutor.";
		assertTrue(msg, this.tutor.getDinheiroRecebido() == 0);
	}
	
	@Test
	public void testCadastroHorario() {
		this.tutor.cadastrarHorario("10:00", "Segunda");
		
		String msg = "Avaliação da checagem adequada de um Horario cadastrado na Disponibilidade do Tutor.";
		assertTrue(msg, this.tutor.consultaHorario("10:00", "Segunda"));
		
		String msg2 = "Avaliação da checagem adequada de um Horario não cadastrado na Disponibilidade do Tutor.";
		assertFalse(msg2, this.tutor.consultaHorario("8:00", "Quinta"));
	}

	@Test
	public void testCadastroLocal() {
		this.tutor.cadastrarLocalDeAtendimento("CAA");
		
		String msg = "Avaliação da checagem adequada de um Local cadastrado na Disponibilidade do Tutor.";
		assertTrue(msg, this.tutor.consultaLocal("CAA"));
		
		String msg2 = "Avaliação da checagem adequada de um Local não cadastrado na Disponibilidade do Tutor.";
		assertFalse(msg2, this.tutor.consultaLocal("LCC 1"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarTutoriaRepetida() {
		String msg = "Avaliação da exceção lançada ao tentar adicionar uma Tutoria já cadastrada.";
		this.tutor.adicionarTutoria("Programação 2", 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarTutoriaDisciplinaVazia() {
		String msg = "Avaliação da exceção lançada ao tentar adicionar uma Tutoria com Disciplina vazia.";
		this.tutor.adicionarTutoria("", 3);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionarTutoriaDisciplinaNull() {
		String msg = "Avaliação da exceção lançada ao tentar adicionar uma Tutoria com Disciplina null.";
		this.tutor.adicionarTutoria(null, 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarTutoriaProficienciaZero() {
		String msg = "Avaliação da exceção lançada ao tentar adicionar uma Tutoria com Proficiencia zero.";
		this.tutor.adicionarTutoria("Programação 2", 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarTutoriaProficienciaNegativa() {
		String msg = "Avaliação da exceção lançada ao tentar adicionar uma Tutoria com Proficiencia negativa.";
		this.tutor.adicionarTutoria("Programação 2", -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionarTutoriaProficienciaMaior() {
		String msg = "Avaliação da exceção lançada ao tentar adicionar uma Tutoria com Proficiencia maior que 5.";
		this.tutor.adicionarTutoria("Programação 2", 6);
	}
	
}

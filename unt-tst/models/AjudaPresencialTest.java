package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AjudaPresencialTest {

	private AjudaPresencial ajuda;
	
	@Before
	public void criaAjudaPresencial() {
		this.ajuda = new AjudaPresencial("111111111", "Programacao 2", "15:00", "seg", "LCC3", "999999999");
	}
	
	@Test
	public void testCriaAjudaPresencial() {
		String msg = "Avaliacao do armazenamento adequado da matricula do Aluno em uma AjudaPresencial.";
		assertEquals(msg, "111111111", this.ajuda.getMatriculaAluno());
		
		String msg2 = "Avaliacao do armazenamento adequado da disciplina de uma ajuda em uma AjudaPresencial.";
		assertEquals(msg2, "Programacao 2", this.ajuda.getDisciplina());	
		
		String msg3 = "Avaliacao do estado inicial adequado que define uma Ajuda como avaliada ou nao.";
		assertFalse(msg3, this.ajuda.getAvaliacaoConcluida());
		
		String msg4 = "Avaliacao do armazenamento adequado do horario em uma AjudaPresencial.";
		assertEquals(msg4, "15:00", this.ajuda.getHora());
		
		String msg5 = "Avaliacao do armazenamento adequado do dia em uma AjudaPresencial.";
		assertEquals(msg5, "seg", this.ajuda.getDia());
		
		String msg6 = "Avaliacao do armazenamento adequado do local em uma AjudaPresencial.";
		assertEquals(msg6, "LCC3", this.ajuda.getLocal());
		
		String msg7 = "Avaliacao do armazenamento adequado da matricula do Tutor em uma AjudaPresencial.";
		assertEquals(msg7, "999999999", this.ajuda.getMatriculaTutor());
	}
	
	@Test
	public void testRegistrarAvaliacao() {
		String msg = "Avaliacao do estado adequado de uma AjudaPresencial ainda nao avaliada.";
		assertFalse(msg, this.ajuda.getAvaliacaoConcluida());
		
		this.ajuda.registrarAvaliacao();
		String msg2 = "Avaliacao do estado adequado de uma AjudaPresencial ja avaliada.";
		assertTrue(msg2, this.ajuda.getAvaliacaoConcluida());
	}
	
	@Test
	public void testGetInfo() {
		String msg = "Avaliacao da obtenção do atributo matriculaAluno a partir do getInfo().";
		assertEquals(msg, "111111111", this.ajuda.getInfo("aluno"));
		
		String msg2 = "Avaliacao da obtenção do atributo disciplina a partir do getInfo().";
		assertEquals(msg2, "Programacao 2", this.ajuda.getInfo("disciplina"));
		
		String msg3 = "Avaliacao da obtenção do atributo hora a partir do getInfo().";
		assertEquals(msg3, "15:00", this.ajuda.getInfo("horario"));
		
		String msg4 = "Avaliacao da obtenção do atributo dia a partir do getInfo().";
		assertEquals(msg4, "seg", this.ajuda.getInfo("dia"));
		
		String msg5 = "Avaliacao da obtenção do atributo localInteresse a partir do getInfo().";
		assertEquals(msg5, "LCC3", this.ajuda.getInfo("localInteresse"));
		
		String msg6 = "Avaliacao da obtenção do atributo matriculaTutor a partir do getInfo().";
		assertEquals(msg6, "999999999", this.ajuda.getInfo("tutor"));
	}
	
	@Test
	public void testToString() {
		String msg = "Avaliacao da representacao textual adequada de uma AjudaPresencial.";
		assertEquals(msg, "Tutor - 999999999, horario - 15:00, dia - seg, local - LCC3, disciplina - Programacao 2", this.ajuda.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAtributoVazio() {
		String msg = "Avaliacao da excecao lancada ao utilizar uma String vazia para obter um atributo de uma AjudaPresencial.";
		this.ajuda.getInfo("");
	}

	@Test(expected=NullPointerException.class)
	public void testGetInfoAtributoNulo() {
		String msg = "Avaliacao da excecao lancada ao utilizar um null para obter um atributo de uma AjudaPresencial.";
		
		this.ajuda.getInfo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAjudaPresencialMatriculaAlunoVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaPresencial cuja matricula do Aluno seja uma String vazia.";
		AjudaPresencial ajudaInvalida = new AjudaPresencial("   ", "P2", "00:00", "seg", "CAA", "2");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAjudaPresencialMatriculaAlunoNula() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaPresencial cuja matricula do Aluno seja um null.";
		AjudaPresencial ajudaInvalida = new AjudaPresencial(null, "P2", "00:00", "seg", "CAA", "2");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAjudaPresencialDisciplinaVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaPresencial cuja disciplina seja uma String vazia.";
		AjudaPresencial ajudaInvalida = new AjudaPresencial("1", "   ", "00:00", "seg", "CAA", "2");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAjudaPresencialDisciplinaNula() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaPresencial cuja disciplina seja um null.";
		AjudaPresencial ajudaInvalida = new AjudaPresencial("1", null, "00:00", "seg", "CAA", "2");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAjudaPresencialHoraVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaPresencial cuja hora seja uma String vazia.";
		AjudaPresencial ajudaInvalida = new AjudaPresencial("1", "P2", "", "seg", "CAA", "2");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAjudaPresencialHoraNula() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaPresencial cuja hora seja um null.";
		AjudaPresencial ajudaInvalida = new AjudaPresencial("1", "P2", null, "seg", "CAA", "2");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAjudaPresencialDiaVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaPresencial cujo dia seja uma String vazia.";
		AjudaPresencial ajudaInvalida = new AjudaPresencial("1", "P2", "00:00", "     ", "CAA", "2");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAjudaPresencialDiaNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaPresencial cujo dia seja um null.";
		AjudaPresencial ajudaInvalida = new AjudaPresencial("1", "P2", "00:00", null, "CAA", "2");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAjudaPresencialLocalVazio() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaPresencial cujo local de interesse seja uma String vazia.";
		AjudaPresencial ajudaInvalida = new AjudaPresencial("1", "P2", "00:00", "seg", "  ", "2");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAjudaPresencialLocalNulo() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaPresencial cujo local de interesse seja um null.";
		AjudaPresencial ajudaInvalida = new AjudaPresencial("1", "P2", "00:00", "seg", null, "2");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAjudaPresencialMatriculaTutorNula() {
		String msg = "Avaliacao da excecao lancada ao tentar criar uma AjudaPresencial cuja matricula do Tutor seja um null.";
		AjudaPresencial ajudaInvalida = new AjudaPresencial("1", "P2", "00:00", "seg", "CAA", null);
	}
	
}

package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import controllers.Sistema;

public class SistemaTest {
	Sistema s;
	
	@Before
	public void inicializar() {
		s = new Sistema();
		
		s.cadastrarAluno("Mateus de Lima Oliveira", "118110219", 1, "(83) 99337-5161", "mateuslm@live.com");
		s.cadastrarAluno("Matthew Melio", "115260904", 10000,"", "matthew.met@ccc.ufcg.edu.br");
		
		s.tornarTutor("115260904", "ATAL", 3);
		s.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", "15:30", "Seg");	
		s.cadastrarLocalDeAtendimento("matthew.met@ccc.ufcg.edu.br", "CAA - 104");
	}
	
	@Test
	public void testCadastrarAluno() {
		s.cadastrarAluno("Mateus de Lima Oliveira", "117110219", 001, "(83) 99337-5161", "mateuslm@live.com");
	} 
	
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarAlunoNomeVazio() {
		s.cadastrarAluno("", "117110219", 001, "(83) 99337-5161", "mateuslm@live.com");
	} 
	
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarAlunoEmailVazio() {
		s.cadastrarAluno("Mateus de Lima Oliveira", "117110219", 001, "(83) 99337-5161", "");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarAlunoMatriculaVazio() {
		s.cadastrarAluno("Mateus de Lima Oliveira", "", 001, "(83) 99337-5161", "mateuslm@live.com");
	}
	
	@Test
	public void testCadastrarAlunoTelefoneVazio() {
		s.cadastrarAluno("Mateus de Lima Oliveira", "117110219", 001, "", "mateuslm@live.com");
	} 
	
	@Test
	public void testGetInfoAlunoNome() {
		assertEquals(s.getInfoAluno("118110219", "Nome"), "Mateus de Lima Oliveira");
	} 
	
	@Test
	public void testGetInfoAlunoEmail() {
		assertEquals(s.getInfoAluno("118110219", "Email"), "mateuslm@live.com");
	} 
	
	@Test
	public void testGetInfoAlunoMatricula() {
		assertEquals(s.getInfoAluno("118110219", "Telefone"), "(83) 99337-5161");
	} 
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetInfoAlunoAtributoInvalido() {
		assertEquals(s.getInfoAluno("118110219", "Idade"), "(83) 99337-5161");
	} 
	
	@Test
	public void testRecuperarAluno() {
		assertEquals(s.recuperaAluno("118110219"), "118110219 - Mateus de Lima Oliveira - 1 - (83) 99337-5161 - mateuslm@live.com");
	} 
	
	@Test (expected = IllegalArgumentException.class)
	public void testRecuperarAlunoMatriculaInvalida() {
		assertEquals(s.recuperaAluno("018110219"), "118110219 - Mateus de Lima Oliveira - 1 - (83) 99337-5161 - mateuslm@live.com");
	} 
	
	@Test (expected = IllegalArgumentException.class)
	public void testRecuperarAlunoMatriculaVazia() {
		assertEquals(s.recuperaAluno(""), "118110219 - Mateus de Lima Oliveira - 1 - (83) 99337-5161 - mateuslm@live.com");
	} 
	
	@Test
	public void testListarAlunos() {
		assertEquals(s.listarAlunos(), "118110219 - Mateus de Lima Oliveira - 1 - (83) 99337-5161 - mateuslm@live.com, 115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br");
	}
	
	@Test
	public void testTornarTutor() {
		s.tornarTutor("118110219", "Vetorial", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorMatriculaInvalida() {
		s.tornarTutor("117110219", "Vetorial", 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorProeficienciaInvalida() {
		s.tornarTutor("117110219", "Vetorial", -1);
	}
	
	@Test
	public void testRecuperarTutor() {
		assertEquals(s.recuperaTutor("115260904"), "115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br");
	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperarTutorMatriculaInvalida() {
		assertEquals(s.recuperaTutor("015260904"), "115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br");
	}
	
	@Test
	public void testListarTutores() {
		assertEquals(s.listarTutores(), "115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br");
	}
	
	@Test
	public void testCadastrarHorario() {
		s.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", "15:30", "Seg");		
	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioEmailVazio() {
		s.cadastrarHorario("", "15:30", "Seg");		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioHorarioVazio() {
		s.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", "", "Seg");		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioDiaVazio() {
		s.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", "15:30", "");		
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarHorarioEmailNulo() {
		s.cadastrarHorario(null, "15:30", "Seg");		
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarHorarioHorarioNulo() {
		s.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", null, "Seg");		
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarHorarioDiaNulo() {
		s.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", "15:30", null);		
	}
	
	@Test
	public void testCadastrarLocalDeAtendimento() {
		s.cadastrarLocalDeAtendimento("matthew.met@ccc.ufcg.edu.br", "CAA - 104");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoEmailVazio() {
		s.cadastrarLocalDeAtendimento("", "CAA - 104");		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoLocalVazio() {
		s.cadastrarLocalDeAtendimento("matthew.met@ccc.ufcg.edu.br", "");		
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarLocalDeAtendimentoEmailNulo() {
		s.cadastrarLocalDeAtendimento(null, "CAA - 104");		
	}
	
	@Test(expected = NullPointerException.class)
	public void testCadastrarLocalDeAtendimentoLocalNulo() {
		s.cadastrarLocalDeAtendimento("matthew.met@ccc.ufcg.edu.br", null);		
	}
	
	@Test
	public void testConsultarLocalDeAtendimento() {
		s.consultaLocal("matthew.met@ccc.ufcg.edu.br", "CAA - 104");
	}
	
	@Test (expected = NullPointerException.class)
	public void testConsultarLocalDeAtendimentoEmailNulo() {
		s.consultaLocal(null, "CAA - 104");
	}
	
	@Test (expected = NullPointerException.class)
	public void testConsultarLocalDeAtendimentoLocalNulo() {
		s.consultaLocal("matthew.met@ccc.ufcg.edu.br", null);
	}
	
	@Test
	public void testConsultarHorarioDeAtendimento() {
		s.consultaHorario("matthew.met@ccc.ufcg.edu.br", "15:30", "Seg");
	}
	
	@Test (expected = NullPointerException.class)
	public void testConsultarHorarioDeAtendimentoEmailNulo() {
		s.consultaHorario(null, "15:30", "Seg");
	}
	
	@Test (expected = NullPointerException.class)
	public void testConsultarHorarioDeAtendimentoHorarioNulo() {
		s.consultaHorario("matthew.met@ccc.ufcg.edu.br", null, "Seg");
	}
	
	@Test (expected = NullPointerException.class)
	public void testConsultarHorarioDeAtendimentoDiaNulo() {
		s.consultaHorario("matthew.met@ccc.ufcg.edu.br", "15:30", null);
	}
	
}

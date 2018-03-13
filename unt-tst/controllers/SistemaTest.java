package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import controllers.Sistema;
import general.AlunoException;
import general.TutorException;

public class SistemaTest {
	Sistema sistema;
	
	@Before
	public void criaSistema() {
		this.sistema = new Sistema();
		
		this.sistema.cadastrarAluno("Mateus de Lima Oliveira", "118110219", 1, "(83) 99337-5161", "mateuslm@live.com");
		this.sistema.cadastrarAluno("Matthew Melio", "115260904", 10000,"", "matthew.met@ccc.ufcg.edu.br");
		
		this.sistema.tornarTutor("115260904", "ATAL", 3);
		this.sistema.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", "15:30", "Seg");	
		this.sistema.cadastrarLocalDeAtendimento("matthew.met@ccc.ufcg.edu.br", "CAA - 104");
	}
	
	@Test
	public void testCadastrarAluno() {
		this.sistema.cadastrarAluno("Mateus de Lima Oliveira", "117110219", 001, "(83) 99337-5161", "mateuslm@live.com");
	} 
	
	@Test (expected = AlunoException.class)
	public void testCadastrarAlunoNomeVazio() {
		this.sistema.cadastrarAluno("", "117110219", 001, "(83) 99337-5161", "mateuslm@live.com");
	} 
	
	@Test (expected = AlunoException.class)
	public void testCadastrarAlunoEmailVazio() {
		this.sistema.cadastrarAluno("Mateus de Lima Oliveira", "117110219", 001, "(83) 99337-5161", "");
	}
	
	@Test (expected = AlunoException.class)
	public void testCadastrarAlunoMatriculaVazio() {
		this.sistema.cadastrarAluno("Mateus de Lima Oliveira", "", 001, "(83) 99337-5161", "mateuslm@live.com");
	}
	
	@Test
	public void testCadastrarAlunoTelefoneVazio() {
		this.sistema.cadastrarAluno("Mateus de Lima Oliveira", "117110219", 001, "", "mateuslm@live.com");
	} 
	
	@Test
	public void testGetInfoAlunoNome() {
		assertEquals(this.sistema.getInfoAluno("118110219", "Nome"), "Mateus de Lima Oliveira");
	} 
	
	@Test
	public void testGetInfoAlunoEmail() {
		assertEquals(this.sistema.getInfoAluno("118110219", "Email"), "mateuslm@live.com");
	} 
	
	@Test
	public void testGetInfoAlunoMatricula() {
		assertEquals(this.sistema.getInfoAluno("118110219", "Telefone"), "(83) 99337-5161");
	} 
	
	@Test (expected = AlunoException.class)
	public void testGetInfoAlunoAtributoInvalido() {
		assertEquals(this.sistema.getInfoAluno("118110219", "Idade"), "(83) 99337-5161");
	} 
	
	@Test
	public void testRecuperarAluno() {
		assertEquals(this.sistema.recuperaAluno("118110219"), "118110219 - Mateus de Lima Oliveira - 1 - (83) 99337-5161 - mateuslm@live.com");
	} 
	
	@Test (expected = AlunoException.class)
	public void testRecuperarAlunoMatriculaInvalida() {
		assertEquals(this.sistema.recuperaAluno("018110219"), "118110219 - Mateus de Lima Oliveira - 1 - (83) 99337-5161 - mateuslm@live.com");
	} 
	
	@Test (expected = AlunoException.class)
	public void testRecuperarAlunoMatriculaVazia() {
		assertEquals(this.sistema.recuperaAluno(""), "118110219 - Mateus de Lima Oliveira - 1 - (83) 99337-5161 - mateuslm@live.com");
	} 
	
	@Test
	public void testListarAlunos() {
		assertEquals(this.sistema.listarAlunos(), "118110219 - Mateus de Lima Oliveira - 1 - (83) 99337-5161 - mateuslm@live.com, 115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br");
	}
	
	@Test
	public void testTornarTutor() {
		this.sistema.tornarTutor("118110219", "Vetorial", 1);
	}
	
	@Test(expected = TutorException.class)
	public void testTornarTutorMatriculaInvalida() {
		this.sistema.tornarTutor("117110219", "Vetorial", 1);
	}
	
	@Test(expected = TutorException.class)
	public void testTornarTutorProeficienciaInvalida() {
		this.sistema.tornarTutor("117110219", "Vetorial", -1);
	}
	
	@Test
	public void testRecuperarTutor() {
		assertEquals(this.sistema.recuperaTutor("115260904"), "115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br");
	} 
	
	@Test(expected = TutorException.class)
	public void testRecuperarTutorMatriculaInvalida() {
		assertEquals(this.sistema.recuperaTutor("015260904"), "115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br");
	}
	
	@Test
	public void testListarTutores() {
		assertEquals(this.sistema.listarTutores(), "115260904 - Matthew Melio - 10000 - matthew.met@ccc.ufcg.edu.br");
	}
	
	@Test
	public void testCadastrarHorario() {
		this.sistema.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", "15:30", "Seg");		
	} 
	
	@Test(expected = TutorException.class)
	public void testCadastrarHorarioEmailVazio() {
		this.sistema.cadastrarHorario("", "15:30", "Seg");		
	}
	
	@Test(expected = TutorException.class)
	public void testCadastrarHorarioHorarioVazio() {
		this.sistema.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", "", "Seg");		
	}
	
	@Test(expected = TutorException.class)
	public void testCadastrarHorarioDiaVazio() {
		this.sistema.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", "15:30", "");		
	}
	
	@Test(expected = TutorException.class)
	public void testCadastrarHorarioEmailNulo() {
		this.sistema.cadastrarHorario(null, "15:30", "Seg");		
	}
	
	@Test(expected = TutorException.class)
	public void testCadastrarHorarioHorarioNulo() {
		this.sistema.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", null, "Seg");		
	}
	
	@Test(expected = TutorException.class)
	public void testCadastrarHorarioDiaNulo() {
		this.sistema.cadastrarHorario("matthew.met@ccc.ufcg.edu.br", "15:30", null);		
	}
	
	@Test
	public void testCadastrarLocalDeAtendimento() {
		this.sistema.cadastrarLocalDeAtendimento("matthew.met@ccc.ufcg.edu.br", "CAA - 104");
	}
	
	@Test(expected = TutorException.class)
	public void testCadastrarLocalDeAtendimentoEmailVazio() {
		this.sistema.cadastrarLocalDeAtendimento("", "CAA - 104");		
	}
	
	@Test(expected = TutorException.class)
	public void testCadastrarLocalDeAtendimentoLocalVazio() {
		this.sistema.cadastrarLocalDeAtendimento("matthew.met@ccc.ufcg.edu.br", "");		
	}
	
	@Test(expected = TutorException.class)
	public void testCadastrarLocalDeAtendimentoEmailNulo() {
		this.sistema.cadastrarLocalDeAtendimento(null, "CAA - 104");		
	}
	
	@Test(expected = TutorException.class)
	public void testCadastrarLocalDeAtendimentoLocalNulo() {
		this.sistema.cadastrarLocalDeAtendimento("matthew.met@ccc.ufcg.edu.br", null);		
	}
	
	@Test
	public void testConsultarLocalDeAtendimento() {
		this.sistema.consultaLocal("matthew.met@ccc.ufcg.edu.br", "CAA - 104");
	}
	
	@Test (expected = NullPointerException.class)
	public void testConsultarLocalDeAtendimentoEmailNulo() {
		this.sistema.consultaLocal(null, "CAA - 104");
	}
	
	@Test (expected = NullPointerException.class)
	public void testConsultarLocalDeAtendimentoLocalNulo() {
		this.sistema.consultaLocal("matthew.met@ccc.ufcg.edu.br", null);
	}
	
	@Test
	public void testConsultarHorarioDeAtendimento() {
		this.sistema.consultaHorario("matthew.met@ccc.ufcg.edu.br", "15:30", "Seg");
	}
	
	@Test (expected = NullPointerException.class)
	public void testConsultarHorarioDeAtendimentoEmailNulo() {
		this.sistema.consultaHorario(null, "15:30", "Seg");
	}
	
	@Test (expected = NullPointerException.class)
	public void testConsultarHorarioDeAtendimentoHorarioNulo() {
		this.sistema.consultaHorario("matthew.met@ccc.ufcg.edu.br", null, "Seg");
	}
	
	@Test (expected = NullPointerException.class)
	public void testConsultarHorarioDeAtendimentoDiaNulo() {
		this.sistema.consultaHorario("matthew.met@ccc.ufcg.edu.br", "15:30", null);
	}
	
	@Test 
	public void testPedirAjudaPresencial() {
		this.sistema.pedirAjudaPresencial("115260904", "ATAL", "15:30", "Seg", "CAA");
	}
	
}

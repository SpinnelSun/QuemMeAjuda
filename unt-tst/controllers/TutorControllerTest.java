package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TutorControllerTest {
	TutorController tutorController;
	
	@Before
	public void inicializar() {
		tutorController = new TutorController();
		tutorController.criarNovoTutor("111111111", "Otavio Rocha Alvez", "2", "(00) 00000-0000", "otavio@gmail.com");
		tutorController.cadastrarHorario("otavio@gmail.com", "15:30", "Seg");
		tutorController.cadastrarLocalDeAtendimento("otavio@gmail.com", "CAA");
	}
	
	@Test
	public void criarNovoTutorTest() {
		tutorController.criarNovoTutor("000000000", "Otavio Rocha Alvez", "2", "(00) 00000-0000", "otavio@gmail.com");
	}
	
	@Test
	public void criarNovoTutorNumeroVazioTest() {
		tutorController.criarNovoTutor("000000000", "Otavio Rocha Alvez", "2", "", "otavio@gmail.com");
	}
	
	@Test
	public void tornarTutorTest() {
		tutorController.tornarTutor("111111111", "ATAl", 4);
	}
	
	@Test(expected = NullPointerException.class)
	public void tornarTutorMatriculaInvalidaTest() {
		tutorController.tornarTutor("000000000", "ATAl", 4);
	}
	
	@Test(expected = NullPointerException.class)
	public void tornarTutorMatriculaVaziaTest() {
		tutorController.tornarTutor("", "ATAl", 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tornarTutorProficienciaNegativaTest() {
		tutorController.tornarTutor("111111111", "ATAl", -4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tornarTutorProficienciaZeroTest() {
		tutorController.tornarTutor("111111111", "ATAl", -4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tornarTutorDisciplinaVaziaTest() {
		tutorController.tornarTutor("111111111", "", 4);
	}
	
	@Test(expected = NullPointerException.class)
	public void tornarTutorDisciplinaNulaTest() {
		tutorController.tornarTutor("111111111", null, 4);
	}
	
	@Test
	public void recuperaTutorTest() {
		assertEquals("111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com",tutorController.recuperaTutor("111111111"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void recuperaTutorMatriculaInvalidaTest() {
		assertEquals("111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com",tutorController.recuperaTutor("110111111"));
	}
	
	@Test
	public void listarTutoresTest() {
		assertEquals("111111111 - Otavio Rocha Alvez - 2 - (00) 00000-0000 - otavio@gmail.com",tutorController.listarTutores());
	}
	
	@Test
	public void cadastrarHorarioTest() {
		tutorController.cadastrarHorario("otavio@gmail.com", "15:30", "Seg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarHorarioEmailInvalidoTest() {
		tutorController.cadastrarHorario("oavio@gmail.com", "15:30", "Seg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarHorarioEmailVazioTest() {
		tutorController.cadastrarHorario("", "15:30", "Seg");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarHorarioEmailNuloTest() {
		tutorController.cadastrarHorario(null, "15:30", "Seg");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cadastrarHorarioHoraVaziaTest() {
		tutorController.cadastrarHorario("otavio@gmail.com", "", "Seg");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarHorarioHoraNulaTest() {
		tutorController.cadastrarHorario("otavio@gmail.com", null, "Seg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarHorarioDiaVazioTest() {
		tutorController.cadastrarHorario("otavio@gmail.com", "15:30", "");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarHorarioDianuloTest() {
		tutorController.cadastrarHorario("otavio@gmail.com", "15:30", null);
	}

	@Test
	public void cadastrarLocalDeAtendimentoTest() {
		tutorController.cadastrarLocalDeAtendimento("otavio@gmail.com", "CAA");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarLocalDeAtendimentoEmailInvalidoTest() {
		tutorController.cadastrarLocalDeAtendimento("oavio@gmail.com", "CAA");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarLocalDeAtendimentoEmailVazioTest() {
		tutorController.cadastrarLocalDeAtendimento("", "CAA");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarLocalDeAtendimentoEmailNuloTest() {
		tutorController.cadastrarLocalDeAtendimento(null, "CAA");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarLocalDeAtendimentoLocalVazioTest() {
		tutorController.cadastrarLocalDeAtendimento("otavio@gmail.com", "");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastrarLocalDeAtendimentoLocalNuloTest() {
		tutorController.cadastrarLocalDeAtendimento("otavio@gmail.com", null);
	}
	
	@Test
	public void consultaHorarioTest() {
		assertTrue(tutorController.consultaHorario("otavio@gmail.com", "15:30", "Seg") == true);
	}
	
	@Test
	public void consultaHorarioNaoDisponivelTest() {
		assertFalse(tutorController.consultaHorario("otavio@gmail.com", "15:31", "Seg") == true);
	}
	
	@Test
	public void consultaHorarioDiaNaoDisponivelTest() {
		assertFalse(tutorController.consultaHorario("otavio@gmail.com", "15:30", "Qua") == true);
	}
	
	@Test
	public void consultaLocalTest() {
		assertTrue(tutorController.consultaLocal("otavio@gmail.com", "CAA") == true);
	}
	
	@Test
	public void consultaLocalErradoTest() {
		assertFalse(tutorController.consultaLocal("otavio@gmail.com", "CA") == true);
	}
	
}

package utility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import controllers.Sistema;

public class SistemaTest {
	Sistema s;
	
	@Before
	public void inicializar() {
		s = new Sistema();
		s.cadastrarAluno("Mateus de Lima Oliveira", "118110219", 001, "(83) 99337-5161", "mateuslm@live.com");
	}
	
	@Test
	public void testCadastrarAluno() {
		s.cadastrarAluno("Mateus de Lima Oliveira", "117110219", 001, "(83) 99337-5161", "mateuslm@live.com");
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
	
	@Test
	public void testCadastrarHorario() {
		
	} 

}

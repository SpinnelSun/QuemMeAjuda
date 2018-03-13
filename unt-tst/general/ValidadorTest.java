package general;

import static org.junit.Assert.*;

import org.junit.Test;

import utility.Validador;

public class ValidadorTest {

	@Test(expected = IllegalArgumentException.class)
	public void testValidarStringNaoVaziaComVazia() {
		String msg = "Avaliacao da excecao lancada ao tentar validar uma String vazia nesse metodo.";
		Validador.validarStringNaoVazia("Excecao lancada!", "");
	}

	@Test(expected = NullPointerException.class)
	public void testValidarStringNaoNulaComNull() {
		String msg = "Avaliacao da excecao lancada ao tentar validar um null nesse metodo.";
		Validador.validarStringNaoNula("Excecao lancada!", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarEmailSemArroba() {
		String msg = "Avaliacao da excecao lancada ao tentar validar um email sem o @.";
		Validador.validarEmail("Excecao lancada!", "adress.email.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidarEmailIniciadoEmArroba() {
		String msg = "Avaliacao da excecao lancada ao tentar validar um email iniciado por @ nesse metodo.";
		Validador.validarEmail("Excecao lancada!", "@adress.email.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidarEmailTerminadoEmArroba() {
		String msg = "Avaliacao da excecao lancada ao tentar validar um email terminado com @ nesse metodo.";
		Validador.validarEmail("Excecao lancada!", "adress.email.com@");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarInteiroPositivoComNegativo() {
		String msg = "Avaliacao da excecao lancada ao tentar validar um inteiro negativo nesse metodo.";
		Validador.validarInteiroPositivo("Excecao lancada!", -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidarInteiroPositivoComZero() {
		String msg = "Avaliacao da excecao lancada ao tentar validar um zero nesse metodo.";
		Validador.validarInteiroPositivo("Excecao lancada!", 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarIntUmACincoComZero() {
		String msg = "Avaliacao da excecao lancada ao tentar validar um zero nesse metodo.";
		Validador.validarIntUmACinco("Excecao lancada!", 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidarIntUmACincoComMaior() {
		String msg = "Avaliacao da excecao lancada ao tentar validar um número maior que 5 nesse metodo.";
		Validador.validarIntUmACinco("Excecao lancada!", 6);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidarIntUmACincoComNegativo() {
		String msg = "Avaliacao da excecao lancada ao tentar validar um número negativo nesse metodo.";
		Validador.validarIntUmACinco("Excecao lancada!", -1);
	}

}

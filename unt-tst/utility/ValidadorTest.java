package utility;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidadorTest {

	@Test(expected = IllegalArgumentException.class)
	public void testValidarStringNaoVaziaComVazia() {
		String msg = "Avaliação da exceção lançada ao tentar validar uma String vazia nesse método.";
		Validador.validarStringNaoVazia("Exceção lançada!", "");
	}

	@Test(expected = NullPointerException.class)
	public void testValidarStringNaoNulaComNull() {
		String msg = "Avaliação da exceção lançada ao tentar validar um null nesse método.";
		Validador.validarStringNaoNula("Exceção lançada!", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarEmailSemArroba() {
		String msg = "Avaliação da exceção lançada ao tentar validar um email sem o @.";
		Validador.validarEmail("Exceção lançada!", "adress.gmail.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidarEmailIniciadoEmArroba() {
		String msg = "Avaliação da exceção lançada ao tentar validar um email iniciado por @ nesse método.";
		Validador.validarEmail("Exceção lançada!", "@adress.gmail.com");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidarEmailTerminadoEmArroba() {
		String msg = "Avaliação da exceção lançada ao tentar validar um email terminado com @ nesse método.";
		Validador.validarEmail("Exceção lançada!", "adress.gmail.com@");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarInteiroPositivoComNegativo() {
		String msg = "Avaliação da exceção lançada ao tentar validar um inteiro negativo nesse método.";
		Validador.validarInteiroPositivo("Exceção lançada!", -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidarInteiroPositivoComZero() {
		String msg = "Avaliação da exceção lançada ao tentar validar um zero nesse método.";
		Validador.validarInteiroPositivo("Exceção lançada!", 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidarIntUmACincoComZero() {
		String msg = "Avaliação da exceção lançada ao tentar validar um zero nesse método.";
		Validador.validarIntUmACinco("Exceção lançada!", 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidarIntUmACincoComMaior() {
		String msg = "Avaliação da exceção lançada ao tentar validar um número maior que 5 nesse método.";
		Validador.validarIntUmACinco("Exceção lançada!", 6);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidarIntUmACincoComNegativo() {
		String msg = "Avaliação da exceção lançada ao tentar validar um número negativo nesse método.";
		Validador.validarIntUmACinco("Exceção lançada!", -1);
	}

}

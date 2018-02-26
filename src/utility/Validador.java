package utility;

public class Validador {
	
	public static void validarStringNaoVazia(String msg, String str) {
		if (str.trim().equals("")) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	public static void validarStringNaoNula(String msg, String str) {
		if (str == null) {
			throw new NullPointerException(msg); 
		}
	}
	
	public static void validarStringNaoVaziaNaoNula(String msg, String str) {
		Validador.validarStringNaoVazia(msg, str);
		Validador.validarStringNaoNula(msg, str);
	}
	
	public static void validarPositiveInteger(String msg, int value) {
		if (value < 1) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	public static void validarNotNegativeInteger(String msg, int value) {
		if (value < 0) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	public static void validarNotNegativeDouble(String msg, double value) {
		if (value < 0) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	public static void validarLessEqualThan(String msg, int value1, int value2) {
		if (value1 > value2) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	public static void validarPercentage(String msg, double value) {
		if ((value < 0) || (value > 1)) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
}

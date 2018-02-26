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
	
	public static void validarEmail(String msg, String email) {
		Validador.validarStringNaoVaziaNaoNula(msg, email);
		
		if (!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
				throw new IllegalArgumentException(msg);
		}
	}	
	
	public static void validarInteiroPositivo(String msg, int valor) {
		if (valor < 1) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	public static void validarIntUmACinco(String msg, int valor) {
		if (valor < 1 || valor > 5) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
}

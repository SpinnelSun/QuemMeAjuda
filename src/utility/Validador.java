package utility;

/**
 * Representacao de um validador de informacoes, no qual estao armazenados os metodos para evitar a
 * utilizacao de informacoes invalidas. Essa classe visa evitar a repeticao de codigo necessario em
 * validacoes idênticas ou semelhantes.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Matheus Alves dos Santos - 117110503
 * @author Misael Augusto Silva da Costa - 117110525
 *
 */
public class Validador {
	
	/**
	 * Avalia se uma String e nao-vazia. Lancara uma excecao adequada caso nao o seja.
	 * 
	 * @param msg A mensagem a ser associada a excecao lancada.
	 * @param str A string a ser validada como nao-vazia.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarStringNaoVazia(String msg, String str) {
		if (str.trim().equals("")) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	/**
	 * Avalia se uma String e nao-nula. Lancara uma excecao adequada caso nao o seja.
	 * 
	 * @param msg A mensagem a ser associada a excecao lancada.
	 * @param str A string a ser validada como nao-nula.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarStringNaoNula(String msg, String str) {
		if (str == null) {
			throw new NullPointerException(msg); 
		}
	}
	
	/**
	 * Avalia se uma String e nao-vazia e nao-nula. Lancara uma excecao adequada caso nao o seja.
	 * 
	 * @param msg A mensagem a ser associada a excecao lancada.
	 * @param str A string a ser validada como nao-vazia e nao-nula.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarStringNaoVaziaNaoNula(String msg, String str) {
		Validador.validarStringNaoVazia(msg, str);
		Validador.validarStringNaoNula(msg, str);
	}
	
	/**
	 * Avalia se um e-mail informado segue os padroes esperados de um endereco de email. Sera lan-
	 * cada uma excecao adequada caso o padrao nao seja seguido.
	 * 
	 * @param msg A mensagem a ser associada a excecao lancada.
	 * @param str O email a ser validado nos padroes.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarEmail(String msg, String email) {
		Validador.validarStringNaoVaziaNaoNula(msg, email);
		
		if (!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
				throw new IllegalArgumentException(msg);
		}
	}	
	
	/**
	 * Avalia se um número inteiro e positivo. Lancara uma excecao adequada caso nao o seja.
	 * 
	 * @param msg A mensagem a ser associada a excecao lancada.
	 * @param value O inteiro a ser validado como positivo.
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarInteiroPositivo(String msg, int valor) {
		if (valor < 1) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
	/**
	 * Avalia se um número inteiro esta no intervalo [1, 5]. Lancara uma excecao adequada caso o in-
	 * teiro nao esteja nesse intervalo.
	 * 
	 * @param msg A mensagem a ser associada a excecao lancada.
	 * @param value O inteiro a ser validado no intervalo [1, 5].
	 * 
	 * @returns null.
	 * 
	 */
	public static void validarIntUmACinco(String msg, int valor) {
		if (valor < 1 || valor > 5) {
			throw new IllegalArgumentException(msg); 
		}
	}
	
}
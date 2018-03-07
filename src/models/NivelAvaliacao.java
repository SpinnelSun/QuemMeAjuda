package models;

/**
 * Enumeracao dos niveis pelos quais um Tutor pode ser classificado a partir de sua nota de avalia-
 * cao. Cada valor de NivelAvaliacao e definido a partir de uma String que o especifique.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Misael Augusto Silva da Costa - 117110525
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public enum NivelAvaliacao {
	
	ALTO("TOP") ,
	
	MEDIO("Tutor") ,
	
	BAIXO("Aprendiz") ;
	
	private String nivel;
	
	/**
	 * Constroi um valor de NivelAvaliacao a partir de uma String que o especifique.
	 * 
	 * @param estado A String que especifica o valor de NivelAvaliacao.
	 * 
	 */
	NivelAvaliacao(String nivel) {
		this.nivel = nivel;
	}
	
	/**
	 * Retorna a String que define o valor de NivelAvaliacao.
	 * 
	 * @returns A representacao textual de um valor de NivelAvaliacao.
	 * 
	 */
	@Override
	public String toString() {
		return this.nivel;
	}

}
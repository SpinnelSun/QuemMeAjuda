package models;

import views.SeletorInfoAjuda;

/**
 * Enumeracao das informacoes possuidas por uma Ajuda. Cada valor de InfoAjuda e definido a partir
 * de uma String que representa seu nome.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Misael Augusto Silva da Costa - 117110525
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public enum InfoAjuda implements SeletorInfoAjuda {
	
	DISCIPLINA("DISCIPLINA") {
		@Override
		public String getInfo(Ajuda ajuda) {
			return ajuda.getDisciplina();
		}		
	},
	
	ALUNO("ALUNO") {
		@Override
		public String getInfo(Ajuda ajuda) {
			return ajuda.getMatriculaAluno();
		}	
	},
	
	TUTOR("TUTOR") {
		@Override
		public String getInfo(Ajuda ajuda) {
			return ajuda.getMatriculaTutor();
		}
	};
	
	private String nomeInfo;
	
	/**
	 * Constroi um valor de InfoAjuda a partir de uma String que o defina.
	 * 
	 * @param estado A String que nomeia o valor de InfoAjuda.
	 * 
	 */
	InfoAjuda(String nomeInfo) {
		this.nomeInfo = nomeInfo;
	}
	
	/**
	 * Verifica se a String passada como parametro desse metodo especifica algum dos valores de
	 * InfoAjuda. Caso nao o faca, esse metodo lancara a excecao adequada.
	 * 
	 * @returns null.
	 * 
	 */
	public static void impedirAtributoInexistente(String atributo) {
		for (InfoAjuda infoAjuda : InfoAjuda.values()) {
			if (infoAjuda.toString().equals(atributo)) {
				return;
			}
		}
		
		throw new IllegalArgumentException("atributo nao encontrado");
	}
	
	/**
	 * Retorna a String que define o valor de InfoAjuda.
	 * 
	 * @returns A representacao textual de um valor de InfoAjuda.
	 * 
	 */
	@Override
	public String toString() {
		return this.nomeInfo;
	}

}

package models;

import views.SeletorInfoAjudaPresencial;

/**
 * Enumeracao das informacoes possuidas por uma AjudaPresencial. Cada valor de InfoAjudaPresencial e
 * definido a partir de uma String que representa seu nome.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Misael Augusto Silva da Costa - 117110525
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public enum InfoAjudaPresencial implements SeletorInfoAjudaPresencial {
	
	DISCIPLINA("DISCIPLINA") {
		@Override
		public String getInfo(AjudaPresencial ajuda) {
			return InfoAjuda.DISCIPLINA.getInfo(ajuda);
		}		
	},
	
	ALUNO("ALUNO") {
		@Override
		public String getInfo(AjudaPresencial ajuda) {
			return InfoAjuda.ALUNO.getInfo(ajuda);
		}	
	},
	
	TUTOR("TUTOR") {
		@Override
		public String getInfo(AjudaPresencial ajuda) {
			return InfoAjuda.TUTOR.getInfo(ajuda);
		}
	},
	
	HORARIO("HORARIO") {
		@Override
		public String getInfo(AjudaPresencial ajuda) {
			return ajuda.getHora();
		}
	},
	
	DIA("DIA") {
		@Override
		public String getInfo(AjudaPresencial ajuda) {
			return ajuda.getDia();
		}
	},
	
	LOCALINTERESSE("LOCALINTERESSE") {
		@Override
		public String getInfo(AjudaPresencial ajuda) {
			return ajuda.getLocal();
		}
	};
	
	private String nomeInfo;
	
	/**
	 * Constroi um valor de InfoAjudaPresencial a partir de uma String que o defina.
	 * 
	 * @param estado A String que nomeia o valor de InfoAjudaPresencial.
	 * 
	 */
	InfoAjudaPresencial(String nomeInfo) {
		this.nomeInfo = nomeInfo;
	}
	
	/**
	 * Verifica se a String passada como parametro desse metodo especifica algum dos valores de
	 * InfoAjudaPresencial. Caso nao o faca, esse metodo lancara a excecao adequada.
	 * 
	 * @returns null.
	 * 
	 */
	public static void impedirAtributoInexistente(String atributo) {
		for (InfoAjudaPresencial infoAjuda : InfoAjudaPresencial.values()) {
			if (infoAjuda.toString().equals(atributo)) {
				return;
			}
		}
		
		throw new IllegalArgumentException("atributo nao encontrado");
	}
	
	/**
	 * Retorna a String que define o valor de InfoAjudaPresencial.
	 * 
	 * @returns A representacao textual de um valor de InfoAjudaPresencial.
	 * 
	 */
	@Override
	public String toString() {
		return this.nomeInfo;
	}

}

package models;

import views.AtributoStrategy;

/**
 * Enumeracao dos atributos possuidos por um Aluno. Cada Atributo e definido a partir de uma String
 * que representa seu nome.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Misael Augusto Silva da Costa - 117110525
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public enum AtributoAluno implements AtributoStrategy {
	
	NOME("Nome") {
		@Override
		public String getAtributo(Aluno aluno) {
			return aluno.getNome();
		}		
	},
	
	TELEFONE("Telefone") {
		@Override
		public String getAtributo(Aluno aluno) {
			return aluno.getTelefone();
		}	
	},
	
	EMAIL("Email") {
		@Override
		public String getAtributo(Aluno aluno) {
			return aluno.getEmail();
		}
	},
	
	MATRICULA("Matricula") {
		@Override
		public String getAtributo(Aluno aluno) {
			return aluno.getMatricula();
		}
	},
	
	CURSO("Codigo do Curso") {
		@Override
		public String getAtributo(Aluno aluno) {
			return Integer.toString(aluno.getCodigoCurso());
		}
	},
	
	NOTA("Nota") {
		@Override
		public String getAtributo(Aluno aluno) {
			return Double.toString(aluno.getNota());
		}
	};
	
	private String atributo;
	
	/**
	 * Constroi um Atributo a partir de uma String que o defina.
	 * 
	 * @param estado A String que nomeia o Atributo.
	 * 
	 */
	AtributoAluno(String atributo) {
		this.atributo = atributo;
	}
	
	/**
	 * Retorna a String que define o Atributo.
	 * 
	 * @returns A representacao textual de um Atributo.
	 * 
	 */
	@Override
	public String toString() {
		return this.atributo;
	}

}

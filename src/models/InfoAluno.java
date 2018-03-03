package models;

import views.InfoAlunoStrategy;

/**
 * Enumeracao das informacoes possuidas por um Aluno. Cada valor de InfoAluno e definido a partir
 * de uma String que representa seu nome.
 * 
 * Laboratorio de Programacao 2 - Projeto de Laboratorio - Quem Me Ajuda
 * 
 * @author Mateus de Lima Oliveira  - 117110219
 * @author Misael Augusto Silva da Costa - 117110525
 * @author Matheus Alves dos Santos - 117110503
 *
 */
public enum InfoAluno implements InfoAlunoStrategy {
	
	NOME("NOME") {
		@Override
		public String getInfo(Aluno aluno) {
			return aluno.getNome();
		}		
	},
	
	TELEFONE("TELEFONE") {
		@Override
		public String getInfo(Aluno aluno) {
			return aluno.getTelefone();
		}	
	},
	
	EMAIL("EMAIL") {
		@Override
		public String getInfo(Aluno aluno) {
			return aluno.getEmail();
		}
	},
	
	MATRICULA("MATRICULA") {
		@Override
		public String getInfo(Aluno aluno) {
			return aluno.getMatricula();
		}
	},
	
	CURSO("CODIGO DO CURSO") {
		@Override
		public String getInfo(Aluno aluno) {
			return Integer.toString(aluno.getCodigoCurso());
		}
	},
	
	NOTA("NOTA") {
		@Override
		public String getInfo(Aluno aluno) {
			return Double.toString(aluno.getNota());
		}
	};
	
	private String informacao;
	
	/**
	 * Constroi um valor de InfoAluno a partir de uma String que o defina.
	 * 
	 * @param estado A String que nomeia o valor de InfoAluno.
	 * 
	 */
	InfoAluno(String nomeInfo) {
		this.informacao = nomeInfo;
	}
	
	/**
	 * Retorna a String que define o valor de InfoAluno.
	 * 
	 * @returns A representacao textual de um valor de InfoAluno.
	 * 
	 */
	@Override
	public String toString() {
		return this.informacao;
	}

}

package models;

import views.AtributoStrategy;

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
	
	AtributoAluno(String atributo) {
		this.atributo = atributo;
	}
	
	@Override
	public String toString() {
		return this.atributo;
	}

}

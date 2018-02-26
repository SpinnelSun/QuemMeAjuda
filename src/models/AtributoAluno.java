package models;

import view.AtributoStrategy;

public enum AtributoAluno implements AtributoStrategy {
	
	NOME("Nome") {
		@Override
		public String getAtributo(Aluno aluno) {
			return aluno.getNome();
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
			return aluno.getCodigoCurso();
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

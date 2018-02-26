package models;

import view.AtributoStrategy;

public enum AtributoAluno implements AtributoStrategy {
	
	Nome("Nome") {
		@Override
		public String getAtributo(Aluno aluno) {
			return aluno.getNome();
		}		
	},
	
	Matricula("Matricula") {
		@Override
		public String getAtributo(Aluno aluno) {
			return aluno.getMatricula();
		}
	},
	
	Curso("Codigo do Curso") {
		@Override
		public String getAtributo(Aluno aluno) {
			return aluno.getCodigoCurso();
		}
	},
	
	Telefone("Telefone") {
		@Override
		public String getAtributo(Aluno aluno) {
			return aluno.getTelefone();
		}	
	},
	
	Email("Email") {
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

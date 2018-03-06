package models;

import views.SeletorInfoAjuda;

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
	
	InfoAjuda(String nomeInfo) {
		this.nomeInfo = nomeInfo;
	}
	
	@Override
	public String toString() {
		return this.nomeInfo;
	}

}

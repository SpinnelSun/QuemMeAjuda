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
	
	public static void impedirAtributoInexistente(String atributo) {
		for (InfoAjuda infoAjuda : InfoAjuda.values()) {
			if (infoAjuda.toString().equals(atributo)) {
				return;
			}
		}
		
		throw new IllegalArgumentException("atributo nao encontrado");
	}
	
	@Override
	public String toString() {
		return this.nomeInfo;
	}

}

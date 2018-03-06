package models;

import views.SeletorInfoAjudaPresencial;

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
	
	InfoAjudaPresencial(String nomeInfo) {
		this.nomeInfo = nomeInfo;
	}
	
	@Override
	public String toString() {
		return this.nomeInfo;
	}

}

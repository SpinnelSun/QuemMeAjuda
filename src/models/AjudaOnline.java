package models;

public class AjudaOnline extends Ajuda {
	
	public AjudaOnline(String matrAluno, String descricao) {
		super(matrAluno, descricao);
	}

	@Override
	public String toString() {
		return super.toString() + ", disciplina" +
				this.getDisciplina();
	}
	
	

}

package models;

public class AjudaOnline extends Ajuda {
	
	public AjudaOnline(String matriculaAluno, String disciplina, String matriculaTutor) {
		super(matriculaAluno, disciplina, matriculaTutor);
	}

	@Override
	public String toString() {
		return "Tutor - " + this.getMatriculaTutor() + ", disciplina - " + this.getDisciplina();
	}
	
}

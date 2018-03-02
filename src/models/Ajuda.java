package models;

public abstract class Ajuda {
	
	private String disciplina;
	private String matriculaAluno;
	private String matriculaTutor; 
	
	public Ajuda(String matriculaAluno, String disciplina) {
		this.disciplina = disciplina;
		this.matriculaAluno = matriculaAluno;
		this.matriculaTutor = "";
	}
	
	public String getMatriculaTutor() {
		return matriculaTutor;
	}
	
	public void setMatriculaTutor(String matriculaTutor) {
		this.matriculaTutor = matriculaTutor;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	@Override
	public String toString() {
		return "Tutor - " + this.getMatriculaTutor() ;
	}
	
}

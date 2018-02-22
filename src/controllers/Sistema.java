package controllers;

public class Sistema {
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		return;
	}
	
	public String recuperaAluno(String matricula) {
		return "";
	}
	
	public String listarAlunos() {
		return "";
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return "";
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		return;
	}
	
	public String recuperaTutor(String matricula) {
		return "";
	}
	
	public String listarTutores() {
		return "";
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		return;
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		return;
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return true;
	}
	
	public boolean consultaLocal(String email, String local) {
		return true;
	}

}

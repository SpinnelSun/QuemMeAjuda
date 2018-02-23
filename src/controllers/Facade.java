package controllers;

import easyaccept.EasyAccept;

public class Facade {
	
	private Sistema sistema;
	
	public static void main(String[] args) {
		args = new String[] {"controllers.Facade", "acc-tst/us1_test.txt", "acc-tst/us2_test.txt"};
		
		EasyAccept.main(args);
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String email) {
		this.sistema.cadastrarAluno(nome, matricula, codigoCurso, email);
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String recuperaAluno(String matricula) {
		return this.sistema.recuperaAluno(matricula);
	}
	
	public String listarAlunos() {
		return this.sistema.listarAlunos();
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return this.sistema.getInfoAluno(matricula, atributo);
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.sistema.tornarTutor(matricula, disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) {
		return this.sistema.recuperaTutor(matricula);
	}
	
	public String listarTutores() {
		return this.sistema.listarTutores();
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		this.cadastrarHorario(email, horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.cadastrarLocalDeAtendimento(email, local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return this.sistema.consultaHorario(email, horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return this.sistema.consultaLocal(email, local);
	}
}

package controllers;

import easyaccept.EasyAccept;

public class Facade {
	
	private static Sistema sistema;
	
	public static void main(String[] args) {
		inicializar();
		
		args = new String[] {"controllers.Facade", "acc-tst/us1_test.txt", "acc-tst/us2_test.txt",
							 "acc-tst/us3_test.txt"};
		
		EasyAccept.main(args);
	}
	
	public static void inicializar() {
		Facade.sistema = new Sistema();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		Facade.sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String recuperaAluno(String matricula) {
		return Facade.sistema.recuperaAluno(matricula);
	}
	
	public String listarAlunos() {
		return Facade.sistema.listarAlunos();
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return Facade.sistema.getInfoAluno(matricula, atributo);
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		Facade.sistema.tornarTutor(matricula, disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) {
		return Facade.sistema.recuperaTutor(matricula);
	}
	
	public String listarTutores() {
		return Facade.sistema.listarTutores();
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		Facade.sistema.cadastrarHorario(email, horario, dia); 
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		Facade.sistema.cadastrarLocalDeAtendimento(email, local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return Facade.sistema.consultaHorario(email, horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return Facade.sistema.consultaLocal(email, local);
	}
}

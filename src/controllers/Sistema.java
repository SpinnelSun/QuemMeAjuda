package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Aluno;
import models.Tutor;

public class Sistema {
	
	private Map<String, Aluno> alunos;
	private Map<String, Tutor> tutores;
	private Comparator<Aluno> ordenadorAlunos;
	
	public Sistema() {
		this.alunos = new HashMap<String, Aluno>();
		this.tutores = new HashMap<String, Tutor>();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String email) {
		this.alunos.put(matricula, new Aluno(matricula, nome, codigoCurso, email));
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.alunos.put(matricula, new Aluno(matricula, nome, codigoCurso, telefone, email));
	}
	
	public String recuperaAluno(String matricula) {
		return this.alunos.get(matricula).toString();
	}
	
	private List<Aluno> ordenarAlunosPorNome() {
		List<Aluno> alunosPorNome = new ArrayList<Aluno>();
		alunosPorNome.addAll(this.alunos.values());
		alunosPorNome.sort(this.ordenadorAlunos);
		
		return alunosPorNome;
	}
	
	public String listarAlunos() {
		String listagemAlunos = "";
		for (Aluno aluno : this.ordenarAlunosPorNome()) {
			listagemAlunos += aluno.toString() + System.lineSeparator();
		}
		
		return listagemAlunos;
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return "";
	}
	
	private boolean alunoTemTelefone(String matricula) {
		return (!this.alunos.get(matricula).getTelefone().isEmpty());
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		return;
	}
	
	public String recuperaTutor(String matricula) {
		return this.tutores.get(matricula).toString();
	}
	
	public String listarTutores() {
		String listagemTutores = "";
		for (Tutor tutor : this.tutores.values()) {
			listagemTutores += tutor.toString() + System.lineSeparator();
		}
		
		return listagemTutores;
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

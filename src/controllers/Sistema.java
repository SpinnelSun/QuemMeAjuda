package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Aluno;
import models.AtributoAluno;
import models.Tutor;

public class Sistema {
	
	private Map<String, Aluno> alunos;
	private Map<String, Tutor> tutores;
	private Comparator<Aluno> ordenadorAlunos;
	
	public Sistema() {
		this.alunos = new HashMap<String, Aluno>();
		this.tutores = new HashMap<String, Tutor>();
		this.ordenadorAlunos = new AlunoPorNome();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone,
							   String email) {
		this.alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));
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
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		Tutor t = (Tutor) alunos.get(matricula);
		t.setDisciplina(disciplina);
		t.setDisciplina(disciplina);
		tutores.put(t.getEmail(), t);
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
		this.tutores.get(email).cadastrarHorario(horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		this.tutores.get(email).cadastrarLocalDeAtendimento(local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return tutores.get(email).consultaHorario(horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return tutores.get(email).consultaLocal(local);
	}

}
